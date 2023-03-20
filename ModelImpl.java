import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This Class implements all the methods mentioned in the Model interface,
 * it performs operations required to create
 * a portfolio ,calculate the value of the portfolio, review the saved
 * portfolio and show the composition of particular
 * portfolio based on the user inputs and result
 * is sent back to view via controller without any direct interaction between view and model.
 **/

public class ModelImpl implements Model {
  // option 1
  @Override
  public StringBuilder addPortfolioByManualInput(int userId,
                                                 String userName, String userEmail,
                                                 int portfolioId, ArrayList<String> tickerNumData)
          throws InterruptedException {
    ApiAccessData ap = new ApiAccessData();
    LoadData ld = new LoadData();
    Double total_share_price = Double.valueOf(0);
    Double curr_share_price = Double.valueOf(0);
    String tickerNumber = "";
    int numberOfStocks = 0;
    boolean portIdCheck = checkForUniquePortfolio(portfolioId);
    if (!portIdCheck) {
      throw new IllegalArgumentException("Please enter valid portfolio id, "
              + "as currently added portfolio id already exists");
    }
    for (int i = 0; i < tickerNumData.size() - 1; i = i + 2) {
      tickerNumber = tickerNumData.get(i);
      numberOfStocks = Integer.parseInt(tickerNumData.get(i + 1));

      ap.apiAccess(tickerNumber);
      curr_share_price = numberOfStocks * ap.getClose();
      LoadData.loadData(userId, userName, userEmail, portfolioId,
              ap.getTimestamp(), tickerNumber,
              numberOfStocks, ap.getClose(), curr_share_price);
    }
    return new StringBuilder("Portfolio created successfully");
  }


  @Override
  public StringBuilder addPortfolioByFile(int userId, String userName,
                                          String userEmail, int portfolioId) throws IOException {
    LoadData ld = new LoadData();
    ApiAccessData ap = new ApiAccessData();
    boolean portfolioIdCheck = checkForUniquePortfolio(portfolioId);
    if (!portfolioIdCheck) {
      throw new IllegalArgumentException("Please enter valid portfolio id,"
              + " as currently added portfolio id already exists");
    }
    Scanner sc;
    try {
      sc = new Scanner(new File("portfolio_data_to_be_loaded.csv"));
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException("File not found");
    }
    BufferedReader br = new BufferedReader(new FileReader("portfolio_data_to_be_loaded.csv"));
    String line;
    int count = 0;
    while ((line = br.readLine()) != null) {
      count++;
      if (count > 1) {
        String[] cols = line.split(",");
        ap.apiAccess(cols[0]);

        LoadData.loadData(userId, userName, userEmail, portfolioId,
                String.valueOf(java.time.LocalDate.now()),
                cols[0], Integer.parseInt(cols[1]), ap.getClose(),
                ap.getClose() * Integer.parseInt(cols[1]));
      }
    }
    sc.close();
    return new StringBuilder("Portfolio added");
  }


  //option 3
  @Override
  public StringBuilder getComposition(int userId, String userName, String userEmail,
                                      int portfolioId) throws FileNotFoundException {

    Boolean checkFile = checkForUniquePortfolio(portfolioId);
    StringBuilder sb = new StringBuilder();
    if (!checkFile) {
      LoadData ld = new LoadData();
      String fileName = "portfolio_data_" + portfolioId + ".csv";
      Scanner s = new Scanner(new File(fileName));
      s.useDelimiter(",");
      while (s.hasNext()) {
        String str = s.next();
        sb.append(str + " ");
      }

      return sb;
    } else {
      throw new IllegalArgumentException("Portfolio does not exist");
    }
  }

  @Override
  //option 4
  public StringBuilder portfolioValue(int userId, String userName, String userEmail,
                                      int portfolioId, String date)
          throws InterruptedException, IOException {
    Boolean checkFile = checkForUniquePortfolio(portfolioId);
    if (checkFile) {
      throw new IllegalArgumentException("Portfolio does not exist");
    }
    String fileName = "portfolio_data_" + portfolioId + ".csv";
    BufferedReader br = null;
    String line = "";
    int toContinue = 1;
    ArrayList<String> sb = new ArrayList<String>();
    StringBuilder output = new StringBuilder();

    br = new BufferedReader(new FileReader(fileName));
    String headerLine = br.readLine();
    while ((line = br.readLine()) != null) {
      String[] tickerNumbers = line.split(",");
      sb.add(tickerNumbers[5]);
      sb.add(tickerNumbers[6]);
    }

    for (int i = 0; i < sb.size(); i = i + 2) {
      String tickerNum = sb.get(i);
      int numberOfStocks = Integer.parseInt(sb.get(i + 1));
      if (i > 10 && i % 4 == 0) {
        Thread.sleep(10000);
      }
      output.append(getSpecifcValue(tickerNum, numberOfStocks, date,
              userId, userName, userEmail, portfolioId));
      if (output.length() == 0) {
        return new StringBuilder();
      }
    }

    output.insert(0, "userId userName userEmail portfolioId Date"
            + " TickerNumber NumberOfStocks ClosingAmount PortfolioAmount \n");
    return output;

  }


  // helper
  private boolean checkForUniquePortfolio(int portfolioId) {
    String fileName = "portfolio_data_" + portfolioId + ".csv";
    File file = new File(fileName);
    return !file.exists();
  }


  private StringBuilder getSpecifcValue(String tickerNum, int numberOfStocks, String date,
                                        int userId, String userName, String userEmail,
                                        int portfolioId) {
    ApiAccessData ap = new ApiAccessData();
    String fileName = ap.apiAccessSpecificDate(tickerNum);
    BufferedReader br = null;
    String line = "";
    Double close = Double.valueOf(0);
    boolean print = false;
    StringBuilder output = new StringBuilder();
    ArrayList<String> sb = new ArrayList<String>();
    try {
      br = new BufferedReader(new FileReader(fileName));
      String headerLine = br.readLine();

      while ((line = br.readLine()) != null) {
        String[] tickerNumbers = line.split(",");
        sb.add(tickerNumbers[0]);
        sb.add(tickerNumbers[4]);
      }

      for (int i = 0; i < sb.size(); i = i + 2) {
        if (date.equals(sb.get(i))) {
          close = Double.parseDouble(sb.get(i + 1));
          print = true;
          break;
        }
      }

      if (print) {
        output.append(userId + " ");
        output.append(userName + " ");
        output.append(userEmail + " ");
        output.append(portfolioId + " ");
        output.append(date + " ");
        output.append(tickerNum + " ");
        output.append(numberOfStocks + " ");
        output.append(close + " ");
        output.append(numberOfStocks * close);
        output.append("\r\n");


        return output;
      } else {
        throw new IllegalArgumentException("Incorrect date has been input");
      }

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


}
