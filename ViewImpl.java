package view;

import java.io.PrintStream;


/**
 * This class implements the view interface.
 * It displays all the input and output related messages to the user and also takes
 * input from the user to create a portfolio,
 * get the composition of a particular portfolio,  get the value of particular
 * portfolio on a particular date and to display the saved portfolios.
 **/
public class ViewImpl implements View {

  private final PrintStream out;

  public ViewImpl(PrintStream out) {
    this.out = out;
  }

  @Override
  public void printOutput(StringBuilder sb) {
    this.out.println(sb.toString());
  }


  @Override
  public void printError(String s) {
    this.out.println(s);
  }


}
