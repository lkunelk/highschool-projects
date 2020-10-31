import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Evolution extends JPanel implements MouseListener, KeyListener{
	
	//class variables
	private boolean selectModeOn;
	private double ratio = 3.0/4.0;
	private int animationRate = 10;
	
	private Organism parent;
	private ArrayList<Organism> children;
	private ArrayList<Organism> tree = new ArrayList<Organism>();
	
	private Drawing parentDrawing;
	private ArrayList<Drawing> childrenDrawing;
	
	private JLabel reproduce=new JLabel(new ImageIcon("reproduce.png"));
	private JLabel viewGenes=new JLabel(new ImageIcon("genes.png"));
	private JLabel animation=new JLabel(new ImageIcon("animation.png"));
	
	//constructor
	Evolution(){
		setLayout(null);
		setBackground(Color.BLACK);
		addKeyListener(this);
		
		reproduce.addMouseListener(this);
		viewGenes.addMouseListener(this);
		animation.addMouseListener(this);
	}
	
	//method for drawing parent
	private void drawParent(){
		
		clearScreen();
		
    	parentDrawing=new Drawing();
    	parentDrawing.setBounds(0,0,getWidth(),(int)(getHeight()*ratio));
    	add(parentDrawing);
		parentDrawing.setCurrent(parent);
		
		//Buttons
		reproduce.setBounds((int)((getWidth()/3)-250)/2,(int)((getHeight()*ratio)+((getHeight()/4-80)/2)),250,80);
		viewGenes.setBounds((int)((getWidth()-250)/2),(int)((getHeight()*ratio)+((getHeight()/4-80)/2)),250,80);
		animation.setBounds((int)(((getWidth()/1.5))+((getWidth()/3-250)/2)),(int)((getHeight()*ratio)+((getHeight()/4-80)/2)),250,80);
		
		add(reproduce);
		add(viewGenes);
		add(animation);
		repaint();
	}
	
	//method for drawing children
	private void drawChildren(){
		
		clearScreen();
		
	}
	
	//method for reproducing the parent
	private void reproduce(){
		
		System.out.println(Arrays.toString(parent.getGenes()));
		parent.getGenes()[((int)(Math.random()*11))]+=(int)(Math.random()*100)%2==0?1:-1;
		parent = new Organism(parent.getGenes(), 1);
		System.out.println(Arrays.toString(parent.getGenes()));
		tree.add(parent);
		drawParent();
	}
	
	//method for setting new parent
	public void setParent(Organism p){
		if(p==null)return;
		parent = p;
		tree.add(parent);
		drawParent();
	}
	
	//Method for displaying the organism tree
	private void animate(){
		for(Organism o: tree){
			parent = o;
			parentDrawing.setCurrent(parent);
			try{Thread.sleep(1000/animationRate);}catch(Exception e){}
		}
	}
	
	//method for clearing screen
	private void clearScreen(){
		removeAll();
		validate();
		repaint();
	}
	
	//Key listener method
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==10){
			System.out.println("hello");
		}
	}
	
	//Mouse listener method
	public void mousePressed(MouseEvent e) {
	}
	
	//unused keylistener methods
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	//other mouselisteners methods the program doesn't use
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == reproduce){
			for(int i = 0; i < 20; i++)reproduce();
		}
		else if(e.getSource() == viewGenes){
			System.out.println("view genes!");
			JOptionPane.showMessageDialog(this, Arrays.toString(parent.getGenes()),"Genes",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == animation){
			System.out.println("let's watch anime!");
			new Thread(){
				public void run(){
					animate();
				}
			}.start();
		}
	}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}//end class
