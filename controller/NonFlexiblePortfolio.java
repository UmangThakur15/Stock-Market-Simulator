package controller;

import model.PortfolioNonFlexible;
import view.View;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class implements all the methods of ControllerNonFlexible Interface
 * and methods from the abstractPortfolio abstract class.
 **/
public class NonFlexiblePortfolio extends AbstractPortfolioController implements
    ControllerNonFlexible {

  private final int userId;
  private final String userName;
  private final String userEmail;
  private final int portfolioId;

  private int portfolioOption;

  private ArrayList<String> tickerList;
  private Scanner sc;
  private String ticker;
  private int numOfStocks;


  /**
   * Constructor for the NonFlexiblePortfolio Class initializes
   * the userID,userName,userEmail and portfolioId.
   *
   * @param userId      Integer, UserId of the user
   * @param userName    String, UserName of the user
   * @param userEmail   String, Email address of the user
   * @param portfolioId Integer, Portfolio ID of the user
   */
  public NonFlexiblePortfolio(int userId, String userName,
                              String userEmail, int portfolioId) {
    this.userId = userId;
    this.userName = userName;
    this.userEmail = userEmail;
    this.portfolioId = portfolioId;
  }


  /**
   * This method is taking View Interface object, PortfolioNonFlexible Interface object and
   * Scanner Class object as argument.
   *
   * @param view  View, It takes object of view Interface as parameter
   * @param model PortfolioNonFlexible, It takes object
   *              of PortfolioNonFlexible Interface as parameter
   * @param sc    Scanner, It takes object of Scanner class as parameter.
   **/
  public void goNonFlexible(View view, PortfolioNonFlexible model, Scanner sc) {
    int option;
    String date;
    view.nonFlexiblePortAllOptions();
    option = sc.nextInt();
    int counter = 0;
    if (option == 0) {
      view.programClosed();
      return;
    }
    while (option != 0) {
      try {
        switch (option) {
          case 1: {
            if (counter == 0) {
              counter++;
              this.tickerList = getTickerNumber(view, sc);
              StringBuilder sb = new StringBuilder(model.addPortfolioByManualInput(this.userId,
                  this.userName, this.userEmail, this.portfolioId, this.tickerList));
              view.printString(sb);
            } else {
              view.invalidOption();
              return;
            }
            break;
          }
          case 2: {
            if (counter == 0) {
              counter++;
              StringBuilder sb = new StringBuilder(model.addPortfolioByFile(this.userId,
                  this.userName, this.userEmail, this.portfolioId, ""));
              view.printString(sb);
            } else {
              view.invalidOption();
              return;
            }
            break;
          }
          case 3: {
            StringBuilder sb = new StringBuilder(model.getComposition(this.userId,
                this.userName, this.userEmail, this.portfolioId));
            view.printString(sb);
            counter++;
            break;
          }
          case 4: {
            view.date();
            date = takeDate(view, sc);
            StringBuilder sb = new StringBuilder(model.portfolioValue(this.userId,
                this.userName,
                this.userEmail, this.portfolioId, date));
            view.printString(sb);
            counter++;
            break;
          }
          default: {
            view.invalidOption();
            return;
          }
        }
        view.nonFlexiblePortLimitedOption();
        option = sc.nextInt();
      } catch (IllegalArgumentException e) {
        view.printError(e.getMessage());
        return;
      } catch (ParseException e) {
        throw new RuntimeException(e);
      } catch (IOException e) {
        throw new RuntimeException(e);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    view.programClosed();
  }

}
