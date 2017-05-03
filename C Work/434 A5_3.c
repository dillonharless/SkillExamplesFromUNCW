#include <stdio.h>
#include <stdlib.h>


/*  Author: Dillon Harless
	Date: 4.26.2017
	
	This program declares a 3-dimensional array and prints the address of each index. */
	
	
int main(int argc, char** argv);

int main(int argc, char** argv){
	
	
	double myDoubles[4][2][3];
	int i;
	int j;
	int k;
	
	for (i = 0; i < 4; i++) {
		for (j = 0; j < 2; j++) {
			for (k = 0; k < 3; k++){
		printf("Address of doubles[%d][%d][%d]: %u\n", i, j,k, &myDoubles[i][j][k]);

		printf("\n");
			}
		}
	}	
	return (EXIT_SUCCESS);
}