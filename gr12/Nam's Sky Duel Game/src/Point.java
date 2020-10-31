
public class Point {
	private double x;
	private double y;
	
	//constructor
	Point(double x, double y){
		//setting class variables
		this.x = x;
		this.y = y;
	}
	
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
	 * method for checking if two points are the same
	 * 
	 * pre-condition: 
	 * - takes a Point object
	 * 
	 * post-condition: 
	 * - returns true if two points have same location
	 */
	public boolean equals(Object p){
		if(p instanceof Point){
			Point point = (Point)p;
			return	point.getX() == x && point.getY() ==y;
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
				"\ny: "+y;
		
	}//end toString()
}
