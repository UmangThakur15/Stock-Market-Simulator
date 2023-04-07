import controller.ControllerImpl;
import controller.ControllerMain;
import model.ModelImpl;
import model.ModelImplFlexible;
import model.PortfolioFlexible;
import model.PortfolioNonFlexible;
import org.junit.Test;
import view.View;
import view.ViewImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.Assert.assertEquals;


/**
 * This class consists of all the tests to check the correctness of the methods in the
 * NonFlexiblePortfolio Class.
 **/
public class NonFlexiblePortfolioTest {

  @Test
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_10
  // portfolio_data_10.csv does not exist else it will throw an error
  public void testAddFileManualInputCorrectInput() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 10;
    int portfolioOption = 2;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + tickerNumber3 + System.lineSeparator()
        + numberOfStocks3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4
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
        + "Press zero to exit" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
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
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on path : portfolio_data_11
  // portfolio_data_11.csv does not exist else it will throw an error
  public void testAddFileManualInputCorrectInput10S() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 11;
    int portfolioOption = 2;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1
        + System.lineSeparator() + tickerNumber2 + System.lineSeparator()
        + numberOfStocks2
        + System.lineSeparator() + tickerNumber3 + System.lineSeparator()
        + numberOfStocks3 + System.lineSeparator()
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
        + "Press zero to exit" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
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


  // Please enter a new portfolio id that does not exist on standard path.
  // Please ensure portfolio_data_13.csv does not exist
  @Test
  public void testAddFileManualInputCorrectInvalidTicker()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 13;
    int portfolioOption = 2;
    int option = 1;
    String tickerNumber1 = "ZZZZ";
    int numberOfStocks1 = 10;
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + tickerNumber1
        + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + tickerNumber2
        + System.lineSeparator() + numberOfStocks2
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
        + "Press zero to exit" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
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

  //Portfolio already exists, so please use a portfolio id that exists.
  // Please ensure exists portfolio_data_1.csv
  @Test
  public void testControllerAddDataByManualFilePortfolioExists()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1;
    int portfolioOption = 2;
    int option = 2;

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator()
        + portfolio_id + System.lineSeparator()
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

  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on path : portfolio_data_12
  // portfolio_data_12.csv does not exist else it will throw an error
  @Test
  public void testControllerAddDataByManualFileNewPort() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolioOption = 2;
    int portfolio_id = 12;
    int option = 2;

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id + System.lineSeparator()
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
        + "Press zero to exit" + System.lineSeparator()
        + "Portfolio added" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
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
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 20;
    int portfolioOption = 2;
    int option = 2;

    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
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
  public void testControllerGetComposition() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1;
    int portfolioOption = 2;
    int option = 3;
    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
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
        + "Press zero to exit" + System.lineSeparator()
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
        + "Press zero to exit" + System.lineSeparator()
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

  // Please enter the portfolio id that does not exist on standard path.
  @Test
  public void testControllerGetCompositionPortDoesNotExist()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1112;
    int option = 3;
    int portfolioOption = 2;

    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
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
        + "Press zero to exit" + System.lineSeparator()
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
  public void testControllerGetPortfolioValue() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1;
    int option = 4;
    int portfolio_option = 2;
    String date = "2022-10-25";
    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolio_option + System.lineSeparator() + option
        + System.lineSeparator() + date
        + System.lineSeparator() + "0";

    // Below is the expected result to run for MAC
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
        + "Press zero to exit" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$29377.019999999997" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
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

