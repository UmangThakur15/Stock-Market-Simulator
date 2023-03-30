package controller;


import model.PortfolioFlexible;
import view.View;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


/**
 * This class implements all the methods of ControllerFlexible
 * Interface and methods from the abstractPortfolio
 * abstract class.
 **/
public class FlexiblePortfolio
    extends AbstractPortfolioController
    implements ControllerFlexible {
  private final int userId;
  private final String userName;
  private final String userEmail;
  private final int portfolioId;


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
  public FlexiblePortfolio(int userId, String userName,
                           String userEmail, int portfolioId) {
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
    int optionExistingPort;
    int optionCreatePort;
    int optionCommissionFee;
    String date;
    String ticker;
    int numOfStocks;
    view.flexiblePortAllOptions();
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
              view.flexibleDollarCostAverageLimited();
              optionCreatePort = sc.nextInt();
              switch (optionCreatePort) {
                case 1: {
                  this.tickerList = getTickerNumberDateWise(view, sc);
                  StringBuilder sb = new StringBuilder(
                      newModel.addPortfolioByManualInput(this.userId,
                          this.userName, this.userEmail, this.portfolioId, this.tickerList));
                  view.printString(sb);
                  break;
                }
                case 2: {
                  view.totalAmountToBeInvested();
                  Double amount = sc.nextDouble();
                  view.startDate();
                  String startDate = takeDate(view, sc);
                  view.endDateWithEmpty();
                  String endDate = takeDate(view, sc);
                  this.tickerList = getTickerNumberDCA(view, sc);
                  view.takeFrequency();
                  int days = sc.nextInt();
                  if (endDate.equals("n")) {
                    StringBuilder sb = new
                        StringBuilder(newModel.createPortfolioDollarAverageLogicWithEndDate(
                        this.userId,
                        this.userName, this.userEmail, this.portfolioId, this.tickerList,
                        amount, days,
                        startDate, LocalDate.now().minusDays(2).toString()));
                    view.printString(sb);
                    break;
                  } else {
                    StringBuilder sb = new StringBuilder(
                        newModel.createPortfolioDollarAverageLogicWithEndDate(this.userId,
                            this.userName, this.userEmail, this.portfolioId, this.tickerList,
                            amount, days,
                            startDate, endDate));
                    view.printString(sb);
                    break;
                  }
                }
                default: {
                  view.invalidOption();
                  return;
                }
              }
            } else {
              view.invalidOption();
              return;
            }
            break;
          }
          case 2: {
            if (counter == 0) {
              counter++;
              StringBuilder sb = new StringBuilder(newModel.addPortfolioByFile(this.userId,
                  this.userName, this.userEmail, this.portfolioId, ""));
              view.printString(sb);
            } else {
              view.invalidOption();
              return;
            }
            break;
          }
          case 3: {
            view.date();
            date = takeDate(view, sc);
            StringBuilder sb = new StringBuilder(newModel.getComposition(this.userId,
                this.userName, this.userEmail, this.portfolioId, date));
            view.printString(sb);
            counter++;
            break;
          }
          case 4: {
            view.date();
            date = this.takeDate(view, sc);
            StringBuilder sb = new StringBuilder(newModel.portfolioValue(this.userId,
                this.userName,
                this.userEmail, this.portfolioId, date));
            view.printString(sb);
            counter++;
            break;
          }
          case 5: {
            view.flexibleDollarCostAverage();
            optionExistingPort = sc.nextInt();
            switch (optionExistingPort) {
              case 1: {
                this.tickerList = getTickerNumberDateWise(view, sc);
                StringBuilder sb = new
                    StringBuilder(newModel.modifyPortfolioByAdding(this.userId,
                    this.userName, this.userEmail, this.portfolioId, this.tickerList));
                view.printString(sb);
                counter++;
                break;
              }
              case 2: {
                view.totalAmountToBeInvested();
                Double amount = sc.nextDouble();
                view.startDate();
                String startDate = takeDate(view, sc);
                view.endDateWithEmpty();
                String endDate = takeDate(view, sc);
                this.tickerList = getTickerNumberDCA(view, sc);
                view.takeFrequency();
                int days = sc.nextInt();
                if (endDate.equals("n")) {
                  StringBuilder sb = new StringBuilder(
                      newModel.createPortfolioDollarAverageLogicWithEndDate(this.userId,
                          this.userName, this.userEmail, this.portfolioId, this.tickerList,
                          amount, days,
                          startDate, LocalDate.now().minusDays(2).toString()));
                  view.printString(sb);
                } else {
                  StringBuilder sb = new StringBuilder(
                      newModel.createPortfolioDollarAverageLogicWithEndDate(this.userId,
                          this.userName, this.userEmail, this.portfolioId,
                          this.tickerList, amount, days,
                          startDate, endDate));
                  view.printString(sb);

                }
                break;
              }
              case 3: {
                view.totalAmountToBeInvested();
                Double amount = sc.nextDouble();
                view.startDate();
                String startDate = takeDate(view, sc);
                this.tickerList = getTickerNumberDCA(view, sc);
                StringBuilder sb = new StringBuilder(
                    newModel.createPortfolioInvestment(this.userId,
                        this.userName, this.userEmail, this.portfolioId,
                        this.tickerList, amount,
                        startDate));
                view.printString(sb);
                break;
              }
              default: {
                view.invalidOption();
                return;
              }
            }
            break;
          }
          case 6: {
            view.takeTickerSymbol();
            ticker = sc.next();
            view.takeNumberOfStocks();
            numOfStocks = sc.nextInt();
            view.date();
            date = takeDate(view, sc);
            StringBuilder sb = new StringBuilder(newModel.sellStocks(this.userId,
                this.userName, this.userEmail, this.portfolioId, ticker, numOfStocks,
                date));
            view.printString(sb);
            counter++;
            break;
          }
          case 7: {
            view.commissionFeeOption();
            optionCommissionFee = sc.nextInt();
            view.date();
            date = this.takeDate(view, sc);
            switch (optionCommissionFee) {
              case 1: {
                Double commission = getCommissionFee(view, sc);
                StringBuilder sb = new StringBuilder(newModel.getCostBasis(this.userId,
                    this.userName,
                    this.userEmail, this.portfolioId, date, commission));
                view.printString(sb);
                break;
              }
              case 2: {
                StringBuilder sb = new StringBuilder(newModel.getCostBasis(this.userId,
                    this.userName,
                    this.userEmail, this.portfolioId, date, 0.00));
                view.printString(sb);
                break;
              }
              default: {
                view.invalidOption();
                return;
              }
            }
            counter++;
            break;
          }
          case 8: {
            view.startDate();
            String startDate = takeDate(view, sc);
            view.endDate();
            String endDate = takeDate(view, sc);
            HashMap<LocalDate, Integer> result = newModel.portfolioPerformance(this.userId,
                this.userName, this.userEmail, this.portfolioId, startDate, endDate);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            int check = result.get(LocalDate.parse("1800-01-01", dateTimeFormatter));
            result.remove(LocalDate.parse("1800-01-01", dateTimeFormatter));
            if (check == 0) {
              view.printPerformanceDayWise(result, portfolioId, startDate, endDate);
            } else if (check == 1) {
              view.printPerformanceMonthWise(result, portfolioId, startDate, endDate);
            } else {
              view.printPerformanceYearWise(result, portfolioId, startDate, endDate);
            }
            counter++;
            break;
          }
          default: {
            view.invalidOption();
            return;
          }
        }
        view.flexiblePortLimitedOption();
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
    view.programClosed();
  }
}
