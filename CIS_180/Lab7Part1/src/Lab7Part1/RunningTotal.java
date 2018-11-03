/* Dan Matheson
 * 10/27/16
 * This program will be used to allow a user to enter values into a running total of numbers and will calculate the Product, Average, and Sum of the numbers entered.
 * It will use methods to return those values to the main program.
 */

package Lab7Part1;

import java.util.Scanner;

public class RunningTotal {
	
	//Declare variables for RunningTotal class
	private double product = 1;
	private double sum = 0;
	private int totalNumbersEntered = 0;
	private double number;
	
	//This is the constructor for the Running Total class
	public RunningTotal(){
	
	}
	
	//This method will allow the user to enter values into the running total
	public void getNumbersFromUser(){
		
		//This opens up an instance of the Scanner Class
		Scanner reader = new Scanner(System.in);
		
		//This will ask the user for the first value and cast it to an integer if they tried to enter a double instead
		System.out.println("Enter positive integers to add up the running total!");
		number = (int)reader.nextDouble();
		
		//This while loop will run as long as the number is above zero and continue to get integers from the user
		while (number>0){
			product*=number;
			sum+=number;
			totalNumbersEntered++;
			System.out.println("Enter another positive integer!");
			number = (int)reader.nextDouble();
		}
		
		//This will close the instance of Scanner Class
		reader.close();
	}
	
	//This method will return the average of all of the numbers entered
	public double getAverage(){
		return sum/totalNumbersEntered;
	}
	
	//This method will return the product of all of the numbers entered
	public double getProduct(){
		return product;
	}
	
	//This method will return the sum of all of the numbers entered
	public double getSum(){
		return sum;
	}
}