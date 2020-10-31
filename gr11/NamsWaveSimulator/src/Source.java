import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Source {
	
	boolean tracing = true;//FOR TRACING PROGRAM

	static double time;
	char name;
	boolean on;
	char direction;//TELLS PROGRAM WHAT DIRECTIN THE WAVE WILL MOVE
	double amplitude;//HOW BIG THE WAVE IS
	double frequency;//CYCLES PER SECOND
	double period;//TIME FOR COMPLETE CYCLE
	double phaseShift;//HOW MUCH THE WAVE IS DELAYED
	double progress;//TELLS PROGRAM HOW FAR INTO A CYCLE IS THE WAVE
	
	SourceSetter bob;//SETTER OF THE WAVE INSTANCE VARIABLES
	
	//CONSTRUCTOR
	Source(char n){
		//SETTING VALUES
		name = n;
		bob = new SourceSetter();
	}//END CONSTRUCTOR
	
	//GET METHOD FOR SOURCESETTER
	public SourceSetter getSetter(){
		return bob;
	}//END getSetter()
	
	//GET METHOD FOR DIRECTION
	public char getDirection(){
		return direction;
	}//END getDirection()
	
	//SET METHOD FOR AMPLITUDE
	public boolean setAmplitude(double a){
		if(a > 0 && a < 100){
			amplitude = a;
			bob.amplitudeField.setText(amplitude+"pxl");
			return true;
		}
		return false;
	}//END setAmplitude()
	
	//SET METHOD FOR FREQUENCY
	public boolean setFrequency(double f){
		if(f > 0 && f < 100){
			frequency = f;
			bob.frequencyField.setText(frequency+"Hz");
			return true;
		}
		return false;
	}//END setFrequency()
	
	//SET METHOD FOR ON OFF
	public void setOnOff(boolean o){
		on = o;
		if(o)bob.onOffButton.setText("ON");
		else bob.onOffButton.setText("OFF");
	}//END setOnOff()
	
	//METHOD FOR RETURNING NEXT VALUE FOR THE ROPE
	public double getValue(){
		if(on){
			//if(progress > 1.0/frequency)progress -= 1.0/frequency;
			return amplitude*Math.sin(Math.toRadians(frequency*time*360+phaseShift));
		}
		else{
			return 0;
		}
	}//END getValue()
	
	//METHOD FOR TRACING
	public void tracing(String x){
		if(tracing)System.out.println(x);
	}//END tracing()
	
	//INNER CLASS FOR SETTING INSTANCE VARIABLES OF SOURCE
	public class SourceSetter extends JPanel implements MouseListener,KeyListener{
		
		JTextField frequencyField;//TEXTFIELD FOR FREQUENCY
		JTextField amplitudeField;//TEXTFIELD FOR AMPLITUDE
		JTextField phaseShiftField;//TEXTFIELD FOR DIRECTION
		
		JButton onOffButton;//BUTTON FOR TURNING THE WAVE ON OR OFF
		JButton directionButton;//BUTTON FOR CHANGING THE WAVE'S DIRECTION
		
		String num;//FOR STORING INPUTS
		
		//CONSTRUCTOR
		SourceSetter(){
			//SETTING UP TEXTFIELDS FOR PANEL1
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			
			frequencyField = new JTextField(frequency+"Hz");
			amplitudeField = new JTextField(amplitude+"pxl");
			phaseShiftField= new JTextField(phaseShift+""+(char)(176));
			
			phaseShiftField.addKeyListener(this);
			frequencyField.addKeyListener(this);
			amplitudeField.addKeyListener(this);
			
			phaseShiftField.addMouseListener(this);
			frequencyField.addMouseListener(this);
			amplitudeField.addMouseListener(this);
			
			JLabel label1 = new JLabel(" phase shift ");
			JLabel label2 = new JLabel(" frequency ");
			JLabel label3 = new JLabel(" amplitude ");
			
			panel1.setLayout(new GridLayout(3,2));
			
			panel1.add(label1);
			panel1.add(phaseShiftField);
			panel1.add(label2);
			panel1.add(frequencyField);
			panel1.add(label3);
			panel1.add(amplitudeField);
			
			//SETTING BUTTONS FOR PANEL2
			onOffButton = new JButton();
			directionButton = new JButton();
			
			if(on) onOffButton.setText("ON");
			else onOffButton.setText("OFF");
			
			if(direction == 'L')directionButton.setText("<<<");
			else directionButton.setText(">>>");
			
			
			onOffButton.addMouseListener(this);
			directionButton.addMouseListener(this);
			
			panel2.setLayout(new GridLayout(2,1));
			panel2.add(onOffButton);
			panel2.add(directionButton);
			
			//SWITCHES PANELS AROUND FOR EVEN LOOK, DEPENDING ON WHERE IT'S LOCATED
			this.add(panel1);
			this.add(panel2);
			this.setBackground(Color.black);
		}

		//5 MOUSE LISTENER METHODS
		public void mouseClicked(MouseEvent e) {
			//SWITCHING THE WAVE ON OR OFF
			if(e.getSource() == onOffButton){
				if(on == true){
					on = false;//TURN IT OFF!
					onOffButton.setText("OFF");
				}
				else{
					on = true;//TURN IT ON!
					onOffButton.setText("ON");
				}
				
			}
			//SWITCHING DIRECTIONS
			if(e.getSource() == directionButton){
				if(direction == 'L'){
					direction = 'R';//CHANGE IT TO RIGHT
					directionButton.setText(">>>");
				}
				else{
					direction = 'L';//TURN IT ON!
					directionButton.setText("<<<");
				}
			}
			
			//SELLECTING ALL TEXT ON CLICK
			if(e.getSource() == frequencyField){
					frequencyField.selectAll();
			}
			
			//SELLECTING ALL TEXT ON CLICK
			if(e.getSource() == amplitudeField){
				amplitudeField.selectAll();
			}
			
			//SELLECTING ALL TEXT ON CLICK
			if(e.getSource() == phaseShiftField){
				phaseShiftField.selectAll();
			}
		}

		//MOUSE LISTENER METHODS
		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void keyPressed(KeyEvent e) {
		}

		//KEY LISTENER METHODS
		public void keyReleased(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
			//IF USER HITS ENTER
			if(e.getKeyChar() == 10){
				//GETTING INPUT
				if(e.getSource() == frequencyField){
					num = frequencyField.getText();
					
					try{//SETTING FREQUENCY
							frequency = Double.parseDouble(num);
							frequencyField.setText(frequency+"Hz");
							frequencyField.selectAll();
							
							period = 1/frequency;
							
							tracing("period "+period);
							tracing("progress "+progress);
							
					}catch(NumberFormatException ev){
						frequencyField.setText("ERROR");
						frequencyField.selectAll();
						tracing("can't parse for frequency");
					}
				}
				
				
				//GETTING INPUT
				if(e.getSource() == amplitudeField){
					num = amplitudeField.getText();
					
					try{//SETTING AMPLITUDE
						amplitude = Double.parseDouble(num);
						amplitudeField.setText(amplitude+"pxl");
						amplitudeField.selectAll();
					}catch(NumberFormatException ev){
						amplitudeField.setText("ERROR");
						amplitudeField.selectAll();
						tracing("can't parse for amplitude");
					}
				}
				
				//GETTING INPUT
				if(e.getSource() == phaseShiftField){
					num = phaseShiftField.getText();
					
					try{//SETTING PHASE SHIFT
						phaseShift = Double.parseDouble(num);
						phaseShiftField.setText(phaseShift+""+(char)(179));
						phaseShiftField.selectAll();
					}catch(NumberFormatException ev){
						phaseShiftField.setText("ERROR");
						phaseShiftField.selectAll();
						tracing("can't parse for phase shift");
					}
				}
			}
		}
	}
	
}//END SOURCE CLASS
