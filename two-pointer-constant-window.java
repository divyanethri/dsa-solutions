import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	//two pointers -> constant window type
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0; i< n; i++){
		    arr[i] = scn.nextInt();
		 
		}
		//initialize the sum variable
		int sum = 0;

		//calculate first window sum i.e, first k elements sum
		for(int i=0; i<k; i++){
		    sum += arr[i];
		}
		//initialize l (left) index to 0;
		//initialise r (right) index to k-1;
		//now we have window elements.
		int l =0;
		int r = k-1;
		//intialize maxSum with sum;
        int mSum = sum;

		//run a while loop till r < n-1 
		// now subtract left element, increment left and right element for next window
		// add right element into the sum
		// call max sum method
		//compare maxSum with sum and change according to it.
        	while(r < n-1){
            		sum = sum - arr[l];
            		l++;
            		r++;
            		sum = sum + arr[r];
            		mSum = maxSum(mSum, sum);
            
        	}
        
    	System.out.println(mSum);
	}
	// It compares sum and maxSum and assign as per the values
	public static int maxSum(int mSum, int sum){
	    if(mSum > sum) return mSum;
	    else return sum;
	    
	}
}
