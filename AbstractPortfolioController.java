package controller;

import view.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * This is the abstract class for the Controller that has all
 * the common methods of the FlexiblePortfolio Class and NonFlexiblePortfolio.
 **/


public abstract class AbstractPortfolioController {

  private int userId;
  private String userName;
  private String user_email;
  private int portfolio_id;
  private int option;
  private int portfolioOption;
  private String date;
  private ArrayList<String> tickerList;
  private Scanner sc;
  private View view;
  private String ticker;
  private int numOfStocks;


  /**
   * This method takes date as input from the user in YYYY-MM-DD format.
   *
   * @param view View, it is the object of View Interface
   * @param sc   Scanner, it is the object of Scanner Class
   * @return dateCurr  It returns the date entered by the user
   * @throws IllegalArgumentException This exception occurs when an argument passed to a
   *                                  method doesn't fit within the logic of the usage of argument
   **/


  public String takeDate(View view, Scanner sc) throws IllegalArgumentException {
    view.printOutput(new
        StringBuilder("Please enter date in exact same format YYYY-MM-DD"));
    String dateCurr = sc.next();
    return dateCurr;
  }


  /**
   * This method takes Ticker number, number of stocks and date as input from the user
   * and returns the ArrayList of Ticker number, number of stocks and date entered.
   *
   * @param view View, it is the object of View Interface
   * @param sc   Scanner, it is the object of Scanner Class
   * @return ArrayList It returns the ArrayList of Ticker number, number of stocks and date entered
   * @throws InterruptedException This exception occurs when a thread is interrupted while
   *                              it's waiting, sleeping, or otherwise occupied
   **/

  public ArrayList<String> getTickerNumberDateWise(View view, Scanner sc)
      throws InterruptedException {
    ArrayList<String> tickerNumberData = new ArrayList<String>();
    String tickerNumber = "";
    int number_of_stocks = 0;
    // int counterForAPITrack = 0;
    while (!tickerNumber.equals("exit")) {
      //counterForAPITrack++;
      // if (counterForAPITrack >= 5 && counterForAPITrack % 5 == 0) {
      //   view.printOutput(new StringBuilder("Please wait for 10 sec"));
      //    Thread.sleep(10000);
      // }
      view.printOutput(new StringBuilder("Please enter the ticker number for your stock"));
      view.printOutput(new StringBuilder("Please enter exit if you want to end"));
      tickerNumber = sc.next();
      if (tickerNumber.equals("exit")) {
        return tickerNumberData;
      } else {
        tickerNumberData.add(tickerNumber);
      }
      view.printOutput(new StringBuilder("Enter Number of Stocks"));
      try {
        number_of_stocks = sc.nextInt();
      } catch (InputMismatchException e) {
        throw new IllegalArgumentException("Number of stocks cannot be fraction");
      }
      if (number_of_stocks < 0) {
        throw new IllegalArgumentException("You have entered negative number of "
            + "stocks, kindly create the portfolio again");
      }

      tickerNumberData.add(String.valueOf(number_of_stocks));

      String currDate = takeDate(view, sc);
      tickerNumberData.add(currDate);
    }
    return tickerNumberData;
  }


  /**
   * This method takes Ticker number and number of stocks as input
   * and returns the ArrayList of the Ticker number
   * and number of stocks entered.
   *
   * @param view View, it is the object of View Interface
   * @param sc   Scanner, it is the object of Scanner Class
   * @return ArrayList  It returns the ArrayList of the Ticker number
   *          and number of stocks entered.
   * @throws InterruptedException This exception occurs when a thread is interrupted
   *                              while it's waiting, sleeping, or otherwise occupied
   **/

  public ArrayList<String> getTickerNumber(View view, Scanner sc) throws InterruptedException {
    ArrayList<String> tickerNumberData = new ArrayList<String>();
    String tickerNumber = "";
    int number_of_stocks = 0;
    //  int counterForAPITrack = 0;
    while (!tickerNumber.equals("exit")) {
      view.printOutput(new StringBuilder("Please enter the ticker number for your stock"));
      view.printOutput(new StringBuilder("Please enter exit if you want to end"));
      tickerNumber = sc.next();
      if (tickerNumber.equals("exit")) {
        return tickerNumberData;
      } else {
        tickerNumberData.add(tickerNumber);
      }
      view.printOutput(new StringBuilder("Enter Number of Stocks"));
      try {
        number_of_stocks = sc.nextInt();
      } catch (InputMismatchException e) {
        throw new IllegalArgumentException("Number of stocks cannot be fraction");
      }
      if (number_of_stocks < 0) {
        throw new IllegalArgumentException("You have entered invalid number of "
            + "stocks, kindly create the portfolio again");
      } else {
        tickerNumberData.add(String.valueOf(number_of_stocks));
      }
      tickerNumberData.add(LocalDate.now().toString());
    }
    return tickerNumberData;
  }

}
