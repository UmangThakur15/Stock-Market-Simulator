package controller;

import model.PortfolioFlexible;
import model.PortfolioNonFlexible;
import view.View;


/**
 * This interface has goStock method which refers to the both
 * PortfolioNonFlexible class and PortfolioFlexible class.
 **/
public interface ControllerMain {


  /**
   * This method is taking View Interface object, PortfolioFlexible Interface object and
   * PortfolioNonFlexible Interface object as argument.
   *
   * @param view     View  It takes object of view Interface as parameter
   * @param model    PortfolioNonFlexible, It takes object of PortfolioNonFlexible
   *                 Interface as parameter
   * @param newModel PortfolioFlexible, It takes object of PortfolioFlexible
   *                 Interface as parameter
   * @throws InterruptedException This exception occurs when a thread
   *                              is interrupted while it's waiting,
   *                              sleeping, or otherwise occupied
   */
  void goStock(View view, PortfolioNonFlexible model, PortfolioFlexible newModel)
      throws InterruptedException;
}
