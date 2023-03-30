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
 * update the portfolio with Dollar cot strategy.
 */
public class UpdatePortDCAStrategy extends JFrame implements TextFieldView {


  private final JTextField portfolioIdI;

  private final JTextField amountI;
  private final JButton updateStocksDCA;
  private final JButton homeDCASpecificDateStrategy;
  private final JButton exit;
  private final JLabel error;

  private final JTextField numStocksI;
  private final JComboBox year;
  private final JComboBox month;
  private final JComboBox day;

  private JLabel interval;
  private JTextField intervalI;
  private JTextField startDateI;


  /**
   * This is a constructor for UpdatePortDCAStrategy class,
   * it initializes the JFrame to get the user input.
   **/
  public UpdatePortDCAStrategy() {
    super();
    final JPanel updatePortDCA;
    final JLabel portfolioId;
    final JLabel amount;
    final JLabel startDate;
    final JLabel numStocks;
    final JLabel yearLabel;
    final JLabel monthLabel;
    final JLabel dayLabel;
    final Color customColor;
    final Color customColor1;
    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 400);

    this.setPreferredSize(new Dimension(450, 300));


    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);
    this.setBackground(customColor);

    updatePortDCA = new JPanel();
    updatePortDCA.setBorder(
        BorderFactory.createTitledBorder("Add Stocks to Portfolio using Weightage"));
    updatePortDCA.setBounds(200, 350, 200, 200);
    updatePortDCA.setLayout(new BoxLayout(updatePortDCA, BoxLayout.PAGE_AXIS));
    this.setPreferredSize(new Dimension(450, 500));

    updatePortDCA.setBackground(customColor);
    portfolioId = new JLabel("Portfolio Id");
    portfolioIdI = new JTextField("");
    numStocks = new JLabel("Number of Stocks");
    numStocksI = new JTextField("");
    amount = new JLabel("Amount");
    amountI = new JTextField();

    updatePortDCA.add(portfolioId);
    updatePortDCA.add(portfolioIdI);
    updatePortDCA.add(numStocks);
    updatePortDCA.add(numStocksI);
    updatePortDCA.add(amount);
    updatePortDCA.add(amountI);


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

    errorPanel.setBackground(customColor);

    JPanel buttonPanel = new JPanel();
    updateStocksDCA = new JButton("Add Stocks to the Portfolio via Strategy");
    homeDCASpecificDateStrategy = new JButton("Go to Main Menu");
    exit = new JButton("Exit");

    updateStocksDCA.setActionCommand("updateStocksDCA");
    homeDCASpecificDateStrategy.setActionCommand("homeDCASpecificDateStrategy");
    exit.setActionCommand("exit");


    buttonPanel.add(updateStocksDCA);
    buttonPanel.add(homeDCASpecificDateStrategy);
    buttonPanel.add(exit);
    buttonPanel.setLayout(new GridLayout(2, 2));

    buttonPanel.setBackground(customColor);
    errorPanel.setBackground(customColor);
    buttonPanel.setBackground(customColor);
    updatePortDCA.setLayout(new GridLayout(3, 2));

    datePanel.setBackground(customColor);
    JPanel composition = new JPanel();
    composition.setLayout(new GridLayout(2, 1));
    composition.add(updatePortDCA);
    composition.add(datePanel);
    this.add(composition, BorderLayout.PAGE_START);
    this.add(errorPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
    this.setBackground(customColor);
    this.setVisible(true);
    this.pack();
  }

  @Override
  public void addActionListener(ActionListener listener) {
    updateStocksDCA.addActionListener(listener);
    homeDCASpecificDateStrategy.addActionListener(listener);
    exit.addActionListener(listener);
  }

  @Override
  public ArrayList<String> getInput() {
    ArrayList<String> list6 = new ArrayList<>();
    String date = year.getSelectedItem().toString() + "-" + month.getSelectedItem().toString() + "-"
        + day.getSelectedItem().toString();

    list6.add(portfolioIdI.getText());
    list6.add(amountI.getText());
    list6.add(date);
    list6.add(numStocksI.getText());

    return list6;
  }

  @Override
  public void clearField() {
    portfolioIdI.setText("");
    amountI.setText("");
    //startDateI.setText("");
    //  intervalI.setText("");
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
