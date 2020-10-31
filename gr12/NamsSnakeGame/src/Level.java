import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Level extends JPanel{
	
	//class variables
	private Keyboard keyboard;//for gettin input from user
	private int updates = 10;//updates per second
	private boolean gameOver = false;//to let program know if game is over
	private LongCat cat;//the cat
	private int cellWidth = 50;//width of each square in pixels
	private int boardWidth = 20, boardHeight = 16;//dimension of board
	private int count; // for timing respawn time
	private boolean[][] board;//for mice to see if they are trapped by the cat
	private int points;//the total points scored
	private int time;//time until game over
	private ArrayList<String> names;//list of names on highscore
	private ArrayList<Integer> scores;//scores for high score
	private ArrayList<Mouse> mouse = new ArrayList<Mouse>();//the mice array
	
	//constructor
	Level(Keyboard k){
		keyboard = k;
		
		//setting the size of panel based on the background picture
		setPreferredSize(new Dimension(boardWidth*cellWidth, boardHeight*cellWidth));
		
		
		
		//setting up planes
		reset();

	}//end constructor
	
	

	//method for calling update() at a constant rate
	public void start(){
		double timer = 0;
		double deltaT = 0;//change in time
		double lastT = System.nanoTime();//getting the current time
		
		//this part has to run forever
		while(true){
			//getting current time
			double now = System.nanoTime();
			
			//adding time that elapsed to delta variable
			timer += (now - lastT); 
			deltaT += (now - lastT);
			lastT = now;
			
			//calling update(), when deltaT is bigger than one second(1second = 1 000 000 000nanoseconds)
			//by multiplying the delta by number of updates, say 60, will cause the delta value to reach one second 60 times faster
			//therefore update will be called 60 times a second
			if(deltaT*updates >= 1000000000){
				update();
				deltaT-=1000000000/updates;//resetting delta back to zero
			}
			if(timer >= 1000000000){
				time--;
				timer-=1000000000;
			}
		}//end loop
		
	}//end start()
	
	
	// method for resetting the game
	private void reset(){
		points = 0;
		time = 60;
		cat = new LongCat(10, 10, 25, this);
		mouse.clear();
		gameOver = false;
	}//end reset()
	
	//method for updating positions of all objects on the screen 
	private void update(){
		
		if(time <= 0){//if time runs out
			time = 0;
			if(!gameOver)displayHighScore();
			gameOver = true;
		}
		
		//if enter is pressed then the game is reset
		if(keyboard.getKeys()[KeyEvent.VK_ENTER]){
			reset();
		}
		
		collision();
		
		for(int i = 0; i < mouse.size(); i++) 
			if(!mouse.get(i).isAlive())
				mouse.remove(i);
		
		//add mouse if there are less than 3
		if(mouse.size() < 20){
			if(count > 0){
				count--;
			}else{
				count = 8;
			}
			if(count == 1)mouse.add(new Mouse((int)(Math.random()*boardWidth), (int)(Math.random()*boardHeight), (int)(Math.random()*4), this, cat));
		}
		
		//updating mice
		for(Mouse m: mouse)
			m.update();
		cat.update();
		
		//calling paintComponent() to draw objects to screen
		repaint();
		
	}//end update()
	
	//method for determining whether the mice are captured
	private void collision(){
		//head on collision
		for(Mouse m: mouse){
			if(m.getX() == cat.getHead().getX() && m.getY() == cat.getHead().getY()){
				m.kill();
				if(!gameOver)points++;
				return;
			}
		}
		
		//checking whether the cat trapped mice with its body
		Node t = cat.getHead().next();
		
		do{
			if(t.getX() == cat.getHead().getX() && t.getY() == cat.getHead().getY()){
				
				board = new boolean[boardWidth][boardHeight];
				t = cat.getHead();
				
				do{//positions where the cat is set them to true
					board[t.getX()][t.getY()] = true;			
					t = t.next();
				}while(t != null);
				
				for(Mouse m: mouse){
					if(!findWay(m.getX(), m.getY())){
						m.kill();
						if(!gameOver)points+=2;//you get 2 points for trapping the mouse
					}
					
				}
				
				return;//once the cat was found to hit itself there's no need to check the other nodes
			}else{
				t = t.next();
			}
		}while(t != null);
	}//end collision()
	
	//recursive method for checking if mice are trapped
	private boolean findWay(int x, int y){
		
		board[x][y] = true;
		
		if(x == 0 || x == boardWidth-1 || y == 0 || y == boardHeight-1)return true;//simplest case
		
		if(x<boardWidth-1 && !board[x+1][y]){
			if(findWay(x+1, y))return true;
		}
		if(x>0            && !board[x-1][y]){
			if(findWay(x-1, y))return true;	
		}
		if(y<boardHeight-1 && !board[x][y+1]){
			if(findWay(x, y+1))return true;
		}
		if(y>0             && !board[x][y-1]){
			if(findWay(x, y-1))return true;
		}
		
		return false;
	}//end findWay()
	
	//method for painting objects to screen
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		//displaying info
		String zero = "";
		g2d.setFont(new Font("times new roman", Font.BOLD, 39));
		g2d.drawString("score: "+points, 100, 100);
		if(time-(time/60)*60<10)zero = "0";
		if(!gameOver)g2d.drawString("time: "+time/60+":"+zero+(time-(time/60)*60), 100, 130);
		else g2d.drawString("time: 00:00", 100, 130);
				
		//drawing the mice
		for(Mouse m: mouse){
			int xPos = m.getX()*cellWidth;
			int yPos = m.getY()*cellWidth;
			if(m.getImage()!=null && m.isAlive())g2d.drawImage(m.getImage() ,xPos, yPos, null);
		}
		
		//drawing the cat
		Node t = cat.getHead();
		do{
			int xPos = t.getX()*cellWidth;
			int yPos = t.getY()*cellWidth;
			if(t.getImage()!=null)g2d.drawImage(t.getImage() ,xPos, yPos, null);
			t = t.next();
		}while(t != null);
		
		//if game is over, display the results
		if(gameOver){
			g2d.setFont(new Font("garamond", Font.BOLD, 100));
			
			g2d.setFont(new Font("times new roman", Font.BOLD, 35));
			g2d.drawString("press enter to play again", 100, 300);
			
			g2d.drawString("High Scores:", 760, 250);
			for(int i = 0; i < names.size(); i++){
				if(i == 10)break;//print only first 10
				g2d.drawString(names.get(i)+" - "+scores.get(i), 800, 300+35*i);
			}
		}
	}//end paintComponent()
	
	//method for displaying highscore
	private void displayHighScore(){
		names = new ArrayList<String>();
		scores = new ArrayList<Integer>();
		
		//read list
		BufferedReader br = null;
		
		try {//create buffered reader
			br = new BufferedReader(new FileReader("bin/scores.txt"));
		}catch(FileNotFoundException ex){
			JOptionPane.showMessageDialog(this, "File not found!");
			return;
		}
		catch (Exception a) {
			return;
			
		}
		
		int size = 0;
		
		try {//reading the size
			size = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e1) {
			e1.printStackTrace();
		}
		
		//reading in the names and scores
		for(int i = 0; i < size; i++){
			String[] in = null;
			
			try {
				in = br.readLine().split(" ");
			} catch (IOException e) {
				e.printStackTrace();
			}
			scores.add(Integer.parseInt(in[1]));
			names.add(in[0]);
		}
		
		try{
			br.close();
		}catch(IOException e){
			
		}
		
		//adding the score to the list
		String name = JOptionPane.showInputDialog(this, "What's your name?");
		
		if(names.size() == 0){
			scores.add(points);
			names.add(name);
		}
		else{
			for(int i = 0; i < names.size(); i++){
				if(scores.get(i) < points){
					System.out.println(names.size()+"at: "+i+names.get(i));
					scores.add(i, points);
					names.add(i, name);
					break;
				}
			}
		}
		
		
		//save list
		PrintWriter pw = null;
		
		try {//create the PrintWriter object and specify the name
			 pw = new PrintWriter(new File("bin/scores.txt"));
		} catch (FileNotFoundException ex) {
			return;
		}catch(NullPointerException ex){
			return;
		}
		//save the size of the array
		pw.println(names.size());
		
		//save the values
		for(int i = 0; i < names.size(); i++){
			pw.println(names.get(i)+" "+scores.get(i));
		}
		
		pw.close();
	}
	
	//Get Methods--------------------------------------------------
	
	//get method
	public int getBoardWidth(){
		return boardWidth;
	}//end
	
	//get method
	public int getBoardHeight(){
		return boardHeight;
	}//end
	
	//method for getting updates
	public int getUpdates(){
		return updates;
	}//end getUpdates()
	
	// method for getting keyboard object
	public Keyboard getKeyboard(){
		return keyboard;
	}//end getKeyboard()
	
}
