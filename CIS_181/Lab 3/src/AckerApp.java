/* Dan Matheson
 * 2/14/17
 * This program will get two positive integers from the user and enter them into the Acker Function to get the total number of iterations and result and print it to the user.
 */
import java.io.*;
import java.util.*;
public class AckerApp {

	public static void main(String[] args) {
		String nextLine = "";
		int m, n, result, invocations;
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		//Start an infinite loop to run the program.
		while(true){
			//Create a new pointer to the AckerFunction class.
			AckerFunction function = new AckerFunction();
			//Ask the user to input two integers.
			System.out.print("Input two integers seperated by a space character (enter 'q' to quit) : ");

			//Input the two integers the user entered into a string.
			try {
				nextLine = stdin.readLine();
			}
			//Catch an input exception that could occur.
			catch (IOException e) {
				e.printStackTrace();
			}

			//If the user enters a 'q', then the program will terminate.
			if (nextLine.length() > 0 && (nextLine.charAt(0) == 'q' || nextLine.charAt(0) == 'Q')) {
				System.out.println("Done!");
				System.exit(0);
			}

			//Change the two numbers into tokens that are separated by a space.
			StringTokenizer input = new StringTokenizer(nextLine," ");
			try {
				//Parse the tokens as integers to the m and n variables.
				m = Integer.parseInt(input.nextToken());
				n = Integer.parseInt(input.nextToken());
			}
			//Catch an exception that could occur setting the tokens to integers.
			catch (Exception e) {
				System.out.println("Invalid entry! Please try again!");
				continue;
			}

			//This if statement will catch if the user entered a negative number.
			if(m < 0 || n < 0){
				System.out.println("Invalid entry! Please enter a positive integer!");
			}
			
			//If the user entered a valid number then the program will run it through the Acker Function.
			else{
				result = function.acker(m,n);
				invocations = function.countOfInvocations();
				System.out.println("\nTotal number of invocations = " + invocations + ", result = " + result + "\n");
			}
		}
	}
}
