/*
Dan Matheson
Homework 3 Part 2
*/
#include <stdio.h>
#define ARRSIZE 100

void compareNutsAndBolts(int[], int[], int, int, int, int);

int main()
{
	int input=-1, numBolts=0, numNuts=0;
	int nuts[ARRSIZE] = {0}, bolts[ARRSIZE] = {0};
	//While loop to allow the user to enter as many bolt sizes as they wish
	while(input!=0)
	{
		printf("Enter sizes of bolts(0 to stop): ");
		scanf("%d", &input);
		//Check for valid input
		if(input<0)
			printf("Invalid Input");
		else if(input != 0)
		{
			bolts[numBolts] = input;
			numBolts++;
			//Check if the array is full
			if(numBolts == ARRSIZE)
			{
				printf("Maximum number of bolts added\n");
				input = 0;
			}
		}
	}
	printf("You have entered %d Bolt sizes\n", numBolts);
	printf("-------------------------------------------\n");
	input = -1;
	//Loop to allow the user to enter as many nut sizes as they wish
	while(input!=0)
	{
		printf("Enter sizes of nuts(0 to stop): ");
		scanf("%d", &input);
		//Check for valid input
		if(input<0)
			printf("Invalid Input");
		else if(input != 0)
		{
			nuts[numNuts] = input;
			numNuts++;
			//Check if the array is full
			if(numNuts == ARRSIZE)
			{
				printf("Maximum number of nuts added\n");
				input = 0;
			}
		}
	}
	printf("You have entered %d Nut sizes\n", numNuts);
	printf("-------------------------------------------\n");
	compareNutsAndBolts(bolts, nuts, 0, 0, numBolts, numNuts);
}
//Function to recursively match bolts to nuts
void compareNutsAndBolts(int bolt[], int nut[], int index1, int index2, int numB, int numN)
{
	//This will check if there are no more bolts to compare to nuts
	if(numB == 0 && numN > 0)
	{
		//This will check if the nut at the index is greater than zero
		if(nut[index2] > 0)
		{
			numN--;
			printf("There is no match for nut of size %d\n", nut[index2]);
			printf("-------------------------------------------\n");
		}
		//This will check if the number of nuts is still greater than zero and recursively call
		if(numN > 0)
			compareNutsAndBolts(bolt, nut, 0, index2+1, 0, numN);
		//Terminating condition when the number of nuts and bolts are zero
		else
			return;
	}
	//This will check if there are no more nuts to compare to bolts
	else if(numN == 0 && numB > 0)
	{
		numB--;
		printf("There is no match for bolt of size %d\n", bolt[index1]);
		printf("-------------------------------------------\n");
		if(numB > 0)
			compareNutsAndBolts(bolt, nut, index1+1, 0, numB, 0);
		//Terminating condition when the number of nuts and bolts are zero
		else
			return;
	}
	//This will check if the size of the bolt is smaller than the nut
	else if(bolt[index1] < nut[index2])
	{
		printf("The bolt of size %d is smaller than the nut of size %d\n", bolt[index1], nut[index2]);
		//This will check if there is another nut to compare to the bolt
		if(index2+1 < ARRSIZE && nut[index2+1] != 0)
			compareNutsAndBolts(bolt, nut, index1, index2+1, numB, numN);
		//This will check if there is another bolt that can be compared to the nuts
		else if(numB-1 != 0 && bolt[index1+1] != 0)
		{
			printf("There is no nut to match the bolt of size %d\n", bolt[index1]);
			printf("-------------------------------------------\n");
			numB--;
			compareNutsAndBolts(bolt, nut, index1+1, 0, numB, numN);
		}
		//This will check if there are no more bolts to compare to the nuts
		else if(numB-1 == 0)
		{
			printf("There is no nut to match the bolt of size %d\n", bolt[index1]);
			printf("-------------------------------------------\n");
			compareNutsAndBolts(bolt, nut, 0, 0, 0, numN);
		}
			
	}
	//This will check if the size of the bolt is greater than the nut
	else if(bolt[index1] > nut[index2])
	{
		//This will check if the nut it is being compared to has been removed from the array
		if(nut[index2] != -1)
			printf("The bolt of size %d is greater than the nut of size %d\n", bolt[index1], nut[index2]);
		//This will check if there is another nut to compare to the bolt
		if(index2+1 < ARRSIZE && nut[index2+1] != 0)
			compareNutsAndBolts(bolt, nut, index1, index2+1, numB, numN);
		//This will check if there is another bolt to compare to the nuts
		else if(numB-1 != 0 && bolt[index1+1] != 0)
		{
			printf("There is no nut to match the bolt of size %d\n", bolt[index1]);
			printf("-------------------------------------------\n");
			numB--;
			compareNutsAndBolts(bolt, nut, index1+1, 0, numB, numN);
		}
		//This will check if there are no more bolts to be compared to nuts
		else if(numB-1 == 0)
		{
			printf("There is no nut to match the bolt of size %d\n", bolt[index1]);
			printf("-------------------------------------------\n");
			compareNutsAndBolts(bolt, nut, 0, 0, 0, numN);
		}
	}
	//This will check if the size of the bolt is equal to the nut
	else if(bolt[index1] == nut[index2])
	{
		printf("The bolt of size %d is a match to the nut of size %d\n", bolt[index1], nut[index2]);
		printf("-------------------------------------------\n");
		nut[index2] = -1;
		numB--;
		numN--;
		//This will check if there is another bolt to compare to the nuts
		if(numB > 0 && numN > 0)
			compareNutsAndBolts(bolt, nut, index1+1, 0, numB, numN);
		//This will check if there are no more bolts to compare to the nuts
		else if(numB == 0 && numN > 0)
			compareNutsAndBolts(bolt, nut, 0, 0, 0, numN);
		//This will check if there are no more nuts to compare to the bolts
		else if(numB > 0 && numN == 0)
			compareNutsAndBolts(bolt, nut, index1+1, 0, numB, 0);
		//Terminating condition when the number of nuts and bolts is equal to zero
		else
			return;
	}
}
