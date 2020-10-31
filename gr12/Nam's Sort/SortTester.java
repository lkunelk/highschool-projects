/**
 * @(#)InsertionSort.java
 *
 *
 * @author 
 * @version 1.00 2015/2/1
 */


import java.io.*;

public class SortTester {

	int[] arI;
	double[] arD = {45.6, 34.2, 67.9, 23.4, 12.1, 45.6, 78.8, 98.4, 98.2, 98.3, 22.3, 88.8, 45.5};

	public static void main(String[] arg)throws Exception{
		new SortTester();
	}

    public SortTester()throws Exception {
    	
    	printArray(arD);
    	
    	selectSort(arD);
    }
    
    public void createRandomArray(int[] ar){
    	//create array
    	ar = new int[20];
    	
    	//fill array
    	for(int i = 1; i <= ar.length; i++){
    		ar[i-1] = i;
    	}
    	
    	//mix up the array
    	for(int i = 0; i < 100; i++){
    		int i1 = (int)(Math.random()*ar.length);
    		int i2 = (int)(Math.random()*ar.length);
    		
    		if(i1 == i2){
    			continue;
    		}
    		
    		//fancy way of switching values around
    		ar[i1] *= ar[i2];
    		ar[i2] = ar[i1]/ar[i2];
    		ar[i1] /= ar[i2];
    		
    	}
    }
    
    public void bubbleSort(double[] ar){
    	for(int top = ar.length-1;top > 0; top--){
    		for(int i = 0; i < top; i++){
    			if(ar[i] > ar[i+1]){
    				double t = ar[i];
    				ar[i] = ar[i+1];
    				ar[i+1] = t;
    			}
    		}
    		
    		printArray(ar);
    	}
    }
    
    public void selectSort(double[] ar){
    	for(int top = ar.length-1; top > 0; top--){
    		int largeLoc = 0;
    		
    		for(int i = 1; i<=top; i++){
    			if(ar[i]>ar[largeLoc]){
    				largeLoc = i;
    			}
    		}
    		
    		double temp = ar[top];
    		ar[top] = ar[largeLoc];
    		ar[largeLoc] = temp;
    		
    		printArray(ar);
    	}
    }
    
    public void insertSort(double[] ar){
    	for(int i = 1; i < ar.length; i++){
    		double element = ar[i];
    		int j = i;
    		//loop through sorted portion
    		while(j > 0 && ar[j-1] > element){
    			ar[j] = ar[j-1];
    			j--;
    		}
    		ar[j] = element;
    		printArray(ar);
    	}
    }
    
    public void printArray(int[] ar){
    	System.out.println("");
    	for(int i = 0; i < ar.length; i++){
    		System.out.print(ar[i]+", ");
    	}
    }
    
    public void printArray(double[] ar){
    	System.out.println("");
    	for(int i = 0; i < ar.length; i++){
    		System.out.print(ar[i]+", ");
    	}
    }
}