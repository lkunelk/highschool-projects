//import classes
import java.util.ArrayList;
import java.util.Collections;


public class BubbleSort {
	
	//class variables
	private ArrayList<Colour> array = new ArrayList<Colour>();
	private ArrayList<Integer> element1 = new ArrayList<Integer>();
	private ArrayList<Integer> element2 = new ArrayList<Integer>();
	
	//constructor
	BubbleSort(ArrayList<Colour> ar){
		//copy the array
		for(Colour c: ar){
			array.add(c);
		}
	}//end constructor
	
	//method for creating steps for sorting the array
	public void sort(){
		
		//reset solution
		element1 = new ArrayList<Integer>();
		element2 = new ArrayList<Integer>();
		
		//sort
		for(int top = array.size()-1;top > 0; top--){
    		for(int i = 0; i < top; i++){
    			
    			//if element to the right is bigger than the current
    			if(array.get(i).compareTo(array.get(i+1)) > 0){
    				
    				//switch the colours
    				Colour t = array.get(i);
    				array.set(i,array.get(i+1));
    				array.set(i+1, t);
    				
    				//add it to the steps
    				element1.add(i);
    				element2.add(i+1);
    			}
    		}
    	}
	}//end sort()
	
	//get method
	public ArrayList<Integer> getElement1(){
		return element1;
	}//end getElement1()
	
	//get method
	public ArrayList<Integer> getElement2(){
		return element2;
	}//end getElement2()
	
	//set method
	public void setArray(ArrayList<Colour> ar){
		//copy the array
		for(Colour c: ar){
			array.add(c);
		}
	}//end setArray()
	
	
}//end class
