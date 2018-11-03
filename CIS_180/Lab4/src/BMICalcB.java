/* Dan Matheson
 * 10/6/16
 * This program will ask the user for their weight in pounds, as well as their height.
 * It will use those values to calculate their Body Mass Index and tell them if they should consult a doctor and how over or underweight they are.
 */

//Import the scanner class to be used to get information from the console
import java.util.Scanner;

public class BMICalcB {

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
		reader.nextLine();//Catch the enter key

		//Debug line to make sure that the number the user entered is stored correctly
		System.out.println("The weight you entered is "+weight);

		//Ask the user to input their height
		System.out.println("\nWhat is your height in inches?");

		//Get the information from the user about their height
		height = reader.nextDouble();
		reader.nextLine();//Catch the enter key

		//Debug line to make sure that the number the user entered is stored correctly
		System.out.println("The height you entered is "+height);

		//Calculate the body mass index for the individual
		bodyMassIndex = ((weight * 708)/(height*height));

		//Run the body mass index through an if statement to check if it is below 16
		if (bodyMassIndex<16){

			System.out.println("\nYour Body Mass Index(BMI) is " + bodyMassIndex);
			System.out.println("You should consult a doctor immediately, you are very underweight!\n\nThank you for using the BMI Calculator!");
		}		

		//Run the body mass index through an if statement to check if it is below 18.5
		else if (bodyMassIndex<18.5){

			System.out.println("\nYour Body Mass Index(BMI) is " + bodyMassIndex);
			System.out.println("You should consult a doctor immediately, you are underweight!\n\nThank you for using the BMI Calculator!");
		}

		//Run the body mass index through an if statement to check if it is below 25
		else if (bodyMassIndex<25){

			System.out.println("\nYour Body Mass Index(BMI) is " + bodyMassIndex);
			System.out.println("You have a normal healthy Body Mass Index!\n\nThank you for using the BMI Calculator!");
		}

		//Run the body mass index through an if statement to check if it is below 30
		else if (bodyMassIndex<30){

			System.out.println("\nYour Body Mass Index(BMI) is " + bodyMassIndex);
			System.out.println("You should consult a doctor immediately, you are overweight!\n\nThank you for using the BMI Calculator!");
		}

		//Run the body mass index through an if statement to check if it is below 35
		else if (bodyMassIndex<35){

			System.out.println("\nYour Body Mass Index(BMI) is " + bodyMassIndex);
			System.out.println("You should consult a doctor immediately, you are obese!\n\nThank you for using the BMI Calculator!");
		}

		//Runs if the body mass is greater than or equal to 35
		else {
			System.out.println("\nYour Body Mass Index(BMI) is " + bodyMassIndex);
			System.out.println("You should consult a doctor immediately, you are very obese!\n\nThank you for using the BMI Calculator!");			
		}

		//Close the instance of scanner
		reader.close();
	}

}
