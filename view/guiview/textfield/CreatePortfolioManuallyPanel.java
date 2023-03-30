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
 * This class implements the TextFieldView interface, it
 * enables the JFrame to get user inputs to create portfolio
 * manually.
 */

public class CreatePortfolioManuallyPanel extends JFrame implements TextFieldView {


  private final JTextField tickerNumberT;
  private final JTextField numOfStocksT;


  private final JTextField portfolioidT;
  private final JButton addMoreButton;
  private final JButton homeCreatePortManually;
  private final JButton exit;
  private final JLabel error;

  private final JComboBox year;
  private final JComboBox month;
  private final JComboBox day;


  /**
   * This is a constructor for createPortfolioManuallyPanel class,
   * it initializes the JFrame to get the user input.
   **/

  public CreatePortfolioManuallyPanel() {


    super();
    final JPanel createPortfolioManually;
    final JLabel tickerNumber;
    final JLabel numOfStocks;
    final JLabel date;
    final JLabel portfolioId;
    final JTextField dateT;
    final JLabel yearLabel;
    final JLabel monthLabel;
    final JLabel dayLabel;
    final Color customColor;
    final Color customColor1;
    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 400);

    this.setPreferredSize(new Dimension(450, 300));

    createPortfolioManually = new JPanel();

    createPortfolioManually.setBorder(BorderFactory.createTitledBorder("Create "
        + "Portfolio Manually"));
    createPortfolioManually.setBounds(200, 350, 200, 200);
    createPortfolioManually.setLayout(new BoxLayout(createPortfolioManually,
        BoxLayout.PAGE_AXIS));

    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    tickerNumber = new JLabel("Ticker Number");
    tickerNumberT = new JTextField("");
    numOfStocks = new JLabel("Number Of Stocks");
    numOfStocksT = new JTextField("");
    portfolioId = new JLabel("Portfolio Id");
    portfolioidT = new JTextField("");


    createPortfolioManually.add(tickerNumber);
    createPortfolioManually.add(tickerNumberT);
    createPortfolioManually.add(numOfStocks);
    createPortfolioManually.add(numOfStocksT);
    createPortfolioManually.add(portfolioId);
    createPortfolioManually.add(portfolioidT);

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
    addMoreButton = new JButton("Add Stocks to the Portfolio");
    addMoreButton.setActionCommand("addMoreButton");
    homeCreatePortManually = new JButton("Back to Main Menu");
    homeCreatePortManually.setActionCommand("homeCreatePortManually");
    exit = new JButton("Exit");
    exit.setActionCommand("exit");


    buttonPanel.add(addMoreButton);
    buttonPanel.add(homeCreatePortManually);
    buttonPanel.add(exit);
    buttonPanel.setLayout(new GridLayout(2, 2));


    buttonPanel.setBackground(customColor);
    errorPanel.setBackground(customColor);
    createPortfolioManually.setBackground(customColor);
    datePanel.setBackground(customColor);
    createPortfolioManually.setLayout(new GridLayout(3, 2));

    JPanel composition = new JPanel();
    composition.setLayout(new GridLayout(2, 1));
    composition.add(createPortfolioManually);
    composition.add(datePanel);
    this.add(composition, BorderLayout.PAGE_START);
    this.add(errorPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
    this.setVisible(true);
    this.pack();


  }

  @Override
  public void addActionListener(ActionListener listener) {

    addMoreButton.addActionListener(listener);
    homeCreatePortManually.addActionListener(listener);
    exit.addActionListener(listener);

  }

  @Override
  public ArrayList<String> getInput() {
    ArrayList<String> tickerData = new ArrayList<>();
    String date = year.getSelectedItem().toString() + "-" + month.getSelectedItem().toString() + "-"
        + day.getSelectedItem().toString();

    tickerData.add(portfolioidT.getText());
    tickerData.add(tickerNumberT.getText());
    tickerData.add(numOfStocksT.getText());
    tickerData.add(date);
    return tickerData;
  }

  @Override
  public void clearField() {
    portfolioidT.setText("");
    tickerNumberT.setText("");
    numOfStocksT.setText("");
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

  @Override
  public void errorMessage(String message) {
    error.setText(message);
  }


}
