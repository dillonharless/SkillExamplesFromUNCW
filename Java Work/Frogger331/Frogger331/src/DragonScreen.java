
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 * 
 * Builds a visual screen, holds most of gameplay mechanics
 *
 */
public class DragonScreen extends JPanel implements KeyListener 
{
	//screen dimensions, boundaries and dividers
	public static int screenWidth = 720;
	public static int screenHeight = 782;	
	
	private static int finishLine = 45;
	private static int startingLine = 655;
	private static int leftBound = 14;
	private static int rightBound = 636;
	private static int lane = 51;
	private static int column = 52;
	
	private Point startingPoint = new Point(326, 655);
	
	private static int obstacleHeight = 48; 		//obstacleHeight used for every MovingGameObject
	//match widths of each image
	private static int truckWidth = 170;	
	private static int turtleWidth = 157;
	private static int carWidth = 89;
	private static int logWidth = 176;
	private static int dragonWidth = 54;
	
	//all necessary images
	public static ImageIcon bgImg = new ImageIcon ("Frogger Background2.png");
	public static ImageIcon carImg = new ImageIcon ("car.png");
	public static ImageIcon car2Img = new ImageIcon ("car2.png");
	public static ImageIcon sleighImg = new ImageIcon ("santa.png");
	public static ImageIcon truckImg = new ImageIcon ("truck.png");
	public static ImageIcon truck2Img = new ImageIcon ("truck2.png");
	public static ImageIcon truck3Img = new ImageIcon ("truck3.png");
	public static ImageIcon dragImg = new ImageIcon ("dragon.png");
	public static ImageIcon logImg = new ImageIcon ("log.png");
	public static ImageIcon dragonImg = new ImageIcon ("dragon.png");
	public static ImageIcon blankImg = new ImageIcon("blank.png");
	
	//bug and skull will be implemented later
	public static ImageIcon bugImg = new ImageIcon ("bug.png");
	public static ImageIcon skullImg = new ImageIcon("skullcrossbones.png");
	
	//images for the timer bar
	public static ImageIcon tb0 = new ImageIcon ("Timebar0%.png");
	public static ImageIcon tb1 = new ImageIcon ("Timebar10%.png");
	public static ImageIcon tb2 = new ImageIcon ("Timebar20%.png");
	public static ImageIcon tb3 = new ImageIcon ("Timebar30%.png");
	public static ImageIcon tb4 = new ImageIcon ("Timebar40%.png");
	public static ImageIcon tb5 = new ImageIcon ("Timebar50%.png");
	public static ImageIcon tb6 = new ImageIcon ("Timebar60%.png");
	public static ImageIcon tb7 = new ImageIcon ("Timebar70%.png");
	public static ImageIcon tb8 = new ImageIcon ("Timebar80%.png");
	public static ImageIcon tb9 = new ImageIcon ("Timebar90%.png");
	
	public static ImageIcon curtime = new ImageIcon(); //will be reset to each timer bar image
	
	//number of lives
	public static ImageIcon heart1 = new ImageIcon ("1heart.png");
	public static ImageIcon heart2 = new ImageIcon ("2heart.png");
	public static ImageIcon heart3 = new ImageIcon ("3heart.png");
	public static ImageIcon lose = new ImageIcon ("lose.png"); //ending image
	public static ImageIcon win = new ImageIcon ("win.png");
	
	protected Player player;		//initialize player object to track score and lives
	private int furthestlane = 604;				//tracks the farthest the dragon has reached for scorekeeping
	
	//checks whether dragon has landed on a log/turtle and is therefore safe
	public boolean dragonOnLog = false;
	public boolean dragonOnTurtle = false;
	
	//same dragon gets used throughout the program
	public Dragon playerdrag = new Dragon(startingPoint, new
				Rectangle(dragonWidth, obstacleHeight), dragImg.getImage());
	
	private ArrayList<GameObject> gameObject;
	private javax.swing.Timer timer;

	/**
	 * The screen has the original Frogger background. 
	 * Calls addDragonssandObstacles
	 * Sets KeyListener  
	 * The timer begins.
	 */
	public DragonScreen() 
	{
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		gameObject = new ArrayList<GameObject>();
		addDragonandObstacles();
		player = new Player();
		this.addKeyListener(this);
		//set new timer and start
		timer = new javax.swing.Timer(30, new TimerListener());
		timer.start();
	}
	
