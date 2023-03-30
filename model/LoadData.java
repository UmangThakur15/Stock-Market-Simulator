package model;


import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * This class implements all the methods
 * mentioned in the ILoadData interface.
 * It is loading data to csv file.
 **/
public class LoadData implements ILoadData {

  @Override
  public void loadData(int userId, String userName, String userEmail, int portfolioId,
                       String timestamp, String tickerNumber,
                       Double numberOfStocks, Double close,
                       Double currSharePrice) throws RuntimeException {
    String fileName = "portfolio_data_" + portfolioId + ".csv";
    try {
      File file = new File(fileName);
      if (file.exists()) {
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        String sb = userId
            + ","
            + userName
            + ","
            + userEmail
            + ","
            + portfolioId
            + ","
            + timestamp
            + ","
            + tickerNumber
            + ","
            + numberOfStocks
            + ","
            + close
            + ","
            + currSharePrice;
        bw.newLine();
        pw.write(sb);
        pw.close();
      } else {
        PrintWriter pw = new PrintWriter(new File(fileName));
        String sb = "User Id"
            + ","
            + "User name"
            + ","
            + "User email"
            + ","
            + "Portfolio Id"
            + ","
            + "Date"
            + ","
            + "Ticker Number"
            + ","
            + "Number of Stocks"
            + ","
            + "Current Stock Price"
            + ","
            + "Sum of Stocks"
            + System.lineSeparator()
            + userId
            + ","
            + userName
            + ","
            + userEmail
            + ","
            + portfolioId
            + ","
            + timestamp
            + ","
            + tickerNumber
            + ","
            + numberOfStocks
            + ","
            + close
            + ","
            + currSharePrice;
        pw.write(sb);
        pw.close();
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}