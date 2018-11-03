/**
 * Dan Matheson
 * 2/9/18
 * This program will store the stock information that has been gathered from the alphavantage website as a comma seperated value.
 */
import java.io.*;
import java.sql.Date;

public class StockQuote implements Serializable{

	private static final long serialVersionUID = 1L;
	private Date date;
	private double open;
	private double high;
	private double low;
	private double close;
	private double volume;

	//create a constructor that takes in a comma seperated string
	public StockQuote(String []data)
	{
		//set the parsed values of the data
		date = java.sql.Date.valueOf(data[0]);
		open = Double.parseDouble(data[1]);
		high = Double.parseDouble(data[2]);
		low = Double.parseDouble(data[3]);
		close = Double.parseDouble(data[4]);
		volume = Double.parseDouble(data[5]);
	}
	//create a private constructor to prevent the default constructor from working
	@SuppressWarnings("unused")
	private StockQuote()
	{

	}
	//create getters for all of the stock information
	public Date getDate() {
		return date;
	}
	public double getOpen() {
		return open;
	}
	public double getHigh() {
		return high;
	}
	public double getLow() {
		return low;
	}
	public double getClose() {
		return close;
	}
	public double getVolume() {
		return volume;
	}
}
