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
 * enables the JFrame to get inputs from the user to
 * calculate the Cost basis without Commission fee.
 **/

public class CostBasisWithoutCommissionPan extends JFrame implements TextFieldView {


  private final JTextField portfolioIdI;

  private final JButton exit;
  private final JButton homeCostBasisWithoutComm;
  private final JButton getCostBasisWO;

  private final JLabel error;


  private final JComboBox year;
  private final JComboBox month;
  private final JComboBox day;


  /**
   * This is a constructor for costBasisWithoutCommissionPan class,
   * it initializes the JFrame to get the user input.
   **/
  public CostBasisWithoutCommissionPan() {

    super();
    final JPanel getCostWO;
    final JLabel portfolioId;
    final JLabel dateComp;
    final JTextField dateCompI;
    final JLabel yearLabel;
    final JLabel monthLabel;
    final JLabel dayLabel;

    final Color customColor;
    final Color customColor1;
    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 400);

    this.setPreferredSize(new Dimension(450, 300));

    getCostWO = new JPanel();

    getCostWO.setBorder(BorderFactory.createTitledBorder("Portfolio Value"));
    getCostWO.setBounds(200, 350, 200, 200);
    getCostWO.setLayout(new BoxLayout(getCostWO, BoxLayout.PAGE_AXIS));

    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    portfolioId = new JLabel("Portfolio Id");
    portfolioIdI = new JTextField("");
    getCostWO.add(portfolioId);
    getCostWO.add(portfolioIdI);

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
    getCostBasisWO = new JButton("Get Cost Basis without Commission Fee");
    getCostBasisWO.setActionCommand("getCostBasisWO");
    homeCostBasisWithoutComm = new JButton("Go to Main Menu");
    homeCostBasisWithoutComm.setActionCommand("homeCostBasisWithoutComm");
    exit = new JButton("Exit");
    exit.setActionCommand("exit");

    buttonPanel.add(getCostBasisWO);
    buttonPanel.add(homeCostBasisWithoutComm);
    buttonPanel.add(exit);
    buttonPanel.setLayout(new GridLayout(2, 2));


    getCostWO.setBackground(customColor);
    getCostWO.setLayout(new GridLayout(1, 2));
    buttonPanel.setBackground(customColor);
    errorPanel.setBackground(customColor);
    datePanel.setBackground(customColor);


    JPanel composition = new JPanel();
    composition.setLayout(new GridLayout(2, 1));
    composition.add(getCostWO);
    composition.add(datePanel);
    this.add(composition, BorderLayout.PAGE_START);
    this.add(errorPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
    this.setVisible(true);
    this.pack();

  }

  @Override
  public void addActionListener(ActionListener listener) {
    getCostBasisWO.addActionListener(listener);
    homeCostBasisWithoutComm.addActionListener(listener);
    exit.addActionListener(listener);
  }

  @Override
  public ArrayList<String> getInput() {
    ArrayList<String> list2 = new ArrayList<>();
    String date = year.getSelectedItem().toString() + "-" + month.getSelectedItem().toString() + "-"
        + day.getSelectedItem().toString();
    list2.add(portfolioIdI.getText());
    list2.add(date);
    list2.add("0");
    return list2;
  }

  @Override
  public void clearField() {
    portfolioIdI.setText("");
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
