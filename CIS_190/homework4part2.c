#include <stdio.h>
#include <stdlib.h>
void findPrefixes(int *, int *, char *, int, int, int, int);
int main()
{
	int input, *numSeq, *numTrack, count=0, temp, valid = 0, i, numComb = 1;
	char **charSeq;
	while(valid == 0)
	{
		printf("Enter a number sequence: ");
		scanf("%d", &input);
		temp = input;
		while(temp!=0)
		{
			if(temp%10 == 0 || temp%10 == 1)
			{
				printf("Invalid Input\n");
				temp = 0;
				valid = 0;
				count = -1;
				numbComb = 1;
			}
			else if(temp%10 == 7 || temp%10 == 9)
			{
				numbComb*=4;
				valid = 1;
			}
			else
			{
				numbComb*=3'
				valid = 1;
			}
			temp/=10;
			count++;
		}
	}
	numSeq = (int *)calloc(count, sizeof(int));
	numTrack = (int *)calloc(count, sizeof(int));
	charSeq = (char **)calloc(numComb, sizeof(char *));

	for(i=0;i<numComb;i++)
		*(charSeq + i) = (char *)calloc(count, sizeof(char));

	for(i=0;i<count;i++)
	{
		*(numSeq + (count-i-1)) = input%10;
		if(input%10 == 7 || input%10 == 9)
			*(numTrack + (count-i-1)) = 3;
		else
			*(numTrack + (count-i-1)) = 2;
		input/=10;
	}
	for(i=0;i<count;i++)
	{
		printf("%d\n", *(numSeq + i));
	}
	
}
void findPrefixes(int *i, int *iT, char **c, int count, int charRow, int charCol, int numChar)
{
	char temp;
	switch(*(i+numChar))
	{
		case 2:
			temp = 'a' + *(iT + charCol);
			break;
		case 3:
			temp = 'd' + charCol;
			break;
		case 4:
			temp = 'g' + charCol;
			break;
		case 5:
			temp = 'j' + charCol;
			break;
		case 6:
			temp = 'm' + charCol;
			break;
		case 7:
			temp = 'p' + charCol;
			break;
		case 8:

			temp = 't' + charCol;
			break;
		case 9:
			temp = 'w' + charCol;
			break;
	}
	if(count == 0)
	{
		*(*(c + charRow) + charCol) = temp;
		return;
	}
	else if(
}
