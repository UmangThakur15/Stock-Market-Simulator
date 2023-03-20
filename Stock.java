import java.io.IOException;

/**
 * This is the main class which is enabling the controller to interact between model and view.
 **/
public class Stock {


  /**
   * This method directs the controller to start the program.
   *
   * @param args Standard argument.
   * @throws InterruptedException exception due to time limit.
   * @throws IOException          exception when reading file.
   */
  public static void main(String[] args) throws InterruptedException, IOException {
    Model model = new ModelImpl();
    View view = new ViewImpl();

    Controller controller = new ControllerImpl(System.in, System.out);
    controller.goStock(model, view);
  }
}
