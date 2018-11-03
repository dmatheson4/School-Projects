// Dan Matheson
// Sep. 15, 2016
// This application will allow the user to change the color of the text and background with the click of a button.

// My First Application
// Watch the colors change as you click the buttons

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Colors extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L; //This is where all of the variables are set
	private JButton backgroundButton = new JButton("Background Color");
	private JButton textButton = new JButton("Text Color");
	private JLabel greeting = new JLabel("Dan Matheson");
	private Color[] bgColors = {Color.cyan, Color.orange, Color.pink, Color.green, Color.white };
	private Color[] txtColors = {Color.blue, Color.magenta, Color.red, Color.black };
	private JPanel backgroundPane = new JPanel();
	private int bgCode = 0;
	private int txtCode = 0;
	
	public Colors() { //This is the class that will create the window for the user to interact with
		super("Colors");
		
		backgroundPane.setLayout(new FlowLayout (FlowLayout.CENTER, 5, 30)); 
		this.add(backgroundPane);
		
		backgroundButton.addActionListener(this);
		backgroundPane.add(backgroundButton);
		
		textButton.addActionListener(this);
		backgroundPane.add(textButton);
		
		Font font = new Font("Helvetica", Font.BOLD, 18);
		greeting.setFont(font);
		backgroundPane.add(greeting);
		greeting.setForeground(txtColors[txtCode]);
		backgroundPane.setBackground(bgColors[bgCode]);
		
		this.setSize(325, 200);
		this.setResizable(false);
		this.setLocationByPlatform(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) { 
		Object source = e.getSource(); //Who generated the event?
		
		if (source == backgroundButton) { //Was it the background color button?
			bgCode = ++bgCode % bgColors.length;
			Color color = bgColors[bgCode];
			backgroundPane.setBackground(color);
		}
		
		else if (source == textButton) { //Or was it in the Text Color Button?
			txtCode = ++txtCode % txtColors.length;
			greeting.setForeground(txtColors[txtCode]);
		}
	}
	
	public static void main(String[] args) { //This is the main program that will execute the colors class
		new Colors();	
	}
}