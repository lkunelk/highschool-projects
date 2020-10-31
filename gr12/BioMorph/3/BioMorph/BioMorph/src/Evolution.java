/*
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Evolution extends JPanel implements MouseListener, KeyListener, MouseWheelListener {
	
	//Class Variables
	private boolean selectModeOn;
	private boolean animating;
	
	private Thread animator;
	private double ratio=3.0/4.0;
	private double ratio2=1.0/2.0;
	private int animationRate=10;
	
	private Organism parent;
	private ArrayList<Organism> children;
	private ArrayList<Organism> tree=new ArrayList<Organism>();
	
	private Drawing parentDrawing = new Drawing();
	private ArrayList<Drawing> childrenDrawing = new ArrayList<Drawing>();
	
	private JLabel reproduce=new JLabel(new ImageIcon("reproduce.png"));
	private JLabel viewGenes=new JLabel(new ImageIcon("genes.png"));
	private JLabel animation=new JLabel(new ImageIcon("animation.png"));
	
	//Constructor
	Evolution(){
		setLayout(null);
		setBackground(Color.BLACK);
		addKeyListener(this);
		addMouseListener(this);
		
		addMouseWheelListener(this);
		parentDrawing.addMouseWheelListener(this);
		reproduce.addMouseWheelListener(this);
		viewGenes.addMouseWheelListener(this);
		animation.addMouseWheelListener(this);
		
		reproduce.addMouseListener(this);
		viewGenes.addMouseListener(this);
		animation.addMouseListener(this);
	}
	
	//method for drawing parent
	private void drawParent(){
		
		clearScreen();
		parentDrawing.setCurrent(parent);
    	parentDrawing.setBounds(0,0,getWidth(),(int)(getHeight()*ratio));
    	add(parentDrawing);
		
		//Buttons
		reproduce.setBounds((int)((getWidth()/3.0)-250)/2,(int)((getHeight()*ratio)+((getHeight()/4-80)/2)),250,80);
		viewGenes.setBounds((int)((getWidth()-250)/2.0),(int)((getHeight()*ratio)+((getHeight()/4-80)/2)),250,80);
		animation.setBounds((int)(((getWidth()/1.5))+((getWidth()/3-250)/2)),(int)((getHeight()*ratio)+((getHeight()/4-80)/2)),250,80);
		
		add(reproduce);
		add(viewGenes);
		add(animation);
		
		
		repaint();
	}
	
	//method for drawing children
	private void drawChildren(){
		
		selectModeOn = true;
		
		clearScreen();
		
		//draw the parent on top
		parentDrawing=new Drawing();
    	parentDrawing.setBounds(0,0,getWidth(),(int)(getHeight()*ratio2));
    	add(parentDrawing);
		parentDrawing.setCurrent(parent);
		
		//get the children
		children=parent.reproduce();
		childrenDrawing.clear();
		for(int i=0; i<3; i++)
			childrenDrawing.add(new Drawing());
		
		
		//draw the children
		for(int i=0; i<3; i++){
			childrenDrawing.get(i).setBounds(i*getWidth()/3,getHeight()/2,getWidth()/3,getHeight()/2);
    		add(childrenDrawing.get(i));
			childrenDrawing.get(i).setCurrent(children.get(i));
			childrenDrawing.get(i).addMouseListener(this);
		}
		repaint();
		
	}
	
	//method for setting new parent
	public void setParent(Organism p){
		if(p==null)return;
		parent = p;
		tree.add(parent);
		drawParent();
	}
	
	public void setTree(ArrayList<Organism> tree){
		this.tree=tree;
	}
	
	//Method for displaying the organism tree
	private void animate(){
		for(Organism o: tree){
			
			parentDrawing.setCurrent(o);
			
			try
			{
				Thread.sleep(1000/animationRate);
			}
			catch(InterruptedException e)
			{
				animating = false;
				parentDrawing.setCurrent(parent);
				return;
			}	
		}
		animating = false;
	}
	
	//method for clearing screen
	private void clearScreen(){
		removeAll();
		validate();
		repaint();
	}
	
	public Organism getCurrent(){
		return parent;
	}
	
	public ArrayList<Organism> getTree(){
		return tree;
	}
	
	//Key listener method
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==10){
			System.out.println("hello");
		}
	}
	
	//Mouse listener method
	public void mouseReleased(MouseEvent e) {
		
		if(animating){
			System.out.println("anim: "+animating);
			animator.interrupt();
		}
		else if(selectModeOn){
			for(int i=0; i<3; i++)
				if(e.getSource() == childrenDrawing.get(i)){
					setParent(children.get(i));
					selectModeOn = false;
				}
		}
		else{
			if(e.getSource() == reproduce)
			{
				drawChildren();
			}
			else if(e.getSource() == viewGenes)
			{
				System.out.println("view genes!");
				JOptionPane.showMessageDialog(this, Arrays.toString(parent.getGenes()),"Genes",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(e.getSource() == animation && !animating)
			{
				animating = true;
				
				System.out.println("let's watch anime!");
				animator = new Thread(){
					public void run(){
						animate();
					}
				};
				
				animator.start();
			}
		}
	}	
	
	public void mouseWheelMoved(MouseWheelEvent e) {
		int delta = e.getWheelRotation()*3;
		parentDrawing.changeScale(delta);
		for(Drawing d: childrenDrawing)
			d.changeScale(delta);
	}
	
	//unused keylistener methods
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	//other mouselisteners methods the program doesn't use
	public void mousePressed(MouseEvent e) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mouseClicked(MouseEvent e) {}
}//end class