/**
 * @(#)S3.java
 *
 *
 * @author 
 * @version 1.00 2014/10/8
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class S3 {

	boolean tracing = true;
	Scanner sc = new Scanner("S3.txt");
	Stack top, side;
	
	public static void main(String[] args){
		new S3();
	}
	
    public S3() {
    	for(int a = 0; a < 1; a++){
    		
    		int trains = sc.nextInt();
    		trace(""+trains);
    		
    		for(; i <0;i++){
    			try{
    				top.push(sc.nextInt());
    			}catch(Exception e){
    			}
    		}
    		
    	}
    	
    }
    
    public String trace(String x){
    	if(tracing)System.out.println(x);
    }
}