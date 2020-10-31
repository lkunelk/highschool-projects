import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	private boolean tracing = true;//for tracing the program
	
	//this array stores all keys that are pressed
	private boolean[] keysPressed = new boolean[200];
	
	/*
	 * method for getting x position
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - returns the keysPressed array
	 */
	public boolean[] getKeys(){
		return keysPressed;
	}//end getKeys()
	
	//KeyListener methods
	public void keyPressed(KeyEvent e) {
		if(tracing)System.out.println(e.getKeyCode());
		
		//sets values in array to  true if the corresponding keys are pressed
		keysPressed[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		//sets values in array to back to false if the corresponding keys are released
		keysPressed[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}

	/* method for printing information about this object
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - prints information about this object to the console
	 */
	public String toString(){
		return	"nothing useful to print";
		
	}//end toString()
}
