package view.guiview.buttons;


import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;


/**
 * This class implements the ButtonsView interface and
 * creates the JFrame on the screen to view the home and
 * exit option.
 **/
public class PortfolioPerformanceAll extends JPanel implements ButtonsView {


  private final JButton homePPB;
  private final JButton exit;


  /**
   * This is a constructor for PortfolioPerformanceAll class, it initializes the
   * frame on the screen to view the home and
   * exit option.
   **/
  public PortfolioPerformanceAll() {
    final JPanel portPer;
    portPer = new JPanel();
    homePPB = new JButton("Go to Main Menu");
    exit = new JButton("Exit");

    homePPB.setActionCommand("homePPB");
    exit.setActionCommand("exit");


    portPer.add(homePPB);
    portPer.add(exit);

    portPer.setLocation(10, 850);
    portPer.setSize(50, 50);

    this.add(portPer, BorderLayout.AFTER_LAST_LINE);
    this.setLayout(new GridLayout(3, 1));
    setVisible(true);
  }


  @Override
  public void addActionListener(ActionListener listener) {
    homePPB.addActionListener(listener);
    exit.addActionListener(listener);
  }

  @Override
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }


}