  //Before running please ensure that Portfolio id 100000 does not exist on path
  @Test
  //(expected= IllegalArgumentException.class)
  public void testControllerGetPortfolioValue2() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 100000;
    int option = 4;
    int portfolio_option = 2;
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
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_15
  // portfolio_data_10.csv does not exist else it will throw an error
  public void testManualReUpload() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 15;
    int portfolioOption = 2;
    int option1 = 1;
    int option2 = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + tickerNumber3 + System.lineSeparator()
        + numberOfStocks3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
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
        + "Press zero to exit" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
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
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_15
  // portfolio_data_10.csv does not exist else it will throw an error
  // all in one
  public void testManualUploadGetComposPortVal() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 16;
    int portfolioOption = 2;
    int option1 = 1;
    int option2 = 3;
    int option3 = 4;
    String date1 = "2021-11-11";
    String date2 = "2022-10-31";
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + tickerNumber3 + System.lineSeparator()
        + numberOfStocks3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4
        + System.lineSeparator() + "exit"
        + System.lineSeparator()
        + option2 + System.lineSeparator() + option3 + System.lineSeparator() + date1
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
        + "Press zero to exit" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
        + "UId UName UEId PortId Date Ticker NumStocks" + System.lineSeparator()
        + "10 ABC test@gmail.com 16 2022-11-21 NFLX 10.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 16 2022-11-21 MSFT 20.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 16 2022-11-21 TSLA 30.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 16 2022-11-21 AMZN 40.0 " + System.lineSeparator()
        + "" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$184029.7" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$18485.2" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
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
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_15
  // portfolio_data_10.csv does not exist else it will throw an error
  // all in one
  public void testGetCompositionAndUpload() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1;
    int portfolioOption = 2;
    int option1 = 3;
    int option2 = 1;


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator()
        + portfolio_id + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option1
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
        + "Press zero to exit" + System.lineSeparator()
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
        + "Press zero to exit" + System.lineSeparator()
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
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_15
  // portfolio_data_10.csv does not exist else it will throw an error
  // all in one
  public void testPortValAndUpload() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1;
    int portfolioOption = 2;
    int option1 = 4;
    int option2 = 1;
    String date1 = "2022-11-11";


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
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
        + "Press zero to exit" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$26818.58" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
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
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_17
  // portfolio_data_10.csv does not exist else it will throw an error
  public void testManualUploadGetComposition() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 17;
    int portfolioOption = 2;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    int option1 = 3;


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + tickerNumber1
        + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator()
        + numberOfStocks2
        + System.lineSeparator() + tickerNumber3
        + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator()
        + numberOfStocks4 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option1
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
        + "Press zero to exit" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
        + "UId UName UEId PortId Date Ticker NumStocks" + System.lineSeparator()
        + "10 ABC test@gmail.com 17 2022-11-21 NFLX 10.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 17 2022-11-21 MSFT 20.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 17 2022-11-21 TSLA 30.0 " + System.lineSeparator()
        + "10 ABC test@gmail.com 17 2022-11-21 AMZN 40.0 " + System.lineSeparator()
        + "" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
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
  public void testFractional() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1026;
    int portfolioOption = 2;
    int option = 1;
    String tickerNumber1 = "NFLX";
    double numberOfStocks1 = 10.66;


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + tickerNumber1
        + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator()
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
        + "Press zero to exit" + System.lineSeparator()
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
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_18
  // portfolio_data_10.csv does not exist else it will throw an error
  public void testManualUploadPortVal() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 18;
    int portfolioOption = 2;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    int option1 = 4;
    String date1 = "2022-10-30";


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + tickerNumber3
        + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator()
        + numberOfStocks4 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option1 + System.lineSeparator()
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
        + "Press zero to exit" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
        + "Please enter date in exact same format YYYY-MM-DD" + System.lineSeparator()
        + "$18666.6" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
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
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_19
  // portfolio_data_19.csv does not exist else it will throw an error
  public void testManualUploadANdInvalidOption() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 19;
    int portfolioOption = 2;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String tickerNumber3 = "TSLA";
    int numberOfStocks3 = 30;
    String tickerNumber4 = "AMZN";
    int numberOfStocks4 = 40;
    int option1 = 7;


    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator()
        + portfolio_id + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option1 + System.lineSeparator()
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
        + "Press zero to exit" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Please enter the number of stocks" + System.lineSeparator()
        + "Please enter the Ticker Number" + System.lineSeparator()
        + "Please enter exit if you want to exit" + System.lineSeparator()
        + "Portfolio created successfully" + System.lineSeparator()
        + "Please select from below options" + System.lineSeparator()
        + "3: To get Composition of Portfolio" + System.lineSeparator()
        + "4: Portfolio value on certain date" + System.lineSeparator()
        + "Press zero to exit" + System.lineSeparator()
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


}