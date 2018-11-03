/* Dan Matheson
 * 9/29/16
 * This program will ask the user for their weight in pounds, as well as their height.
 * It will use those values to calculate their Body Mass Index and tell them if they should consult a doctor.
 */

//Import the scanner class to be used to get information from the console
import java.util.Scanner;

public class BMICalculator {

	public static void main(String[] args) {
		//Declare the variables weight, height, and body mass index
		double weight, height, bodyMassIndex;

		//Create an instance of scanner
		Scanner reader = new Scanner(System.in);

		//Ask the user to input their weight in pounds
		//If you want to get any of these values as an integer, then you can replace .nextDouble() with .nextInt()
		System.out.println("What is your weight in pounds?");

		//Get the information from the user about their weight
		weight = reader.nextDouble();

		//Debug line to make sure that the number the user entered is stored correctly
		System.out.println("The weight you entered is "+weight);

		//Ask the user to input their height
		System.out.println("\nWhat is your height in inches?");

		//Get the information from the user about their height
		height = reader.nextDouble();

		//Debug line to make sure that the number the user entered is stored correctly
		System.out.println("The height you entered is "+height);

		//Calculate the body mass index for the individual
		bodyMassIndex = ((weight * 708)/(height*height));

		//Run the body mass index through an if statement to check if it is not between 25 and 18.5
		if (bodyMassIndex>25 || bodyMassIndex<18.5){

			//If the body mass index is not between 25 and 18.5 it will print their body mass index and tell them to consult a doctor
			System.out.println("\nYour Body Mass Index(BMI) is " + bodyMassIndex);
			System.out.println("You should consult a doctor immediately!\n\nThank you for using the BMI Calculator!");
		}

		//This else statement will run if the numbers are between or at 25 and 18.5
		else{

			//This will print to the user their body mass index and tell them that it is a healthy number
			System.out.println("\nYour Body Mass Index(BMI) is " + bodyMassIndex);
			System.out.println("You have a healthy Body Mass Index!\n\nThank you for using the BMI Calculator!");
		}

		//Close the instance of scanner
		reader.close();
	}

}
