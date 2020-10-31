import java.awt.BorderLayout;

import javax.swing.JFrame;

/*
 * Sky Duel game
 * Author: Nam Nguyen
 * version 1.0
 * Date started: 29 september 2014
 * Date ended: 12 november 2014
 * description5
 * this is a 2 player game where each player takes control of a plane
 * players try to destroy other planes to win
 */

public class Game {

	Keyboard keyboard = new Keyboard();
	JFrame f = new JFrame("Sky Duel");
	
	public static void main(String[] args){
		Game g = new Game();
		g.setup();
	}
	
	/* 
	 * method for setting up the game
	 * pre-condition:
	 * - keyboard object has to be created
	 * 
	 * post-condition:
	 * - a level object is created and added to a frame
	 */
	public void setup(){
		
		//creating level
		Level l = new Level(keyboard);
		
		//setting up frame
		f.addKeyListener(keyboard);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(BorderLayout.CENTER, l);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		//starting the level
		l.start();
	}//end setup()
	
	/*
	 * method for printing information about this object
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - prints information about this object to the console
	 */
	public String toString(){
		return "width of frame: "+f.getWidth()
				+"\nheight of frame: "+f.getHeight();
	}//end toString()
}
