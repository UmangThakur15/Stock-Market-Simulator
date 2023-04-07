import controller.ControllerImpl;
import controller.ControllerMain;
import model.ModelImpl;
import model.ModelImplFlexible;
import model.PortfolioFlexible;
import model.PortfolioNonFlexible;
import org.junit.Test;
import view.View;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.HashMap;


import static org.junit.Assert.assertEquals;


/**
 * This class consists of all the tests to check the correctness of the methods
 * present in the ViewImpl class.
 **/
public class MockViewTestNonFlexible {

  @Test
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_40
  // portfolio_data_40.csv does not exist else it will throw an error
  public void testAddFileManualInputCorrectInput() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 40;
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


    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + tickerNumber3 + System.lineSeparator()
        + numberOfStocks3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + "exit" + System.lineSeparator() + "0";


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123452521222021222021222021222021228267";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  @Test

  public void testAddFileManualInputCorrectInput10S() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 41;
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
        + System.lineSeparator() + portfolio_id + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + tickerNumber3 + System.lineSeparator()
        + numberOfStocks3 + System.lineSeparator()
        + "exit" + System.lineSeparator() + "0";

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123452521222021222021222021228267";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  // Enter portfolio that exists so that it throws an error
  // Please ensure on standard path portfolio_data_1.csv exists
  @Test
  public void testAddFileManualInputPortfolioExists() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1;
    int portfolioOption = 2;
    int option = 1;
    String tickerNumber1 = "NFLX";
    int numberOfStocks1 = 10;
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;

    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id + System.lineSeparator() + portfolioOption
        + System.lineSeparator()
        + option
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + "exit" + System.lineSeparator() + "0";

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123452521222021222021228267";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  // Please enter a new portfolio id that does not exist on standard path.
  // Please ensure portfolio_data_43.csv does not exist
  @Test
  public void testAddFileManualInputCorrectInvalidTicker()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 43;
    int portfolioOption = 2;
    int option = 1;
    String tickerNumber1 = "ZZZZ";
    int numberOfStocks1 = 10;
    String tickerNumber2 = "MSFT";
    int numberOfStocks2 = 20;
    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator() + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + "exit" + System.lineSeparator() + "0";

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "1234525212220212220212210";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
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

    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption + System.lineSeparator() + option;

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123452510";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on path : portfolio_data_42
  // portfolio_data_42.csv does not exist else it will throw an error
  @Test
  public void testControllerAddDataByManualFileNewPort() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolioOption = 2;
    int portfolio_id = 42;
    int option = 2;

    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption + System.lineSeparator() + option + System.lineSeparator() + "0";

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "12345258267";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  // please enter portfolio id that exists.
  //Please ensure on standard path portfolio_data_1.csv exists.
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

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "12345258267";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123452510";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  //Portfolio already exists, so please use a portfolio id that exists.
  // Please ensure exists portfolio_data_1.csv
  @Test
  public void testControllerGetPortfolioValue()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 1;
    int option = 4;
    int portfolio_option = 2;
    String date = "2022-10-25";
    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolio_option + System.lineSeparator() + option + System.lineSeparator() + date
        + System.lineSeparator() + "0";

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123452598267";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
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
    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + option + System.lineSeparator() + portfolio_option + System.lineSeparator() + date + "0";

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123456";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_45
  // portfolio_data_45.csv does not exist else it will throw an error
  public void testManualReUpload() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 45;
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


    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
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

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123452521222021222021222021222021228266";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  @Test
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_46
  // portfolio_data_46.csv does not exist else it will throw an error
  // all in one
  public void testManualUploadGetComposPortVal() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 46;
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


    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option1
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + tickerNumber3 + System.lineSeparator()
        + numberOfStocks3 + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator() + "exit"
        + System.lineSeparator()
        + option2 + System.lineSeparator() + option3 + System.lineSeparator() + date1
        + System.lineSeparator() + option3 + System.lineSeparator() + date2 + System.lineSeparator()
        + "0" + System.lineSeparator();

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "12345252122202122202122202122202122826826982698267";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());

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


    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option1
        + System.lineSeparator() + option2;

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "12345258266";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());

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


    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option1 + System.lineSeparator() + date1
        + System.lineSeparator() + option2;

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123452598266";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_47
  // portfolio_data_47.csv does not exist else it will throw an error
  public void testManualUploadGetComposition() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 47;
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


    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option1 + System.lineSeparator() + "0";

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123452521222021222021222021222021228268267";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());

  }


  @Test
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_48
  // portfolio_data_48.csv does not exist else it will throw an error
  public void testManualUploadPortVal() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 48;
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


    String inputString = user_id + System.lineSeparator() + user_name
        + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option1 + System.lineSeparator()
        + date1 + System.lineSeparator() + "0";

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "1234525212220212220212220212220212282698267";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_49
  // portfolio_data_49.csv does not exist else it will throw an error
  public void testManualUploadANdInvalidOption() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 49;
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

    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator() + option
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator() + numberOfStocks1
        + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + tickerNumber3 + System.lineSeparator() + numberOfStocks3
        + System.lineSeparator()
        + tickerNumber4 + System.lineSeparator() + numberOfStocks4 + System.lineSeparator()
        + "exit" + System.lineSeparator() + option1 + System.lineSeparator()
        + System.lineSeparator() + "0";

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123452521222021222021222021222021228266";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView2(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  class LoggingView2 implements View {
    private final StringBuilder log;
    private final PrintStream out;

    public LoggingView2(StringBuilder log, PrintStream out) {
      this.log = log;
      this.out = out;
    }


    @Override
    public void takeUserId() {
      log.append('1');
    }

    @Override
    public void takeUserName() {
      log.append('2');
    }

    @Override
    public void takeUserEmail() {
      log.append('3');
    }

    @Override
    public void takePortfolioId() {
      log.append('4');
    }

    @Override
    public void takePortfolioType() {
      log.append('5');
    }

    @Override
    public void invalidOption() {
      log.append('6');
    }

    @Override
    public void programClosed() {
      log.append('7');
    }

    @Override
    public void printString(StringBuilder sb) {
      log.append('8');
    }

    @Override
    public void date() {
      log.append('9');
    }

    @Override
    public void printError(String s) {
      log.append("10");
    }

    @Override
    public void flexiblePortLimitedOption() {
      log.append("11");
    }

    @Override
    public void flexiblePortAllOptions() {
      log.append("12");
    }

    @Override
    public void flexibleDollarCostAverage() {
      log.append("13");
    }

    @Override
    public void startDate() {
      log.append("14");
    }

    @Override
    public void endDate() {
      log.append("15");
    }

    @Override
    public void commissionFeeOption() {
      log.append("16");
    }

    @Override
    public void commissionFee() {
      log.append("17");
    }

    @Override
    public void takeFrequency() {
      log.append("18");
    }

    @Override
    public void totalAmountToBeInvested() {
      log.append("19");
    }

    @Override
    public void takeNumberOfStocks() {
      log.append("20");
    }

    @Override
    public void takeTickerSymbol() {
      log.append("21");
    }

    @Override
    public void takeExit() {
      log.append("22");
    }

    @Override
    public void takeWeightage() {
      log.append("23");
    }

    @Override
    public void endDateWithEmpty() {
      log.append("24");
    }

    @Override
    public void flexibleDollarCostAverageLimited() {
      log.append("30");
    }

    @Override
    public void nonFlexiblePortAllOptions() {
      log.append("25");
    }

    @Override
    public void nonFlexiblePortLimitedOption() {

      log.append("26");
    }

    @Override
    public void printPerformanceDayWise(HashMap<LocalDate, Integer> datePortValueTrack,
                                        int portfolioId, String startDate, String endDate) {
      log.append("27");
    }

    @Override
    public void printPerformanceMonthWise(HashMap<LocalDate, Integer> datePortValueTrack,
                                          int portfolioId, String startDate, String endDate) {
      log.append("28");
    }

    @Override
    public void printPerformanceYearWise(HashMap<LocalDate, Integer> datePortValueTrack,
                                         int portfolioId, String startDate, String endDate) {
      log.append("29");
    }
  }


}
