package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


/**
 * This class implements the IApiAccessData interface to
 * accesses the url to get the updated stock value for particular ticker symbol.
 **/
public class ApiAccessData implements IApiAccessData {

  @Override
  public String apiAccessSpecificDate(String tickerNumber) {
    String apiKey = "2K95QGJGQLFASIP3";
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
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try (InputStream in1 = url.openStream();
         ReadableByteChannel rbc = Channels.newChannel(in1);
         FileOutputStream fos = new FileOutputStream(tickerNumber + ".csv")) {
      fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return tickerNumber + ".csv";
  }


}
