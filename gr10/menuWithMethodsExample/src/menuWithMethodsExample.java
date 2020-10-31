/**
 * @(#)menuWithMethodsExample.java
 *
 * menuWithMethodsExample application
 *
 * @author
 * @version 1.00 2008/9/26
 */
import java.io.*;

public class menuWithMethodsExample
{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception
   	{
    	new menuWithMethodsExample();
    }

    menuWithMethodsExample() throws Exception
    {
    	char choice;

    	title();
    	pause();
    	do
    	{
    		clear();
    		menu();
    		choice = br.readLine().charAt(0);
    		clear();
    		switch(choice)
    		{
    			case 'i':
    			case 'I':
    				instructions();
    				break;
    			case 'r':
    			case 'R':
    				play();
    				break;
    			case 'x':
    			case 'X':
    				exit();
    				break;
    			default:
    				System.out.println("Duh!");
    		}
    		pause();
    	}while(choice!='x'&&choice!='X');
    }

    public void clear()
    {
    	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void pause() throws Exception
    {
    	System.out.print("Please press the ENTER key to continue...");
    	br.readLine();
    }

    public void title()
    {
    	System.out.println("Title would go here");
    }

    public void menu()
    {
    	System.out.println("A menu similar to this would go here");
    	System.out.println("I) Instructions");
    	System.out.println("R) Run the program");
    	System.out.println("X) Exit the program");
    	System.out.print("Enter your choice: ");
    }

    public void instructions()
    {
    	System.out.println("Instructions screen would go here");
    }

    public void play()
    {
    	System.out.println("The code for running the program would go here");
    }

    public void exit()
    {
    	System.out.println("Exit screen would go here");
    }

}
