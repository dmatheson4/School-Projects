/* Dan Matheson
 * 10/11/16
 * This program will serve as the main program for the Lab 5 project and will call to the Pet class to get and set information to variables using methods in that class.
 * It will also print a final output with all of the pets names, ages, types, and owners names.
 */

package lab5Conversion;

//Import the Scanner and Input-Output class
import java.util.*;
import java.io.*;

public class PetOrganizer {

	public static void main(String[] args) {

		//Try catch block to catch any problems reading or writing to file, or any other problems that may occur
		try{
			//Find the file to read information out of
			File file = new File("Input.txt");
			//Create an instance of Scanner
			Scanner inFile = new Scanner(file);

			Pet p1 = new Pet();
			Pet p2 = new Pet();
			Pet p3 = new Pet();

			//Get and set the first pets name to p1
			p1.setPetName(inFile.nextLine());

			//Get and set the first pets age to p1
			p1.setPetAge(inFile.nextInt());
			inFile.nextLine();

			//Get and set the type of pet to p1
			p1.setPetType(inFile.nextLine());

			//Get and set the owner of the pet to p1
			p1.setPetOwner(inFile.nextLine());

			//Get and set the second pets name to p2
			p2.setPetName(inFile.nextLine());

			//Get and set the second pets age to p2
			p2.setPetAge(inFile.nextInt());
			inFile.nextLine();

			//Get and set the type of pet to p2
			p2.setPetType(inFile.nextLine());

			//Get and set the owner of the pet to p2
			p2.setPetOwner(inFile.nextLine());			

			//Get and set the second pets name to p3
			p3.setPetName(inFile.nextLine());

			//Get and set the third pets age to p3
			p3.setPetAge(inFile.nextInt());
			inFile.nextLine();

			//Get and set the type of pet to p3
			p3.setPetType(inFile.nextLine());

			//Get and set the owner of the pet to p3
			p3.setPetOwner(inFile.nextLine());

			//Close the File
			inFile.close();

			//Create the new file to write to
			PrintWriter outFile = new PrintWriter("Output.txt");

			//Print all of the pets information to the file
			outFile.println("[][][][][][] Pet Patient List [][][][][][]");
			outFile.println("Pet 1");
			outFile.println("Pet Name: " + p1.getPetName());
			outFile.println("Pet Age: " + p1.getPetAge());
			outFile.println("Pet Type: " + p1.getPetType());
			outFile.println("Pet Owner: " + p1.getPetOwner() + "\n");
			outFile.println("Pet 2");
			outFile.println("Pet Name: " + p2.getPetName());
			outFile.println("Pet Age: " + p2.getPetAge());
			outFile.println("Pet Type: " + p2.getPetType());
			outFile.println("Pet Owner: " + p2.getPetOwner() + "\n");
			outFile.println("Pet 3");
			outFile.println("Pet Name: " + p3.getPetName());
			outFile.println("Pet Age: " + p3.getPetAge());
			outFile.println("Pet Type: " + p3.getPetType());
			outFile.println("Pet Owner: " + p3.getPetOwner());
			outFile.println("[][][][][][][][][][][][][][][][][][][][][]");

			//Close the output file
			outFile.close();
		}
		//Catches any exceptions that may occur and prints it to the screen
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}