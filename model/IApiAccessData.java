package model;


/**
 * This interface has apiAccessSpecificDate  method that is
 * implemented by ApiAccessData class and is used to access the
 * API.
 **/
public interface IApiAccessData {


  /**
   * This method is taking tickerNumber as parameter and
   * returning the updated stock value for the passed ticker number.
   *
   * @param tickerNumber String, contains tickerNumber
   * @return String , it returns the updated stock value
   *                  for the specific tickerNumber
   */
  String apiAccessSpecificDate(String tickerNumber);

}
