#include <stdio.h>
#include <stdlib.h>


/*  Author: Dillon Harless
	Date: 4.26.2017
	
	This program implements recursive factorial, and attempts to print addresses of values along the way. */

int myFactorial(int myInt);
int myTracker = 0;

int main()
{
    int myInt;
    printf("Enter a positive integer: ");
    scanf("%d", &myInt);
    printf("Factorial of %d = %ld", myInt, myFactorial(myInt));
    return 0;
}
int myFactorial(int myInt)
{   
	//Not really working properly. Prints same address every time. The original one i submitted was working.
    if (myInt >= 1){
		myTracker+=1;
		printf("The address of call %d is %p \n",myTracker,&myFactorial);
		//printf("The value of call %d is %d \n\n",myTracker,myFactorial);

        return myInt*myFactorial(myInt-1);
 
	}
    else
        return 1;
}