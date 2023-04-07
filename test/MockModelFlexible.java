import model.PortfolioFlexible;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * This is the mock model class for PortfolioFlexible Class.
 **/
public class MockModelFlexible implements PortfolioFlexible {
  private final StringBuilder log;

  public MockModelFlexible(StringBuilder log) {
    this.log = log;
  }


  @Override
  public StringBuilder addPortfolioByManualInput(int userId, String userName, String userEmail,
                                                 int portfolioId, ArrayList<String> tickerNumData)
      throws InterruptedException, ParseException {
    log.append("AA");
    return new StringBuilder("AA");
  }

  @Override
  public StringBuilder addPortfolioByFile(int userId, String userName,
                                          String userEmail, int portfolioId,
                                          String fileName) throws IOException, ParseException {
    log.append("AA");
    return new StringBuilder("AA");
  }


  @Override
  public StringBuilder portfolioValue(int userId, String userName,
                                      String userEmail, int portfolioId, String date)
      throws IOException, InterruptedException, ParseException {
    log.append("AC");
    return new StringBuilder("AC");
  }

  @Override
  public StringBuilder getComposition(int userId,
                                      String userName,
                                      String userEmail, int portfolioId, String date)
      throws IOException {
    log.append("AD");
    return new StringBuilder("AD");
  }

  @Override
  public StringBuilder modifyPortfolioByAdding(int userId, String userName, String userEmail,
                                               int portfolioId, ArrayList<String> tickerNumData)
      throws InterruptedException, ParseException {
    log.append("AE");
    return new StringBuilder("AE");
  }

  @Override
  public StringBuilder sellStocks(int userId,
                                  String userName, String userEmail,
                                  int portfolioId, String ticker, int numOfStocks, String date)
      throws IOException, ParseException {
    log.append("AF");
    return new StringBuilder("AF");
  }

  @Override
  public StringBuilder getCostBasis(int userId, String userName, String userEmail,
                                    int portfolioId, String date, Double commissionFee)
      throws IOException, ParseException {
    log.append("AG");
    return new StringBuilder("AG");
  }


  @Override
  public HashMap<LocalDate, Integer> portfolioPerformance(int userId, String userName,
                                                          String userEmail, int portfolioId,
                                                          String startDate, String endDate) {
    log.append("AH");
    return null;
  }

  @Override
  public StringBuilder createPortfolioDollarAverageLogicWithEndDate(int userId,
                                                                    String userName,
                                                                    String userEmail,
                                                                    int portfolioId,
                                                                    ArrayList<String> tickerList,
                                                                    Double amount,
                                                                    int days,
                                                                    String startDate,
                                                                    String endDate)
      throws ParseException, IOException {
    log.append("AJ");
    return null;
  }

  @Override
  public StringBuilder createPortfolioInvestment(int userId, String userName,
                                                 String userEmail, int portfolioId,
                                                 ArrayList<String> tickerList,
                                                 Double amount,
                                                 String startDate)
      throws ParseException, IOException {
    log.append("AI");
    return new StringBuilder("AI");
  }


}


