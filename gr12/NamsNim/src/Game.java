import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;

public class Game extends JPanel implements MouseListener, MouseMotionListener{

	AI bob = new AI();
	
	int turn = 1;
	
	int xSpacing = 70;
	int xOffset = 10;
	int yOffset = 180;
	int ySpacing = 47;
	
	int stoneHeight = 40;
	int stoneWidth = 60;
	
	//for deciding which stones to paint
	int thePile = 5;
	int theStone = 5;
	
	private int[] piles = {2,2,2,2};
	
	public void paint(Graphics g){
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.BLUE);
		if(thePile >= 0 && thePile <= 3){
			for(int y = 0; y < piles[thePile]; y++){
				if(y > theStone-1){
					
					g.fillOval(thePile*(xSpacing)+xOffset-3, y*(-ySpacing)+yOffset-3, stoneWidth+6, stoneHeight+6);
				}
			}
		}
		
		g.setColor(Color.BLACK);
		for(int x = 0; x < 4; x++){
			for(int y = 0; y < piles[x]; y++){
				g.fillOval(x*(xSpacing)+xOffset, y*(-ySpacing)+yOffset, stoneWidth, stoneHeight);
			}
		}
		
		
	}
	
	private void play(){
		while(true){System.out.println("hi");
			  if(turn == 1){
				  removeStones(bob.move(piles), false);
			  }else if(turn == 2){
				  
			  }
			  
		}
	}
	
	private void removeStones(int[] move, boolean isPlayer){
		System.out.println(piles[0]+""+piles[1]+""+piles[2]+""+piles[3]);
		
		if(isPlayer){
			piles[thePile] -= move[0];
		}else{
			for(int i = 0; i < 4; i++){
				if(piles[i] == move[1]){
					piles[i] -= move[0];
					break;
				}
			}
		}
		System.out.println("stones: "+move[0]+", pile:"+move[1]);
		if(turn == 1)turn = 2;
		else turn = 1;
		repaint();
	}
	
	private void generatePiles(){
		int[] t = {4,4,1,0};
		piles = t;
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		
		JFrame f = new JFrame("Nim");
		g.addMouseMotionListener(g);
		g.addMouseListener(g);
		
		f.getContentPane().add(BorderLayout.CENTER, g);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300,300);
		f.setResizable(false);
		f.setVisible(true);
		
		g.generatePiles();
		g.play();
	}

	public void mouseDragged(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
		
		for(int x = 0; x < 4; x++){
			if(e.getX() > x*(xSpacing)+xOffset && e.getX()< x*(xSpacing)+xOffset+stoneWidth){
				thePile = x;
				break;
			}
			else{
				thePile = 5;
			}
		}
		
		if(thePile != 5){
			for(int y = 0; y < piles[thePile]; y++){
				if(e.getY() > y*(-ySpacing)+yOffset && e.getY()< y*(-ySpacing)+yOffset+stoneHeight){
					theStone = y;
					if(piles[thePile] == 4 && y == 0){
						theStone = 5;
					}
					break;
				}
				else{
					theStone = 5;
				}
			}
			
			repaint();
		}
		//System.out.println(e.getX()+", "+e.getY());
		//System.out.println(thePile+", "+theStone);
	}
	
	public void mouseReleased(MouseEvent arg0) {
		if(theStone != 5){
			if(turn == 2){
				int numStones = piles[thePile] - theStone; 
				int[] move = {numStones, piles[thePile]};
				removeStones(move, true);
				repaint();
			}
			
			
			
		}
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//generatePiles();
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
