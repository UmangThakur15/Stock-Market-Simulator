package view.guiview.textfield;


import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import view.guiview.helperclass.HelperClass;

/**
 * This class implements the TextFieldView interface, it
 * enables the JFrame to get inputs from the user to
 * get composition on specific date.
 */
public class GetCompositionPanel extends JFrame implements TextFieldView {


  private final JTextField portfolioIdI;

  private final JButton exit;
  private final JButton homeGetComposition;
  private final JButton getCompositionButton;
  private final JTextArea error;
  private final JComboBox year;
  private final JComboBox month;
  private final JComboBox day;

  /**
   * This is a constructor for GetCompositionPanel class,
   * it initializes the JFrame to get the user input.
   **/

  public GetCompositionPanel() {

    super();
    final JPanel getCompo;
    final JLabel portfolioId;
    final JLabel dateComp;
    final JLabel yearLabel;
    final JLabel monthLabel;
    final JLabel dayLabel;
    final JPanel middlePanel;
    final JScrollPane scroll;

    final Color customColor;
    final Color customColor1;


    setTitle("Flexible GUI");
    this.setBounds(550, 300, 300, 400);


    getCompo = new JPanel();

    getCompo.setBorder(BorderFactory.createTitledBorder("Portfolio Composition"));
    getCompo.setBounds(200, 200, 200, 200);
    getCompo.setLayout(new BoxLayout(getCompo, BoxLayout.PAGE_AXIS));

    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    portfolioId = new JLabel("Portfolio Id");
    portfolioIdI = new JTextField(20);

    getCompo.add(portfolioId);
    getCompo.add(portfolioIdI);


    JPanel datePanel = new JPanel();
    dateComp = new JLabel("Date     ");
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
    datePanel.add(dateComp);
    datePanel.add(yearLabel);
    datePanel.add(year);
    datePanel.add(monthLabel);
    datePanel.add(month);
    datePanel.add(dayLabel);
    datePanel.add(day);


    middlePanel = new JPanel();
    middlePanel.setBorder(new TitledBorder(new EtchedBorder(), "Display Area"));


    error = new JTextArea(20, 58);
    error.setEditable(false); // set textArea non-editable
    scroll = new JScrollPane(error);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


    middlePanel.add(scroll);

    scroll.setBackground(customColor);

    JPanel buttonPanel = new JPanel();
    getCompositionButton = new JButton("Get composition");
    getCompositionButton.setActionCommand("getCompositionButton");
    homeGetComposition = new JButton("Go to Main Menu");
    homeGetComposition.setActionCommand("homeGetComposition");
    exit = new JButton("Exit");
    exit.setActionCommand("exit");

    buttonPanel.add(getCompositionButton);
    buttonPanel.add(homeGetComposition);
    buttonPanel.add(exit);

    buttonPanel.setBackground(customColor);
    getCompo.setBackground(customColor);
    datePanel.setBackground(customColor);
    middlePanel.setBackground(customColor);


    JPanel composition = new JPanel();
    composition.setLayout(new GridLayout(2, 1));
    composition.add(getCompo);
    composition.add(datePanel);
    this.add(composition, BorderLayout.PAGE_START);
    this.add(middlePanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
    this.setVisible(true);
    this.pack();

  }


  @Override
  public void addActionListener(ActionListener listener) {

    getCompositionButton.addActionListener(listener);
    homeGetComposition.addActionListener(listener);
    exit.addActionListener(listener);

  }

  @Override
  public ArrayList<String> getInput() {
    ArrayList<String> getCompositionList = new ArrayList<>();

    String date = year.getSelectedItem().toString() + "-" + month.getSelectedItem().toString() + "-"
        + day.getSelectedItem().toString();

    getCompositionList.add(portfolioIdI.getText());
    getCompositionList.add(date);
    return getCompositionList;
  }

  @Override
  public void errorMessage(String message) {
    error.setText(message);
  }

  @Override
  public void clearField() {
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
