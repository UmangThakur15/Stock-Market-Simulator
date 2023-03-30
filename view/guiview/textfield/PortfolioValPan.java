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
 * get the portfolio value on specific date.
 */
public class PortfolioValPan extends JFrame implements TextFieldView {


  private final JTextField portfolioIdI;

  private final JButton exit;
  private final JButton homePortVal;
  private final JButton getVal;
  private final JLabel error;

  private final JComboBox year;
  private final JComboBox month;
  private final JComboBox day;


  /**
   * This is a constructor for portfolioValPan class,
   * it initializes the JFrame to get the user input.
   **/

  public PortfolioValPan() {


    super();
    final JLabel datePortValue;
    final JPanel getPortValue;
    final JLabel portfolioId;
    final JLabel yearLabel;
    final JLabel monthLabel;
    final JLabel dayLabel;

    final Color customColor;
    final Color customColor1;

    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 400);

    this.setPreferredSize(new Dimension(450, 300));


    getPortValue = new JPanel();

    getPortValue.setBorder(BorderFactory.createTitledBorder("Portfolio Value"));
    getPortValue.setBounds(200, 350, 200, 200);
    getPortValue.setLayout(new BoxLayout(getPortValue, BoxLayout.PAGE_AXIS));

    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    portfolioId = new JLabel("Portfolio Id");
    portfolioIdI = new JTextField("");
    getPortValue.add(portfolioId);
    getPortValue.add(portfolioIdI);

    JPanel datePanel = new JPanel();
    datePortValue = new JLabel("Date     ");
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
    datePanel.add(datePortValue);
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
    homePortVal = new JButton("Go to Main Menu");
    exit = new JButton("Exit");
    getVal = new JButton("Get Portfolio Value");


    getVal.setActionCommand("getVal");
    homePortVal.setActionCommand("homePortVal");
    exit.setActionCommand("exit");


    buttonPanel.add(homePortVal);
    buttonPanel.add(exit);
    buttonPanel.add(getVal);

    getPortValue.setBackground(customColor);
    buttonPanel.setBackground(customColor);
    errorPanel.setBackground(customColor);
    datePanel.setBackground(customColor);


    JPanel composition = new JPanel();
    composition.setLayout(new GridLayout(2, 1));
    composition.add(getPortValue);
    composition.add(datePanel);
    this.add(composition, BorderLayout.PAGE_START);
    this.add(errorPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
    this.setVisible(true);
    this.pack();
  }


  @Override
  public void addActionListener(ActionListener listener) {
    getVal.addActionListener(listener);
    homePortVal.addActionListener(listener);
    exit.addActionListener(listener);

  }

  @Override
  public ArrayList<String> getInput() {
    ArrayList<String> getComposition = new ArrayList<>();
    String date = year.getSelectedItem().toString() + "-" + month.getSelectedItem().toString() + "-"
        + day.getSelectedItem().toString();

    getComposition.add(portfolioIdI.getText());
    getComposition.add(date);
    return getComposition;
  }

  @Override
  public void errorMessage(String message) {
    error.setText(message);
  }

  @Override
  public void clearField() {
    portfolioIdI.setText("");
    // datePortValueI.setText("");
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
