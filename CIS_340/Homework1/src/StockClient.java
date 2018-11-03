/**
 * Dan Matheson
 * 2/9/18
 * This program will serve as the client for gathering stock information from the alphavantage website through the stock interface.
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Scanner;

public class StockClient {

	//create an instance of the stock 
	private Stock stock;
	private StockClient()
	{
		Date date;
		double open, high, low, close, volume;
		boolean worked;
		String input = "";
		Scanner user = new Scanner(System.in);

		DecimalFormat number = new DecimalFormat();
		DecimalFormat dollars = new DecimalFormat("$#,##0.00;-$#,##0.00");
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);

		//try to get the stock server from the registry
		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			stock = (Stock) registry.lookup("StockServer");
		}
		catch (Exception e) {
			System.out.println("Unable to connect to the server");
			e.printStackTrace();
			System.exit(0);
		}
		//print welcome message
		System.out.println("Welcome to the Stock Client");
		//loop until the user types 'done'
		while(input.compareToIgnoreCase("done")!=0)
		{
			//ask the user for the ticker information and put it to an uppercase
			System.out.println("Enter the name of the ticker you would like the stock information for ('done' when finished)");
			input = user.nextLine();
			input = input.toUpperCase();
			//check if the input was the string 'done'
			if(input.compareToIgnoreCase("done")!=0)
			{
				try
				{
					//try to get the stock quote and print the stock information if it was able to obtain it
					worked = stock.getQuote(input);
					if(worked)
					{
						date = stock.getDate();
						open = stock.getOpen();
						high = stock.getHigh();
						low = stock.getLow();
						close = stock.getClose();
						volume = stock.getVolume();
						System.out.println("Stock Information for " + input + " on " + df.format(date));
						System.out.println("------------------------------------");
						System.out.println("Current price: " + dollars.format(close));
						System.out.println("Change: " + dollars.format(close - open));
						System.out.println("Daily High: " + dollars.format(high));
						System.out.println("Daily Low: " + dollars.format(low));
						System.out.println("Volume: " + number.format(volume) + " shares\n");
					}
					//print a message if the ticker information could not be found
					else
						System.out.println("Could not get info for ticker: " + input);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		System.out.println("Have yourself a wonderful day!");
		//close the scanner
		user.close();
	}
	public static void main(String[] args) {
		new StockClient();
	}
}
