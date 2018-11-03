/* Dan Matheson
 * 12/1/16
 * This program will allow for the order calculator JFrame to be created by accessing and creating the panels that will be displayed. 
 * The JFrame will allow the user to select a coffee, bagel, and bagel toppings and will use what they selected to calculate the cost of the order.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
   The OrderCalculatorGUI class creates the GUI for the
   Brandi's Bagel House application.
 */

@SuppressWarnings("serial")
public class OrderCalculatorGUI extends JFrame
{
	private BagelPanel bagels;     // Bagel panel
	private ToppingPanel toppings; // Topping panel
	private CoffeePanel coffee;    // Coffee panel
	private GreetingPanel banner;  // To display a greeting
	private JPanel buttonPanel;    // To hold the buttons
	private JButton calcButton;    // To calculate the cost
	private JButton exitButton;    // To exit the application
	private final double TAX_RATE = 0.06; // Sales tax rate

	/**
      Constructor
	 */

	public OrderCalculatorGUI()
	{
		//This try-catch will try and change the look and feel of the jpanel to motif
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		}
		catch (Exception e){
			System.out.println("Error Setting Look and Feel!");
		}

		// Display a title.
		setTitle("Order Calculator");

		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a BorderLayout manager.
		setLayout(new BorderLayout());

		// Create the custom panels.
		banner = new GreetingPanel();
		bagels = new BagelPanel();
		toppings = new ToppingPanel();
		coffee = new CoffeePanel();

		// Create the button panel.
		buildButtonPanel();

		// Add the components to the content pane.
		add(banner, BorderLayout.NORTH);
		add(bagels, BorderLayout.CENTER);
		add(toppings, BorderLayout.EAST);
		add(coffee, BorderLayout.WEST);
		add(buttonPanel, BorderLayout.SOUTH);

		// Pack the contents of the window and display it.
		pack();
		setVisible(true);
	}

	/**
      The buildButtonPanel method builds the button panel.
	 */

	private void buildButtonPanel()
	{
		// Create a panel for the buttons.
		buttonPanel = new JPanel();

		// Create the buttons.
		calcButton = new JButton("Calculate");
		exitButton = new JButton("Exit");

		// Register the action listeners.
		calcButton.addActionListener(new CalcButtonListener());
		exitButton.addActionListener(new ExitButtonListener());

		// Add the buttons to the button panel.
		buttonPanel.add(calcButton);
		buttonPanel.add(exitButton);
	}

	/**
      Private inner class that handles the event when
      the user clicks the Calculate button.
	 */

	private class CalcButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Variables to hold the subtotal, tax, and total
			double subtotal, tax, total, tip = -1;
			int choice;

			// Calculate the subtotal.
			subtotal = bagels.getBagelCost() + 
					toppings.getToppingCost() +
					coffee.getCoffeeCost();

			// Calculate the sales tax.
			tax = subtotal * TAX_RATE;

			// Calculate the total.
			total = subtotal + tax;

			// Create a DecimalFormat object to format output.
			DecimalFormat dollar = new DecimalFormat("0.00");			

			//This pane will ask the user if they would like to tip their server
			choice = JOptionPane.showConfirmDialog(null, "Would you like to tip your server?", "Brandi's Bagel House", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			//This if statement will check if they said that they wanted to tip the server
			if(choice == JOptionPane.YES_OPTION){
				
				//This try-catch will catch if the user does not enter a valid value
				try{
					while(tip < 0) {
						tip = Double.parseDouble(JOptionPane.showInputDialog(null, "How much would you like to tip your server?", "Brandi's Bagel House", JOptionPane.QUESTION_MESSAGE));
						if(tip < 0)
							JOptionPane.showMessageDialog(null, "You cannot enter a negative tip");
					}
					//Add the tip to the total
					total = total + tip;

					// Display the charges.
					JOptionPane.showConfirmDialog(null, "Subtotal: $" +
							dollar.format(subtotal) + "\n" +
							"Tax: $" + dollar.format(tax) + "\n" +
							"Tip: $" + dollar.format(tip) + "\n" + 
							"Total: $" + dollar.format(total) + 
							"\nHave a nice day!", "Brandi's Bagel House", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					tip = -1;
				}
				catch(Exception exception){
					// Display the charges.
					JOptionPane.showConfirmDialog(null, "Subtotal: $" +
							dollar.format(subtotal) + "\n" +
							"Tax: $" + dollar.format(tax) + "\n" + 
							"Total: $" + dollar.format(total) + 
							"\nHave a nice day!", "Brandi's Bagel House", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				}
			}

			//This statement will run if the user does not want to tip their server
			else{
				
				// Display the charges.
				JOptionPane.showConfirmDialog(null, "Subtotal: $" +
						dollar.format(subtotal) + "\n" +
						"Tax: $" + dollar.format(tax) + "\n" + 
						"Total: $" + dollar.format(total) + 
						"\nHave a nice day!", "Brandi's Bagel House", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			}

		}
	}

	/**
      Private inner class that handles the event when
      the user clicks the Exit button.
	 */

	private class ExitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}

	/**
      main method
	 */

	public static void main(String[] args)
	{
		new OrderCalculatorGUI();
	}
}