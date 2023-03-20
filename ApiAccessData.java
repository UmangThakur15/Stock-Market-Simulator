import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

/**
 * This class accesses the url to get the updated stock value for particular ticker symbol.
 **/
class ApiAccessData {
  private String timestamp;
  private Double close;

  protected void apiAccess(String tickerNumber) {
    String apiKey = "GM9LFVJDF2AACH8U";
    String stockSymbol = tickerNumber; //ticker symbol for Google
    URL url = null;

    try {
      url = new URL("https://www.alphavantage"
              + ".co/query?function=TIME_SERIES_DAILY"
              + "&outputsize=full"
              + "&symbol"
              + "=" + stockSymbol + "&apikey=" + apiKey + "&datatype=csv");
    } catch (MalformedURLException e) {
      throw new RuntimeException("the alphavintage API has either changed or "
              + "no longer works or you provided incorrect ticker Number");
    }

    InputStream in = null;
    StringBuilder output = new StringBuilder();
    String[] answer = null;

    try {
      in = url.openStream();
      int b;
      int count = 0;

      while ((b = in.read()) != -1) {
        if (b == '\n') {
          count++;
          if (count == 2) {
            break;
          }
        }
        if (count == 1) {
          output.append((char) b);
        }
      }
      for (int i = 0; i < output.length(); i++) {
        answer = output.toString().split(",");
      }

      if (answer.length == 1) {
        throw new IllegalArgumentException("Invalid ticker Number provided");
      }
      setTimestamp(answer[0].trim());
      this.setClose(Double.valueOf(answer[4]));
    } catch (IOException e) {
      throw new IllegalArgumentException("No price data found for " + stockSymbol);
    }

  }


  protected String apiAccessSpecificDate(String tickerNumber) {
    String apiKey = "GM9LFVJDF2AACH8U";
    String stockSymbol = tickerNumber;
    URL url = null;

    try {
      url = new URL("https://www.alphavantage"
              + ".co/query?function=TIME_SERIES_DAILY"
              + "&outputsize=full"
              + "&symbol"
              + "=" + stockSymbol + "&apikey=" + apiKey + "&datatype=csv");
    } catch (MalformedURLException e) {
      throw new RuntimeException("the alpha Vintage API has either changed or "
              + "no longer works or you provided incorrect ticker Number");
    }

    try (InputStream in = url.openStream();
         ReadableByteChannel rbc = Channels.newChannel(in);
         FileOutputStream fos = new FileOutputStream(tickerNumber + ".csv")) {
      fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    } catch (IOException e) {
      throw new IllegalArgumentException("No price data found for " + stockSymbol);
    }
    return tickerNumber + ".csv";
  }

  private LocalDate isWeekend(LocalDate ld) throws ParseException {
    DayOfWeek day = DayOfWeek.of(ld.get(ChronoField.DAY_OF_WEEK));
    if (day == DayOfWeek.SUNDAY) {
      LocalDate newDate = ld.minusDays(2);
      return newDate;
    }
    if (day == DayOfWeek.SATURDAY) {
      LocalDate newDate = ld.minusDays(1);
      return newDate;
    }
    return ld;
  }

  /**
   * This method gives date for the Ticker Number.
   *
   * @return String This method gives date for the Ticker Number.
   */

  public String getTimestamp() {
    return this.timestamp;
  }

  private void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * This method gives the closing amount of a particular ticker Number.
   *
   * @return double The closing amount of a particular ticker Number.
   */

  public double getClose() {
    return this.close;
  }


  private void setClose(double close) {
    this.close = close;
  }


}
