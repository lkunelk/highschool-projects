import java.awt.Image;

import javax.swing.ImageIcon;


public class Mouse {
	static ImageIcon sprite1 = new ImageIcon("bin/mouse1.png");
	static ImageIcon sprite2 = new ImageIcon("bin/mouse2.png");
	static ImageIcon sprite3 = new ImageIcon("bin/mouse3.png");
	static ImageIcon sprite4 = new ImageIcon("bin/mouse4.png");
	
	//class fields
	final int UP = 0;
	final int RIGHT = 1;
	final int LEFT = 3;
	final int DOWN = 2;
	
	private int x, y;//coordinates
	private int dir = 0;
	private int count;
	private boolean alive = true;
	private Level level;
	private ImageIcon im;
	private LongCat cat;
	
	//constructor
	Mouse(int X, int Y, int d, Level l, LongCat c){
		x = X;
		y = Y;
		dir = d;
		level = l;
		cat = c;
		im = sprite1;
	}//end constructor
	
	//update method
	public void update(){
		if(count < 0){//change direction after certain numbers of steps
			count = (int)(Math.random()*5)+5;
			changeDir();
		}
		
		if(wayIsClear(dir)){
			if(dir == UP){
				y--;
			}
			else if(dir == DOWN){
				y++;
			}
			else if(dir == LEFT){
				x--;
			}
			else{
				x++;
			}
		}
		else{
			changeDir();
		}
		
		count--;
	}//end update()
	
	//method for changing directions
	public void changeDir(){
		dir = (int)(Math.random()*1000)%4;
		
		//update the image based on the direction
		if(dir == 0)
			im = sprite1;
		if(dir == 1)
			im = sprite2;
		if(dir == 2)
			im = sprite3;
		if(dir == 3)
			im = sprite4;
	}//end changeDir()
	
	//method for checking if snake can go forward without going out of bounds
	public boolean wayIsClear(int dir){
		Node t = cat.getHead();
		int x = this.x, y = this.y;
		if(dir == UP)y--;
		if(dir == DOWN)y++;
		if(dir == LEFT)x--;
		if(dir == RIGHT)x++;
		
		//loop through all the nodes of the cat and see whether its body is in front of the mouse
		do{
			if(t.getX() == x && t.getY() == y)
				return false;
			t = t.next();
		}while(t != null);
		
		if(dir == UP){
			return(y >= 0);
		}else if(dir == DOWN){
			return(y < level.getBoardHeight());
		}else if(dir == RIGHT){
			return(x < level.getBoardWidth());
		}else{
			return(x >= 0);
		}
	}//end wayIsClear()
	
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
			return im.getImage();
		}
		
		//get method
		public int getDir(){
			return dir;
		}
		
		//get method
		public boolean isAlive(){
			return alive;
		}
		
		//set method
		public void setDir(int d){
			if(d >= 0 && d <= 3)
				dir = d;
		}
		
		//method for killing the mouse
		public void kill(){
			System.out.println("im  dead");
			alive = false;
		}
		
		//setMethod
		public void setImage(ImageIcon i){
			if(i != null)
				im = i;
		}
}//end class
