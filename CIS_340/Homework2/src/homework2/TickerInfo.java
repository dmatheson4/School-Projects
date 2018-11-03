/**
 * Dan Matheson
 * This class will serve as the bean for the jsp to use to get ticker info from
 */
package homework2;


public class TickerInfo {
	
	private static String ticker="";
	private static String date="";
	private static double open=0;
	private static double high=0;
	private static double low=0;
	private static double close=0;
	private static double volume=0;
	
	//create getters and setters for the variables
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		TickerInfo.date = date;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		TickerInfo.open = open;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		TickerInfo.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		TickerInfo.low = low;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		TickerInfo.close = close;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		TickerInfo.volume = volume;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		TickerInfo.ticker = ticker;
	}
	
}
