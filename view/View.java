package view;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * This interface has all the methods with which user interacts directly.
 * It takes all the desired inputs from the user
 * and based on the inputs it displays the desired outputs.
 **/
public interface View {


  /**
   * This method takes user id.
   */

  void takeUserId();

  /**
   * This method takes username.
   */


  void takeUserName();

  /**
   * This method takes user email.
   */

  void takeUserEmail();

  /**
   * This method takes portfolio id.
   */

  void takePortfolioId();

  /**
   * This method takes portfolio type.
   */

  void takePortfolioType();

  /**
   * This method shows when invalid option is chosen.
   */

  void invalidOption();

  /**
   * This method shows when program is closed.
   */

  void programClosed();

  /**
   * This method prints string.
   *
   * @param sb String that needs to be printed.
   */

  void printString(StringBuilder sb);

  /**
   * This method takes date as input.
   */

  void date();


  /**
   * This method prints the error.
   *
   * @param s String thats needs to be printed.
   */
  void printError(String s);


  /**
   * This method shows limited flexible portfolio options.
   */

  void flexiblePortLimitedOption();

  /**
   * This method shows all flexible portfolio options.
   */

  void flexiblePortAllOptions();

  /**
   * This method shows dollar cost average options.
   */

  void flexibleDollarCostAverage();

  /**
   * This method takes start date.
   */

  void startDate();

  /**
   * This method takes end date.
   */

  void endDate();

  /**
   * This method takes commission fee options.
   */

  void commissionFeeOption();

  /**
   * This method takes commission fee.
   */

  void commissionFee();

  /**
   * This method takes interval.
   */

  void takeFrequency();

  /**
   * This method takes amount to be invested.
   */

  void totalAmountToBeInvested();

  /**
   * This method take snumber of stocks.
   */

  void takeNumberOfStocks();

  /**
   * This method takes stock symbols.
   */

  void takeTickerSymbol();

  /**
   * This method shows exit.
   */

  void takeExit();

  /**
   * This method shows weight.
   */

  void takeWeightage();

  /**
   * This method shows end date.
   */

  void endDateWithEmpty();

  /**
   * This method shows options for Dollar Cost Average.
   */

  void flexibleDollarCostAverageLimited();


  /**
   * This method shows all options for non flexible portfolio.
   */

  void nonFlexiblePortAllOptions();

  /**
   * This method shows limited for non flexible portfolio.
   */

  void nonFlexiblePortLimitedOption();

  /**
   * This method print graph day wise.
   *
   * @param datePortValueTrack hashmap of dates and values.
   * @param portfolioId        portfolio id for which grah
   *                           needs to be created.
   * @param startDate          start date for graph.
   * @param endDate            end date for graph.
   */

  void printPerformanceDayWise(HashMap<LocalDate, Integer> datePortValueTrack,
                               int portfolioId, String startDate, String endDate);

  /**
   * This method print graph month wise.
   *
   * @param datePortValueTrack hashmap of dates and values.
   * @param portfolioId        portfolio id for which grah needs to be created.
   * @param startDate          start date for graph.
   * @param endDate            end date for graph.
   */


  void printPerformanceMonthWise(HashMap<LocalDate, Integer> datePortValueTrack,
                                 int portfolioId, String startDate, String endDate);

  /**
   * This method print graph year wise.
   *
   * @param datePortValueTrack hashmap of dates and values.
   * @param portfolioId        portfolio id for which grah needs to be created.
   * @param startDate          start date for graph.
   * @param endDate            end date for graph.
   */

  void printPerformanceYearWise(HashMap<LocalDate, Integer> datePortValueTrack,
                                int portfolioId, String startDate, String endDate);


}