#Author: Dillon Harless
#Monday February 20th, 2017

	
#This program contains 3 packages: Point, LineSegment and main.
#Point creates points with two coordinates, x and y.
#LineSegment creates a line segment using two Points.
#main creates an array containing pairs of line segments, and checks to see if they intersect by 
	#by first seeing if the segments would intersect if they were unending lines,
	#and then checking to see if the point of intersection falls between both segments' boundaries.


package Point;
use strict; #Throws Exceptions
use warnings; #Shows Warnings
use diagnostics; #Shows more warnings that help debug
use Data::Dumper; #Very very helpful; shows the structure of an object, its data, and its references. Used it at one point and deleted it
use feature 'say'; #Print with an implicit new line

my $MAX_X_AND_Y = 20;


# This creates a new point, passing the string Point as the first argument and 
# creating a relationship between an empty hash and the type Point which is held in the scalar class courtesy of shift.  
sub new {
  my $class = shift;
  my $self = {};
  bless $self, $class;
  return $self;
}

#Returns the value to be used in set_x and set_y, allowing each Point to have differing values.
sub getRandom{
	return int(rand($MAX_X_AND_Y));
}

#Calls both set_x and set_y, passing to the functions a random number to be assigned to x and y.
sub random{
	my $self = shift;
	$self->set_x(getRandom());
	$self->set_y(getRandom());
}
 
#Returns the x-value of the point. 
sub get_x {
  my $self = shift;
  return $self->{'x'};
}

#Returns the y-value of the point.
sub get_y {
  my $self = shift;
  return $self->{'y'};
}

#Assigns a value to the key x in the Point. 
sub set_x {
  my $self = shift;
  my $x = shift || getRandom();
  $self->{'x'} = $x;
}

#Assigns a value to the key y in the Point. 
sub set_y {
  my $self = shift;
  my $y = shift;
  $self->{'y'} = $y;
}

#Sets both x and y simultaneously.
sub set_xy{
	my $self = shift;
	my $x = shift;
	my $y = shift;
	$self->{'x'} = $x;
	$self->{'y'} = $y;
}



package LineSegment;
use strict;
use warnings;
use diagnostics;
use Data::Dumper;
use feature 'say';

#Creates a new LineSegment, passing Points as values in a hash.
sub new{
	my $class = shift;
	my $self = {
	A => shift,
	B => shift
	};
	bless $self, $class;
	return $self;
}

#Allows the user to manually set A for lineSegment.
sub setA{
	my $self = shift;
	my $xVal = shift;
	$self->{A}{'x'} = $xVal;
	my $yVal = shift;
	$self->{A}{'x'} = $xVal;	
}

#Allows the user to manually set A for lineSegment.
sub setB{
	my $self = shift;
	my $xVal = shift;
	$self->{B}{'x'} = $xVal;
	my $yVal = shift;
	$self->{B}{'x'} = $xVal;	
}

#Returns a hash which is Point A.
sub getA{
	my $self = shift;
	return $self->{A};
}

#Returns a hash which is Point B.
sub getB{
	my $self = shift;
	return $self->{B};
}



package main;
use strict;
use warnings;
use diagnostics;
use Data::Dumper;
use feature 'say';

say "Welcome!";
say "This program will determine if pairs of line segments intersect.";
say "The maximum range for X and Y in this program have been set to 20.";
print "How many line pairs would you like to process?  ";

my $numberOfPairs = <>;
print "\n";
print "\n";

#This creates an array and passes 40 line segments into it.
my $i = 1; 	 #Incrementer
my @arrayOfSegs; #Will contain LineSegments after processed in following loop
while ($i < $numberOfPairs*2 + 1){
	my $p1 = Point->new();
	$p1->random();
	my $p2 = Point->new();
	$p2->random();
	
	push (@arrayOfSegs, LineSegment->new($p1,$p2));  
	$i++;
}


#For each point in each segment in the array, this prints the coordinates.
my $inc = 1; #Numbers the segments
say "Printing line segments...";
for my $line ( @arrayOfSegs ) {
    print "Segment #", $inc, "\n";
    for my $point ( keys %$line ) {
         say "$point=$line->{$point}{'x'},$line->{$point}{'y'}";
    }
    $inc++;
    say"";
}

#This creates another array, gets the size of @arrayOfSegs,
#and then adds every two line segments from the @arrayOfSegs to @linePairs.

my @linePairs; #Will contain arrays consisting of two lineSegments each.
my $size = @arrayOfSegs;
for ($i=0; $i<$size; $i+=2)
{
    my $line1 = $arrayOfSegs[$i];
    my $line2 = $arrayOfSegs[$i+1];
    push (@linePairs, [$line1,$line2]);
}

#Prints all Pairs, and assigns the coordinates to variables
	#for processing in an interssect method I found online. I thought I had a 
say "Printing pairs of segments...\n";
my @checkIntersect=(0); #Will use to check if lines intersect
foreach my $loop_variable (@linePairs) {
	print "[(",$loop_variable->[0]{A}{'x'},", ";
	print    $loop_variable->[0]{A}{'y'},"),";
	print "(",$loop_variable->[0]{B}{'x'},", ";
	print    $loop_variable->[0]{B}{'y'},") _PAIRS WITH_ ";
	print "(",$loop_variable->[1]{A}{'x'},", ";
	print    $loop_variable->[1]{A}{'y'},"),";
	print "(",$loop_variable->[1]{B}{'x'},", ";
	print    $loop_variable->[1]{B}{'y'},")] ";
	
	my $Ax = $loop_variable->[0]{A}{'x'};
	my $Ay = $loop_variable->[0]{A}{'y'};
	my $Bx = $loop_variable->[0]{B}{'x'};
	my $By = $loop_variable->[0]{B}{'y'};
	my $Cx = $loop_variable->[1]{A}{'x'};
	my $Cy = $loop_variable->[1]{A}{'y'};
	my $Dx = $loop_variable->[1]{B}{'x'};
	my $Dy = $loop_variable->[1]{B}{'y'};
	
	my $d1 = ($Ax - $Bx)*($Ay - $By);
	my $d2 = ($Cx - $Dx)*($Cy - $Dy);
	
	my $line1= $d1 - $d2;
	my $line2= $d2 - $d1; 

	#Finds whether or not there is an intersection
	if ($line1!=0 && $line2 !=0){
	my $_range1 = ( ($By-$Dy)*($Cx-$Dx) - ($Bx-$Dx)*($Cy-$Dy) ) / $line1;   
+ 
        my $_range2 = ( ($Dy-$By)*($Ax-$Bx) - ($Dx-$Bx)*($Ay-$By) ) / $line2;
        
	if($_range1>0 && $_range1<=1 && $_range2>0 && $_range2<=1) {    
		 my $interX= $_range1*$Ax + (1-$_range1)*$Bx;
		 my $interY= $_range1*$Ay + (1-$_range1)*$By;
		 @checkIntersect=($interX, $interY);
	 }

}

#Checks to see if array is empty. It will be empty if there was no intersection.
#If it is not empty, print the value of the intersection stored in @checkIntersect
#It warns me that I am not calling the data here in the best way, but it works for me.
	if (@checkIntersect[0] != 0){
        print "There is an intersection at: (@checkIntersect[0], @checkIntersect[1]) \n\n";
        @checkIntersect = (0); #Must set back to zero or when there is no intersection
			       #this code snippet will still think there is and use
				#use the last values
        
	}
	else{
		print "There is no intersection.\n\n"
	}
}



