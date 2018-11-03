/*
Dan Matheson
Homework 3 Part 1
*/
#include <stdio.h>

void towers(int, int, int, int);

int main()
{
	int num;
	//Ask the user for the number of disks
	printf("Enter the number of disks: ");
	scanf("%d", &num);
	printf("The sequence of moves involved in the Tower of HaHa are:\n");
	//Call the recursive towers function to solve the tower of HaHa
	towers(num, 1, 2, 3);
	return 0;
}
//Function to solve the tower of HaHa
void towers(int num, int fromTower, int toTower, int auxTower)
{
	//Terminating condition when the disk number is 1
	if(num == 1)
	{
		printf("Move disk 1 from tower %d to tower %d\n", fromTower, toTower);
		return;
	}
	//Recursive calls for moving disks
	towers(num - 1, fromTower, auxTower, toTower);
	printf("Move disk %d from tower %d to tower %d\n", num, fromTower, toTower);
	towers(num - 1, auxTower, toTower, fromTower);
}