	/**
	 * This method creates a Dragon and several Obstacles 
	 * Adds them to the screen
	 *   
	 */
	public void addDragonandObstacles() {
		
			gameObject.add(0,playerdrag); //add dragon we already created to index 0

			Car car = new Car(new Point(0, finishLine+lane*8), new Rectangle(carWidth, obstacleHeight), carImg.getImage());
			gameObject.add(car);
			
			Truck truck = new Truck(new Point(screenWidth, finishLine+lane*7), new Rectangle(
					truckWidth, obstacleHeight), truckImg.getImage());
			gameObject.add(truck);
			
			Car car2 = new Car(new Point(column*6, finishLine+lane*8), new Rectangle(
					carWidth, obstacleHeight), car2Img.getImage());
			gameObject.add(car2);
			
			Truck truck2 = new Truck(new Point(screenWidth-column*4, finishLine+lane*7), new Rectangle(
					truckWidth, obstacleHeight), truck2Img.getImage());
			gameObject.add(truck2);
			
			Car car3 = new Car(new Point(column, finishLine+lane*10), new Rectangle(
					carWidth, obstacleHeight), car2Img.getImage());
			gameObject.add(car3);
			
			Car santa = new Car(new Point(0, finishLine+lane*9), new Rectangle(
					obstacleHeight, obstacleHeight), sleighImg.getImage());
			gameObject.add(santa);

			Truck truck3 = new Truck(new Point(screenWidth-column*3, finishLine+lane*11), new Rectangle(
					truckWidth, obstacleHeight),truck3Img.getImage());
			gameObject.add(truck3);
			
			Log log = new Log(new Point(0, finishLine+lane), new Rectangle(
					logWidth, obstacleHeight), logImg.getImage());
			gameObject.add(log);
				
			Turtle turtle = new Turtle(new Point(screenWidth, finishLine+lane*2), new Rectangle(
					turtleWidth, obstacleHeight), dragonImg.getImage());
			gameObject.add(turtle);
			
			Car santa1 = new Car(new Point(column*6, finishLine+lane*9), new Rectangle(
					obstacleHeight, obstacleHeight), sleighImg.getImage());
			gameObject.add(santa1);
			
			Turtle turtle1 = new Turtle(new Point(screenWidth+column*12, finishLine+lane*4), new Rectangle(
					turtleWidth, obstacleHeight), dragonImg.getImage());
			gameObject.add(turtle1);
			
			Log log1 = new Log(new Point(column*6, finishLine+lane), new Rectangle(
					logWidth, obstacleHeight), logImg.getImage());
			gameObject.add(log1);
			
			Turtle turtle2 = new Turtle(new Point(screenWidth+column*3, finishLine+lane*4), new Rectangle(
					turtleWidth, obstacleHeight), dragonImg.getImage());
			gameObject.add(turtle2);
			
			Log log3 = new Log(new Point(screenWidth-column*2, finishLine+lane*3), new Rectangle(
					logWidth+40, obstacleHeight), logImg.getImage());
			gameObject.add(log3);
			
			Turtle turtle3 = new Turtle(new Point(screenWidth+column*5, finishLine+lane*2), new Rectangle(
					turtleWidth, obstacleHeight), dragonImg.getImage());
			gameObject.add(15, turtle3);

			Log log4 = new Log(new Point(screenWidth, finishLine+lane*5), new Rectangle(
					logWidth+20, obstacleHeight), logImg.getImage());
			gameObject.add(log4);
			
			Turtle turtle4 = new Turtle(new Point(screenWidth+column*8, finishLine+lane*4), new Rectangle(
					turtleWidth, obstacleHeight), dragonImg.getImage());
			gameObject.add(turtle4);
			
			Log log5 = new Log(new Point(screenWidth+column*8, finishLine+lane*5), new Rectangle(
					logWidth-20, obstacleHeight), logImg.getImage());
			gameObject.add(log5);
			
			}
		/**
		 * Method to display a skull image, set dragon location to starting point, and decrement number of lives.
		 * @param m a Moving Game Object that can die (in this case, the main dragon)
		 */
	public void die(MovingGameObject m)
	{
		Death death = new Death(
				playerdrag.getLocation(),
				playerdrag.getSize(),
				skullImg.getImage(), 0);
		gameObject.add(death);
		m.setLocation(startingPoint);
		m.setAngle(0);
		player.decLives();	//decrement number of lives
		if (player.getLives() == 0)
		{
			timer.stop();
			setTimer(timer);
		}
	}
	
