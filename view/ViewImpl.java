package view;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.time.format.TextStyle.SHORT;
import static java.util.Locale.US;
import static java.util.stream.Collectors.toMap;

/**
 * This is a concrete class which contains all the methods which are used to print the options
 * available yto be the user to proceed forward in the code.
 */

public class ViewImpl implements View {

  private final PrintStream out;

  /**
   * This initializes the print statement being used in the class.
   *
   * @param out System.out used to print options.
   */
  public ViewImpl(PrintStream out) {
    this.out = out;
  }

  @Override
  public void takeUserId() {
    this.out.println("Welcome!");
    this.out.println("Please enter your user id");
  }

  @Override
  public void takeUserName() {
    this.out.println("Please enter your user name");
  }

  @Override
  public void takeUserEmail() {
    this.out.println("Please enter your user email id");
  }

  @Override
  public void takePortfolioId() {
    this.out.println("Please enter the portfolio Id");
  }

  @Override
  public void takePortfolioType() {
    this.out.println("Please choose the type of stock");
    this.out.println("1. For Flexible");
    this.out.println("2. For non Flexible");
  }

  @Override
  public void invalidOption() {
    this.out.println("Invalid option");
  }

  @Override
  public void flexiblePortAllOptions() {
    this.out.println("Please select from below options");
    this.out.println("1: To Add a new Portfolio manually");
    this.out.println("2: To Add a new Portfolio using a file");
    this.out.println("3: To get Composition of Portfolio");
    this.out.println("4: Portfolio value on certain date");
    this.out.println("5: Purchase a stock in existing portfolio");
    this.out.println("6: Sell a stock in existing portfolio");
    this.out.println("7: Determine cost basis");
    this.out.println("8: Portfolio Performance");
    this.out.println("Press zero to exit");
  }

  @Override
  public void flexiblePortLimitedOption() {
    this.out.println("Please select from below options");
    this.out.println("3: To get Composition of Portfolio");
    this.out.println("4: Portfolio value on certain date");
    this.out.println("5: Purchase a stock in existing portfolio");
    this.out.println("6: Sell a stock in existing portfolio");
    this.out.println("7: Determine cost basis");
    this.out.println("8: Portfolio Performance");
    this.out.println("Please enter zero to exit");
  }

  @Override
  public void nonFlexiblePortAllOptions() {
    this.out.println("Please select from below options");
    this.out.println("1: To Add a new Portfolio manually");
    this.out.println("2: To Add a new Portfolio using a file");
    this.out.println("3: To get Composition of Portfolio");
    this.out.println("4: Portfolio value on certain date");
    this.out.println("Press zero to exit");
  }

  @Override
  public void nonFlexiblePortLimitedOption() {
    this.out.println("Please select from below options");
    this.out.println("3: To get Composition of Portfolio");
    this.out.println("4: Portfolio value on certain date");
    this.out.println("Press zero to exit");
  }


  @Override
  public void programClosed() {
    this.out.println("Program closed");
  }

  @Override
  public void flexibleDollarCostAverage() {
    this.out.println("1: For uploading stocks one by one");
    this.out.println("2: For uploading stocks by dollar cost averaging method");
    this.out.println("3: For uploading stocks by specifying weight");

  }

  @Override
  public void flexibleDollarCostAverageLimited() {
    this.out.println("1: For uploading stocks one by one");
    this.out.println("2: For uploading stocks by dollar cost averaging method");

  }

  @Override
  public void printString(StringBuilder sb) {
    this.out.println(sb.toString());
  }

  @Override
  public void startDate() {
    //this.out.println("Please enter start date");
    this.out.println("Please enter start date in exact same format YYYY-MM-DD");
  }

  @Override
  public void endDate() {
    //  this.out.println("Please enter end date");
    this.out.println("Please enter end date in exact same format YYYY-MM-DD");
  }

  @Override
  public void endDateWithEmpty() {
    //this.out.println("Please enter end date");
    this.out.println("Please enter end date in exact same format YYYY-MM-DD");
    this.out.println("Please enter n if you have no end date");
  }

  @Override
  public void date() {
    //this.out.println("Please enter date");
    this.out.println("Please enter date in exact same format YYYY-MM-DD");
  }

  @Override
  public void printError(String s) {
    this.out.println(s);
  }

  @Override
  public void commissionFeeOption() {
    this.out.println("1: For getting cost basis with commission fees");
    this.out.println("2: For getting cost basis without commission fees");
  }

  @Override
  public void takeFrequency() {
    this.out.println("Please enter the frequency "
        + "after which you want ot invest in portfolio in days");
  }

  @Override
  public void totalAmountToBeInvested() {
    this.out.println("Please enter the "
        + "amount you want to invest");
  }

  @Override
  public void takeTickerSymbol() {
    this.out.println("Please enter the Ticker Number");
  }

  @Override
  public void takeNumberOfStocks() {
    this.out.println("Please enter the number of stocks");
  }

  @Override
  public void takeExit() {
    this.out.println("Please enter exit if you want to exit");
  }

  @Override
  public void takeWeightage() {
    this.out.println("Enter weightage of each stock");
  }

  @Override
  public void commissionFee() {
    this.out.println("Please enter the commission fee");
    this.out.println("Commission fee should be greater than 0");
  }


