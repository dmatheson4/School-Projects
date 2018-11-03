/* Dan Matheson
 * 12/3/16
 * This program will load the world series winners from a text file, and allow the user to sort the teams by team name or years of the world series. 
 * It will also allow the user to find out what team won in which specific year, and if they want to find out which years a specific team won the world series.
 */
import java.io.File;
import java.util.Scanner;

public class MainClass {

	public static Winner [] listOfWinners;

	public static void loadFromFile()
	{
		//This try-catch will catch if there is a problem reading from the file
		try{
			//Create instance of Scanner and provide instance of File pointing to the txt file
			Scanner input = new Scanner(new File("WorldSeriesWinners.txt"));

			//Get the number of teams
			int years = input.nextInt();
			input.nextLine();//move to the next line

			//Create the array
			listOfWinners = new Winner[years];

			//for every year in the textfile
			for(int index = 0; index<years; index++)
			{
				//Get the year
				int year = input.nextInt();
				input.skip("	");
				//Get the team
				String team = input.nextLine();

				//Create an instance of Winner and add it to the next spot in the array
				listOfWinners[index] = new Winner(team,year);
			}
			//Close the instance of Scanner
			input.close();
		}
		//This will catch if there is any problem reading from the file or setting values and will print a message to the console
		catch(Exception e)
		{
			System.out.println("Hey Meatbag, I'm Bender, and something wrong in the loadFromFile method happened!");
			System.out.println(e.toString());
			System.exit(0);
		}
	}

	public static void sortByTeamName()
	{
		//Create a new array of Winners to populate with the sorted teams
		Winner listOfWinners2[] = new Winner[listOfWinners.length];
		int index;

		//This for loop will run through all of the World Series Winners and sort them into alphabetical order from a-z
		for(int i = 0; i<listOfWinners.length; i++){
			index = i;
			//This for loop will run through all of the teams in the list of winners
			for (int j = 0; j < listOfWinners.length; j++){
				//This if statement will compare each of the winners to the current index winner
				if(listOfWinners[j].getTeam().compareToIgnoreCase(listOfWinners[index].getTeam()) <= 0){
					index = j;
				}
			}
			//Set the sorted values of the winners to the new array
			listOfWinners2[i] = new Winner(listOfWinners[index].getTeam(), listOfWinners[index].getYear());
			listOfWinners[index] = new Winner("zzzzzzzzzzzzzzz", 100000);//Set the value of the team used to a value that will make it unused in the future
		}
		//Set the pointer of listOfWinners to the listOfWinners2 array
		listOfWinners = listOfWinners2;
	}

	public static void sortByYear()
	{
		Winner listOfWinners2[] = new Winner[listOfWinners.length];
		int index;

		//This for loop will run through all of the World Series Winners and sort them in order of the years
		for(int i = 0; i<listOfWinners.length; i++){
			index = i;
			//This for loop will run through all of the teams in the list of winners
			for (int j = 0; j < listOfWinners.length; j++){
				//This if statement will compare each of the winners to the current index winner
				if(listOfWinners[j].getYear() < listOfWinners[index].getYear()){
					index = j;
				}
			}
			//Set the sorted values of the winners to the new array
			listOfWinners2[i] = new Winner(listOfWinners[index].getTeam(), listOfWinners[index].getYear());
			listOfWinners[index] = new Winner("zzzzzzzzzzzzzzz", 100000);//Set the values of the team to a value that will make it unused in the future
		}
		//Set the pointer of listOfWinners to the listOfWinners2 array
		listOfWinners = listOfWinners2;
	}

	public static void printArray()
	{
		//Print the array
		for(int index=0; index<listOfWinners.length; index++)
		{
			System.out.println(listOfWinners[index].getYear()+" Winners " + listOfWinners[index].getTeam());
		}
	}

	public static void searchForWinnerByYear(int year)
	{
		int index = 0;
		boolean yearFound = false;

		//This do while loop will continue looping through each index in the array and see if it can find the year asked for
		do{
			//This if statement will run if the year in the specified index of the array contains the year they are looking for
			if(listOfWinners[index].getYear() == year){
				System.out.println("The team that won in " + year + " is The " + listOfWinners[index].getTeam() + "\n");
				yearFound = true;
			}
			//This else statement will run to increment the index number if the year is not found
			else{
				index++;
			}
		}while(yearFound == false && index < listOfWinners.length);

		//If the loop runs up to the length of the listOfWinners array, then it will print a message that there is not a winner
		if(index == listOfWinners.length){
			System.out.println("That year does not have a winner!\n");
		}
	}

	public static void searchForYearsATeamWon(String team)
	{
		System.out.println("The " + team + " Winners:");
		//This for loop will run through the entire list of winners and look for the name of the team the user is asking for
		for(int index = 0; index < listOfWinners.length; index++){
			//This if statement will check if the team name is equal to the name the user entered
			if(listOfWinners[index].getTeam().equalsIgnoreCase(team)){
				System.out.println(listOfWinners[index].getYear());
			}
		}
	}

	public static void main(String[] args) {

		int choice;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("World Series Program");

		//Load textfile 
		loadFromFile();
		do{
			System.out.println("1.........Print out the Winner List sorted by team name");
			System.out.println("2.........Print out the Winner List sorted by years");
			System.out.println("3.........Print out the Winner of a particular year");
			System.out.println("4.........Print out the years a particular team won");
			System.out.println("5.........Exit the Program");
			System.out.println("Which Choice Would You Like?");
			choice = keyboard.nextInt();

			switch(choice)
			{
			case 1:
				//Option 1, sort array by name and print out.
				sortByTeamName();
				printArray();
				break;
			case 2:
				//Option 2, sort array by year and print out.
				sortByYear();
				printArray();
				break;
			case 3:
				//Option 3 Search for winner by year
				System.out.println("What year would you like to find the winner?");
				int year = keyboard.nextInt();
				searchForWinnerByYear(year);
				break;
			case 4:
				//Option 4 Search for years a team won
				System.out.println("What team would you like to check for years won?");
				keyboard.nextLine();
				String team = keyboard.nextLine();
				searchForYearsATeamWon(team);
				break;
			case 5://Exit
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}while(choice != 5);

		//Close the instance of Scanner and give a farewell message
		keyboard.close();
		System.out.println("Goodbye!");
	}

}
