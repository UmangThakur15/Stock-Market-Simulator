package view.guiview.textfield;


import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 * This class implements the TextFieldView interface, it
 * enables the JFrame to get inputs from the user to
 * get portfolio Id to get details.
 */
public class GetPortfolioId extends JFrame implements TextFieldView {


  private final JTextField portfolioIdI;
  private final JLabel error;
  private final JButton selectFilePathNow;
  private final JButton exit;
  private final JButton homeGetFiles;

  private Color customColor;


  /**
   * This is a constructor for GetPortfolioId class,
   * it initializes the JFrame to get the user input.
   **/
  public GetPortfolioId() {
    super();
    final JPanel portInfo;
    final JLabel portfolioId;
    final Color customColor1;
    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 400);

    this.setPreferredSize(new Dimension(450, 300));
    this.setBackground(customColor);
    portInfo = new JPanel();
    portInfo.setBorder(BorderFactory.createTitledBorder("Enter a new Portfolio Id"));
    portInfo.setBounds(200, 350, 200, 200);
    portInfo.setLayout(new BoxLayout(portInfo, BoxLayout.PAGE_AXIS));

    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    portfolioId = new JLabel("Portfolio Id");
    portfolioIdI = new JTextField("");
    selectFilePathNow = new JButton("Create Portfolio");
    homeGetFiles = new JButton("Go to Main Menu");
    exit = new JButton("Exit");


    selectFilePathNow.setActionCommand("selectFilePathNow");
    homeGetFiles.setActionCommand("homeGetFiles");
    exit.setActionCommand("exit");

    JPanel errorPanel = new JPanel();
    error = new JLabel("");
    errorPanel.add(error);

    portInfo.setBackground(customColor);

    portInfo.add(portfolioId);
    portInfo.add(portfolioIdI);
    portInfo.add(selectFilePathNow);
    portInfo.add(homeGetFiles);
    portInfo.add(exit);

    GridLayout gridLayout = new GridLayout(4, 2);
    gridLayout.setHgap(20);
    gridLayout.setVgap(30);
    portInfo.setLayout(gridLayout);
    portInfo.setBackground(customColor);

    this.add(portInfo, BorderLayout.PAGE_START);
    this.add(errorPanel, BorderLayout.PAGE_END);
    //this.setLayout(new GridLayout(2,1));
    this.setBackground(customColor);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    this.pack();

  }

  @Override
  public void addActionListener(ActionListener listener) {
    selectFilePathNow.addActionListener(listener);
    exit.addActionListener(listener);
    homeGetFiles.addActionListener(listener);

  }

  @Override
  public ArrayList<String> getInput() {
    ArrayList<String> list = new ArrayList<>();
    list.add(portfolioIdI.getText());
    return list;
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
