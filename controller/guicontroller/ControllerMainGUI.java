package controller.guicontroller;


/**
 * This interface has all the methods that ControllerImplGUI
 * class implements to perform required on Portfolio.
 * User does not directly interact with this interface.
 **/


public interface ControllerMainGUI {


  /**
   * This method is Initializes ActionMap which stores all the actions that need to be performed
   * when a button is clicked in GUI.
   *
   * @throws InterruptedException This exception occurs when a thread
   *                              is interrupted while it's waiting,
   *                              sleeping, or otherwise occupied.
   */

  void goStock()
      throws InterruptedException;
}
