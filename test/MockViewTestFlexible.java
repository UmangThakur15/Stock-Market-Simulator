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
public class MockViewTestFlexible {


  @Test
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_2000
  // portfolio_data_2000.csv does not exist else it will throw an error
  public void testAddFileManualInputCorrectInput() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2000;
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

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123451230212220921222092122209212220921228117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  @Test
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on path : portfolio_data_2001
  // portfolio_data_2001.csv does not exist else it will throw an error
  public void testAddFileManualInputCorrectInput10S() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2001;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "12345123021222092122209212220921228117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  @Test
  public void testAddFileManualInputCorrectInvalidTicker()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2002;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "12345123021222092122209212210";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
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
    int portfolioOption = 1;
    int option = 2;

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator()
        + portfolioOption + System.lineSeparator() + option;


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123451210";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on path : portfolio_data_2003
  // portfolio_data_2003.csv does not exist else it will throw an error
  @Test
  public void testControllerAddDataByManualFileNewPort()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolioOption = 1;
    int portfolio_id = 2003;
    int option = 2;

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption + System.lineSeparator() + option
        + System.lineSeparator() + "0";


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "12345128117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
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
    int portfolioOption = 1;
    int option = 3;
    String date1 = "2022-11-11";

    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption + System.lineSeparator() + option + System.lineSeparator()
        + date1 + System.lineSeparator() + "0";


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123451298117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
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
    int portfolio_id = 2005;
    int option = 3;
    int portfolioOption = 1;

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption + System.lineSeparator() + option + System.lineSeparator() + "0";


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "1234512910";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  //Portfolio already exists, so please use a portfolio id that exists.
  // Please ensure exists portfolio_data_1.csv
  @Test
  public void testControllerGetPortfolioValue() throws IOException, InterruptedException {
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
        + option + System.lineSeparator() + portfolio_option
        + System.lineSeparator() + date + "0";


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123456";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
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
    int portfolio_option = 1;
    String date = "2022-10-30";

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + option + System.lineSeparator() + portfolio_option
        + System.lineSeparator() + date + "0";


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123456";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_1006
  // portfolio_data_1006.csv does not exist else it will throw an error
  public void testManualReUpload() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2006;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123451230212220921222092122209212220921228116";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  @Test
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_2007
  // portfolio_data_2007.csv does not exist else it will throw an error
  // all in one
  public void testManualUploadGetComposPortVal() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2007;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123451230212220921222092122209212220921228119811981198117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
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
    int portfolioOption = 1;
    int option1 = 3;
    String date = "2022-11-11";
    int option2 = 1;

    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption
        + System.lineSeparator() + option1 + System.lineSeparator() + date
        + System.lineSeparator() + option2;


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123451298116";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
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
    int portfolioOption = 1;
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
    String expectedLog = "123451298116";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_2008
  // portfolio_data_2008.csv does not exist else it will throw an error
  public void testManualUploadGetComposition() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2008;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "1234512302122209212220921222092122209212281198117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_2009
  // portfolio_data_2009.csv does not exist else it will throw an error
  public void testManualUploadPortVal() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2009;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "1234512302122209212220921222092122209212281198117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_1010
  // portfolio_data_1010.csv does not exist else it will throw an error
  public void testManualUploadANdInvalidOption() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2010;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123451230212220921222092122209212220921228116";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  @Test
  public void testModifyPortOnExistingPortfolioFutureDate() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 3;
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
    String date = "2022-11-22";

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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "1234512132122209212220921222092122209212281198117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  @Test
  public void testModifyPortOnExistingPortfolioAllPortfolio() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2012;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "1234512302122209212220921222092"
        + "1222092122811132122209212220921222092122209212281198117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "1234512132122209212220921222092122209212210";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "12345123021222010";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  public void sellStocksCurrDatePortfolioExistsGreaterThan() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2013;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123451230212220921222"
        + "0921222092122209212220921222092122209212220921222092122811212098112120910";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "12345122120910";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  public void sellStocksGreaterThanStocksInPortfolio() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2003;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "12345122120910";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  @Test
  public void sellStocksGivenDate() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2014;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "12345123021222092122209212"
        + "22092122209212220921222092122209212220"
        + "9212220921228112120981121209811169178117";

    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  @Test
  public void testCostBasisOnFutureDate() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 3;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "12345121691710";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "12345121691710";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
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

    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "1234512169178117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  @Test
  public void testCostBasis2() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2017;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123451230212220921222092122209212220921228119811169178117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  @Test
  public void testDailyPerformance() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2018;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123451230212220921222092"
        + "1222092122209212220921222092122209212220921222092122811141527117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());

  }

  @Test
  public void testDailyStartDateAfterFutureDate() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2019;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123451230212220921222092122209212220921222092"
        + "1222092122209212220921222092122811141510";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());

  }


  @Test
  public void testTwoDayPerformance() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2020;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "1234512302122209"
        + "2122209212220921222092122209212220921"
        + "22209212220921222092122811141527117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  public void testThreeDayPerformance() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2021;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123451230212220921222092122"
        + "2092122209212220921222092122209212220921222092122811141527117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  public void testWeekPerformance() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2022;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "12345123021222092122209212220"
        + "92122209212220921222092122209212220921222092122811141527117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  public void QuaterlyPerformance() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2023;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "1234512302122209212220"
        + "921222092122209212220921222092122209212220921222092122811141528117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  @Test
  public void YearlyPerformance() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2024;
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "12345123021222092122"
        + "20921222092122209212220921222092122209212220921222092122811141528117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  @Test
  public void testMultipleScenarioAllInOne() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 2025;
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
    // get composition
    int option3 = 3;
    String dateS1 = "2022-11-11";
    //    Portfolio Value
    int option4 = 4;
    String dateS2 = "2022-11-01";
    // ADD
    int option5 = 5;
    String tickerNumberModify1 = "NFLX";
    int numberOfStocksModify1 = 10;
    String dateModify1 = "2022-10-25";
    String tickerNumberModify2 = "MSFT";
    int numberOfStocksModify2 = 20;
    String dateModify2 = "2022-11-05";

    // Sell
    int option6 = 6;
    String sellTicker = "NFLX";
    int sellNum = 20;
    String sellDate = "2022-11-02";
    // Get Cost basis
    int option7 = 7;
    String dateCostBasis = "2022-10-30";
    // Performance
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


    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    String expectedLog = "123451230212220921222092122209212220921222"
        + "09212220921222092122209212220921228119811981"
        + "113212220921222092122811981198112120981116917811141527117";
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new LoggingView1(modelLog, new PrintStream(outStream));
    PortfolioNonFlexible m = new ModelImpl();
    PortfolioFlexible mn = new ModelImplFlexible();
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  class LoggingView1 implements View {
    private final StringBuilder log;
    private final PrintStream out;

    public LoggingView1(StringBuilder log, PrintStream out) {
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
