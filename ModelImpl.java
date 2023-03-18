package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * This Class implements all the methods mentioned in the PortfolioNonFlexible interface
 * and methods in AbstractPortfolio class,
 * it performs operations required to create
 * a portfolio ,calculate the value of the portfolio, review the saved
 * portfolio and show the composition of particular
 * portfolio based on the user inputs and result
 * is sent back to view via controller without any direct interaction between view and model.
 **/

public class ModelImpl
    extends AbstractPortfolio
    implements PortfolioNonFlexible {

  @Override
  public StringBuilder portfolioValue(int userId, String userName, String userEmail,
                                      int portfolioId, String date)
      throws InterruptedException, IOException, ParseException {
    boolean portIdCheck = portfolioExists(portfolioId);
    if (!portIdCheck) {
      throw new IllegalArgumentException("Portfolio id does not exist");
    }
    LocalDate inputDate;
    try {
      inputDate = LocalDate.parse(date);
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Invalid Date format");
    }
    // inputDate = checkForMonday(inputDate);
    //date = isWeekend(inputDate).toString();
    inputDate = checkForDay(inputDate);
    if (inputDate.compareTo(LocalDate.now()) > 0) {
      throw new IllegalArgumentException("future date not possible");
    }
    date = inputDate.toString();

    if (inputDate.compareTo(LocalDate.now()) > 0) {
      throw new IllegalArgumentException("Date is greater than "
          + "today we cannot predict future values");
    }

    String fileName = "portfolio_data_" + portfolioId + ".csv";
    BufferedReader br = null;
    String line = "";
    ArrayList<String> sb = new ArrayList<String>();
    Double valueOfPortfolio = 0.00;
    HashMap<String, Integer> map = new HashMap<>();
    br = new BufferedReader(new FileReader(fileName));
    String headerLine = br.readLine();
    while ((line = br.readLine()) != null) {
      String[] tickerNumbers = line.split(",");
      String tickerNum = tickerNumbers[5];
      int numberOfStocks = Integer.valueOf(tickerNumbers[6]);
      if (numberOfStocks > 0) {
        valueOfPortfolio += numberOfStocks * getClosingValueOnSpecificDate(tickerNum, date);
      }
    }
    return new StringBuilder("$" + valueOfPortfolio);
  }

  @Override
  public StringBuilder getComposition(int userId, String userName, String userEmail,
                                      int portfolioId) throws IOException {

    Boolean portIdCheck = portfolioExists(portfolioId);
    if (!portIdCheck) {
      throw new IllegalArgumentException("Portfolio does not exist");
    }
    String fileName = "portfolio_data_" + portfolioId + ".csv";
    BufferedReader br = null;
    String line = "";
    br = new BufferedReader(new FileReader(fileName));
    String headerLine = br.readLine();
    StringBuilder sb = new StringBuilder();
    while ((line = br.readLine()) != null) {
      String[] tickerNumbers = line.split(",");
      if (Integer.valueOf(tickerNumbers[6]) > 0) {
        LocalDate portDate;
        if (tickerNumbers[4].contains("/")) {
          portDate = stringDateToLocalDate(tickerNumbers[4], "M/d/yy");
        } else {
          portDate = stringDateToLocalDate(tickerNumbers[4], "yyyy-MM-dd");
        }
        String date1 = portDate.toString();

        sb.append(tickerNumbers[0] + " ");
        sb.append(tickerNumbers[1] + " ");
        sb.append(tickerNumbers[2] + " ");
        sb.append(tickerNumbers[3] + " ");
        sb.append(date1 + " ");
        sb.append(tickerNumbers[5] + " ");
        sb.append(tickerNumbers[6] + " ");
        sb.append(System.lineSeparator());
      }
    }
    sb.insert(0, System.lineSeparator());
    sb.insert(0, "UId UName UEId PortId Date Ticker NumStocks");
    return sb;
  }
}
