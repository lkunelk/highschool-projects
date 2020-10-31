/*
Actual Biomorph Class
(This is the class for the things that have genes and evolve ect. These are both the children and the parent biomorphs)
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Organism
{
	private static int restrictions[][]={{1,10},{-30,30},{-30,30},{-30,30},{-30,30},{-30,30},{-30,30},{-30,30},{-30,30},{0,20},{1,10}};
	private int[] genes;//What the genes do: 0depth, 1right even vertical, 2right even horizontal, 3right odd vertical, 4right odd horizontal, 5left even vertical, 6left even horizontal, 7left odd vertical, 8left off horizontal, 9colour, 10thickness
	private int generation;
	private boolean isParent;
	private Node head;
	private double[] dimensions={Integer.MAX_VALUE, Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};//{minX,minY,maxX,maxY} a rectangle bounding the organism - for centering purposes
	
	//Start of Constuctor
	//Pre-Condition: Organism was created with int[] genes and int generation
    Organism(int[] forGenes, int gen)
    {
    	generation=gen;
    	genes=forGenes;
    	head=new Node(0,0,0,this);
    }//End of Constructor
    //Post-Conditions: sets generation, genes and head
    
    //Reproduce Method - Purpose: returns a 3 length ArrayList of children with random mutations for use in Screen Class as possible next mutation
    //Pre-Condition: Method was called
    public ArrayList<Organism> reproduce()
    {
    	//This is a parent
    	isParent = true;
    	
    	//Temp values
    	ArrayList children = new ArrayList(3);
    	int len = genes.length;
    	boolean[] chosen = new boolean[len];
    	int g = (int)(Math.random()*len);
    	
    	for(int i = 0; i<3; i++)
    	{
			int[] newGenes = genes.clone();
			int v = Math.random()>.5?1:-1;
			newGenes[g]+=v;
			
			//If it goes over restriction then change the gene the other way
			if(newGenes[g]<restrictions[g][0])newGenes[g]+=2;
			if(newGenes[g]>restrictions[g][1])newGenes[g]-=2;
			
			//Add children Organisms to the ArrayList
			children.add(new Organism(newGenes, generation+1));
			
			//Keep trying
    		do
    		{
    			chosen[g] = true;
    			g = (int)(Math.random()*len);
    		}while(chosen[g]);
    	}	
    	return children;
    }//Post-Condition: Returns ArrayList<Organism> children
    
    //getRestrictions Method - Purpose: Return restrictions int[][]
    //Pre-Condition: Method was called
    public static int[][] getRestrictions()
    {
    	return restrictions;
    }//Post-Condition: Returns restrictions
    
    //isParent Method - Purpose: Check boolean isParent
    //Pre-Condition: Method was called
    public boolean isParent()
    {
    	return isParent;
    }//Post-Condition: Returns boolean isParent
    
    //getGeneration Method - Purpose: Return int generation
    //Pre-Condition: Method was called
    public int getGeneration()
    {
    	return generation;
    }//Post-Condition: Returns int generation
    
    //getDimensions Method - Purpose: Return double[] dimensions
    //Pre-Condition: Method was called
    public double[] getDimensions()
    {
    	return dimensions;
    }//Post-Condition: Returns double[] dimensions
    
    //getHead Method - Purpose: Return Node head
    //Pre-Condition: Method was called
    public Node getHead()
    {
    	return(head);
    }//Post-Condition: Returns Node head
    
    //getGenes Method - Purpose: Return int[] genes
    //Pre-Condition: Method was called
    public int[] getGenes()
    {
    	return genes;
    }//Post-Condition: Returns int[] genes
}//End of Organism Class