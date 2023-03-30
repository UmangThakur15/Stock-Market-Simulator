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
 * creates the frame on the screen to take input from the user
 * to calculate cost basis on the basis of entered Commission Fee.
 **/
public class CostBasisWithCommissionPan extends JFrame implements TextFieldView {


  private final JTextField portfolioIdI;

  private final JTextField commissionFeeI;
  private final JButton exit;
  private final JButton homeCostBasisWithComm;
  private final JButton getCostBasisW;

  private final JLabel error;


  private final JComboBox year;
  private final JComboBox month;
  private final JComboBox day;


  /**
   * This is the Constructor of costBasisWithCommissionPan class,
   * it initializes the JFrame on the screen to get user input
   * to calculate Cost basis.
   **/
  public CostBasisWithCommissionPan() {

    super();
    final JPanel getCostW;
    final JLabel portfolioId;
    final JLabel dateComp;
    final JTextField dateCompI;
    final JLabel yearLabel;
    final JLabel monthLabel;
    final JLabel dayLabel;
    final JLabel commissionFee;
    final Color customColor;
    final Color customColor1;

    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 400);
    this.setPreferredSize(new Dimension(450, 300));


    getCostW = new JPanel();


    getCostW.setBorder(BorderFactory.createTitledBorder("Cost Basis with Commission Fee"));
    getCostW.setBounds(200, 350, 200, 200);
    getCostW.setLayout(new BoxLayout(getCostW, BoxLayout.PAGE_AXIS));

    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    portfolioId = new JLabel("Portfolio Id");
    portfolioIdI = new JTextField("");
    commissionFee = new JLabel("Commission Fee");
    commissionFeeI = new JTextField("");
    getCostW.add(portfolioId);
    getCostW.add(portfolioIdI);
    getCostW.add(commissionFee);
    getCostW.add(commissionFeeI);


    JPanel datePanel = new JPanel();
    dateComp = new JLabel("Date     ");
    yearLabel = new JLabel("Year");
    monthLabel = new JLabel("Month");
    dayLabel = new JLabel("Day");
    dateCompI = new JTextField("");

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
    datePanel.add(dateComp);
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
    getCostBasisW = new JButton("Get Cost Basis with Commission Fee");
    getCostBasisW.setActionCommand("getCostBasisW");
    homeCostBasisWithComm = new JButton("Go To Main Menu");
    homeCostBasisWithComm.setActionCommand("homeCostBasisWithComm");
    exit = new JButton("Exit");
    exit.setActionCommand("exit");

    buttonPanel.add(getCostBasisW);
    buttonPanel.add(homeCostBasisWithComm);
    buttonPanel.add(exit);


    getCostW.setBackground(customColor);
    datePanel.setBackground(customColor);
    errorPanel.setBackground(customColor);
    buttonPanel.setBackground(customColor);

    getCostW.setLayout(new GridLayout(2, 2));

    JPanel composition = new JPanel();
    composition.setLayout(new GridLayout(2, 1));
    composition.add(getCostW);
    composition.add(datePanel);
    this.add(composition, BorderLayout.PAGE_START);
    this.add(errorPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
    this.setVisible(true);
    this.pack();

  }

  @Override
  public void addActionListener(ActionListener listener) {
    getCostBasisW.addActionListener(listener);
    homeCostBasisWithComm.addActionListener(listener);
    exit.addActionListener(listener);
  }

  @Override
  public ArrayList<String> getInput() {
    ArrayList<String> list = new ArrayList<>();
    String date = year.getSelectedItem().toString() + "-" + month.getSelectedItem().toString() + "-"
        + day.getSelectedItem().toString();
    list.add(portfolioIdI.getText());
    list.add(date);
    list.add(commissionFeeI.getText());
    return list;
  }

  @Override
  public void clearField() {
    portfolioIdI.setText("");
    commissionFeeI.setText("");
  }

  @Override
  public void errorMessage(String message) {
    error.setText(message);
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
