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
 * get create portfolio performance graph.
 */
public class PortfolioPerformancePanel extends JFrame implements TextFieldView {


  private final JTextField portfolioIdI;
  private final JButton getPortPerformance;
  private final JButton homePPPanel;
  private final JButton exit;
  private final JLabel error;


  private final JComboBox year1;
  private final JComboBox month1;
  private final JComboBox day1;


  private final JComboBox year2;
  private final JComboBox month2;
  private final JComboBox day2;


  /**
   * This is a constructor for portfolioPerformancePanel class,
   * it initializes the JFrame to get the user input.
   **/
  public PortfolioPerformancePanel() {

    super();
    final JPanel portfolioPan;
    final JLabel startDate;
    final JLabel endDate;
    final JLabel yearLabel1;
    final JLabel monthLabel1;
    final JLabel dayLabel1;
    final JLabel yearLabel2;
    final JLabel monthLabel2;
    final JLabel dayLabel2;


    final Color customColor;
    final Color customColor1;
    final JLabel portfolioId;
    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 400);

    this.setPreferredSize(new Dimension(450, 400));


    portfolioPan = new JPanel();
    portfolioPan.setBorder(BorderFactory.createTitledBorder("Date Range to determine"
        + " Portfolio Performance"));
    portfolioPan.setBounds(200, 350, 200, 200);
    portfolioPan.setLayout(new BoxLayout(portfolioPan, BoxLayout.PAGE_AXIS));

    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    portfolioId = new JLabel("Portfolio Id");
    portfolioIdI = new JTextField("");

    portfolioPan.add(portfolioId);
    portfolioPan.add(portfolioIdI);

    JPanel errorPanel = new JPanel();
    error = new JLabel("");
    errorPanel.add(error);

    JPanel buttonPanel = new JPanel();
    getPortPerformance = new JButton("Get Portfolio Performance Bar Graph");
    homePPPanel = new JButton("Go to Main Menu");
    exit = new JButton("Exit");


    getPortPerformance.setActionCommand("getPortPerformance");
    homePPPanel.setActionCommand("homePPPanel");
    exit.setActionCommand("exit");

    buttonPanel.add(getPortPerformance);
    buttonPanel.add(homePPPanel);
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
        HelperClass.setDay(year1, month1, day1);
      }
    };
    year1 = new JComboBox(years1);
    year1.addActionListener(listener1);

    String[] monthNumber1 = {"01", "02", "03", "04", "05", "06", "07",
        "08", "09", "10", "11", "12"};
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

    String[] monthNumber2 = {"01", "02", "03", "04", "05", "06", "07",
        "08", "09", "10", "11", "12"};
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


    datePanel1.setBackground(customColor);
    datePanel2.setBackground(customColor);
    portfolioPan.setBackground(customColor);
    errorPanel.setBackground(customColor);
    buttonPanel.setBackground(customColor);


    JPanel composition = new JPanel();
    composition.setLayout(new GridLayout(3, 1));
    composition.add(portfolioPan);
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
    getPortPerformance.addActionListener(listener);
    homePPPanel.addActionListener(listener);
    exit.addActionListener(listener);
  }

  @Override
  public ArrayList<String> getInput() {
    ArrayList<String> list5 = new ArrayList<>();
    String startDate = year1.getSelectedItem().toString() + "-"
        + month1.getSelectedItem().toString() + "-"
        + day1.getSelectedItem().toString();
    String endDate = year2.getSelectedItem().toString() + "-"
        + month2.getSelectedItem().toString() + "-"
        + day2.getSelectedItem().toString();

    list5.add(portfolioIdI.getText());
    //list5.add(amountI.getText());
    // list5.add(intervalI.getText());
    list5.add(startDate);
    list5.add(endDate);
    //list5.add(numStocksI.getText());
    return list5;
  }

  @Override
  public void errorMessage(String message) {
    error.setText(message);

  }

  @Override
  public void clearField() {
    portfolioIdI.setText("");
    // amountI.setText("");
    // intervalI.setText("");
    // startDateI.setText("");
    // endDateI.setText("");
    // numStocksI.setText("");

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
