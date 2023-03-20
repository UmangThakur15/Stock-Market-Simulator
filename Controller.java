import java.io.IOException;


/**
 * The Controller interface has all the methods that helps in interaction between model and view.
 * It does not perform any other function on its own.
 */

public interface Controller {
  /**
   * This method is passing user inputs from View to Model and after the task is
   * performed it is sending back the result from Model to View.
   *
   * @param model object of The Model to access the Model.
   * @param view  object of The View to access the View.
   * @throws InterruptedException exception due to time limit.
   * @throws IOException          exception when reading file.
   */
  void goStock(Model model, View view) throws InterruptedException, IOException;


}
