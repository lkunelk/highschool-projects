import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Level extends JPanel{
	
	//class variables
	private boolean tracing = false;//for tracing parts of program
	private Keyboard keyboard;//for gettin input from user
	private int updates = 100;//updates per second
	boolean gameOver = false;//to let program know if game is over
	
	private ArrayList<Plane> planes = new ArrayList<Plane>();//holds arrays of planes in the level
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();//holds array of bullets in game
	
	private ImageIcon background = new ImageIcon("bin/background.jpg");//the background of the level
	
	//constructor
	Level(Keyboard k){
		keyboard = k;
		
		//setting the size of panel based on the background picture
		setPreferredSize(new Dimension(background.getIconWidth(), background.getIconHeight()));
		
		//setting up planes
		reset();

	}//end constructor
	
	/*
	 * method for calling update() at a constant rate
	 * 
	 * pre-condition: 
	 * -the variable updates must have a positive value
	 * 
	 * post-condition: 
	 * -method update() is called at a rate of updates per second
	 */
	public void start(){
		
		double deltaT = 0;//change in time
		double lastT = System.nanoTime();//getting the current time
		
		//this part has to run forever
		while(true){
			//getting current time
			double now = System.nanoTime();
			
			//adding time that elapsed to delta variable
			deltaT += (now - lastT);
			lastT = now;
			
			//calling update(), when deltaT is bigger than one second(1second = 1 000 000 000nanoseconds)
			//by multiplying the delta by number of updates, say 60, will cause the delta value to reach one second 60 times faster
			//therefore update will be called 60 times a second
			if(deltaT*updates >= 1000000000){
				update();
				deltaT-=1000000000/updates;//resetting delta back to zero
			}
			
		}//end loop
		
	}//end start()
	
	
	/*
	 * method for resetting the game
	 * 
	 * pre-condition:
	 * - nothing
	 * 
	 * post-condition:
	 * - new planes and bullets arrays are created
	 * - new planes are added to the array and their control keys are set
	 */
	private void reset(){
		
		//making new arrays
		planes = new ArrayList<Plane>();
		bullets = new ArrayList<Bullet>();
		
		//creating planes
		planes.add(new Plane(500,300,300,0,this));
		planes.add(new Plane(500,300,300,180,this));
		planes.add(new Plane(300,300,300,90,this));
	//	planes.add(new Plane(300,300,300,415,this));
		
		int numOPlanes = 3;
		int spacing = 360/numOPlanes;
		
		for(int i = 3; i < numOPlanes; i++){
			PlaneAI p = new PlaneAI((int)(Math.random()*getWidth()),(int)(Math.random()*getHeight()),300,Math.random()*360, this);
			//PlaneAI p = new PlaneAI(400, 400, 300, spacing*i ,this);
			p.setName("Player "+i);
			planes.add(p);
			
		}
		
		planes.get(0).setUp(87);
		planes.get(0).setDown(83);
		planes.get(0).setName("ZheHao");
		
		planes.get(1).setUp(38);
		planes.get(1).setDown(40);
		planes.get(1).setName("Oliver");
		
		planes.get(2).setUp(89);
		planes.get(2).setDown(72);
		planes.get(2).setName("Nam");
		/*
		planes.get(3).setUp(89);
		planes.get(3).setDown(72);
		planes.get(3).setName("Kunek");
		*/
		gameOver = false;
	}//end reset()
	
	/*
	 * method for updating positions of all objects on the screen
	 * 
	 * pre-condition:
	 * - keyboard can't be null, 2 arrays: planes and bullets can't be null
	 * 
	 * post-condition:
	 * - the update() of each object in the planes and bullets arrays is called
	 * - collision between plane and bullets is checked and appropriate method is called for that
	 * - objects that have been marked dead are removed from the arrays
	 */
	public void update(){
		
		//if enter is pressed then the game is reset
		if(keyboard.getKeys()[KeyEvent.VK_ENTER]){
			reset();
		}
		
		//check if someone won
		gameOver();
		
		//updating bullets
		for(int i = 0; i < bullets.size(); i++){
			bullets.get(i).update();
			
			//getting rid of bullets if they go out of screen
			if(bullets.get(i).getX()<0 ||bullets.get(i).getX()>getWidth()){
				bullets.get(i).kill();
				
			}
			if(bullets.get(i).getY()<0 ||bullets.get(i).getY()>getHeight()){
				bullets.get(i).kill();
			}
		}
	
		//updating planes
		for(Plane p: planes){
			p.update();
			
			//flipping the plane if it's going off bounds
			if(p.getX()<0 ||p.getX()>getWidth()){
				p.setDirection(180-p.getDirection());
				if(tracing)System.out.println(p);
			}
			if(p.getY()<0 ||p.getY()>getHeight()){
				p.setDirection(-p.getDirection());
			}
		}
		
		//checking collision between plane and bullets
		for(Plane p: planes){
			for(Bullet b: bullets)
			if(!b.plane.equals(p) && p.getHealth() > 0){
				if(collision(p,b)){
					b.kill();
					p.hit();
				}
			}
		}
		
		//removing dead bullets
		for(int i = 0; i < bullets.size(); i++){
			if(bullets.get(i).isDead()){
				bullets.remove(bullets.get(i));
				i--;
			}
		}
		
		//removing dead planes
		for(int i = 0; i < planes.size(); i++){
			if(planes.get(i).isDead()){
				planes.remove(planes.get(i));
				i--;
			}
		}
		
		//calling paintComponent() to draw objects to screen
		repaint();
		
	}//end update()
	
	/*
	 * method for painting objects to screen
	 * pre-condition: planes, bullets arrays can't be null, 
	 * post-condition: planes and bullets are drawn on screen facing proper directions
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawImage(background.getImage(), 0, 0, null);
		
		//draw the planes
		for(Plane p: planes){
			
			//creating transformation
	        AffineTransform at = new AffineTransform();
	
	        // 3. translate image to where it supposed to be
	        at.translate((int)p.getX(), (int)p.getY());
	
	        // 2. rotating image
	        at.rotate(Math.toRadians(-p.getDirection()));
	
	        // 1. translating image to its center
	        at.translate(-(int)p.getXCenter(), (int)p.getYCenter());
	
	        //actually drawing the image
	        g2d.drawImage(p.getImage(), at, null);
	        
	        g2d.drawString(""+p.getName(), (int)p.getX()-10, (int)p.getY()-15);
		}//end plane for loop
		
		//drawing bullets
		for(int i = 0; i < bullets.size(); i++){
			g2d.drawRect((int)bullets.get(i).getX(), (int)bullets.get(i).getY(), 4,4);
		}
		
		//if game is over, display the results
		if(gameOver){
			g2d.setFont(new Font("garamond", Font.BOLD, 100));
			for(Plane p: planes){
				if(!p.isDead())g2d.drawString(p.getName()+" wins", 200, 200);
			}
			g2d.setFont(new Font("times new roman", Font.BOLD, 35));
			g2d.drawString("press enter to play again", 240, 300);
		}
	}//end paintComponent()
	
	/*
	 * method for detecting collision between plane and bullet
	 * 
	 * pre-condition:
	 * - require a plane and bullet object
	 * 
	 * post-condition:
	 * - returns true if the two objects collide otherwise returns false
	 */
	public boolean collision(Plane p, Bullet b){
		
		//do a broad check before doing the triangle detection
		double distance = (b.getX() - p.getX())*(b.getX() - p.getX())+(b.getY() - p.getY())*(b.getY() - p.getY());
		
		if(distance <= 61*61){
			//for storing 3 points of a triangle
			Point[] vertices = new Point[3];
			
			//checking all triangles inside the plane
			for(int j = 0; j < p.collisionPoints.length - 2; j++){
				//taking next points for testing
				vertices[0] = p.collisionPoints[j];
				vertices[1] = p.collisionPoints[j+1];
				vertices[2] = p.collisionPoints[j+2];
				
				//if one triangle collides then the plane is colliding
				if(triangleCollision(b, vertices)){
					return true;
				}
			}
		}
		
		//if all triangles don't collide then plane is not colliding with the bullet
		return false;
	}//end collision()
	
	/*
	 * method for testing collision between bullet and one triangle
	 * 
	 * pre-condition:
	 * - takes bullet object and array of points that represent a triangle
	 * 
	 * post-condition:
	 * - return true if bullet collides with the triangle, otherwise returns false
	 */
	public boolean triangleCollision(Bullet b, Point[] vertices){
		
		Point line1 = null;
		Point line2 = null;
		Point vertex = null;
		
		for(int i = 0; i <3; i++){
			
			double rise = 0;
			double run = 0;
			double yIntercept = 0;
			
			//switch around points to test each side of the triangle
			if(i == 0){
				line1 = vertices[0];
				line2 = vertices[1];
				vertex = vertices[2];
			}
			else if(i == 1)
			{
				line1 = vertices[0];
				line2 = vertices[2];
				vertex = vertices[1];
			}
			else
			{
				line1 = vertices[2];
				line2 = vertices[1];
				vertex = vertices[0];
			}
			//switching points so that they are in right order according to their x position
			if(line2.getX() > line1.getX()){
				Point temp = line2;
				line2 = line1;
				line1 = temp;
			}
			
			//here we're calculating the equation of line formed by the side of triangle
			//calculate rise
			rise = line1.getY() - line2.getY();
			
			//special case were slope is horizontal
			if(rise == 0){
				boolean vertexSide = vertex.getY() >= line1.getY();
				boolean pointSide = b.getY() >= line1.getY();
				
				//if the vertex and point are on different sides, there is no collision
				if(vertexSide ^ pointSide){
					return false;
				}
				
				continue;
			}
			
			//calculate run
			run = line1.getX() - line2.getX();
			
			//special case where slope is vertical
			if(run == 0){
				boolean vertexSide = vertex.getX() >= line1.getX();
				boolean pointSide = b.getX() >= line1.getX();
				
				//if the vertex and point are on different sides, there is no collision
				if(vertexSide ^ pointSide){
					return false;
				}
				
				continue;
			}
			
			//calculate y-intercept
			yIntercept = line1.getY() - rise/run*line1.getX();
			
			//true means it's above
			//false means it's below the line
			boolean vertexSide = (vertex.getX()*rise/run + yIntercept) >= vertex.getY();
			boolean pointSide = (b.getX()*rise/run + yIntercept) >= b.getY();
			
			//if the vertex and point are on different sides, there is no collision
			if(vertexSide ^ pointSide){
				return false;
			}
		}
		
		return true;
	}//end triangleCollision()

	/*
	 * method for checking if game is finished
	 * 
	 * pre-condition:
	 * - planes array can't be null
	 * 
	 * post-condition:
	 * - if game is finished it sets the gameOver to true, otherwise it set it to false
	 */
	private void gameOver(){
		int dead = 0;
		
		//checking how many planes are dead
		for(int i = 0; i < planes.size(); i++){
			if(planes.get(i).isDead()){
				dead++;
			}
		}
		
		//if there's only one plane remaining alive then game over
		gameOver = (planes.size() - dead) == 1;
	}//end gameOver()
	
	/*
	 * method for adding bullets to the array
	 * 
	 * pre-condition:
	 * - bullets array can't be null
	 * 
	 * post-condition:
	 * - a new bullet object is added to the bullets array
	 */
	public void addBullets(Bullet b){
		bullets.add(b);
	}//end addBullets()
	
	//Get Methods--------------------------------------------------
	
	/*
	 * method for getting updates
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - returns updates of this class
	 */
	public int getUpdates(){
		return updates;
	}//end getUpdates()
	
	public ArrayList<Plane> getPlanes(){
		return planes;
	}
	
	/*
	 * method for getting keyboard object
	 * 
	 * pre-condition: 
	 * -nothing
	 * 
	 * post-condition: 
	 * - return Keyboard object of this class
	 */
	public Keyboard getKeyboard(){
		return keyboard;
	}//end getKeyboard()
	
	//--------------------------------------------------------------
	
	/*
	 * method for printing information about this object
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - prints information about this object to the console
	 */
	public String toString(){
		return "updates per second: "+updates
				+"\nnumber of planes: "+planes.size()
				+"\nnumber of bullets: "+bullets.size();
	}//end toString()
}