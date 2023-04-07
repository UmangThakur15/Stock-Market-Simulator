import org.junit.Test;

import controller.ControllerImpl;
import controller.ControllerMain;
import model.ModelImpl;
import model.ModelImplFlexible;
import model.PortfolioFlexible;
import model.PortfolioNonFlexible;


import view.View;
import view.ViewImpl;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * This class consists of all the tests to check the correctness of the methods in the
 * FlexiblePortfolio Class.
 **/

public class FlexiblePortfolioTest {
  @Test
  public void testAddFileManualInputCorrectInput() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1000;
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
        + "exit" + System.lineSeparator() + 0 + System.lineSeparator();

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
  public void testAddFileManualInputCorrectInput10S()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1001;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-11-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2020-11-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2021-11-11";


    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1
        + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1
        + System.lineSeparator() + tickerNumber2
        + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + date2
        + System.lineSeparator() + tickerNumber3
        + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3
        + System.lineSeparator()
        + "exit" + System.lineSeparator() + "0";

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

  /*@Test
  public void testAddFileManualInputPortfolioExists()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-11-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2020-11-11";

    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator()
        + option + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1
        + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + date2
        + System.lineSeparator() + "exit" + System.lineSeparator() + "0";

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
    + "Please enter valid portfolio id, as currently added portfolio id already exists";
    input = new ByteArrayInputStream(inputString.getBytes());
    OutputStream outStream = new ByteArrayOutputStream();
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    View v = new ViewImpl(new PrintStream(outStream));
    ControllerMain c = new ControllerImpl(input, mn, m,v);
    c.goStock();
    assertEquals(expectedResult.trim(), outStream.toString().trim());
  }*/


  @Test
  public void testAddFileManualInputCorrectInvalidTicker()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1002;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "ZZZZ";
    int numberOfStocks1 = 10;
    String date1 = "2022-11-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2020-11-11";
    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption
        + System.lineSeparator() + option + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1
        + System.lineSeparator() + date1
        + System.lineSeparator() + tickerNumber2 + System.lineSeparator()
        + numberOfStocks2
        + System.lineSeparator() + date2
        + System.lineSeparator() + "exit" + System.lineSeparator() + "0";

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
        + "Invalid ticker Number provided";
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
  public void testControllerAddDataByManualFilePortfolioExists()
      throws InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1;
    int portfolioOption = 1;
    int option = 2;

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator()
        + portfolioOption + System.lineSeparator() + option;

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
        + "Please enter valid portfolio id, as currently added portfolio id already exists";
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
  public void testControllerAddDataByManualFileNewPort()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolioOption = 1;
    int portfolio_id = 1003;
    int option = 2;

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption + System.lineSeparator() + option
        + System.lineSeparator() + "0";

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
        + "Portfolio added" + System.lineSeparator()
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
  public void testControllerAddDataByManualFileInvalidTicker()
      throws InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1004;
    int portfolioOption = 1;
    int option = 2;

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator()
        + portfolioOption + System.lineSeparator() + option
        + System.lineSeparator() + "0";

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
        + "Invalid ticker Number provided";
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
  public void testControllerGetComposition()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1;
    int portfolioOption = 1;
    int option = 3;
    String date1 = "2022-11-11";

    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption + System.lineSeparator() + option + System.lineSeparator()
        + date1 + System.lineSeparator() + "0";


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
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "UId UName UEId PortId Date Ticker NumStocks" + System.lineSeparator()
        + "1 1 1 1 2022-10-28 NFLX 10 " + System.lineSeparator()
        + "1 1 1 1 2022-11-01 MSFT 20 " + System.lineSeparator()
        + "1 1 1 1 2022-11-04 AMZN 30 " + System.lineSeparator()
        + "1 1 1 1 2022-11-10 GOOG 40 " + System.lineSeparator()
        + "1 1 1 1 2022-11-11 AMZN 50 " + System.lineSeparator()
        + "1 1 1 1 2022-11-01 TSLA 12 " + System.lineSeparator()
        + "1 1 1 1 2022-11-10 AMZN 12 " + System.lineSeparator()
        + "1 1 1 1 2022-11-04 NFLX 12 " + System.lineSeparator()
        + "" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Program closed" + System.lineSeparator();


