/*
*/
 
import java.awt.*;
import java.util.*;
import javax.swing.*;

class Drawing extends JLabel{
	
	//Class Variables
	private boolean tracing = false;
	private boolean selectModeOn;
	private double maxScale;	
	private double xCenter,yCenter;
	private double scale=20;
	private Organism current; // Current organism to be displayed
	private ArrayList<Organism> children=new ArrayList<Organism>();
	private Evolution ev;
	
	Drawing(Evolution e){
		ev = e;
	}
	
	//Paint Method
	public void paint(Graphics g){		
		if(current!=null)
		{	
			if(tracing){
				g.fillRect(0,0,getWidth(),getHeight());
				g.setColor(Color.black);
				g.drawLine(getWidth()/2,0,getWidth()/2,getHeight());
				g.drawLine(0,getHeight()/2,getWidth(),getHeight()/2);
			}
			
			calculateCenter();
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Serif", Font.BOLD, 40));
			
			if(ev.selectMode()){
				if(current.isParent())g.drawString("Parent",getWidth()/6,getHeight()/6);//generation number
				else g.drawString("Child",getWidth()/6,getHeight()/6);
			}
			else{
				g.drawString("Gen: "+current.getGeneration(),getWidth()/6,getHeight()/6);//generation number
			}
			
			
			sketch(current.getHead(),g);
		}
	}
	
	//Sketch Method - One Biomorph
	public void sketch(Node n,Graphics g2){
		Graphics2D g=(Graphics2D)g2;
		
		if(n==null)return;
		
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
		
		if(d[3]-d[1]!=0)maxScale = (double)getHeight()/(d[3]-d[1]);
		xCenter=(int)(getWidth()/2.0);
		double s=(d[3]-d[1])/2.0-d[3]; //How much it has to shift to center it vertically
		yCenter=getHeight()/2.0+s*scale;
	}
	
	public void changeScale(int inc){
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
