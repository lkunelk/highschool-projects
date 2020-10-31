import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;

import javax.swing.JPanel;

import java.util.ArrayList;

public class Rope extends JPanel{

	boolean tracing = true;//FOR TRACING THE PROGRAM
	
	//INSTANCE VARIABLES
	ArrayList<Source> sources = new ArrayList<Source>();
	
	double totalHeight1;
	double totalHeight2;
	
	int midX;
	int midY;
	
	char nextSource = 'A';
	Color color;
	
	int penSize;//THICKNESS OF THE ROPE
	int lineStyle;//STYLE OF HOW THE LINE IS DRAWN
	int precision;//PRECISION OF THE DISPLAYED ROPE, USED FOR REDUCING NUMBER OF CALCULATIONS
	
	int length;//LENGTH OF ROPE IN PIXELS
	int speed;//PIXELS PER SECOND
	
	double[] leftValues;//VALUES GOING LEFT ON THE ROPE
	double[] rightValues;//VALUES GOING RIGHT ON THE ROPE
	
	//CONSTRUCTOR
	Rope(int l, int s, int p, int ln){
		
		//SETTING VALUES
		length = l;
		speed = s;
		precision = p;
		lineStyle = ln;
		
		//DEFAULT SETTINGS
		penSize = 3;
		
		for(int a = 0; a < 3; a++)
		addSource();
		
		leftValues = new double[length/precision+1];
		rightValues = new double[length/precision+1];
		color = new Color(140,200,188);
		
		tracing("length of array "+(length/precision+1));
		tracing("height "+this.getHeight());
		tracing("width "+this.getWidth());
	}//END CONSTRUCTOR
	
	//GETTER METHOD FOR SOURCES
	public ArrayList<Source> getSources(){
		return sources;
	}
	
	public int getStyle(){
		return lineStyle;
	}
	
	//GETTER METHOD FOR SPEED
	public int getSpeed(){
		return speed;
	}//END getSpeed()
	
	//GETTER METHOD FOR PRECISION
	public int getPrecision(){
		return precision;
	}//END getPrecision()
	
	//METHOD FOR SETTING LINE STYLE
	public boolean setStyle(int s){
		if(s < 4 || s > 0){
			lineStyle = s;
		}
		return false;
	}
	//METHOD FOR ADDING NEW SOURCE
	public boolean addSource(){
		if(sources.size() < 4){
			sources.add(new Source(nextSource));
			nextSource++;
			return true;
		}
		return false;
	}//END addSource()
	
	//METHOD FOR MOVING POINTS
	public void movePoints(){
		//MOVING TO THE LEFT
		for(int a = 0; a < length/precision; a++){
			leftValues[a] = leftValues[a+1];
		}
		//MOVING TO THE RIGHT
		for(int a = length/precision; a > 0 ; a--){
			rightValues[a] = rightValues[a-1];
		}
		
		//RESETTING VALUES
		rightValues[0] = 0;
		leftValues[length/precision] = 0;

		//GETTING NEW POINT FROM SOURCES
		for(Source source: sources){
			if(source.getDirection() == 'L'){
				leftValues[length/precision] += source.getValue();
			}
			else{
				rightValues[0] += source.getValue();
			}
		}
	}//END movePoints()
	
