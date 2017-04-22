c Author: Dillon Harless
c February 7th, 2017
c Estimation of pi using Monte Carlo method

      program monte_carlo
	

	  integer iter, i
	  real x,y,ins,total
	  double precision estPi,actPi,error

	  actPi = 3.1415926535
	  x = rand(1)
	  ins = 0
	  iter = 1000000

c if point (x,y) is within circle, increment ins.
c ins keeps track of points inside the circle. 
c ins/total iterations gives an estimation of one-fourth pi.
		
      do 20 i = 1, iter
	    x = rand(0)
        y = rand(0)
	    if ((x**(2) + y**(2))**(.5) -1) 10,10,20
 10	    ins = ins + 1
 20	  continue

c must multiply by 4 to get pi
	  total = dble(iter)
	  estPi = (ins/total)*4
	  error = (estPi-actPi)/actPi
	  write (*,*)'Total points in circle:',ins
	  write (*,*)'Total iterations:',iter
      write (*,*)'Estimation of Pi:',estPi
	  write (*,*)'Actual Pi: ',actPi
	  write (*,*)'Error: ',error

	  pause
      stop
	  end

