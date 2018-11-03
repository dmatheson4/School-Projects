/* Dan Matheson
 * 3/17/17
 * This program will serve as the application to test the KSmall method. It will take in an integer to find the kth smallest integer in an array.
 * It will also take in a 'R' or 'Q' in order to refill the array or quit the program.
 */
package kSmall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KSmallTester {

	//These attributes will set the size of the array and have a prompt to give to the user.
	public final static int SIZE_OF_ARRAY = 10;
	public final static String PROMPT = "Please  enter an integer k, 1<=k<=" +
			SIZE_OF_ARRAY + ", 'R' to refill the array, or 'Q' to quit: ";

	//This method prints out the array.
	public static void printArray(int[] array) {
		System.out.println("");
		System.out.print("array = [");
		for (int i=0; i < SIZE_OF_ARRAY-1; i++)
			System.out.print(""+ array[i]+" | ");
		System.out.println(""+ array[SIZE_OF_ARRAY-1]+"]");
		System.out.println("-------------------------------------------------"
				+ "-------------------");
	}

	//This method will fill the array with random numbers.
	public static void randFillArray(int[] array) {
		Random random = new Random();
		for (int i=0; i < SIZE_OF_ARRAY; i++)
			array[i] = random.nextInt(100);
	}

	public static void main(String argv[]) {
		int k = 0, kthSmallest = 0;
		int[] array = new int[SIZE_OF_ARRAY];
		String input="";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] arrayCopy = new int[SIZE_OF_ARRAY];

		//Initialize the array with random numbers.
		randFillArray(array);
		//Create a deep copy of the array that will be passed into the KSmall method.
		for(int i = 0; i < SIZE_OF_ARRAY; i++){
			arrayCopy[i] = array[i];
		}

		//Print a greeting message
		System.out.println("Welcome to the Kth Smallest Tester Program");

		//This infinite while loop will allow the user to get as many k small numbers as they want until they enter a 'q'.
		while(true){
			printArray(array);

			//This will ask the user to enter a value.
			System.out.print(PROMPT);
			//This will set the users entry to a string.
			try{
				input = reader.readLine();
			}
			//Catch an input exception that could occur.
			catch (IOException e) {
				e.printStackTrace();
			}
			
			//This if statement will check if the user wants a new array.
			if(input.charAt(0)=='r' || input.charAt(0)=='R'){
				randFillArray(array);
				System.out.println("Array Refilled!");
				//Create a deep copy of the array that will be passed into the KSmall method.
				for(int i = 0; i < SIZE_OF_ARRAY; i++){
					arrayCopy[i] = array[i];
				}
			}
			
			//If the user enters a 'q' then the program will end.
			else if(input.charAt(0)=='q' || input.charAt(0)=='Q'){
				System.out.println("\nThank you for using the Kth Smaller Tester Program!\nHave a nice day!");
				System.exit(0);
			}
			//This else will run if the user does not enter a 'R' or 'Q'.
			else{
				try{
					//This will try to parse the user input into an integer.
					k = Integer.parseInt(input);
					
					//This if statement will make sure that the user entered a valid number of ksmall they would like to search for.
					if(k <= SIZE_OF_ARRAY && k >= 1){
						kthSmallest = KthSmallest.kSmall(k, arrayCopy, 0, (SIZE_OF_ARRAY-1));
						printArray(arrayCopy);
						//These if statements will check to make sure the numbers have the correct suffix on the k.
						if(k == 1)
							System.out.println("\nThe 1st smallest integer in the array is " + kthSmallest + ".");
						else if(k == 2)
							System.out.println("\nThe 2nd smallest integer in the array is " + kthSmallest + ".");
						else if(k == 3)
							System.out.println("\nThe 3rd smallest integer in the array is " + kthSmallest + ".");
						else
							System.out.println("\nThe " + k + "th smallest integer in the array is " + kthSmallest + ".");
					}
					
					//This will tell the user that they entered an invalid number.
					else
						System.out.println("Invalid Entry!");
				}
				//This will catch if the user entered a character that could not be parsed to an integer and was not a 'q' or 'r'.
				catch(Exception e){
					System.out.println("Invalid Entry!");
				}
			}
		}
	}
}