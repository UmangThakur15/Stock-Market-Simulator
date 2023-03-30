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
 * creates the JFrame on the screen to get all the options
 * of operations that can be performed on flexible portfolio.
 **/
public class FlexibleAllOptions extends JFrame implements ButtonsView {

  private final JButton exit;
  private final JButton createPortfolio;
  private final JButton getComposition;
  private final JButton portfolioValue;
  private final JButton buyStocks;
  private final JButton sellStocks;
  private final JButton costBasis;
  private final JButton portfolioPerformance;


  /**
   * This is a constructor for FlexibleAllOptions class, it initializes the
   * frame on the screen to view all the options of operations that
   * can be performed on the flexible portfolio.
   **/

  public FlexibleAllOptions() {

    super();
    final Color customColor;
    final Color customColor1;
    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 400);

    this.setPreferredSize(new Dimension(350, 300));

    JPanel radioPanel = new JPanel();

    radioPanel.setBorder(BorderFactory.createTitledBorder("Flexible Portfolio Options"));
    radioPanel.setBounds(200, 350, 200, 200);
    radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.PAGE_AXIS));

    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    createPortfolio = new JButton("Create portfolio");
    getComposition = new JButton("Get Composition");
    portfolioValue = new JButton("Portfolio Value");
    buyStocks = new JButton("Buy Stocks");
    sellStocks = new JButton("Sell Stocks");
    costBasis = new JButton("Cost Basis");
    portfolioPerformance = new JButton("Portfolio Performance");
    exit = new JButton("Exit");

    createPortfolio.setForeground(customColor1);
    getComposition.setForeground(customColor1);
    portfolioValue.setForeground(customColor1);
    buyStocks.setForeground(customColor1);
    sellStocks.setForeground(customColor1);
    costBasis.setForeground(customColor1);
    portfolioPerformance.setForeground(customColor1);
    exit.setForeground(customColor1);

    createPortfolio.setActionCommand("createPortfolio");
    getComposition.setActionCommand("getComposition");
    portfolioValue.setActionCommand("portfolioValue");
    buyStocks.setActionCommand("buyStocks");
    sellStocks.setActionCommand("sellStocks");
    costBasis.setActionCommand("costBasis");
    portfolioPerformance.setActionCommand("portfolioPerformance");
    exit.setActionCommand("exit");

    radioPanel.add(createPortfolio);
    radioPanel.add(getComposition);
    radioPanel.add(portfolioValue);
    radioPanel.add(buyStocks);
    radioPanel.add(sellStocks);
    radioPanel.add(costBasis);
    radioPanel.add(portfolioPerformance);
    radioPanel.add(exit);
    radioPanel.setBackground(customColor);
    GridLayout gridLayout = new GridLayout(5, 2);
    radioPanel.setLayout(gridLayout);
    this.add(radioPanel);
    this.setBackground(customColor1);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    this.pack();

  }

  @Override
  public void addActionListener(ActionListener listener) {

    createPortfolio.addActionListener(listener);
    getComposition.addActionListener(listener);
    portfolioValue.addActionListener(listener);
    buyStocks.addActionListener(listener);
    sellStocks.addActionListener(listener);
    costBasis.addActionListener(listener);
    portfolioPerformance.addActionListener(listener);
    exit.addActionListener(listener);
  }

  @Override
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }


}
