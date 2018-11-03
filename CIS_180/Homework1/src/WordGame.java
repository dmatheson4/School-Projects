/* Dan Matheson
 * September 27, 2016
 * This program will ask the user for some information, then it will print two stories using their information.
 */

//Import the Scanner class
import java.util.Scanner;

public class WordGame {

	public static void main(String[] args) {
		
		//Declare variables
		String name, city, college, profession, animal, petName;
		int age;

		//Create an instance of scanner
		Scanner reader = new Scanner(System.in);

		//Get information from the user for the word game

		//Ask the user for their name
		System.out.println("Welcome to the Word Game.\nWhat is your name?");
		
		//Get the users name from the console
		name = reader.nextLine();

		//Ask the user for their age
		System.out.println("What is your age? (whole numbers only please)");
		
		//Get the users age from the console
		age = reader.nextInt();
		reader.nextLine(); //Catches when the user hits enter after entering the integer

		//Ask the user for a city name
		System.out.print("Enter the name of a city: ");
		
		//Get the city name from the console
		city = reader.nextLine();

		//Ask the user for the name of a college
		System.out.print("\nEnter the name of a college: ");
		
		//Get the name of a college from the console
		college = reader.nextLine();

		//Ask the user for a profession
		System.out.print("\nEnter a profession: ");
		
		//Get the title of a profession from the console
		profession = reader.nextLine();

		//Ask the user for a type of animal
		System.out.print("\nEnter a type of animal: ");
		
		//Get the type of animal from the console
		animal = reader.nextLine();

		//Ask the user for a pet name
		System.out.print("\nEnter the name for a pet: ");
		
		//Get the pet name from the console
		petName = reader.nextLine();

		//Print the information in the story
		System.out.println("\nThere once was a person named "+name+" who lived in "+city+". At the age of "+age+", "+name+" went to");
		System.out.println("college at "+college+". "+name+" graduated and went to work as a "+profession+". Then, "+name);
		System.out.println("adopted a(n) "+animal+" named "+petName+". They both lived happily ever after!\n\n");

		//Print the information in the second story
		System.out.println("Once upon a time, there was a person by the name "+name+". They were very fortunate because they were able to go to "+college+".");
		System.out.println("While they attended "+college+" they wanted to study to become a(n) "+profession+", however, when they turned "+age);
		System.out.println("they ended up leaving "+college+" and joining to the circus in "+city+" where they worked with a(n) "+animal+" named "+petName+".");
		System.out.println("Both of them ended up living happy lives together while in the circus.");
		
		//Close the Scanner instance
		reader.close();
	}

}
