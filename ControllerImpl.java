package controller;

import model.PortfolioFlexible;
import model.PortfolioNonFlexible;
import view.View;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This is ControllerImpl Class for the implementation of
 * ControllerMain Interface. Methods mentioned in the
 * ControllerImpl class helps in interaction between Model and View.
 */

public class ControllerImpl implements ControllerMain {
  private final Scanner sc;

  private int option;

  private String date;
  private ArrayList<String> tickerList;
  private View view;
  private String ticker;
  private int numOfStocks;


  /**
   * Constructor for the ControllerImpl Class initializes the input stream.
   *
   * @param in InputStream, Contains the input.
   */

  public ControllerImpl(InputStream in) {

    sc = new Scanner(in);
  }


  @Override
  public void goStock(View view, PortfolioNonFlexible model, PortfolioFlexible newModel)
      throws InterruptedException {
    int userId;
    String userName;
    String userEmail;
    int portfolioId;
    int portfolioOption;
    view.printOutput(new StringBuilder("Welcome!"));
    view.printOutput(new StringBuilder("Please enter your user id"));
    userId = sc.nextInt();
    view.printOutput(new StringBuilder("Please enter your user name"));
    userName = sc.next();
    view.printOutput(new StringBuilder("Please enter your user email id"));
    userEmail = sc.next();
    view.printOutput(new StringBuilder("Please enter the portfolio Id"));
    portfolioId = sc.nextInt();
    view.printOutput(new StringBuilder("Please choose the type of stock"));
    view.printOutput(new StringBuilder("1. For Flexible"));
    view.printOutput(new StringBuilder("2. For non Flexible"));
    portfolioOption = sc.nextInt();
    ControllerFlexible flexible = null;
    ControllerNonFlexible nonFlexible = null;
    switch (portfolioOption) {
      case 1: {
        flexible = new FlexiblePortfolio(userId,
            userName, userEmail, portfolioId);
        flexible.goFlexible(view, newModel, sc);
        return;
      }
      case 2: {
        nonFlexible = new NonFlexiblePortfolio(userId,
            userName, userEmail, portfolioId);
        nonFlexible.goNonFlexible(view, model, sc);
        return;
      }
      case 0: {
        view.printOutput(new StringBuilder("Program closed while choosing portfolio option"));
        return;
      }
      default: {
        view.printOutput(new StringBuilder("Invalid Option Chosen while choosing portfolio"));
      }
    }

  }

}
