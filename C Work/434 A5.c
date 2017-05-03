#include <stdio.h>
#include <stdlib.h>

/*  Author: Dillon Harless
	Date: 4.26.2017
	
	This program finds and prints addresses of different data types */


int gInt;
double gDouble;
char gChar;
int main(int argc, char** argv);

/*Author: Dillon Harless
  Params: int, double, char
  
  This function prints several addresses */
  
void findAddresses(int pInt, double pDouble, char pChar){
	
	/*  Here I created variables and implemented 
		dynamic memory allocation. I casted to the
		proper types to ensure all c compilers would accept them,
		making the code more portable. */
		
	int *dynInt;
    dynInt = (int *) malloc(100);
	double *dynDouble;
    dynDouble = (double *) malloc(200);
	char *dynChar;
    dynChar = (char *) malloc(50);
	
	/*locals*/
	
	int lInt;
	double lDouble;
	char lChar;
	
	/*statics*/ 
	
	static int sInt;
	static double sDouble;
	static char sChar;
	
	/*Literals*/ 
	const char *CCHAR;
	CCHAR = (char *) "This is me string";
	
	
	
	printf ("Address of gInt = %p\n", &gInt);
	printf ("Address of gDouble = %p\n", &gDouble);
	printf ("Address of gChar = %p\n", &gChar);
	printf ("Address of pInt = %p\n", &pInt);
	printf ("Address of pDouble = %p\n", &pDouble);
	printf ("Address of pChar = %p\n", &pChar);
	printf ("Address of lInt = %p\n", &lInt);
	printf ("Address of lDouble = %p\n", &lDouble);
	printf ("Address of lChar = %p\n", &lChar);
	printf ("Address of dynInt's pointer = %p\n", &dynInt);	
	printf ("Address of dynDouble's pointer = %p\n", &dynDouble);	
	printf ("Address of dynChar's pointer = %p\n", &dynChar);
	printf ("Address of dynInt = %p\n", dynInt);	
	printf ("Address of dynDouble = %p\n", dynDouble);	
	printf ("Address of dynChar = %p\n", dynChar);
	printf ("Address of sInt = %p\n", &sInt);
	printf ("Address of sDouble = %p\n", &sDouble);
	printf ("Address of sChar = %p\n", &sChar);
	printf ("Address of main() = %p\n", main);
	printf ("Address of findAddresses = %p\n", findAddresses);
	printf ("Address of CCHAR = %p\n", &CCHAR);
	printf ("Address of CCHAR's pointer = %p\n", CCHAR);




	
}

/*Author: Dillon Harless
  Params: argv[]
  
  This function calls findAdress(), passing a few values */
  
int main(int argc, char** argv){
	
	int passInt = 1;
	double passDouble = 2.0;
	char passChar = 'a';
	findAddresses(passInt,passDouble,passChar);
	
	return (EXIT_SUCCESS);
}


