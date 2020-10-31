/**
 * @(#)triangleCalculator.java
 *
 * triangleCalculator application
 *	this program accepts measures of sides and angles of a triangle then step by step shows how to solve for the unknown and displays the result.
 *	It uses the trigonometric laws to make the calculations.
 *
 * @Nam Nguyen 
 * @version 1.00 
 *	started 2013/5/21
 *	finished 2013/5/
 */
 
import java.io.*;
 
public class triangleCalculator {

    public static void main(String[] args)throws Exception {
    	
	    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	    double A = 0, B = 0, C = 0;
	    double a =	0, b = 0, c = 0;
	    double[] num = new double[6];
	    boolean valid;
	    
	    
	   	do
	   	{
	   		A = B = C = a = b = c = 0;
	   		
	   		clear(0);clear(0);
	   		displayTri(a, b, c, A, B, C);
		   	System.out.println("please enter angle A");
	    	A = Double.parseDouble(br.readLine());
	    	
	    	displayTri(a, b, c, A, B, C);
	    	System.out.println("please enter angle B");
	    	B = Double.parseDouble(br.readLine());
	    	
	    	displayTri(a, b, c, A, B, C);
	    	System.out.println("please enter angle C");
	    	C = Double.parseDouble(br.readLine());
	    	
	    	displayTri(a, b, c, A, B, C);
	    	System.out.println("please enter side a");
	    	a = Double.parseDouble(br.readLine());
	    	
	    	displayTri(a, b, c, A, B, C);
	    	System.out.println("please enter side b");
	    	b = Double.parseDouble(br.readLine());
	    	
	    	displayTri(a, b, c, A, B, C);
	    	System.out.println("please enter side c");
	    	c = Double.parseDouble(br.readLine());
	    		
	    		if(A==90 || B==90 || C==90)
	    		{
	    			calculateRightTri(a, b, c, A, B, C, br, false, num);
	    		}
	    		else
	    		{
	    			calculateOtherTri(a, b, c, A, B, C, br, false, num);
	    		}
	   	}
    	while(!false);
    }//END OF main()
    

    
    //METHOD FOR CALCULATING RIGHT TRIANGLES
    static void calculateRightTri(double a, double b, double c, double A, double B, double C, BufferedReader br, boolean check, double[] num)throws Exception {
    	boolean tracing = false;
    	int side =0;
    	int angle =0;
    	int number=0;
    //______________________________________________________________________________________________
    	displayResult(false, a, b, c, A, B, C);
    	mid("          This is a right triangle, so you will be using sine, cosine and tangent functions");
     	br.readLine();
     //______________________________________________________________________________________________
     		
    	do
    	{	
    		side =0;
    		angle =0;
    		
	    	if(A>0)
	    		angle++;
	    	if(B>0)
	    		angle++;
	    	if(C>0)
	    		angle++;
	    	
	    	if(a>0)
	    		side++;
	    	if(b>0)
	    		side++;
	    	if(c>0)
	    		side++;
     		
    		if(side==2)
    		{
    			if(A==90)
    			{
    				if(a==0)
    				{
    					//______________________________________________________________________________________________
    					clear(0);
    					mid("                 Solve side 'a' using pythagorean theorem");
     					br.readLine();
     					//______________________________________________________________________________________________
    					a = Math.sqrt(b*b + c*c);
    				}
    				else if(b==0)
    				{
    					//______________________________________________________________________________________________
    					clear(0);
    					mid("                 Solve side 'b' using pythagorean theorem");
     					br.readLine();
     					//______________________________________________________________________________________________
    					
    					b = Math.sqrt(a*a - c*c);
    				}
    					
    				else if(c==0)
    				{
    					//______________________________________________________________________________________________
    					clear(0);
    					mid("                 Solve side 'c' using pythagorean theorem");
     					br.readLine();
     					//______________________________________________________________________________________________
    					
    					c = Math.sqrt(a*a - b*b);
    				}
    				
    			}
    				
    					
    			
    			if(B==90)
    			{
    				if(b==0)
    				{
    					//______________________________________________________________________________________________
    					clear(0);
    					mid("                 Solve side 'b' using pythagorean theorem");
     					br.readLine();
     					//______________________________________________________________________________________________
    					
    					b = Math.sqrt(a*a + c*c);
    				}
    					
    				else if(a==0)
    				{
    					//______________________________________________________________________________________________
    					clear(0);
    					mid("                 Solve side 'a' using pythagorean theorem");
     					br.readLine();
     					//______________________________________________________________________________________________
    					
    					a = Math.sqrt(b*b - c*c);
    				}
    					
    				else if(c==0)
    				{
    					//______________________________________________________________________________________________
    					clear(0);
    					mid("                 Solve side 'c' using pythagorean theorem");
     					br.readLine();
     					//______________________________________________________________________________________________
    					
    					c = Math.sqrt(b*b - a*a);
    				}	
    			}
    				
    					
    					
    			if(C==90)
    			{
    				if(c==0)
    				{
    					//______________________________________________________________________________________________
    					clear(0);
    					mid("                 Solve side 'c' using pythagorean theorem");
     					br.readLine();
     					//______________________________________________________________________________________________
    					
    					c = Math.sqrt(b*b + a*a);
    				}
    					
    				else if(b==0)
    				{
    					//______________________________________________________________________________________________
    					clear(0);
    					mid("                 Solve side 'b' using pythagorean theorem");
     					br.readLine();
     					//______________________________________________________________________________________________
    					
    					b = Math.sqrt(c*c - a*a);
    				}
    					
    				else if(a==0)
    				{
    					//______________________________________________________________________________________________
    					clear(0);
    					mid("                 Solve side 'a' using pythagorean theorem");
     					br.readLine();
     					//______________________________________________________________________________________________
    					
    					a = Math.sqrt(c*c - b*b);
    				}	
    			}
    				
				displayResult(true, a, b, c, A, B, C);
				br.readLine();	
    		}		
	    		
    	
    		if(angle == 2)
    		{
    			displayResult(false, a, b, c, A, B, C);
    			mid("Since there are 2 angles given, you can use the 180 degree theorem to find the 3rd angle");
    			br.readLine();
    			
    			if(A==0)
    			{
					//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'A' using 180 degree theorem");
     				br.readLine();
     				//______________________________________________________________________________________________
    				
    				A = 180 - B - C;
    			}
    			if(B==0)
    			{
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'B' using 180 degree  theorem");
     				br.readLine();
     				//______________________________________________________________________________________________
    				
    				
    				B = 180 - A - C;
    			}
    			if(C==0)
    			{
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'C' using 180 degree  theorem");
     				br.readLine();
     				//______________________________________________________________________________________________
    				
    				
    				C = 180 - B - A;
    			}	
    				
	    		displayResult(true, a, b, c, A, B, C);
	    		br.readLine();
	
    		}
    		
    		
    		if(A==90)
    		{
    			number=0;
    				if(B>0)//Tangent
    			{
    				number++;
    			}
    			if(c>0)
    			{
    				number++;
    			}
    			if(b>0)
    			{
    				number++;
    			}
    			if(number==2)
    			{
    				
    				if(B==0){B=tanAngle(b, c, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'B' using Tan function");
     				br.readLine();
     				//______________________________________________________________________________________________
     				}
    				if(c==0){c=tanSide(b, c, B, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'c' using Tan function");
     				br.readLine();
     				//______________________________________________________________________________________________
     				}
	    			if(b==0){b=tanSide(b, c, B, br);
	    			//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'b' using Tan function");
     				br.readLine();
     				//______________________________________________________________________________________________
     				}
     				displayResult(true, a, b, c, A, B, C);
	    			br.readLine();
    			}
    			
    			number=0;
    			if(B>0)//Sine
    			{
    				number++;
    			}
    			if(a>0)
    			{
    				number++;
    			}
    			if(b>0)
    			{
    				number++;
    			}
    			if(number==2)
    			{
    				if(B==0){B=sinAngle(b, a, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'B' using Sin function");
     				br.readLine();
     				//______________________________________________________________________________________________
     				}
    				if(a==0){a=sinSide(b, a, B, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'a' using Sin function");
     				br.readLine();
     				//______________________________________________________________________________________________
     				}
    				if(b==0){b=sinSide(b, a, B, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'b' using Sin function");
     				br.readLine();
     				//______________________________________________________________________________________________
     				}
     				displayResult(true, a, b, c, A, B, C);
	    			br.readLine();
    			}
    			
    			number=0;
    			
    			if(B>0)//Cosine
    			{
    				number++;
    			}
    			if(a>0)
    			{
    				number++;
    			}
    			if(c>0)
    			{
    				number++;
    			}
    			if(number==2)
    			{
    				
    				if(B==0){B=cosAngle(c, a, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'B' using Cos function");
     				br.readLine();
     				//______________________________________________________________________________________________
     				}
    				if(a==0){a=cosSide(c, a, B, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'a' using Cos function");
     				br.readLine();
     				//______________________________________________________________________________________________
     				}
	    			if(c==0){c=cosSide(c, a, B, br);
	    			//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'c' using Cos function");
     				br.readLine();
     				//______________________________________________________________________________________________
     				}
    			}
    			displayResult(true, a, b, c, A, B, C);
	    		br.readLine();
    		}//END IF FOR ANLGE A
    		
    		if(B==90)
    		{
    			number=0;
    			if(C>0)//Tangent
    			{
    				number++;
    			}
    			if(a>0)
    			{
    				number++;
    			}
    			if(c>0)
    			{
    				number++;
    			}
    			if(number==2)
    			{
    				if(C==0){C=tanAngle(c, a, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'C' using Tan function");
     				br.readLine();
     				//______________________________________________________________________________________________
     				}
    				if(a==0){a=tanSide(c, a, C, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'a' using Tan function");
     				br.readLine();
     				//______________________________________________________________________________________________
     				}
	    			if(c==0){c=tanSide(c, a, C, br);
	    			//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'c' using Tan function");
     				br.readLine();
     				//______________________________________________________________________________________________
     				}
     				displayResult(true, a, b, c, A, B, C);
	    			br.readLine();
    			}
    			
    			number=0;
    			if(C>0)//Sine
    			{
    				number++;
    			}
    			if(b>0)
    			{
    				number++;
    			}
    			if(c>0)
    			{
    				number++;
    			}
    			if(number==2)
    			{
    				if(C==0){C=sinAngle(c, b, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'C' using Sin function");
     				br.readLine();
     				//______________________________________________________________________________________________
     				}
    				if(b==0){b=sinSide(c, b, C, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'b' using Sin function");
     				br.readLine();
     				//______________________________________________________________________________________________
    				}
    				if(c==0){c=sinSide(c, b, C, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'c' using Sin function");
     				br.readLine();
     				//______________________________________________________________________________________________
    				}
    			}
    			
    			number=0;
    			
    			if(C>0)//Cosine
    			{
    				number++;
    			}
    			if(b>0)
    			{
    				number++;
    			}
    			if(a>0)
    			{
    				number++;
    			}
    			if(number==2)
    			{
    				if(C==0){C=cosAngle(a, b, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'C' using Cos function");
     				br.readLine();
     				//______________________________________________________________________________________________
    				}
    				if(b==0){b=cosSide(a, b, C, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'b' using Cos function");
     				br.readLine();
     				//______________________________________________________________________________________________
    				}
    				if(a==0){a=cosSide(a, b, C, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'a' using Cos function");
     				br.readLine();
     				//______________________________________________________________________________________________
    				}
    			}
    			displayResult(true, a, b, c, A, B, C);
	    		br.readLine();
    		}//END IF FOR ANGLE B
    		
    		if(C==90)
    		{System.out.print("hi");
    			number=0;
    			if(A>0)//Tangent
    			{
    				number++;
    			}
    			if(b>0)
    			{
    				number++;
    			}
    			if(a>0)
    			{
    				number++;
    			}
    			if(number==2)
    			{
    				if(A==0){A=tanAngle(a, b, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'A' using Tan function");
     				br.readLine();
     				//______________________________________________________________________________________________
    				}
    				if(b==0){b=tanSide(a, b, A, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'b' using Tan function");
     				br.readLine();
     				//______________________________________________________________________________________________
    				}
	    			if(a==0){a=tanSide(a, b, A, br);
	    			//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'a' using Tan function");
     				br.readLine();
     				//______________________________________________________________________________________________
	    			}
	    			displayResult(true, a, b, c, A, B, C);
	    			br.readLine();
    			}
    			
    			number=0;
    			if(A>0)//Sine
    			{
    				number++;
    			}
    			if(c>0)
    			{
    				number++;
    			}
    			if(a>0)
    			{
    				number++;
    			}
    			if(number==2)
    			{
    				if(A==0){A=sinAngle(a, c, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'A' using Sin function");
     				br.readLine();
     				//______________________________________________________________________________________________
    				}
    				if(c==0){c=sinSide(a, c, A, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'c' using Sin function");
     				br.readLine();
     				//______________________________________________________________________________________________
    				}
    				if(a==0){a=sinSide(a, c, A, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'a' using Sin function");
     				br.readLine();
     				//______________________________________________________________________________________________
    				}
	    			displayResult(true, a, b, c, A, B, C);
	    			br.readLine();
    			}
    			
    			number=0;
    			
    			if(A>0)//Cosine
    			{
    				number++;
    			}
    			if(c>0)
    			{
    				number++;
    			}
    			if(b>0)
    			{
    				number++;
    			}
    			if(number==2)
    			{
    				if(A==0){A=cosAngle(b, c, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'A' using Cos function");
     				br.readLine();
     				//______________________________________________________________________________________________
    				}
    				if(c==0){c=cosSide(b, c, A, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'c' using Cos function");
     				br.readLine();
     				//______________________________________________________________________________________________
    				}
    				if(b==0){b=cosSide(b, c, A, br);
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'b' using Cos function");
     				br.readLine();
     				//______________________________________________________________________________________________
    				}
    			}
    			displayResult(true, a, b, c, A, B, C);
	    		br.readLine();
    		}//END IF FOR ANGLE C
    	}
    	while(angle!=3 || side!=3);
    	
    		System.out.print("                 Here is your solved triangle");
    		displayTri(a, b, c, A, B, C);
    		System.out.print("                 Press Enter To Solve More Triangles");
	    	br.readLine();
    	
    		
    }
    
    //METHOD FOR CALCULATING OTHER TRIANGLE
    static void calculateOtherTri(double a, double b, double c, double A, double B, double C, BufferedReader br, boolean check, double[] num)throws Exception {
     	boolean tracing = true;
     	double sideRatio =0;
     	double angRatio = 0;
     	int side = 0;
     	int angle = 0;
     	
     	
     	//______________________________________________________________________________________________
    	clear(0);
    	mid("      Since there are no 90 degrees given, use coslaw or sinlaw");
     	br.readLine();
    	 //______________________________________________________________________________________________
     	
     	do
     	{
     		side =0;
    		angle =0;
    		
	    	if(A>0)
	    		angle++;
	    	if(B>0)
	    		angle++;
	    	if(C>0)
	    		angle++;
	    	
	    	if(a>0)
	    		side++;
	    	if(b>0)
	    		side++;
	    	if(c>0)
	    		side++;
	    		
     		
     		
     		if(angle == 2)
    		{
    			if(A==0)
    			{
    				if(!check)
    				{
    					//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'A' using 180 degree theorem");
     				br.readLine();
    			 	//______________________________________________________________________________________________
    				}
    				
    				
    				A = 180 - B - C;
    				
    				displayResult(true, a, b, c, A, B, C);
    				br.readLine();
    			}
    			if(B==0)
    			{
    				if(!check)
    				{
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'B' using 180 degree theorem");
     				br.readLine();
    			 	//______________________________________________________________________________________________
    				}
    				
    					B = 180 - A - C;
    					
    					displayResult(true, a, b, c, A, B, C);
    				br.readLine();
    			}
    			if(C==0)
    			{
    				if(!check)
    				{
    				//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'C' using 180 degree theorem");
     				br.readLine();
    			 	//______________________________________________________________________________________________
    				}
    				
    				C = 180 - B - A;
    				
    				displayResult(true, a, b, c, A, B, C);
    				br.readLine();
    			}
    		}//end if
     		
     		if(sideRatio==0)//oooooooooooooooooooooooooooo SINE LAW oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
	     	{
		     	if(A>0 && a>0)
		     	{
		     		sideRatio = a/Math.toDegrees(Math.sin(Math.toRadians(A)));
		     		angRatio = Math.sin(Math.toRadians(A))/a;
		     	}	
		     	if(B>0 && b>0)
		     	{
		     		sideRatio = b/Math.toDegrees(Math.sin(Math.toRadians(B)));
		     		angRatio = Math.sin(Math.toRadians(B))/b;
		     	}	
		     	if(C>0 && c>0)
		     	{
		     		sideRatio = c/Math.toDegrees(Math.sin(Math.toRadians(C)));
		     		angRatio = Math.sin(Math.toRadians(C))/c;
		     	}	
	     	}
	     
	     	if(sideRatio>0)
	     	{
	     		if(a==0&& A>0)
	     		{
	     			if(!check)
    				{
	     			//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'a' using sinlaw");
     				br.readLine();
    			 	//______________________________________________________________________________________________
    				}
	     			
	     			a = sideRatio * Math.toDegrees(Math.sin(Math.toRadians(A)));	
	     				
	     			displayResult(true, a, b, c, A, B, C);
    				br.readLine();
	     		}
	     			
	     		if(b==0&& B>0)
	     		{
	     			if(!check)
    				{
	     			//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'b' using sinlaw");
     				br.readLine();
    			 	//______________________________________________________________________________________________
    				}
	     			b = sideRatio * Math.toDegrees(Math.sin(Math.toRadians(B)));
	     			
	     			displayResult(true, a, b, c, A, B, C);
    				br.readLine();
	     		}
	     			
	     		if(c==0&& C>0)
	     		{
	     			if(!check)
    				{
	     			//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve side 'c' using sinlaw");
     				br.readLine();
    			 	//______________________________________________________________________________________________
    				}
	     			c = sideRatio * Math.toDegrees(Math.sin(Math.toRadians(C)));
	     			
	     			displayResult(true, a, b, c, A, B, C);
    				br.readLine();
	     		}
	     			
	     			
	     		if(A==0&& a>0)
	     		{
	     			if(!check)
    				{
	     			//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'A' using sinlaw");
     				br.readLine();
    			 	//______________________________________________________________________________________________
    				}
	     			A = Math.toDegrees(Math.asin(angRatio * a));
	     			
	     			displayResult(true, a, b, c, A, B, C);
    				br.readLine();
	     		}
	     			
	     		if(B==0&& b>0)
	     		{
	     			if(!check)
    				{
	     			//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'B' using sinlaw");
     				br.readLine();
    			 	//______________________________________________________________________________________________
    				}
	     			
	     			B = Math.toDegrees(Math.asin(angRatio * b));
	     			
	     			displayResult(true, a, b, c, A, B, C);
    				br.readLine();
	     		}
	     		
	     		if(C==0&& c>0)
	     		{
	     			if(!check && c>0)
    				{
	     			//______________________________________________________________________________________________
    				clear(0);
    				mid("                 Solve angle 'C' using sinlaw");
     				br.readLine();
    			 	//______________________________________________________________________________________________
    				}
	     			
	     			C = Math.toDegrees(Math.asin(angRatio * c));
	     			
	     			displayResult(true, a, b, c, A, B, C);
    				br.readLine();
	     		}
	     	}
	     	
	     	//oooooooooooooooooooooooooooo COS LAW ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
	     	
	     	if(A>0 && c>0 && b>0 && a==0)
	     	{
	     		if(!check)
    				{
	     		//______________________________________________________________________________________________
    			clear(0);
    			mid("                 Solve side 'a' using cos law");
     			br.readLine();
    			//______________________________________________________________________________________________
    				}
	     		
	     		a = Math.sqrt(b*b + c*c - 2*b*c*Math.cos(Math.toRadians(A)));
	     		
	     		displayResult(true, a, b, c, A, B, C);
    				br.readLine();
	     	} 
	     	
	     	if(B>0 && a>0 && c>0 && b==0)
	     	{
	     		if(!check)
    				{
	     		//______________________________________________________________________________________________
    			clear(0);
    			mid("                 Solve side 'b' using cos law");
     			br.readLine();
    			 //______________________________________________________________________________________________
    				}
	     		
	     		b = Math.sqrt(a*a + c*c - 2*a*c*Math.cos(Math.toRadians(B)));
	     		
	     		displayResult(true, a, b, c, A, B, C);
    				br.readLine();
	     	}
	     	
	     	if(C>0 && b>0 && a>0 && c==0)
	     	{
	     		if(!check)
    				{
	     		//______________________________________________________________________________________________
    			clear(0);
    			mid("                 Solve side 'c' using cos law");
     			br.readLine();
    			 //______________________________________________________________________________________________
    				}
	     		c = Math.sqrt(b*b + a*a - 2*b*a*Math.cos(Math.toRadians(C)));
	     		
	     		displayResult(true, a, b, c, A, B, C);
    				br.readLine();
	     	}
	     	
	     	if(a>0 && b>0 && c>0 && A==0)
	     	{
	     		if(!check)
    				{
	     		//______________________________________________________________________________________________
    			clear(0);
    			mid("                 Solve angle 'A' using cos law");
     			br.readLine();
    		 	//______________________________________________________________________________________________
    				}
	     		A = Math.toDegrees(Math.acos((a*a - b*b - c*c)/(-2*b*c)));
	     		
	     		displayResult(true, a, b, c, A, B, C);
    				br.readLine();
	     	}
     	}//end loop
     	while(side<3 || angle<3);
     	
     	System.out.print("                 Here is your solved triangle");
    		displayTri(a, b, c, A, B, C);
    		System.out.print("                 Press Enter To Solve More Triangles");
	    	br.readLine();
     	
    }//end method
    

    //METHOD FOR SIN TAN COS oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    static double cosSide(double a, double h, double A, BufferedReader br)throws Exception{
     	if(a==0) return h*Math.cos(Math.toRadians(A));
     	if(h==0) return a/Math.cos(Math.toRadians(A));
    	else return 0;
    }
    
    static double cosAngle(double a, double h, BufferedReader br)throws Exception{
    	return Math.toDegrees(Math.acos(a/h));
    }
    
    static double sinSide(double o, double h, double A, BufferedReader br)throws Exception{
    	if(o==0) return h*Math.sin(Math.toRadians(A));
     	if(h==0) return o/Math.sin(Math.toRadians(A));
    	else return 0;
    }
    
    static double sinAngle(double o, double h, BufferedReader br)throws Exception{
    	return Math.toDegrees(Math.asin(o/h));
    }
    
    static double tanSide(double o, double a, double A, BufferedReader br)throws Exception{

     	if(o==0)
     	{
     		 return a*Math.tan(Math.toRadians(A));
     	}
     	if(a==0) return o/Math.tan(Math.toRadians(A));
     	else return 0;
    }
    
    static double tanAngle(double o, double a, BufferedReader br){
   		return Math.toDegrees(Math.atan(o/a));
    }
   //ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
  
  	//METHOD FOR DISPLAYING RESULTS
    static void displayResult(boolean full, double a, double b, double c, double A, double B, double C) {
    	if(full)
    	{
	    	System.out.println("");
	        System.out.println("THE RESULT IS:");
	    	System.out.println("................................................................................................");
	       	System.out.println("");
    	}
    	
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                    side a: "+r(a)+"               angle A: "+r(A));
       	System.out.println("                    side b: "+r(b)+"               angle B: "+r(B));
       	System.out.println("                    side c: "+r(c)+"               angle C: "+r(C));
    	System.out.println("");
       	System.out.println();
    	System.out.println();
       	System.out.println();
    	System.out.println("");
       	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	
    	if(full)
    	{
	    	System.out.println(""); 
	    	System.out.println("");
	    	System.out.println(""); 
	       	System.out.println("");
	    	System.out.println("");
	       	System.out.println("");
	       	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.print("Press enter to continue");
    	}
       	
    }
    
    //METHOD FOR DISPLAYING INVALID
	static void displayTri(double a, double b, double c, double A, double B, double C) {
		System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	if(A == 0)System.out.println("                                     A"); else System.out.println("                                     "+r(A));
    	System.out.println("");
		System.out.println("                                     /\\");
        System.out.println("                                    /  \\");
    	System.out.println("                                   /    \\");
       	System.out.println("                                  /      \\");
    	System.out.println("                                 /        \\");
    	System.out.println("                                /          \\");
    	System.out.println("                               /            \\");
    	if(c==0)System.out.println("                              /              \\    c"); else System.out.println("                              /              \\    "+r(c));
    	if(b == 0)System.out.println("                       b                         "); else System.out.println("                       "+r(b)+"                         ");
    	System.out.println("                            /                  \\");
    	System.out.println("                           /                    \\");
    	System.out.println("                          /                      \\");
    	System.out.println("                         /                        \\");
    	System.out.println("                        /                          \\");
    	System.out.println("                       /                            \\");
    	System.out.println("                      /                              \\");
    	System.out.println("                     /                                \\");
    	if(B==0)System.out.println("                    ------------------------------------   B"); else System.out.println("                    ------------------------------------   "+r(B));
    	if(C == 0)System.out.println("                 C"); else System.out.println("                 "+r(C));
    	if(a==0)System.out.println("                                     a                      "); else System.out.println("                                     "+r(a));
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.print("");	
	}	
    
    //METHOD FOR DISPLAYING INVALID
	static void displayInvalid() {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                               Sorry, those are invalid numbers");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("................................................................................................");
    	System.out.println("");
    	System.out.print("");	
	}	
		
	//METHOD FOR DISPLAYING INVALID
	static void displayBad() {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                               Sorry, this is an impossible triangle");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("................................................................................................");
    	System.out.println("");
    	System.out.print("");		
	}
	
	//METHOD FOR DISPLAYING Steps
	static void mid(String sentence) {
    	System.out.println(sentence);
		clear();
	}
	
	//METHOD FOR CLEARING
	static void clear() {
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n                                  Press Enter To Continue\n\n");
	}
	
	//METHOD FOR CLEARING
	static void clear(int num) {
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	//METHOD FOR ROUNDING
	static double r(double a) {
		a = a*100;
		a = Math.round(a);
		return a/100;
	}
}	
	
	