/*
Dan Matheson
Homework 3 Part 3
*/
#include <stdio.h>
#define ARRSIZE 1000
int numPipes(int[], int, int);
void sortVectors(int[], int);

int main()
{
	int pipeVectors[ARRSIZE] = {0}, count=0, input=-1, sum;
	//While loop to get input from the user
	while(input!=0)
	{
		printf("Enter a pipe vector from size 1 to 10 (0 to stop): ");
		scanf("%d", &input);
		//Check if the entry was between 1 and 10
		if(input > 10 || input < 0)
			printf("Invalid Input\n");
		else
		{
			pipeVectors[count] = input;
			count++;
		}
	}
	//Check if the user did not enter any pipe vectors
	if(count == 0)
		printf("\nYou do not need any pipes");
	//Check if the user entered only one pipe vector
	else if(count == 1)
		printf("\nWith that vector, you only need 1 pipe");
	//Runs if the user enters more than one pipe vector
	else
	{
		//Sort the vector and find out how many pipes are needed using functions
		sortVectors(pipeVectors, count-1);
		sum = numPipes(pipeVectors, 0, count-1);
		printf("\nWith those vectors, it will take %d %s to complete\n", sum, sum>1? "pipes":"pipe");
	}
}
//Function to calculate how many pipes are needed to fulfill the needs of the plumber
int numPipes(int vect[], int front, int back)
{
	//Condition to check if the front value plus the back value is greater than 10
	if((vect[front]+vect[back])>10)
	{
		//Check if there is another front value
		if(front+1 <= ARRSIZE && vect[front+1]!=0)
			return 1 + numPipes(vect, front+1, back);//Recursive call to find another pipe vector
		else
			return 1;//Terminating condition if there are no more front values
	}
	//Condition to check if the front value plus the back value is equal to 10
	else if((vect[front]+vect[back])==10)
	{
		vect[back]=0;
		if(front+1 <= ARRSIZE && vect[front+1]!=0)
			return 1 + numPipes(vect, front+1, back-1);//Recursive call to find another pipe vector
		else
			return 1;//Terminating condition if there are no more front values
	}
	//Condition to run if the front value plus the back value is less than 10
	else
	{
		//Set the front value to the front value plus the back value
		vect[front] = vect[front]+vect[back];
		//Set the back value to 0
		vect[back]=0;
		//Terminating condition to check if the front index is equal to the back index-1
		if(front == (back-1))
			return 1;
		//Recursive call if there is another back value
		return numPipes(vect, front, back-1);
	}
	
	
}
//Function to sort the pipe vector
void sortVectors(int vect[], int size)
{
	int i, j, tempVal=0, tempValIndex, tempArray[ARRSIZE] = {0};
	//For loop to loop through all of the indeces used in the array
	for(i=0;i<size;i++)
	{
		//Loop through and compare to all other indeces in the array
		for(j=0;j<size;j++)
		{
			//Check if the value is bigger than the current one and change the largest value if needed
			if(vect[j] > tempVal)
			{
				tempVal = vect[j];
				tempValIndex =  j;
			}
		}
		//Set the value in the i position in the temporary array and set the next largest value to 0
		tempArray[i] = tempVal;
		tempVal = 0;
		vect[tempValIndex] = 0;
	}
	//Loop through the size of the array used and set the value in the origional array to that value
	for(i=0;i<size;i++)
		vect[i] = tempArray[i];
}
