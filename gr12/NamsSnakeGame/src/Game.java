import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/*
 * NamsLongCatGame
 * Author: Nam Nguyen
 * version 1.0
 * Date started: 11 April 2015
 * Date ended: 12 April 2015
 * description
 * this is a variation of the snake game, the food is in form of mice which will randomly move around the screen
 * the cat can capture the mice in 2 ways: by eating them head on, or by trapping them with its long body
 */



public class Game {

	private Keyboard keyboard = new Keyboard();
	private JFrame f = new JFrame("Nam's Long Cat Game");
	
	public static void main(String[] args){
		Game g = new Game();
		g.setup();
	}
	
	//method for setting up the game
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
		
		//ask user
		int choice = JOptionPane.showConfirmDialog(null, "Would you like to see instructions?", "Instructions", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
		if(choice == 0){
			displayInstructions();
		}
		
		//starting the level
		l.start();
	}//end setup()
	
	//METHOD FOR DISPLAYING INSTRUCTIONS
	private void displayInstructions(){
		//CREATING NEW FRAME
		JFrame instructionFrame = new JFrame("Instructions");
		
		//CREATING TEXT AREA
		JTextArea text = new JTextArea("\n"
				+ "\n      WELCOME TO THE LONG CAT GAME!!!"
				+ "\n"
				+ "\n      This is a variation of the snake game"
				+ "\n           but instead of a snake you are a long cat"
				+ "\n             really long..."
				+ "\n           "
				+ "\n     the goal is simple catch as many mice as you can"
				+ "\n            to control the cat use arrow keys"
				+ "\n           you have 2 ways of catching them:"
				+ "\n"
				+ "\n       you can either catch them with your paws givning you 1 point"
				+ "\n        or you can trap them with your long body giving you 2 points"
				+ "\n"
				+ "\n     With all of this in mind, you are ready to play!"
				+ "\n              HAVE FUN!!!");
		
		text.setEditable(false);//so that the user can't change the instructions
		
		//setting the frame
		instructionFrame.getContentPane().add(BorderLayout.CENTER,text);
		instructionFrame.setSize(430,500);
		instructionFrame.setResizable(false);
		instructionFrame.setVisible(true);
	}//END displayInstructions()
}
