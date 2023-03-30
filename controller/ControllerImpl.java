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
  private final View view;
  private final PortfolioFlexible newModel;
  private final PortfolioNonFlexible model;
  private int option;
  private String date;
  private ArrayList<String> tickerList;
  private String ticker;
  private int numOfStocks;

  /**
   * Constructor for the ControllerImpl Class initializes the input stream.
   *
   * @param in InputStream, Contains the input.
   */


  public ControllerImpl(InputStream in, PortfolioFlexible newModel,
                        PortfolioNonFlexible model, View view) {
    this.newModel = newModel;
    this.model = model;
    this.view = view;
    this.sc = new Scanner(in);
  }


  @Override
  public void goStock()
      throws InterruptedException {
    int userId;
    String userName;
    String userEmail;
    int portfolioId;
    int portfolioOption;
    view.takeUserId();
    userId = sc.nextInt();
    view.takeUserName();
    userName = sc.next();
    view.takeUserEmail();
    userEmail = sc.next();
    view.takePortfolioId();
    portfolioId = sc.nextInt();
    view.takePortfolioType();
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
      default: {
        view.invalidOption();
      }
    }
  }

}
