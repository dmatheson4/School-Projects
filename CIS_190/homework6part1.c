/*
Dan Matheson
Homework 6 Part 1
*/
#include <stdio.h>
#include <stdlib.h>
#define NAMESIZE 20
//Create the structure for the BEER class
typedef struct beerStr
{
	char name[NAMESIZE];
	int id;
	int quantity;
	double price;
}BEER;

BEER *loadInventory();
void printBeerItem(BEER);
void findBeer(BEER *);
void printEntireInv(BEER *, int, int, int);
void placeOrder(BEER *inv);

int main()
{
	int input;
	BEER *inventory;
	//Load the inventory of beer from the beer.dat file
	inventory = loadInventory();
	printf("Welcome to the Beer Inventory Program\n");
	//loop so that the user can do all that they want to do
	while(1)
	{
		//Get input from the user
		printf("\nPress:\n");
		printf("\t1: Find a Beer by ID number\n");
		printf("\t2: Print Entire Inventory\n");
		printf("\t3: Place an order\n");
		printf("\t4: To Exit\n:");
		scanf("%d", &input);
		//Use a switch statement to go to the part they want to run
		switch(input)
		{
			case 1:
				findBeer(inventory);
				break;
			case 2:
				printEntireInv(inventory, 0, 0, 0);
				break;
			case 3:
				placeOrder(inventory);
				break;
			case 4:
				printf("Thank you for using the Beer Inventory Program\n");
				return 0;
			default:
				printf("Invalid Entry, try again\n");
		}
	}
}
//Function to load the inventory of beers and return the pointer to it
BEER *loadInventory()
{
	int numItems, i;
	BEER *inv;
	//Open the file to be read from
	FILE *in;
	in = fopen("beer.dat", "r");
	if(in == NULL)
	{
		printf("The inventory file cannot be read\n");
		system.exit(100);
	}
	//Read the number of inventory items
	fscanf(in, "%d", &numItems);
	//Allocate the array based on the number of inventory items
	inv = (BEER *)calloc(numItems+1, sizeof(BEER));
	//Set a terminating condition to be used later on
	inv[numItems].price = -1;
	//For loop to loop through the file and store the information on all of the beers
	for(i=0;i<numItems;i++)
	{
		fscanf(in, "%s", inv[i].name);
		fscanf(in, "%d", &inv[i].id);
		fscanf(in, "%d", &inv[i].quantity);
		fscanf(in, "%lf", &inv[i].price);
	}
	//Close the file
	fclose(in);
	//Return the pointer to the inventory
	return inv;
}
//Function to print a beer item based on the beer passed to the function
void printBeerItem(BEER item)
{
	printf("\nInventory Information for ID: %07d\n", item.id);
	printf("Name: %s\n", item.name);
	printf("Quantity: %d\n", item.quantity);
	printf("Price: %.2lf\n", item.price);
	return;
}
//Function to find and print an inventory item the user is looking for by ID
void findBeer(BEER *inv)
{
	int count = 0, id;
	//Get the ID the user is looking for
	printf("What is the ID of the Beer you are searching for?\n");
	scanf("%d", &id);
	//Loop through all of the spots until count hits the terminating value
	while(inv[count].price != -1)
	{
		//If the ID matches then print the beer to the user and exit the function
		if(inv[count].id == id)
		{
			printBeerItem(inv[count]);
			return;
		}
		//Increment the count
		count++;
	}
	//If the beer is not found before exiting the loop then it is not in the inventory
	printf("\nThat Beer Item does not exist in the inventory!\n");
	return;
}
//Function to print and sort the array of inventory items
void printEntireInv(BEER *inv, int next, int prev, int count)
{
	BEER temp;
	//Check for terminating value
	if(inv[next].price == -1)
	{
		//Print the next lowest price inventory item
		printBeerItem(inv[prev]);
		//Set the temporary beer pointer to the slot being sorted
		temp = inv[count];
		//Set the slot at count to the next lowest price item
		inv[count] = inv[prev];
		//Set the slot at the lowest price item to temp
		inv[prev] = temp;
		//Check if there are more items to be sorted
		if(inv[count+1].price != -1)
			printEntireInv(inv, count+1, count+1, count+1);
		//Terminating condition if there are no more inventory items left
		else
			return;
	}
	//Check if the price of the next item is less than the previous
	else if(inv[next].price <= inv[prev].price)
		printEntireInv(inv, next + 1, next, count);
	//Otherwise the price is higher
	else
		printEntireInv(inv, next + 1, prev, count);
}
//Function to allow the user to place an order
void placeOrder(BEER *inv)
{
	int id, quantity = -1, count = 0;
	//Get the ID number of the beer the user wants
	printf("What is the ID of the Beer you would like?\n");
	scanf("%d", &id);
	//Loop through until the end of the inventory is found
	while(inv[count].price != -1)
	{
		//Check if the item is found
		if(inv[count].id == id)
		{
			//Print the items info to the user and break out of the loop
			printBeerItem(inv[count]);
			quantity = 0;
			break;
		}
		count++;
	}
	//If the value of quantity is still -1, then the item was not found
	if(quantity == -1)
	{
		printf("\nThat Beer Item does not exist in the inventory!\n");
		return;
	}
	//Ask the user for how many of that type of beer they want
	printf("How many %ss would you like to order?\n", inv[count].name);
	scanf("%d", &id);
	//Check if the number entered was an invalid amount
	if(id > inv[count].quantity || id < 1)
	{
		printf("Invalid Number of %ss\n", inv[count].name);
		return;
	}
	//Print the invoice to the user if the number they entered was valid
	printf("\nINVOICE\n");
	printf("------------------\n");
	printf("Name: %s\n", inv[count].name);
	printf("Item ID: %07d\n", inv[count].id);
	printf("Quantity: %d\n", id);
	printf("Price: %.2lf\n", inv[count].price);
	printf("------------------\n");
	printf("Subtotal: %.2lf\n\n", inv[count].price * id);
	//Decrement the number of items in the inventory by the number of items the user wants
	inv[count].quantity = inv[count].quantity - id;
	return;
}
