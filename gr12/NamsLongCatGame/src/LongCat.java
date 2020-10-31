import javax.swing.ImageIcon;


public class LongCat {
	
	//class fields
	final int UP = 0;
	final int RIGHT = 0;
	final int LEFT = 0;
	final int DOWN = 0;
	
	//class variable
	int x, y;
	int maxLength, currLength;
	int direction = 1, oldDir = -1;
	Node head, tail;
	Level level;
	Keyboard key;
	//images of the cat
	ImageIcon[] turnSprite = new ImageIcon[4];
	ImageIcon[] headSprite = new ImageIcon[4];
	ImageIcon[] tailSprite = new ImageIcon[4];
	ImageIcon[] bodySprite = new ImageIcon[2];
	
	//constructor
	LongCat(int X, int Y, int length, Level l){
		maxLength = length;
		x = X;
		y = Y;
		tail = head = new Node(X, Y, direction);
		level = l;
		key = l.getKeyboard();
		
		//read in images
		for(int i = 1; i <= 4; i++){
			headSprite[i-1] = new ImageIcon("bin/body_head"+i+".png");
			turnSprite[i-1] = new ImageIcon("bin/body_turn"+i+".png");
			tailSprite[i-1] = new ImageIcon("bin/body_tail"+i+".png");
			if(i<3)bodySprite[i-1] = new ImageIcon("bin/body"+i+".png");
		}
		
		head.setImage(headSprite[1]);
		
	}
	
	//update method for updating position and images
	public void update(){
		
		input();
		
		if(direction == UP){
			if(oldDir == RIGHT){
				head.setImage(turnSprite[3]);
				addHead();
				if(currLength == maxLength)removeTail();
				else currLength++;
			}
			if(oldDir == LEFT){
				head.setImage(turnSprite[0]);
				addHead();
				if(currLength == maxLength)removeTail();
				else currLength++;
			}
		}else if(direction == DOWN){
			if(oldDir == RIGHT){
				head.setImage(turnSprite[2]);
				addHead();
				if(currLength == maxLength)removeTail();
				else currLength++;
			}
			if(oldDir == LEFT){
				head.setImage(turnSprite[1]);
				addHead();
				if(currLength == maxLength)removeTail();
				else currLength++;
			}
		}else if(direction == RIGHT){
			if(oldDir == UP){
				head.setImage(turnSprite[0]);
				addHead();
				if(currLength == maxLength)removeTail();
				else currLength++;
			}
			if(oldDir == DOWN){
				head.setImage(turnSprite[1]);
				addHead();
				if(currLength == maxLength)removeTail();
				else currLength++;
			}
		}else{
			if(oldDir == UP){
				head.setImage(turnSprite[2]);
				addHead();
				if(currLength == maxLength)removeTail();
				else currLength++;
			}
			if(oldDir == DOWN){
				head.setImage(turnSprite[3]);
				addHead();
				if(currLength == maxLength)removeTail();
				else currLength++;
			}
		}
		
		oldDir = -1;
	}
	
	//method for removing the tail
	private void removeTail(){
		tail = tail.previous();
		tail.setImage(tailSprite[tail.getDirection()]);
	}
	
	//method for adding new head
	private void addHead(){
		//setting coordinates of new head
		if(direction == UP)head.setPrevious(new Node(x, y-1, direction));
		if(direction == DOWN)head.setPrevious(new Node(x, y+1, direction));
		if(direction == LEFT)head.setPrevious(new Node(x-1, y, direction));
		if(direction == RIGHT)head.setPrevious(new Node(x+1, y, direction));
		
		//setting the head to the new node
		head.previous().setNext(head);
		head = head.previous();
		head.setImage(headSprite[direction]);
	}//end addHead()
	
	//method for updating user input
	public void input(){
		if(key.getKeys()[38] && 
				wayIsClear(UP)){
			oldDir = direction;
			direction = UP;
		}
		if(key.getKeys()[39] && wayIsClear(RIGHT)){
			oldDir = direction;
			direction = RIGHT;
		}
		if(key.getKeys()[40] && wayIsClear(DOWN)){
			oldDir = direction;
			direction = DOWN;
		}
		if(key.getKeys()[37] && wayIsClear(LEFT)){
			oldDir = direction;
			direction = LEFT;
		}
	}
	
	//method for checking if snake can go forward without going out of bounds
	public boolean wayIsClear(int direction){
		if(direction == UP){
			return(head.getY()-1 >= 0);
		}else if(direction == DOWN){
			return(head.getY()+1 < level.getHeight());
		}else if(direction == RIGHT){
			return(head.getX()+1 < level.getWidth());
		}else{
			return(head.getX()-1 >= 0);
		}
	}

}
