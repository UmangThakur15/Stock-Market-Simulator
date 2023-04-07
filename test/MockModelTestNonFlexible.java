import controller.ControllerImpl;
import controller.ControllerMain;
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
 * This class consists of all the tests to check the correctness of the methods
 * present in the ModelImpl Class.
 **/
public class MockModelTestNonFlexible {

  @Test
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on standard path : portfolio_data_50
  // portfolio_data_50.csv does not exist else it will throw an error
  public void testAddFileManualInputCorrectInput()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 50;
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

    String expectedLog = "A";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  @Test
  //Portfolio does not exist so new Portfolio will be created
  // Before running the test please ensure that on path : portfolio_data_51
  // portfolio_data_51.csv does not exist else it will throw an error
  public void testAddFileManualInputCorrectInput10S()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 51;
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

    String expectedLog = "A";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


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

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id
        + System.lineSeparator() + portfolioOption
        + System.lineSeparator()
        + option
        + System.lineSeparator() + tickerNumber1 + System.lineSeparator()
        + numberOfStocks1 + System.lineSeparator()
        + tickerNumber2 + System.lineSeparator() + numberOfStocks2
        + System.lineSeparator() + "exit" + System.lineSeparator() + "0";

    String expectedLog = "A";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
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
    int portfolio_id = 53;
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

    String expectedLog = "A";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

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

    String expectedLog = "B";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  public void testControllerAddDataByManualFileInvalidTicker()
      throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 1;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 54;
    int portfolioOption = 2;
    int option = 2;

    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption + System.lineSeparator() + option + System.lineSeparator() + "0";

    String expectedLog = "B";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());

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

    String expectedLog = "C";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


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


    String expectedLog = "C";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
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


    String expectedLog = "D";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
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

    String expectedLog = "";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  public void testManualReUpload() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 55;
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

    String expectedLog = "A";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }

  @Test
  public void testManualUploadGetComposPortVal() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 56;
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

    String expectedLog = "ACDD";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test

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


    String expectedLog = "C";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
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


    String expectedLog = "D";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  public void testManualUploadGetComposition() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 57;
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

    String expectedLog = "AC";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  public void testManualUploadPortVal() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 58;
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

    String expectedLog = "AD";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


  @Test
  public void testManualUploadANdInvalidOption() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 59;
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

    String expectedLog = "A";
    input = new ByteArrayInputStream(inputString.getBytes());
    StringBuilder modelLog = new StringBuilder();
    OutputStream outStream = new ByteArrayOutputStream();
    View v = new ViewImpl(new PrintStream(outStream));
    PortfolioNonFlexible m = new MockModelNonFlexible(modelLog);
    PortfolioFlexible mn = new MockModelFlexible(modelLog);
    ControllerMain c = new ControllerImpl(input, mn, m, v);
    c.goStock();
    assertEquals(expectedLog, modelLog.toString());
  }


}

