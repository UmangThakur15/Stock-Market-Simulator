package controller;


/**
 * This class implements all the methods mentioned
 * in the StockInfo Interface. T
 **/
public class StockInfoImpl implements StockInfo {

  private final String tickerNum;
  private final int volume;
  private final String date;


  /**
   * This is th constructor for StockInfoImpl class
   * which initializes the tickerNum, volume and date.
   *
   * @param tickerNum String, contains tickerNum
   * @param volume    Integer, contains volume
   * @param date      String, contains date
   */
  public StockInfoImpl(String tickerNum, int volume, String date) {
    this.tickerNum = tickerNum.toUpperCase();
    this.volume = volume;
    this.date = date;
  }

  @Override
  public String getTickerNum() {
    return tickerNum;
  }


  @Override
  public int getVolume() {
    return volume;
  }

  @Override
  public String getDate() {
    return date;
  }

}
