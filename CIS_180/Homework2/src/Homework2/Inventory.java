/* Dan Matheson
 * 10/31/16
 * This class will allow for an inventory of items(up to 100 items) to be created and saved to a file via an array of Items. 
 * It will also allow the user to open up an inventory of items from a file, as long as it is formatted properly.
 */
package Homework2;

import java.io.*;
import java.util.*;

public class Inventory {

	//Declare the attributes of the Inventory class
	private Item itemArray[] = new Item[100];
	private int totalItems = 0;

	//This method will return the total items that are being used
	public int getTotalNumberOfItems(){
		return totalItems;
	}

	//This will return the information for the item in the inventory based on the index number
	public Item getItem(int index){

		//This if statement will catch if the user is trying to get an inventory item that is out of the range of items currently in the inventory
		if (index < 0 || index >= totalItems)
			return null;
		else
			return itemArray[index];
	}

	//This method will add a new item to the array of items in the inventory
	public void addItem(Item newItem){

		//This will check to see if the item passed in is empty or not
		if (newItem == null){
			System.out.println("Item not added\n");
		}

		//If the item passed in is not empty, then it will store it to the inventory
		else{
			itemArray[totalItems] = newItem;
			totalItems++;
			System.out.println("Item added\n");
		}
	}

	//This method will save all of the inventory items to a file when a file name is used
	public void saveInventoryToFile(String fileName){

		//Create an instance of PrintWriter
		PrintWriter outFile = null;

		//This try-catch will catch if any problems occur when trying to print the items info to the file
		try{
			outFile = new PrintWriter(fileName + ".txt");

			outFile.println(totalItems);

			//This for loop will print the attributes of each item to the file
			for (int i = 0; i < totalItems; i++){
				outFile.println(itemArray[i].getName());
				outFile.println(itemArray[i].getQuantity());
				outFile.println(itemArray[i].getPrice());
				outFile.println(itemArray[i].getUPC());
			}
			//Gives a message to the user to let them know that their file was saved
			System.out.println("Inventory Saved to " + fileName + ".txt\n");
			outFile.close();//Closes the instance of PrintWriter
		}
		//This will catch if the file cannot be created and written to
		catch (Exception f){
			System.out.println(f.getMessage() + "\n");
		}
	}

	//This method will set all of the attributes of all of the items in the file
	public void loadInventoryFromFile(String fileName){

		Scanner inFile = null;

		//This try-catch statement will catch if the user is trying to read an empty file
		try{
			//Set the instance of Scanner to be able to read from the specified file
			inFile = new Scanner(new File(fileName + ".txt"));

			totalItems = inFile.nextInt();
			inFile.nextLine();//Catch the EOL character

			//This will loop as long as the file has another line after the upc is read
			for (int i = 0; i < totalItems; i++){
				String name = inFile.nextLine();
				int quantity = inFile.nextInt();
				inFile.nextLine();//Catch the EOL character
				double price = inFile.nextDouble();
				inFile.nextLine();//Catch the EOL character
				String upc = inFile.nextLine();

				//This will set the values read from the text document to one of the items in the array
				itemArray[i] = new Item(name, quantity, price, upc);
			}
			//Gives a message to the user and lets them know that the file was loaded successfully
			System.out.println("Inventory Loaded from " + fileName + ".txt\n");
			inFile.close();//Closes the instance of scanner
		}
		//This will catch if the file is not formatted properly
		catch (Exception e){
			System.out.println("There was a problem reading the file\nIt may not be properly formatted\n");
		}
	}
}
