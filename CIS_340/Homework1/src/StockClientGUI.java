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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StockClientGUI extends JFrame implements ActionListener{

	//create an instance of the stock 
	private Stock stock;
	private JTextField stockTicker = new JTextField(20);
	private JTextField date = new JTextField(20);
	private JTextField open = new JTextField(20);
	private JTextField high = new JTextField(20);
	private JTextField low = new JTextField(20);
	private JTextField close = new JTextField(20);
	private JTextField volume = new JTextField(20);
	private JButton lookup = new JButton("Get Ticker Info");
	
	private StockClientGUI()
	{
		//Date date;
		//double open, high, low, close, volume;
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
		
		this.setLayout(new GridLayout(0,1));
		JPanel tickerPanel = new JPanel();
		tickerPanel.add(new JLabel("Ticker: \n"));
		tickerPanel.add(stockTicker);
		tickerPanel.add(new JLabel("\nDate: "));
		tickerPanel.add(date);
		tickerPanel.add(new JLabel("\nOpen: "));
		tickerPanel.add(open);
		tickerPanel.add(new JLabel("\nHigh: "));
		tickerPanel.add(high);
		tickerPanel.add(new JLabel("\nLow: "));
		tickerPanel.add(low);
		tickerPanel.add(new JLabel("\nClose: "));
		tickerPanel.add(close);
		tickerPanel.add(new JLabel("\nVolume: "));
		tickerPanel.add(volume);
		this.add(tickerPanel);
		
//		JPanel phonePanel = new JPanel();
//		phonePanel.add(new JLabel(""));
//		phonePanel.add(phoneField);
//		this.add(phonePanel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(lookup);
		this.add(buttonPanel);
		
		lookup.addActionListener(this);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1080, 720);
		this.setVisible(true);
		//close the scanner
		user.close();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	public static void main(String[] args) {
		new StockClientGUI();
	}
}
