/*
*/
 
import java.awt.*;
import java.util.*;
import javax.swing.*;

class Drawing extends JLabel{
	
	//Class Variables	
	private int xCenter,yCenter;
	private double scale=10;
	private Organism current; // Current organism to be displayed
	private ArrayList<Organism> children=new ArrayList<Organism>();
	
	//Paint Method
	public void paint(Graphics g){
		if(current!=null)
		{	
			int[] d=current.getDimensions();
			//Calculate Centers
			xCenter=getWidth()/2;
			int s=(d[3]-d[1])/2-d[3]; //How much it has to shift to center it vertically
			yCenter=(int)(getHeight()/2+s*scale);
			//System.out.println("min: "+d[1]+" max: "+d[3]);
			sketch(current.getHead(),g);
		}
	}
	
	//Sketch Method - One Biomorph
	public void sketch(Node n,Graphics g2){
		Graphics2D g=(Graphics2D)g2;
		
		if(n==null)return;
		
		Node right=n.getRightChild();
		Node left=n.getLeftChild();
		
		g.setColor(new Color(Color.HSBtoRGB((current.getGenes()[9]*5+n.getDepth()*3)/100f,1.0f,1.0f)));
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
	
	//Set Current Method - To set current Biomorph to be displayed
	public void setCurrent(Organism o){
		if(o!=null){
			current=o;
			repaint();
		}
		else System.out.println("NULL!!!!");
	}
}
