/*
 * Evolution class
 * purpose: class that holds all the components together, represents the evolution process
 *          contains all the listeners for user input and interaction
*/

//importing
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Evolution extends JPanel implements MouseListener, KeyListener, MouseWheelListener
{
	
	//Class Variables
	private boolean selectModeOn; //for program to know when the user has a choice to select children
	private boolean animating; //lets program know when animation is taking place
	
	private Thread animator; //thread for animating
	private double ratio=3.0/4.0; //ratio for placing buttons
	private double ratio2=1.0/2.0; //ratio for placing organisms
	private int animationRate=5; //speed of the animation
	
	private Organism parent; //the current organism
	private ArrayList<Organism> children; //children of the current organism
	private ArrayList<Organism> tree=new ArrayList<Organism>(); //all the ancestors of the current organism
	
	private Drawing parentDrawing; //drawing of the parent
	private ArrayList<Drawing> childrenDrawing=new ArrayList<Drawing>();// drawing of the children
	
	private JLabel reproduce=new JLabel(new ImageIcon(getClass().getResource("reproduce.png")));
	private JLabel viewGenes=new JLabel(new ImageIcon(getClass().getResource("genes.png")));
	private JLabel animation=new JLabel(new ImageIcon(getClass().getResource("animation.png")));
	
	//Constructor
	Evolution()
	{
		//Create new drawing
		parentDrawing=new Drawing(this);
		
		setLayout(null);
		setBackground(Color.BLACK);
		
		//Adding various listeners to the buttons and the jpanel
		addKeyListener(this);
		parentDrawing.addKeyListener(this);
		reproduce.addKeyListener(this);
		viewGenes.addKeyListener(this);
		animation.addKeyListener(this);
		
		addMouseWheelListener(this);
		parentDrawing.addMouseWheelListener(this);
		reproduce.addMouseWheelListener(this);
		viewGenes.addMouseWheelListener(this);
		animation.addMouseWheelListener(this);
		
		addMouseListener(this);
		reproduce.addMouseListener(this);
		viewGenes.addMouseListener(this);
		animation.addMouseListener(this);
	}//end Constructor
	
	//drawParent method- purpose: for drawing parent
	//Pre-condition: parent can't be null
	//Postcondition: draws the parent organism on the screen
	private void drawParent(){
		clearScreen();
		
		//Adding drawing to the panel
		parentDrawing.setCurrent(parent);
    	parentDrawing.setBounds(0,0,getWidth(),(int)(getHeight()*ratio));
    	add(parentDrawing);
		
		//Placing Buttons
		reproduce.setBounds((int)((getWidth()/3.0)-250)/2,(int)((getHeight()*ratio)+((getHeight()/4-80)/2)),250,80);
		viewGenes.setBounds((int)((getWidth()-250)/2.0),(int)((getHeight()*ratio)+((getHeight()/4-80)/2)),250,80);
		animation.setBounds((int)(((getWidth()/1.5))+((getWidth()/3-250)/2)),(int)((getHeight()*ratio)+((getHeight()/4-80)/2)),250,80);
		add(reproduce);
		add(viewGenes);
		add(animation);
		
		repaint();
	}//end drawParent()
	
	//drawChildren method - purpose: for drawing children
	//Pre-condition:children array can't be null, or its values can't be null
	//Postcondition:draws the parent and 3 children on the screen
	private void drawChildren()
	{
		selectModeOn = true;//the user is choosing organisms on the screen
		
		clearScreen();
		
		//draw the parent on top
		parentDrawing=new Drawing(this);
    	parentDrawing.setBounds(0,0,getWidth(),(int)(getHeight()*ratio2));
    	add(parentDrawing);
		parentDrawing.setCurrent(parent);
		
		//get the children
		children=parent.reproduce();
		childrenDrawing.clear();
		for(int i=0; i<3; i++)
			childrenDrawing.add(new Drawing(this));
		
		
		//draw the children at the bottom
		for(int i=0; i<3; i++){
			childrenDrawing.get(i).setBounds(i*getWidth()/3,getHeight()/2,getWidth()/3,getHeight()/2);
    		add(childrenDrawing.get(i));
			childrenDrawing.get(i).setCurrent(children.get(i));
			childrenDrawing.get(i).addMouseListener(this);
		}
		
		repaint();
	}//end drawChildren()
	
	//setParent method - purpose: for setting new parent
	//Pre-condition: Organism oject can't be null
	//Postcondition: sets the new parent and draws it on screen
	public void setParent(Organism p)
	{
		if(p==null)return;
		parent = p;
		tree.add(parent);
		drawParent();
		selectModeOn=false;
	}//end setParent()
	
	//setTree method - purpose: for drawing parent
	//Pre-condition: tree can't be null
	//Postcondition: sets the current tree to a new tree
	public void setTree(ArrayList<Organism> tree)
	{
		if(tree!=null)this.tree=tree;
	}//end setTree();
	
	//animate method - purpose: for displaying the organism tree
	//Pre-condition:tree is not null
	//Postcondition:paint drawings of all organism in the tree in order
	private void animate()
	{
		for(Organism o: tree)//for each organism in the tree
		{
			parentDrawing.setCurrent(o);//set the current drawing
			
			try
			{
				Thread.sleep(1000/animationRate);//pausing
			}
			catch(InterruptedException e)//if interrupted by user then stop animating
			{
				//animtaion is finished
				animating = false;
				parentDrawing.setCurrent(parent);
				return;
			}	
		}
		//animtaion is finished
		animating = false;
	}//end animating()
	
	//clearScreen for clearing screen
	//Pre-condition:none
	//Postcondition:clears screen
	private void clearScreen()
	{
		removeAll();
		validate();
		repaint();
	}
	
	//getCurrent method
	//Pre-condition:none
	//Postcondition:returns the parent
	public Organism getCurrent()
	{
		return parent;
	}//end getCurrent()
	
	//getTree method
	//Pre-condition:none
	//Postcondition:returns tree
	public ArrayList<Organism> getTree()
	{
		return tree;
	}//end getTree()
	
	//selectMode method
	//Pre-condition: none
	//Postcondition: returns boolean representing whether selectMode is on
	public boolean selectMode()
	{
		return selectModeOn;
	}
	
	//keyReleased method
	public void keyReleased(KeyEvent e)
	{
		if(animating)//is it doing an animation?
		{
			animator.interrupt();//stop the animation
		}
		else if(selectModeOn)//is user in selection mode?
		{
			if(e.getKeyCode()==49)//'1' as in first child
			{
				setParent(children.get(0));
				selectModeOn = false;
			}
			else if(e.getKeyCode()==50)//'2' as in second child
			{
				setParent(children.get(1));
				selectModeOn = false;
			}
			else if(e.getKeyCode()==51)//'3' as in third child
			{
				setParent(children.get(2));
				selectModeOn = false;
			}
		}
		else
		{
			if(e.getKeyCode()==82)//r as in reproduce
			{
				drawChildren();//reproducing children
			}
			else if(e.getKeyCode()==71)//g as in genes
			{
				JOptionPane.showMessageDialog(this,"Depth: "+(parent.getGenes()[0])+
				"\nVertical Translation - Right Branches, Even Levels: "+(parent.getGenes()[1])+
				"\nHorizontal Translation - Right Branches, Even Levels: "+(parent.getGenes()[2])+
				"\nVertical Translation - Right Branches, Odd Levels: "+(parent.getGenes()[3])+
				"\nHorizontal Translation - Right Branches, Odd Levels: "+(parent.getGenes()[4])+
				"\nVertical Translation - Left Branches, Even Levels: "+(parent.getGenes()[5])+
				"\nHorizontal Translation - Left Branches, Even Levels: "+(parent.getGenes()[6])+
				"\nVertical Translation - Left Branches, Odd Levels: "+(parent.getGenes()[7])+
				"\nHorizontal Translation - Left Branches, Odd Levels: "+(parent.getGenes()[8])+
				"\nColor: "+(parent.getGenes()[9])+"\nThickness: "+(parent.getGenes()[10]),"Genes",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(e.getKeyCode()==65 && !animating)//a as in watch anime
			{
				animating = true;
				
				System.out.println("Now watching anime! =^.^=");
				animator = new Thread(){
					public void run(){
						animate();
					}
				};
				
				animator.start();
			}
		}
	}
	
	//mouseReleased method
	public void mouseReleased(MouseEvent e)
	{
		if(animating)
		{
			//stop animation
			animator.interrupt();
		}
		else if(selectModeOn)
		{
			//checking which drawing was clicked
			for(int i=0; i<3; i++)
				if(e.getSource()==childrenDrawing.get(i))
				{
					//setting the parent to the child that was clicked
					setParent(children.get(i));
				}
		}
		else
		{
			if(e.getSource()==reproduce)//if reproduce was pressed
				drawChildren();
				
			else if(e.getSource()==viewGenes)//display genes
				JOptionPane.showMessageDialog(this,"Depth: "+(parent.getGenes()[0])+
				"\nVertical Translation - Right Branches, Even Levels: "+(parent.getGenes()[1])+
				"\nHorizontal Translation - Right Branches, Even Levels: "+(parent.getGenes()[2])+
				"\nVertical Translation - Right Branches, Odd Levels: "+(parent.getGenes()[3])+
				"\nHorizontal Translation - Right Branches, Odd Levels: "+(parent.getGenes()[4])+
				"\nVertical Translation - Left Branches, Even Levels: "+(parent.getGenes()[5])+
				"\nHorizontal Translation - Left Branches, Even Levels: "+(parent.getGenes()[6])+
				"\nVertical Translation - Left Branches, Odd Levels: "+(parent.getGenes()[7])+
				"\nHorizontal Translation - Left Branches, Odd Levels: "+(parent.getGenes()[8])+
				"\nColor: "+(parent.getGenes()[9])+"\nThickness: "+(parent.getGenes()[10]),"Genes",JOptionPane.INFORMATION_MESSAGE);
			
			else if(e.getSource()==animation && !animating)//animating the organisms development
			{
				animating=true;
				System.out.println("let's watch anime!");
				animator=new Thread()
				{
					public void run()
					{
						animate();
					}
				};
				animator.start();
			}
		}	
	}//end mouseReleased()
	
	//mouseEntered method
	public void mouseEntered(MouseEvent e){
		if(e.getSource()==reproduce ||e.getSource()==viewGenes || e.getSource()==animation) this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		else this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			
		for(int x=0; x<childrenDrawing.size(); x++)//checking if mouse is over any children drawing
			if(e.getSource()==childrenDrawing.get(x))
				this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}//end mouseEntered()
	
	//mouseExited method
	public void mouseExited(MouseEvent e){
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}//end mouseExited()
	
	//mouseWheelMoved method
	public void mouseWheelMoved(MouseWheelEvent e) 
	{
		int delta = e.getWheelRotation();//gives 1 or -1
		parentDrawing.changeScale(delta);//scale the drawing
		for(Drawing d: childrenDrawing)//scale each children drawing
			d.changeScale(delta);
	}//end mouseWheelMoved()
	
	//unused keylistener methods
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	//other mouselisteners methods the program doesn't use
	public void mousePressed(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
}//end class