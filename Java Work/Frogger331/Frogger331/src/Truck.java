
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * A Truck is a  object that moves in a horizontal line.  
 * If a truck collides with the frog, it kills the frog.
 * A player can avoid the truck by moving the frog.
 * When the player moves to the next lane and avoids a 
 * truck, the player will receive 10 points. 
 *
 */
public class Truck extends MovingGameObject 
{

	/**
	 * Create an Truck at a particular place, with a 
	 * particular size, a particular point value, and an image.
	 * @param p The location.
	 * @param s The size (width and height)
	 * @param i The image
	 */	
	public Truck(Point p, Rectangle s, Image i) 
	{
		super(p, s, i, 0);
	}

	
}