	/**
	 * override paintComponent to draw background image and objects
	 */
	public void paintComponent(Graphics g) 
	{

		super.paintComponent(g);
		
		//draw background image
		g.drawImage(bgImg.getImage(), 0, 0, screenWidth, screenHeight, null);
		
		//draw score as a string
		Font f = new Font("Dialog", Font.BOLD, 27);
		g.setColor(Color.WHITE);
		g.setFont(f);
		g.drawString(Integer.toString(player.getPoints()), 150, 766);
		
		//draw timer progress bar
		g.drawImage(curtime.getImage(), 389, 745, 230, 28, null);
		
		if(player.getLives() == 3)
		{
			g.drawImage(heart3.getImage(), 250, 745, 80, 20, null);
		}
		if(player.getLives() == 2)
		{
			g.drawImage(heart2.getImage(), 250, 745, 80, 20, null);
		}
		if(player.getLives() == 1)
		{
			g.drawImage(heart1.getImage(), 250, 745, 80, 20, null);
		}
		
		//draw other game objects
		for (GameObject obj : gameObject) 
		  {
				obj.draw(g);
		  }
		
		//if the dragon jumps on the turtle, it moves along with the turtle
		if(dragonOnTurtle == true)
		{
			playerdrag.setLocation(new Point(playerdrag.getLocation().x-6, playerdrag.getLocation().y));
			playerdrag.draw(g);
		}
		//if the dragon jumps on an log, it moves with the log
		if(dragonOnLog == true)
		{
			playerdrag.setLocation(new Point(playerdrag.getLocation().x+3, playerdrag.getLocation().y));
			playerdrag.draw(g);
		}
		
		//when lives get to 0, game ends
		if (player.getLives() == 0)
		{
			g.drawImage(lose.getImage(), 0, 0, screenWidth, screenHeight, null);
			g.drawString("Score = "+Integer.toString(player.getPoints()), 295, 470);
		}
		if (curtime.getImage() == tb0.getImage())
		{
			g.drawImage(lose.getImage(), 0, 0, screenWidth, screenHeight, null);
			g.drawString("Out of time! Score = "+Integer.toString(player.getPoints()), 200, 470);
		}
		if (playerdrag.getLocation().y-5 <= finishLine)
		{
			g.drawImage(win.getImage(), 0, 0, screenWidth, screenHeight, null);
			g.drawString("Score = "+Integer.toString(player.getPoints()), 295, 470);
		}
		
	}
	
	/**
	 * @return the timer
	 */
	public javax.swing.Timer getTimer() 
	{
		return timer;
	}

	/**
	 * @param timer the timer to set
	 */
	public void setTimer(javax.swing.Timer timer) 
	{
		this.timer = timer;
	}
	
