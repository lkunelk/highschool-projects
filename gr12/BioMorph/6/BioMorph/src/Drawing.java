/*
 *purpose: to draw the organism on the screen
*/

//importing classes
import java.awt.*;
import java.util.*;
import javax.swing.*;

class Drawing extends JLabel{
	
	//Class Variables
	private boolean tracing=false;
	private boolean selectModeOn; //to know when to display what info
	private int scalingSteps = 20; //how many increments of mouse wheel maximize the drawing
	private double scaleRate; //how much the scale gets bigger by
	private double maxScale; //maximum scale so that the drawing just touches the edges
	private double xCenter,yCenter; //center of the organism
	private double scale=20; //starting scale
	private Organism current; // Current organism to be displayed
	private Evolution ev; //the evolution
	
	//constructor
	Drawing(Evolution e){
		ev = e;
	}//end constructor
	
	//Paint Method
	//Pre-condition: current can't be null
	//Postcondition: draws the organism and information about it
	public void paint(Graphics g){		
		if(current!=null)
		{	
			if(tracing){//for tracing values
				g.fillRect(0,0,getWidth(),getHeight());
				g.setColor(Color.black);
				g.drawLine(getWidth()/2,0,getWidth()/2,getHeight());
				g.drawLine(0,getHeight()/2,getWidth(),getHeight()/2);
			}
			
			calculateCenter();
			
			//setting font and color
			g.setColor(Color.WHITE);
			g.setFont(new Font("Cambria",Font.PLAIN,40));
			
			if(ev.selectMode()){//if user is in selection mode, display the organism is a parent of a child
				if(current.isParent())g.drawString("Parent",getWidth()/6,getHeight()/6);//generation number
				else g.drawString("Child",getWidth()/6,getHeight()/6);
			}
			else{// if not in selection mode display the generation number
				g.drawString("Gen: "+current.getGeneration(),getWidth()/6,getHeight()/6);//generation number
			}
			
			//draw the organism
			sketch(current.getHead(),g);
		}
	}//end paint()
	
	//Sketch Method - purpose: draws One Biomorph
	//Pre-condition: none
	//Postcondition: recursively paints the organism
	public void sketch(Node n,Graphics g2){
		Graphics2D g=(Graphics2D)g2;
		
		//if the node is null return
		if(n==null)return;
		
		//getting left and right nodes
		Node right=n.getRightChild();
		Node left=n.getLeftChild();
		
		//set the colour and stroke
		g.setColor(new Color(Color.HSBtoRGB((current.getGenes()[9]*10+n.getDepth()*3)/100f,1.0f,1.0f)));
		g.setStroke(new BasicStroke(current.getGenes()[10], BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		
		//Left
		if(left!=null){
			g.drawLine((int)( n.getX()*scale+xCenter),(int)(n.getY()*scale+yCenter),(int)( left.getX()*scale+xCenter),(int)( left.getY()*scale+yCenter));
			//Reflect
			g.drawLine((int)(-n.getX()*scale+xCenter),(int)(n.getY()*scale+yCenter),(int)(-left.getX()*scale+xCenter),(int)( left.getY()*scale+yCenter));
		}
		
		//Right
		if(right!=null){
			g.drawLine((int)( n.getX()*scale+xCenter),(int)(n.getY()*scale+yCenter),(int)( right.getX()*scale+xCenter),(int)( right.getY()*scale+yCenter));
			//Reflect
			g.drawLine((int)(-n.getX()*scale+xCenter),(int)(n.getY()*scale+yCenter),(int)(-right.getX()*scale+xCenter),(int)( right.getY()*scale+yCenter));
			
		}
		
		//sketch from left and right
		sketch(left,g);
		sketch(right,g);
	}//end sketch()
	
	//calculateCenter method - purpose: for calculating the center of the drawing
	//Pre-condition: current can't be null
	//Postcondition: sets the xCenter, yCenter, maxScale, scaleRate
	public void calculateCenter(){
		
		//get max and min dimensions
		double[] d=current.getDimensions();
		if(tracing)System.out.println(d[3]+" - "+d[1]);
		
		//calculate max scale
		if(d[3]-d[1]!=0)maxScale= getHeight()/(d[3]-d[1]);//making sure we're not dividing by 0
		else maxScale=getWidth()/(d[2]-d[0]);
		
		//if picture is max stretched vertically but still goes out of screen horizontally recalculate maxScale	
		if((d[2]-d[0])*maxScale>=getWidth()){
			maxScale = getWidth()/(d[2]-d[0]);
		}
		
		//make drawing fit the screen if it goes over the edges
		if((d[3]-d[1])*scale>=getHeight() || (d[2]-d[0])*scale>=getWidth()){
			scale = maxScale;
		}
		
		//calculate the scale Rate
		scaleRate = maxScale/scalingSteps;
		
		//calculating center of the Drawing
		xCenter=(int)(getWidth()/2.0);
		double s=(d[3]-d[1])/2.0-d[3]; //How much it has to shift to center it vertically
		yCenter=getHeight()/2.0+s*scale;
	}//end calculateCenter()
	
	//changeScale mehod - purpose: for changing scale
	//Pre-condition: inc should have abs value of 1
	//Postcondition: changes scale of drawing according to scaleRate
	public void changeScale(int inc){
		scale+=inc*scaleRate;
		if(scale<=0)scale=0;
		if(scale>maxScale)scale = maxScale;
		repaint();
	}//end changeScale()
	
	//Set Current Method - To set current Biomorph to be displayed
	//Pre-condition: organism object can't be null
	//Postcondition: sets the current to the new organism and paints it on screen
	public void setCurrent(Organism o){
		if(o!=null){
			current=o;
			repaint();
		}
		else System.out.println("NULL!!!!");
	}
}//end class
