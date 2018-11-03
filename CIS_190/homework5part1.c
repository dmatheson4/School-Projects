/*
Dan Matheson
Homework 5 Part 1
*/
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#define ARRSIZE 5
void generateRandArray(int [], int *[], int *[]);
void printArray(int [], int *[], int *[]);
void sortArray(int [], int *[], int *[], int, int, int, int);
int main()
{
	int normal[ARRSIZE], *ascend[ARRSIZE], *descend[ARRSIZE];
	//generate the random numbers and assign the pointers to the normal array
	generateRandArray(normal, ascend, descend);
	//call the sorting function to sort the pointers to the normal array in ascending and descending format
	sortArray(normal, ascend, descend, 1, 0, 0, ARRSIZE - 1);
	//print the sorted array to the screen
	printArray(normal, ascend, descend);
	return 0;
}
//Function to generate a random number array and assign the pointer arrays to the function unsorted
void generateRandArray(int arr[], int *asc[], int *desc[])
{
	int i, randNum;
	srand(time(NULL));
	//Loop through the array and set it to a random number between 1 and 100
	for(i=0;i<ARRSIZE;i++)
	{
		randNum = (rand() % 100) + 1;
		asc[i] = &arr[i];
		desc[i] = &arr[i];
		*(arr + i) = randNum;
	}
	return;
}
//Function to print the three arrays
void printArray(int arr[], int *asc[], int *desc[])
{
	int i;
	printf("Ascending\tOriginal\tDescending\n");
	//Loop through the array and print the rows of the normal array and pointer arrays
	for(i=0;i<ARRSIZE;i++)
		printf("%6d\t\t%6d\t\t%7d\n", *asc[i], arr[i], *desc[i]);
	return;
}
//Function to sort the pointers to the normal array in ascending and descending order
void sortArray(int arr[], int *asc[], int *desc[], int index, int prevIndex, int currIndex, int numIndeces)
{
	//Check if the index is within the bounds
	if(index <= numIndeces)
	{
		//Check if it is the smallest number being found or the first pointer of the ascending array
		if(currIndex == 0 && arr[index] <= arr[prevIndex])
		{
			sortArray(arr, asc, desc, index + 1, index, currIndex, numIndeces);
		}
		//Check if it is the second row or higher and the current index number is greater than or equal to the last smallest number found
		else if(currIndex > 0 && arr[index] >= *asc[currIndex - 1])
		{
			//Check for a repeated number
			if(arr[index] == *asc[currIndex - 1] && (&arr[index] < asc[currIndex - 1]))
				sortArray(arr, asc, desc, index + 1, index, currIndex, numIndeces);
			//Pass the repeated number to make sure it is assigned in the next spot on the ascending array
			else if(arr[prevIndex] == *asc[currIndex - 1] && (&arr[prevIndex] != asc[currIndex - 1]))
				sortArray(arr, asc, desc, index + 1, prevIndex, currIndex, numIndeces);
			//Check if the number is the next smallest number and pass it to the next function call
			else if((arr[prevIndex] <= *asc[currIndex - 1] || arr[index] <= arr[prevIndex]) && arr[index] > *asc[currIndex - 1])
				sortArray(arr, asc, desc, index + 1, index, currIndex, numIndeces);
			//Call the function with the previous value if there is not an equal or lesser value
			else
				sortArray(arr, asc, desc, index + 1, prevIndex, currIndex, numIndeces);
		}
		//Will run if the number is less than the last smallest number found
		else
			sortArray(arr, asc, desc, index + 1, prevIndex, currIndex, numIndeces);
	}
	//Runs if the index is trying to go out of bounds
	else
	{
		//Set the pointers of the ascending and descending arrays to the index of the previous value
		asc[currIndex] = &arr[prevIndex];
		desc[numIndeces - currIndex] = &arr[prevIndex];
		//Check if there is another number to find
		if((currIndex + 1) <= numIndeces)
			sortArray(arr, asc, desc, 1, 0, currIndex + 1, numIndeces);
		//Terminating condition if there are no more numbers to find
		else
			return;
	}
}
