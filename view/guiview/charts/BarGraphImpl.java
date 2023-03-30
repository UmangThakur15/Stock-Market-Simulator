package view.guiview.charts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JButton;


/**
 * This class implements the IBarChart interface, it
 * creates the bar graph for the portfolio performance
 * for a defined date range.
 */
public class BarGraphImpl extends JPanel implements IBarChart {

  private final HashMap<LocalDate, Integer> map;
  private final String title;
  private JPanel portPer;
  private JButton home;
  private JButton exit;


  /**
   * This a constructor for BarGraphImpl class, it initializes the
   * map and title of the BarGraph.
   *
   * @param map HashMap, it contains HashMap
   * @param t   String, it contains the Title of the BarGraph
   */
  public BarGraphImpl(HashMap<LocalDate, Integer> map, String t) {

    this.map = map;
    title = t;

  }


  /**
   * This method enables to draw bar Graph.
   *
   * @param graphics the <code>Graphics</code> object to protect
   */
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    final Color customColor;
    double maxValue = Collections.max(map.values());
    double minValue = 0;


    Dimension dim = getSize();
    customColor = new Color(135, 206, 235);
    //  int clientWidth = dim.width;
    int clientWidth = dim.width - 50;
    int clientHeight = dim.height - 50;
    int barWidth = clientWidth / map.size();
    Font titleFont = new Font("Book Antiqua", Font.BOLD, 15);
    FontMetrics titleFontMetrics = graphics.getFontMetrics(titleFont);
    Font labelFont = new Font("Book Antiqua", Font.BOLD, 10);
    FontMetrics labelFontMetrics = graphics.getFontMetrics(labelFont);
    int titleWidth = titleFontMetrics.stringWidth(title);
    int q = titleFontMetrics.getAscent();
    int p = (clientWidth - titleWidth) / 2;
    graphics.setFont(titleFont);
    graphics.drawString(title, p, q);
    int top = titleFontMetrics.getHeight();
    int bottom = labelFontMetrics.getHeight();
    if (maxValue == minValue) {
      return;
    }
    double scale = (clientHeight - top - bottom) / (maxValue - minValue);
    q = clientHeight - labelFontMetrics.getDescent();
    graphics.setFont(labelFont);
    int j = 0;
    for (HashMap.Entry<LocalDate, Integer> set : map.entrySet()) {
      int valueP = j * barWidth + 1;
      int valueQ = top;
      // System.out.println(set.getValue());
      // System.out.println(set.getKey());
      int height = (int) (set.getValue() * scale);
      if (set.getValue() >= 0) {
        valueQ += (int) ((maxValue - set.getValue()) * scale);
      } else {
        valueQ += (int) (maxValue * scale);
        height = -height;
      }
      graphics.setColor(customColor);
      graphics.fillRect(valueP, valueQ, barWidth - 2, height);
      graphics.setColor(Color.black);
      graphics.drawRect(valueP, valueQ, barWidth - 2, height);
      int labelWidth = labelFontMetrics.stringWidth(set.getKey().toString());
      p = j * barWidth + (barWidth - labelWidth) / 2;
      graphics.drawString(set.getKey().toString(), p, q);
      j++;
    }
    graphics.drawString("Amount", clientWidth, clientHeight - 250);
    graphics.drawString("Date Range", clientWidth - 400, clientHeight + 15);
  }


  @Override
  public void addActionListener(ActionListener listener) {
    home.addActionListener(listener);
    exit.addActionListener(listener);

  }


  @Override
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }

}
