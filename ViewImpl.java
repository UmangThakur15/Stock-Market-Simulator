import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class implements the view interface.
 * It displays all the input and output related messages to the user and also takes
 * input from the user to create a portfolio,
 * get the composition of a particular portfolio,  get the value of particular
 * portfolio on a particular date and to display the saved portfolios.
 **/
public class ViewImpl implements View {

  private int userId;
  private String userName;
  private String user_email;
  private int portfolio_id;
  private int option;
  private String date;
  private ArrayList<String> tickerList;
  private PrintStream out;
  private Scanner sc;
  //private InputStream in;


  @Override
  public void setInputOutput(InputStream in, PrintStream out) {
    this.out = out;
    //this.in = in;
    sc = new Scanner(in);
  }


  @Override
  public void getInput() throws IllegalArgumentException, InterruptedException {
    this.out.println("Welcome!");
    this.out.println("Please enter your user id");
    userId = sc.nextInt();
    this.out.println("Please enter your user name");
    userName = sc.next();
    this.out.println("Please enter your user email id");
    user_email = sc.next();
    this.out.println("Please enter the portfolio Id");
    portfolio_id = sc.nextInt();
    this.out.println("Please select from below options");
    this.out.println("1: To Add a new Portfolio manually");
    this.out.println("2: To Add a new Portfolio using a file");
    this.out.println("3: To get Composition of Portfolio");
    this.out.println("4: Portfolio value on certain date");
    option = sc.nextInt();
    if (option < 1 && option > 4) {
      throw new IllegalArgumentException("Invalid option given");
    }
    if (option == 1) {
      this.tickerList = this.getTickerNumber();
    }

    if (option == 4) {
      this.date = this.takeDate();
    }


  }


  @Override
  public String takeDate() throws IllegalArgumentException {
    out.println("Please enter date in exact same format YYYY-MM-DD");
    String dateCurr = sc.next();
    return dateCurr;
  }


  @Override
  public ArrayList<String> getTickerList() {
    return this.tickerList;
  }


  @Override
  public String getDate() {
    return this.date;
  }

  @Override
  public int getUserId() {
    return this.userId;
  }

  @Override
  public String getUserName() {
    return this.userName;
  }


  @Override
  public String getUserEmail() {
    return this.user_email;
  }


  @Override
  public int getPortfolioId() {
    return this.portfolio_id;
  }


  @Override
  public int getOption() {
    return this.option;
  }

  @Override
  public void printOutput(StringBuilder sb) {
    this.out.println(sb.toString());
  }

  @Override
  public ArrayList<String> getTickerNumber() throws InterruptedException {
    ArrayList<String> tickerNumberData = new ArrayList<String>();
    String tickerNumber = "";
    int number_of_stocks = 0;
    int counterForAPITrack = 0;
    while (!tickerNumber.equals("exit")) {
      counterForAPITrack++;
      if (counterForAPITrack >= 5 && counterForAPITrack % 5 == 0) {
        out.println("Please wait for 10 sec");
        Thread.sleep(10000);
      }
      out.println("Please enter the ticker number for your stock");
      out.println("Please enter exit if you want to end");
      tickerNumber = sc.next();
      if (tickerNumber.equals("exit")) {
        return tickerNumberData;
      } else {
        tickerNumberData.add(tickerNumber);
      }
      out.println("Enter Number of Stocks");
      number_of_stocks = sc.nextInt();
      if (number_of_stocks < 0) {
        throw new IllegalArgumentException("You have entered invalid number of "
                + "stocks, kindly create the portfolio again");
      } else {
        tickerNumberData.add(String.valueOf(number_of_stocks));
      }

    }
    return tickerNumberData;
  }

  @Override
  public void printError(String s) {
    this.out.println(s);
  }


}
