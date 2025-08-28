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
		//Time Complexity O(2 * k)
		//Space Complexity O(1)
		
		//Maximum points you obtain from  n cards
		//given array which contains n
		//arr =[6,2,3,4, 7,2,1,7,1] k=4
		//pick up the window combinations from left or right not in the middle.
		//make sure it's consecutive form left or right
		
		//initialize the sum variable
		int lsum = 0; // initialise left sum
		int rsum = 0; //initialise right sum
		int mSum = 0; // initialise max sum
		//this loop takes O(k)
		for(int i=0; i<=k-1; i++){ //loop through left k elements and get a sum
		    lsum = lsum + arr[i];

		}
		// assign the left sum to maxSum
		mSum = lsum;
		int rindex = n-1; // initialise right index
		//this loop takes O(k)
		for(int i= k-1; i>=0; i--){ // loop through the k elements by decreasing
		    lsum = lsum - arr[i]; // while looping, subtract the element from the left sum
		    rsum = rsum + arr[rindex];// while looping, add the right element to the right sum
		    rindex--; // decrease the right index
		    mSum = maxSum(mSum, lsum + rsum); // call maxSum method to check the maxSum
		}
		System.out.println(mSum); // print the maxSum
	}
	
	// It compares sum and maxSum and assign as per the values
	public static int maxSum(int mSum, int sum){
	    if(mSum > sum) return mSum;
	    else return sum;
	    
	}
}
