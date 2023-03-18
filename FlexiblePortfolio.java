package controller;


import model.PortfolioFlexible;
import view.View;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class implements all the methods of ControllerFlexible
 * Interface and methods from the abstractPortfolio
 * abstract class.
 **/
public class FlexiblePortfolio extends AbstractPortfolioController implements ControllerFlexible {
  private final int userId;
  private final String userName;
  private final String userEmail;
  private final int portfolioId;

  private int portfolioOption;

  private ArrayList<String> tickerList;
  private Scanner sc;


  /**
   * Constructor for the FlexiblePortfolio Class initializes
   * the userID,userName,userEmail and portfolioId.
   *
   * @param userId      Integer, UserId of the user
   * @param userName    String, UserName of the user
   * @param userEmail   String, Email address of the user
   * @param portfolioId Integer, Portfolio ID of the user
   */
  public FlexiblePortfolio(int userId, String userName, String userEmail, int portfolioId) {
    this.userId = userId;
    this.userName = userName;
    this.userEmail = userEmail;
    this.portfolioId = portfolioId;
  }


  /**
   * This method is taking View Interface object, PortfolioFlexible Interface object and
   * Scanner Class object as argument.
   *
   * @param view     View, It takes object of view Interface as parameter
   * @param newModel PortfolioFlexible, It takes object of PortfolioFlexible Interface as parameter
   * @param sc       Scanner, It takes object of Scanner class as parameter.
   **/
  public void goFlexible(View view, PortfolioFlexible newModel, Scanner sc) {
    int option;
    String date;
    String ticker;
    int numOfStocks;
    view.printOutput(new StringBuilder("Please select from below options"));
    view.printOutput(new StringBuilder("1: To Add a new Portfolio manually"));
    view.printOutput(new StringBuilder("2: To Add a new Portfolio using a file"));
    view.printOutput(new StringBuilder("3: To get Composition of Portfolio"));
    view.printOutput(new StringBuilder("4: Portfolio value on certain date"));
    view.printOutput(new StringBuilder("5: Purchase a stock in existing portfolio"));
    view.printOutput(new StringBuilder("6: Sell a stock in existing portfolio"));
    view.printOutput(new StringBuilder("7: Determine cost basis"));
    view.printOutput(new StringBuilder("8: Portfolio Performance"));
    view.printOutput(new StringBuilder("Press zero to exit"));
    option = sc.nextInt();
    int counter = 0;
    if (option == 0) {
      view.printOutput(new StringBuilder("Program closed at the beginning"));
      return;
    }
    while (option != 0) {
      try {
        switch (option) {
          case 1: {
            if (counter == 0) {
              counter++;
              this.tickerList = getTickerNumberDateWise(view, sc);
              StringBuilder sb = new StringBuilder(newModel.addPortfolioByManualInput(this.userId,
                  this.userName, this.userEmail, this.portfolioId, this.tickerList));
              view.printOutput(sb);
            } else {
              view.printOutput(new StringBuilder("Invalid option as "
                  + "you cannot upload portfolio twice"));
              return;
            }
            break;
          }
          case 2: {
            if (counter == 0) {
              counter++;
              StringBuilder sb = new StringBuilder(newModel.addPortfolioByFile(this.userId,
                  this.userName, this.userEmail, this.portfolioId));
              view.printOutput(sb);
            } else {
              view.printOutput(new StringBuilder("Invalid option as you cannot "
                  + "upload portfolio twice"));
              return;
            }
            break;
          }
          case 3: {
            date = takeDate(view, sc);
            StringBuilder sb = new StringBuilder(newModel.getComposition(this.userId,
                this.userName, this.userEmail, this.portfolioId, date));
            view.printOutput(sb);
            counter++;
            break;
          }
          case 4: {
            date = this.takeDate(view, sc);
            StringBuilder sb = new StringBuilder(newModel.portfolioValue(this.userId,
                this.userName,
                this.userEmail, this.portfolioId, date));
            view.printOutput(sb);
            counter++;
            break;
          }
          case 5: {
            this.tickerList = getTickerNumberDateWise(view, sc);
            StringBuilder sb = new StringBuilder(newModel.modifyPortfolioByAdding(this.userId,
                this.userName, this.userEmail, this.portfolioId, this.tickerList));
            view.printOutput(sb);
            counter++;
            break;
          }
          case 6: {
            view.printOutput(new StringBuilder("Please enter the Ticker"
                + " Number you want to sell"));
            ticker = sc.next();
            view.printOutput(new StringBuilder("Please enter the number"
                + " of stocks you want to sell"));
            numOfStocks = sc.nextInt();
            date = takeDate(view, sc);
            StringBuilder sb = new StringBuilder(newModel.sellStocks(this.userId,
                this.userName, this.userEmail, this.portfolioId, ticker, numOfStocks,
                date));
            view.printOutput(sb);
            counter++;
            break;
          }
          case 7: {
            date = this.takeDate(view, sc);
            StringBuilder sb = new StringBuilder(newModel.getCostBasis(this.userId,
                this.userName,
                this.userEmail, this.portfolioId, date));
            view.printOutput(sb);
            counter++;
            break;
          }
          case 8: {
            String date1 = takeDate(view, sc);
            String date2 = takeDate(view, sc);
            StringBuilder sb = new StringBuilder(newModel.portfolioPerformance(this.userId,
                this.userName,
                this.userEmail, this.portfolioId, date1, date2));
            view.printOutput(sb);
            counter++;
            break;
          }
          default: {
            view.printOutput(new StringBuilder("Invalid option chosen"));
            return;
          }
        }
        view.printOutput(new StringBuilder("Please select from below options"));
        view.printOutput(new StringBuilder("3: To get Composition of Portfolio"));
        view.printOutput(new StringBuilder("4: Portfolio value on certain date"));
        view.printOutput(new StringBuilder("5: Purchase a stock in existing portfolio"));
        view.printOutput(new StringBuilder("6: Sell a stock in existing portfolio"));
        view.printOutput(new StringBuilder("7: Determine cost basis"));
        view.printOutput(new StringBuilder("8: Portfolio Performance"));
        view.printOutput(new StringBuilder("Please enter zero to exit"));
        option = sc.nextInt();
      } catch (IllegalArgumentException | InterruptedException e) {
        view.printError(e.getMessage());
        return;
      } catch (ParseException e) {
        throw new RuntimeException(e);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    view.printOutput(new StringBuilder("Program closed"));
  }
}
