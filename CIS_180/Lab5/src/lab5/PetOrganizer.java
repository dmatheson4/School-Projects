/* Dan Matheson
 * 10/11/16
 * This program will serve as the main program for the Lab 5 project and will call to the Pet class to get and set information to variables using methods in that class.
 * It will also print a final output with all of the pets names, ages, types, and owners names.
 */

package lab5;

//Import the Scanner class
import java.util.Scanner;

public class PetOrganizer {

	public static void main(String[] args) {

		//Create an instance of Scanner
		Scanner reader = new Scanner(System.in);
		
		Pet p1 = new Pet();
		Pet p2 = new Pet();
		Pet p3 = new Pet();

		//Welcome message
		System.out.println("Welcome to the Pet Organizer!");

		//Ask the user for the first pets name
		System.out.println("What is the name of the first pet?");

		//Get and set the first pets name to p1
		p1.setPetName(reader.nextLine());

		//Ask the user for the first pets age
		System.out.println("What is the Age of " + p1.getPetName() + "? (Enter a positive integer)");

		//Get and set the first pets age to p1
		//Use parseInt to make it so I do not have to catch the enter key
		p1.setPetAge(Integer.parseInt(reader.nextLine()));

		//Ask the user for the type of pet the first pet is
		System.out.println("What type of pet is " + p1.getPetName() + "?");

		//Get and set the type of pet to p1
		p1.setPetType(reader.nextLine());

		//Ask the user for the owners name
		System.out.println("Who is the owner of " + p1.getPetName() + "?");

		//Get and set the owner of the pet to p1
		p1.setPetOwner(reader.nextLine());

		//Get information for the second pet
		//Ask the user for the second pets name
		System.out.println("What is the name of the second pet?");

		//Get and set the second pets name to p2
		p2.setPetName(reader.nextLine());

		//Ask the user for the second pets age
		System.out.println("What is the Age of " + p2.getPetName() + "? (Enter a positive integer)");

		//Get and set the second pets age to p2
		//Use parseInt to make it so I do not have to catch the enter key
		p2.setPetAge(Integer.parseInt(reader.nextLine()));

		//Ask the user for the type of pet the second pet is
		System.out.println("What type of pet is " + p2.getPetName() + "?");

		//Get and set the type of pet to p2
		p2.setPetType(reader.nextLine());

		//Ask the user for the owners name
		System.out.println("Who is the owner of " + p2.getPetName() + "?");

		//Get and set the owner of the pet to p2
		p2.setPetOwner(reader.nextLine());			

		//Get information for the third pet
		//Ask the user for the third pets name
		System.out.println("What is the name of the third pet?");

		//Get and set the second pets name to p3
		p3.setPetName(reader.nextLine());

		//Ask the user for the second pets age
		System.out.println("What is the Age of " + p3.getPetName() + "? (Enter a positive integer)");

		//Get and set the third pets age to p3
		//Use parseInt to make it so I do not have to catch the enter key
		p3.setPetAge(Integer.parseInt(reader.nextLine()));

		//Ask the user for the type of pet the third pet is
		System.out.println("What type of pet is " + p3.getPetName() + "?");

		//Get and set the type of pet to p3
		p3.setPetType(reader.nextLine());

		//Ask the user for the owners name
		System.out.println("Who is the owner of " + p3.getPetName() + "?");

		//Get and set the owner of the pet to p3
		p3.setPetOwner(reader.nextLine());

		//Close the instance of Scanner
		reader.close();

		//Print all of the pets information to the console
		System.out.println("[][][][][][] Pet Patient List [][][][][][]");
		System.out.println("Pet 1");
		System.out.println("Pet Name: " + p1.getPetName());
		System.out.println("Pet Age: " + p1.getPetAge());
		System.out.println("Pet Type: " + p1.getPetType());
		System.out.println("Pet Owner: " + p1.getPetOwner() + "\n");
		System.out.println("Pet 2");
		System.out.println("Pet Name: " + p2.getPetName());
		System.out.println("Pet Age: " + p2.getPetAge());
		System.out.println("Pet Type: " + p2.getPetType());
		System.out.println("Pet Owner: " + p2.getPetOwner() + "\n");
		System.out.println("Pet 3");
		System.out.println("Pet Name: " + p3.getPetName());
		System.out.println("Pet Age: " + p3.getPetAge());
		System.out.println("Pet Type: " + p3.getPetType());
		System.out.println("Pet Owner: " + p3.getPetOwner());
		System.out.println("[][][][][][][][][][][][][][][][][][][][][]");
	}

}