#include <stdio.h>
#include <math.h>

void getNewNum(int *);
void addNewNum(int *,int *);
void numLessThanTwenty(int *, int *);
void average(int *, int *, float *);
void squareRoot(int *, float *);
void allNumsBetween(int *, int *);
void incrementCounter(int *);
void printToScreen(int *, float *, float *, int *, int *, int *);


int main()
{
	int newNum, sum=0, numLessTwenty=0, count=1, allBetween=1;
	float avg, sqRoot;
	//Loop through and get new numbers from the user
	do
	{
		//Get the new number from the user
		getNewNum(&newNum);
		//Check if the user entered a non zero number
		if(newNum!=0 && newNum>0)
		{
			//Add the new number to the sum
			addNewNum(&newNum, &sum);
			//Check if the number is still less than twenty
			numLessThanTwenty(&newNum, &numLessTwenty);
			//Calculate the new average
			average(&sum, &count, &avg);
			//Calculate the new square root of the function
			squareRoot(&sum, &sqRoot);
			//Check if the number is still between 10 and 90
			allNumsBetween(&newNum, &allBetween);
			//Print all of the information to the screen
			printToScreen(&sum, &avg, &sqRoot, &numLessTwenty, &allBetween, &count);
			//Increment the count
			incrementCounter(&count);
		}
	}while(newNum!=0);
	return 0;
}

//Function to get the number from the user
void getNewNum(int *newNum)
{
	//Get the number from the user
	printf("\nEnter a positive number (Enter 0 to quit): ");
	scanf("%d", &*newNum);
	return;
}
//Function to add a new number
void addNewNum(int *newNum,int *sum)
{
	//Add the new number to the sum
	*sum+=*newNum;
	return;
}

//Function to check if the number was less than twenty
void numLessThanTwenty(int *newNum,int *lessThan)
{
	//Check if the number is less than 20 or not
	if(*lessThan==1 || *newNum < 20)
		*lessThan = 1;
	else
		*lessThan = 0;
	return;
}

//Function to calculate the average of the numbers added
void average(int *sum,int *count,float *average)
{
	*average = ((float)*sum) / ((float)*count);
	return;
}

//Function to calculate the square root of the sum
void squareRoot(int *sum,float *sqRoot)
{
	//Calculate the square root of the sum
	*sqRoot = sqrt(*sum);
	return;
}

//Function to see if all of the numbers were between 10 and 90
void allNumsBetween(int *newNum,int *allBetween)
{
	//Check if all the numbers are still between 10 and 90
	if(*allBetween == 1 && *newNum >= 10 && *newNum <= 90)
		*allBetween = 1;
	else
		*allBetween = 0;
	
	return;
}

//Function to increment the count
void incrementCounter(int *count)
{
	//Increment the count
	*count = *count + 1;
	return;
}

//Function to print to the screen
void printToScreen(int *sum,float *average,float *sqRoot,int *lessThan,int *allBetween,int *count)
{
	//Print all of the values to the screen
	printf("The number of integers is:\t\t%d\n", *count);
	printf("The sum of the integers is:\t\t%d\n", *sum);
	printf("The average of the integers is:\t\t%3.2f\n", *average);
	printf("The square root is:\t\t\t%3.2f\n", *sqRoot);
	printf("At least one number was <20:\t\t%s\n", *lessThan == 1 ? "True" : "False");
	printf("All numbers between 10 and 90:\t\t%s\n", *allBetween == 1 ? "True" : "False");
	return;
}

