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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import view.guiview.helperclass.HelperClass;


/**
 * This class implements the TextFieldView interface, it
 * enables the JFrame to get inputs from the user to
 * add Dollar cost strategy without end date.
 */
public class DCAWithoutEndDateMainPan extends JFrame implements TextFieldView {


  private final JTextField portfolioIdI;

  private final JTextField numStocksI;
  private final JTextField amountI;
  private final JTextField intervalI;
  private final JButton addDollarCostWO;
  private final JButton homeCreateDCAWOEnd;
  private final JButton exit;
  private final JLabel error;


  private final JComboBox year;
  private final JComboBox month;
  private final JComboBox day;

  private JTextField startDateI;
  private Color customColor;


  /**
   * This is a constructor for DCAWithoutEndDateMainPan class,
   * it initializes the JFrame to get the user input.
   **/

  public DCAWithoutEndDateMainPan() {
    super();
    final JPanel dollarCostAverageWithoutEndDate;
    final JLabel portfolioId;
    final JLabel amount;
    final JLabel interval;
    final JLabel startDate;
    final JLabel numStocks;
    final JLabel yearLabel;
    final JLabel monthLabel;
    final JLabel dayLabel;
    final Color customColor1;
    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 450);

    this.setPreferredSize(new Dimension(550, 500));
    this.setBackground(customColor);

    dollarCostAverageWithoutEndDate = new JPanel();

    dollarCostAverageWithoutEndDate.setBorder(BorderFactory.createTitledBorder("Add"
        + " Stocks to Portfolio via Dollar Cost Average Strategy"));
    dollarCostAverageWithoutEndDate.setBounds(200, 350, 200, 200);
    dollarCostAverageWithoutEndDate.setLayout(new BoxLayout(dollarCostAverageWithoutEndDate,
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

    dollarCostAverageWithoutEndDate.add(portfolioId);
    dollarCostAverageWithoutEndDate.add(portfolioIdI);
    dollarCostAverageWithoutEndDate.add(numStocks);
    dollarCostAverageWithoutEndDate.add(numStocksI);
    dollarCostAverageWithoutEndDate.add(amount);
    dollarCostAverageWithoutEndDate.add(amountI);
    dollarCostAverageWithoutEndDate.add(interval);
    dollarCostAverageWithoutEndDate.add(intervalI);

    JPanel datePanel = new JPanel();
    startDate = new JLabel("Date     ");
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
    datePanel.add(startDate);
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
    addDollarCostWO = new JButton("Add Stocks to the Portfolio via Dollar Cost Average");
    homeCreateDCAWOEnd = new JButton("Go to Main Menu");
    exit = new JButton("Exit");

    addDollarCostWO.setActionCommand("addDollarCostWO");
    homeCreateDCAWOEnd.setActionCommand("homeCreateDCAWOEnd");
    exit.setActionCommand("exit");


    buttonPanel.add(addDollarCostWO);
    buttonPanel.add(homeCreateDCAWOEnd);
    buttonPanel.add(exit);
    buttonPanel.setLayout(new GridLayout(2, 2));

    JPanel composition = new JPanel();
    composition.setLayout(new GridLayout(2, 1));

    dollarCostAverageWithoutEndDate.setLayout(new GridLayout(4, 2));
    dollarCostAverageWithoutEndDate.setBackground(customColor);
    datePanel.setBackground(customColor);
    errorPanel.setBackground(customColor);
    buttonPanel.setBackground(customColor);
    composition.add(dollarCostAverageWithoutEndDate);
    composition.add(datePanel);
    this.add(composition, BorderLayout.PAGE_START);
    this.add(errorPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
    this.setVisible(true);
    this.pack();
  }

  @Override
  public void addActionListener(ActionListener listener) {
    addDollarCostWO.addActionListener(listener);
    homeCreateDCAWOEnd.addActionListener(listener);
    exit.addActionListener(listener);
  }

  @Override
  public ArrayList<String> getInput() {
    ArrayList<String> list6 = new ArrayList<>();
    String date = year.getSelectedItem().toString() + "-" + month.getSelectedItem().toString() + "-"
        + day.getSelectedItem().toString();

    list6.add(portfolioIdI.getText());
    list6.add(amountI.getText());
    list6.add(intervalI.getText());
    list6.add(date);
    LocalDate todayDate = LocalDate.now().minusDays(2);
    String endDateI = todayDate.toString();
    list6.add(endDateI);
    list6.add(numStocksI.getText());

    return list6;
  }

  @Override
  public void clearField() {
    portfolioIdI.setText("");
    amountI.setText("");
    startDateI.setText("");
    intervalI.setText("");
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

  @Override
  public void errorMessage(String message) {

    error.setText(message);
  }
}
