import java.awt.BorderLayout;

import javax.swing.JFrame;

/*
 * Sky Duel game
 * Author: Nam Nguyen
 * version 1.0
 * Date started: 11 april 2015
 * Date ended: april 2015
 * description
 * variation of snake game, where you capture mice by eating them or surrounding them
 */

public class Game {
	
	Keyboard keyboard = new Keyboard();
	JFrame f = new JFrame("Nam's Long Cat");
	
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
}
