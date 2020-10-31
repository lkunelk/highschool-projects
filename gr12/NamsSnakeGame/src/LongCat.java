import javax.swing.ImageIcon;



public class LongCat {
	//class fields
	final int UP = 0;
	final int RIGHT = 1;
	final int LEFT = 3;
	final int DOWN = 2;
	
	//class variables
	private Node head, tail;
	private int x, y; //coordinates of the head
	private int dir = 1;//which way its going
	private int prevDir = 0;//which way it was going
	private int length;
	private Level level;
	private Keyboard key; //for user input
	
	//sprites
	private ImageIcon[] turnSprite = new ImageIcon[4];
	private ImageIcon[] headSprite = new ImageIcon[4];
	private ImageIcon[] tailSprite = new ImageIcon[4];
	private ImageIcon[] bodySprite = new ImageIcon[2];
	
	//constructor
	LongCat(int X, int Y, int l, Level lev){
		x = X;
		y = Y;
		length = l;
		level = lev;
		key = level.getKeyboard();
		
		//load images
		for(int i = 1; i <= 4; i++){
			headSprite[i-1] = new ImageIcon("bin/body_head"+i+".png");
			turnSprite[i-1] = new ImageIcon("bin/body_turn"+i+".png");
			tailSprite[i-1] = new ImageIcon("bin/body_tail"+i+".png");
			if(i<3)bodySprite[i-1] = new ImageIcon("bin/body"+i+".png");
		}
		
		//create the cat
		Node t = tail = new Node(x, y, dir, null);
		tail.setImage(tailSprite[dir]);
		for(int i = 0; i < length-1; i++){
			t.previous = new Node(x, y, dir, t);
			t.setImage(tailSprite[dir]);
			t = t.prev();
		}
		
		head = t;
		head.setImage(headSprite[dir]);
		head.setPosition(x+1, y);
		
	}//end constructor
	
	//method for updating the cats movement
	public void update(){
		input();
		//System.out.println(dir);
		if(wayIsClear(dir)){
			addHead();
			removeTail();
		}
	}//end update()
	
	//method for checking if snake can go forward without going out of bounds
	private boolean wayIsClear(int dir){
		if(dir == UP){
			return(head.getY()-1 >= 0);
		}else if(dir == DOWN){
			return(head.getY()+1 < level.getBoardHeight());
		}else if(dir == RIGHT){
			return(head.getX()+1 < level.getBoardWidth());
		}else{
			return(head.getX()-1 >= 0);
		}
	}//end wayIsClear()
	
	//method for updating user input
	private void input(){
		if(key.getKeys()[38] && wayIsClear(UP) && (dir == RIGHT || dir == LEFT)){
			prevDir = dir;
			dir = UP;
		}
		else if(key.getKeys()[39] && wayIsClear(RIGHT) && (dir == UP || dir == DOWN)){
			prevDir = dir;
			dir = RIGHT;
		}
		else if(key.getKeys()[40] && wayIsClear(DOWN) && (dir == RIGHT || dir == LEFT)){
			prevDir = dir;
			dir = DOWN;
		}
		else if(key.getKeys()[37] && wayIsClear(LEFT) && (dir == UP || dir == DOWN)){
			prevDir = dir;
			dir = LEFT;
		}
		else{
			prevDir = dir;
		}
	}
	
	//method for removing the tail
	private void removeTail(){
		tail = tail.prev();
		tail.next = null;
		tail.setImage(tailSprite[tail.getDir()]);
	}
	
	//method for adding new head
	private void addHead(){
		//System.out.println("direction = "+dir);
		
		//setting coordinates of new head
		if(dir == UP)head = new Node(x, --y, dir, head);
		if(dir == DOWN)head = new Node(x, ++y, dir, head);
		if(dir == LEFT)head = new Node(--x, y, dir, head);
		if(dir == RIGHT)head = new Node(++x, y, dir, head);
		head.next().setDir(head.getDir());
		//changing the body image based on directions it took
		if(prevDir == dir)
			head.next().setImage(bodySprite[dir%2]);
		else if((prevDir == DOWN && dir == RIGHT) || (prevDir == LEFT && dir == UP)){
			head.next().setImage(turnSprite[0]);
		}
		else if((prevDir == LEFT && dir == DOWN) || (prevDir == UP && dir == RIGHT)){
			head.next().setImage(turnSprite[1]);
		}
		else if((prevDir == UP && dir == LEFT) || (prevDir == RIGHT && dir == DOWN)){
			head.next().setImage(turnSprite[2]);
		}
		else if((prevDir == RIGHT && dir == UP) || (prevDir == DOWN && dir == LEFT)){
			head.next().setImage(turnSprite[3]);
		}
		
		head.next().previous = head;//set the old nodes previous as the head
		head.setImage(headSprite[dir]);
	}//end addHead()
	
	//get method
	public Node getHead(){
		return head;
	}//end getHead();
	
	public void printCoods(){
		Node t = head;
		int count = 1;
		do{
			System.out.println(count+" = "+t.getX()+", "+t.getY());
			count++;
			t = t.next();
		}while(t != null);
	}
}//end class