  @Override
  public void printPerformanceDayWise(HashMap<LocalDate, Integer> datePortValueTrack,
                                      int portfolioId, String startDate, String endDate) {

    this.out.println();
    this.out.println("Performance of portfolio "
        + portfolioId + " from " + startDate + " to " + endDate);
    this.out.println();
    int minValue = Collections.min(datePortValueTrack.values());
    int maxValue = Collections.max(datePortValueTrack.values());

    Map<LocalDate, Integer> sortedMap = sortMap(datePortValueTrack);

    int base = minValue;
    int numberAsterisk = ((maxValue - minValue) / 40) + 1;

    //StringBuilder sb = new StringBuilder();
    for (Map.Entry<LocalDate, Integer> set : sortedMap.entrySet()) {

      //sb.append(set.getKey() + " : ");
      this.out.print(set.getKey() + " : ");

      int numberOfAsterisk;
      if (set.getValue() - minValue == 0 && numberAsterisk == 0) {
        numberOfAsterisk = 0;
      } else {
        numberOfAsterisk = (set.getValue() - minValue) / numberAsterisk;
      }
      for (int i = 1; i <= numberOfAsterisk; i++) {
        // sb.append("*");
        this.out.print("*");
      }
      //sb.append(System.lineSeparator());
      this.out.println();
    }
    // sb.append("Relative Scale: base = $" + minValue);
    //sb.append(System.lineSeparator());
    //sb.append("Relative Scale: * = $" + numberAsterisk);
    //sb.append(System.lineSeparator());

    this.out.println("Relative Scale: base = $" + minValue);
    this.out.println("Relative Scale: * = $" + numberAsterisk);
    this.out.println();
    //return sb;
  }

  @Override
  public void printPerformanceMonthWise(HashMap<LocalDate, Integer> datePortValueTrack,
                                        int portfolioId, String startDate,
                                        String endDate) {
    this.out.println();
    this.out.println("Performance of portfolio " + portfolioId + " from "
        + startDate + " to " + endDate);
    this.out.println();
    int minValue = Collections.min(datePortValueTrack.values());
    int maxValue = Collections.max(datePortValueTrack.values());
    int base = minValue;
    Map<LocalDate, Integer> sortedMap = sortMap(datePortValueTrack);

    int numberAsterisk = ((maxValue - minValue) / 40) + 1;
    //StringBuilder sb = new StringBuilder();
    for (Map.Entry<LocalDate, Integer> set : sortedMap.entrySet()) {

      LocalDate d = set.getKey();
      Month month = d.getMonth();

      int year = d.getYear();
      int numberOfAsterisk = 0;
      // sb.append(month.getDisplayName(SHORT, US) + " " + +year + " : ");
      this.out.print(month.getDisplayName(SHORT, US) + " " + year + " : ");
      if (set.getValue() - minValue == 0 && numberAsterisk == 0) {
        numberOfAsterisk = 0;
      } else {
        numberOfAsterisk = (set.getValue() - minValue) / numberAsterisk;
      }
      for (int i = 1; i <= numberOfAsterisk; i++) {
        //sb.append("*");
        this.out.print("*");
      }
      // sb.append(System.lineSeparator());
      this.out.println();
    }

    // sb.append("Relative Scale: base = $" + minValue);
    // sb.append(System.lineSeparator());
    //sb.append("Relative Scale: * = $" + numberAsterisk);
    //sb.append(System.lineSeparator());
    this.out.println("Relative Scale: base = $" + minValue);
    this.out.println("Relative Scale: * = $" + numberAsterisk);
    this.out.println();
    // return sb;
  }


  @Override
  public void printPerformanceYearWise(HashMap<LocalDate, Integer> datePortValueTrack,
                                       int portfolioId, String startDate, String endDate) {
    this.out.println();
    this.out.println("Performance of portfolio " + portfolioId
        + " from " + startDate + " to " + endDate);
    this.out.println();
    int minValue = Collections.min(datePortValueTrack.values());
    int maxValue = Collections.max(datePortValueTrack.values());
    // int base = minValue;
    Map<LocalDate, Integer> sortedMap = sortMap(datePortValueTrack);
    int numberAsterisk = ((maxValue - minValue) / 40) + 1;
    // StringBuilder sb = new StringBuilder();

    for (Map.Entry<LocalDate, Integer> set : sortedMap.entrySet()) {

      LocalDate d = set.getKey();
      Month month = d.getMonth();
      int year = d.getYear();
      int numberOfAsterisk = 0;
      // sb.append(month.getDisplayName(SHORT, US) + " " + +year + " : ");
      this.out.print(month.getDisplayName(SHORT, US) + " " + year + " : ");
      if (set.getValue() - minValue == 0 && numberAsterisk == 0) {
        numberOfAsterisk = 0;
      } else {
        numberOfAsterisk = (set.getValue() - minValue) / numberAsterisk;
      }
      for (int i = 1; i <= numberOfAsterisk; i++) {
        //sb.append("*");
        this.out.print("*");
      }
      // sb.append(System.lineSeparator());
      this.out.println();
    }

    // sb.append("Relative Scale: base = $" + minValue);
    //sb.append(System.lineSeparator());
    //sb.append("Relative Scale: * = $" + numberAsterisk);
    //sb.append(System.lineSeparator());
    this.out.println("Relative Scale: base = $" + minValue);
    this.out.println();
    this.out.println("Relative Scale: * = $" + numberAsterisk);
    this.out.println();
    //return sb;
  }

  private Map<LocalDate, Integer> sortMap(Map<LocalDate, Integer> datePortValueTrack) {
    Map<LocalDate, Integer> sortedByValue = datePortValueTrack.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
            (e1, e2) -> e1, LinkedHashMap::new));
    return sortedByValue;
  }


}