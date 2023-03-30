package view.guiview.buttons;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;


/**
 * This class implements the ButtonsView interface and
 * creates the JFrame on the screen to get all the options to get
 * create a new portfolio.
 **/

public class CreatePortfolioOptionsFlexible extends JFrame implements ButtonsView {

  private final JButton createPortByInput;
  private final JButton createPortThroughFile;
  private final JButton createPortDCSWEndDate;
  private final JButton createPortDCSWOEndDate;
  private final JButton createPortDCSWEndDateEw;
  private final JButton createPortDCSWOEndDateEw;
  private final JButton homeCreatePortAll;
  private final JButton exit;


  /**
   * This is a constructor for createPortfolioOptionsFlexible class, it initializes the
   * frame on the screen to view all the options available for creating a new portfolio.
   **/
  public CreatePortfolioOptionsFlexible() {

    super();


    final Color customColor;
    final Color customColor1;
    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 400);

    this.setPreferredSize(new Dimension(700, 300));

    JPanel mainPanel = new JPanel();

    mainPanel.setBorder(BorderFactory.createTitledBorder("Flexible Portfolio Creation Options"));
    mainPanel.setBounds(200, 350, 200, 200);
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    createPortByInput = new JButton("Add Manually");
    createPortThroughFile = new JButton("Add via File");
    createPortDCSWEndDateEw = new JButton("Add via strategy with end date Equal Weights");
    createPortDCSWEndDate = new JButton("Add via strategy with end date");
    createPortDCSWOEndDate = new JButton("Add via strategy without end date");
    createPortDCSWOEndDateEw = new JButton("Add via strategy without end date Equal Weights");
    homeCreatePortAll = new JButton("Back to Main Menu");
    exit = new JButton("Exit");

    createPortByInput.setActionCommand("createPortByInput");
    createPortThroughFile.setActionCommand("createPortThroughFile");
    createPortDCSWEndDate.setActionCommand("createPortDCSWEndDate");
    createPortDCSWOEndDate.setActionCommand("createPortDCSWOEndDate");
    createPortDCSWEndDateEw.setActionCommand("createPortDCSWEndDateEw");
    createPortDCSWOEndDateEw.setActionCommand("createPortDCSWOEndDateEw");
    homeCreatePortAll.setActionCommand("homeCreatePortAll");
    exit.setActionCommand("exit");

    createPortByInput.setForeground(customColor1);
    createPortThroughFile.setForeground(customColor1);
    createPortDCSWEndDate.setForeground(customColor1);
    createPortDCSWOEndDate.setForeground(customColor1);
    createPortDCSWEndDateEw.setForeground(customColor1);
    createPortDCSWOEndDateEw.setForeground(customColor1);
    homeCreatePortAll.setForeground(customColor1);
    exit.setForeground(customColor1);

    mainPanel.add(createPortByInput);
    mainPanel.add(createPortThroughFile);
    mainPanel.add(createPortDCSWEndDate);
    mainPanel.add(createPortDCSWOEndDate);
    mainPanel.add(createPortDCSWEndDateEw);
    mainPanel.add(createPortDCSWOEndDateEw);
    mainPanel.add(homeCreatePortAll);
    mainPanel.add(exit);


    mainPanel.setBackground(customColor);
    GridLayout gridLayout = new GridLayout(6, 2);
    mainPanel.setLayout(gridLayout);
    this.add(mainPanel);
    this.setBackground(customColor);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    this.pack();

  }


  @Override
  public void addActionListener(ActionListener listener) {
    createPortByInput.addActionListener(listener);
    createPortThroughFile.addActionListener(listener);
    createPortDCSWEndDate.addActionListener(listener);
    createPortDCSWOEndDate.addActionListener(listener);
    createPortDCSWEndDateEw.addActionListener(listener);
    createPortDCSWOEndDateEw.addActionListener(listener);
    homeCreatePortAll.addActionListener(listener);
    exit.addActionListener(listener);
  }


  @Override
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }
}
