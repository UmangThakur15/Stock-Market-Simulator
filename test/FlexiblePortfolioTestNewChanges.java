import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import controller.ControllerImpl;
import controller.ControllerMain;
import model.ModelImpl;
import model.ModelImplFlexible;
import model.PortfolioFlexible;
import model.PortfolioNonFlexible;
import view.View;
import view.ViewImpl;

import static org.junit.Assert.assertEquals;


/**
 * This class consists of all the test cases related to
 * Dollar cost strategy with end date and without end date and Investment.
 */
public class FlexiblePortfolioTestNewChanges {

  @Test
  public void testAddFileManualInputCorrectInput() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1900;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-11-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-08-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-09-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-10-11";

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption
        + System.lineSeparator() + option + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + date2
        + System.lineSeparator() + tickerNumber3
        + System.lineSeparator() + numberOfStocks3 + System.lineSeparator() + date3
        + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + date4 + System.lineSeparator()
        + "exit" + System.lineSeparator()
        + 5 + System.lineSeparator() + 2 + System.lineSeparator()
        + 2000.00 + System.lineSeparator() + "2022-11-10" + System.lineSeparator()
        + "2022-11-20" + System.lineSeparator()
        + "NFLX" + System.lineSeparator() + 60 + System.lineSeparator()
        + "MSFT" + System.lineSeparator() + 40 + System.lineSeparator() + "exit"
        + System.lineSeparator() + 1
        + System.lineSeparator()
        + 0 + System.lineSeparator();

