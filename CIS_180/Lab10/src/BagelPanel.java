/*  Dan Matheson
 * 12/1/16
 *  The BagelPanel class allows the user to select either
 *  a white or whole wheat bagel.
 */

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BagelPanel extends JPanel
{
	// The following constants are used to indicate
	// the cost of each type of bagel.
	public final double WHITE_BAGEL = 1.25;
	public final double WHEAT_BAGEL = 1.50;
	public final double GARLIC_BAGEL = 1.75;//Added the garlic bagel price
	public final double GLUTEN_FREE_BAGEL = 2.00;//Added the gluten free bagel price
	public final double EVERYTHING_BAGEL = 2.25;//Added my own everything bagel price

	// The following variables will reference radio
	// buttons for white and whole wheat bagels.
	private JRadioButton whiteBagel;
	private JRadioButton wheatBagel;
	private JRadioButton garlicBagel;//Declare the button for the garlic bagel
	private JRadioButton glutenFreeBagel;//Declare the button for the gluten free bagel
	private JRadioButton everythingBagel;//Declare the button for the everything bagel

	// The following variable will reference a
	// ButtonGroup object to group the radio buttons.
	private ButtonGroup bg;

	/**
	 *  Constructor
	 */

	public BagelPanel()
	{
		// Create a GridLayout manager with 
		// two rows and one column.
		setLayout(new GridLayout(5, 1));//Resize the grid to a 5 by 1

		// Create the radio buttons.
		whiteBagel = new JRadioButton("White", true);
		wheatBagel = new JRadioButton("Wheat");
		garlicBagel = new JRadioButton("Garlic");//Sets the name of the garlic bagel
		glutenFreeBagel = new JRadioButton("Gluten-Free");//Sets the name of the gluten free bagel
		everythingBagel = new JRadioButton("Everything");//Sets the name of the everything bagel

		// Group the radio buttons.
		bg = new ButtonGroup();
		bg.add(whiteBagel);
		bg.add(wheatBagel);
		bg.add(garlicBagel);//Add the garlic bagel to the button group
		bg.add(glutenFreeBagel);//Add the gluten free bagel to the button group
		bg.add(everythingBagel);//Add the everything bagel to the button group

		// Add a border around the panel.
		setBorder(BorderFactory.createTitledBorder("Bagel"));

		// Add the radio buttons to this panel.
		add(whiteBagel);
		add(wheatBagel);
		add(garlicBagel);//Add the garlic bagel radio button
		add(glutenFreeBagel);//add the gluten free bagel radio button
		add(everythingBagel);//add the everything bagel radio button
	}

	/**
	 *  The getBagelCost method returns the cost of
	 *  the selected bagel.
	 */

	public double getBagelCost()
	{
		// The following variable will hold the cost
		// of the selected bagel.
		double bagelCost = 0.0;

		// Determine which bagel is selected.
		if (whiteBagel.isSelected())
			bagelCost = WHITE_BAGEL;
		else if(wheatBagel.isSelected())
			bagelCost = WHEAT_BAGEL;
		else if(garlicBagel.isSelected())//Add an else if statement to check if the cost of the bagel will be the garlic bagel
			bagelCost = GARLIC_BAGEL;
		else if(glutenFreeBagel.isSelected())//Add an else if statement to check if the cost of the bagel is the gluten free bagel
			bagelCost = GLUTEN_FREE_BAGEL;
		else//This else statement will run if none of the bagels are selected and will return the price of the everything bagel
			bagelCost = EVERYTHING_BAGEL;

		// Return the cost of the selected bagel.
		return bagelCost;
	}
}