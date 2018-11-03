#include <stdio.h>
#define ARRSIZE 13
int printTower(int);
float calcWeight(float [][ARRSIZE], int, int, int, int, int *);

int main()
{
	int numIn, numBottom=0, count = 0, row = 0, col = 0, n = 1;
	float in, humanPyramid[ARRSIZE][ARRSIZE] = {0};
	//While loop to get input from the user on how many people are in the pyramid
	while(numBottom>13 || numBottom<1)
	{
		printf("Enter the number of people on the bottom of the pyramid(Between 1 and 13): ");
		scanf("%d", &numBottom);
		//Check for invalid input
		if(numBottom > 13 || numBottom < 1)
			printf("Invalid input\n");
	}
	printf("-------------------------------------------------------------------------------\n");
	//Call the print tower function to show the user what the tower looks like and get how many weight inputs that is needed from the user
	numIn = printTower(numBottom);
	printf("Using the pyramid above, enter each persons weight:\n");
	//While loop to get the weight of people in the pyramid from the user
	while(count != numIn)
	{
		printf("Person %d:%s", count+1, count > 8? " " : "  ");
		scanf("%f", &in);
		//Check for valid input from the user
		if(in > 0)
		{
			//Set the value in the array to the users input
			humanPyramid[row][col] = in;
			//Check if the user has inputted as many values as will fit in each row, and go to a new row
			if(col == row)
			{
				row++;
				col = 0;
			}
			//Otherwise, increment the column
			else
				col++;
			count++;
		}
		else
			printf("Invalid input: Please enter a positive weight\n");
	}
	printf("-------------------------------------------------------------------------------\n");
	//Print the tower again to the user to make it easy for them to visualize the tower and compare it to the weights
	printTower(numBottom);
	printf("Use the pyramid above to find the weight each person is holding on their knees:\n");
	//Call the calcWeight function to recursively find each persons weight
	calcWeight(humanPyramid, (numBottom-1), 0, 0, 0, &n);
	return 0;
}
//This function will print the tower to the user to easily associate the numbers with the weights they are inputting
int printTower(int numRows)
{
	int numSpaces, i, j, count=-1, num = 1, numPrints=1, numInputs=0;
	numSpaces = numRows-1;
	
	//While loop to print the pyramid of people to the user
	while((++count) != numRows)
	{
		//print the number of spaces in the row
		for(i=numSpaces; i>0; i--)
			printf(" ");
		//print the numbers in the row
		for(j=numPrints; j>0; j--)
			printf("%s%d ", num>10 ? "" : " ", num++);
		printf("\n");
		//add the number of numbers printed to a running sum
		numInputs+=numPrints;
		numPrints++;
		numSpaces--;
	}
	printf("\n");
	return numInputs;//Return the number of inputs that the user will need to enter
}
//This function will calculate the weight that each person in the tower is holding on their knees
float calcWeight(float arr[][ARRSIZE], int numRows, int cRow, int row, int col, int *n)
{
	float weight;
	//Check if the value asked for is the value at the top of the tower
	if(row == 0 && col == 0)
	{
		//Check if it is the first time calculating this value
		if(cRow == 0)
		{		
			printf("Person 1:  %.2f\n", arr[0][0]);
			*n = *n + 1;//Increment the number of the person being printed
			//Check if there was only a tower of one person
			if(cRow != numRows)
				calcWeight(arr, numRows, cRow+1, row+1, 0, n);
			else 
				return 0.0;
		}
		//If it is not the first time, return the weight of the top person divided by two
		else
			return (arr[0][0] / 2.0);
	}
	//Check if the weight being requested is blank space and return 0
	else if(cRow != row && (col > (ARRSIZE-1) || col < 0 || arr[row][col] == 0.0))
		return 0.0;
	//Check if the weight being requested is in the row above the current row
	else if(cRow != row)
		return (arr[row][col] + calcWeight(arr, numRows, cRow, row-1, col-1, n) + calcWeight(arr, numRows, cRow, row-1, col, n))/2;
	//Check if the next persons weight is being calculated
	else if(cRow == row && col <= cRow)
	{
		//Calculate the weight the current person is holding by adding their weight to the weight of the people above them
		weight = arr[row][col] + calcWeight(arr, numRows, cRow, row-1, col-1, n) + calcWeight(arr, numRows, cRow, row-1, col, n);
		printf("Person %d:%s%.2f\n", *n, *n >= 10 ? " " : "  ", weight);
		*n = *n + 1;//Increment the number of the person being printed
		//Call the function for the next person to the right
		calcWeight(arr, numRows, cRow, row, col+1, n);
	}
	//Check if the value being calculated is at the end of the row. if so, go to the next row
	else if(cRow == row && col > cRow && cRow != numRows)
		calcWeight(arr, numRows, cRow+1, row+1, 0, n);
	//Terminating condition if the program is done finding values for the weight on a persons shoulders
	else if(cRow == row && col > cRow && cRow == numRows)
		return 0.0;
}

