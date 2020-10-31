
import java.awt.image.BufferedImage;//for storing images
import java.io.File;//for loading the image file
import java.io.IOException;//for handling exceptions

import javax.imageio.ImageIO;//for reading in image file

public class Plane {
	
	protected String name;//name of the pilot
	
	protected Level level;
	protected int updates;//updates per second
	protected Keyboard keyboard; // for user input
	protected int up, down, special; // control keys for the plane
	
	Point[] points={//the hit points of the plane,
			new Point(2,4),
				new Point(7,1),
				new Point(4,13),
				new Point(15,8),
				new Point(14,14),
				new Point(31,6),
				new Point(31,16),
				new Point(61,7),
				new Point(61,16)};
	
	Point[] collisionPoints = new Point[points.length];//will store the above hit points after they have been rotated
	
	protected Point gunBarrelPosition = new Point(60, 10);//position from where bullets will come out
	protected Point gunBarrel;//current location of the gun barrel on the plane after rotation
	
	protected BufferedImage sprite;//image of plane to be displayed on the screen
	protected BufferedImage hit;//when plane is hit this will be displayed
	protected BufferedImage plane;//the image of plane itself
	protected BufferedImage explosion;//when plane is destroyed it explodes
	protected int xCenter = 30;//center of the image
	protected int yCenter = -12;//center of the image
	
	protected boolean alive = true;
	protected int health = 15;//HP
	protected double x, y;//position of the plane
	protected double speed;//only positive value
	protected double turningRate = 170.0;//per second
	protected double direction;//which way the plane is flying
	
