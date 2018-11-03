/* Dan Matheson
 * 10/27/16
 * This program will be used to get numbers from a file and store them into a running total of numbers and will calculate the Product, Average, and Sum of the numbers gathered.
 * It will use methods to return those values to the main program.
 */

package Lab7Conversion;

import java.io.*;
import java.util.*;

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

		//Try catch block to catch any exceptions that may occur
		try{
			File fileName = new File("Numbers.txt");
			//This opens up an instance of the Scanner Class
			Scanner inFile = new Scanner(fileName);

			//Get the first number in the file
			number = inFile.nextInt();
			inFile.nextLine();//Catch the return character

			//This while loop will run as long as the number is above zero and continue to get integers from the user
			while (number>0){
				product*=number;
				sum+=number;
				totalNumbersEntered++;
				
				//This if statement will check if there is another number in the file
				if(inFile.hasNextInt()){
					number = inFile.nextInt();
					inFile.nextLine();//Catch the return character
				}
				else{
					number = 0;
				}
			}

			//This will close the instance of Scanner Class
			inFile.close();
		}
		//Catch any exceptions that may occur when reading from the file and prints a message about the exception that occured
		catch(Exception e){
			System.out.println(e.getMessage());
		}
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