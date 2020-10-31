/**
 * @(#)Battleship.java
 *
 * Battleship application
 *
 * @author 
 * @version 1.00 2013/11/29
 */

import java.util.*;

public class Battleship {
	
	private ArrayList<Ship> shipList = new ArrayList<Ship>();
	private GameHelper helper = new GameHelper();
	private int numOfGuesses = 0;
	
	private void setUpGame() {
		//first make some ships and give them locations
		Ship one = new Ship();
		one.setName("Titanic");
		Ship two = new Ship();
		two.setName("Red Rose");
		Ship three = new Ship();
		three.setName("Blue Whale");
		shipList.add(one);
		shipList.add(two);
		shipList.add(three);
		
		System.out.println("Your goal is to sink three ships.");
		System.out.println("Titanic, Red Rose, Blue Whale.");
		System.out.println("Try to sink them all in the fewest number of guesses.");
		
		for(Ship shipToSet : shipList) {
			ArrayList<String> newLocation = helper.placeShip(3);
			shipToSet.setLocationCells(newLocation);
		}//end loop
	}//end setUpGame()
	
	private void startPlaying() {
		while(!shipList.isEmpty()) {
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}//end while
		finishGame();
	}//end startPlaying()
	
	private void finishGame() {
		System.out.println("All ships are dead!");
		if(numOfGuesses <= 18) {
			System.out.println("It only took you "+numOfGuesses+" guesses.");
			System.out.println("You are the king of the sea.");
		}else {
			System.out.println("Took youo long enough. "+ numOfGuesses+" guesses.");
			System.out.println("Nect will be your day.");
		}
	}
	
	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result = "miss";
		
		for(Ship shipToTest : shipList) {
			result = shipToTest.checkYourself(userGuess);
			
			if(result.equals("hit")) {
				break;
			}
			if(result.equals("kill")) {
				shipList.remove(shipToTest);
				break;
			}
		}//end for
		System.out.println(result);
	}
	
	public static void main(String[] args){
		Battleship game = new Battleship();
		game.setUpGame();
		game.startPlaying();
	}//end main()
	
}//end class