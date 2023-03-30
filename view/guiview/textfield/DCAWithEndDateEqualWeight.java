package view.guiview.textfield;


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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

import view.guiview.helperclass.HelperClass;


/**
 * This class implements the TextFieldView interface, it
 * enables the JFrame to get inputs from the user to
 * add Dollar cost strategy for equal weights for each ticker.
 **/
public class DCAWithEndDateEqualWeight extends JFrame implements TextFieldView {


  private final JTextField amountI;
  private final JTextField intervalI;
  private final JButton addDCAEqualWith;
  private final JButton homeEqualWith1;
  private final JButton exit;
  private final JLabel error;

  private final JTextField numStocksI;
  private final JComboBox year1;
  private final JComboBox month1;
  private final JComboBox day1;

  private final JComboBox year2;
  private final JComboBox month2;
  private final JComboBox day2;
  private Color customColor;
  private JTextField portfolioIdI;


  /**
   * This is a constructor for DCAWithEndDateEqualWeight class,
   * it initializes the JFrame to get the user input.
   **/
  public DCAWithEndDateEqualWeight() {
    super();
    final JPanel dollarCostAverageWithEndDate;
    final JLabel portfolioId;

    final JLabel amount;
    final JLabel interval;
    final JLabel startDate;
    final JLabel endDate;
    final JLabel numStocks;
    final JLabel yearLabel1;
    final JLabel monthLabel1;
    final JLabel dayLabel1;
    final JLabel yearLabel2;
    final JLabel monthLabel2;
    final JLabel dayLabel2;
    final Color customColor1;
    final JTextField startDateI;
    final JTextField endDateI;


    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 400);

    this.setPreferredSize(new Dimension(550, 550));
    this.setBackground(customColor);


    dollarCostAverageWithEndDate = new JPanel();

    dollarCostAverageWithEndDate.setBorder(BorderFactory.createTitledBorder("Add Stocks" +
        " to Portfolio via Dollar Cost Average Strategy"));
    dollarCostAverageWithEndDate.setBounds(200, 350, 200, 200);
    dollarCostAverageWithEndDate.setLayout(new BoxLayout(dollarCostAverageWithEndDate,
        BoxLayout.PAGE_AXIS));

    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    portfolioId = new JLabel("Portfolio Id");
    portfolioIdI = new JTextField("");
    numStocks = new JLabel("Number of Stocks");
    numStocksI = new JTextField("");
    amount = new JLabel("Amount");
    amountI = new JTextField();
    interval = new JLabel("Interval(Days)");
    intervalI = new JTextField();

    dollarCostAverageWithEndDate.add(portfolioId);
    dollarCostAverageWithEndDate.add(portfolioIdI);
    dollarCostAverageWithEndDate.add(numStocks);
    dollarCostAverageWithEndDate.add(numStocksI);
    dollarCostAverageWithEndDate.add(amount);
    dollarCostAverageWithEndDate.add(amountI);
    dollarCostAverageWithEndDate.add(interval);
    dollarCostAverageWithEndDate.add(intervalI);

    JPanel errorPanel = new JPanel();
    error = new JLabel("");
    errorPanel.add(error);

    JPanel buttonPanel = new JPanel();
    addDCAEqualWith = new JButton("Add Stocks to the Portfolio via Dollar Cost Avg");
    homeEqualWith1 = new JButton("Go to Main Menu");
    exit = new JButton("Exit");

    addDCAEqualWith.setActionCommand("addDCAEqualWith");
    homeEqualWith1.setActionCommand("homeEqualWith1");
    exit.setActionCommand("exit");

    buttonPanel.add(addDCAEqualWith);
    buttonPanel.add(homeEqualWith1);
    buttonPanel.add(exit);
    buttonPanel.setLayout(new GridLayout(2, 2));