	/**
	 * 
	 * holds timer
	 * moves objects
	 * collision testing
	 */
	private class TimerListener implements ActionListener 
	{
		private int deathTimer;
		private int timecount = 0;
		public void actionPerformed(ActionEvent e) 
		{
			//switch the timer progress bar image
			//move all objects
			//check for collisions
			
			timecount += 1;
			switch( timecount )
			{
				
				case(1):
					curtime.setImage(tb9.getImage());
					break;
				case(60):
					curtime.setImage(tb8.getImage());
					break;
				case(120):
					curtime.setImage(tb7.getImage());
					break;
				case(180):
					curtime.setImage(tb6.getImage());
					break;	
				case(240):
					curtime.setImage(tb5.getImage());
					break;	
				case(300):
					curtime.setImage(tb4.getImage());
					break;
				case(360):
					curtime.setImage(tb3.getImage());
					break;
				case(420):
					curtime.setImage(tb2.getImage());
					break;
				case(480):
					curtime.setImage(tb1.getImage());
					break;
				case(530):
					curtime.setImage(tb0.getImage());
					break;
			}

			
			for (int i=1; i<gameObject.size(); i++) 
			{
				GameObject obj = gameObject.get(i);		//pull each game object from list except dragon
				if (obj instanceof MovingGameObject) 
				{
					double endX = 0;	//initialize ending x and y values for movement
					double endY = 0;
					
					MovingGameObject movingObj = (MovingGameObject) obj;
					Point location = movingObj.getLocation();
					
					//cars and turtles move faster than logs and trucks
					//direction alternates according to whether index is odd or even
					if (i%2 == 0 && (movingObj instanceof Car  || movingObj instanceof Turtle))
					{
						endX = location.x + 6;
						endY = location.y;
					}
					else if (i%2 == 1 && (movingObj instanceof Car || movingObj instanceof Turtle))
					{
						endX = location.x - 6;
						endY = location.y;
					}
					else if (i%2 == 0 && (movingObj instanceof Truck || movingObj instanceof Log))
					{
						endX = location.x + 3;
						endY = location.y;
					}
					else if (i%2 == 1 && (movingObj instanceof Truck || movingObj instanceof Log)) 
					{
						endX = location.x - 3;
						endY = location.y;
					}
					else
					{
						endX = location.x;
						endY = location.y;
					}

					//calculate change in X and Y and set new vector
					double changeX = (endX - location.x);
					double changeY = (endY - location.y);
					MyVector vector = new MyVector(changeX, changeY);
					movingObj.setVector(vector);
					movingObj.move();	
				}
			}
			
			//this loop checks for collisions in the case that the dragon sits still and gets hit by objects
			for (int i = 0; i < gameObject.size(); i++) 
			{
				GameObject obj = gameObject.get(i);
				if(obj instanceof MovingGameObject)
				{
					//get next object to look at
					MovingGameObject movingObj = (MovingGameObject) obj;
					
					if (movingObj instanceof Death)
					{
						deathTimer++;
						movingObj.setAge(deathTimer);
						if (deathTimer >= movingObj.maxAge)
						{
							gameObject.remove(movingObj);
							deathTimer = 0;
						}
					}
					//see if it collides with any other object
					for (int j = i + 1; j < gameObject.size(); j++) 
					{
						GameObject otherObj = gameObject.get(j);
						if (movingObj == otherObj || otherObj instanceof Death) 
						{
							continue;  //don't compare to self or death image
						}

						if (otherObj instanceof MovingGameObject) 
						{
							MovingGameObject otherMovingObj = (MovingGameObject) otherObj;
							
							if (movingObj.collide(otherMovingObj)) //calls collide method from MovingGameObject
							{
								if (movingObj instanceof Dragon) 	//other objects don't touch, only dragons need to check for collision
								{
									if(otherMovingObj instanceof Log)	//set true that dragon is on a log and safe
									{
										dragonOnLog = true;
										dragonOnTurtle = false;	
										if (movingObj.getLocation().x > screenWidth-column)	//floated off the right edge of the screen
										{
											dragonOnLog = false;
											die(movingObj);
										}
										break;
									}
									if(otherMovingObj instanceof Turtle)	//set true that dragon is on a turtle and safe
									{
										dragonOnTurtle = true;
										dragonOnLog = false;
										if (movingObj.getLocation().x < column)	//floated off the left edge of the screen
										{
											dragonOnTurtle = false;
											die(movingObj);
										}
										break;
									}
									if(otherMovingObj instanceof Car || otherMovingObj instanceof Truck)	//dragon dies
									{
										die(movingObj);
										break;
									}
								}
							}
						}
					}	
				}	
			}
			repaint();
		}
	}
	
