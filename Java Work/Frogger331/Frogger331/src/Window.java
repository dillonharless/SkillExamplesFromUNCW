import javax.swing.JFrame;


/**
 
 * Window class to hold all game components
 *
 **/

@SuppressWarnings("serial")
public class Window extends JFrame 
{

	/**
	 * Window constructor
	 * Calls and adds a frogScreen
	 **/
	public Window() 
	{
		setTitle("Dragon Adventures");
		DragonScreen dragonScreen = new DragonScreen();
		add(dragonScreen);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dragonScreen.setFocusable(true);
		dragonScreen.requestFocusInWindow();
		pack();
		setLocationRelativeTo(null);		//center the window on the desktop
		
		setVisible(true);
	}
/**
 * Create the window.  
 * @param args Ignored.
 */
public static void main(String[] args) {
	Window window = new Window();

}


}