package view.guiview.textfield;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import view.guiview.helperclass.HelperClass;


/**
 * This class implements the TextFieldView interface, it
 * enables the JFrame to get inputs from the user to
 * sell stocks on specific date.
 */
public class SellStocksPanel extends JFrame implements TextFieldView {


  private final JTextField tickerNumberI;
  private final JTextField numOfStocksI;
  private final JTextField dateI;
  private final JTextField portfolioIdI;
  private final JButton sellMoreStock;
  private final JButton homeSellStocks;
  private final JButton exit;
  private final JLabel error;

  private final JComboBox year;
  private final JComboBox month;
  private final JComboBox day;


  /**
   * This is a constructor for SellStocksPanel class,
   * it initializes the JFrame to get the user input.
   **/
  public SellStocksPanel() {

    super();

    final JPanel sellStocks;
    final JLabel tickerNumber;
    final JLabel numOfStocks;
    final JLabel portfolioId;
    final JTextField dateT;
    final JLabel yearLabel;
    final JLabel monthLabel;
    final JLabel dayLabel;
    final Color customColor;
    final Color customColor1;
    JLabel date;
    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 400);

    this.setPreferredSize(new Dimension(450, 300));


    sellStocks = new JPanel();
    sellStocks.setBorder(BorderFactory.createTitledBorder("Sell Stocks"));
    sellStocks.setLayout(new BoxLayout(sellStocks, BoxLayout.PAGE_AXIS));
    tickerNumber = new JLabel("Ticker Number");
    tickerNumberI = new JTextField("");
    numOfStocks = new JLabel("Number Of Stocks");
    numOfStocksI = new JTextField("");
    date = new JLabel("Date in format YYYY-MM-DD");
    dateI = new JTextField("");
    portfolioId = new JLabel("Portfolio Id");
    portfolioIdI = new JTextField("");


    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);

    JPanel datePanel = new JPanel();
    date = new JLabel("Date     ");
    yearLabel = new JLabel("Year");
    monthLabel = new JLabel("Month");
    dayLabel = new JLabel("Day");
    dateT = new JTextField("");


    int currentYear = LocalDateTime.now().getYear();
    String[] years = new String[currentYear + 45 - 1994];
    int j = 0;
    for (int i = 1994; i < currentYear + 45; i++) {
      years[j++] = Integer.toString(i);
    }
    ActionListener listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        HelperClass.setDay(year, month, day);
      }
    };
    year = new JComboBox(years);
    year.addActionListener(listener);

    String[] monthNumber = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    month = new JComboBox(monthNumber);
    month.addActionListener(listener);
    String[] days = HelperClass.getDefaultDay();
    day = new JComboBox(days);
    datePanel.add(date);
    datePanel.add(yearLabel);
    datePanel.add(year);
    datePanel.add(monthLabel);
    datePanel.add(month);
    datePanel.add(dayLabel);
    datePanel.add(day);


    JPanel errorPanel = new JPanel();
    error = new JLabel("");
    errorPanel.add(error);


    JPanel buttonPanel = new JPanel();
    sellMoreStock = new JButton("Sell Stocks");
    sellMoreStock.setActionCommand("sellMoreStock");
    homeSellStocks = new JButton("Go to Main Menu");
    homeSellStocks.setActionCommand("homeSellStocks");
    exit = new JButton("Exit");
    exit.setActionCommand("exit");


    buttonPanel.add(sellMoreStock);
    buttonPanel.add(homeSellStocks);
    buttonPanel.add(exit);


    sellStocks.add(portfolioId);
    sellStocks.add(portfolioIdI);
    sellStocks.add(tickerNumber);
    sellStocks.add(tickerNumberI);
    sellStocks.add(numOfStocks);
    sellStocks.add(numOfStocksI);


    buttonPanel.setBackground(customColor);
    errorPanel.setBackground(customColor);
    sellStocks.setBackground(customColor);
    datePanel.setBackground(customColor);

    GridLayout gridLayout = new GridLayout(3, 2);
    sellStocks.setLayout(gridLayout);

    JPanel composition = new JPanel();
    composition.setLayout(new GridLayout(2, 1));
    composition.add(sellStocks);
    composition.add(datePanel);
    this.add(composition, BorderLayout.PAGE_START);
    this.add(errorPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
    this.setVisible(true);
    this.pack();


  }

  @Override
  public void addActionListener(ActionListener listener) {
    sellMoreStock.addActionListener(listener);
    homeSellStocks.addActionListener(listener);
    exit.addActionListener(listener);
  }


  @Override
  public ArrayList<String> getInput() {

    ArrayList<String> tickerData = new ArrayList<>();
    String date = year.getSelectedItem().toString() + "-" + month.getSelectedItem().toString() + "-"
        + day.getSelectedItem().toString();

    tickerData.add(portfolioIdI.getText());
    tickerData.add(tickerNumberI.getText());
    tickerData.add(numOfStocksI.getText());
    tickerData.add(date);

    return tickerData;
  }

  @Override
  public void errorMessage(String message) {
    error.setText(message);
  }

  @Override
  public void clearField() {
    tickerNumberI.setText("");
    numOfStocksI.setText("");
    dateI.setText("");
    portfolioIdI.setText("");
  }

  @Override
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }

  @Override
  public void hideMainButton() {
    return;
  }

}
