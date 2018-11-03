#include <stdio.h>

int readNewNum(int);
int numGreater(int, int);
void printThreeLargest(int, int, int);

int main
{
	int count = 1, newNum, largest1 = NULL, largest2 = NULL, largest3 = NULL, i;
	//For loop to get all twenty values from the file
	for(i=0; i<20; i++)
	{
		newNum = readNewNum(i);
		//This will catch if it is the first number inputted
		if(largest3 == NULL)
			largest3 = newNum;
		//This will check if it is the second number inputted
		else if(largest2 == NULL)
			//This will check if the new number is larger than the first number entered
			if(numGreater(newNum, largest3))
			{
				largest2 = largest3;
				largest3 = newNum;
			}
			//This will set the second number to the second largest if it isnt bigger than the first
			else
				largest2 = newNum;
		//This will catch if this is the third number inputted
		else if(largest1 == NULL)
			//This will check if the number is greater than the greatest number so far
			if(numGreater(newNum, largest3))
			{
				largest1 = largest2;
				largest2 = largest3;
				largest3 = newNum;
			}
			//This will check if the number is greater than the second greatest number so far
			else if(numGreater(newNum, largest2))
			{
				largest1 = largest2;
				largest2 = newNum;
			}
			//If the number is not greater than the first two numbers it will be set to the last number
			else
				largest1 = newNum;
		//This will check if the new number is greater than the largest number and put it in the right place
		else if(numGreater(newNum, largest3))
		{
			largest1 = largest2;
			largest2 = largest3;
			largest3 = newNum;
		}
		//This will check if the new number is greater than the second largest number and put it in the right place
		else if(numGreater(newNum, largest2))
		{
			largest1 = largest2;
			largest2 = newNum;
		}
		//This will check if the new number is greater than the third largest number and put it in the right place
		else if(numGreater(newNum, largest1))
			largest1 = newNum;
		count = incrementCounter(count);
	}
}
//This function will read the next new number from the file and return it
int readNewNum(int count)
{
	//Open the input file
	FILE *in;
	int returnValue, i;
	in = fopen("input.txt");
	//Use a for loop to get the value needed
	for(i=0; i<count; i++)
		fscanf(in, "%d", &returnValue);
	//Close the file when done
	fclose(in);
	return returnValue;
}
//This function will return a 1 or 0 depending on if the new number is greater than the current number
int numGreater(int newNum, int currentNum)
{
	return (newNum > currentNum);
}
//This function will increment counter
int incrementCounter(int count)
{
	return ++count;
}

void printThreeLargest(int num1, int num2, int num3)
{
}
