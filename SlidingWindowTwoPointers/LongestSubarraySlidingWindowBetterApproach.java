import java.util.*;
import java.lang.*;
import java.io.*;

class SlidingWindow3
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//Longest subarry when condition met
		//sliding window, standard approach accross all the problems
		// two concepts of the window
		// i) expand right element++
		// ii) shrink left element++ (whenever condition is false/ not met)
		//may contain 1 element or full array which summation equal to the k
		//better approach (generate all the subarrays and check the condition)
		//[2,5,1,7,10] where k = 14
		//sorted array
		//Time Complexity O(n + n)
		//Space Complexity O(1)

		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0; i< n; i++){
		    arr[i] = scn.nextInt();
		 
		}
		
		//initializing maxLen, sum, left(l), right(r)
		int maxLen=0;
		int sum =0;
		int l = 0;
		int r = 0;
		//loop till right reaches n(length)
		while(r < n){
		    //add every right element to the sum
		    sum = sum + arr[r];
		    //check if we need to move left pointer to right
		    //if sum > k then subtract that left pointer element from the sum and move the left pointer to right.
			// while may take n time so the total TC may be 2N
			//because we are shrinking for small window which length is less than maxLen, it's a waste of time to do this.
			// As we already found the maxLen we need to check for > maxLen,
			// We can use this while returning/ printing all the subarrays instead of maxLen
		    while(sum > k){
		        
		        sum = sum - arr[l];
		        l++;
		    }
		    //check if sum <=k, then call maxLength and update maxLen according to the returned value
		    if(sum <= k){
		        maxLen = maxLength(maxLen, (r-l) + 1);

		    }
		    //move right pointer further, so that loop runs.
		    //remember loop started with r condition, so as a trick you must need to increment r variable. 
		    r++;
		  }
		  //print the maxLen
		System.out.println(maxLen);
	}
	
	public static int  maxLength(int maxLen, int newLen){
	    if(maxLen > newLen) return maxLen;
	    else return newLen;

    }

}
