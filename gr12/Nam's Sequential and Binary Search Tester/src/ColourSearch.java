/**
 * @(#)ColourSearch.java
 *
 *
 * @author 
 * @version 1.00 2015/1/23
 */
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;

public class ColourSearch extends JFrame{

	//class variables
	int update = 10;//per second
	Display d1, d2;//for displaying the arrays on the screen
	ArrayList<Colour> array;

	//main method
	public static void main(String[] args){
		ColourSearch program = new ColourSearch("Binary vs Linear Colour Search");
		
		
	}//end main()

	//consructor
    public ColourSearch(String s) {
    	super(s);
    	
    	d1 = new Display(array);
    	
    	//add panels
    	add(d1, BorderLayout.CENTER);
    	
    	setSize(400, 600);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
    }//end constructor
    
    //start method for sorting and then updating other classes
    public void start(){
    	//create sort method
    	
    	
    }//end start()
}