	//METHOD FOR DRAWING BASIC ROPE
	public void drawBasicRope(Graphics2D g2){
		
		midX = (this.getWidth()-length)/2;//FOR CENTERING THE WAVE
		midY = (this.getHeight())/2;
		
		//SETTING PEN
		BasicStroke bs = new BasicStroke(penSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g2.setStroke(bs);
		g2.setColor(color);
		
		//DRAWING
		totalHeight2 =rightValues[0] + leftValues[0];
		
		for(int a = 1; a < length/precision+1; a++){
			
			totalHeight1 =rightValues[a] + leftValues[a];
			
			g2.draw(new Line2D.Double(precision*a+midX, totalHeight1+midY, precision*(a-1)+midX, totalHeight2+midY));
			
			totalHeight2 = totalHeight1;
		}
	}//END drawBasicRope()
	
	//METHOD FOR DRAWING DOTS
	public void drawDottedRope(Graphics2D g2){
		
		midX = (this.getWidth()-length)/2;//FOR CENTERING THE WAVE
		midY = (this.getHeight())/2;
		
		//SETTING PEN
		BasicStroke bs = new BasicStroke(penSize+3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g2.setStroke(bs);
		g2.setColor(color);
		
		//DRAWING
		totalHeight2 = rightValues[0] + leftValues[0];
		for(int a = 1; a < length/precision+1; a+=precision*3){
			
			totalHeight1 = rightValues[a] + leftValues[a];
			
			g2.draw(new Line2D.Double(precision*a+midX, totalHeight1+midY, precision*(a)+midX, totalHeight1+midY));
			
			tracing(rightValues[a] +" + "+ leftValues[a]);
			
		}
	}//END drawDottedRope()
	
	//METHOD FOR DRAWING BASIC ROPE
		public void drawWaterWave(Graphics2D g2){
			
			midX = (this.getWidth()-length)/2;//FOR CENTERING THE WAVE
			midY = (this.getHeight())/2;
			
			//SETTING PEN
			BasicStroke bs = new BasicStroke(penSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
			g2.setStroke(bs);
			g2.setColor(Color.BLUE);
			
			//DRAWING
			totalHeight2 =rightValues[0] + leftValues[0];
			
			for(int a = 1; a < length/precision+1; a++){
				
				totalHeight1 =rightValues[a] + leftValues[a];
				
				g2.draw(new Line2D.Double(precision*a+midX, totalHeight1+midY, precision*a+midX, getHeight()));
				
				tracing(" a :"+ a);
				
				totalHeight2 = totalHeight1;
			}
			tracing("---------------------");
		}//END drawBasicRope()
	
	//METHOD FOR DRAWING GRID
	public void drawGrid(Graphics2D g2){
		
		midX = (this.getWidth())/2;//FOR CENTERING THE WAVE
		midY = (this.getHeight()/2);
		
		g2.setStroke(new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
		g2.setColor(new Color(0,0,0));
		
		g2.draw(new Line2D.Double(0, midY , getWidth() , midY));
		g2.setStroke(new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
		
		for(int a = 1;a < midY; a+=30){
			g2.draw(new Line2D.Double(0, midY+a , getWidth() , midY+a));
			g2.draw(new Line2D.Double(0, midY-a , getWidth() , midY-a));
		}
		
		for(int a = 0;a < midX; a+=30){
			g2.draw(new Line2D.Double(midX+a, 0, midX+a, getHeight() ));
			g2.draw(new Line2D.Double(midX-a, 0, midX-a, getHeight() ));
		}
	}//END drawGrid()
	
	//METHOD FOR DISPLAYING TITLE
	public void drawTitle(Graphics2D g2){

		midX = (this.getWidth())/2-300;//FOR CENTERING THE WAVE
		midY = (this.getHeight()/2) - 20;
		
		
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Arial",Font.BOLD, 60));
		g2.drawString("Wave Simulator 2014", -5 +midX, midY);
		
		g2.setFont(new Font("Arial",Font.BOLD, 60));
		g2.setColor(Color.WHITE);
		g2.drawString("Wave Simulator 2014", midX, midY);
		
		g2.setFont(new Font("Arial",Font.BOLD, 18));
		g2.setColor(Color.WHITE);
		g2.drawString("created by Nam", midX+500, midY+50);
		
		g2.setFont(new Font("Arial",Font.BOLD, 20));
		g2.setColor(Color.WHITE);
		g2.drawString("Click to proceed", midX+220, midY+200);
	}
	
	//METHOD FOR DRAWING BASIC ROPE
	public void drawValues(Graphics2D g2){
			
			midX = (this.getWidth()-length)/2;//FOR CENTERING THE WAVE
			midY = (this.getHeight()/2);
			
			BasicStroke bs = new BasicStroke(penSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
			g2.setStroke(bs);
			g2.setColor(color);
			
			//DRAWING
			totalHeight2 =rightValues[0] + leftValues[0];
			for(int a = 0; a < length/precision+1; a+=6){
				
				totalHeight1 =rightValues[a] + leftValues[a];
				
				g2.draw(new Line2D.Double(precision*a+midX, totalHeight1+midY, precision*(a)+midX, 0+midY));
				
				tracing(rightValues[a] +" + "+ leftValues[a]);
				
				totalHeight2 = totalHeight1;
			}
		}//END drawValues()
	
	//PAINT METHOD FOR DRAWING WAVE
	public void paintComponent(Graphics g){
		
		int midX = (this.getWidth()-length)/2;//FOR CENTERING THE WAVE
		int midY = (this.getHeight())/2;
		
		//CASTING GRAPHICS TO GRAPHICS2D
		Graphics2D g2 = (Graphics2D)g;
		
		//DRAWING BACKGROUND
		GradientPaint gp = new GradientPaint(midX,0,Color.blue,midX,this.getHeight(),Color.black);
		g2.setPaint(gp);
		g2.fillRect(0, 0,this.getWidth() , this.getHeight());
		
		//THE WAVE IS DRAWN DEPENDING ON LINE STYLE
		if(lineStyle == 1){//BASIC LINE
			drawGrid(g2);
			drawBasicRope(g2);
		} 
		else if(lineStyle == 2){
			drawGrid(g2);
			drawDottedRope(g2);
		}
		else if(lineStyle == 3){
			drawGrid(g2);
			drawValues(g2);
		}
		else if(lineStyle == 4){
			drawGrid(g2);
			drawWaterWave(g2);
		}
		else if(lineStyle == 0){
			drawGrid(g2);
			drawTitle(g2);
		}
	}//END paintComponent()
	
	//METHOD FOR TRACING
	public void tracing(String x){
		if(tracing)System.out.println(x);
	}//END tracing()
}
