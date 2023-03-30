package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * This Class implements all the methods mentioned in the PortfolioFlexible interface
 * and methods in AbstractPortfolio class,
 * it performs operations required to create
 * a portfolio ,calculate the value of the portfolio, review the saved
 * portfolio, show the composition of particular
 * portfolio, purchasing the stocks in the existing portfolio,
 * sell the stocks, calculate cost basis and performance
 * of the portfolio based on the user inputs and result
 * is sent back to view via controller without any direct interaction between view and model.
 **/

public class ModelImplFlexible
    extends AbstractPortfolio
    implements PortfolioFlexible {


  @Override
  public StringBuilder createPortfolioDollarAverageLogicWithEndDate(int userId,
                                                                    String userName,
                                                                    String userEmail,
                                                                    int portfolioId,
                                                                    ArrayList<String>
                                                                        tickerList,
                                                                    Double amount,
                                                                    int days,
                                                                    String startDate,
                                                                    String endDate)
      throws ParseException, IOException {

    ILoadData ld = new LoadData();
    Map<String, Double> map = new HashMap<String, Double>();
    for (int i = 0; i < tickerList.size() - 1; i = i + 2) {
      map.put(tickerList.get(i), ((Double.valueOf(tickerList.get(i + 1)) / 100) * amount));
    }
    LocalDate start;
    LocalDate end;
    try {
      start = stringDateToLocalDate(startDate, "yyyy-MM-dd");
      if (start.compareTo(LocalDate.now()) > 0) {
        throw new IllegalArgumentException("Start date cannot be greater than today");
      }
    } catch (DateTimeParseException e) {
      return new StringBuilder("Invalid input date");
    }
    try {
      if (!endDate.equals("n")) {
        end = stringDateToLocalDate(endDate, "yyyy-MM-dd");
        if (end.compareTo(LocalDate.now()) > 0) {
          throw new IllegalArgumentException("End date cannot be greater than today");
        }
      } else {
        end = LocalDate.now();
      }
    } catch (DateTimeParseException e) {
      return new StringBuilder("Invalid end date");
    }
    if (start.compareTo(end) > 0) {
      throw new IllegalArgumentException("Start date cannot be greater than 0");
    }
    start = checkForDayAdd(start);
    end = checkForDayAdd(end);

    while (start.compareTo(end) <= 0) {
      String date = start.toString();
      for (Map.Entry<String, Double> set :
          map.entrySet()) {
        Double close = getClosingValueOnSpecificDate(set.getKey(), date);

        if (Double.compare(close, -100.00) == 0) {
          HashMap<LocalDate, Double> map1 = holiday(set.getKey(), start);
          LocalDate key = map1.entrySet().stream().findFirst().get().getKey();
          close = map1.entrySet().stream().findFirst().get().getValue();
          start = key;
          date = key.toString();
        }

        Double numberOfStocks = set.getValue() / close;
        Double totalAmount = close * numberOfStocks;
        close = Math.round(close * 100.0) / 100.0;
        numberOfStocks = Math.round(numberOfStocks * 100.0) / 100.0;
        totalAmount = Math.round(totalAmount * 100.0) / 100.0;
        ld.loadData(userId, userName, userEmail, portfolioId,
            date, set.getKey(),
            numberOfStocks, close, totalAmount);
      }
      start = start.plusDays(days);
      start = checkForDayAdd(start);
    }
    return new StringBuilder("Portfolio created successfully");
  }

  @Override
  public StringBuilder createPortfolioInvestment(int userId,
                                                 String userName, String userEmail,
                                                 int portfolioId, ArrayList<String> tickerList,
                                                 Double amount,
                                                 String startDate)
      throws ParseException, IOException {

    Map<String, Double> map = new HashMap<String, Double>();
    Double sum = 0.00;
    ILoadData ld = new LoadData();
    for (int i = 0; i < tickerList.size() - 1; i = i + 2) {

      map.put(tickerList.get(i), ((Double.valueOf(tickerList.get(i + 1)) / 100) * amount));
      sum += Double.valueOf(tickerList.get(i + 1));
    }
    if (sum.compareTo(100.0) != 0) {
      throw new IllegalArgumentException("Weightage is not equal to zero");
    }
    LocalDate start;
    try {
      start = stringDateToLocalDate(startDate, "yyyy-MM-dd");
      if (start.compareTo(LocalDate.now()) > 0) {
        throw new IllegalArgumentException("Start date cannot be greater than today");
      }
    } catch (DateTimeParseException e) {
      return new StringBuilder("Invalid input date");
    }


    try {
      start = stringDateToLocalDate(startDate, "yyyy-MM-dd");
      if (start.compareTo(LocalDate.now()) > 0) {
        throw new IllegalArgumentException("Date cannot be greater than today");
      }
    } catch (DateTimeParseException e) {
      return new StringBuilder("Invalid end date");
    }

    start = checkForDayAdd(start);


    String date = start.toString();
    for (Map.Entry<String, Double> set :
        map.entrySet()) {
      Double close = getClosingValueOnSpecificDate(set.getKey(), date);

      if (Double.compare(close, -100.00) == 0) {
        HashMap<LocalDate, Double> map1 = holiday(set.getKey(), start);
        LocalDate key = map1.entrySet().stream().findFirst().get().getKey();
        close = map1.entrySet().stream().findFirst().get().getValue();
        start = key;
        date = key.toString();
      }

      Double numberOfStocks = set.getValue() / close;
      Double totalAmount = close * numberOfStocks;
      close = Math.round(close * 100.0) / 100.0;
      numberOfStocks = Math.round(numberOfStocks * 100.0) / 100.0;
      totalAmount = Math.round(totalAmount * 100.0) / 100.0;
      ld.loadData(userId, userName, userEmail, portfolioId,
          date, set.getKey(),
          numberOfStocks, close, totalAmount);
    }

    return new StringBuilder("Portfolio created successfully");
  }

  @Override
  public StringBuilder getComposition(int userId, String userName, String userEmail,
                                      int portfolioId, String date) throws IOException {

    boolean portIdCheck = portfolioExists(portfolioId);
    if (!portIdCheck) {
      throw new IllegalArgumentException("Portfolio does not exist");
    }
    String fileName = "portfolio_data_" + portfolioId + ".csv";
    BufferedReader br = null;
    String line = "";
    StringBuilder sb = new StringBuilder();
    LocalDate inputDate;
    try {
      inputDate = stringDateToLocalDate(date, "yyyy-MM-dd");
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Invalid Date format");
    }
    if (inputDate.compareTo(LocalDate.now()) > 0) {
      throw new IllegalArgumentException("future date not possible");
    }
    br = new BufferedReader(new FileReader(fileName));
    String headerLine = br.readLine();
    while ((line = br.readLine()) != null) {
      String[] tickerNumbers = line.split(",");
      LocalDate portDate;
      if (tickerNumbers[4].contains("/")) {
        portDate = stringDateToLocalDate(tickerNumbers[4], "M/d/yy");
      } else {
        portDate = stringDateToLocalDate(tickerNumbers[4], "yyyy-MM-dd");
      }
      String date1 = portDate.toString();
      int check = portDate.compareTo(inputDate);
      if (check <= 0 && Double.valueOf(tickerNumbers[6]) > 0) {
        sb.append(tickerNumbers[0] + " ");
        sb.append(tickerNumbers[1] + " ");
        sb.append(tickerNumbers[2] + " ");
        sb.append(tickerNumbers[3] + " ");
        sb.append(date1 + " ");
        sb.append(tickerNumbers[5] + " ");
        sb.append(tickerNumbers[6] + " ");
        sb.append(System.lineSeparator());
      }
    }
    sb.insert(0, System.lineSeparator());
    sb.insert(0, "UId UName UEId PortId Date Ticker NumStocks");
    return sb;
  }


  @Override
  public StringBuilder modifyPortfolioByAdding(int userId,
                                               String userName, String userEmail,
                                               int portfolioId, ArrayList<String> tickerNumData)
      throws ParseException, IOException {
    boolean portIdCheck = portfolioExists(portfolioId);
    if (!portIdCheck) {
      throw new IllegalArgumentException("Portfolio id does not exist");
    }
    ILoadData ld = new LoadData();
    for (int i = 0; i < tickerNumData.size() - 2; i = i + 3) {
      String tickerNum = tickerNumData.get(i);
      int numberOfStocks = Integer.parseInt(tickerNumData.get(i + 1));
      LocalDate inputDate;
      try {
        if (tickerNumData.get(i + 2).contains("/")) {
          inputDate = stringDateToLocalDate(tickerNumData.get(i + 2), "M/d/yy");
        } else {
          inputDate = stringDateToLocalDate(tickerNumData.get(i + 2), "yyyy-MM-dd");
        }
      } catch (DateTimeParseException e) {
        throw new IllegalArgumentException("Invalid date");
      }

      inputDate = checkForDay(inputDate);
      if (inputDate.compareTo(LocalDate.now()) > 0) {
        throw new IllegalArgumentException("future date not possible");
      }
      String date = inputDate.toString();
      Double close = getClosingValueOnSpecificDate(tickerNum, date);

      if (Double.compare(close, -100.00) == 0) {
        HashMap<LocalDate, Double> map = holiday(tickerNum, inputDate);
        LocalDate key = map.entrySet().stream().findFirst().get().getKey();
        close = map.entrySet().stream().findFirst().get().getValue();
        date = key.toString();
      }

      ld.loadData(userId, userName, userEmail, portfolioId,
          date, tickerNum,
          (double) numberOfStocks, close, numberOfStocks * close);
    }
    return new StringBuilder("Portfolio updated successfully");
  }

  @Override
  public StringBuilder sellStocks(int userId,
                                  String userName, String userEmail,
                                  int portfolioId, String ticker, int numOfStocks, String date)
      throws IOException, ParseException {
    boolean portIdCheck = portfolioExists(portfolioId);
    if (!portIdCheck) {
      throw new IllegalArgumentException("Portfolio id does not exist");
    }
    String fileName = "portfolio_data_" + portfolioId + ".csv";
    BufferedReader br = null;
    String line = "";
    int toContinue = 1;
    ArrayList<String> sb = new ArrayList<String>();
    HashMap<String, Double> map = new HashMap<>();
    ILoadData ld = new LoadData();
    LocalDate inputDate;
    try {
      inputDate = LocalDate.parse(date);
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Invalid date");
    }
    inputDate = checkForDay(inputDate);
    if (inputDate.compareTo(LocalDate.now()) > 0) {
      throw new IllegalArgumentException("future date not possible");
    }
    br = new BufferedReader(new FileReader(fileName));
    String headerLine = br.readLine();
    while ((line = br.readLine()) != null) {
      String[] tickerNumbers = line.split(",");
      LocalDate portDate;

      if (tickerNumbers[4].contains("/")) {
        portDate = stringDateToLocalDate(tickerNumbers[4], "M/d/yy");
      } else {
        portDate = stringDateToLocalDate(tickerNumbers[4], "yyyy-MM-dd");
      }
      int check = portDate.compareTo(inputDate);
      if (check <= 0) {
        if (map.containsKey(tickerNumbers[5])) {
          map.replace(tickerNumbers[5], map.get(tickerNumbers[5])
              + Double.valueOf(tickerNumbers[6]));
        } else {
          map.put(tickerNumbers[5], Double.valueOf(tickerNumbers[6]));
        }
      }
    }

    if (!map.containsKey(ticker)) {
      throw new IllegalArgumentException("Ticker Number does not exist in the given portfolio");
    }

    if (map.get(ticker) < numOfStocks) {
      throw new IllegalArgumentException("The mentioned number of "
          + "stocks to be sold is greater than the stocks available in the portfolio");
    }

    String todayDate = inputDate.toString();
    double close = getClosingValueOnSpecificDate(ticker, todayDate);

    if (Double.compare(close, -100.00) == 0) {
      HashMap<LocalDate, Double> map1 = holiday(ticker, inputDate);
      LocalDate key = map1.entrySet().stream().findFirst().get().getKey();
      close = map1.entrySet().stream().findFirst().get().getValue();
      todayDate = key.toString();
    }

    ld.loadData(userId, userName, userEmail, portfolioId,
        todayDate, ticker,
        -(double) numOfStocks, -close, -(close * numOfStocks) + 1);

    return new StringBuilder("Portfolio sold successfully updated");
  }


  @Override
  public StringBuilder getCostBasis(int userId,
                                    String userName,
                                    String userEmail,
                                    int portfolioId, String date, Double commissionFee)
      throws IOException, ParseException {
    boolean portIdCheck = portfolioExists(portfolioId);
    if (!portIdCheck) {
      throw new IllegalArgumentException("Portfolio id does not exist");
    }
    String fileName = "portfolio_data_" + portfolioId + ".csv";
    BufferedReader br = null;
    String line = "";
    double valueOfPortfolio = Double.valueOf(0);
    ArrayList<String> sb = new ArrayList<String>();
    HashMap<String, Integer> map = new HashMap<>();
    br = new BufferedReader(new FileReader(fileName));
    String headerLine = br.readLine();
    LocalDate inputDate;
    try {
      inputDate = LocalDate.parse(date);
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Invalid date");
    }
    if (inputDate.compareTo(LocalDate.now()) > 0) {
      throw new IllegalArgumentException("future date not possible");
    }
    while ((line = br.readLine()) != null) {
      String[] tickerNumbers = line.split(",");
      LocalDate portDate;
      if (tickerNumbers[4].contains("/")) {
        portDate = stringDateToLocalDate(tickerNumbers[4], "M/d/yy");
      } else {
        portDate = stringDateToLocalDate(tickerNumbers[4], "yyyy-MM-dd");
      }


      double numberOfStocks = Double.valueOf(tickerNumbers[6]);
      int checker = portDate.compareTo(inputDate);

      if (checker <= 0 && numberOfStocks > 0) {
        valueOfPortfolio = valueOfPortfolio + Double.valueOf(tickerNumbers[8]) + commissionFee;
      }
      if (checker <= 0 && numberOfStocks < 0) {
        valueOfPortfolio += commissionFee;
      }
    }
    return new StringBuilder("$" + valueOfPortfolio);
  }


  @Override
  public StringBuilder portfolioValue(int userId, String userName,
                                      String userEmail, int portfolioId, String date)
      throws IOException, InterruptedException, ParseException {
    boolean portIdCheck = portfolioExists(portfolioId);
    if (!portIdCheck) {
      throw new IllegalArgumentException("Portfolio id does not exist");
    }
    LocalDate inputDate;
    try {
      inputDate = LocalDate.parse(date);
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Invalid date");
    }

    date = checkForDay(inputDate).toString();
    inputDate = LocalDate.parse(date);
    LocalDate currDate = LocalDate.now();
    int dateCheck = inputDate.compareTo(currDate);


    if (dateCheck > 0) {
      throw new IllegalArgumentException("Date is "
          + "greater than today we cannot predict future values");
    }

    String fileName = "portfolio_data_" + portfolioId + ".csv";
    BufferedReader br = null;
    String line = "";
    int totalStocks = 0;
    double valueOfPortfolio = Double.valueOf(0);
    ArrayList<String> sb = new ArrayList<String>();
    HashMap<String, Integer> map = new HashMap<>();
    br = new BufferedReader(new FileReader(fileName));
    String headerLine = br.readLine();
    while ((line = br.readLine()) != null) {
      String[] tickerNumbers = line.split(",");
      String tickerNum = tickerNumbers[5];
      Double numberOfStocks = Double.valueOf(tickerNumbers[6]);
      LocalDate portDate;
      if (tickerNumbers[4].contains("/")) {
        portDate = stringDateToLocalDate(tickerNumbers[4], "M/d/yy");
      } else {
        portDate = stringDateToLocalDate(tickerNumbers[4], "yyyy-MM-dd");
      }

      int check = portDate.compareTo(inputDate);
      if (check <= 0 && numberOfStocks > 0) {
        Double close = getClosingValueOnSpecificDate(tickerNum, String.valueOf(inputDate));
        if (Double.compare(close, -100.00) == 0) {
          HashMap<LocalDate, Double> map1 = holiday(tickerNum, inputDate);
          LocalDate key = map1.entrySet().stream().findFirst().get().getKey();
          close = map1.entrySet().stream().findFirst().get().getValue();
          //date = key.toString();
        }
        valueOfPortfolio += numberOfStocks * close;
      }
    }

    return new StringBuilder("$" + valueOfPortfolio);
  }


  @Override
  public HashMap<LocalDate, Integer> portfolioPerformance(int userId, String userName,
                                                          String userEmail, int portfolioId,
                                                          String startDate, String endDate)
      throws ParseException, IOException, InterruptedException {

    LocalDate start;
    LocalDate end;
    try {
      start = stringDateToLocalDate(startDate, "yyyy-MM-dd");
      end = stringDateToLocalDate(endDate, "yyyy-MM-dd");
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Invalid date");
    }
    if (start.compareTo(end) > 0) {
      throw new IllegalArgumentException("Start date is greater than end date");
    }
    if (start.compareTo(end) == 0) {
      throw new IllegalArgumentException("Start date and end date are same");
    }
    if (end.compareTo(LocalDate.now()) > 0) {
      throw new IllegalArgumentException("future date not possible");
    }
    Period p = Period.between(start, end);
    long p2 = ChronoUnit.DAYS.between(start, end);
    int totalDays = (int) p2;
    int year = p.getYears();
    if (year > 30) {
      throw new IllegalArgumentException("Dates cannot be more than 30 years apart");
    }
    if (totalDays < 7) {
      throw new IllegalArgumentException("Input should have at least 5 working days");
    }

    if (totalDays >= 1825) {
      return yearPerformance(userId, userName, userEmail, portfolioId, start, end);
    } else if (totalDays >= 730 && totalDays < 1825) {
      return threeMonthPerformance(userId, userName, userEmail, portfolioId, start, end);
    } else if (totalDays >= 210 && totalDays < 730) {
      return monthPerformance(userId, userName, userEmail, portfolioId, start, end);
    } else if (totalDays >= 91 && totalDays < 210) {
      return weekPerformance(userId, userName, userEmail, portfolioId, start, end);
    } else if (totalDays > 60 && totalDays <= 90) {
      return threePerformance(userId, userName, userEmail, portfolioId, start, end);
    } else if (totalDays > 30 && totalDays <= 60) {
      return twoPerformance(userId, userName, userEmail, portfolioId, start, end);
    } else if (totalDays <= 30) {
      return dayPerformance(userId, userName, userEmail, portfolioId, start, end);
    } else {
      //return new StringBuilder("No data available");
      return null;
    }

  }


  private HashMap<LocalDate, Integer> dayPerformance(int userId, String userName,
                                                     String userEmail, int portfolioId,
                                                     LocalDate startDate, LocalDate endDate)
      throws ParseException, IOException, InterruptedException {
    HashMap<LocalDate, Integer> datePortValueTrack = new HashMap<>();
    datePortValueTrack.put(stringDateToLocalDate("1800-01-01", "yyyy-MM-dd"), 0);
    LocalDate startDate1 = startDate;
    LocalDate endDate1 = endDate;
    endDate = checkForDay(endDate);
    startDate = checkForDay(startDate);
    while (startDate.compareTo(endDate) <= 0) {
      StringBuilder sm;
      try {
        sm = portfolioValue(userId, userName, userEmail,
            portfolioId, startDate.toString());
      } catch (IllegalArgumentException e) {
        sm = new StringBuilder("$0.00");
      }
      String m = sm.substring(1, sm.length());
      int pos = m.indexOf('.');
      m = m.substring(0, pos);
      int i = Integer.valueOf(m);
      String s = String.valueOf(i);
      String result = round(s, s.length());
      datePortValueTrack.put(startDate, Integer.valueOf(result));
      startDate = startDate.plusDays(1);
      startDate = addDaysFridayCheck(startDate);
    }

    datePortValueTrack = sortMap(datePortValueTrack);
    return datePortValueTrack;
  }

  private HashMap<LocalDate, Integer> twoPerformance(int userId, String userName,
                                                     String userEmail, int portfolioId,
                                                     LocalDate startDate, LocalDate endDate)
      throws ParseException, IOException, InterruptedException {
    HashMap<LocalDate, Integer> datePortValueTrack = new HashMap<>();
    datePortValueTrack.put(stringDateToLocalDate("1800-01-01", "yyyy-MM-dd"), 0);
    LocalDate startDate1 = startDate;
    LocalDate endDate1 = endDate;

    endDate = checkForDay(endDate);
    startDate = checkForDay(startDate);

    while (startDate.compareTo(endDate) <= 0) {
      StringBuilder sm;
      try {
        sm = portfolioValue(userId, userName, userEmail,
            portfolioId, startDate.toString());
      } catch (IllegalArgumentException e) {
        sm = new StringBuilder("$0.00");
      }
      String m = sm.substring(1, sm.length());

      int pos = m.indexOf('.');
      m = m.substring(0, pos);
      int i = Integer.valueOf(m);
      String s = String.valueOf(i);
      String result = round(s, s.length());
      datePortValueTrack.put(startDate, Integer.valueOf(result));
      startDate = startDate.plusDays(2);
      startDate = addDaysFridayCheck(startDate);
    }

    datePortValueTrack = sortMap(datePortValueTrack);
    return datePortValueTrack;
  }

  private HashMap<LocalDate, Integer> threePerformance(int userId, String userName,
                                                       String userEmail, int portfolioId,
                                                       LocalDate startDate, LocalDate endDate)
      throws ParseException, IOException, InterruptedException {
    HashMap<LocalDate, Integer> datePortValueTrack = new HashMap<>();
    datePortValueTrack.put(stringDateToLocalDate("1800-01-01", "yyyy-MM-dd"), 0);
    LocalDate startDate1 = startDate;
    LocalDate endDate1 = endDate;
    endDate = checkForDay(endDate);
    startDate = checkForDay(startDate);
    while (startDate.compareTo(endDate) <= 0) {

      StringBuilder sm;
      try {
        sm = portfolioValue(userId, userName, userEmail,
            portfolioId, startDate.toString());
      } catch (IllegalArgumentException e) {
        sm = new StringBuilder("$0.00");
      }

      String m = sm.substring(1, sm.length());
      int pos = m.indexOf('.');
      m = m.substring(0, pos);
      int i = Integer.valueOf(m);
      String s = String.valueOf(i);
      String result = round(s, s.length());
      datePortValueTrack.put(startDate, Integer.valueOf(result));
      startDate = startDate.plusDays(3);
      startDate = addDaysFridayCheck(startDate);
    }

    datePortValueTrack = sortMap(datePortValueTrack);
    return datePortValueTrack;
  }

  private HashMap<LocalDate, Integer> weekPerformance(int userId, String userName,
                                                      String userEmail, int portfolioId,
                                                      LocalDate startDate, LocalDate endDate)
      throws ParseException, IOException, InterruptedException {
    HashMap<LocalDate, Integer> datePortValueTrack = new HashMap<>();
    datePortValueTrack.put(stringDateToLocalDate("1800-01-01", "yyyy-MM-dd"), 0);
    LocalDate startDate1 = startDate;
    LocalDate endDate1 = endDate;
    endDate = checkForDay(endDate);
    startDate = checkForDay(startDate);
    while (startDate.compareTo(endDate) <= 0) {

      StringBuilder sm;
      try {
        sm = portfolioValue(userId, userName, userEmail,
            portfolioId, startDate.toString());
      } catch (IllegalArgumentException e) {
        sm = new StringBuilder("$0.00");
      }
      String m = sm.substring(1, sm.length());
      int pos = m.indexOf('.');
      m = m.substring(0, pos);
      int i = Integer.valueOf(m);
      String s = String.valueOf(i);
      String result = round(s, s.length());
      datePortValueTrack.put(startDate, Integer.valueOf(result));
      startDate = startDate.plusDays(7);
      startDate = addDaysFridayCheck(startDate);
    }

    datePortValueTrack = sortMap(datePortValueTrack);
    return datePortValueTrack;
  }

  private HashMap<LocalDate, Integer> monthPerformance(int userId, String userName,
                                                       String userEmail, int portfolioId,
                                                       LocalDate startDate, LocalDate endDate)
      throws ParseException, IOException, InterruptedException {
    HashMap<LocalDate, Integer> datePortValueTrack = new HashMap<>();
    datePortValueTrack.put(stringDateToLocalDate("1800-01-01", "yyyy-MM-dd"), 1);

    LocalDate startDate1 = startDate;
    LocalDate endDate1 = endDate;

    startDate = lastDayOfMonth(startDate);

    endDate = lastDayOfMonth(endDate);
    endDate = lastDayOfMonthCheckForEndDate(endDate);


    while (startDate.compareTo(endDate) <= 0) {
      StringBuilder sm;
      try {
        sm = portfolioValue(userId, userName, userEmail,
            portfolioId, startDate.toString());
      } catch (IllegalArgumentException e) {
        sm = new StringBuilder("$0.00");
      }
      String m = sm.substring(1, sm.length());
      int pos = m.indexOf('.');
      m = m.substring(0, pos);
      int i = Integer.valueOf(m);
      String s = String.valueOf(i);
      String result = round(s, s.length());
      datePortValueTrack.put(startDate, Integer.valueOf(result));
      startDate = lastDayOfMonth(startDate.plusMonths(1));
      startDate = lastDayOfMonth(startDate);
    }

    datePortValueTrack = sortMap(datePortValueTrack);
    return datePortValueTrack;
  }

  private HashMap<LocalDate, Integer> threeMonthPerformance(int userId, String userName,
                                                            String userEmail, int portfolioId,
                                                            LocalDate startDate, LocalDate endDate)
      throws ParseException, IOException, InterruptedException {
    HashMap<LocalDate, Integer> datePortValueTrack = new HashMap<>();
    datePortValueTrack.put(stringDateToLocalDate("1800-01-01", "yyyy-MM-dd"), 1);
    LocalDate startDate1 = startDate;
    LocalDate endDate1 = endDate;

    startDate = lastDayOfMonth(startDate);
    endDate = lastDayOfMonth(endDate);
    endDate = lastDayOfMonthCheckForEndDate(endDate);

    while (startDate.compareTo(endDate) <= 0) {
      StringBuilder sm;
      try {
        sm = portfolioValue(userId, userName, userEmail,
            portfolioId, startDate.toString());
      } catch (IllegalArgumentException e) {
        sm = new StringBuilder("$0.00");
      }
      String m = sm.substring(1, sm.length());
      int pos = m.indexOf('.');
      m = m.substring(0, pos);
      int i = Integer.valueOf(m);
      String s = String.valueOf(i);
      String result = round(s, s.length());
      datePortValueTrack.put(startDate, Integer.valueOf(result));

      startDate = lastDayOfMonth(startDate.plusMonths(3));
      startDate = lastDayOfMonth(startDate);
    }


    datePortValueTrack = sortMap(datePortValueTrack);
    return datePortValueTrack;
  }

  private HashMap<LocalDate, Integer> yearPerformance(int userId, String userName,
                                                      String userEmail, int portfolioId,
                                                      LocalDate startDate, LocalDate endDate)
      throws ParseException, IOException, InterruptedException {
    HashMap<LocalDate, Integer> datePortValueTrack = new HashMap<>();
    datePortValueTrack.put(stringDateToLocalDate("1800-01-01", "yyyy-MM-dd"), 2);
    LocalDate startDate1 = startDate;
    LocalDate endDate1 = endDate;


    int yearStart = startDate.getYear();
    Month monthStart = startDate.getMonth();
    int dayStart = 10;
    LocalDate localDate = LocalDate.of(yearStart, monthStart, dayStart);
    LocalDate lastDayOfYearStart = localDate.with(TemporalAdjusters.lastDayOfYear());
    lastDayOfYearStart = checkForDay(lastDayOfYearStart);

    int yearEnd = endDate.getYear();
    Month monthEnd = endDate.getMonth();
    int dayEnd = 10;
    LocalDate localDate1 = LocalDate.of(yearEnd - 1, monthEnd, dayEnd);
    LocalDate lastDayOfYearEnd = localDate1.with(TemporalAdjusters.lastDayOfYear());
    lastDayOfYearEnd = checkForDay(lastDayOfYearEnd);
    if (lastDayOfYearEnd.compareTo(endDate) > 0) {
      lastDayOfYearEnd = lastDayOfYearEnd.minusYears(1);
      lastDayOfYearEnd = checkForDay(lastDayOfYearEnd);
    }
    while (lastDayOfYearStart.compareTo(lastDayOfYearEnd) < 0
        || lastDayOfYearStart.equals(lastDayOfYearEnd)) {
      StringBuilder sm;
      try {
        sm = portfolioValue(userId, userName, userEmail,
            portfolioId, startDate.toString());
      } catch (IllegalArgumentException e) {
        sm = new StringBuilder("$0.00");
      }
      String m = sm.substring(1, sm.length());
      int pos = m.indexOf('.');
      m = m.substring(0, pos);
      int i = Integer.valueOf(m);
      String s = String.valueOf(i);
      String result = round(s, s.length());
      datePortValueTrack.put(lastDayOfYearStart, Integer.valueOf(result));
      lastDayOfYearStart = lastDayOfMonth(lastDayOfYearStart.plusYears(1));
      lastDayOfYearStart = checkForDay(lastDayOfYearStart);


    }


    datePortValueTrack = sortMap(datePortValueTrack);

    return datePortValueTrack;
  }


  private String round(String s, int length) {
    char[] c = s.toCharArray();
    int n = length;

    if (c[n - 1] == '0') {
      return s;
    } else if (c[n - 1] == '1' || c[n - 1] == '2'
        || c[n - 1] == '3' || c[n - 1] == '4'
        || c[n - 1] == '5') {
      c[n - 1] = '0';
      return new String(c);
    } else {
      c[n - 1] = '0';
      for (int i = n - 2; i >= 0; i--) {
        if (c[i] == '9') {
          c[i] = '0';
        } else {
          int t = c[i] - '0' + 1;
          c[i] = (char) (48 + t);
          break;
        }
      }
    }
    String s1 = new String(c);
    if (s1.charAt(0) == '0') {
      s1 = "1" + s1;
    }
    return s1;
  }


}
