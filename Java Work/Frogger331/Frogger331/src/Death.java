import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;



/**
 * An explosion occurs when two objects collide and at least
 * one is destroyed.
 *
 */
public class Death extends MovingGameObject {

	/**
	 * Create an Explosion at a particular place, with a 
	 * particular size, a particular point value, and an image.
	 * @param location The location.
	 * @param size The size (width and height)
	 * @param pv The point value
	 * @angle angle The angle of the object.  
	 */	
	public Death(Point location, Rectangle size, Image i, double angle) {
		super(location, size, i, angle);
		maxAge = 5;  // image only last 5 time clicks.
	}

}
