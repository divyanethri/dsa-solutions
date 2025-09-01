import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner scn = new Scanner(System.in);
	    int k = scn.nextInt();
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    for(int i=0; i< n; i++){
	        arr[i] = scn.nextInt();
	    }
		//Max Consecutive Ones III brute force
		//Longest Subarray with at most K zeroes(because having zeroes means we can replace them)
		
		//Time Complexity : O(N X N)
		//Space Complexity : O(1)
		//initialise maxLength
		int maxLen = 0;
		
		//loop through the array till n 
		for(int i=0; i< n; i++){
		    //declare a zeroes varaible
		    int zeros = 0;
		    //loop through the entire array from i to till n 
		    //always increment zeroes when we encounter
		    //find out if there are zeroes less than or equal to k, then find out the maxLen.
		    // if zeroes greather than k then break from the loop
		    for(int j=i; j< n; j++){
		        if(arr[j]==0){
		            zeros++;
		        }
		        if(zeros<= k){
		            int len = j-i+1;
		            maxLen = Math.max(maxLen, len);
		        }else{
		            break;
		        }
		    }
		    
		}
		//print the maxLength
		System.out.println(maxLen);

	}
}
