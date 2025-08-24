import java.util.*;
import java.lang.*;
import java.io.*;

class LargestSubArrayBruteForce
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//Longest subarry when condition met
		//may contain 1 element or full array which summation equal to the k
		//brute force approach (generate all the subarrays and check the condition)
		//[2,5,1,7,10] where k = 14
		//sorted array

		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0; i< n; i++){
		    arr[i] = scn.nextInt();
		 
		}
		int maxLen=0;
		
		for(int i=0; i< n-1; i++){
		    int sum = 0;
		    for(int j= i; j<n-1; j++){
		        sum = sum + arr[j];
		        if(sum <=k){
		            maxLen = maxLength(maxLen, (j-i)+1);
		        }
		        //break if the sum exceeds as even if you move further you will get more sum since it's a sorted array
		        else{
		            break;
		        }
		    }
		}
		System.out.println(maxLen);
	}
	
	public static int  maxLength(int maxLen, int newLen){
	    if(maxLen > newLen) return maxLen;
	    else return newLen;

    }

}
