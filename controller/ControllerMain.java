package controller;


/**
 * This interface has goStock method which refers to the both
 * PortfolioNonFlexible class and PortfolioFlexible class.
 **/
public interface ControllerMain {


  /**
   * This method is taking View Interface object, PortfolioFlexible Interface object and
   * PortfolioNonFlexible Interface object as argument.
   *
   * @throws InterruptedException This exception occurs when a thread
   *                              is interrupted while it's waiting,
   *                              sleeping, or otherwise occupied
   */
  void goStock()
      throws InterruptedException;
}
