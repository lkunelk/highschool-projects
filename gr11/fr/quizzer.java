/**
 * @(#)quizzer.java
 *
 *
 * @author 
 * @version 1.00 2013/11/4
 */
import java.io.*;

public class quizzer 
{

    public quizzer() throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int word;
    	 while(true)
    	 {
    	 	word=(int)(Math.random()*10+1);
    	 	
    	 	if(word == 1)
    	 	{
    	 		System.out.print("je");
    	 	}
    	 		
    	 	br.readLine();
    	 }
    }
    
    
    
}