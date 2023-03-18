package model;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


/**
 * This is the interface has all the common methods that
 * are implemented by both ModelImpl class and ModelImplFlexible class to
 * perform the required operations on the Portfolio based on the
 * user input and returns the output. User does not directly interact with this interface.
 **/

public interface Portfolio {


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
   * @return StringBuilder, success or failure message
   * @throws InterruptedException This exception occurs when a thread is interrupted
   *                              while it's waiting,sleeping, or otherwise occupied
   * @throws ParseException       This error message signals that an error has been
   *                                reached unexpectedly while parsing.
   **/
  StringBuilder addPortfolioByManualInput(int userId, String userName, String userEmail,
                                          int portfolioId, ArrayList<String> tickerNumData)
      throws InterruptedException, ParseException;


  /**
   * This method takes the userId, userName, userEmail,
   * portfolioId as the parameter to create the User Portfolio using csv file.
   *
   * @param userId      Integer, It takes userId as parameter
   * @param userName    String, It Takes userName as parameter
   * @param userEmail   String, It Takes userEmailId as parameter
   * @param portfolioId Integer, It Takes portfolioId as parameter
   * @return StringBuilder, success or failure message
   * @throws IOException    exception when reading file.
   * @throws ParseException This error message signals that an
   *                        error has been reached unexpectedly while parsing.
   **/
  StringBuilder addPortfolioByFile(int userId,
                                   String userName, String userEmail, int portfolioId)
      throws IOException, ParseException;


}
