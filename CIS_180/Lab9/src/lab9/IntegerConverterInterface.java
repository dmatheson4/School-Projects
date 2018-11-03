/* Dan Matheson
 * 11/15/16
 * This program will serve as the interface for the IntegerConverter class. It will allow the user to enter integers in the base 10 system, and the 
 * program will use static methods in the IntegerConverter class to return those numbers as Hexadecimal, Roman Numeral, and Binary numbers.
 */
package lab9;

import java.util.*;

public class IntegerConverterInterface {

	public static void main(String[] args) {

		int number;

		//Create an instance of the Scanner class
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome to the Integer Converter!");//Welcome message

		//This loop will allow the user to enter as many values as they want and will stop when they enter 0
		do{
			//Ask the user for an integer to convert
			System.out.println("Enter an integer that you would like to be converted. Enter 0 to stop converting numbers.");
			number = reader.nextInt();//Get an integer from the user
			reader.nextLine();//Read the EOL Character

			//This if statement will run if the user enters a number that is not zero
			if(number != 0){
				System.out.println("That number in Hexa-Decimal is: " + IntegerConverter.toHex(number));
				System.out.println("That number in Roman Numeral is: " + IntegerConverter.toRomanNumeral(number));
				System.out.println("That number in Binary is: " + IntegerConverter.toBinary(number) + "\n");
			}
		}while(number!=0);

		//Closing message
		System.out.println("Thank you for using the Integer Converter!\nHave a Nice Day!");
		reader.close();//Closes the instance of Scanner
	}

}
