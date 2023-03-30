package view.guiview.textfield;

import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This interface has all the methods that are implemented by
 * BuyStocks, costBasisWithCommissionPan, costBasisWithoutCommissionPan,
 * createPortfolioManuallyPanel, DCASubPanelEqualWeights, DCASubPanelEqualWeightWithEndDate,
 * DCASubPanelWithEndDate, DCASubPanelWoEndDate, DCAWithEndDateEqualWeight, DCAWithEndDateMainPan,
 * DCAWithoutEndDateEqualWeight, DCAWithoutEndDateMainPan, GetCompositionPanel, GetPortfolioId,
 * JFrameView, portfolioPerformancePanel, portfolioValPan, SellStocksPanel, updatePortDCA,
 * UpdatePortDCAStrategy, it is a combination of buttons and text fields and enables to
 * take input from the user.
 **/

public interface TextFieldView {


  /**
   * This method is handling all action events such as when
   * the user clicks on a Button.
   *
   * @param listener ActionListener, It contains the listener
   */
  void addActionListener(ActionListener listener);





  /**
   * Method returns the ArrayList of the ticker data.
   * @return ArrayList, it returns ArrayList of Ticker Number
   */
  ArrayList<String> getInput();


  /**
   * This method takes the error message as parameter.
   *
   * @param message String, it contains the error message
   */

  void errorMessage(String message);


  /**
   * This method clear the Text Fields.
   **/

  void clearField();


  /**
   * This method resets the focus on the component created
   * on the screen when an Action is performed.
   */
  void resetFocus();


  /**
   * This method allows to disable the button.
   **/
  void hideMainButton();
}
