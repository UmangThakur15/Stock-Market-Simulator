import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This is the interface which has all the methods that
 * performs the required operations on the Portfolio based on the
 * user input and returns the output. User does not directly interact with this interface.
 */

public interface Model {

  /**
   * This method takes the userId, userName, userEmail, portfolioId,
   * list of composition of ticker symbol
   * and the number of shares as the parameters
   * to create a Portfolio of the user manually.
   *
   * @param userId        It takes userId as parameter
   * @param userName      It Takes userName as parameter
   * @param userEmail     It Takes userEmailId as parameter
   * @param portfolioId   It Takes portfolioId as parameter
   * @param tickerNumData It takes TickerNumData as parameter
   * @return Returns success or failure message
   * @throws InterruptedException exception due to time limit.
   **/
  StringBuilder addPortfolioByManualInput(int userId, String userName, String userEmail,
                                          int portfolioId, ArrayList<String> tickerNumData)
          throws InterruptedException;

  /**
   * This method takes the userId, userName, userEmail,
   * portfolioId as the parameter and the list of composition
   * of Ticker Symbol and shares is uploaded in the form of csv
   * file to create the User Portfolio.
   *
   * @param userId      It takes userId as parameter
   * @param userName    It takes userName as parameter
   * @param userEmail   It takes userEmail as parameter
   * @param portfolioId It takes portfolioId as parameter
   * @return returns success or failure message.
   * @throws IOException exception when reading file.
   **/
  StringBuilder addPortfolioByFile(int userId,
                                   String userName, String userEmail, int portfolioId)
          throws IOException;

  /**
   * This method takes userId, userName, userEmail, portfolioId as the parameter
   * to return the composition of the portfolio for the given parameters.
   *
   * @param userId      It takes userId as parameter
   * @param userName    It takes userName as parameter
   * @param userEmail   It takes userEmailId as parameter
   * @param portfolioId It takes portfolioId as parameter
   * @return Returns StringBuilder that contains the output data.
   * @throws FileNotFoundException Throws error message when file is not found.
   **/
  StringBuilder getComposition(int userId,
                               String userName, String userEmail, int portfolioId)
          throws FileNotFoundException;

  /**
   * This method takes the userId, userName, userEmail,portfolioId and date as the parameter and
   * returns the value to the particular portfolio on the given date.
   *
   * @param userId      It takes userId as parameter.
   * @param userName    It takes userName as parameter.
   * @param userEmail   It takes userEmailId as parameter.
   * @param portfolioId It takes portfolioId as parameter.
   * @param date        It takes date as parameter.
   * @return Returns final output.
   * @throws InterruptedException exception due to time limit.
   * @throws IOException          exception when reading file.
   **/
  StringBuilder portfolioValue(int userId,
                               String userName, String userEmail, int portfolioId, String date)
          throws InterruptedException, IOException;
}
