/**
 * @(#)InsertionSort.java
 *
 *
 * @author 
 * @version 1.00 2015/2/1
 */


import java.io.*;

public class InsertionSort {

	int[] ar;

	public static void main(String[] arg)throws Exception{
		new InsertionSort();
	}

    public InsertionSort()throws Exception {
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
    	
    	printArray();
    	
    	insertSort(ar);
    }
    
    public void insertSort(int[] array){
    	for(int i = 1; i < array.length; i++){
    		int element = array[i];
    		int j = i;
    		//loop through sorted portion
    		while(j > 0 && array[j-1] > element){
    			array[j] = array[j-1];
    			j--;
    		}
    		array[j] = element;
    		printArray();
    	}
    }
    
    public void printArray(){
    	System.out.println("");
    	for(int i = 0; i < ar.length; i++){
    		System.out.print(ar[i]+", ");
    	}
    }
}