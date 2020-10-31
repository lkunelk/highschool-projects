import javax.swing.ImageIcon;

public class Node {
	//class variables
	int x, y;
	int direction;
	ImageIcon i;
	Node next, previous;
	
	//constructor
	Node(int X, int Y, int dir){
		x = X;
		y = Y;
		direction = dir;
	}//end constructor
	
	//SET METHODS --------------------------------------------------
	
	//set method
	public void setNext(Node n){
		next = n;
	}//end setNext()
	
	//set method
	public void setPrevious(Node n){
		previous = n;
	}//end setPrevious()
	
	//set method for setting image
	public void setImage(ImageIcon im){
		if(im != null)
			i = im;
		else
			System.out.println("its null");
	}//end setImage
	
	//GET METHODS --------------------------------------------------
	//get method
	public int getDirection(){
		return direction;
	}
	
	//getMethod
	public int getX(){
		return x;
	}//end getX()
	
	//getMethod
	public int getY(){
		return y;
	}//end getY()
	
	//get method
	public Node next(){
		return next;
	}//end next()
	
	public Node previous(){
		return previous;
	}//end previous()
}//end class
