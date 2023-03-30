package view.guiview.textfield;


import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 * This class implements the TextFieldView interface, it
 * enables the JFrame to get inputs from the user to
 * update the portfolio with Dollar cot strategy.
 */
public class UpdatePortDCA extends JFrame implements TextFieldView {

  private final JButton homeUpdatePort;
  private final JButton exit;
  private final JButton updatePortDCAWO;
  private final JTextField[] stockSymbol;
  private final JTextField[] percentage;
  private final int num;
  private final JLabel error;


  /**
   * This is a constructor for updatePortDCA class,
   * it initializes the JFrame to get the user input.
   **/
  public UpdatePortDCA(int numOfStocks) {
    super();

    final Color customColor;
    final Color customColor1;
    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 400);

    this.setPreferredSize(new Dimension(450, 300));


    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);

    this.setBackground(customColor);


    List<String> stockNames = new ArrayList<>();
    JLabel[] stockLabel;
    JLabel[] percentageLabel;
    JPanel[] stockPanel;
    num = numOfStocks;

    stockLabel = new JLabel[num];
    stockSymbol = new JTextField[num];
    percentageLabel = new JLabel[num];
    percentage = new JTextField[num];

    stockPanel = new JPanel[num];
    for (int i = 0; i < num; i++) {
      stockLabel[i] = new JLabel("Ticker Number");
      stockSymbol[i] = new JTextField(20);
      percentageLabel[i] = new JLabel("Percentage");
      percentage[i] = new JTextField(3);
      stockPanel[i] = new JPanel();
      stockPanel[i].add(stockLabel[i]);
      stockPanel[i].add(stockSymbol[i]);
      stockPanel[i].add(percentageLabel[i]);
      stockPanel[i].add(percentage[i]);
      stockPanel[i].setBackground(customColor);
    }

    JPanel errorPanel = new JPanel();
    error = new JLabel("");
    errorPanel.add(error);

    updatePortDCAWO = new JButton("Update Stocks to the Portfolio");
    updatePortDCAWO.setActionCommand("updatePortDCAWO");
    homeUpdatePort = new JButton("Go to Main Menu");
    homeUpdatePort.setActionCommand("homeUpdatePort");
    exit = new JButton("exit");
    exit.setActionCommand("exit");
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(updatePortDCAWO);
    buttonPanel.add(homeUpdatePort);
    buttonPanel.add(exit);

    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new GridLayout(2, 1));
    bottomPanel.add(buttonPanel);
    bottomPanel.setBackground(customColor);
    buttonPanel.setBackground(customColor);
    errorPanel.setBackground(customColor);

    JPanel allStock = new JPanel();
    allStock.setLayout(new GridLayout(stockNames.size(), 1));
    for (int i = 0; i < num; i++) {
      allStock.add(stockPanel[i]);
    }

    allStock.setBackground(customColor);
    int vsb = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
    int hsb = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
    JScrollPane scrollPane = new JScrollPane(allStock, vsb, hsb);
    scrollPane.setBackground(customColor);
    errorPanel.setBackground(customColor);
    this.add(errorPanel, BorderLayout.PAGE_START);
    this.add(scrollPane, BorderLayout.CENTER);
    this.add(bottomPanel, BorderLayout.PAGE_END);

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setBackground(customColor);
    this.setVisible(true);
    this.pack();

  }

  @Override
  public void addActionListener(ActionListener listener) {
    updatePortDCAWO.addActionListener(listener);
    homeUpdatePort.addActionListener(listener);
    exit.addActionListener(listener);
  }

  @Override
  public ArrayList<String> getInput() {
    ArrayList<String> allInfo = new ArrayList<>();
    for (int i = 0; i < num; i++) {
      allInfo.add(stockSymbol[i].getText().toUpperCase());
      allInfo.add(percentage[i].getText());
    }
    return allInfo;
  }

  @Override
  public void errorMessage(String message) {
    error.setText(message);
  }

  @Override
  public void clearField() {
    for (int i = 0; i < num; i++) {
      percentage[i].setText("");
    }

    for (int i = 0; i < num; i++) {
      stockSymbol[i].setText("");
    }
  }

  @Override
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }

  @Override
  public void hideMainButton() {
    updatePortDCAWO.setEnabled(false);
  }
}
