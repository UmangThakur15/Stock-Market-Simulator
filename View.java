package view;

/**
 * This interface has all the methods with which user interacts directly.
 * It takes all the desired inputs from the user
 * and based on the inputs it displays the desired outputs.
 **/
public interface View {


  /**
   * This method prints the error messages encountered while
   * performing a specific method in the modelImpl class
   * via controller.
   *
   * @param s
   **/
  void printError(String s);


  /**
   * This method prints the value in the StringBuilder.
   *
   * @param sb
   **/
  void printOutput(StringBuilder sb);

}
