public class Bullet {
	Plane plane; //the plane the bullet belongs to
	private Level level;
	private int updates;//updates per second
	private double x, y;//position of the bullet
	private double speed = 300;//only positive value
	private double direction;//which way the bullet is flying
	private boolean alive = true;//for deciding whether to get rid of the bullet
	
	//Constructor
	Bullet(int xLocation, int yLocation, double direction, Level level, Plane p){
		//setting the class variables
		plane = p;
		this.level = level;
		this.speed = Math.abs(speed);
		this.direction = direction;
		x = xLocation;
		y = yLocation;
		updates = level.getUpdates();
	}//end constructor
	
	/*
	 * method for updating bullet's position
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - changes x,y position based on speed and direction
	 */
	public void update(){
		if(alive){
			//changing position of plane based on the angle and number of updates
			x += Math.cos(Math.toRadians(direction))*speed/updates;
			y -= Math.sin(Math.toRadians(direction))*speed/updates;
		}
	}//end update()
	
	public void setDirection(int dir){
		direction+=dir;
		direction%=360;
	}
	
	/*
	 * method for  killing bullet
	 * 
	 * pre-condition: 
	 * - nothing
	 * 
	 * post-condition: 
	 * - marks the bullet to be removed from array
	 * - sets the speed to 0
	 */
	public void kill(){
		alive = false;
		speed = 0;
	}//end kill()
	
	//get methods for the class--------------------------------
	
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
	 * method for checking if two bullets are the same
	 * 
	 * pre-condition: 
	 * - takes a Bullet object
	 * 
	 * post-condition: 
	 * - returns true if two bullets have same location, otherwise returns false
	 */
	public boolean equals(Object p){
		if(p instanceof Bullet){
			Bullet bullet = (Bullet)p;
			return	bullet.getX() == x && bullet.getY() ==y;
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
					"\ndirection: "+direction;
			
	}//end toString()
}
