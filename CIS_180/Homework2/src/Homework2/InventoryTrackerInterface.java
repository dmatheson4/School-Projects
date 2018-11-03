/* Dan Matheson
 * 10/26/16
 * This program will allow the user to access an inventory of items and add items to the inventory. It will use the Inventory and Item classes
 * to allow the user to create an inventory of items and access the attributes of each item. The user can then save their inventory to a file, 
 * as well as, load an inventory from a file with any name that they chose as long as it is properly formatted.
 */
package Homework2;

import java.util.*;

public class InventoryTrackerInterface {

	public static void main(String[] args){

		//Declare attributes that will be used to interact with the Item and Inventory class
		int option;
		boolean run = true;
		Inventory inventory = new Inventory();
		Item item = null;
		String name;
		int quantity;
		double price;
		String upc;
		int numItem;

		//Create an instance of the scanner class
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome to the Inventory Tracker!");

		//Start of the do-while loop
		do{
			//This try catch will be able to catch any invalid entry that the user tries to input. For example, if they input a string into an integer value
			try{
				//Ask the user what they would like to do with the program
				System.out.println("What would you like to do? (Enter an integer 1-5)");
				System.out.println("\t1: Add an item to the inventory\n\t2: Get an items info\n\t3: Save inventory to a file\n\t4: Load inventory from a file\n\t5: Exit program");
				option = reader.nextInt();
				reader.nextLine();

				//Use a switch to complete the users request
				switch(option){

				//Case 1 will add an item to the inventory
				case 1:
					//Ask the user for the attributes of the item they would like to add
					System.out.println("What is the name of the item you would like to add?");
					name = reader.nextLine();
					System.out.println("What quantity of " + name + " would you like to add? (Integer Value Please)");
					quantity = reader.nextInt();
					reader.nextLine();
					System.out.print("What is the price of " + name + "?\n$");
					price = reader.nextDouble();
					reader.nextLine();
					System.out.println("What is the upc of " + name + "?");
					upc = reader.nextLine();
					//Create the item and add it to the inventory with the parameters given by the user
					item = new Item(name, Math.abs(quantity), Math.abs(price), upc);//If the user enters a negative number for quantity or price, then it will go in as a positive number
					inventory.addItem(item);
					break;

				//This case will give the user the information for a specific inventory item that they chose
				case 2:
					//This if statement will check if there are no inventory items to be accessed
					if (inventory.getTotalNumberOfItems()==0){
						System.out.println("There are no items in the inventory\n");
						break;
					}
					//This statement will run if there is at least one item in the inventory
					else{
						System.out.println("What item would you like inventory information of? (1 - " + (inventory.getTotalNumberOfItems())  + ")");
						numItem = (reader.nextInt()-1);
						reader.nextLine();
					}
					//Set the current item to the item stored in the inventory
					item = inventory.getItem(numItem);

					//Check to make sure that they entered a valid number
					if (item == null){
						System.out.println("That item does not exist.\n");
						break;
					}
					//This statement will run if the user entered a valid item number
					else{
						//Print out the attributes of the item requested by the user
						System.out.println("\nDetails for Inventory Item Number " + (numItem + 1));
						System.out.println("Name: " + item.getName());
						System.out.println("Quantity: " + item.getQuantity());
						System.out.println("Price: $" + item.getPrice());
						System.out.println("upc: " + item.getUPC() + "\n");
						break;
					}

				//This case will ask the user what they would like to name their file and save it to a text file
				case 3:
					//This if statement will catch if there are not any items in the inventory to save
					if (inventory.getTotalNumberOfItems() == 0){
						System.out.println("There are no items in the inventory to save.\n");
						break;
					}
					//This statement will run if there are inventory items to save to a file
					else{
						System.out.println("What would you like the file name to be? (.txt will be automatically added)");
						name = reader.nextLine();
						inventory.saveInventoryToFile(name);
						break;
					}

				//This case will ask the user for the name of the saved file they want to open and load it into the inventory class
				case 4:

					//This if statement will run if there are one or more items in the inventory
					if(inventory.getTotalNumberOfItems() != 0){
						System.out.println("Would you like to override the current Inventory?(yes, no)");
						name = reader.nextLine();

						//This if statement will catch if the user enters no and will break out of the case
						if(name.equalsIgnoreCase("no")){
							break;
						}

						//This if statement will catch if the user enters yes and will load the new file
						else if(name.equalsIgnoreCase("yes")){
							System.out.println("What is the name of the inventory file you would like to load? (.txt will be automatically added)");
							name = reader.nextLine();
							inventory.loadInventoryFromFile(name);
							break;
						}

						//This else statement will catch any answer that is not yes or no
						else{
							System.out.println("Invalid Response\n");
							break;
						}
					}

					//This code will only run if the inventory has zero items and will allow the user to load a file
					else if(inventory.getTotalNumberOfItems() == 0){
						System.out.println("What is the name of the inventory file you would like to load? (.txt will be automatically added)");
						name = reader.nextLine();
						inventory.loadInventoryFromFile(name);
						break;
					}

				//This case will end the program and give the user an exit message
				case 5: 
					run = false;
					System.out.println("Thank you for using the Inventory Tracker!\nHave a nice day!");
					break;

				//The default case will run if the user enters an invalid choice
				default:
					System.out.println("Invalid choice.\nPlease try again.\n");
				}
			}
			//Catches if the user is trying to input an incorrect data type into Scanner
			catch (InputMismatchException e){
				System.out.println("Invalid Entry\n");
				reader.nextLine();
			}
			//Catches all other exceptions that may occur and prints an error message
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		}while(run == true);//The do-while loop will run while run is equal to true
		reader.close();//Closes the instance of Scanner
	}

}
