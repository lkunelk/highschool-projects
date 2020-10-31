/*
*/
 
import java.awt.*;
import java.util.*;
import javax.swing.*;

class Drawing extends JLabel{
	
	//Class Variables
	private boolean tracing=false; //for tracing
	private boolean selectModeOn; //so that program knows when to display generation and labels
	private double maxScale; //so that the organism touches the edges of the panel
	private double xCenter,yCenter; //center of the organism
	private double scale=20; //how much to scale the organism
	private Organism current; // Current organism to be displayed
	private ArrayList<Organism> children=new ArrayList<Organism>();
	private Evolution ev;
	
	//Constructor
	Drawing(Evolution e){
		ev = e;
	}
	
	//Paint Method
	public void paint(Graphics g){		
		if(current!=null)//draw only if we have an organism, else dont draw anything
		{	
			calculateCenter();//calculating positions to center the organism on screen
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Cambria",Font.PLAIN,40));
			
			if(ev.selectMode()){//if selection mode is on display which organism is parent and which is child
				if(current.isParent())g.drawString("Parent",getWidth()/6,getHeight()/6);//generation number
				else g.drawString("Child",getWidth()/6,getHeight()/6);
			}
			else{//else display the generation of the current organism
				g.drawString("Gen: "+current.getGeneration(),getWidth()/6,getHeight()/6);//generation number
			}
			
			//draw the organism
			sketch(current.getHead(),g);
		}
	}
	
	//Sketch Method - One Biomorph
	public void sketch(Node n,Graphics g2){
		Graphics2D g=(Graphics2D)g2;
		
		//if there is no node return
		if(n==null)return;
		
		//getting the right and left nodes from the current one
		Node right=n.getRightChild();
		Node left=n.getLeftChild();
		
		g.setColor(new Color(Color.HSBtoRGB((current.getGenes()[9]*10+n.getDepth()*3)/100f,1.0f,1.0f)));
		g.setStroke(new BasicStroke(current.getGenes()[10]));
		
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
		
		sketch(left,g);
		sketch(right,g);
	}
	
	public void calculateCenter(){
		double[] d=current.getDimensions();
		
		if(tracing)System.out.println(d[3]+" - "+d[1]);
		
		if(d[3]-d[1]!=0)maxScale=(double)getHeight()/(d[3]-d[1]);
		if((d[2]-d[0])*maxScale>=getWidth()){
			
			maxScale = getWidth()/(d[2]-d[0]);//if picture is max stretched vertically but still goes out of screen horizontally recalculate maxScale
		System.out.println(":"+maxScale);
		}
		if((d[3]-d[1])*scale>=getHeight() || (d[2]-d[0])*scale>=getWidth())
		{
			scale = maxScale;//make it fit the screen if goes over
		}
		
		xCenter=(int)(getWidth()/2.0);
		double s=(d[3]-d[1])/2.0-d[3]; //How much it has to shift to center it vertically
		yCenter=getHeight()/2.0+s*scale;
	}
	
	public void changeScale(double inc){
		scale+=inc;
		if(scale<1)scale=0;
		if(scale>maxScale)scale = maxScale;
		repaint();
	}
	
	//Set Current Method - To set current Biomorph to be displayed
	public void setCurrent(Organism o){
		if(o!=null){
			current=o;
			repaint();
		}
		else System.out.println("NULL!!!!");
	}
}
