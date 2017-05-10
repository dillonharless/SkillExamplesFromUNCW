
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * A Turtle is a  object that moves in a horizontal line and submerges 
 * into the water every 5 seconds.  
 * If it frog reaches to a turtle, the frog will can stay on the turtle
 * before the turtle submerges into the water.
 * When the player moves to the next lane and avoids 
 * the water, the player will receive 10 points.
 *
 */
public class Turtle extends MovingGameObject 
{
	/**
	 * Create a Turtle at a particular place, with a 
	 * particular size, a particular point value, and an image.
	 * @param p The location.
	 * @param s The size (width and height)
	 * @param i The image
	 */	
	public Turtle(Point p, Rectangle s, Image i) 
	{
		super(p, s, i, 0);
	}

	

}