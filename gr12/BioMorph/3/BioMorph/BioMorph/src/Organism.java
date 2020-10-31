
import javax.swing.*;
import java.awt.*;
import java.util.*;

//Actual Biomorph Class
public class Organism
{
	private int restrictions[][]={{1,10},{-30,30},{-30,30},{-30,30},{-30,30},{-30,30},{-30,30},{-30,30},{-30,30},{0,20},{1,10}};
	private int[] genes;//0depth, 1right even vertical, 2right even horizontal, 3right odd vertical, 4right odd horizontal, 5left even vertical, 6left even horizontal, 7left odd vertical, 8left off horizontal, 9colour, 10thickness
	private int generation;
	private Node head;
	private double[] dimensions={Integer.MAX_VALUE, Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};//{minX,minY,maxX,maxY} a rectangle bounding the organism - for centering purposes
	
    Organism(int[] forGenes, int gen)
    {
    	generation=gen;
    	genes=forGenes;
    	head=new Node(0,0,0,this);
    }
    
    public ArrayList<Organism> reproduce()//returns a 3 length ArrayList of children with random mutations
    {
    	ArrayList children = new ArrayList(3);
    	int len = genes.length;
    	boolean[] chosen = new boolean[len];
    	
    	int g = (int)(Math.random()*len);
    	
    	for(int i = 0; i<3; i++){
    		
    		
			int[] newGenes = genes.clone();
			
			int v = Math.random()>.5?1:-1;
			newGenes[g]+=v;
			
			//if goes over restriction then change the gene the other way
			if(newGenes[g]<restrictions[g][0])newGenes[g]+=2;
			if(newGenes[g]>restrictions[g][1])newGenes[g]-=2;
			
			
			children.add(new Organism(newGenes, generation+1));
			
    		do{
    			chosen[g] = true;
    			g = (int)(Math.random()*len);
    		}while(chosen[g]);
    	}
    			
    	return children;
    }
   
    
    public int getGeneration()
    {
    	return generation;
    }
    
    public double[] getDimensions()
    {
    	return dimensions;
    }
    
    public Node getHead()
    {
    	return(head);
    }
    
    public int[] getGenes()
    {
    	return genes;
    }
}