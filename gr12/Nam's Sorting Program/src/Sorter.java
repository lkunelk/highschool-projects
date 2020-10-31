/**
 * @(#)Colour Sorter program
 *
 *	this program lets you read in a list of numbers and using Bubble sort, sort them in ascending order
 *	you can also create a list and modify it
 *	using GUI the program shows the sort happen in real time, so you can get a sense of what the Bubble sort looks like
 *
 * @author Nam Nguyen
 * @version 1.00
 * start 2015/1/23
 * end 2015/2/12
 */

//importing classes
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Sorter extends JFrame implements MouseListener{

	//class variables
	private double biggest, smallest = Integer.MAX_VALUE;//stores the biggest and smallest values in the array for deciding what colour each elment gets
	private Display display;//for displaying the arrays on the screen
	private ArrayList<Colour> colourArray = new ArrayList<Colour>();//stores colours
	private ArrayList<Double> array = new ArrayList<Double>();//stores values
	private ArrayList<Integer> steps1 = new ArrayList<Integer>();//stores steps to sort an array
	private ArrayList<Integer> steps2 = new ArrayList<Integer>();//the two arrays store which elements to switch
	
	//sorter
	private BubbleSort sorter;
	
	// Buttons
	private JButton createButton;
	private JButton addButton;
	private JButton removeButton;
	private JButton sortButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton mixupButton;
	private JButton replaceButton;
	
	private boolean update, mix, sort, busy;//for deciding when to update the screen
	
	//main method
	public static void main(String[] args){
		Sorter program = new Sorter("Colour Sorter");
		program.start();
	}//end main()

	//constructor
    public Sorter(String s) {
    	super(s);
    	
    	//setup display and buttons
    	display = new Display(colourArray);
    	JPanel bottomPanel = new JPanel();
    	
    	//creating buttons
    	createButton = new JButton("Create");
    	sortButton = new JButton("Sort");
    	saveButton = new JButton("Save");
    	loadButton = new JButton("Load");
    	mixupButton = new JButton("Mixup");
    	replaceButton = new JButton("Replace");
    	
    	//adding mouse listener to buttons
    	createButton.addMouseListener(this);
    	sortButton.addMouseListener(this);
    	saveButton.addMouseListener(this);
    	loadButton.addMouseListener(this);
    	mixupButton.addMouseListener(this);
    	replaceButton.addMouseListener(this);
    	
    	//adding buttons to panel
    	bottomPanel.add(createButton);
    	bottomPanel.add(sortButton);
    	bottomPanel.add(saveButton);
    	bottomPanel.add(loadButton);
    	bottomPanel.add(mixupButton);
    	bottomPanel.add(replaceButton);
    	
    	//add panels
    	add(bottomPanel, BorderLayout.SOUTH);
    	add(display, BorderLayout.CENTER);
    	
    	setSize(800, 700);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
    }//end constructor
    
    //method for creating colour array
    public void createColourArray(){
    	System.out.println("updating");
    	
    	//resetting the colour array
    	colourArray.removeAll(colourArray);
    	
    	//calculating range
    	double range = biggest - smallest;
    	
    	//for each element in array
    	for(int i = 0; i < array.size(); i++){
    		
    		//get the relative distance of the value in the range
    		float hue = (float)( (array.get(i)-smallest)/range );
    		
    		//add the new colour
    		colourArray.add(new Colour(hue, 1.0f, 1.0f));
    	}
    	
    }//end createColourArray()
    
    //start method for sorting and then updating other classes
    public void start(){
    	//create sort method
    	while(true){
    		
    		pause(10);
    		if(sort){
    			sort();
    			//reset the booleans
    			sort = false;
    			busy = false;
    		}
    		if(update){
    			createColourArray();
    			display.update();
    			//reset the booleans
    			busy = false;
    			update = false;
    		}
    		if(mix){
    			mixup();
    			//reset the booleans
    			busy = false;
    			mix = false;
    		}
    	}
    	
    }//end start()
    
    //method for sorting the array step by step
    public void sort(){
		
    	//create new sorter
    	sorter = new BubbleSort(colourArray);
    	sorter.sort();
    	
    	//getting the instructions to sort the array
    	steps1 = sorter.getElement1();
    	steps2 = sorter.getElement2();
    	
    	//for each step
    	for(int i = 0; i < steps1.size(); i++){
    		
    		int e1 = steps1.get(i);
    		int e2 = steps2.get(i);
    		
    		//switch around the colours
    		Colour c = colourArray.get(e1);
			colourArray.set(e1,colourArray.get(e2));
			colourArray.set(e2, c);
			
			//switch around the numbers
			double t = array.get(e1);
			array.set(e1,array.get(e2));
			array.set(e2, t);
			
			
			display.update();
			pause(10);
    	}
    	
    }//end sort()
    
    //method for randomly mixing elements
    public void mixup(){
    	//creating temporary array
    	double[] ar = new double[array.size()];
		
		for(int i = 0; i < array.size(); i++){
			ar[i] = array.get(i);
		}
		
		//mix up the array
    	for(int i = 0; i < array.size()*2; i++){
    		int i1 = (int)(Math.random()*array.size());
    		int i2 = (int)(Math.random()*array.size());
    		
    		if(i1 == i2){
    			continue;
    		}
    		
    		//switching values around
    		double t = ar[i1];
    		ar[i1] = ar[i2];
    		ar[i2] = t;
    		
    		//switching the colours
    		Colour c = colourArray.get(i1);
    		colourArray.set(i1, colourArray.get(i2));
    		colourArray.set(i2, c);
    		
    		display.update();
    		
    		pause(5);
    	}
    	
    	//set the array to the mixed up array
    	array = new ArrayList<Double>();
    	for(int i = 0; i < ar.length; i++){
    		array.add(ar[i]);
    	}
    }//end mixup()
    
    //mouse listener method
	public void mousePressed(MouseEvent e) {
		//create button was pressed
		if(e.getSource().equals(createButton) && !busy){
			//ask the user for size
			String input = JOptionPane.showInputDialog(this, "How big do you want the list to be? (1-100)", "50");
			
			int size = -1;
			
			try{
				//get the input
				size = Integer.parseInt(input);
			}catch(NumberFormatException ex){
				//if bad input
				JOptionPane.showMessageDialog(this, "Invalid input!");
				return;
			}
			catch(NullPointerException ex){
				//if no input is given
				return;
			}
			
			//size has to be between 1-100
			if(size < 1 || size > 100){
				JOptionPane.showMessageDialog(this, "Invalid size!");
				return;
			}
			
			//reset array
			array.removeAll(array);
			
			//update the smallest and biggest
			smallest = 0;
			biggest = size-1;
			
			//add the elements in decreasing order
			for(int i = size-1; i >= 0; i--){
				array.add((double)i);
				System.out.println(i);
			}
			
			//tell program to update
			update = true;
			busy = true;
		}
		//sort button was pressed------------------------------------------------------------------------------
		else if(e.getSource().equals(sortButton) && !busy){
			System.out.println("sorting!");
			
			//check if array is empty
			if(array.size()==0){
				JOptionPane.showMessageDialog(this, "Can't sort an empty Array!");
			}
			
			//tell program to sort
			sort = true;
			busy = true;
		}
		//save button was pressed------------------------------------------------------------------------------
		else if(e.getSource().equals(saveButton) && !busy){
			System.out.println("saving!");
			
			//if the array is empty
			if(array.size() == 0){
				JOptionPane.showMessageDialog(this, "The array is empty!");
				return;
			}
			
			//prompt user for file name
			String name = JOptionPane.showInputDialog(this, "Which file to save to?", "unsorted.txt");
			PrintWriter pw = null;
			
			try {//create the PrintWriter object and specify the name
				 pw = new PrintWriter(new File(name));
			} catch (FileNotFoundException ex) {
				JOptionPane.showMessageDialog(this, "Invalid name!");
				return;
			}catch(NullPointerException ex){
				return;
			}
			//save the size of the array
			pw.println("size: "+array.size());
			
			//save the values
			for(int i = 0; i < array.size(); i++){
				pw.println(array.get(i));
			}
			
			pw.close();
			
		}
		//load button was pressed------------------------------------------------------------------------------
		else if(e.getSource().equals(loadButton) && !busy){
			System.out.println("loading!");
			
			BufferedReader br = null;
			
			//prompt user for file name
			String name = JOptionPane.showInputDialog(this, "Which file to load?", "unsorted.txt");
			
			try {//create buffered reader
				br = new BufferedReader(new FileReader(name));
			}catch(FileNotFoundException ex){
				JOptionPane.showMessageDialog(this, "File not found!");
				return;
			}
			catch (Exception a) {
				return;
			}
			
			//size of the array
			int size = 0;
			
			//reset array
			array.removeAll(array);
			colourArray.removeAll(colourArray);
			
			try {//read in the size of the array
				String[] input = br.readLine().split(" ");
				size = Integer.parseInt(input[1]);
				
				//reading in the data
				for(int i = 0; i < size; i++){
					
					double number = Double.parseDouble(br.readLine());
					
					array.add(number);
					
					//checking if the new number is the smallest or biggest
					if(number < smallest){
						smallest = number;
					}
					if(number > biggest){
						biggest = number;
					}
				}
				
			} catch (Exception e1) {//if data is bad reset the array and return
				JOptionPane.showMessageDialog(this, "Invalid data!");
				array = new ArrayList<Double>();
				try {//closing reader
					br.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				return;
			}
			
			try {//closing reader
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			//tell program to update
			busy = true;
			update = true;
		}
		//mixup button was pressed------------------------------------------------------------------------------
		else if(e.getSource().equals(mixupButton) && !busy){
			System.out.println("mixing!");
			
			//tell program to mix numbers
			busy = true;
			mix = true;
		}
		//replace button was pressed------------------------------------------------------------------------------
		else if(e.getSource().equals(replaceButton) && !busy){
			System.out.println("replacing!");
			
			//prompt user
			String input = JOptionPane.showInputDialog(this, "Which element to find?", "1");
			double target = -1;
			
			try{
				target = Double.parseDouble(input);
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(this, "Invalid input!");
			}
			catch(NullPointerException ex){
				return;
			}
			
			//target has to be a positive integer
			if(target < 0){
				JOptionPane.showMessageDialog(this, "Your number has to be positive!");
				return;
			}
			
			int index = -1;
			
			///search for the number
			for(int i = 0; i < array.size(); i++){
				if(array.get(i) == target){
					index = i;
				}
			}
			
			//if not found
			if(index == -1){
				JOptionPane.showMessageDialog(this, "Element not found!");
				return;
			}
			
			//get user input
			input = JOptionPane.showInputDialog(this, "Element found at index: "+index+"\nWhat value to replace it with?", "1.0");
			double num = 0;
			
			try{
				num = Double.parseDouble(input);
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(this, "Invalid input!");
			}
			catch(NullPointerException ex){
				return;
			}
			
			//replace the number
			array.set(index, num);
			
			//tell program to update
			busy = true;
			update = true;
		}
	}//end mousePressed()

  //mouse listener method
	public void mouseClicked(MouseEvent arg0) {
	}//end mouseClicked()

	//mouse listener method
	public void mouseEntered(MouseEvent arg0) {
	}//end mouseEntered()

	//mouse listener method
	public void mouseExited(MouseEvent arg0) {
	}//end mouseExited()

	
	//mouse listener method
	public void mouseReleased(MouseEvent arg0) {
	}//end mouseReleased()
	
	//Method for pausing
	private  void pause(int time){
		
		if(time < 0){
			return;
		}
		
		//take initial time
		long last = System.currentTimeMillis();
		
		long now = 0;//for storing the current time
		
		do{//take current time and check it against the initial time
			now = System.currentTimeMillis();
		}//if certain amount of time passes, break out of the loop
		while(now - last < time);
	}//end pause()
}//end class