	/**
	 * Set controls to move dragon around
	 * Also checks collisions again since this is where the dragon can move
	 */
	public void keyPressed(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();		
	    switch( keyCode ) 
	    { 
	        case KeyEvent.VK_UP:
	            // dragon faces front and moves forward one unit 
	        	if (playerdrag != null) 
	        	{
					Point location = playerdrag.getLocation();
					playerdrag.setAngle(0);
		        	if (location.y > finishLine)	//can't move forward once it gets to the finish line
		        	{
		        		playerdrag.setLocation(new Point(location.x, location.y-lane));
		        	}
	        	}
	            break;
	        case KeyEvent.VK_DOWN:
	            // dragon faces back and moves back one unit 
	        	if (playerdrag != null) 
	        	{
					Point location = playerdrag.getLocation();
					playerdrag.setAngle(180);
		        	if (location.y < startingLine)	//can't go off the bottom of the screen
		        	{
		        		playerdrag.setLocation(new Point(location.x, location.y+lane));
		        	}
	        	}
	        	break;
	        case KeyEvent.VK_LEFT:
	        	//dragon faces left and moves left one unit
	        	if (playerdrag != null) 
	        	{
					Point location = playerdrag.getLocation();
					playerdrag.setAngle(270);
		        	if (playerdrag.getLocation().x > leftBound)	//can't move off the left side of the screen
		        	{
		        		playerdrag.setLocation(new Point(location.x-column, location.y));
		        	}
	        	}
	            
	            break;
	        case KeyEvent.VK_RIGHT :
	        	//dragon faces right and moves right one unit
	        	if (playerdrag != null) 
	        	{
					Point location = playerdrag.getLocation();
					playerdrag.setAngle(90);
		        	if (location.x < rightBound)	//can't move off the right side of the screen
		        	{
		        		playerdrag.setLocation(new Point(location.x+column, location.y));
		        	}
	        	}
	            break; 
	        case KeyEvent.VK_ENTER :	//at the end if you want to play again, this calls main method
	        	StartDragonScreen.main(null);
	        	break;
	     }
	    
	    //reset these booleans
	    dragonOnLog = false;
	    dragonOnTurtle = false;
	    int deathTimer = 0;
	    //re-check for collisions
	    for (int i = 0; i < gameObject.size(); i++) 
		{
			GameObject obj = gameObject.get(i);
			if(obj instanceof MovingGameObject)
			{
				MovingGameObject movingObj = (MovingGameObject) obj;
				if (movingObj instanceof Death)
					{
						deathTimer++;
						movingObj.setAge(deathTimer);
						if (deathTimer >= movingObj.maxAge)
						{
							gameObject.remove(movingObj);
							deathTimer = 0;
						}
					}
				//see if it collides with an objects
				for (int j = i + 1; j < gameObject.size(); j++) 
				{
					GameObject otherObj = gameObject.get(j);
					if (movingObj == otherObj || otherObj instanceof Death) 
					{
						continue;  //don't compare to self
					}

					if (otherObj instanceof MovingGameObject) 
					{
						MovingGameObject otherMovingObj = (MovingGameObject) otherObj;
						
						if (movingObj.collide(otherMovingObj)) 
						{
							if (movingObj instanceof Dragon) 
							{
								if(otherMovingObj instanceof Log)
								{
									dragonOnLog = true;
									dragonOnTurtle = false;
									if (movingObj.getLocation().x > screenWidth-column)	//floated off the right edge of the screen
									{
										dragonOnLog = false;
										die(movingObj);
									}
									break;
								}
								if(otherMovingObj instanceof Turtle)
								{
									dragonOnTurtle = true;
									dragonOnLog = false;
									if (movingObj.getLocation().x < column)	//floated off the left edge of the screen
									{
										dragonOnTurtle = false;
										die(movingObj);
									}
									break;
								}
								if(otherMovingObj instanceof Car || otherMovingObj instanceof Truck)	//dragon dies
								{
									die(movingObj);
									break;
								}
							}
						}
					}
				}	
			}
		}
	    
	    //if dragon is in the water but not on a log or turtle, it dies
	    if (playerdrag.getLocation().y < finishLine+lane*5 && 
	    		playerdrag.getLocation().y >= finishLine && (!dragonOnLog && !dragonOnTurtle))
		{
	    	die(playerdrag);
    	}
		
	    
	    if (playerdrag.getLocation().y != startingLine-lane*7)
	    {
	    	if (playerdrag.getLocation().y < furthestlane)
	    	{
		    	player.addPoints(10);
		    	furthestlane = playerdrag.getLocation().y;
	    	}
	    }
	    repaint();
	}
	    

	
	public void keyReleased(KeyEvent e) 
	{
		// does nothing
	}
	public void keyTyped(KeyEvent e) 
	{
		// does nothing		
	}

	}
