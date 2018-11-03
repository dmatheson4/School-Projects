/**
 * Dan Matheson
 * 2/9/18
 * This program will serve as the stock server that will implement the interface methods and query info from the alphavantage website.
 * -Djava.rmi.server.hostname=localhost
 */
import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;

public class StockServer implements Stock{

	//store the api key and stock quote
	private String api_key = "U5VIXOEOODL1MDKE";
	StockQuote stock;

	//create the method to get a stock quote from the website
	@Override
	public boolean getQuote(String ticker) throws RemoteException {

		try {
			//build the url and connect to it to get the information on the stock ticker
			URL url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + ticker + "&apikey=" + api_key + "&datatype=csv");
			URLConnection conn = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			in.readLine(); // skip header row
			String quoteString = in.readLine();
			in.close();

			//check if the quote string is empty
			if (quoteString == null) {
				System.out.println("Requested data is not available.");
				return false;
			}
			String[] data = quoteString.split(",");
			if (data.length != 6) {
				System.out.println("Ticker " + ticker + " caused " + "Bad output: " + quoteString);
				return false;
			}
			else
				//create the stock quote and pass the csv
				stock = new StockQuote(data);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	//Create methods to implement the stock interface
	@Override
	public Date getDate() throws RemoteException {
		return stock.getDate();
	}

	@Override
	public double getOpen() throws RemoteException {
		return stock.getOpen();
	}

	@Override
	public double getHigh() throws RemoteException {
		return stock.getHigh();
	}

	@Override
	public double getLow() throws RemoteException {
		return stock.getLow();
	}

	@Override
	public double getClose() throws RemoteException {
		return stock.getClose();
	}

	@Override
	public double getVolume() throws RemoteException {
		return stock.getVolume();
	}
	public static void main(String[] args) throws Exception {
		try
		{
			//Create the stock server and a server stub
			Stock server = new StockServer();
			Stock stub = (Stock) UnicastRemoteObject.exportObject(server, 0);
			//create the registry and rename it
			Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			registry.rebind("StockServer", stub);
			System.out.println("Server Running");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
