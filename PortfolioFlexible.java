package model;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


/**
 * This is the interface which has all the methods that
 * performs the required operations on the Flexible Portfolio based on the
 * user input and returns the output. User does not directly interact with this interface.
 **/

public interface PortfolioFlexible extends Portfolio {


  /**
   * This method takes userId, userName, userEmail, portfolioId and date as input parameters
   * and returns the value of the portfolio on the specific date.
   *
   * @param userId      Integer, It takes userId as parameter
   * @param userName    String, It Takes userName as parameter
   * @param userEmail  String, It Takes userEmailId as parameter
   * @param portfolioId Integer, It Takes portfolioId as parameter
   * @param date        String, Date on which value needs to be calculated
   * @return Value of the portfolio
   * @throws IOException          This exception occurs while reading file.
   * @throws InterruptedException This exception occurs when a thread is interrupted
   *                              while it's waiting,sleeping, or otherwise occupied
   * @throws ParseException       This error message signals that an error has been
   *                              reached unexpectedly while parsing.
   */
  StringBuilder portfolioValue(int userId, String userName,
                               String userEmail, int portfolioId, String date)
      throws IOException, InterruptedException, ParseException;


  /**
   * This method takes userId, userName, userEmail, portfolioId and date as input parameters
   * and returns the composition of the Portfolio on the specific date.
   *
   * @param userId      Integer, It takes userId as parameter
   * @param userName    String, It Takes userName as parameter
   * @param userEmail   String, It Takes userEmailId as parameter
   * @param portfolioId Integer, It Takes portfolioId as parameter
   * @param date        String, Date on which composition needs to be displayed
   * @return composition of the portfolio on the specific date
   * @throws IOException This exception occurs while reading file.
   **/
  StringBuilder getComposition(int userId,
                               String userName, String userEmail, int portfolioId, String date)
      throws IOException;


  /**
   * This method takes the userId, userName, userEmail,
   * portfolioId and List of composition ticker
   * number, number of stocks and specific date as
   * input parameters and modifies the existing portfolio.
   *
   * @param userId        Integer, It takes userId as parameter
   * @param userName      String, It Takes userName as parameter
   * @param userEmail     String, It Takes userEmailId as parameter
   * @param portfolioId   Integer, It Takes portfolioId as parameter
   * @param tickerNumData ArrayList, It takes TickerNumData as parameter
   * @return StringBuilder
   * @throws InterruptedException This exception occurs
   *          when a thread is interrupted while it's waiting,
   *                              sleeping, or otherwise occupied
   * @throws ParseException       This error message signals that
   *                        an error has been reached unexpectedly while parsing.
   **/

  StringBuilder modifyPortfolioByAdding(int userId, String userName, String userEmail,
                                        int portfolioId, ArrayList<String> tickerNumData)
      throws InterruptedException, ParseException;


  /**
   * This method takes the userId, userName,
   * userEmail, portfolioId,ticker,numOfStocks and date as parameter
   * and sells the stocks based on user input.
   *
   * @param userId      Integer, It takes userId as parameter
   * @param userName    String, It Takes userName as parameter
   * @param userEmail   String, It Takes userEmailId as parameter
   * @param portfolioId Integer, It Takes portfolioId as parameter
   * @param ticker      String, It takes ticker symbol as parameter
   * @param numOfStocks Integer, It takes number of stocks
   * @param date        String, It takes the date as parameter
   * @return StringBuilder
   * @throws IOException    This exception occurs while reading file.
   * @throws ParseException This error message signals
   *          that an error has been reached unexpectedly while parsing.
   **/
  StringBuilder sellStocks(int userId,
                           String userName, String userEmail,
                           int portfolioId, String ticker, int numOfStocks, String date)
          throws IOException, ParseException;


  /**
   * This method takes the userId, userName,
   * userEmail, portfolioId and date as parameter and
   * returns the Cost basis as of specific date.
   *
   * @param userId      Integer, It takes userId as parameter
   * @param userName    String, It Takes userName as parameter
   * @param userEmail   String, It Takes userEmailId as parameter
   * @param portfolioId Integer, It Takes portfolioId as parameter
   * @param date        String, It takes the date as parameter
   * @return StringBuilder
   * @throws IOException    This exception occurs while reading file.
   * @throws ParseException This error message signals
   *          that an error has been reached unexpectedly while parsing.
   **/


  StringBuilder getCostBasis(int userId,
                             String userName,
                             String userEmail, int portfolioId, String date)
      throws IOException, ParseException;


  /**
   * This method takes the userId, userName, userEmail, portfolioId, startDate and
   * endDate as parameter and return the performance of the portfolio
   * in the given date
   * range in the form of graph.
   *
   * @param userId      Integer, It takes userId as parameter
   * @param userName    String, It Takes userName as parameter
   * @param userEmail   String, It Takes userEmailId as parameter
   * @param portfolioId Integer, It Takes portfolioId as parameter
   * @param startDate   String, It takes the start date as parameter
   * @param endDate     String, It takes the end date as parameter
   * @return StringBuilder
   * @throws ParseException       This error message signals that an error has been
   *                              reached unexpectedly while parsing.
   * @throws IOException          This exception occurs while reading file.
   * @throws InterruptedException This exception occurs when a thread is interrupted
   *                              while it's waiting,
   *                              sleeping, or otherwise occupied
   **/
  StringBuilder portfolioPerformance(int userId, String userName,
                                     String userEmail, int portfolioId,
                                     String startDate, String endDate)
      throws ParseException, IOException, InterruptedException;


}
