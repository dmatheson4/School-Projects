/*  Dan Matheson
 *  12/1/16
 *  The ToppingPanel class creates a panel of check boxes that allow the user to select
 *  the toppings for the bagel.
 */

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ToppingPanel extends JPanel
{
	// The following constants are used to indicate
	// the cost of toppings.
	public final double CREAM_CHEESE = 0.50;
	public final double BUTTER = 0.25;
	public final double PEACH_JELLY = 0.75;
	public final double BLUEBERRY_JAM = 0.75;
	public final double STRAWBERRY_JAM = 0.75;//Add the price for strawberry jam

	// Check boxes for the available toppings.
	private JCheckBox creamCheese;  // Cream cheese
	private JCheckBox butter;       // Butter
	private JCheckBox peachJelly;   // Peach jelly
	private JCheckBox blueberryJam; // Blueberry jam
	private JCheckBox strawberryJam;// Strawberry jam

	/**
	 *  Constructor
	 */

	public ToppingPanel()
	{
		// Create a GridLayout manager with 
		// four rows and one column.
		setLayout(new GridLayout(5, 1));//Change the grid to a 5 by 1

		// Create the check boxes.
		creamCheese = new JCheckBox("Cream cheese");
		butter = new JCheckBox("Butter");
		peachJelly = new JCheckBox("Peach jelly");
		blueberryJam = new JCheckBox("Blueberry jam");
		strawberryJam = new JCheckBox("Strawberry jam");//Add the name of the checkbox to the strawberry jam JCheckBox

		// Add a border around the panel.
		setBorder(BorderFactory.createTitledBorder("Toppings"));

		// Add the check boxes to this panel.
		add(creamCheese);
		add(butter);
		add(peachJelly);
		add(blueberryJam);
		add(strawberryJam);//Add strawberry jam check box to the panel
	}

	/**
	 *  The getToppingCost method returns the cost of
	 *  the selected toppings.
	 */

	public double getToppingCost()
	{
		// The following variable will hold the cost
		// of the selected topping.
		double toppingCost = 0.0;

		// Determine which of the toppings are selected.
		// More than one may be selected.
		if (creamCheese.isSelected())
			toppingCost += CREAM_CHEESE;
		if (butter.isSelected())
			toppingCost += BUTTER;
		if (peachJelly.isSelected())
			toppingCost += PEACH_JELLY;
		if (blueberryJam.isSelected())
			toppingCost += BLUEBERRY_JAM;
		if (strawberryJam.isSelected())//Add the cost of strawberry jam if it is selected
			toppingCost += STRAWBERRY_JAM;

		// Return the topping cost.
		return toppingCost;
	}
}