    String expectedResult = "Welcome!" + System.lineSeparator()
        + "Please enter your user id" + System.lineSeparator()
        + "Please enter your user name" + System.lineSeparator()
        + "Please enter your user email id" + System.lineSeparator()
        + "Please enter the portfolio Id" + System.lineSeparator()
        + "Please choose the type of stock" + System.lineSeparator()
        + "1. For Flexible" + System.lineSeparator()
        + "2. For non Flexible" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "1: To Add a new Portfolio manually" + System.lineSeparator()
        + "2: To Add a new Portfolio using a file" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
        + "1: For uploading stocks one by one" + System.lineSeparator()
        + "2: For uploading stocks by dollar cost averaging method" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For uploading stocks one by one" + System.lineSeparator()
        + "2: For uploading stocks by dollar cost averaging method" + System.lineSeparator()
        + "3: For uploading stocks by specifying weight" + System.lineSeparator()
        + "Please enter the amount you want to invest" + System.lineSeparator()
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter end date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter n if you have no end date" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the frequency after which you want"
        + "ot invest in portfolio in days" + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Program closed";
    input = new ByteArrayInputStream(inputString.getBytes());
    OutputStream outStream = new ByteArrayOutputStream();
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    View v = new ViewImpl(new PrintStream(outStream));
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedResult.trim(), outStream.toString().trim());
  }


  @Test
  public void testCostBasisAfterCreationUpdate() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1901;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-11-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-08-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-09-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-10-11";

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption
        + System.lineSeparator() + option + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + date2
        + System.lineSeparator() + tickerNumber3
        + System.lineSeparator() + numberOfStocks3 + System.lineSeparator() + date3
        + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + date4 + System.lineSeparator()
        + "exit" + System.lineSeparator() + 7 + System.lineSeparator() + 1
        + System.lineSeparator() + "2022-11-11"
        + System.lineSeparator() + 20.5 + System.lineSeparator()
        + 5 + System.lineSeparator() + 2 + System.lineSeparator()
        + 2000.00 + System.lineSeparator() + "2022-11-10" + System.lineSeparator()
        + "2022-11-20" + System.lineSeparator()
        + "NFLX" + System.lineSeparator() + 60 + System.lineSeparator()
        + "MSFT" + System.lineSeparator() + 40 + System.lineSeparator() + "exit"
        + System.lineSeparator() + 1
        + System.lineSeparator() + 7 + System.lineSeparator() + 1
        + System.lineSeparator() + "2022-11-11"
        + System.lineSeparator() + 10.5 + System.lineSeparator()
        + 0 + System.lineSeparator();

    String expectedResult = "Welcome!" + System.lineSeparator()
        + "Please enter your user id" + System.lineSeparator()
        + "Please enter your user name" + System.lineSeparator()
        + "Please enter your user email id" + System.lineSeparator()
        + "Please enter the portfolio Id" + System.lineSeparator()
        + "Please choose the type of stock" + System.lineSeparator()
        + "1. For Flexible" + System.lineSeparator()
        + "2. For non Flexible" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "1: To Add a new Portfolio manually" + System.lineSeparator()
        + "2: To Add a new Portfolio using a file" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
        + "1: For uploading stocks one by one" + System.lineSeparator()
        + "2: For uploading stocks by dollar cost averaging method" + System.lineSeparator()
        + "Please enter the amount you want to invest" + System.lineSeparator()
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter end date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter n if you have no end date" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the frequency after which you want ot invest"
        + " in portfolio in days"
        + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For getting cost basis with commission fees" + System.lineSeparator()
        + "2: For getting cost basis without commission fees" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the commission fee" + System.lineSeparator()
        + "Commission fee should be greater than 0" + System.lineSeparator()
        + "$10410.300000000003" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For uploading stocks one by one" + System.lineSeparator()
        + "2: For uploading stocks by dollar cost averaging method" + System.lineSeparator()
        + "3: For uploading stocks by specifying weight" + System.lineSeparator()
        + "Please enter the amount you want to invest" + System.lineSeparator()
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter end date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter n if you have no end date" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the frequency after which you want ot invest in portfolio in days"
        + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For getting cost basis with commission fees" + System.lineSeparator()
        + "2: For getting cost basis without commission fees" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the commission fee" + System.lineSeparator()
        + "Commission fee should be greater than 0" + System.lineSeparator()
        + "$14252.300000000003" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Program closed";
    input = new ByteArrayInputStream(inputString.getBytes());
    OutputStream outStream = new ByteArrayOutputStream();
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    View v = new ViewImpl(new PrintStream(outStream));
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedResult.trim(), outStream.toString().trim());
  }


  @Test
  public void testCostBasisPortCreatedThroughDollarCostAverage() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1905;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-11-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-08-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-09-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-10-11";

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption
        + System.lineSeparator() + option + System.lineSeparator() + 2
        + System.lineSeparator() + 2000.05
        + System.lineSeparator() + "2022-11-01"
        + System.lineSeparator() + "2022-11-15"
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + tickerNumber3
        + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + "exit"
        + System.lineSeparator() + 2
        + System.lineSeparator() + 7 + System.lineSeparator() + 1
        + System.lineSeparator() + "2022-11-11"
        + System.lineSeparator() + 20.5 + System.lineSeparator()
        + 0 + System.lineSeparator();

    String expectedResult = "Welcome!" + System.lineSeparator()
        + "Please enter your user id" + System.lineSeparator()
        + "Please enter your user name" + System.lineSeparator()
        + "Please enter your user email id" + System.lineSeparator()
        + "Please enter the portfolio Id" + System.lineSeparator()
        + "Please choose the type of stock" + System.lineSeparator()
        + "1. For Flexible" + System.lineSeparator()
        + "2. For non Flexible" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "1: To Add a new Portfolio manually" + System.lineSeparator()
        + "2: To Add a new Portfolio using a file" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
        + "1: For uploading stocks one by one" + System.lineSeparator()
        + "2: For uploading stocks by dollar cost averaging method" + System.lineSeparator()
        + "Please enter the amount you want to invest" + System.lineSeparator()
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter end date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter n if you have no end date" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the frequency after which you want ot invest in portfolio in days"
        + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For getting cost basis with commission fees" + System.lineSeparator()
        + "2: For getting cost basis without commission fees" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the commission fee" + System.lineSeparator()
        + "Commission fee should be greater than 0" + System.lineSeparator()
        + "$10410.300000000003" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Program closed";
    input = new ByteArrayInputStream(inputString.getBytes());
    OutputStream outStream = new ByteArrayOutputStream();
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    View v = new ViewImpl(new PrintStream(outStream));
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedResult.trim(), outStream.toString().trim());
  }

  @Test
  public void testCostBasisAfterCreationUpdateOnDifferentDates() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1902;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-11-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-08-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-09-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-10-11";

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption
        + System.lineSeparator() + option + System.lineSeparator() + 2
        + System.lineSeparator() + 2000.05
        + System.lineSeparator() + "2022-11-01"
        + System.lineSeparator() + "2022-11-15"
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + tickerNumber3
        + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + "exit" + System.lineSeparator() + 2
        + System.lineSeparator() + 7 + System.lineSeparator() + 1
        + System.lineSeparator() + "2022-11-11"
        + System.lineSeparator() + 20.5 + System.lineSeparator()
        + 5 + System.lineSeparator() + 3 + System.lineSeparator()
        + 2000.00 + System.lineSeparator() + "2022-11-10" + System.lineSeparator()
        + "NFLX" + System.lineSeparator() + 60 + System.lineSeparator()
        + "MSFT" + System.lineSeparator() + 40 + System.lineSeparator() + "exit"
        + System.lineSeparator() + 7 + System.lineSeparator() + 1
        + System.lineSeparator() + "2022-11-11"
        + System.lineSeparator() + 10.5 + System.lineSeparator()
        + System.lineSeparator() + 7 + System.lineSeparator() + 1
        + System.lineSeparator() + "2022-11-15"
        + System.lineSeparator() + 10.5 + System.lineSeparator()
        + System.lineSeparator() + 7 + System.lineSeparator() + 1
        + System.lineSeparator() + "2022-11-16"
        + System.lineSeparator() + 10.5 + System.lineSeparator()
        + System.lineSeparator() + 7 + System.lineSeparator() + 1
        + System.lineSeparator() + "2022-10-30"
        + System.lineSeparator() + 10.5 + System.lineSeparator()
        + System.lineSeparator() + 7 + System.lineSeparator() + 1
        + System.lineSeparator() + "2022-11-02"
        + System.lineSeparator() + 10.5 + System.lineSeparator()
        + 0 + System.lineSeparator();


    String expectedResult = "Welcome!" + System.lineSeparator()
        + "Please enter your user id" + System.lineSeparator()
        + "Please enter your user name" + System.lineSeparator()
        + "Please enter your user email id" + System.lineSeparator()
        + "Please enter the portfolio Id" + System.lineSeparator()
        + "Please choose the type of stock" + System.lineSeparator()
        + "1. For Flexible" + System.lineSeparator()
        + "2. For non Flexible" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "1: To Add a new Portfolio manually" + System.lineSeparator()
        + "2: To Add a new Portfolio using a file" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
        + "1: For uploading stocks one by one" + System.lineSeparator()
        + "2: For uploading stocks by dollar cost averaging method" + System.lineSeparator()
        + "Please enter the amount you want to invest" + System.lineSeparator()
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter end date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter n if you have no end date" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the frequency after which you want ot invest in portfolio in days"
        + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For getting cost basis with commission fees" + System.lineSeparator()
        + "2: For getting cost basis without commission fees" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the commission fee" + System.lineSeparator()
        + "Commission fee should be greater than 0" + System.lineSeparator()
        + "$10410.300000000003" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For uploading stocks one by one" + System.lineSeparator()
        + "2: For uploading stocks by dollar cost averaging method" + System.lineSeparator()
        + "3: For uploading stocks by specifying weight" + System.lineSeparator()
        + "Please enter the amount you want to invest" + System.lineSeparator()
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For getting cost basis with commission fees" + System.lineSeparator()
        + "2: For getting cost basis without commission fees" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the commission fee" + System.lineSeparator()
        + "Commission fee should be greater than 0" + System.lineSeparator()
        + "$12231.300000000003" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For getting cost basis with commission fees" + System.lineSeparator()
        + "2: For getting cost basis without commission fees" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the commission fee" + System.lineSeparator()
        + "Commission fee should be greater than 0" + System.lineSeparator()
        + "$14273.360000000004" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For getting cost basis with commission fees" + System.lineSeparator()
        + "2: For getting cost basis without commission fees" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the commission fee" + System.lineSeparator()
        + "Commission fee should be greater than 0" + System.lineSeparator()
        + "$14273.360000000004" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For getting cost basis with commission fees" + System.lineSeparator()
        + "2: For getting cost basis without commission fees" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the commission fee" + System.lineSeparator()
        + "Commission fee should be greater than 0" + System.lineSeparator()
        + "$0.0" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For getting cost basis with commission fees" + System.lineSeparator()
        + "2: For getting cost basis without commission fees" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the commission fee" + System.lineSeparator()
        + "Commission fee should be greater than 0" + System.lineSeparator()
        + "$2042.06" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Program closed";
    input = new ByteArrayInputStream(inputString.getBytes());
    OutputStream outStream = new ByteArrayOutputStream();
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    View v = new ViewImpl(new PrintStream(outStream));
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedResult.trim(), outStream.toString().trim());
  }


  @Test
  public void testPortValInvestmentDollarCostAverage() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1910;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-11-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-08-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-09-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-10-11";

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption
        + System.lineSeparator() + option + System.lineSeparator() + 2
        + System.lineSeparator() + 2000.05
        + System.lineSeparator() + "2022-11-01"
        + System.lineSeparator() + "2022-11-15"
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + tickerNumber3
        + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + "exit" + System.lineSeparator() + 2
        + System.lineSeparator() + 7 + System.lineSeparator() + 1
        + System.lineSeparator() + "2022-11-11"
        + System.lineSeparator() + 20.5 + System.lineSeparator()
        + 5 + System.lineSeparator() + 3 + System.lineSeparator()
        + 2000.00 + System.lineSeparator() + "2022-11-10" + System.lineSeparator()
        + "NFLX" + System.lineSeparator() + 60 + System.lineSeparator()
        + "MSFT" + System.lineSeparator() + 40 + System.lineSeparator() + "exit"
        + System.lineSeparator() + 7 + System.lineSeparator() + 1
        + System.lineSeparator() + "2022-11-15" + System.lineSeparator() + 20.5
        + System.lineSeparator()
        + 5 + System.lineSeparator() + 3 + System.lineSeparator()
        + 4000.00 + System.lineSeparator() + "2022-11-05" + System.lineSeparator()
        + "AMZN" + System.lineSeparator() + 60 + System.lineSeparator()
        + "GOOG" + System.lineSeparator() + 40 + System.lineSeparator() + "exit"
        + System.lineSeparator()
        + 5 + System.lineSeparator() + 3 + System.lineSeparator()
        + 4000.00 + System.lineSeparator() + "2022-11-15" + System.lineSeparator()
        + "AMZN" + System.lineSeparator() + 60 + System.lineSeparator()
        + "GOOG" + System.lineSeparator() + 40 + System.lineSeparator() + "exit"
        + System.lineSeparator() + 7 + System.lineSeparator() + 1
        + System.lineSeparator() + "2022-11-15"
        + System.lineSeparator() + 20.5
        + System.lineSeparator() + 4 + System.lineSeparator() + "2022-11-10"
        + System.lineSeparator() + 4 + System.lineSeparator() + "2022-10-28"
        + System.lineSeparator() + 4 + System.lineSeparator() + "2022-11-02"
        + System.lineSeparator() + 4 + System.lineSeparator() + "2022-11-12"
        + System.lineSeparator() + 4 + System.lineSeparator() + "2022-11-15"
        + System.lineSeparator() + 4 + System.lineSeparator() + "2022-11-16"
        + System.lineSeparator()
        + 0 + System.lineSeparator();


    String expectedResult = "Welcome!" + System.lineSeparator()
        + "Please enter your user id" + System.lineSeparator()
        + "Please enter your user name" + System.lineSeparator()
        + "Please enter your user email id" + System.lineSeparator()
        + "Please enter the portfolio Id" + System.lineSeparator()
        + "Please choose the type of stock" + System.lineSeparator()
        + "1. For Flexible" + System.lineSeparator()
        + "2. For non Flexible" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "1: To Add a new Portfolio manually" + System.lineSeparator()
        + "2: To Add a new Portfolio using a file" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
        + "1: For uploading stocks one by one" + System.lineSeparator()
        + "2: For uploading stocks by dollar cost averaging method" + System.lineSeparator()
        + "Please enter the amount you want to invest" + System.lineSeparator()
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter end date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter n if you have no end date" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the frequency after which you want ot invest in portfolio in days"
        + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For getting cost basis with commission fees" + System.lineSeparator()
        + "2: For getting cost basis without commission fees" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the commission fee" + System.lineSeparator()
        + "Commission fee should be greater than 0" + System.lineSeparator()
        + "$10410.300000000003" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For uploading stocks one by one" + System.lineSeparator()
        + "2: For uploading stocks by dollar cost averaging method" + System.lineSeparator()
        + "3: For uploading stocks by specifying weight" + System.lineSeparator()
        + "Please enter the amount you want to invest" + System.lineSeparator()
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For getting cost basis with commission fees" + System.lineSeparator()
        + "2: For getting cost basis without commission fees" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the commission fee" + System.lineSeparator()
        + "Commission fee should be greater than 0" + System.lineSeparator()
        + "$14533.360000000004" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For uploading stocks one by one" + System.lineSeparator()
        + "2: For uploading stocks by dollar cost averaging method" + System.lineSeparator()
        + "3: For uploading stocks by specifying weight" + System.lineSeparator()
        + "Please enter the amount you want to invest" + System.lineSeparator()
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For uploading stocks one by one" + System.lineSeparator()
        + "2: For uploading stocks by dollar cost averaging method" + System.lineSeparator()
        + "3: For uploading stocks by specifying weight" + System.lineSeparator()
        + "Please enter the amount you want to invest" + System.lineSeparator()
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Enter weightage of each stock" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "1: For getting cost basis with commission fees" + System.lineSeparator()
        + "2: For getting cost basis without commission fees" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the commission fee" + System.lineSeparator()
        + "Commission fee should be greater than 0" + System.lineSeparator()
        + "$22615.360000000004" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$14499.311600000003" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$0.0" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$1903.5048" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$17020.243600000005" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$23027.3547" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$22675.5743" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Program closed";
    input = new ByteArrayInputStream(inputString.getBytes());
    OutputStream outStream = new ByteArrayOutputStream();
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    View v = new ViewImpl(new PrintStream(outStream));
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedResult.trim(), outStream.toString().trim());
  }


}
