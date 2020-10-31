import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Level extends JPanel{
	
	//class variables
	private int cellWidth = 50;
	private int Width=30, Height=20;
	private Keyboard keyboard;//for gettin input from user
	private int updates = 60;//updates per second
	private ImageIcon background = new ImageIcon("bin/floor.png");
	
	private LongCat cat;
	private ArrayList<Mouse> mice = new ArrayList<Mouse>();//holds array of bullets in game
	
	
	//constructor
	Level(Keyboard k){
		keyboard = k;
		
		//setting the size of panel based on the background picture
		setPreferredSize(new Dimension(500, 500));
		
		//setting up planes
		reset();

	}//end constructor
	
	/*
	 * method for calling update() at a constant rate
	 * 
	 * pre-condition: 
	 * -the variable updates must have a positive value
	 * 
	 * post-condition: 
	 * -method update() is called at a rate of updates per second
	 */
	public void start(){
		
		double deltaT = 0;//change in time
		double lastT = System.nanoTime();//getting the current time
		
		//this part has to run forever
		while(true){
			//getting current time
			double now = System.nanoTime();
			
			//adding time that elapsed to delta variable
			deltaT += (now - lastT);
			lastT = now;
			
			//calling update(), when deltaT is bigger than one second(1second = 1 000 000 000nanoseconds)
			//by multiplying the delta by number of updates, say 60, will cause the delta value to reach one second 60 times faster
			//therefore update will be called 60 times a second
			if(deltaT*updates >= 1000000000){
				update();
				deltaT-=1000000000/updates;//resetting delta back to zero
			}
			
		}//end loop
		
	}//end start()
	
	
	/*
	 * method for resetting the game
	 * 
	 * pre-condition:
	 * - nothing
	 * 
	 * post-condition:
	 * - new planes and bullets arrays are created
	 * - new planes are added to the array and their control keys are set
	 */
	private void reset(){
		 //cat = new LongCat(0, 0, 10, this);
		
	}//end reset()
	
	/*
	 * method for updating positions of all objects on the screen
	 * 
	 * pre-condition:
	 * - keyboard can't be null, 2 arrays: planes and bullets can't be null
	 * 
	 * post-condition:
	 * - the update() of each object in the planes and bullets arrays is called
	 * - collision between plane and bullets is checked and appropriate method is called for that
	 * - objects that have been marked dead are removed from the arrays
	 */
	public void update(){
		
		//if enter is pressed then the game is reset
		if(keyboard.getKeys()[KeyEvent.VK_ENTER]){
			reset();
		}
		
		//update snake
		//cat.update();
		
		//update mice
		
		//check for collision
		
		//remove dead mice
		
		//calling paintComponent() to draw objects to screen
		repaint();
		
	}//end update()
	
	/*
	 * method for painting objects to screen
	 * pre-condition: planes, bullets arrays can't be null, 
	 * post-condition: planes and bullets are drawn on screen facing proper directions
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.fillRect(0, 0, 100, 100);
		g2d.drawImage(background.getImage(), 20, 0, null);
		
		//g2d.drawImage(cat.head.i.getImage(), 0, 0, null);
		//draw the planes
		
	}//end paintComponent()
	
	
	
	/*
	 * method for adding mouse to the board
	 * 
	 * pre-condition:
	 * - mouse array can't be null
	 * 
	 * post-condition:
	 * - a new mouse object is added to the mouse array
	 */
	public void addMouse(){
		
	}//end addBullets()
	
	//Get Methods--------------------------------------------------
	
	/*
	 * method for getting updates
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - returns updates of this class
	 */
	public int getUpdates(){
		return updates;
	}//end getUpdates()
	
	//method for getting width of the board
	public int getWidth(){
		return Width;
	}
	
	/*
	 * method for getting keyboard object
	 * 
	 * pre-condition: 
	 * -nothing
	 * 
	 * post-condition: 
	 * - return Keyboard object of this class
	 */
	public Keyboard getKeyboard(){
		return keyboard;
	}//end getKeyboard()
}
