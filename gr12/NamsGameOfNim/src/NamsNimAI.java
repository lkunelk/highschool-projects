/**
 * @(#)NamsNimAI.java
 *
 *
 * @author 
 * @version 1.00 2014/9/29
 */


public class NamsNimAI {

    public NamsNimAI() {
    }
    //#1. num of stones removed #2.num of stones in the pile being removed 
    
    public int[] move(int[] piles){
    	int[] move = new int[2];
    	int[][] desired = {
    		{0,0,0,1},
    		{0,0,2,2},
    		{0,0,3,2},
    		{0,1,1,1},
    		{0,0,1,4},
    		{1,1,1,4};
    	}
    	
    	for(int pile = 0; pile < 4; pile++){
    		for(int stones = 1; stones <= 4; stones++){
    			//looping through all desired cases
    			for(int pattern = 0; pattern < desired.length; pattern++){
    				if()
    			}
    			
    		}
    	}
    	
    	return move;
    }
}