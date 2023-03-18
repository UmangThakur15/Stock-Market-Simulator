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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.time.format.TextStyle.SHORT;
import static java.util.Locale.US;


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
      if (check <= 0 && Integer.valueOf(tickerNumbers[6]) > 0) {
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
      throws InterruptedException, ParseException {
    ApiAccessData ap = new ApiAccessData();
    boolean portIdCheck = portfolioExists(portfolioId);
    if (!portIdCheck) {
      throw new IllegalArgumentException("Portfolio id does not exist");
    }

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
      // inputDate = checkForMonday(inputDate);
      //String date = isWeekend(inputDate).toString();
      inputDate = checkForDay(inputDate);
      if (inputDate.compareTo(LocalDate.now()) > 0) {
        throw new IllegalArgumentException("future date not possible");
      }
      String date = inputDate.toString();
      Double close = getClosingValueOnSpecificDate(tickerNum, date);
      //Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
      //date=new SimpleDateFormat("MM/dd/yy").format(date1);
      LoadData.loadData(userId, userName, userEmail, portfolioId,
          date, tickerNum,
          numberOfStocks, close, numberOfStocks * close);
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
    HashMap<String, Integer> map = new HashMap<>();
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
      //   DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yy");
      //  String dateString = tickerNumbers[4];
      //LocalDate portDate = LocalDate.parse(dateString, dateTimeFormatter);
      if (tickerNumbers[4].contains("/")) {
        portDate = stringDateToLocalDate(tickerNumbers[4], "M/d/yy");
      } else {
        portDate = stringDateToLocalDate(tickerNumbers[4], "yyyy-MM-dd");
      }
      int check = portDate.compareTo(inputDate);
      if (check <= 0) {
        if (map.containsKey(tickerNumbers[5])) {
          map.replace(tickerNumbers[5], map.get(tickerNumbers[5])
              + Integer.valueOf(tickerNumbers[6]));
        } else {
          map.put(tickerNumbers[5], Integer.valueOf(tickerNumbers[6]));
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
    //inputDate = checkForMonday(inputDate);
    // String todayDate = isWeekend(inputDate).toString();
    // inputDate = checkForDay(inputDate);
    String todayDate = inputDate.toString();
    double close = getClosingValueOnSpecificDate(ticker, todayDate);
    // Date date1=new SimpleDateFormat("yyyy-mm-dd").parse(todayDate);
    // todayDate=new SimpleDateFormat("MM/dd/yy").format(date1);
    LoadData.loadData(userId, userName, userEmail, portfolioId,
        todayDate, ticker,
        -numOfStocks, -close, -(close * numOfStocks) + 1);

    return new StringBuilder("Portfolio sold successfully updated");
  }


  @Override
  public StringBuilder getCostBasis(int userId,
                                    String userName,
                                    String userEmail, int portfolioId, String date)
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
      //LocalDate date1 = LocalDate.parse(mainDate.toString());

      int numberOfStocks = Integer.valueOf(tickerNumbers[6]);
      int checker = portDate.compareTo(inputDate);
      // System.out.println(date1+" "+mainDate);
      if (checker <= 0 && numberOfStocks > 0) {
        valueOfPortfolio = valueOfPortfolio + Double.valueOf(tickerNumbers[8]) + 1;
      }
      if (checker <= 0 && numberOfStocks < 0) {
        valueOfPortfolio += 1;
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
    //date = isWeekend(inputDate).toString();
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
      int numberOfStocks = Integer.valueOf(tickerNumbers[6]);
      LocalDate portDate;
      if (tickerNumbers[4].contains("/")) {
        portDate = stringDateToLocalDate(tickerNumbers[4], "M/d/yy");
      } else {
        portDate = stringDateToLocalDate(tickerNumbers[4], "yyyy-MM-dd");
      }
      // LocalDate mainDate=inputDate;
      int check = portDate.compareTo(inputDate);
      if (check <= 0 && numberOfStocks > 0) {
        valueOfPortfolio += numberOfStocks
            * getClosingValueOnSpecificDate(tickerNum, String.valueOf(inputDate));
      }
    }

    return new StringBuilder("$" + valueOfPortfolio);
  }


  @Override
  public StringBuilder portfolioPerformance(int userId, String userName,
                                            String userEmail, int portfolioId,
                                            String startDate, String endDate)
      throws ParseException, IOException, InterruptedException {

    //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");;
    LocalDate start;
    LocalDate end;
    try {
      start = stringDateToLocalDate(startDate, "yyyy-MM-dd");
      end = stringDateToLocalDate(endDate, "yyyy-MM-dd");
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Invalid date");
    }
    int check = start.compareTo(end);
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
    int month = p.getMonths();
    int days = p.getDays();
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
      return new StringBuilder("No data available");
    }

  }

  private StringBuilder dayPerformance(int userId, String userName,
                                       String userEmail, int portfolioId,
                                       LocalDate startDate, LocalDate endDate)
      throws ParseException, IOException, InterruptedException {
    HashMap<LocalDate, Integer> datePortValueTrack = new HashMap<>();
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

    StringBuilder sb = new StringBuilder();
    sb.append(System.lineSeparator());
    sb.append("Performance of portfolio "
        + portfolioId + " from " + startDate1 + " to " + endDate1);
    sb.append(System.lineSeparator());
    sb.append(System.lineSeparator());
    sb.append(printPerformanceDayWise(datePortValueTrack));
    return sb;
  }

  private StringBuilder twoPerformance(int userId, String userName,
                                       String userEmail, int portfolioId,
                                       LocalDate startDate, LocalDate endDate)
      throws ParseException, IOException, InterruptedException {
    HashMap<LocalDate, Integer> datePortValueTrack = new HashMap<>();
    LocalDate startDate1 = startDate;
    LocalDate endDate1 = endDate;
    //endDate = checkForMonday(endDate);
    //endDate = isWeekend(endDate);
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

    StringBuilder sb = new StringBuilder();
    sb.append(System.lineSeparator());
    sb.append("Performance of portfolio "
        + portfolioId + " from " + startDate1 + " to " + endDate1);
    sb.append(System.lineSeparator());
    sb.append(System.lineSeparator());
    sb.append(printPerformanceDayWise(datePortValueTrack));
    return sb;
  }

  private StringBuilder threePerformance(int userId, String userName,
                                         String userEmail, int portfolioId,
                                         LocalDate startDate, LocalDate endDate)
      throws ParseException, IOException, InterruptedException {
    HashMap<LocalDate, Integer> datePortValueTrack = new HashMap<>();
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

    StringBuilder sb = new StringBuilder();
    sb.append(System.lineSeparator());
    sb.append("Performance of portfolio "
        + portfolioId + " from " + startDate1 + " to " + endDate1);
    sb.append(System.lineSeparator());
    sb.append(System.lineSeparator());
    sb.append(printPerformanceDayWise(datePortValueTrack));
    return sb;
  }

  private StringBuilder weekPerformance(int userId, String userName,
                                        String userEmail, int portfolioId,
                                        LocalDate startDate, LocalDate endDate)
      throws ParseException, IOException, InterruptedException {
    HashMap<LocalDate, Integer> datePortValueTrack = new HashMap<>();
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

    StringBuilder sb = new StringBuilder();
    sb.append(System.lineSeparator());
    sb.append("Performance of portfolio "
        + portfolioId + " from " + startDate1 + " to " + endDate1);
    sb.append(System.lineSeparator());
    sb.append(System.lineSeparator());
    sb.append(printPerformanceDayWise(datePortValueTrack));
    return sb;
  }

  private StringBuilder monthPerformance(int userId, String userName,
                                         String userEmail, int portfolioId,
                                         LocalDate startDate, LocalDate endDate)
      throws ParseException, IOException, InterruptedException {
    HashMap<LocalDate, Integer> datePortValueTrack = new HashMap<>();

    LocalDate startDate1 = startDate;
    LocalDate endDate1 = endDate;

    startDate = lastDayOfMonth(startDate);

    endDate = lastDayOfMonth(endDate);
    endDate = lastDayOfMonthCheckForEndDate(endDate);


    //startDate = isWeekendPerformance(startDate);
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
      //     System.out.println(startDate+" "+endDate);
    }
    StringBuilder sb = new StringBuilder();
    sb.append(System.lineSeparator());
    sb.append("Performance of portfolio "
        + portfolioId + " from " + startDate1 + " to " + endDate1);
    sb.append(System.lineSeparator());
    sb.append(System.lineSeparator());
    sb.append(printPerformanceMonthWise(datePortValueTrack));
    return sb;
  }

  private StringBuilder threeMonthPerformance(int userId, String userName,
                                              String userEmail, int portfolioId,
                                              LocalDate startDate, LocalDate endDate)
      throws ParseException, IOException, InterruptedException {
    HashMap<LocalDate, Integer> datePortValueTrack = new HashMap<>();
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

    StringBuilder sb = new StringBuilder();
    sb.append(System.lineSeparator());
    sb.append("Performance of portfolio "
        + portfolioId + " from " + startDate1 + " to " + endDate1);
    sb.append(System.lineSeparator());
    sb.append(System.lineSeparator());
    sb.append(printPerformanceMonthWise(datePortValueTrack));
    return sb;
  }

  private StringBuilder yearPerformance(int userId, String userName,
                                        String userEmail, int portfolioId,
                                        LocalDate startDate, LocalDate endDate)
      throws ParseException, IOException, InterruptedException {
    HashMap<LocalDate, Integer> datePortValueTrack = new HashMap<>();
    LocalDate startDate1 = startDate;
    LocalDate endDate1 = endDate;

    //startDate = lastDayOfMonth(startDate);
    int yearStart = startDate.getYear();
    Month monthStart = startDate.getMonth();
    int dayStart = 10;
    LocalDate localDate = LocalDate.of(yearStart, monthStart, dayStart);
    LocalDate lastDayOfYearStart = localDate.with(TemporalAdjusters.lastDayOfYear());
    lastDayOfYearStart = checkForDay(lastDayOfYearStart);
    //  endDate = lastDayOfMonth(endDate);
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
    // System.out.println(lastDayOfYearEnd+" "+lastDayOfYearStart);
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
      //System.out.println(lastDayOfYearStart.getYear()+" mid");
      //System.out.println(lastDayOfYearEnd+" "+lastDayOfYearStart);
    }

    //for( Map.Entry<LocalDate, Integer> entry : datePortValueTrack.entrySet() ){
    //     System.out.println( entry.getKey() + " => " + entry.getValue() );
    //  }

    StringBuilder sb = new StringBuilder();
    sb.append(System.lineSeparator());
    sb.append("Performance of portfolio "
        + portfolioId + " from " + startDate1 + " to " + endDate1);
    sb.append(System.lineSeparator());
    sb.append(System.lineSeparator());
    sb.append(printPerformanceYearWise(datePortValueTrack));
    return sb;
  }


  private StringBuilder printPerformanceDayWise(HashMap<LocalDate, Integer> datePortValueTrack) {
    int minValue = Collections.min(datePortValueTrack.values());
    int maxValue = Collections.max(datePortValueTrack.values());

    Map<LocalDate, Integer> sortedMap = sortMap(datePortValueTrack);

    int base = minValue;
    int numberAsterisk = ((maxValue - minValue) / 40) + 1;
    // 1 star represents numberAsterisk
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<LocalDate, Integer> set : sortedMap.entrySet()) {

      sb.append(set.getKey() + " : ");

      int numberOfAsterisk;
      if (set.getValue() - minValue == 0 && numberAsterisk == 0) {
        numberOfAsterisk = 0;
      } else {
        numberOfAsterisk = (set.getValue() - minValue) / numberAsterisk;
      }
      for (int i = 1; i <= numberOfAsterisk; i++) {
        sb.append("*");
      }
      sb.append(System.lineSeparator());
    }
    sb.append("Relative Scale: base = $" + minValue);
    sb.append(System.lineSeparator());
    sb.append("Relative Scale: * = $" + numberAsterisk);
    sb.append(System.lineSeparator());
    return sb;
  }

  private StringBuilder printPerformanceMonthWise(HashMap<LocalDate, Integer> datePortValueTrack) {

    int minValue = Collections.min(datePortValueTrack.values());
    int maxValue = Collections.max(datePortValueTrack.values());
    int base = minValue;
    Map<LocalDate, Integer> sortedMap = sortMap(datePortValueTrack);
    // represents one star
    int numberAsterisk = ((maxValue - minValue) / 40) + 1;
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<LocalDate, Integer> set : sortedMap.entrySet()) {

      LocalDate d = set.getKey();
      Month month = d.getMonth();

      int year = d.getYear();
      int numberOfAsterisk = 0;
      sb.append(month.getDisplayName(SHORT, US) + " " + +year + " : ");
      if (set.getValue() - minValue == 0 && numberAsterisk == 0) {
        numberOfAsterisk = 0;
      } else {
        numberOfAsterisk = (set.getValue() - minValue) / numberAsterisk;
      }
      for (int i = 1; i <= numberOfAsterisk; i++) {
        sb.append("*");
      }
      sb.append(System.lineSeparator());
    }

    sb.append("Relative Scale: base = $" + minValue);
    sb.append(System.lineSeparator());
    sb.append("Relative Scale: * = $" + numberAsterisk);
    sb.append(System.lineSeparator());
    return sb;
  }


  private StringBuilder printPerformanceYearWise(HashMap<LocalDate, Integer> datePortValueTrack) {

    int minValue = Collections.min(datePortValueTrack.values());
    int maxValue = Collections.max(datePortValueTrack.values());
    int base = minValue;
    Map<LocalDate, Integer> sortedMap = sortMap(datePortValueTrack);
    int numberAsterisk = ((maxValue - minValue) / 40) + 1;
    StringBuilder sb = new StringBuilder();
    // 1 star represents numberAsterisk
    for (Map.Entry<LocalDate, Integer> set : sortedMap.entrySet()) {

      LocalDate d = set.getKey();
      Month month = d.getMonth();
      int year = d.getYear();
      int numberOfAsterisk = 0;
      sb.append(month.getDisplayName(SHORT, US) + " " + +year + " : ");
      if (set.getValue() - minValue == 0 && numberAsterisk == 0) {
        numberOfAsterisk = 0;
      } else {
        numberOfAsterisk = (set.getValue() - minValue) / numberAsterisk;
      }
      for (int i = 1; i <= numberOfAsterisk; i++) {
        sb.append("*");
      }
      sb.append(System.lineSeparator());
    }

    sb.append("Relative Scale: base = $" + minValue);
    sb.append(System.lineSeparator());
    sb.append("Relative Scale: * = $" + numberAsterisk);
    sb.append(System.lineSeparator());
    return sb;
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
