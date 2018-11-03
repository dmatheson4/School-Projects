/*
Dan Matheson
Homework 1 Problem 1
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
	//Set up the seed for the program
	srand(time(NULL));
	
	int randNum1, randNum2, numQuestions=0, input=-1, randResponse;
	int grade=0, numCorrect=0, numIncorrect=0, wrongAnswer=0, nextQuestion=1;

	//Print a welcome message to the user
	printf("Welcome to the Multiplication Tester!\n");

	//While loop to loop until 10 questions have been answered
	while(numQuestions != 10)
	{
		//This will check if the next questions random numbers are being generated
		if(nextQuestion == 1)
		{
			randNum1 = rand() % 10;
			randNum2 = rand() % 10;
			//Set the next question value to zero
			nextQuestion = 0;
		}
		//Ask the user the question on what is being multiplied and scan for their input
		printf("\nHow much is %d times %d? ", randNum1, randNum2);
		scanf("%d", &input);
		
		//Check if the input from the user was the correct answer
		if(input == (randNum1 * randNum2))
		{
			//Generate a random response and pass it into a switch function
			randResponse = rand() % 4;
			switch(randResponse)
			{
				case 0:
					printf("\nVery good!\n");
					break;
				case 1:
					printf("\nExcellent!\n");
					break;
				case 2:
					printf("\nNice work!\n");
					break;
				case 3:
					printf("\nKeep up the good work!\n");
					break;
				default:
					printf("\nIf this prints something went terribly wrong\n");
			}
			//Increment the number of questions answered correctly
			numQuestions++;
			//Check if they got the answer right on the first try
			if(wrongAnswer == 0)
				numCorrect++;
			//If they got it wrong the first try, the value of wrong answer is reset
			else
			{
				numIncorrect++;	
				wrongAnswer = 0;
			}
			//This will allow the loop to generate a new set of random numbers
			nextQuestion = 1;
		}
		//If they got the question wrong then this code will run
		else
		{
			//Generate a random response and pass it into a switch function
			randResponse = rand() % 4;
			switch(randResponse)
			{
				case 0:
					printf("\nNo. Please try again.\n");
					break;
				case 1:
					printf("\nWrong. Try once more.\n");
					break;
				case 2:
					printf("\nDon't give up!\n");
					break;
				case 3:
					printf("\nNo. Keep trying.\n");
					break;
				default:
					printf("\nIf this prints something went terribly wrong\n");
			}
			//This will tell that the answer on the first try was wrong
			wrongAnswer = 1;
		}
	}
	//Calculate the students grade
	grade = (numCorrect * 100) / (numCorrect + numIncorrect);
	//Print the grade and the number of correct and incorrect answers to the user
	printf("\nYour Score: %d\n", grade);
	printf("Number of correct responses: %d\n", numCorrect);
	printf("Number of incorrect responses: %d\n", numIncorrect);
	//Check if the grade is below a 75 to see if they need extra help
	if(grade < 75)
		printf("Please ask you instructor for extra help\n");
	return 0;
	
}

