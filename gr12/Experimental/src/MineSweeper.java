/**
* @(#)MineSweeper.java
*
* MineSweeper application
* A Copy of the Famous Mineseeper Application
* Instead of numbers using pips.
* @Simon Berest
* @version 1.00 2014/11/28
*/

	import java.io.*; //imports
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	
	class MineSweeper implements MouseListener//Launcher for game
	{
		JFrame frame = new JFrame();
		JLabel screen = new JLabel();
		ImageIcon norm = new ImageIcon("TitleScreen.Png");
		ImageIcon start = new ImageIcon("TitleScreen1.Png");
		ImageIcon ins = new ImageIcon("TitleScreen2.Png");
		ImageIcon options = new ImageIcon("TitleScreen3.Png");
		ImageIcon exit = new ImageIcon("TitleScreen4.Png");
	
	public static void main(String[] args)
	{
		new MineSweeper();
	}
	
	MineSweeper()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Closes game on close of frame
		JPanel pane = new JPanel(new BorderLayout()); //new jpanel in a borderlayout
		pane.add(screen,BorderLayout.CENTER); //adds a grid in the middle
		frame.setContentPane(pane);
		frame.pack();
		frame.setResizable(false); // no resizing
		frame.setSize(778, 714); //sets size of frame, ideal for size of south, west, east, and grid.
		frame.setVisible(true); //frame is visible
		screen.setIcon(norm);
	}
	
	public void mouseClicked(MouseEvent e) // use this method to perform actions when the mouse button is pressed
	{
	}
	
	/**
	*Not used
	*/
	public void mousePressed(MouseEvent e) // use this method to perform actions when the mouse Button is pressed
	{
	}
	
	/**
	*Not used
	*/
	public void mouseReleased(MouseEvent e) // use this method to perform actions when the mouse Button is released
	{
	}
	
	/**
	*Not used
	*/
	public void mouseEntered(MouseEvent e) // use this method to perform actions when the mouse enters a component
	{
	}
	
	/**
	*Not used
	*/
	public void mouseExited(MouseEvent e) // use this method to perform actions when the mouse exits a component
	{
	
	}
	}