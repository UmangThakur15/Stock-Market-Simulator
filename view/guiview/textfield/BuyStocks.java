package view.guiview.textfield;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

import view.guiview.helperclass.HelperClass;


/**
 * This class implements the TextFieldView, it
 * takes the user inputs to buy more stocks in the
 * existing portfolio.
 **/

public class BuyStocks extends JFrame implements TextFieldView {


  private final JTextField tickerNumberI;
  private final JTextField numOfStocksI;
  private final JTextField portfolioIdI;
  private final JButton buyMoreStock;
  private final JButton homeBuyStocks;
  private final JButton exit;
  private final JLabel error;
  private final JComboBox year;
  private final JComboBox month;
  private final JComboBox day;


  /**
   * This is a constructor of BuyStocks class,
   * it initializes the JFrame on the screen to take inputs from
   * the user.
   **/

  public BuyStocks() {

    super();

    final JPanel buyStocks;
    final JLabel tickerNumber;
    final JLabel numOfStocks;
    final JLabel date;
    final JLabel portfolioId;
    final JLabel yearLabel;
    final JLabel monthLabel;
    final JLabel dayLabel;
    final Color customColor;
    final Color customColor1;
    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 400);

    this.setPreferredSize(new Dimension(450, 300));


    buyStocks = new JPanel();

    buyStocks.setBorder(BorderFactory.createTitledBorder("Add Stocks to Portfolio"));
    buyStocks.setBounds(200, 350, 200, 200);
    buyStocks.setLayout(new BoxLayout(buyStocks, BoxLayout.PAGE_AXIS));

    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    tickerNumber = new JLabel("Ticker Number");
    tickerNumberI = new JTextField("");
    numOfStocks = new JLabel("Number Of Stocks");
    numOfStocksI = new JTextField("");
    portfolioId = new JLabel("Portfolio Id");
    portfolioIdI = new JTextField("");

    buyStocks.add(portfolioId);
    buyStocks.add(portfolioIdI);
    buyStocks.add(tickerNumber);
    buyStocks.add(tickerNumberI);
    buyStocks.add(numOfStocks);
    buyStocks.add(numOfStocksI);

    JPanel datePanel = new JPanel();
    date = new JLabel("Date     ");
    yearLabel = new JLabel("Year");
    monthLabel = new JLabel("Month");
    dayLabel = new JLabel("Day");
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
    buyMoreStock = new JButton("Add Stocks to Portfolio");
    homeBuyStocks = new JButton("Go to Main Menu");
    exit = new JButton("Exit");
    buyMoreStock.setActionCommand("buyMoreStock");
    homeBuyStocks.setActionCommand("homeBuyStocks");
    exit.setActionCommand("exit");
    buttonPanel.add(buyMoreStock);
    buttonPanel.add(homeBuyStocks);
    buttonPanel.add(exit);

    buyStocks.setBackground(customColor);
    buttonPanel.setBackground(customColor);
    errorPanel.setBackground(customColor);
    datePanel.setBackground(customColor);
    buyStocks.setLayout(new GridLayout(3, 2));


    JPanel composition = new JPanel();
    composition.setLayout(new GridLayout(2, 1));
    composition.add(buyStocks);
    composition.add(datePanel);
    this.add(composition, BorderLayout.PAGE_START);
    this.add(errorPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
    this.setVisible(true);
    this.pack();

  }

  @Override
  public void addActionListener(ActionListener listener) {
    buyMoreStock.addActionListener(listener);
    homeBuyStocks.addActionListener(listener);
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
    portfolioIdI.setText("");
    tickerNumberI.setText("");
    numOfStocksI.setText("");
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
