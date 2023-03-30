package model;


/**
 * This interface have loadData method
 * that is implemented by LoadData class
 * to load data to csv file.
 **/
public interface ILoadData {


  /**
   * This method takes userId, userName, userEmail, portfolioId,
   * timestamp, tickerNumber,numberOfStocks,close and currSharePrice
   * as parameter.
   *
   * @param userId         Integer, contains user ID
   * @param userName       String, contains username
   * @param userEmail      String, contains user Email
   * @param portfolioId    Integer, contains portfolio ID
   * @param timestamp      String, contains time stamp
   * @param tickerNumber   String, contains ticker Number
   * @param numberOfStocks Double, contains number of Stocks
   * @param close          Double, contains closing amount
   * @param currSharePrice Double, contains the current amount
   * @throws RuntimeException It is an exception raised when
   *                          an invalid object is passed.
   **/
  void loadData(int userId, String userName, String userEmail, int portfolioId,
                String timestamp, String tickerNumber,
                Double numberOfStocks, Double close,
                Double currSharePrice) throws RuntimeException;

}
