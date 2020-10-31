/**
 * @(#)Player.java
 *
 *
 * @author 
 * @version 1.00 2013/11/26
 */


public class Player
{
	int number = 0;
	
	public void guess()
	{
		number = (int)(Math.random()*10);
		System.out.println("I'm guessing "+number);
	}
}