import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * This interface has all the methods with which user interacts directly.
 * It takes all the desired inputs from the user
 * and based on the inputs it displays the desired outputs.
 **/
public interface View {

  /**
   * This method displays all the messages to get input from the user and also takes the user input.
   *
   * @throws IllegalArgumentException exception due to time limit.
   * @throws InterruptedException     exception when reading file.
   **/
  void getInput() throws InterruptedException;

  /**
   * This Returns the userId.
   *
   * @return one
   */
  int getUserId();


  /**
   * This returns the userName.
   *
   * @return username
   */
  String getUserName();

  /**
   * This return the emailID.
   *
   * @return emailId
   */
  String getUserEmail();


  /**
   * This method the return the PortfolioId.
   *
   * @return PortfolioId
   */
  int getPortfolioId();


  /**
   * This method the returns the option.
   *
   * @return option
   */
  int getOption();

  
  String takeDate();

  String getDate();

  /**
   * This method prints the value in the StringBuilder.
   *
   * @param sb StringBuilder
   **/
  void printOutput(StringBuilder sb);


  ArrayList<String> getTickerNumber() throws InterruptedException;


  void setInputOutput(InputStream in, PrintStream out);


  /**
   * This returns the list of ticker symbols.
   *
   * @return list
   */
  ArrayList<String> getTickerList();

  /**
   * This method prints the error messages encountered while
   * performing a specific method in the modelImpl class
   * via controller.
   *
   * @param s Error Message
   **/
  void printError(String s);

}
