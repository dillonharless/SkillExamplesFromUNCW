import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 	Displays a start screen prompt
 * When the user hits Enter, closes start screen and opens a game window
 * Contains main method
 * 
 *
 */
public class StartDragonScreen extends JFrame implements KeyListener 
{    
	   public static int screenWidth = 720;
	   public static int screenHeight = 782;
	   protected static Window dragonWindow = new Window();
	   
	   private JLabel imgLabel;
	   	   
	   public StartDragonScreen()
	   {
		   setSize(screenWidth, screenHeight);
		   setLocationRelativeTo(null);						
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   setTitle("Start");
		   addKeyListener(this);
		   ImageIcon start = new ImageIcon("start.png");
		   imgLabel = new JLabel();
		   imgLabel.setIcon(start);
		   add(imgLabel);
		   
		   setVisible(true);
	   }
	   
	/**
	 * Watches for Enter to be pressed to initialize a game window   
	 */
	public void keyPressed(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
	    switch( keyCode ) 
	    { 
	        case KeyEvent.VK_ENTER:
	        	setVisible(false);
	        	dragonWindow = new Window();
	        break;
	    }
	}
	public void keyReleased(KeyEvent e) 
	{
		//does nothing
	}
	
	public void keyTyped(KeyEvent e) 
	{
		//does nothing
	}
	
	/**
	 * Main method sets current dragon window to invisible and opens a new start screen
	 * @param args ignore
	 */
	public static void main(String[] args) 
	{	
		dragonWindow.setVisible(false);
		StartDragonScreen start = new StartDragonScreen();
	}
}

