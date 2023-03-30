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
 * enables the JFrame to get inputs from the user
 * about user info.
 */
public class JFrameView extends JFrame implements TextFieldView {


  private final JTextField usernameI;
  private final JTextField useridI;
  private final JTextField useremailI;

  private final JButton exit;
  private final JButton next;
  private final JLabel error;


  /**
   * This is a constructor for JFrameView class,
   * it initializes the JFrame to get the user input.
   **/
  public JFrameView() {
    super();
    final JLabel userId;
    final JLabel userName;
    final JLabel emailId;
    final JPanel pan;
    final Color customColor;
    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 400);

    this.setPreferredSize(new Dimension(350, 300));


    pan = new JPanel();
    pan.setBorder(BorderFactory.createTitledBorder("User Info"));
    pan.setBounds(200, 350, 200, 200);
    pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));

    customColor = new Color(135, 206, 235);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    userId = new JLabel("User Id");
    useridI = new JTextField("");
    userName = new JLabel("User Name");
    usernameI = new JTextField("");
    emailId = new JLabel("Email Id");
    useremailI = new JTextField("");

    pan.add(userId);
    pan.add(useridI);
    pan.add(userName);
    pan.add(usernameI);
    pan.add(emailId);
    pan.add(useremailI);

    JPanel errorPanel = new JPanel();
    error = new JLabel("");
    errorPanel.add(error);

    JPanel buttonPanel = new JPanel();
    exit = new JButton("Exit");
    next = new JButton("Next");
    exit.setActionCommand("exit");
    next.setActionCommand("next");

    buttonPanel.add(next);
    buttonPanel.add(exit);

    pan.setBackground(customColor);
    buttonPanel.setBackground(customColor);
    errorPanel.setBackground(customColor);

    JPanel composition = new JPanel();
    pan.setLayout(new GridLayout(4, 2));
    this.add(pan, BorderLayout.PAGE_START);
    this.add(errorPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.PAGE_END);
    this.setLayout(new GridLayout(3, 1));
    this.setBackground(customColor);
    this.setVisible(true);
    this.pack();
  }


  @Override
  public void addActionListener(ActionListener listener) {
    next.addActionListener(listener);
    exit.addActionListener(listener);
  }

  @Override
  public ArrayList<String> getInput() {
    ArrayList<String> userInfoInput = new ArrayList<>();
    userInfoInput.add(useridI.getText());
    userInfoInput.add(usernameI.getText());
    userInfoInput.add(useremailI.getText());
    return userInfoInput;
  }


  @Override
  public void clearField() {
    useridI.setText("");
    usernameI.setText("");
    useremailI.setText("");

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