    input = new ByteArrayInputStream(inputString.getBytes());
    OutputStream outStream = new ByteArrayOutputStream();
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    View v = new ViewImpl(new PrintStream(outStream));
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedResult, outStream.toString());
  }


  @Test
  public void testControllerGetCompositionPortDoesNotExist()
      throws InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1005;
    int option = 3;
    int portfolioOption = 1;

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption + System.lineSeparator() + option + System.lineSeparator() + "0";


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
        + "Please enter date in exact same format YYYY-MM-DD"
        + System.lineSeparator()
        + "Portfolio does not exist" + System.lineSeparator();

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
  public void testControllerGetPortfolioValue()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1;
    int option = 4;
    int portfolio_option = 1;
    String date = "2022-10-29";
    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolio_option + System.lineSeparator() + option + System.lineSeparator() + date
        + System.lineSeparator() + "0";

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
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$2957.2000000000003" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Program closed" + System.lineSeparator();

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
  public void testControllerGetPortfolioValue2()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 100000;
    int option = 4;
    int portfolio_option = 1;
    String date = "2022-10-30";
    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + option + System.lineSeparator() + portfolio_option
        + System.lineSeparator() + date + "0";

    String expectedResult = "Welcome!" + System.lineSeparator()
        + "Please enter your user id" + System.lineSeparator()
        + "Please enter your user name" + System.lineSeparator()
        + "Please enter your user email id" + System.lineSeparator()
        + "Please enter the portfolio Id" + System.lineSeparator()
        + "Please choose the type of stock" + System.lineSeparator()
        + "1. For Flexible" + System.lineSeparator()
        + "2. For non Flexible" + System.lineSeparator()
        + "Invalid option" + System.lineSeparator();
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
  public void testManualReUpload()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1006;
    int portfolioOption = 1;
    int option1 = 1;
    int option2 = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2021-11-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2020-11-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2019-11-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2020-12-31";


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option1
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1
        + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + date2
        + System.lineSeparator() + tickerNumber3
        + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4
        + System.lineSeparator() + date4 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option2 + System.lineSeparator();

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
        + "Invalid option";

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
  public void testManualUploadGetComposPortVal()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1007;
    int portfolioOption = 1;
    int option1 = 1;
    int option2 = 3;
    int option3 = 4;
    String date = "2022-11-11";
    String date1 = "2021-11-11";
    String date2 = "2022-10-31";
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String dateU1 = "2022-11-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String dateU2 = "2022-10-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String dateU3 = "2022-09-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String dateU4 = "2022-08-11";


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option1
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + dateU1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + dateU2
        + System.lineSeparator() + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + dateU3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4
        + System.lineSeparator() + dateU4 + System.lineSeparator() + "exit"
        + System.lineSeparator()
        + option2 + System.lineSeparator() + date + System.lineSeparator()
        + option3 + System.lineSeparator()
        + date1
        + System.lineSeparator() + option3 + System.lineSeparator()
        + date2 + System.lineSeparator()
        + "0" + System.lineSeparator();

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
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "UId UName UEId PortId Date Ticker NumStocks" + System.lineSeparator()
        + "10 ABC test@gmail.com 1007 2022-11-11 NFLX 10.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1007 2022-10-11 MSFT 20.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1007 2022-09-09 TSLA 30.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1007 2022-08-11 AMZN 40.0 " + System.lineSeparator()
        + "" + System.lineSeparator()
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
        + "$15566.4" + System.lineSeparator()
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
  public void testGetCompositionAndUpload() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1;
    int portfolioOption = 1;
    int option1 = 3;
    String date = "2022-11-11";
    int option2 = 1;

    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption
        + System.lineSeparator() + option1 + System.lineSeparator() + date
        + System.lineSeparator() + option2;

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
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "UId UName UEId PortId Date Ticker NumStocks" + System.lineSeparator()
        + "1 1 1 1 2022-10-28 NFLX 10 " + System.lineSeparator()
        + "1 1 1 1 2022-11-01 MSFT 20 " + System.lineSeparator()
        + "1 1 1 1 2022-11-04 AMZN 30 " + System.lineSeparator()
        + "1 1 1 1 2022-11-10 GOOG 40 " + System.lineSeparator()
        + "1 1 1 1 2022-11-11 AMZN 50 " + System.lineSeparator()
        + "1 1 1 1 2022-11-01 TSLA 12 " + System.lineSeparator()
        + "1 1 1 1 2022-11-10 AMZN 12 " + System.lineSeparator()
        + "1 1 1 1 2022-11-04 NFLX 12 " + System.lineSeparator()
        + "" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Invalid option" + System.lineSeparator();
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
  public void testPortValAndUpload() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1;
    int portfolioOption = 1;
    int option1 = 4;
    int option2 = 1;
    String date1 = "2022-11-11";


    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option1 + System.lineSeparator() + date1
        + System.lineSeparator() + option2;

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
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$26818.58" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Invalid option";
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
  public void testManualUploadGetComposition()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1008;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-01-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-02-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-03-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-04-11";
    int option1 = 3;
    String date = "2022-10-11";


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator()
        + date2 + System.lineSeparator() + tickerNumber3 + System.lineSeparator()
        + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + date4 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option1 + System.lineSeparator() + date
        + System.lineSeparator() + "0";

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
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "UId UName UEId PortId Date Ticker NumStocks" + System.lineSeparator()
        + "10 ABC test@gmail.com 1008 2022-01-11 NFLX 10.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1008 2022-02-11 MSFT 20.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1008 2022-03-11 TSLA 30.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1008 2022-04-11 AMZN 40.0 " + System.lineSeparator()
        + "" + System.lineSeparator()
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
  public void testManualUploadPortVal() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1009;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-05-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-06-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-07-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-08-11";
    int option1 = 4;
    String date = "2022-10-30";


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + date2 + System.lineSeparator()
        + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4
        + System.lineSeparator() + date4 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option1 + System.lineSeparator()
        + date + System.lineSeparator() + "0";

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
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$18666.6" + System.lineSeparator()
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
  public void testManualUploadANdInvalidOption()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1010;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-09-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-08-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-10-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-05-11";
    int option1 = 12;

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2 + System.lineSeparator()
        + date2 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + date4 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option1;

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
        + "Invalid option";
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
  public void testModifyPortOnExistingPortfolioFutureDate()
      throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2;
    int portfolioOption = 1;
    int option = 5;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-09-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-08-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-10-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-05-11";
    int option1 = 3;
    String date = "2023-11-25";

    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2 + System.lineSeparator()
        + date2 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + date4 + System.lineSeparator() + "exit" + System.lineSeparator()
        + option1 + System.lineSeparator() + date + ""
        + System.lineSeparator() + "0";

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
        + "3: For uploading stocks by specifying weight" + System.lineSeparator()
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
        + "Portfolio updated successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "future date not possible";
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
  public void testModifyPortOnExistingPortfolioAllPortfolio()
      throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1012;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-05-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-06-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-07-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-08-11";
    int option1 = 5;
    int option11 = 4;
    String date = "2022-10-28";

    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2 + System.lineSeparator()
        + date2 + System.lineSeparator()
        + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + date4 + System.lineSeparator() + "exit"
        + System.lineSeparator() + option1
        + System.lineSeparator() + 1
        + System.lineSeparator()
        + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2 + System.lineSeparator()
        + date2 + System.lineSeparator()
        + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + date4 + System.lineSeparator() + "exit" + System.lineSeparator()
        + option11 + System.lineSeparator() + date
        + System.lineSeparator() + "0";

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
        + "Portfolio updated successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$37333.2" + System.lineSeparator()
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
  public void testModifyPortOnNonExistingPortfolio() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 111111111;
    int portfolioOption = 1;
    int option = 5;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-09-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-08-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-10-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-05-11";
    int option1 = 3;
    String date = "2022-10-28";

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2 + System.lineSeparator()
        + date2 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + date4 + System.lineSeparator() + "exit" + System.lineSeparator()
        + option1 + System.lineSeparator() + date
        + System.lineSeparator() + "0";

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
        + "3: For uploading stocks by specifying weight" + System.lineSeparator()
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
        + "Portfolio id does not exist";
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
  public void testFractional() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1026;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    double numberOfStocks1 = 10.66;
    String date1 = "2022-11-11";


    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + "exit" + System.lineSeparator() + "0" + System.lineSeparator();

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
        + "Number of stocks cannot be fraction";
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
  public void sellStocksCurrDatePortfolioExistsGreaterThan() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1013;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-05-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-06-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-07-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-08-11";
    String tickerNumber5 = "NFLX";
    int numberOfStocks5 = 50;
    String date5 = "2022-09-30";
    String tickerNumber6 = "NFLX";
    int numberOfStocks6 = 50;
    String date6 = "2022-10-30";
    String tickerNumber7 = "NFLX";
    int numberOfStocks7 = 50;
    String date7 = "2022-11-01";
    String tickerNumber8 = "NFLX";
    int numberOfStocks8 = 50;
    String date8 = "2022-11-05";
    String tickerNumber9 = "NFLX";
    int numberOfStocks9 = 50;
    String date9 = "2022-11-11";
    int option1 = 6;
    String tickerNumberS1 = "NFLX";
    int numberOfStocksS1 = 100;
    String dateS1 = "2022-11-01";

    String tickerNumberS2 = "NFLX";
    int numberOfStocksS2 = 100;
    String dateS2 = "2022-11-03";

    int option11 = 7;
    String date = "2022-11-11";

    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator()
        + date2 + System.lineSeparator()
        + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4
        + System.lineSeparator()
        + date4
        + System.lineSeparator() + tickerNumber5 + System.lineSeparator()
        + numberOfStocks5
        + System.lineSeparator() + date5
        + System.lineSeparator() + tickerNumber6 + System.lineSeparator() + numberOfStocks6
        + System.lineSeparator() + date6 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber7 + System.lineSeparator() + numberOfStocks7
        + System.lineSeparator() + date7 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber8 + System.lineSeparator() + numberOfStocks8
        + System.lineSeparator() + date8 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber9 + System.lineSeparator() + numberOfStocks9
        + System.lineSeparator() + date9 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option1 + System.lineSeparator()
        + tickerNumberS1 + System.lineSeparator() + numberOfStocksS1
        + System.lineSeparator() + dateS1 + System.lineSeparator()
        + option1 + System.lineSeparator()
        + tickerNumberS2 + System.lineSeparator() + numberOfStocksS2
        + System.lineSeparator()
        + dateS2 + System.lineSeparator()
        + "exit" + System.lineSeparator()
        + option11 + System.lineSeparator()
        + System.lineSeparator() + 1
        + System.lineSeparator() + 1
        + date
        + System.lineSeparator() + "0";

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
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Portfolio sold successfully updated" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "The mentioned number of stocks to be sold is "
        + "greater than the stocks available in the portfolio";
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
  public void sellStocksFutureDateDatePortfolioExists() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1003;
    int portfolioOption = 1;
    int option = 6;

    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 25;
    String date1 = "2023-11-01";


    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator() + 0 + System.lineSeparator()
        + "0";

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
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "future date not possible";
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
  public void sellStocksCurrDatePortfolioNotExists() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 111111111;
    int portfolioOption = 1;
    int option = 6;

    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 25;
    String date1 = "2023-11-01";

    String tickerNumber2 = "NFLX";
    int numberOfStocks2 = 10;
    String date2 = "2022-11-03";


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + tickerNumber1
        + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + option + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator()
        + date2 + System.lineSeparator()
        + System.lineSeparator() + "0";

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
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Portfolio id does not exist";
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
  public void sellStocksGreaterThanStocksInPortfolio() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1003;
    int portfolioOption = 1;
    int option = 6;

    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10000;
    String date1 = "2022-11-11";

    String tickerNumber2 = "NFLX";
    int numberOfStocks2 = 10;
    String date2 = "2022-11-03";


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + option + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator()
        + date2 + System.lineSeparator()
        + System.lineSeparator() + "0";

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
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "The mentioned number of stocks to be sold is "
        + "greater than the stocks available in the portfolio";
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
  public void sellStocksGivenDate() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1014;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-05-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-06-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-07-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-08-11";
    String tickerNumber5 = "NFLX";
    int numberOfStocks5 = 50;
    String date5 = "2022-09-30";
    String tickerNumber6 = "NFLX";
    int numberOfStocks6 = 50;
    String date6 = "2022-10-30";
    String tickerNumber7 = "NFLX";
    int numberOfStocks7 = 50;
    String date7 = "2022-11-01";
    String tickerNumber8 = "NFLX";
    int numberOfStocks8 = 50;
    String date8 = "2022-11-05";
    String tickerNumber9 = "NFLX";
    int numberOfStocks9 = 50;
    String date9 = "2022-11-11";

    int option1 = 6;
    String tickerNumberS1 = "NFLX";
    int numberOfStocksS1 = 100;
    String dateS1 = "2022-10-28";
    String tickerNumberS2 = "NFLX";
    int numberOfStocksS2 = 100;
    String dateS2 = "2022-11-05";

    int option11 = 7;

    String date = "2022-11-11";

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator()
        + date2 + System.lineSeparator()
        + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + date4
        + System.lineSeparator() + tickerNumber5 + System.lineSeparator()
        + numberOfStocks5
        + System.lineSeparator() + date5
        + System.lineSeparator() + tickerNumber6 + System.lineSeparator()
        + numberOfStocks6
        + System.lineSeparator() + date6 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber7 + System.lineSeparator()
        + numberOfStocks7
        + System.lineSeparator() + date7 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber8 + System.lineSeparator()
        + numberOfStocks8
        + System.lineSeparator() + date8 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber9 + System.lineSeparator()
        + numberOfStocks9
        + System.lineSeparator() + date9 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option1 + System.lineSeparator()
        + tickerNumberS1 + System.lineSeparator() + numberOfStocksS1
        + System.lineSeparator() + dateS1 + System.lineSeparator()
        + option1 + System.lineSeparator()
        + tickerNumberS2 + System.lineSeparator() + numberOfStocksS2
        + System.lineSeparator()
        + dateS2
        + System.lineSeparator() + option11
        + System.lineSeparator() + 1
        + System.lineSeparator() + date
        + System.lineSeparator() + 1
        + System.lineSeparator() + "0";


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
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Portfolio sold successfully updated" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Portfolio sold successfully updated" + System.lineSeparator()
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
        + "$101892.5" + System.lineSeparator()
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
  public void testCostBasisOnFutureDate() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2;
    int portfolioOption = 1;
    int option = 7;
    String date = "2023-11-11";


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + date
        + System.lineSeparator() + 1
        + System.lineSeparator() + "0";

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
        + "1: For getting cost basis with commission fees" + System.lineSeparator()
        + "2: For getting cost basis without commission fees" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the commission fee" + System.lineSeparator()
        + "Commission fee should be greater than 0" + System.lineSeparator()
        + "future date not possible";
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
  public void testCostBasisPortfolioNotExists() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 111111;
    int portfolioOption = 1;
    int option = 7;
    String date = "2022-11-11";


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + date
        + System.lineSeparator() + 2
        + System.lineSeparator() + "0";

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
        + "1: For getting cost basis with commission fees" + System.lineSeparator()
        + "2: For getting cost basis without commission fees" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the commission fee" + System.lineSeparator()
        + "Commission fee should be greater than 0" + System.lineSeparator()
        + "Portfolio id does not exist";
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
  public void testCostBasis1() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1;
    int portfolioOption = 1;
    int option = 7;
    String date = "2022-11-11";

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + date
        + System.lineSeparator() + 1
        + System.lineSeparator() + "0";

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
        + "1: For getting cost basis with commission fees" + System.lineSeparator()
        + "2: For getting cost basis without commission fees" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter the commission fee" + System.lineSeparator()
        + "Commission fee should be greater than 0" + System.lineSeparator()
        + "$26087.18" + System.lineSeparator()
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
  public void testCostBasis2() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1017;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-05-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-06-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-07-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-08-11";
    int option1 = 4;
    String date = "2022-10-28";
    int option11 = 7;
    String date11 = "2022-11-11";

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator()
        + portfolio_id + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1
        + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator()
        + numberOfStocks2 + System.lineSeparator()
        + date2 + System.lineSeparator()
        + tickerNumber3 + System.lineSeparator()
        + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4
        + System.lineSeparator()
        + date4 + System.lineSeparator() + "exit"
        + System.lineSeparator()
        + option1 + System.lineSeparator() + date
        + System.lineSeparator() + option11
        + System.lineSeparator() + 1
        + System.lineSeparator() + date11
        + System.lineSeparator() + 1
        + System.lineSeparator() + "0";

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
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$18666.6" + System.lineSeparator()
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
        + "$33444.0" + System.lineSeparator()
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
  public void testDailyPerformance() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1018;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-05-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-06-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-07-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-08-11";
    String tickerNumber5 = "NFLX";
    int numberOfStocks5 = 50;
    String date5 = "2022-09-30";
    String tickerNumber6 = "NFLX";
    int numberOfStocks6 = 50;
    String date6 = "2022-10-30";
    String tickerNumber7 = "NFLX";
    int numberOfStocks7 = 50;
    String date7 = "2022-11-01";
    String tickerNumber8 = "NFLX";
    int numberOfStocks8 = 50;
    String date8 = "2022-11-05";
    String tickerNumber9 = "NFLX";
    int numberOfStocks9 = 50;
    String date9 = "2022-11-11";
    int option2 = 8;
    String dateFrom = "2022-10-15";
    String dateTo = "2022-11-15";

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator()
        + date2 + System.lineSeparator()
        + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4
        + System.lineSeparator()
        + date4
        + System.lineSeparator() + tickerNumber5 + System.lineSeparator() + numberOfStocks5
        + System.lineSeparator() + date5
        + System.lineSeparator() + tickerNumber6 + System.lineSeparator() + numberOfStocks6
        + System.lineSeparator() + date6 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber7 + System.lineSeparator() + numberOfStocks7
        + System.lineSeparator() + date7 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber8 + System.lineSeparator() + numberOfStocks8
        + System.lineSeparator() + date8 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber9 + System.lineSeparator() + numberOfStocks9
        + System.lineSeparator() + date9 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option2 + System.lineSeparator()
        + dateFrom + System.lineSeparator() + dateTo + System.lineSeparator() + "0";

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
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter end date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "" + System.lineSeparator()
        + "Performance of portfolio 1018 from 2022-10-15 to 2022-11-15" + System.lineSeparator()
        + "" + System.lineSeparator()
        + "2022-10-14 : " + System.lineSeparator()
        + "2022-10-17 : *" + System.lineSeparator()
        + "2022-10-19 : **" + System.lineSeparator()
        + "2022-10-21 : **" + System.lineSeparator()
        + "2022-10-24 : **" + System.lineSeparator()
        + "2022-10-26 : ***" + System.lineSeparator()
        + "2022-10-28 : ************" + System.lineSeparator()
        + "2022-10-31 : ***********" + System.lineSeparator()
        + "2022-11-02 : ******************" + System.lineSeparator()
        + "2022-11-04 : *************************" + System.lineSeparator()
        + "2022-11-07 : ************************" + System.lineSeparator()
        + "2022-11-09 : ***********************" + System.lineSeparator()
        + "2022-11-11 : **************************************" + System.lineSeparator()
        + "2022-11-14 : ***************************************" + System.lineSeparator()
        + "Relative Scale: base = $28800" + System.lineSeparator()
        + "Relative Scale: * = $1588" + System.lineSeparator()
        + "" + System.lineSeparator()
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
  public void testDailyStartDateAfterFutureDate() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1019;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-05-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-06-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-07-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-08-11";
    String tickerNumber5 = "NFLX";
    int numberOfStocks5 = 50;
    String date5 = "2022-09-30";
    String tickerNumber6 = "NFLX";
    int numberOfStocks6 = 50;
    String date6 = "2022-10-30";
    String tickerNumber7 = "NFLX";
    int numberOfStocks7 = 50;
    String date7 = "2022-11-01";
    String tickerNumber8 = "NFLX";
    int numberOfStocks8 = 50;
    String date8 = "2022-11-05";
    String tickerNumber9 = "NFLX";
    int numberOfStocks9 = 50;
    String date9 = "2022-11-11";
    int option2 = 8;
    String dateFrom = "2022-11-16";
    String dateTo = "2022-11-14";

    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator()
        + date2 + System.lineSeparator()
        + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4
        + System.lineSeparator()
        + date4
        + System.lineSeparator() + tickerNumber5 + System.lineSeparator()
        + numberOfStocks5
        + System.lineSeparator() + date5
        + System.lineSeparator() + tickerNumber6 + System.lineSeparator() + numberOfStocks6
        + System.lineSeparator() + date6 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber7 + System.lineSeparator() + numberOfStocks7
        + System.lineSeparator() + date7 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber8 + System.lineSeparator() + numberOfStocks8
        + System.lineSeparator() + date8 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber9 + System.lineSeparator() + numberOfStocks9
        + System.lineSeparator() + date9 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option2 + System.lineSeparator()
        + dateFrom + System.lineSeparator() + dateTo + System.lineSeparator() + "0";

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
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter end date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Start date is greater than end date";
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
  public void testTwoDayPerformance() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1020;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-05-11";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-06-11";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-11-05";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-10-28";
    String tickerNumber5 = "NFLX";
    int numberOfStocks5 = 50;
    String date5 = "2022-10-15";
    String tickerNumber6 = "NFLX";
    int numberOfStocks6 = 50;
    String date6 = "2022-10-30";
    String tickerNumber7 = "NFLX";
    int numberOfStocks7 = 50;
    String date7 = "2022-11-01";
    String tickerNumber8 = "NFLX";
    int numberOfStocks8 = 50;
    String date8 = "2022-11-05";
    String tickerNumber9 = "NFLX";
    int numberOfStocks9 = 50;
    String date9 = "2022-11-11";
    int option2 = 8;
    String dateFrom = "2022-10-01";
    String dateTo = "2022-11-11";

    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator()
        + date2 + System.lineSeparator()
        + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + date4
        + System.lineSeparator() + tickerNumber5 + System.lineSeparator() + numberOfStocks5
        + System.lineSeparator() + date5
        + System.lineSeparator() + tickerNumber6 + System.lineSeparator() + numberOfStocks6
        + System.lineSeparator() + date6 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber7 + System.lineSeparator() + numberOfStocks7
        + System.lineSeparator() + date7 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber8 + System.lineSeparator() + numberOfStocks8
        + System.lineSeparator() + date8 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber9 + System.lineSeparator() + numberOfStocks9
        + System.lineSeparator() + date9 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option2 + System.lineSeparator()
        + dateFrom + System.lineSeparator() + dateTo + System.lineSeparator() + "0";

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
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter end date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "" + System.lineSeparator()
        + "Performance of portfolio 1020 from 2022-10-01 to 2022-11-11" + System.lineSeparator()
        + "" + System.lineSeparator()
        + "2022-09-30 : " + System.lineSeparator()
        + "2022-10-03 : " + System.lineSeparator()
        + "2022-10-05 : " + System.lineSeparator()
        + "2022-10-07 : " + System.lineSeparator()
        + "2022-10-10 : " + System.lineSeparator()
        + "2022-10-12 : " + System.lineSeparator()
        + "2022-10-14 : *****" + System.lineSeparator()
        + "2022-10-17 : ******" + System.lineSeparator()
        + "2022-10-19 : ******" + System.lineSeparator()
        + "2022-10-21 : *******" + System.lineSeparator()
        + "2022-10-24 : *******" + System.lineSeparator()
        + "2022-10-26 : *******" + System.lineSeparator()
        + "2022-10-28 : ****************" + System.lineSeparator()
        + "2022-10-31 : ****************" + System.lineSeparator()
        + "2022-11-02 : *********************" + System.lineSeparator()
        + "2022-11-04 : *****************************" + System.lineSeparator()
        + "2022-11-07 : *****************************" + System.lineSeparator()
        + "2022-11-09 : ****************************" + System.lineSeparator()
        + "2022-11-11 : ***************************************" + System.lineSeparator()
        + "Relative Scale: base = $6720" + System.lineSeparator()
        + "Relative Scale: * = $2090" + System.lineSeparator()
        + "" + System.lineSeparator()
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
  public void testThreeDayPerformance() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1021;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-08-25";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-08-28";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-09-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-10-12";
    String tickerNumber5 = "NFLX";
    int numberOfStocks5 = 50;
    String date5 = "2022-10-15";
    String tickerNumber6 = "NFLX";
    int numberOfStocks6 = 50;
    String date6 = "2022-08-30";
    String tickerNumber7 = "NFLX";
    int numberOfStocks7 = 50;
    String date7 = "2022-11-01";
    String tickerNumber8 = "NFLX";
    int numberOfStocks8 = 50;
    String date8 = "2022-11-05";
    String tickerNumber9 = "NFLX";
    int numberOfStocks9 = 50;
    String date9 = "2022-11-11";
    int option2 = 8;
    String dateFrom = "2022-08-21";
    String dateTo = "2022-11-11";

    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2 + System.lineSeparator()
        + date2 + System.lineSeparator()
        + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + date4
        + System.lineSeparator() + tickerNumber5 + System.lineSeparator() + numberOfStocks5
        + System.lineSeparator() + date5
        + System.lineSeparator() + tickerNumber6 + System.lineSeparator() + numberOfStocks6
        + System.lineSeparator() + date6 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber7 + System.lineSeparator() + numberOfStocks7
        + System.lineSeparator() + date7 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber8 + System.lineSeparator() + numberOfStocks8
        + System.lineSeparator() + date8 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber9 + System.lineSeparator() + numberOfStocks9
        + System.lineSeparator() + date9 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option2 + System.lineSeparator()
        + dateFrom + System.lineSeparator() + dateTo + System.lineSeparator() + "0";

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
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter end date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "" + System.lineSeparator()
        + "Performance of portfolio 1021 from 2022-08-21 to 2022-11-11" + System.lineSeparator()
        + "" + System.lineSeparator()
        + "2022-08-19 : " + System.lineSeparator()
        + "2022-08-22 : " + System.lineSeparator()
        + "2022-08-25 : *" + System.lineSeparator()
        + "2022-08-29 : ****" + System.lineSeparator()
        + "2022-09-01 : **********" + System.lineSeparator()
        + "2022-09-05 : **********" + System.lineSeparator()
        + "2022-09-08 : **********" + System.lineSeparator()
        + "2022-09-12 : ***************" + System.lineSeparator()
        + "2022-09-15 : ***************" + System.lineSeparator()
        + "2022-09-19 : ***************" + System.lineSeparator()
        + "2022-09-22 : ***************" + System.lineSeparator()
        + "2022-09-26 : **************" + System.lineSeparator()
        + "2022-09-29 : ***************" + System.lineSeparator()
        + "2022-10-03 : **************" + System.lineSeparator()
        + "2022-10-06 : **************" + System.lineSeparator()
        + "2022-10-10 : *************" + System.lineSeparator()
        + "2022-10-13 : ****************" + System.lineSeparator()
        + "2022-10-17 : ***********************" + System.lineSeparator()
        + "2022-10-20 : ************************" + System.lineSeparator()
        + "2022-10-24 : **************************" + System.lineSeparator()
        + "2022-10-27 : **************************" + System.lineSeparator()
        + "2022-10-31 : **************************" + System.lineSeparator()
        + "2022-11-03 : *******************************" + System.lineSeparator()
        + "2022-11-07 : *************************************" + System.lineSeparator()
        + "2022-11-10 : ***************************************" + System.lineSeparator()
        + "Relative Scale: base = $0" + System.lineSeparator()
        + "Relative Scale: * = $1805" + System.lineSeparator()
        + "" + System.lineSeparator()
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
  public void testWeekPerformance() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1022;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-06-25";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-07-28";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-08-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-09-12";
    String tickerNumber5 = "NFLX";
    int numberOfStocks5 = 50;
    String date5 = "2022-10-15";
    String tickerNumber6 = "NFLX";
    int numberOfStocks6 = 50;
    String date6 = "2022-10-30";
    String tickerNumber7 = "NFLX";
    int numberOfStocks7 = 50;
    String date7 = "2022-11-11";
    String tickerNumber8 = "NFLX";
    int numberOfStocks8 = 50;
    String date8 = "2022-06-30";
    String tickerNumber9 = "NFLX";
    int numberOfStocks9 = 50;
    String date9 = "2022-08-11";
    int option2 = 8;
    String dateFrom = "2022-06-21";
    String dateTo = "2022-11-11";

    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2 + System.lineSeparator()
        + date2 + System.lineSeparator()
        + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + date4
        + System.lineSeparator() + tickerNumber5 + System.lineSeparator() + numberOfStocks5
        + System.lineSeparator() + date5
        + System.lineSeparator() + tickerNumber6 + System.lineSeparator() + numberOfStocks6
        + System.lineSeparator() + date6 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber7 + System.lineSeparator() + numberOfStocks7
        + System.lineSeparator() + date7 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber8 + System.lineSeparator() + numberOfStocks8
        + System.lineSeparator() + date8 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber9 + System.lineSeparator() + numberOfStocks9
        + System.lineSeparator() + date9 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option2 + System.lineSeparator()
        + dateFrom + System.lineSeparator() + dateTo + System.lineSeparator() + "0";

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
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter end date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "" + System.lineSeparator()
        + "Performance of portfolio 1022 from 2022-06-21 to 2022-11-11" + System.lineSeparator()
        + "" + System.lineSeparator()
        + "2022-06-21 : " + System.lineSeparator()
        + "2022-06-28 : " + System.lineSeparator()
        + "2022-07-05 : *****" + System.lineSeparator()
        + "2022-07-12 : *****" + System.lineSeparator()
        + "2022-07-19 : ******" + System.lineSeparator()
        + "2022-07-26 : ******" + System.lineSeparator()
        + "2022-08-02 : *********" + System.lineSeparator()
        + "2022-08-09 : **********" + System.lineSeparator()
        + "2022-08-16 : ********************************" + System.lineSeparator()
        + "2022-08-23 : ******************************" + System.lineSeparator()
        + "2022-08-30 : ********************" + System.lineSeparator()
        + "2022-09-06 : *******************" + System.lineSeparator()
        + "2022-09-13 : **********************" + System.lineSeparator()
        + "2022-09-20 : ************************" + System.lineSeparator()
        + "2022-09-27 : **********************" + System.lineSeparator()
        + "2022-10-04 : ***********************" + System.lineSeparator()
        + "2022-10-11 : ********************" + System.lineSeparator()
        + "2022-10-18 : ****************************" + System.lineSeparator()
        + "2022-10-25 : *********************************" + System.lineSeparator()
        + "2022-11-01 : ***************************************" + System.lineSeparator()
        + "2022-11-08 : ************************************" + System.lineSeparator()
        + "Relative Scale: base = $0" + System.lineSeparator()
        + "Relative Scale: * = $1888" + System.lineSeparator()
        + "" + System.lineSeparator()
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
  public void QuaterlyPerformance() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1023;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2021-06-25";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2021-07-28";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2021-08-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2021-09-12";
    String tickerNumber5 = "NFLX";
    int numberOfStocks5 = 50;
    String date5 = "2021-10-15";
    String tickerNumber6 = "NFLX";
    int numberOfStocks6 = 50;
    String date6 = "2022-10-30";
    String tickerNumber7 = "NFLX";
    int numberOfStocks7 = 50;
    String date7 = "2022-11-11";
    String tickerNumber8 = "NFLX";
    int numberOfStocks8 = 50;
    String date8 = "2022-06-30";
    String tickerNumber9 = "NFLX";
    int numberOfStocks9 = 50;
    String date9 = "2022-08-11";
    int option2 = 8;
    String dateFrom = "2021-12-28";
    String dateTo = "2022-11-11";

    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2 + System.lineSeparator()
        + date2 + System.lineSeparator()
        + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + date4
        + System.lineSeparator() + tickerNumber5 + System.lineSeparator() + numberOfStocks5
        + System.lineSeparator() + date5
        + System.lineSeparator() + tickerNumber6 + System.lineSeparator() + numberOfStocks6
        + System.lineSeparator() + date6 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber7 + System.lineSeparator() + numberOfStocks7
        + System.lineSeparator() + date7 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber8 + System.lineSeparator() + numberOfStocks8
        + System.lineSeparator() + date8 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber9 + System.lineSeparator() + numberOfStocks9
        + System.lineSeparator() + date9 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option2 + System.lineSeparator()
        + dateFrom + System.lineSeparator() + dateTo + System.lineSeparator() + "0";

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
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter end date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "" + System.lineSeparator()
        + "Performance of portfolio 1023 from 2021-12-28 to 2022-11-11" + System.lineSeparator()
        + "" + System.lineSeparator()
        + "Dec 2021 : ***************************************" + System.lineSeparator()
        + "Jan 2022 : ********************************" + System.lineSeparator()
        + "Feb 2022 : ********************************" + System.lineSeparator()
        + "Mar 2022 : ***********************************" + System.lineSeparator()
        + "Apr 2022 : ***********************" + System.lineSeparator()
        + "May 2022 : *********************" + System.lineSeparator()
        + "Jun 2022 : " + System.lineSeparator()
        + "Jul 2022 : ***" + System.lineSeparator()
        + "Aug 2022 : *" + System.lineSeparator()
        + "Sep 2022 : *" + System.lineSeparator()
        + "Oct 2022 : *******" + System.lineSeparator()
        + "Relative Scale: base = $48820" + System.lineSeparator()
        + "Relative Scale: * = $3979" + System.lineSeparator()
        + "" + System.lineSeparator()
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
  public void YearlyPerformance() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1024;
    int portfolioOption = 1;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2020-06-25";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2021-07-28";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-08-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2021-09-12";
    String tickerNumber5 = "NFLX";
    int numberOfStocks5 = 50;
    String date5 = "2021-10-15";
    String tickerNumber6 = "NFLX";
    int numberOfStocks6 = 50;
    String date6 = "2019-10-30";
    String tickerNumber7 = "NFLX";
    int numberOfStocks7 = 50;
    String date7 = "2022-11-11";
    String tickerNumber8 = "NFLX";
    int numberOfStocks8 = 50;
    String date8 = "2022-06-30";
    String tickerNumber9 = "NFLX";
    int numberOfStocks9 = 50;
    String date9 = "2022-08-11";
    int option2 = 8;
    String dateFrom = "2020-05-18";
    String dateTo = "2022-11-11";

    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2 + System.lineSeparator()
        + date2 + System.lineSeparator()
        + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + date4
        + System.lineSeparator() + tickerNumber5 + System.lineSeparator() + numberOfStocks5
        + System.lineSeparator() + date5
        + System.lineSeparator() + tickerNumber6 + System.lineSeparator() + numberOfStocks6
        + System.lineSeparator() + date6 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber7 + System.lineSeparator() + numberOfStocks7
        + System.lineSeparator() + date7 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber8 + System.lineSeparator() + numberOfStocks8
        + System.lineSeparator() + date8 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber9 + System.lineSeparator() + numberOfStocks9
        + System.lineSeparator() + date9 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option2 + System.lineSeparator()
        + dateFrom + System.lineSeparator() + dateTo + System.lineSeparator() + "0";

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
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter end date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "" + System.lineSeparator()
        + "Performance of portfolio 1024 from 2020-05-18 to 2022-11-11" + System.lineSeparator()
        + "" + System.lineSeparator()
        + "May 2020 : " + System.lineSeparator()
        + "Aug 2020 : **" + System.lineSeparator()
        + "Nov 2020 : *" + System.lineSeparator()
        + "Feb 2021 : **" + System.lineSeparator()
        + "May 2021 : *" + System.lineSeparator()
        + "Aug 2021 : ***" + System.lineSeparator()
        + "Nov 2021 : ***************************************" + System.lineSeparator()
        + "Feb 2022 : ******************************" + System.lineSeparator()
        + "May 2022 : ********************" + System.lineSeparator()
        + "Aug 2022 : *********" + System.lineSeparator()
        + "Relative Scale: base = $20990" + System.lineSeparator()
        + "Relative Scale: * = $4913" + System.lineSeparator()
        + "" + System.lineSeparator()
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
  public void testMultipleScenarioAllInOne() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1025;
    int portfolioOption = 1;
    int option1 = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String date1 = "2022-06-25";
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String date2 = "2022-07-28";
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String date3 = "2022-08-11";
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    String date4 = "2022-09-12";
    String tickerNumber5 = "NFLX";
    int numberOfStocks5 = 50;
    String date5 = "2022-10-15";
    String tickerNumber6 = "NFLX";
    int numberOfStocks6 = 50;
    String date6 = "2022-10-30";
    String tickerNumber7 = "NFLX";
    int numberOfStocks7 = 50;
    String date7 = "2022-11-11";
    String tickerNumber8 = "NFLX";
    int numberOfStocks8 = 50;
    String date8 = "2022-06-30";
    String tickerNumber9 = "NFLX";
    int numberOfStocks9 = 50;
    String date9 = "2022-08-11";
    int option3 = 3;
    String dateS1 = "2022-11-11";
    int option4 = 4;
    String dateS2 = "2022-11-01";
    int option5 = 5;
    String tickerNumberModify1 = "NFLX";
    int numberOfStocksModify1 = 10;
    String dateModify1 = "2022-10-25";
    String tickerNumberModify2 = "MSFT";
    int numberOfStocksModify2 = 20;
    String dateModify2 = "2022-11-05";
    int option6 = 6;
    String sellTicker = "NFLX";
    int sellNum = 20;
    String sellDate = "2022-11-02";
    int option7 = 7;
    String dateCostBasis = "2022-10-30";
    int option8 = 8;
    String dateFrom = "2022-05-18";
    String dateTo = "2022-11-11";

    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption
        + System.lineSeparator() + option1
        + System.lineSeparator() + 1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + date1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2 + System.lineSeparator()
        + date2 + System.lineSeparator()
        + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator() + date3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + date4
        + System.lineSeparator() + tickerNumber5 + System.lineSeparator() + numberOfStocks5
        + System.lineSeparator() + date5
        + System.lineSeparator() + tickerNumber6 + System.lineSeparator() + numberOfStocks6
        + System.lineSeparator() + date6 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber7 + System.lineSeparator() + numberOfStocks7
        + System.lineSeparator() + date7 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber8 + System.lineSeparator() + numberOfStocks8
        + System.lineSeparator() + date8 + System.lineSeparator()
        + System.lineSeparator() + tickerNumber9 + System.lineSeparator() + numberOfStocks9
        + System.lineSeparator() + date9 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option3 + System.lineSeparator()
        + dateS1
        + System.lineSeparator() + option4 + System.lineSeparator()
        + dateS2 + System.lineSeparator()
        + option5 + System.lineSeparator()
        + 1 + System.lineSeparator()
        + tickerNumberModify1 + System.lineSeparator()
        + numberOfStocksModify1 + System.lineSeparator() + dateModify1 + System.lineSeparator()
        + tickerNumberModify2 + System.lineSeparator() + numberOfStocksModify2
        + System.lineSeparator()
        + dateModify2 + System.lineSeparator() + "exit" + System.lineSeparator() + option3
        + System.lineSeparator() + dateS1 + System.lineSeparator() + option4
        + System.lineSeparator() + dateS2 + System.lineSeparator()
        + option6 + System.lineSeparator() + sellTicker + System.lineSeparator() + sellNum
        + System.lineSeparator() + sellDate
        + System.lineSeparator() + option7
        + System.lineSeparator() + 1
        + System.lineSeparator() + dateCostBasis
        + System.lineSeparator() + 1
        + System.lineSeparator() + option8
        + System.lineSeparator() + dateFrom + System.lineSeparator()
        + dateTo + System.lineSeparator()
        + "0";

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
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "UId UName UEId PortId Date Ticker NumStocks" + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-06-24 NFLX 10.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-07-28 MSFT 20.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-08-11 TSLA 30.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-09-12 AMZN 40.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-10-14 NFLX 50.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-10-28 NFLX 50.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-11-11 NFLX 50.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-06-30 NFLX 50.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-08-11 NFLX 50.0 " + System.lineSeparator()
        + "" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$75487.1" + System.lineSeparator()
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
        + "Portfolio updated successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "UId UName UEId PortId Date Ticker NumStocks" + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-06-24 NFLX 10.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-07-28 MSFT 20.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-08-11 TSLA 30.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-09-12 AMZN 40.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-10-14 NFLX 50.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-10-28 NFLX 50.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-11-11 NFLX 50.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-06-30 NFLX 50.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-08-11 NFLX 50.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-10-25 NFLX 10.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 1025 2022-11-04 MSFT 20.0 " + System.lineSeparator()
        + "" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$78354.6" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Portfolio sold successfully updated" + System.lineSeparator()
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
        + "$88775.09999999999" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "5: Purchase a stock in existing portfolio" + System.lineSeparator()
        + "6: Sell a stock in existing portfolio" + System.lineSeparator()
        + "7: Determine cost basis" + System.lineSeparator()
        + "8: Portfolio Performance" + System.lineSeparator()
        + "Please enter zero to exit" + System.lineSeparator()
        + "Please enter start date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "Please enter end date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "" + System.lineSeparator()
        + "Performance of portfolio 1025 from 2022-05-18 to 2022-11-11" + System.lineSeparator()
        + "" + System.lineSeparator()
        + "2022-05-18 : " + System.lineSeparator()
        + "2022-05-25 : " + System.lineSeparator()
        + "2022-06-01 : " + System.lineSeparator()
        + "2022-06-08 : " + System.lineSeparator()
        + "2022-06-15 : " + System.lineSeparator()
        + "2022-06-22 : " + System.lineSeparator()
        + "2022-06-29 : " + System.lineSeparator()
        + "2022-07-06 : *****" + System.lineSeparator()
        + "2022-07-13 : *****" + System.lineSeparator()
        + "2022-07-20 : ******" + System.lineSeparator()
        + "2022-07-27 : *******" + System.lineSeparator()
        + "2022-08-03 : **********" + System.lineSeparator()
        + "2022-08-10 : **********" + System.lineSeparator()
        + "2022-08-17 : *******************************" + System.lineSeparator()
        + "2022-08-24 : ******************************" + System.lineSeparator()
        + "2022-08-31 : ********************" + System.lineSeparator()
        + "2022-09-07 : ********************" + System.lineSeparator()
        + "2022-09-14 : ***********************" + System.lineSeparator()
        + "2022-09-21 : ***********************" + System.lineSeparator()
        + "2022-09-28 : ************************" + System.lineSeparator()
        + "2022-10-05 : ***********************" + System.lineSeparator()
        + "2022-10-12 : *********************" + System.lineSeparator()
        + "2022-10-19 : *******************************" + System.lineSeparator()
        + "2022-10-26 : ***********************************" + System.lineSeparator()
        + "2022-11-02 : ***************************************" + System.lineSeparator()
        + "2022-11-09 : ***************************************" + System.lineSeparator()
        + "Relative Scale: base = $0" + System.lineSeparator()
        + "Relative Scale: * = $1866" + System.lineSeparator()
        + "" + System.lineSeparator()
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
