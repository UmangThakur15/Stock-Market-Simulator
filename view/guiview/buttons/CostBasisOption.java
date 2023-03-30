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
 * Cost Basis on a particular Portfolio.
 **/
public class CostBasisOption extends JFrame implements ButtonsView {


  private final JButton withCommission;
  private final JButton withoutCommission;
  private final JButton homeCostBasisMain;
  private final JButton exit;


  /**
   * This is a constructor for costBasisOption class, it initializes the
   * frame on the screen to view cost Basis options with or without commission fee.
   **/
  public CostBasisOption() {

    super();
    final JPanel costBasis;


    final Color customColor;
    final Color customColor1;
    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 400);

    this.setPreferredSize(new Dimension(600, 300));


    costBasis = new JPanel();


    costBasis.setBorder(BorderFactory.createTitledBorder("Cost Basis"));
    costBasis.setBounds(200, 350, 200, 200);
    costBasis.setLayout(new BoxLayout(costBasis, BoxLayout.PAGE_AXIS));

    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    withCommission = new JButton("Cost Basis with Commission Fees");
    withoutCommission = new JButton("Cost Basis without Commission Fees");
    homeCostBasisMain = new JButton("Go to Main Menu");
    exit = new JButton("Exit");

    withCommission.setActionCommand("withCommission");
    withoutCommission.setActionCommand("withoutCommission");
    homeCostBasisMain.setActionCommand("homeCostBasisMain");
    exit.setActionCommand("exit");

    costBasis.setBackground(customColor);

    costBasis.add(withCommission);
    costBasis.add(withoutCommission);
    costBasis.add(homeCostBasisMain);
    costBasis.add(exit);

    GridLayout gridLayout = new GridLayout(2, 2);
    gridLayout.setHgap(80);
    gridLayout.setVgap(80);
    costBasis.setLayout(gridLayout);
    this.setBackground(customColor);
    this.add(costBasis);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    this.pack();
  }


  @Override
  public void addActionListener(ActionListener listener) {
    withCommission.addActionListener(listener);
    withoutCommission.addActionListener(listener);
    homeCostBasisMain.addActionListener(listener);
    exit.addActionListener(listener);

  }


  @Override
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }
}
