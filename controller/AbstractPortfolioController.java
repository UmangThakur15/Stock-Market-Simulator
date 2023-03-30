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

  private StockInfo stocksObject;


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
    while (!tickerNumber.equals("exit")) {
      view.takeTickerSymbol();
      view.takeExit();
      tickerNumber = sc.next();
      if (tickerNumber.equals("exit")) {
        return tickerNumberData;
      }

      view.takeNumberOfStocks();
      try {
        number_of_stocks = sc.nextInt();
      } catch (InputMismatchException e) {
        throw new IllegalArgumentException("Number of stocks cannot be fraction");
      }
      if (number_of_stocks < 0) {
        throw new IllegalArgumentException("You have entered negative number of "
            + "stocks, kindly create the portfolio again");
      }

      //tickerNumberData.add(String.valueOf(number_of_stocks));
      view.date();
      String currDate = takeDate(view, sc);
      //tickerNumberData.add(currDate);
      stocksObject = new StockInfoImpl(tickerNumber, number_of_stocks, currDate);
      tickerNumberData.add(stocksObject.getTickerNum());
      tickerNumberData.add(String.valueOf(stocksObject.getVolume()));
      tickerNumberData.add(stocksObject.getDate());
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
   *                       and number of stocks entered.
   * @throws InterruptedException This exception occurs when a thread is interrupted
   *                              while it's waiting, sleeping, or otherwise occupied
   **/

  public ArrayList<String> getTickerNumber(View view, Scanner sc) throws InterruptedException {
    ArrayList<String> tickerNumberData = new ArrayList<String>();
    String tickerNumber = "";
    int number_of_stocks = 0;
    //  int counterForAPITrack = 0;
    while (!tickerNumber.equals("exit")) {
      view.takeTickerSymbol();
      view.takeExit();
      tickerNumber = sc.next();
      if (tickerNumber.equals("exit")) {
        return tickerNumberData;
      }
      view.takeNumberOfStocks();
      try {
        number_of_stocks = sc.nextInt();
      } catch (InputMismatchException e) {
        throw new IllegalArgumentException("Number of stocks cannot be fraction");
      }
      if (number_of_stocks < 0) {
        throw new IllegalArgumentException("You have entered invalid number of "
            + "stocks, kindly create the portfolio again");
      }
      stocksObject = new StockInfoImpl(tickerNumber, number_of_stocks, LocalDate.now().toString());
      tickerNumberData.add(stocksObject.getTickerNum());
      tickerNumberData.add(String.valueOf(stocksObject.getVolume()));
      tickerNumberData.add(stocksObject.getDate());
    }
    return tickerNumberData;
  }


  /**
   * This method takes the Arraylist of Ticker Number and number of stocks
   * as input and returns the ArrayList of the Ticker Data.
   *
   * @param view View, it is the object of View Interface
   * @param sc   Scanner, it is the object of Scanner Class
   * @return ArrayList  It returns the ArrayList of the Ticker number
   *                      and number of stocks entered.
   * @throws InterruptedException This exception occurs when a thread is interrupted
   *                              while it's waiting, sleeping, or otherwise occupied
   */

  public ArrayList<String> getTickerNumberDCA(View view, Scanner sc)
      throws InterruptedException {
    ArrayList<String> tickerNumberData = new ArrayList<String>();
    String tickerNumber = "";
    int number_of_stocks = 0;
    while (!tickerNumber.equals("exit")) {
      view.takeTickerSymbol();
      view.takeExit();
      tickerNumber = sc.next();
      if (tickerNumber.equals("exit")) {
        return tickerNumberData;
      }
      view.takeWeightage();
      try {
        number_of_stocks = sc.nextInt();
      } catch (InputMismatchException e) {
        throw new IllegalArgumentException("Fractional Weightage not allowed");
      }
      if (number_of_stocks < 0) {
        throw new IllegalArgumentException("You have entered "
            + "negative weightage that is not possible");
      }
      stocksObject = new StockInfoImpl(tickerNumber, number_of_stocks, null);
      tickerNumberData.add(stocksObject.getTickerNum());
      tickerNumberData.add(String.valueOf(stocksObject.getVolume()));
    }
    return tickerNumberData;
  }


  /**
   * This method takes the commission Fee from the user
   * and return the commission fee.
   *
   * @param view View   It is the object of View Interface
   * @param sc   Scanner  It is the object of Scanner Class
   * @return Double It returns the commission fee
   */
  public Double getCommissionFee(View view, Scanner sc) {
    view.commissionFee();
    Double commission = sc.nextDouble();
    return commission;
  }

}

