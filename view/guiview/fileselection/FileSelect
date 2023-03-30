package view.guiview.fileselection;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;


/**
 * This class implements the IFileSelection interface, it
 * enables the user to choose the file from the specific path
 * to upload or create a portfolio.
 **/
public class FileSelect extends JFrame implements IFileSelection {
  private final JButton done;
  private final JButton homeFileSelect;
  private final JButton exit;

  private final JLabel error;
  private final JFileChooser fileChooser;
  private final int userSelection;


  /**
   * This is a constructor for fileSelect class, it
   * initializes the JFrame on the screen to select a file from
   * the specific path.
   */
  public FileSelect() {
    super();

    final Color customColor;
    final Color customColor1;
    setTitle("Flexible GUI");
    this.setBounds(550, 350, 300, 400);

    this.setPreferredSize(new Dimension(450, 400));


    fileChooser = new JFileChooser();

    fileChooser.setBorder(BorderFactory.createTitledBorder("Flexible Portfolio Creation Options"));
    //fileChooser.setBounds(200,350,200,200);
    fileChooser.setLayout(new BoxLayout(fileChooser, BoxLayout.PAGE_AXIS));

    customColor = new Color(135, 206, 235);
    customColor1 = new Color(30, 144, 255);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    fileChooser.setDialogTitle("Select File to Open");
    userSelection = fileChooser.showOpenDialog(this);
    done = new JButton("Please click to Upload");
    done.setActionCommand("done");
    homeFileSelect = new JButton("Back to Main Menu");
    homeFileSelect.setActionCommand("homeFileSelect");
    exit = new JButton("Exit");
    exit.setActionCommand("exit");
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(done);
    buttonPanel.add(homeFileSelect);
    buttonPanel.add(exit);
    error = new JLabel();
    error.setText("");
    error.setBackground(customColor);
    JPanel errorPanel = new JPanel();
    errorPanel.add(error);

    fileChooser.setBackground(customColor);
    buttonPanel.setBackground(customColor);
    errorPanel.setBackground(customColor);


    errorPanel.setLayout(new GridLayout(1, 1));
    errorPanel.setBackground(customColor);
    this.add(buttonPanel, BorderLayout.PAGE_START);
    this.add(errorPanel, BorderLayout.CENTER);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(2, 1));
    this.setBackground(customColor);
    setVisible(true);
    this.pack();
  }

  @Override
  public String getInput() {
    return fileChooser.getSelectedFile().getAbsolutePath();
  }

  @Override
  public int getFileChooser() {
    return userSelection;
  }

  @Override
  public void setHint(String message) {
    error.setText(message);
  }

  @Override
  public void addActionListener(ActionListener listener) {
    fileChooser.addActionListener(listener);
    done.addActionListener(listener);
    homeFileSelect.addActionListener(listener);
    exit.addActionListener(listener);
  }

  @Override
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();

  }

}