	protected int fireRate = 5;//per second
	protected int firePause = 10;//for timing pauses in between shots
	protected int explosionPause = 0;//for timing pause after explosion
	protected int hitPause = 0;//for timing pause after being hit by a bullet
	
	
	//Constructor
	Plane(int xLocation, int yLocation, double speed, double direction, Level level){
		
		File f = null;
				
		if((int)(Math.random()*2) == 0){
			f = new File("bin/warplane.png");
		}
		else{
			f = new File("bin/warplane2.png");	
		}
		
		
		try {//loading images
			sprite = plane = ImageIO.read(f);
			hit = ImageIO.read(new File("bin/planeHit.png"));
			explosion = ImageIO.read(new File("bin/explosion.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//rotating the collision points 
		for(int i = 0; i < collisionPoints.length; i++){
			double newX = x + (points[i].getX())*(Math.cos(Math.toRadians(direction))) - (points[i].getY())*(Math.sin(Math.toRadians(direction)));
			double newY = y - (points[i].getX())*(Math.sin(Math.toRadians(direction))) - (points[i].getY())*(Math.cos(Math.toRadians(direction)));
			collisionPoints[i] = new Point(newX, newY);
		}
		
		//setting class variables
		this.level = level;
		this.speed = Math.abs(speed);
		this.direction = direction;
		x = xLocation;
		y = yLocation;
		updates = level.getUpdates();
		keyboard = level.getKeyboard();
	}//end constructor
	
	/*
	 * method for updating plane's position and it's sprites
	 * 
	 * pre-condition: 
	 * - keyboard, gunBarrel, gunBarrellPosition, hitPoints, points can't be null 
	 * 
	 * post-condition: 
	 * - changes x, y location based on speed, direction
	 * - changes collisionPoints based on location, direction
	 * - changes location of gunBarrel
	 * - changes direction based on user input
	 * - created bullet objects and adds them to level based on user input
	 * - changes images of the object based on health and other factors
	 */
	public void update(){
		
		updateUserInput();
		
		updatePlane();
		
	}//end update()
	
	public void updatePlane(){
		//changing position of plane based on the angle and number of updates
		x += Math.cos(Math.toRadians(direction))*speed/updates;
		y -= Math.sin(Math.toRadians(direction))*speed/updates;
		
		//rotating the collision points 
		for(int i = 0; i < collisionPoints.length; i++){
			double newX = x + (points[i].getX()-xCenter)*(Math.cos(Math.toRadians(direction))) - (-points[i].getY()-yCenter)*(Math.sin(Math.toRadians(direction)));
			double newY = y - (points[i].getX()-xCenter)*(Math.sin(Math.toRadians(direction))) - (-points[i].getY()-yCenter)*(Math.cos(Math.toRadians(direction)));
			collisionPoints[i] = new Point(newX, newY);
		}
		
		//rotating location of gunBarrel
		double newX = x + (gunBarrelPosition.getX()-xCenter)*(Math.cos(Math.toRadians(direction))) - (-gunBarrelPosition.getY()-yCenter)*(Math.sin(Math.toRadians(direction)));
		double newY = y - (gunBarrelPosition.getX()-xCenter)*(Math.sin(Math.toRadians(direction))) - (-gunBarrelPosition.getY()-yCenter)*(Math.cos(Math.toRadians(direction)));
		gunBarrel = new Point(newX, newY);
		
		if(firePause==updates/fireRate+1){
			shoot();
			firePause = 0;
		}
		firePause++;
		
		//when the plane is hit it will turn yellow for a fraction of time
		//this code sets the sprite to the original image after that fraction of time elapses
		if(hitPause > 0){
			hitPause++;
			if(hitPause >= 5){
				
				hitPause = 0;
				sprite = plane;
			}
		}
		
		//when the plane is dead make it explode
		if(health < 1){
			speed = direction = 0;
			xCenter = 120;
			yCenter = -80;
			sprite = explosion;
			
			explosionPause++;
			if(explosionPause == updates){
				alive = false;
			}
		}
	}
	
	public void updateUserInput(){
		//changing planes directions based on user input
		if(keyboard.getKeys()[up]){
			direction += turningRate/updates;
		}
		
		if(keyboard.getKeys()[down]){
			direction -= turningRate/updates;
		}
		
		//shooting bullets at a constant rate
		if(firePause==updates/fireRate){
			shoot();
		}
	}
	
	/*
	 * method for shooting bullets
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - adds a new bullet object in the level object
	 */
	private void shoot(){
		if(health>0)level.addBullets(new Bullet((int)(gunBarrel.getX()), (int)(gunBarrel.getY()), direction, level, this));
	}//end shoot()
	
	/*
	 * method for decrementing plane's health
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - makes health one less
	 * - changes sprite to yellow plane to indicate to user that the plane was hit
	 */
	public void hit(){
		health--;//loses one health
		if(health > 0){
			sprite = hit;//changes sprite to the yellow plane
			hitPause = 1;//begins timing so that the code in update() changes sprite back to normal plane
		}
	}//end hit()
	
	//set methods-----------------------------------------------
	
	/*
	 * method for setting the up key for the plane
	 * 
	 * pre-condition: 
	 * - takes integer in between 0 and 200 representing key on the keyboard
	 * 
	 * post-condition: 
	 * - sets the up variable to the given integer
	 */
	public void setUp(int u){
		if(u>0 && u<200){
			up = u;
		}
		else{
			System.out.println("key number set for plane is invalid");
		}
	}//end setUp()
	
	/*
	 * method for setting the special key for the plane
	 * 
	 * pre-condition: 
	 * - takes integer in between 0 and 200 representing key on the keyboard
	 * 
	 * post-condition: 
	 * - sets the down variable to the given integer
	 */
	public void setDown(int d){
		if(d>0 && d<200 && d != up || d != down){
			down = d;
		}
		else{
			System.out.println("key number set for plane is invalid");
		}
	}//end setDown()
	
	/*
	 * method for setting the shoot key
	 * 
	 * pre-condition: 
	 * - takes integer in between 0 and 200 representing key on the keyboard
	 * 
	 * post-condition: 
	 * - sets the shoot variable to the given integer
	 */
	public void setSpecial(int s){
		if(s>0 && s<200){
			special = s;
		}
		else{
			System.out.println("key number set for plane is invalid");
		}//end setShoot()
	}
	//get methods for the class--------------------------------
	
	/*
	 * method for setting direction
	 * 
	 * pre-condition: 
	 * - double value representing direction
	 * 
	 * post-condition: 
	 * - sets direction
	 */
	public void setDirection(double d){
		direction = d % 360;
	}//end setDirection()
	
	/*
	 * method for setting name
	 * 
	 * pre-condition: 
	 * - takes a string
	 * 
	 * post-condition: 
	 * - sets name to the string
	 */
	public void setName(String s){
		name = s;
	}//end setName()
	
	public void setX(double xx){
		x = xx;
	}
	
	public void setY(double yy){
		y = yy;
	}
	
	//get methods-----------------------------------------------
	
	/*
	 * method for getting x position
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - returns x coordinate
	 */
	public double getX(){
		return x;
	}//end getX()
	
	/*
	 * method for getting y position
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - returns y coordinate
	 */
	public double getY(){
		return y;
	}//end getY()
	
	/*
	 * method for getting xCenter
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - returns xCenter
	 */
	public double getXCenter(){
		return xCenter;
	}//end getXCenter()
	
	/*
	 * method for getting yCenter
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - returns yCenter
	 */
	public double getYCenter(){
		return yCenter;
	}//end getYCenter()
	
	/*
	 * method for getting the current sprite
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - returns sprite of this object
	 */
	public BufferedImage getImage(){
		return sprite;
	}//end getImaged()
	
	/*
	 * method for getting health
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - returns health
	 */
	public int getHealth(){
		return health;
	}//end getHealth()
	
	/*
	 * method for getting name
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - returns name
	 */
	public String getName() {
		return name;
	}//end getName()
	
	/*
	 * method for getting direction
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - returns direction
	 */
	public double getDirection(){
		return direction;
	}//end getDirection()
	
	/*
	 * method for checking if the object is dead
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - returns true if dead, otherwise return false
	 */
	public boolean isDead() {
		return !alive;
	}//end isDead()
	
	/*
	 * method for checking if two planes are the same
	 * 
	 * pre-condition: 
	 * - takes a Plane object
	 * 
	 * post-condition: 
	 * - returns true if two planes have same image, otherwise returns false
	 */
	public boolean equals(Object p){
		if(p instanceof Plane){
			Plane plane = (Plane)p;
			return	name.equals(plane.getName());
		}
		return false;
	}//end equals()
	
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
		return	"\nx: "+x+
				"\ny: "+y+
				"\nspeed: "+speed+
				"\ndirection: "+direction+
				"\nsprite width: "+plane.getWidth()+
				"\nsprite height: "+plane.getHeight();
		
	}//end toString()

}//end class
