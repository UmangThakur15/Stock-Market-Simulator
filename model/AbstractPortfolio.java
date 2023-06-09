package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;

import static java.util.stream.Collectors.toMap;


/**
 * This is the abstract class for the Model that has all
 * the common methods of the ModelImplFlexible Class
 * and ModelImpl Class.
 **/

public abstract class AbstractPortfolio implements Portfolio {


  /**
   * This method takes the userId, userName, userEmail, portfolioId,
   * list of composition of ticker symbol
   * and the number of shares as the parameters
   * to create a Portfolio of the user manually.
   *
   * @param userId        Integer, It takes userId as parameter
   * @param userName      String, It Takes userName as parameter
   * @param userEmail     String, It Takes userEmailId as parameter
   * @param portfolioId   Integer, It Takes portfolioId as parameter
   * @param tickerNumData ArrayList, It takes TickerNumData as parameter
   * @return Returns success or failure message
   * @throws ParseException This error message signals that an
   *                        error has been reached unexpectedly while parsing.
   */

  public StringBuilder addPortfolioByManualInput(int userId,
                                                 String userName, String userEmail,
                                                 int portfolioId, ArrayList<String> tickerNumData)
      throws ParseException, IOException {

    for (int i = 0; i < tickerNumData.size() - 2; i = i + 3) {
      String tickerNum = tickerNumData.get(i);
      int numberOfStocks = Integer.parseInt(tickerNumData.get(i + 1));
      String date = tickerNumData.get(i + 2);
      LocalDate date1;
      try {
        date1 = LocalDate.parse(date);
      } catch (DateTimeParseException e) {
        throw new IllegalArgumentException("Invalid Date");
      }

      date1 = checkForDay(date1);
      if (date1.compareTo(LocalDate.now()) > 0) {
        throw new IllegalArgumentException("future date not possible");
      }

      String date2 = date1.toString();
      double close = getClosingValueOnSpecificDate(tickerNum, date2);

      if (Double.compare(close, -100.00) == 0) {
        HashMap<LocalDate, Double> map = holiday(tickerNum, date1);
        LocalDate key = map.entrySet().stream().findFirst().get().getKey();
        close = map.entrySet().stream().findFirst().get().getValue();
        date2 = key.toString();
      }

      ILoadData ld = new LoadData();
      ld.loadData(userId, userName, userEmail, portfolioId,
          date2, tickerNum,
          (double) numberOfStocks, close, numberOfStocks * close);
    }
    return new StringBuilder("Portfolio created successfully");
  }


  /**
   * This method takes the userId, userName, userEmail,
   * portfolioId as the parameter and creates portfolio using csv file upload.
   *
   * @param userId      Integer, It takes userId as parameter
   * @param userName    String, It takes userName as parameter
   * @param userEmail   String, It takes userEmailId as parameter
   * @param portfolioId Integer, It takes portfolioId as parameter
   * @return Returns StringBuilder that contains portfolio created message.
   * @throws IOException    exception when reading file.
   * @throws ParseException This error message signals that an error
   *                        has been reached unexpectedly while parsing.
   */

