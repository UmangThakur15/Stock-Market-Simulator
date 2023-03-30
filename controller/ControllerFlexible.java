package controller;


import model.PortfolioFlexible;
import view.View;

import java.util.Scanner;


/**
 * This interface has the go method which is being used
 * to refer to the FlexiblePortfolio Class.
 **/

public interface ControllerFlexible {


  /**
   * This method is taking View Interface object, PortfolioFlexible Interface object and
   * Scanner Class object as argument.
   *
   * @param view     View  It takes object of view Interface as parameter
   * @param newModel PortfolioFlexible,It takes object of PortfolioFlexible Interface as parameter
   * @param sc       Scanner,It takes object of Scanner class as parameter.
   */
  void goFlexible(View view, PortfolioFlexible newModel, Scanner sc);
}
