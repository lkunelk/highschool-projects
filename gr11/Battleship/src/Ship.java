/**
 * @(#)Ship.java
 *
 *
 * @author 
 * @version 1.00 2013/11/29
 */

import java.util.*;

public class Ship {
	
	private ArrayList<String> locationCells;
	private String name;
	
	public void setLocationCells(ArrayList<String> locs) {
		locationCells = locs;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public String checkYourself(String userInput) {
		String result = "miss";
		int index = locationCells.indexOf(userInput);
		
		if(index >= 0) {
			locationCells.remove(index);
			
			if(locationCells.isEmpty()) {
				result = "kill";
				System.out.println("Ouch! you sunk "+name+" :(");
			}else {
				result = "hit";
			}//end if
		}//end if
		
		return result;
			
	}//end checkYourself()
}//end class