  public StringBuilder addPortfolioByFile(int userId, String userName,
                                          String userEmail, int portfolioId, String fileName)
      throws IOException, ParseException {
    ILoadData ld = new LoadData();
    boolean portIdCheck = portfolioExists(portfolioId);
    if (portIdCheck) {
      throw new IllegalArgumentException("Please enter valid portfolio id, "
          + "as currently added portfolio id already exists");
    }
    Scanner sc;
    String file;
    if (fileName.equals("")) {
      try {
        sc = new Scanner(new File("portfolio_data_to_be_loaded.csv"));
        fileName = "portfolio_data_to_be_loaded.csv";
      } catch (FileNotFoundException e) {
        return new StringBuilder("Base file not upload the data is not found on standard path");
      }
    } else {
      try {
        sc = new Scanner(new File(fileName));
      } catch (FileNotFoundException e) {
        return new StringBuilder("Base file not available at the path you mentioned");
      }
    }
    // BufferedReader br = new BufferedReader(new FileReader("portfolio_data_to_be_loaded.csv"));
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    String line;
    int count = 0;
    while ((line = br.readLine()) != null) {
      count++;
      if (count > 1) {
        String[] cols = line.split(",");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yy");
        String s;
        LocalDate inputDate;
        try {
          s = LocalDate.parse(cols[1], format).toString();
          inputDate = LocalDate.parse(s);
        } catch (Exception e) {
          throw new IllegalArgumentException("Invalid File Format");
        }

        inputDate = checkForDay(inputDate);
        if (inputDate.compareTo(LocalDate.now()) > 0) {
          throw new IllegalArgumentException("future date not possible");
        }
        String date = inputDate.toString();
        double close = getClosingValueOnSpecificDate(cols[0], date);
        if (Double.compare(close, -100.00) == 0) {
          HashMap<LocalDate, Double> map = holiday(cols[0], inputDate);
          LocalDate key = map.entrySet().stream().findFirst().get().getKey();
          close = map.entrySet().stream().findFirst().get().getValue();
          date = key.toString();
        }

        ld.loadData(userId, userName, userEmail, portfolioId,
            date, cols[0],
            Double.valueOf(cols[2]), close, close * Integer.valueOf(cols[2]));
      }
    }
    sc.close();
    return new StringBuilder("Portfolio added");
  }


  // helper
  protected boolean portfolioExists(int portfolioId) {
    String fileName = "portfolio_data_" + portfolioId + ".csv";
    File file = new File(fileName);
    return file.exists();
  }

