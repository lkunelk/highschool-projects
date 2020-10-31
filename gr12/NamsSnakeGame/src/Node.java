import java.awt.Image;

import javax.swing.ImageIcon;

public class Node {
	//class variables
	private int dir;
	private ImageIcon im;
	private int x, y; //its location
	Node next, previous;
	
	//constructor
	Node(int X, int Y, int d, Node nextNode){
		dir = d;
		x = X;
		y = Y;
		next = nextNode;
	}//end constructor
	
	//get method
	public Node next(){
		return next;
	}//end next()
	
	//get method
	public Node prev(){
		return previous;
	}//end prev()
	
	//getMethod
	public int getX(){
		return x;
	}//end getX()
	
	//getMethod
	public int getY(){
		return y;
	}//end getY()
	
	//get method
	public Image getImage(){
		if(im != null)return im.getImage();
		return null;
	}
	
	//get method
	public int getDir(){
		return dir;
	}
	
	//set method
	public void setPosition(int X, int Y){
		x = X;
		y = Y;
	}//end setPosition()
	
	//set method
	public void setDir(int d){
		if(d >= 0 && d <= 3)
			dir = d;
	}
	
	//setMethod
	public void setImage(ImageIcon i){
		if(i != null)
			im = i;
	}
}//end class
