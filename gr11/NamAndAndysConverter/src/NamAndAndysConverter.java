/* Number Converter
 * This program converts between Roman numerals, Arabic numerals, and numbers in English
 * Authors: Andy Rock & Nam Nguyen
 * Start Date: February 6, 2014
 * End Date:   February 22, 2014
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.*;
import java.util.*;

public class NamAndAndysConverter extends JFrame implements MouseListener,ActionListener,FocusListener
{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	String instructions = 
	"<html>"+
		"<p style=\"font-size:15px;font-family:Cambria;margin-bottom:7px\">"+
			"Instructions:"+
		"</p>"+
		"<p>"+
			"Enter a number in any of the three formats. Click Convert to convert your number to the other 2 formats."+
		"</p>"+
	"</html>";
	JPanel panel = new JPanel();
	JLabel left = new JLabel();
	JLabel right = new JLabel();
	JLabel bottom = new JLabel();
	JLabel instructionsLabel = new JLabel(instructions);
	JPanel inputPanel = new JPanel(new GridLayout(3,1));
	JPanel[] textPanel = new JPanel[3];
	JFormattedTextField[] textField = new JFormattedTextField[3];
	JButton convert = new JButton("<html><p style=\"font-size:30;font-family:Cambria\">Convert!</p></html>");
	JPanel outputPanel = new JPanel(new GridLayout(3,1));
	JLabel[] outputField = new JLabel[3];
	boolean invalid = false;
	double[] value = new double[3];
	int roundAngle = 0,roundSide = 1;
	String[] values =
	{
		"Arabic:",
		"Roman:",
		"English:"
	};

	public static void main(String[] args)
	{
		new NamAndAndysConverter();
	}

	NamAndAndysConverter()
	{
		super("Converter");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(302,206);
		Dimension frameSize=getSize();
		setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.width)/2);
		setLayout(null);
		setResizable(false);
		panel.setLayout(null);
		panel.setBounds(0,0,296,177);
		left.setBounds(5,5,169,104);
		right.setBounds(179,5,113,104);
		bottom.setBounds(5,114,286,57);
		instructionsLabel.setBounds(9,7,165,100);
		inputPanel.setBounds(181,7,108,100);
		convert.setBounds(6,115,285,56);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED));
		left.setBorder(new BevelBorder(BevelBorder.LOWERED));
		right.setBorder(new BevelBorder(BevelBorder.LOWERED));
		bottom.setBorder(new BevelBorder(BevelBorder.LOWERED));
		convert.addMouseListener(this);
		for(int i=0;i<3;i++)
		{
			textPanel[i] = new JPanel();
			textPanel[i].add(new JLabel(values[i]));
			textField[i] = new JFormattedTextField();
			textField[i].setColumns(3);
			textField[i].addActionListener(this);
			textField[i].addFocusListener(this);
			textPanel[i].add(textField[i]);
			inputPanel.add(textPanel[i]);
		}
		panel.add(left);
		panel.add(right);
		panel.add(bottom);
		panel.add(instructionsLabel);
		panel.add(inputPanel);
		panel.add(convert);
		add(panel);
		setVisible(true);
	}

	public void convert()
	{
		String arabic =  textField[0].getText().toUpperCase();
		String roman =   textField[1].getText().toUpperCase();
		String english = textField[2].getText().toLowerCase();
		if(!arabic.equals(""))
		{
			roman =   aToR(arabic);
			english = aToE(arabic);
		}
		else if(!roman.equals(""))
		{
			arabic =  rToA(roman);
			english = aToE(arabic);
		}
		else if(!english.equals(""))
		{
			arabic = eToA(english);
			roman  = aToR(arabic);
		}
		else
			arabic=null;
		JPanel outputPanel = new JPanel(new GridLayout(3,1));
		if(arabic!=null&&roman!=null&&english!=null)
		{
			outputPanel.add(new JLabel("Arabic:   "+arabic));
			outputPanel.add(new JLabel("Roman:    "+roman));
			outputPanel.add(new JLabel("English:  "+english));
		}
		else
		{
			outputPanel.add(new JLabel("INVALID!"));
			outputPanel.add(new JLabel(""));
			outputPanel.add(new JLabel(""));
		}
		JOptionPane.showMessageDialog(this,outputPanel,"Results",JOptionPane.PLAIN_MESSAGE);
		textField[0].setText("");
		textField[1].setText("");
		textField[2].setText("");
	}

	String aToR(String arabic)
	{
		int ar;
		try
		{
			ar = Integer.parseInt(arabic);
			
			if(ar>=1000000 || ar <0){
				return null;
			}
		}
		catch(Exception e)
		{
			return null;
		}
		if(ar>=1000)
			return "M"+aToR(""+(ar-1000));
		if(ar>=900)
			return "CM"+aToR(""+(ar-900));
		if(ar>=500)
			return "D"+aToR(""+(ar-500));
		if(ar>=400)
			return "CD"+aToR(""+(ar-400));
		if(ar>=100)
			return "C"+aToR(""+(ar-100));
		if(ar>=90)
			return "XC"+aToR(""+(ar-90));
		if(ar>=50)
			return "L"+aToR(""+(ar-50));
		if(ar>=40)
			return "XL"+aToR(""+(ar-40));
		if(ar>=10)
			return "X"+aToR(""+(ar-10));
		if(ar>=9)
			return "IX"+aToR(""+(ar-9));
		if(ar>=5)
			return "V"+aToR(""+(ar-5));
		if(ar>=4)
			return "IV"+aToR(""+(ar-4));
		if(ar>=1)
			return "I"+aToR(""+(ar-1));
		return "";
	}
	String rToA(String roman)
	{
		char[] rom = roman.toCharArray();
		int[] num = new int[rom.length];
		for(int i=0;i<rom.length;i++)
		{
			switch(rom[i])
			{
				case 'I':
					num[i]=1;
					break;
				case 'V':
					num[i]=5;
					break;
				case 'X':
					num[i]=10;
					break;
				case 'L':
					num[i]=50;
					break;
				case 'C':
					num[i]=100;
					break;
				case 'D':
					num[i]=500;
					break;
				case 'M':
					num[i]=1000;
					break;
				default:
					return null;
			}
		}
		for(int x=0;x<num.length-1;x++)
			if(num[x]!=0&&num[x+1]!=0&&num[x]<num[x+1])
			{
				num[x+1]-=num[x];
				num[x]=0;
				x=0;
			}
		int total=0;
		for(int n:num)
			total+=n;
		return ""+total;
	}
	String eToA(String word){
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
    	
    	oneValues.add(1);
    	oneValues.add(2);
    	oneValues.add(3);
    	oneValues.add(4);
    	oneValues.add(5);
    	oneValues.add(6);
    	oneValues.add(7);
    	oneValues.add(8);
    	oneValues.add(9);
    	
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
    	
    	if(tempWord.equals("zero")){
    		return "0";
    	}
    	
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
		    	if(a == 4 || decision == -1)return null;
		    	
    	}
    	
    	
    	return ""+solution;
    }
    String aToE(String num){
    	try
    	{
    		if(Integer.parseInt(num)>=1000000 || Integer.parseInt(num) <0)
    			return null;
    	}
    	catch(Exception e)
    	{
    		return null;
    	}
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
    	
    	if(num.equals("0")){
    		return "zero";
    	}
    	
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

	public void mouseClicked(MouseEvent ME)
	{
		if(ME.getSource()==convert)
			convert();
	}
	public void mousePressed(MouseEvent ME)
	{
	}
	public void mouseReleased(MouseEvent ME)
	{
	}
	public void mouseEntered(MouseEvent ME)
	{
	}
	public void mouseExited(MouseEvent ME)
	{
	}
	public void actionPerformed(ActionEvent AE)
	{
		convert();
	}
	public void focusLost(FocusEvent FE)
	{
		
	}
	public void focusGained(FocusEvent FE)
	{
		for(int i=0;i<3;i++)
			textField[i].setText("");
	}
}