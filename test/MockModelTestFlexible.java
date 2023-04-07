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
 * present in the ModelImplFlexible Class.
 **/
public class MockModelTestFlexible {

  @Test
  public void testAddFileManualInputCorrectInput() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 3000;
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

    String expectedLog = "AA";
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

  public void testAddFileManualInputCorrectInput10S() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 3001;
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

    String expectedLog = "AA";
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
    int portfolioOption = 1;
    int portfolio_id = 3003;
    int option = 2;

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator() + user_email
        + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption + System.lineSeparator() + option
        + System.lineSeparator() + "0";

    String expectedLog = "AA";
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
    int portfolio_id = 3004;
    int portfolioOption = 1;
    int option = 2;

    String inputString = user_id + System.lineSeparator()
        + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id
        + System.lineSeparator()
        + portfolioOption + System.lineSeparator() + option
        + System.lineSeparator() + "0";

    String expectedLog = "AA";
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
    int portfolioOption = 1;
    int option = 3;
    String date1 = "2022-11-11";

    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption + System.lineSeparator() + option + System.lineSeparator()
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
        + portfolio_option + System.lineSeparator() + option + System.lineSeparator() + date
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
    int portfolio_id = 3006;
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

    String expectedLog = "AA";
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
    int portfolio_id = 3007;
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

    String expectedLog = "AAADACAC";
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
    int portfolioOption = 1;
    int option1 = 3;
    String date = "2022-11-11";
    int option2 = 1;

    String inputString = user_id + System.lineSeparator() + user_name + System.lineSeparator()
        + user_email + System.lineSeparator() + portfolio_id + System.lineSeparator()
        + portfolioOption
        + System.lineSeparator() + option1 + System.lineSeparator() + date
        + System.lineSeparator() + option2;

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
  public void testManualUploadGetComposition() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 3008;
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

    String expectedLog = "AAAD";
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
    int portfolio_id = 3009;
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

    String expectedLog = "AAAC";
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
  public void testManualUploadANdInvalidOption() throws IOException,
      InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 3010;
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

    String expectedLog = "AA";
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
  public void testModifyPortOnExistingPortfolioFutureDate()
      throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 4;
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

    String expectedLog = "AEAD";
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
  public void testModifyPortOnExistingPortfolioAllPortfolio() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 3012;
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

    String expectedLog = "AAAEAC";
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

    String expectedLog = "AEAD";
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
  public void testFractional() throws IOException, InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 3026;
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


  // Error check
  @Test
  public void sellStocksFutureDateDatePortfolioExists() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 3003;
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

    String expectedLog = "AF";
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

    String expectedLog = "AFAF";
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
  public void sellStocksGreaterThanStocksInPortfolio() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 3003;
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

    String expectedLog = "AFAF";
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
  public void sellStocksGivenDate() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 3014;
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


    String expectedLog = "AAAFAFAG";
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
  public void testCostBasisOnFutureDate() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 4;
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

    String expectedLog = "AG";
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

    String expectedLog = "AG";
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

    String expectedLog = "AG";
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
  public void testCostBasis2() throws InterruptedException {
    InputStream input = null;
    int user_id = 10;
    String user_name = "ABC";
    String user_email = "test@gmail.com";
    int portfolio_id = 3017;
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

    String expectedLog = "AAACAG";
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






