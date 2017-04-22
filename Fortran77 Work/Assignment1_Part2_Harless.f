c Author: Dillon Harless
c February 9th, 2017

c Estimation of pi via recursion in Newton's Method
c I think the reason we are not using factorial
c is because its big-O is exponential

	  program newtons_method
	  implicit none
	
	  double precision estPi, actPi, error,
     2  sum, denom, numer
	  integer iters, i
	
	  actPi = 3.1415926535
	  iters = 30
c Fractions change according to newtons method
c and adding them together converges on Pi/2
	
	  numer = iters + 2
	  denom = ((iters+2) * 2) + 1
	  sum = 1 + (numer/denom)
	  numer = numer - 1
	  denom = denom - 2
	  do 10 i = 0, iters
	    sum = 1 + ((numer/denom)*sum)
	    numer = numer - 1 
	    denom = denom - 2	  
 10	  continue

c Must multiply by 2 for pi.
	  estPi = sum*2
	  error = (estPi-actPi)/actPi
	  write (*,*)"Total iterations:",iters
      write (*,*)"Estimated Pi:",estPi
	  write (*,*)"Actual Pi:",actPi
      write (*,*)"My error:",error
	  pause
	  stop
	  end