  protected Double getClosingValueOnSpecificDate(String tickerNum, String date)
      throws ParseException, IOException {
    IApiAccessData ap = new ApiAccessData();
    String fileName = ap.apiAccessSpecificDate(tickerNum);
    BufferedReader br = null;
    String line = "";
    Double close = Double.valueOf(0);
    boolean print = false;
    StringBuilder output = new StringBuilder();
    ArrayList<String> sb = new ArrayList<String>();
    try {
      br = new BufferedReader(new FileReader(fileName));
      String headerLine = br.readLine();
      while ((line = br.readLine()) != null) {
        String[] tickerNumbers = line.split(",");
        if (tickerNumbers[0].equals(date)) {
          close = Double.parseDouble(tickerNumbers[4]);
          print = true;
          break;
        }
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    if (print) {
      return close;
    } else {
      //throw new IllegalArgumentException("Date entered is a holiday");
      return -100.00;
    }
  }

  protected HashMap<LocalDate, Double> holiday(String tickerNum,
                                               LocalDate date) throws IOException {
    HashMap<LocalDate, Double> map = new HashMap<LocalDate, Double>();
    date = date.plusDays(1);
    date = checkForDayAdd(date);
    String inputDate = date.toString();

    IApiAccessData ap = new ApiAccessData();
    String fileName = ap.apiAccessSpecificDate(tickerNum);
    BufferedReader br = null;
    String line = "";
    Double close = Double.valueOf(0);

    while (inputDate != null) {
      br = new BufferedReader(new FileReader(fileName));
      String headerLine = br.readLine();
      while ((line = br.readLine()) != null) {
        String[] tickerNumbers = line.split(",");
        if (tickerNumbers[0].equals(inputDate)) {
          close = Double.parseDouble(tickerNumbers[4]);
          map.put(date, close);
          return map;
        }
      }
      date = date.plusDays(1);
      date = checkForDayAdd(date);
      inputDate = date.toString();
    }
    return null;
  }

  protected LocalDate checkForDay(LocalDate date) {
    LocalDate today = LocalDate.now();
    DayOfWeek dayOfWeek = date.getDayOfWeek();
    if (dayOfWeek.getValue() == 6) {
      return date.minusDays(1);
    }
    if (dayOfWeek.getValue() == 7) {
      return date.minusDays(2);
    }

    if (today.compareTo(date) == 0) {
      LocalTime time = LocalTime.now();
      int hour = time.getHour();
      if (hour < 23) {
        if (dayOfWeek.getValue() == 1) {
          return date.minusDays(3);
        }

        if (dayOfWeek.getValue() >= 2 && dayOfWeek.getValue() <= 5) {
          return date.minusDays(1);
        }
      }
    }
    return date;
  }


  protected LocalDate checkForDayAdd(LocalDate date) {
    LocalDate today = LocalDate.now();
    DayOfWeek dayOfWeek = date.getDayOfWeek();
    if (dayOfWeek.getValue() == 6) {
      return date.plusDays(2);
    }
    if (dayOfWeek.getValue() == 7) {
      return date.plusDays(1);
    }

    if (today.compareTo(date) == 0) {
      LocalTime time = LocalTime.now();
      int hour = time.getHour();
      if (hour < 23) {
        if (dayOfWeek.getValue() == 1) {
          return date.minusDays(3);
        }

        if (dayOfWeek.getValue() >= 2 && dayOfWeek.getValue() <= 5) {
          return date.minusDays(1);
        }
      }
    }
    return date;
  }


  protected LocalDate addDaysFridayCheck(LocalDate date) {
    DayOfWeek dayOfWeek = date.getDayOfWeek();

    if (dayOfWeek.getValue() == 6) {
      return date.plusDays(2);
    }

    if (dayOfWeek.getValue() == 7) {
      return date.plusDays(1);
    }
    return date;
  }

  protected LocalDate monthWiseWeekend(LocalDate date) {
    DayOfWeek dayOfWeek = date.getDayOfWeek();

    if (dayOfWeek.getValue() == 6) {
      return date.minusDays(1);
    }

    if (dayOfWeek.getValue() == 7) {
      return date.minusDays(2);
    }
    return date;
  }


  protected LocalDate lastDayOfMonth(LocalDate date) {
    int year = date.getYear();
    int month = date.getMonthValue();
    int lastDayOfMonth = getNumberOfDaysInMonth(year, month);
    String end = "";
    if (month <= 9) {
      end = date.getYear() + "-" + "0" + month + "-" + lastDayOfMonth;
    } else {
      end = date.getYear() + "-" + month + "-" + lastDayOfMonth;
    }
    date = LocalDate.parse(end);
    date = monthWiseWeekend(date);
    return date;
  }

  private int getNumberOfDaysInMonth(int year, int month) {
    YearMonth yearMonthObject = YearMonth.of(year, month);
    int daysInMonth = yearMonthObject.lengthOfMonth();
    return daysInMonth;
  }

  protected LocalDate lastDayOfMonthCheckForEndDate(LocalDate date) {
    int year = date.getYear();
    int month = date.getMonthValue();

    LocalDate todayDate = LocalDate.now();

    if (month == todayDate.getMonthValue() && year == todayDate.getYear()) {
      if (month == 1) {
        year = year - 1;
        month = 12;
      } else {
        month = month - 1;
      }
    }
    int lastDayOfMonth = getNumberOfDaysInMonth(year, month);
    String end = "";
    if (month <= 9) {
      end = date.getYear() + "-" + "0" + month + "-" + lastDayOfMonth;
    } else {
      end = date.getYear() + "-" + month + "-" + lastDayOfMonth;
    }
    date = LocalDate.parse(end);
    date = monthWiseWeekend(date);
    return date;
  }


  protected LocalDate stringDateToLocalDate(String date, String formatter) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter);
    LocalDate portDate;
    try {
      portDate = LocalDate.parse(date, dateTimeFormatter);
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Invalid date");
    }
    return portDate;
  }

  protected HashMap<LocalDate, Integer> sortMap(Map<LocalDate, Integer> datePortValueTrack) {
    HashMap<LocalDate, Integer> sortedByValue = datePortValueTrack.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
            (e1, e2) -> e1, LinkedHashMap::new));
    return sortedByValue;
  }

}
