package view.guiview.fileselection;


import java.awt.event.ActionListener;


/**
 * This interface has all the methods that fileSelect class implements, it
 * allows the user to choose the file to create the portfolio.
 **/
public interface IFileSelection {



  /**
   * Method returns the absolute path of the
   * file that user wants to input.
   * @return String, it returns the absolute path
   */
  String getInput();


  /**
   * Method returns the user selection.
   * @return Integer, it returns the user selection
   */
  int getFileChooser();


  /**
   * Method takes error message as the parameter.
   *
   * @param message String, It contains the error message
   */
  void setHint(String message);


  /**
   * This method is handling all action events such as when
   * the user clicks on a Button.
   *
   * @param listener ActionListener, It contains the listner
   */
  void addActionListener(ActionListener listener);


  /**
   * This method resets the focus on the component created
   * on the screen when an Action is performed.
   */
  void resetFocus();


}
