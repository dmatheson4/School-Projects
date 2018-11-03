/*
Dan Matheson
Homework 1 Problem 2
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
	//Set up the seed for the program
	srand(time(NULL));
	//Declare variables
	int tNum0, tNum1, tNum2, userNum0, userNum1, userNum2, input, guess=1;
	
	//Set the numbers to their random values
	tNum0 = rand() % 10;
	tNum1 = rand() % 10;

	//Use a while loop to ensure that tNum1 is not equal to tNum0
	while(tNum0 == tNum1)
		tNum1 = rand() % 10;
	tNum2 = rand() % 10;

	//Use a while loop to ensure that tNum2 is not equal to tNum0 or tNum1
	while(tNum0 == tNum2 || tNum1 == tNum2)
		tNum2 = rand() % 10;

	//Print welcome message to the user and tell them what to do
	printf("Today we will play a game, you take ten guesses of a 3 digit number, ");
	printf("and I\nwill tell you when one is a match or a hit.\n");

	//While loop to allow the user to have ten guesses
	while(guess!=11)
	{
		//Tell the user what guess they are on and ask them for their guess
		printf("\nThis is you number %d guess\n", guess);
		printf("What is your guess?\n");
		scanf("%d", &input);

		//Check to make sure the user entered a valid number
		if(input < 0 || input > 999)
			printf("Please enter a positive 3 digit number\n");
		else
		{
			//Convert the input into the single integer values
			userNum0 = (input % 1000) / 100;
			userNum1 = (input % 100) / 10;
			userNum2 = input % 10;

			//Check if the left number had any matches or a hit
			if(userNum0 == tNum0)
				printf("Number %d is a hit\n", userNum0);
			else if(userNum0 == tNum1)
				printf("Number %d is a match\n", userNum0);
			else if(userNum0 == tNum2)
				printf("Number %d is a match\n", userNum0);

			//Check if the middle number had any matches or a hit
			if(userNum1 == tNum1)
				printf("Number %d is a hit\n", userNum1);
			else if(userNum1 == tNum0)
				printf("Number %d is a match\n", userNum1);
			else if(userNum1 == tNum2)
				printf("Number %d is a match\n", userNum1);

			//Check if the right number had any matches or a hit
			if(userNum2 == tNum2)
				printf("Number %d is a hit\n", userNum2);
			else if(userNum2 == tNum0)
				printf("Number %d is a match\n", userNum2);
			else if(userNum2 == tNum1)
				printf("Number %d is a match\n", userNum2);

			//If the user hits all of the numbers, tell them they won
			if(userNum0 == tNum0 && userNum1 == tNum1 && userNum2 == tNum2)
			{
				printf("Congratulations, you correctly guesssed ");
				printf("%d%d%d\n", tNum0, tNum1, tNum2);
				return 0;
			}
			//Increment guess if there were not three hits
			guess++;
		}		
	}
	//If they do not guess the correct number in ten guesses tell them they have failed
	printf("\nSorry, you were unable to guess the number %d%d%d\n", tNum0, tNum1, tNum2);
	return 0;
	
}
