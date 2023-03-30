package model;

import java.io.IOException;
import java.text.ParseException;


/**
 * This Class implements all the methods mentioned in the Portfolio interface,
 * it performs operations required to create
 * a portfolio ,calculate the value of the portfolio, review the saved
 * portfolio and show the composition of particular
 * portfolio based on the user inputs and result
 * is sent back to view via controller without any direct
 * interaction between view and model.
 **/

public interface PortfolioNonFlexible extends Portfolio {


  /**
   * This method takes the userId, userName, userEmail, portfolioId and date
   * and returns the portfolio value on the given date.
   *
   * @param userId      Integer, It takes userId as parameter
   * @param userName    String, It Takes userName as parameter
   * @param userEmail   String, It Takes userEmailId as parameter
   * @param portfolioId Integer, It Takes portfolioId as parameter
   * @param date        String, It Takes date on which Portfolio value
   *                    needs to be calculated
   * @return StringBuilder
   * @throws InterruptedException This exception occurs when a thread is
   *                              interrupted while it's waiting,
   *                              sleeping, or otherwise occupied
   * @throws IOException          exception when reading file.
   * @throws ParseException       This error message signals that an error has been
   *                              reached unexpectedly while parsing.
   **/
  StringBuilder portfolioValue(int userId, String userName, String userEmail,
                               int portfolioId, String date)
      throws InterruptedException, IOException, ParseException;


  /**
   * This method takes the userId, userName, userEmail and portfolioId
   * as the parameter and return the Composition of the Portfolio.
   *
   * @param userId      Integer, It takes userId as parameter
   * @param userName    String, It Takes userName as parameter
   * @param userEmail   String, It Takes userEmailId as parameter
   * @param portfolioId Integer, It Takes portfolioId as parameter
   * @return StringBuilder
   * @throws IOException exception when reading file.
   **/
  StringBuilder getComposition(int userId, String userName, String userEmail,
                               int portfolioId) throws IOException;

}
