/**
 * Dan Matheson
 * 3/5/18
 * This program will take in attributes from an html form and get ticker info from alphavantage.com
 * It will then save the ticker info to a bean that will be passed to a jsp and create a new html page
 */
package homework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TickerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String api_key = "U5VIXOEOODL1MDKE";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ticker = req.getParameter("ticker");
		TickerInfo bean = new TickerInfo();
		
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
				bean.setTicker("Requested data is not available.");
			}
			//split up the data into an array of strings
			String[] data = quoteString.split(",");
			if (data.length != 6) {
				bean.setTicker("Ticker " + ticker + " caused " + "Bad output: " + quoteString);
			}
			else {
				//set the ticker values to the bean class
				String date = java.sql.Date.valueOf(data[0]).toString();
				double open = Double.parseDouble(data[1]);
				double high = Double.parseDouble(data[2]);
				double low = Double.parseDouble(data[3]);
				double close = Double.parseDouble(data[4]);
				double volume = Double.parseDouble(data[5]);
				
				bean.setTicker(ticker);
				bean.setDate(date);
				bean.setOpen(open);
				bean.setHigh(high);
				bean.setLow(low);
				bean.setClose(close);
				bean.setVolume(volume);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//set the class attribute to the servlet request
		req.setAttribute("bean", bean);
		//get the request dispatcher from the jsp and forward the request
		RequestDispatcher dispatch = req.getRequestDispatcher("ticker_view.jsp");
		dispatch.forward(req, resp);
	}
}
