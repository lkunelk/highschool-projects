/**
 * @(#)TestyProgram.java
 *
 * TestProgram application
 *
 * @author 
 * @version 1.00 2013/11/28
 */
import java.io.*;
 
public class TestyProgram {
    
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	while(true){
    		double x = Math.random();
    		System.out.print((byte)(x*2)+" ");System.out.println(x);
    		br.readLine();
    	}
    		

    
    	
}
}