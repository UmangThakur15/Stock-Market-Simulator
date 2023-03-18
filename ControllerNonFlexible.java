package controller;

import model.PortfolioNonFlexible;
import view.View;

import java.util.Scanner;


/**
 * This interface has the go method which is being used to refer to the NonFlexiblePortfolio Class.
 **/
public interface ControllerNonFlexible {


  /**
   * This method is taking View Interface object, PortfolioNonFlexible Interface object and
   * Scanner Class object as argument.
   *
   * @param view  View, It takes object of view Interface as parameter
   * @param model PortfolioNonFlexible,It takes object of PortfolioNonFlexible
   *              Interface as parameter
   * @param sc    Scanner,It takes object of Scanner class as parameter.
   **/
  void goNonFlexible(View view, PortfolioNonFlexible model, Scanner sc);
}
