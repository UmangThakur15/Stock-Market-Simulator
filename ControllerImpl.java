import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;


/**
 * This is Controller Class for the implementation of Controller interface. Methods mentioned in the
 * controller class helps in interaction between Model and View.
 */

public class ControllerImpl implements Controller {
  private final InputStream in;
  private final PrintStream out;


  /**
   * Constructor for the Controller Class initializes the input stream and output stream.
   *
   * @param in  InputStream Contains teh input.
   * @param out PrintStream Contains the output.
   */
  public ControllerImpl(InputStream in, PrintStream out) {
    this.in = in;
    this.out = out;
  }


  @Override
  public void goStock(Model model, View view) throws InterruptedException, IOException {
    view.setInputOutput(this.in, this.out);
    view.getInput();
    if (view.getOption() == 1) {
      try {
        StringBuilder sb = new StringBuilder(model.addPortfolioByManualInput(view.getUserId(),
                view.getUserName(),
                view.getUserEmail(), view.getPortfolioId(), view.getTickerList()));
        view.printOutput(sb);
      } catch (IllegalArgumentException e) {
        view.printError(e.getMessage());
      }

    } else if (view.getOption() == 2) {
      try {
        StringBuilder sb = new StringBuilder(model.addPortfolioByFile(view.getUserId(),
                view.getUserName(),
                view.getUserEmail(), view.getPortfolioId()));
        view.printOutput(sb);
      } catch (IllegalArgumentException e) {
        view.printError(e.getMessage());
      }

    } else if (view.getOption() == 3) {

      try {
        StringBuilder sb = new StringBuilder(model.getComposition(view.getUserId(),
                view.getUserName(),
                view.getUserEmail(), view.getPortfolioId()));
        view.printOutput(sb);
      } catch (IllegalArgumentException e) {
        view.printError(e.getMessage());
      }
      //System.out.println(sb.toString());

    } else {
      //view.takeDate();
      try {
        StringBuilder sb = new StringBuilder(model.portfolioValue(view.getUserId(),
                view.getUserName(),
                view.getUserEmail(), view.getPortfolioId(), view.getDate()));
        view.printOutput(sb);
      } catch (IllegalArgumentException e) {
        view.printError(e.getMessage());
      }
    }
  }
}
