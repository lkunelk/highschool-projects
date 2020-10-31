import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.util.ArrayList;

public class WaveSimulator implements MouseListener{
	
	boolean tracing = true;//FOR TRACING PROGRAM
	int slowMo = 1;//FOR SLOW MOTION
	boolean pause = false;//FOR PAUSING WAVE
	double time;//PERIOD OF REPAINTING THE WAVE
	
	JFrame program;//MAIN FRAME
	Rope string;//THE PANEL THAT DISPLAYS WAVE
	ArrayList<Source> sources;//LIST OF SOURCES FOR string
	
	//MAIN METHOD
	public static void main(String[] args) {
		new WaveSimulator();
	}

	//CONSTRUCTOR
	WaveSimulator(){
		program = new JFrame("Wave Simulator 2014");
		setUp();
	}
	
	//METHOD FOR SETTING UP FRAME AND ITS OBJECTS
	public void setUp(){
		
		JPanel bottomPanel = new JPanel();//SOUTH PANEL ON THE FRAME
		JPanel wrapPanel = new JPanel();//FOR CREATING A BORDER AROUND THE SOURCE SETTERS
		
		//CREATING THE string PANEL
		string = new Rope(600, 400, 1 , 0);
		string.addMouseListener(this);
		
		//GETTING SOURCES FROM THE string
		sources = string.getSources();
		
		//ADDING SOURCE SETTERS TO THE PANEL
		for(int a = 0; a < sources.size(); a++)
		wrapPanel.add(sources.get(a).getSetter());
		
		//ADDING WRAP PANEL TO THE SOUTH PANEL
		bottomPanel.add(wrapPanel);
		
		//SETTING COLOURS
		wrapPanel.setBackground(new Color(17,17,140));
		bottomPanel.setBackground(Color.black);
		
		//ADDING ONLY THE string PANEL TO THE FRAME FOR THE TITLE AND SETTING THE FRAME
		program.getContentPane().add(BorderLayout.CENTER, string);
		program.setSize(1000,450);
		program.setLocationRelativeTo(null);
		program.setVisible(true);
		program.setResizable(true);
		
		//ADDING LISTENER FOR WHEN THE PROGRAM IS CLOSED, DISPLAYS THANK YOU MESSAGE WHEN CLOSED
		program.addWindowListener
        (new WindowAdapter()
          {
            public void windowClosing(WindowEvent e)
            {
            	//JOptionPane.showConfirmDialog(null, "Thanks for using my program, hope you found it interesting \n        if you have any comments you can contact me at:\n                              nam_nguyen@JMail.java", "Thank You!", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
            	System.exit(0);
            }
          }
        );
		
		//SETTING FIRST SOURCE'S VARIABLES
		sources.get(0).setAmplitude(60);
		sources.get(0).setFrequency(2);
		sources.get(0).setOnOff(true);
		
		tracing("speed "+1000/string.getSpeed()) ;
		
		//WAITING UNTIL USER CLICKS TO PROCEED
		while(string.getStyle() == 0){
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
			}
		}
		
		//ADDING BOTTOM PANEL
		program.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
		program.setVisible(true);
		
		//ASKING USER IF HE/SHE WANTS TO READ ISTRUCTIONS
		int choice = JOptionPane.showConfirmDialog(null, "Would you like to see instructions?", "Instructions", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(choice == 0){
			displayInstructions();
		}
		
		//CALCULATING PERIOD BASED ON SPEED SET IN STRING
		time = 1000.0/string.getSpeed()*string.getPrecision();
		tracing("time: "+time+", slo mo:"+slowMo);
		
		//DISPLAYING THE string
		while(true){
			try{
				
				Thread.sleep((int)time*slowMo);
				if(!pause){
					Source.time += time/1000;
					string.movePoints();
					program.repaint();
				}
				
			}catch(InterruptedException e){
				System.out.print("problem sleeping");
			}
		}
	}//END setUp()
	
	//METHOD FOR DISPLAYING INSTRUCTIONS
	public void displayInstructions(){
		//CREATING NEW FRAME
		JFrame instructionFrame = new JFrame("Instructions");
		
		//CREATING TEXT AREA
		JTextArea text = new JTextArea("\n"
				+ "\n    WELCOME TO WAVE SIMULATOR 2014!!!"
				+ "\n"
				+ "\n   This application allows you to experiment with waves on a string"
				+ "\n          You can change 3 variables:"
				+ "\n           - frequency"
				+ "\n           - amplitude"
				+ "\n           - phase shift"
				+ "\n"
				+ "\n   Simply enter a number into the chosen field"
				+ "\n           and see what happens!"
				+ "\n"
				+ "\n   Keep in mind that:"
				+ "\n           - you have to enter the values without its units"
				+ "\n           - You are allowed to input decimals."
				+ "\n           - There is no size limit for the numbers you input "
				+ "\n             but the program can display as much as the pixel spacing allows for"
				+ "\n"
				+ "\n   You can also switch directions or turn the source on or off."
				+ "\n   Also, By clicking on the wave you can put it in SLOW MOTION or PAUSE it!"
				+ "\n"
				+ "\n   There are two sources so that you can see"
				+ "\n           how the two waves interact."
				+ "\n"
				+ "\n   With all of this in mind, you are ready to experiment with Waves!"
				+ "\n           HAVE FUN!!!");
		
		text.setEditable(false);//SO THAT USER CAN'T CHANGE INSTRUCTIONS
		
		//SETTING THE FRAME
		instructionFrame.getContentPane().add(BorderLayout.CENTER,text);
		instructionFrame.setSize(430,500);
		instructionFrame.setResizable(false);
		instructionFrame.setVisible(true);
	}//END displayInstructions()
	
	//METHOD FOR TRACING
	public void tracing(String x){
		if(tracing)System.out.println(x);
	}//END tracing()
	
	//MOUSE LISTENER METHOD
	public void mousePressed(MouseEvent e){
		if(e.getSource() == string){
			if(string.getStyle() == 0){//SWITCHING FROM TITLE TO PROGRAM
				string.setStyle(1);
			}
			else if(slowMo == 1){//IF NOT IN SLOW MOTION
				if(pause){
					pause = false;
				}
				else{
					slowMo = (int)(20.0/time);//so that the frequency is always every 20ms
				}
			}
			else{//IF IN SLOW MOTION
				slowMo = 1;//SET IT BACK TO NORMAL
				pause = true;
			}
		}
	}//END mousePressed() 
	
	//MOUSE LISTENER METHOD
	public void mouseReleased(MouseEvent e){
	}//END mouseReleased()
	
	//MOUSE LISTENER METHOD
	public void mouseEntered(MouseEvent e){
	}//END mouseEntered()
	
	//MOUSE LISTENER METHOD
	public void mouseExited(MouseEvent e){	
	}//END maouseExited()
	
	//MOUSE LISTENER METHOD
	public void mouseClicked(MouseEvent e){		
	}//END mouseClicked()
}//END CLASS
