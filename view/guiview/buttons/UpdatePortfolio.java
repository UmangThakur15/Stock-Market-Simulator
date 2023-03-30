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
 * creates the JFrame on the screen to view the all the
 * options available to update an existing portfolio.
 **/
public class UpdatePortfolio extends JFrame implements ButtonsView {


  private final JButton normalUpdate;
  private final JButton withDCSWithEnDate;
  private final JButton withDCSWOEnDate;
  private final JButton withWeightOnSpecificDate;
  private final JButton homeBuyMain;
  private final JButton exit;


  /**
   * This is a constructor for UpdatePortfolio class, it
   * initializes the frame on the screen to view all the options
   * available to update an existing portfolio.
   */
  public UpdatePortfolio() {

    super();


    final JPanel updatePortOptions;


    final Color customColor;
    final Color customColor1;
    setTitle("Flexible GUI");
    this.setBounds(550, 350, 500, 400);

    this.setPreferredSize(new Dimension(800, 400));


    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);

    updatePortOptions = new JPanel();


    updatePortOptions.setBorder(BorderFactory.createTitledBorder("Options to Buy Stocks"));
    updatePortOptions.setBounds(200, 350, 200, 200);
    updatePortOptions.setLayout(new BoxLayout(updatePortOptions, BoxLayout.PAGE_AXIS));

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    normalUpdate = new JButton("Add stocks one by one");
    withDCSWithEnDate = new JButton("Add stocks Using Dollar Cost Strategy With End Date");
    withDCSWOEnDate = new JButton("Add stocks Using Dollar Cost Strategy Without End Date");
    withWeightOnSpecificDate = new JButton("Add stocks by Investment");
    homeBuyMain = new JButton("Go to Main Menu");
    exit = new JButton("Exit");

    normalUpdate.setActionCommand("normalUpdate");
    withDCSWithEnDate.setActionCommand("withDCSWithEnDate");
    withDCSWOEnDate.setActionCommand("withDCSWOEnDate");
    withWeightOnSpecificDate.setActionCommand("withWeightOnSpecificDate");
    homeBuyMain.setActionCommand("homeBuyMain");
    exit.setActionCommand("exit");

    updatePortOptions.add(normalUpdate);
    updatePortOptions.add(withDCSWithEnDate);
    updatePortOptions.add(withDCSWOEnDate);
    updatePortOptions.add(withWeightOnSpecificDate);
    updatePortOptions.add(homeBuyMain);
    updatePortOptions.add(exit);

    updatePortOptions.setBackground(customColor);

    GridLayout gridLayout = new GridLayout(3, 2);
    updatePortOptions.setLayout(gridLayout);
    this.add(updatePortOptions);
    this.setBackground(customColor);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    this.pack();
  }

  @Override
  public void addActionListener(ActionListener listener) {
    normalUpdate.addActionListener(listener);
    withDCSWithEnDate.addActionListener(listener);
    withDCSWOEnDate.addActionListener(listener);
    withWeightOnSpecificDate.addActionListener(listener);
    homeBuyMain.addActionListener(listener);
    exit.addActionListener(listener);

  }

  @Override
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }
}

