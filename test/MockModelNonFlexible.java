import model.PortfolioNonFlexible;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


/**
 * This is the Mock class for the PortfolioNonFlexible Interface.
 **/
public class MockModelNonFlexible implements PortfolioNonFlexible {

  private final StringBuilder log;

  public MockModelNonFlexible(StringBuilder log) {
    this.log = log;
  }

  @Override
  public StringBuilder portfolioValue(int userId, String userName, String userEmail,
                                      int portfolioId, String date)
      throws InterruptedException, IOException, ParseException {
    log.append("D");
    return new StringBuilder("D");
  }

  @Override
  public StringBuilder getComposition(int userId, String userName, String userEmail,
                                      int portfolioId) throws IOException {
    log.append("C");
    return new StringBuilder("C");
  }

  @Override
  public StringBuilder addPortfolioByManualInput(int userId, String userName, String userEmail,
                                                 int portfolioId, ArrayList<String> tickerNumData)
      throws InterruptedException, ParseException {
    log.append("A");
    return new StringBuilder("A");
  }


  @Override
  public StringBuilder addPortfolioByFile(int userId,
                                          String userName,
                                          String userEmail, int portfolioId, String path)
      throws IOException, ParseException {
    log.append("B");
    return new StringBuilder("B");
  }


}






