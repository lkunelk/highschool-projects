/*
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
//The actual biomorph class
public class Organism
{
	private final int depthRestrict = 10;//so that organisms can't get any bigger
	private final int lengthRestrict = 50;
	private int[] genes;//0depth, 1right even vertical, 2right even horizontal, 3right odd vertical, 4right odd horizontal, 5left even vertical, 6left even horizontal, 7left odd vertical, 8left off horizontal, 9colour, 10thickness
	private int generation;
	private Node head;
	private int[] dimensions =  {Integer.MAX_VALUE, Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};//{minX,minY,maxX,maxY} a rectangle bounding the organism - for centering purposes
	
    Organism(int[] forGenes, int gen)
    {
    	generation = gen;
    	genes=forGenes;
    	head=new Node(0,0,0, this);
    }
    
    public ArrayList<Organism> reproduce()//returns a 3 length ArrayList of children with random mutations
    {
    	ArrayList toReturn = new ArrayList(3);
    	boolean[] chosen = new boolean[genes.length];
    	
    	for(int i = 0; i<3; i++){
    		int toMutate = (int)(Math.random()*genes.length);
    		while(chosen[toMutate])
    			chosen[toMutate] = true;
    	}
    	
    	return toReturn;
    }
    
    public int getGeneration()
    {
    	return generation;
    }
    
    public int[] getDimensions()
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