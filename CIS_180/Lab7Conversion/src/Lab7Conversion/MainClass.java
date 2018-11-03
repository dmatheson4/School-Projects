/* Dan Matheson
 * 10/27/16
 * This program will get numbers from a file using the RunningTotal class and print the results to a file when all the numbers have been read.
 */
package Lab7Conversion;

import java.io.*;

public class MainClass {

	public static void main(String[] args) {

		//Create an instance of the RunningTotal class
		RunningTotal user = new RunningTotal();

		//Run the method to get integers from the file
		user.getNumbersFromUser();

		//Try catch block to catch any exceptions that may occur
		try{
			PrintWriter outFile = new PrintWriter("Results.txt");

			//Print out the results of the numbers that were entered to the screen
			outFile.println("The average of the numbers in the file is " + user.getAverage());
			outFile.println("The sum of the numbers in the file is " + user.getSum());
			outFile.println("The product of the numbers in the file is " + user.getProduct());
			outFile.close();
		}
		//Catches any exceptions that may occur when printing to the file and will print a message describing the exception
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
