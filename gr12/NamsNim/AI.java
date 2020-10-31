/**
 * @(#)NamsNimAI.java
 *
 *
 * @author 
 * @version 1.00 2014/9/29
 */


public class AI {
	
    //#1. num of stones removed #2.num of stones in the pile being removed 
    
	public void random(){
		
	}
	
    public int[] move(int[] p){
    	
    	int[] piles = new int[4];
    	
    	for(int i = 0; i < 4; i++){
    		piles[i] = p[i];
    	}
    	
    	//System.out.println("given: "+piles[0]+", "+piles[1]+", "+piles[2]+", "+piles[3]);
    	//sort piles
    	while(piles[0]>piles[1] || piles[1] > piles[2] || piles[2] > piles[3]){
    		for(int i = 0; i < 3; i++){
    			if(piles[i]>piles[i+1]){
    				int temp = piles[i+1];
    				piles[i+1] = piles[i];
    				piles[i] = temp;
    			}
    		}
    	}
    	
    	
    	
    	int[] move = new int[2];
    	int[][] desired = {//desired conditions that guarantee a winning game if it's opponents turn, no matter how they move the game is won for me
    		{0,0,0,1},
    		{0,1,1,1},
    		{0,0,2,2},
    		{1,1,2,2},
    		{2,2,2,2},
    		{0,0,3,3},
    		{1,1,3,3},
    		{2,2,3,3},
    		{3,3,3,3},
    		{0,1,2,3},
    		{1,2,3,4},
    		{0,2,2,4},
    		{0,3,3,4},
    		{0,0,1,4},
    		{1,1,1,4},
    		{0,1,4,4},
    		{1,4,4,4}
    	};
    	
    	for(int pile = 0; pile < 4; pile++){//looping through each pile in game
    		
    		for(int stones = 1; stones < 4; stones++){//looping through the three possible # of stones removed
    			
    			boolean good = true;//for deciding whether the move matches any desired conditions
    			int[] temp = new int[4];
    			for(int i = 0; i < 4; i++){
    				temp[i] = piles[i];
    			}
    			
    			temp[pile] -= stones;
    			
    			//sort piles
    	    	while(temp[0]>temp[1] || temp[1] > temp[2] || temp[2] > temp[3]){
    	    		for(int i = 0; i < 3; i++){
    	    			if(temp[i]>temp[i+1]){
    	    				int t = temp[i+1];
    	    				temp[i+1] = temp[i];
    	    				temp[i] = t;
    	    			}
    	    		}
    	    	}
    			
    			for(int i = 0; i < 4; i++){
    			//	System.out.print(temp[i]+", ");
    			}
    			//System.out.println("---------------=-");
    			//looping through all desired cases
    			if(temp[pile] >= 0){
	    			for(int pattern = 0; pattern < desired.length; pattern++){
	    				good = true;
	    				
	    				for(int pil = 0; pil < 4; pil++){
							if(temp[pil] != desired[pattern][pil]){
								good = false;
							}//System.out.print(desired[pattern][pil]);
	    				}//System.out.println();
	    				
	    				if(good){//if this boolean remains true, then the pile and stones will be returned
	    					move[0] = stones;
	    					move[1] = piles[pile];
	    					return move;
	    				}
	    			}
    			}
    		}
    	}
    	
    	//if no matching pattern is found the program will take one stone from random pile
    	
    	for(int i = 0; i < 4; i++){
    		//System.out.println(piles[i] > 0);
    		if(piles[i] > 0){
    			move[0] = 1;
    			move[1] = piles[i];
    			break;
    		}
    	}
    	
    	return move;
    }
}