#include <stdio.h>
#define NUMCITIES 14
//int calcPath(char[][16], int [][NUMCITIES]);
int findOpenPath(int [][NUMCITIES], int, int, int);
int main()
{
	char cities[NUMCITIES][16]={	{"New York City"},
					{"Washington D.C."},
					{"Milwaukee"},
					{"Chicago"},
					{"Minneapolis"},
					{"Seattle"},
					{"Oklahoma City"},
					{"San Francisco"},
					{"Las Vegas"},
					{"Los Angeles"},
					{"Phoenix"},
					{"Dallas"},
					{"New Orleans"},
					{"Miami"}};

	int connections[NUMCITIES][NUMCITIES]={	{0,237,0,0,1217,0,0,0,0,0,0,1614,0,0},
						{237,0,811,0,0,0,0,0,0,0,0,0,0,0},
						{0,811,0,0,0,0,0,2257,0,0,1771,0,0,0},
						{0,0,0,0,0,2060,0,0,1780,0,0,0,948,1423},
						{1217,0,0,0,0,0,792,0,0,0,0,949,0,0},
						{0,0,0,2060,0,0,0,808,0,0,0,0,0,0},
						{0,0,0,0,792,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,808,0,0,0,414,0,0,0,0},
						{0,0,0,1780,0,0,0,0,0,272,0,0,0,0},
						{0,0,0,0,0,0,0,414,272,0,0,1440,0,0},
						{0,0,1771,0,0,0,0,0,0,0,0,0,0,0},
						{1614,0,0,0,949,0,0,0,0,1440,0,0,517,0},
						{0,0,0,0,0,0,0,0,0,0,0,517,0,0},
						{0,0,0,948,0,0,0,0,0,0,0,0,0,0}};
	int i, j, valid = 0, to, from;
	/*for(i=0;i<NUMCITIES;i++)
		for(j=0;j<NUMCITIES;j++)
			if(connections[i][j])
				printf("Distance from %s to %s is %d\n", cities[i], cities[j], connections[i][j]);*/
	while(valid == 0)
	{
		printf("Use the list of cities below to say where you are coming from and going to:\n");
		for(i=0;i<NUMCITIES;i++)
			printf("\t%s%d:%s\n", i>8? "":" ", i+1, cities[i]);
		printf("Where are you coming from(1 to %d)? ", NUMCITIES);
		scanf("%d", &from);
		if(from > NUMCITIES || from < 1)
		{
			valid = 0;
			printf("Invalid Input\n");
		}
		else
		{
			printf("Where are you going to(1 to %d)? ", NUMCITIES);
			scanf("%d", &to);
			if(to > NUMCITIES || to < 1)
			{
				valid = 0;
				printf("Invalid Input");
			}
			else
				valid = 1;
		}
			
	}
	printf("Paths from %s to %s\n", cities[from-1], cities[to-1]);
	printf("-------------------------------------------------------\n");
	
}
int calcPath(char c[][16], int d[][NUMCITIES], int to, int from, int pos, int skip, int dist)
{
	int next;
	if(pos == to)
	{
		printf("Travel from %s to %s.", c[from], c[to]);
	}
	else if(skip > 1)
	{
		next = findOpenPath(d, pos, 0, skip);
		if(next == -1)
			return next;
		else if(
	}
	else if(pos == 0)
	{
		
	}
}
//This function will find an open path given a number of paths to skip
int findOpenPath(int d[][NUMCITIES], int curr, int next, int skips)
{
	if(skips > 0 && d[curr][next]>0 && next+1<NUMCITIES)
		return findOpenPath(d, curr, next+1, skips-1);
	else if(skips == 0 && d[curr][next]>0)
		return next;
	else if(d[curr][next]==0 && next+1<NUMCITIES)
		return findOpenPath(d, curr, next+1, skips);
	else if(d[curr][next]==0 && next+1==NUMCITIES)
		return -1;
}




