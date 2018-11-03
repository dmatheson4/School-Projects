/* Dan Matheson
 * 10/6/16
 * This program will ask the user to enter a number that corresponds to a certain character then print that character in a larger form to the console.
 * The program will then use a switch statement to decide which letter to print.
 */

//Import the Scanner class to get information from the console.
import java.util.Scanner;

public class ASCIIArt {

	public static void main(String[] args) {
		//Declare variables
		int choice;
		String m, i, n, o, z, minionz;

		//Open an instance of the Scanner class
		Scanner reader = new Scanner(System.in);

		//Ask the user for the variables they would like to print
		System.out.println("What character would you like to turn to ASCII art? (enter a number between 1 and 6)");
		System.out.println("\t1: Print 'M'\n\t2: Print 'I'\n\t3: Print 'N'\n\t4: Print 'O'\n\t5: Print 'Z'\n\t6: Print 'MINIONZ'");

		//Make the ASCII art using asterisks for all of the characters
		m = "***     ***\n*** *** ***\n***  *  ***\n***     ***\n***     ***\n";
		i = "***********\n    ***    \n    ***    \n    ***    \n***********\n";
		n = "****    ***\n*** *   ***\n***  *  ***\n***   * ***\n***    ****\n";
		o = "    ***    \n  *** ***  \n ***   *** \n  *** ***  \n    ***    \n";
		z = "***********\n        ** \n    **     \n **        \n***********\n";
		
		//Extra printed message
		minionz="***     ***  ***********  ****    ***  ***********      ***      ****    ***  ***********\n"+
				"*** *** ***      ***      *** *   ***      ***        *** ***    *** *   ***          ** \n"+
				"***  *  ***      ***      ***  *  ***      ***       ***   ***   ***  *  ***      **     \n"+
				"***     ***      ***      ***   * ***      ***        *** ***    ***   * ***   **        \n"+
				"***     ***  ***********  ***    ****  ***********      ***      ***    ****  ***********\n";

		//Test to see how the letters print
//		System.out.println(m);
//		System.out.println(i);
//		System.out.println(n);
//		System.out.println(o);
//		System.out.println(z);
//		System.out.println(minionz);

		//Take input from the user about their choice
		choice = reader.nextInt();

		//Make a switch statement to print the users request
		switch (choice){

		//This will catch if the user chose the first choice
		case 1: 
			System.out.println(m);
			break;

			//This will catch if the user chose the second choice
		case 2: 
			System.out.println(i);
			break;

			//This will catch if the user chose the third choice
		case 3: 
			System.out.println(n);
			break;

			//This will catch if the user chose the fourth choice
		case 4: 
			System.out.println(o);
			break;

			//This will catch if the user chose the fifth choice
		case 5: 
			System.out.println(z);
			break;

			//This will catch if the user chose the sixth choice
		case 6: 
			System.out.println(minionz);
			break;

			//This default statement will catch if the user enters an invalid number
		default: 
			System.out.println("You have entered an invalid number!");
		}

		//Close the instance of scanner
		reader.close();
	}

}
