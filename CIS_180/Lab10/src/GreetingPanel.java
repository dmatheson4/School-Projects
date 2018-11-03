/*  Dan Matheson
 *  12/1/16
 *  The GreetingPanel class is a specialized JPanel class.
 *  It displays a greeting for the application window.
 */

import javax.swing.*;

@SuppressWarnings("serial")
public class GreetingPanel extends JPanel
{
	/**
	 *  Constructor
	 */

	public GreetingPanel()
	{
		// Create the label.
		JLabel greeting =
				new JLabel("Welcome to Brandi's Bagel House");

		// Add the label to this panel.
		add(greeting);
	}
}
