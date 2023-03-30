package controller;


/**
 * This interface has all the methods that
 * StockInfoImpl class implements to get the information
 * to create a portfolio.
 **/
public interface StockInfo {


  /**
   * This Method returns the ticker number to be added
   * to the portfolio.
   *
   * @return String It returns the ticker number
   **/
  String getTickerNum();


  /**
   * This Method returns the number of stocks to be added
   * to the portfolio.
   *
   * @return Integer, it returns the number of stocks
   */
  int getVolume();

  /**
   * The Method returns the date on which ticker number needs
   * to be added to the portfolio.
   *
   * @return String, it returns the date
   */
  String getDate();




}
