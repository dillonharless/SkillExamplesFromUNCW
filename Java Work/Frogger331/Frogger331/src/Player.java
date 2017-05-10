 /**
 *
 * Keeps track of score and number of lives
 */
public class Player 
{
	private int number;
	private int lives;
	private int points;
	
	
	/**
	 * FrogNumber would be implemented if we had to move multiple frogs across the screen
	 * @return frogNumber -- The current frog number that the player is controlling
	 */
	public Player()
	{
		this.number = 5;
		this.lives = 3;
	}
	
	public int getNumber() 
	{ 
		return number;
	}
	
	/**
	 * Method for resetting the Frog number First frog used will be frog number 5
	 * The count is decremented from there 
	 */
	public void resetNumber() 
	{
		this.number = 5;
	}
	
	/**
	 * Method for decreasing the number of frogs by 1
	 */
	public void decNumber()
	{
		this.number -= 1;
	}
	
	
	/**
	 * Method for getting the number of lives the current frog has
	 * @return frogLives
	 */
	public int getLives() 
	{
		return lives;
	}
	
	/**
	 * Decrease the number of lives left by one
	 */
	public void decLives()
	{
		lives -= 1;
	}
	
	/**
	 * Method for resetting the frogs lives to 3
	 * 
	 */
	public void resetLives() 
	{
		this.lives = 3;
	}
	
	
	/**
	 * Method for getting the number of points 
	 * @return points
	 */
	public int getPoints() 
	{
		return points;
	}
	
	/**
	 * method for resetting the players points to 0
	 * 
	 */
	public void resetPoints() 
	{
		this.points = 0;
	}
	
	/**
	 * Method for adding points to the players current points
	 * @param addPoints -- The number of points to add to the players current points
	 */
	public void addPoints(int addPoints)
	{
		this.points += addPoints;
	}
	
}
