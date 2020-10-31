/**
 * @(#)RomanNumberEnglishConverter.java
 *
 * RomanNumberEnglishConverter application
 *
 * @author 
 * @version 1.00 2014/2/8
 */
import java.io.*;
import java.util.*;
 
public class RomanNumberEnglishConverter {
    
    public static void main(String[] args)throws Exception {
    	new RomanNumberEnglishConverter();
    }
    
    RomanNumberEnglishConverter()throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	do
    	{
    		//Input number
    		System.out.println("");
    		String b = br.readLine();
    		int a = ConvertEnglishToArabic(b);
    		System.out.println("the number is: "+a);
    	}while(true);
    	
    }
    
    public int ConvertEnglishToArabic(String word){
    	boolean tracing = false;
    	byte decision = 1;
    	String tempWord = "";
    	int tempNum = 0;
    	int finalNumber = 0;
    	boolean oneMatch = false;
    	boolean tenMatch = false;
    	boolean teenMatch = false;
    	boolean hundMatch = false;
    	
    	StringTokenizer st = new StringTokenizer(word);
    	
    	//int numTokens = countTokens();
    	
    	ArrayList<String> ones = new ArrayList();
    	ArrayList<Integer> oneValues = new ArrayList();
    	ArrayList<String> tens = new ArrayList();
    	ArrayList<Integer> tenValues = new ArrayList();
    	ArrayList<String> teens = new ArrayList();
    	ArrayList<Integer> teenValues = new ArrayList();
    	ArrayList<String> orderOfMagnitude = new ArrayList();
    	ArrayList<Integer> values = new ArrayList();
    	int solution  = 0;
    	
    	ones.add("one");
    	ones.add("two");
    	ones.add("three");
    	ones.add("four");
    	ones.add("five");
    	ones.add("six");
    	ones.add("seven");
    	ones.add("eight");
    	ones.add("nine");
    	ones.add("zero");
    	
    	oneValues.add(1);
    	oneValues.add(2);
    	oneValues.add(3);
    	oneValues.add(4);
    	oneValues.add(5);
    	oneValues.add(6);
    	oneValues.add(7);
    	oneValues.add(8);
    	oneValues.add(9);
    	oneValues.add(0);
    	
    	tens.add("ten");
    	tens.add("twenty");
    	tens.add("thirty");
    	tens.add("forty");
    	tens.add("fifty");
    	tens.add("sixty");
    	tens.add("seventy");
    	tens.add("eighty");
    	tens.add("ninety");
    	
    	tenValues.add(10);
    	tenValues.add(20);
    	tenValues.add(30);
    	tenValues.add(40);
    	tenValues.add(50);
    	tenValues.add(60);
    	tenValues.add(70);
    	tenValues.add(80);
    	tenValues.add(90);
    	
    	teens.add("eleven");
    	teens.add("twelve");
    	teens.add("thirteen");
    	teens.add("fourteen");
    	teens.add("fifteen");
    	teens.add("sixteen");
    	teens.add("seventeen");
    	teens.add("eighteen");
    	teens.add("nineteen");
    	
    	teenValues.add(11);
    	teenValues.add(12);
    	teenValues.add(13);
    	teenValues.add(14);
    	teenValues.add(15);
    	teenValues.add(16);
    	teenValues.add(17);
    	teenValues.add(18);
    	teenValues.add(19);
    	
    	orderOfMagnitude.add("thousand");
    	orderOfMagnitude.add("million");
    //	orderOfMagnitude.add("billion");
    //	orderOfMagnitude.add("trillion");
    //	orderOfMagnitude.add("quadrillion");
    //	orderOfMagnitude.add("quintillion");
    	
    	values.add(1000);
    	values.add(1000*1000);
    //	values.add(1000*1000*1000);
    //	values.add(1000*1000*1000*1000);
    //	values.add(1000*1000*1000*1000*1000);
    //	values.add(1000*1000*1000*1000*1000*1000);
    
    	tempWord = st.nextToken();
    	
    	
    	for(int a = 0; a<5 && decision != 0;a++){
    		tenMatch = oneMatch = false;
    		if(tracing)System.out.println("loop!");
 //-------------------------------------------------------------------------------
    		//Check for ones
    		if(tracing)System.out.println("ones!");
	    	for(String number:ones){
	    		if(tempWord.equals(number)){
	    			tempNum += oneValues.get(ones.indexOf(number));
	    			if(st.hasMoreTokens()){
	    				tempWord = st.nextToken();
	    			}
	    			else{
	    				decision = 0;
	    				break;
	    			}
	    			decision = 2;
	    			break;
	    		}
	    		decision = 3;
	    	}
    		
 //-------------------------------------------------------------------------------
    		
    		if(decision == 2){
    			if(tracing)System.out.println("hundreds!");
	    		//check for hundred
	    		if(tempWord.equals("hundred")){
		    		tempNum = tempNum * 100;
		    		if(st.hasMoreTokens()){
	    				tempWord = st.nextToken();
	    				decision = 3;
	    			}
	    			else{
	    				decision = 0;
	    			}
		    	}
		    	else
		    	{
		    		decision = 6;
		    	}
    		}
    		
 //-------------------------------------------------------------------------------   		
	    	if(decision == 3){
		    	//Check for tens
		    	if(tracing)System.out.println("tens!");
		    	for(String number:tens){
		    		if(tempWord.equals(number)){
		    			tenMatch = true;
		    			tempNum += tenValues.get(tens.indexOf(number));
		    			if(st.hasMoreTokens()){
		    				tempWord = st.nextToken();
		    			}
		    			else{
		    				decision = 0;
		    				break;
		    			}
		    			break;
		    		}
		    		decision = 4;
		    	}
	    	}//end if
	    	 
//-----------------------------------------------	    	
		    if(decision == 4){	
		    	//Check for ones
		    	if(tracing)System.out.println("ones2!");
		    	for(String number:ones){
		    		if(tempWord.equals(number)){
	    				oneMatch = true;
		    			tempNum += oneValues.get(ones.indexOf(number));
		    			if(st.hasMoreTokens()){
		    				tempWord = st.nextToken();
		    			}
		    			else{
		    				decision = 0;
		    				break;
		    			}
		    			break;
		    		}
		    		decision = 6;
		    	}
		    }
//-----------------------------------------------	    	
		    if(!oneMatch && !tenMatch){
		    	if(tracing)System.out.println("teens!");
		    	if(!oneMatch && !tenMatch){
			    	//check for teens
			    	for(String number:teens){
			    		if(tempWord.equals(number)){
			    			tempNum += teenValues.get(teens.indexOf(number));
			    			if(st.hasMoreTokens()){
			    				tempWord = st.nextToken();
			    			}
			    			else{
			    				decision = 0;
			    				break;
			    			}
			    			decision = 6;
			    			break;
			    		}
			    	}
		    	}
		    }
//-------------------------------------------------------------------------------	    	
	    	if(decision == 6){
	    		if(tracing)System.out.println("mags!");
	    		//check for magnitude
		    		if(tempWord.equals(orderOfMagnitude.get(a))){
		    			tempNum *= values.get(a);
		    				if(st.hasMoreTokens()){
			    				tempWord = st.nextToken();
			    			}
			    			else{
			    				decision = 0;
			    			}
		    		}
		    		else
		    		{
		    			decision = -1;
		    		}
		    		
	    	}
//-------------------------------------------------------------------------------		    	
		    	
		    	solution += tempNum;
		    	if(tracing)System.out.println("solution = "+ solution);
		    	tempNum = 0;
		    	if(a == 4 || decision == -1)return -1;
		    	
    	}
    	
    	
    	return solution;
    }
    
    public String ConvertArabicToEnglish(String num){
    	boolean tracing = false;
    	int decision = 1;
    	String tempWord = "";
    	int tempNum = 0;
    	int finalNumber = 0;
    	String solution  = "";
    	
    	ArrayList<String> ones = new ArrayList();
    	ArrayList<String> tens = new ArrayList();
    	ArrayList<String> teens = new ArrayList();
    	ArrayList<Character> digits = new ArrayList();
    	
    	digits.add('1');
    	digits.add('2');
    	digits.add('3');
    	digits.add('4');
    	digits.add('5');
    	digits.add('6');
    	digits.add('7');
    	digits.add('8');
    	digits.add('9');
    	
    	ones.add("one");
    	ones.add("two");
    	ones.add("three");
    	ones.add("four");
    	ones.add("five");
    	ones.add("six");
    	ones.add("seven");
    	ones.add("eight");
    	ones.add("nine");
    	
    	tens.add("ten");
    	tens.add("twenty");
    	tens.add("thirty");
    	tens.add("forty");
    	tens.add("fifty");
    	tens.add("sixty");
    	tens.add("seventy");
    	tens.add("eighty");
    	tens.add("ninety");
    	
    	teens.add("eleven");
    	teens.add("twelve");
    	teens.add("thirteen");
    	teens.add("fourteen");
    	teens.add("fifteen");
    	teens.add("sixteen");
    	teens.add("seventeen");
    	teens.add("eighteen");
    	teens.add("nineteen");
    	
    	int b = num.length();
    	int a = 0;
    	
    	decision = b%3;
    	
    	for(int c = 0; c<3 && a<b; c++){
 //-------------------------------------------------------------------------------
    		//Check for one hundreds
    		if(decision == 0){
    			if(tracing)System.out.println("hundreds a = "+a);
    			if(num.charAt(a) == '0'){
			    	a++;
			    	decision = 2;
			    }
			    else
			    {
				    for(Character number:digits){
			    		if(num.charAt(a) == number){
			    			
			    			solution += ones.get(digits.indexOf(number)) + " hundred";
			    			a++;
			    			decision = 2;
			    			break;
			    		}
			    	}
			    }
		    	
		    	
    		}
    		
    		//Check for tens and teens
    		if(decision == 2){
    			
    			if(num.charAt(a) == '1'){
		    		if(tracing)System.out.println("teens a = "+a);
		    		for(Character numb:digits){
		    			if(num.charAt(a+1) == numb){
				    		solution += " " + teens.get(digits.indexOf(numb));
				    		if(b-a>2){a+=2;}else{ c=3;}
				    		decision = 0;
				    		break;
		    			}
		    		}
		    	}
		    	
		    	if(decision == 2){
			    	if(num.charAt(a) == '0'){
			    		a++;
			    		decision = 1;
			    	}
			    	else
			    	{
				    	for(Character number:digits){
				    		if(num.charAt(a) == number){
				    			if(tracing)System.out.println("tens a = "+a);
				    			solution += " " + tens.get(digits.indexOf(number));
				    			a++;
				    			decision = 1;
				    			break;
				    		}
				    	}	
			    	}
			    	
			    	
		    	}
    		}//end if 1
    		
    		//Check for ones
    		if(decision == 1){
    			if(num.charAt(a) == '0'){
			    	a++;
			    	decision = 0;
			    }
			    else
			    {
				    for(Character number:digits){
				    		if(num.charAt(a) == number){
				    			if(tracing)System.out.println("ones a = "+a);
				    			solution += " " + ones.get(digits.indexOf(number));
				    			
				    			a++;
				    			decision = 0;
				    			break;
				    		}
				    }	
			    }
    			
			    
    		}
    		
    		if(tracing)System.out.println("a = "+a);
    		if(tracing)System.out.println("b = "+b);
    		if(tracing)System.out.println("b - a = "+(b-a));
    		if((b-a) == 3){solution += " thousand ";}
    	}//end for loop
    	
    	
    	
    	return solution;
    }
    
}//end class

