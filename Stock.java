import controller.ControllerImpl;
import controller.ControllerMain;
import model.ModelImpl;
import model.ModelImplFlexible;
import model.PortfolioFlexible;
import model.PortfolioNonFlexible;
import view.View;
import view.ViewImpl;

import java.io.IOException;
import java.text.ParseException;


/**
 * This is the main class which is enabling the controller to interact between model and view.
 **/

public class Stock {

  /**
   * This method directs the controller to start the program.
   *
   * @param args argument.
   * @throws InterruptedException throws error message.
   * @throws IOException          throws error message.
   */


  public static void main(String[] args)
      throws InterruptedException, IOException, ParseException {
    PortfolioNonFlexible model = new ModelImpl();
    View view = new ViewImpl(System.out);
    PortfolioFlexible newModel = new ModelImplFlexible();

    ControllerMain controller = new ControllerImpl(System.in);
    controller.goStock(view, model, newModel);
  }
}
