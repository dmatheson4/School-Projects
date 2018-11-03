/*
Dan Matheson
Homework 5 Part 2
*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define NUMROWS 5
#define NUMCOLS 10
void generateArray(int **);
void printArray(int **);
void selectionSort(int **, int, int, int, int);
void quickSort(int **, int, int, int, int, int);
int main()
{
	int **arr;
	arr = (int **)calloc(5, sizeof(int *));
	arr[0] = (int *)calloc(10, sizeof(int));
	arr[1] = (int *)calloc(5, sizeof(int));
	arr[2] = (int *)calloc(2, sizeof(int));
	arr[3] = (int *)calloc(7, sizeof(int));
	arr[4] = (int *)calloc(6, sizeof(int));
	generateArray(arr);
	printArray(arr);
	printf("\n");
	selectionSort(arr, 0, 1, 0, 0);
	printArray(arr);
}
void generateArray(int **arr)
{
	int i, j, nums = 10;
	srand(time(NULL));
	for(i=0;i<NUMROWS;)
	{
		for(j=0;j<=nums;j++)
		{
			if(nums == 10)
			{
				if(j == 10)
				{
					nums = 5;
					j = nums + 1;
					i++;
				}
				else
					arr[i][j] = rand() % 100 + 1;
			}
			else if(nums == 5)
			{
				if(j == 5)
				{
					nums = 2;
					j = nums + 1;
					i++;
				}
				else
					arr[i][j] = rand() % 100 + 1;
			}
			else if(nums == 2)
			{
				if(j == 2)
				{
					nums = 7;
					j = nums + 1;
					i++;
				}
				else
					arr[i][j] = rand() % 100 + 1;
			}
			else if(nums == 7)
			{
				if(j == 7)
				{
					nums = 6;
					j = nums + 1;
					i++;
				}
				else
					arr[i][j] = rand() % 100 + 1;
			}
			else
			{
				if(j == 6)
					i++;
				else
					arr[i][j] = rand() % 100 + 1;
			}
		}
	}
	return;
}
void printArray(int **arr)
{
	int i, j, nums = 10;
	for(i=0;i<NUMROWS;)
	{
		for(j=0;j<=nums;j++)
		{
			if(nums == 10)
			{
				if(j == 10)
				{
					nums = 5;
					j = nums + 1;
					i++;
					printf("\n");
				}
				else
					printf("%d ", arr[i][j]);
			}
			else if(nums == 5)
			{
				if(j == 5)
				{
					nums = 2;
					j = nums + 1;
					i++;
					printf("\n");
				}
				else
					printf("%d ", arr[i][j]);
			}
			else if(nums == 2)
			{
				if(j == 2)
				{
					nums = 7;
					j = nums + 1;
					i++;
					printf("\n");
				}
				else
					printf("%d ", arr[i][j]);
			}
			else if(nums == 7)
			{
				if(j == 7)
				{
					nums = 6;
					j = nums + 1;
					i++;
					printf("\n");
				}
				else
					printf("%d ", arr[i][j]);
			}
			else
			{
				if(j == 6)
				{
					i++;
					printf("\n");
				}
				else
					printf("%d ", arr[i][j]);
			}
		}
	}
	return;
}
void selectionSort(int **arr, int row, int col, int prevRow, int currRow)
{
	int temp;
	if(row < NUMROWS)
	{
		printf("%d\n",arr[row][col]);
		if(arr[row][col] == 0)
			selectionSort(arr, row + 1, col, prevRow, currRow);
		else if(arr[row][col] <= arr[prevRow][col])
			selectionSort(arr, row + 1, col, row, currRow);
		else
			selectionSort(arr, row + 1, col, prevRow, currRow);
	}
	else
	{
		temp = arr[currRow][col];
		arr[currRow][col] = arr[prevRow][col];
		arr[prevRow][col] = temp;
		if(currRow + 1 < NUMROWS)
			selectionSort(arr, currRow + 1, col, currRow + 1, currRow + 1);
		else if(currRow + 1 == NUMROWS && col + 2 < NUMCOLS)
			selectionSort(arr, 0, col + 2, 0, 0);
		else
			return;
			
	}
}
void quickSort(int **arr, int row, int col, int pivot, int upper, int lower)
{
	
}
