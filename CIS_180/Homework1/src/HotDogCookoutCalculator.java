/* Dan Matheson
 * September 29, 2016
 * This program will get input from the user about a hot dog cookout and use that information to calculate the number of packages of hot dogs and buns
 * they will need to purchase. It will then give them the number of left over hot dogs and buns that they should have at the end of the cookout.
 */

//Import the Scanner class
import java.util.Scanner;

public class HotDogCookoutCalculator {

	public static void main(String[] args) {

		//Declare variables for the number of people, hot dogs per person, extra hot dogs, extra buns, total hot dogs, bags of hot dogs, and bags of buns
		int numPeople, numHotDogsPerPerson, numHotDogsExtra, numBunsExtra, totalHotDogs, numBagsOfHotDogs, numBagsOfBuns;

		//Set the number of hot dog buns and hot dogs in a bag to a value
		int numHotDogsInBag = 10;
		int numBunsInBag = 8;

		//Create an instance of the Scanner Class
		Scanner reader = new Scanner(System.in);

		//Get the number of People attending the cookout from the user
		System.out.println("Welcome to the Hot Dog Cookout Calculator!\nHow many people will be attending the cookout? (Please enter a positive integer)");
		numPeople = reader.nextInt();
		reader.nextLine();//Catch the enter key

		//Get the number of hot dogs per person from the user
		System.out.println("How many hot dogs would you like to get per person? (Please enter a positive Integer)");
		numHotDogsPerPerson = reader.nextInt();
		reader.nextLine();//Catch the enter key

		//Calculate how many total hot dogs there are
		totalHotDogs = numPeople * numHotDogsPerPerson;

		//Calculate the number of extra hot dogs and extra buns
		numHotDogsExtra = totalHotDogs%numHotDogsInBag;
		numBunsExtra = totalHotDogs%numBunsInBag;

		//This if statement will run if there are more left over hot dogs than left over buns
		if (numHotDogsExtra > numBunsExtra){

			//Create an if statement to see if there are any extra buns and do a calculation based on it to find out how many bags of each is needed
			//This statement will run if there are extra buns left over
			if (numBunsExtra > 0){
				//These next two lines will calculate the number of bags of hot dogs and buns
				numBagsOfHotDogs = totalHotDogs / numHotDogsInBag + 1;
				numBagsOfBuns = totalHotDogs / numBunsInBag + 1;
			}

			//This statement will run if there are no buns left in the bag
			else{

				//These next two lines will calculate the number of bags of hot dogs and buns
				numBagsOfHotDogs = totalHotDogs / numHotDogsInBag + 1;
				numBagsOfBuns = totalHotDogs / numBunsInBag;
			}
		}

		//This statement will run if there are more extra buns than left over hot dogs
		else if (numHotDogsExtra < numBunsExtra){

			//Create an if statement to see if there are any extra hot dogs and do a calculation based on it to find out how many bags of each is needed
			//This statement will run if there are extra hot dogs left over
			if (numHotDogsExtra > 0){

				//These next two lines will calculate the number of bags of hot dogs and buns
				numBagsOfHotDogs = totalHotDogs / numHotDogsInBag + 1;
				numBagsOfBuns = totalHotDogs / numBunsInBag + 1;
			}

			//This statement will run if there are no hot dogs left in the bag
			else{

				//These next two lines will calculate the number of bags of hot dogs and buns
				numBagsOfHotDogs = totalHotDogs / numHotDogsInBag;
				numBagsOfBuns = totalHotDogs / numBunsInBag + 1;
			}
		}

		//This else statement will run if there are no left over hot dog buns and hot dogs
		else{

			//These next two lines will calculate the number of bags of hot dogs and buns
			numBagsOfHotDogs = totalHotDogs / numHotDogsInBag;
			numBagsOfBuns = totalHotDogs / numBunsInBag;
		}

		//Recalculate for the number of extra buns left over Because the number may change based on how many bags are bought
		numHotDogsExtra = (numBagsOfHotDogs * numHotDogsInBag) % totalHotDogs;
		numBunsExtra = (numBagsOfBuns * numBunsInBag) % totalHotDogs;
		
		//Print to the user how many packages of hot dogs and buns they will need to purchase as well as how many leftover hot dogs and buns will be left over
		System.out.println("\nYou will need to buy "+numBagsOfHotDogs+" packages of hot dogs for the cookout.");
		System.out.println("You will also need to buy "+numBagsOfBuns+" packages of hot dog buns for the cookout.");
		System.out.println("After the cookout you should have "+numHotDogsExtra+" hot dog(s) left over.");
		System.out.println("After the cook you should also have "+numBunsExtra+" bun(s) left over.");
		System.out.println("\nThank you for using the Hot Dog Cookout Calculator!\nHave a nice cookout!");

		//Close the instance of Scanner class
		reader.close();
	}

}