    JPanel datePanel1 = new JPanel();
    startDate = new JLabel("Start Date     ");
    yearLabel1 = new JLabel("Year");
    monthLabel1 = new JLabel("Month");
    dayLabel1 = new JLabel("Day");
    int currentYear1 = LocalDateTime.now().getYear();
    String[] years1 = new String[currentYear1 + 45 - 1994];
    int j = 0;
    for (int i = 1994; i < currentYear1 + 45; i++) {
      years1[j++] = Integer.toString(i);
    }
    ActionListener listener1 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        HelperClass.setDay(year1,
            month1, day1);
      }
    };
    year1 = new JComboBox(years1);
    year1.addActionListener(listener1);

    String[] monthNumber1 = {"01", "02", "03", "04", "05", "06", "07", "08",
        "09", "10", "11", "12"};
    month1 = new JComboBox(monthNumber1);
    month1.addActionListener(listener1);
    String[] days1 = HelperClass.getDefaultDay();
    day1 = new JComboBox(days1);
    datePanel1.add(startDate);
    datePanel1.add(yearLabel1);
    datePanel1.add(year1);
    datePanel1.add(monthLabel1);
    datePanel1.add(month1);
    datePanel1.add(dayLabel1);
    datePanel1.add(day1);


    JPanel datePanel2 = new JPanel();
    endDate = new JLabel("End Date     ");
    yearLabel2 = new JLabel("Year");
    monthLabel2 = new JLabel("Month");
    dayLabel2 = new JLabel("Day");
    int currentYear2 = LocalDateTime.now().getYear();
    String[] years2 = new String[currentYear2 + 45 - 1994];
    int k = 0;
    for (int i = 1994; i < currentYear2 + 45; i++) {
      years2[k++] = Integer.toString(i);
    }
    ActionListener listener2 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        HelperClass.setDay(year2, month2, day2);
      }
    };
    year2 = new JComboBox(years2);
    year2.addActionListener(listener2);

    String[] monthNumber2 = {"01", "02", "03", "04", "05", "06", "07", "08",
        "09", "10", "11", "12"};
    month2 = new JComboBox(monthNumber2);
    month2.addActionListener(listener2);
    String[] days2 = HelperClass.getDefaultDay();
    day2 = new JComboBox(days2);
    datePanel2.add(endDate);
    datePanel2.add(yearLabel2);
    datePanel2.add(year2);
    datePanel2.add(monthLabel2);
    datePanel2.add(month2);
    datePanel2.add(dayLabel2);
    datePanel2.add(day2);


    dollarCostAverageWithEndDate.setLayout(new GridLayout(4, 2));
    dollarCostAverageWithEndDate.setBackground(customColor);
    buttonPanel.setBackground(customColor);
    errorPanel.setBackground(customColor);
    datePanel1.setBackground(customColor);
    datePanel2.setBackground(customColor);

    JPanel composition = new JPanel();
    composition.setLayout(new GridLayout(3, 1));
    composition.add(dollarCostAverageWithEndDate);
    composition.add(datePanel1);
    composition.add(datePanel2);
    this.add(composition, BorderLayout.PAGE_START);
    this.add(errorPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
    this.setVisible(true);
    this.pack();
  }


  @Override
  public void addActionListener(ActionListener listener) {
    addDCAEqualWith.addActionListener(listener);
    homeEqualWith1.addActionListener(listener);
    exit.addActionListener(listener);
  }

  @Override
  public ArrayList<String> getInput() {
    ArrayList<String> list5 = new ArrayList<>();
    String startDate = year1.getSelectedItem().toString() +
        "-" + month1.getSelectedItem().toString() + "-"
        + day1.getSelectedItem().toString();
    String endDate = year2.getSelectedItem().toString() +
        "-" + month2.getSelectedItem().toString() + "-"
        + day2.getSelectedItem().toString();

    list5.add(portfolioIdI.getText());
    list5.add(amountI.getText());
    list5.add(intervalI.getText());
    list5.add(startDate);
    list5.add(endDate);
    list5.add(numStocksI.getText());
    return list5;
  }

  @Override
  public void errorMessage(String message) {
    error.setText(message);

  }

  @Override
  public void clearField() {
    portfolioIdI.setText("");
    amountI.setText("");
    intervalI.setText("");
    // startDateI.setText("");
    // endDateI.setText("");
    numStocksI.setText("");

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
