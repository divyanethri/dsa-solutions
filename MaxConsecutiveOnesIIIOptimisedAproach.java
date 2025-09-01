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
		//Max Consecutive Ones III optimised solution
		//Time Complexity: O(N) 
		//Space Complexity: O(1)
        //The idea is to maintain constant maxlen gap between left and right.
        //Because checking for less length than maxlen window is waste of time.
		
		
		//Best approach maybe asked in interviews to cut down the while loop in a while loop.
		
		//initialise maxLength, left, zeroes, right
		int maxLen = 0;
        int left =0;
        int zeroes = 0;
        int right = 0;
        //loop till right is less than arr.length
        while(right< arr.length){
            //check if 0 is there, then increment zeroes 
            if(arr[right] == 0){
                zeroes++;
            }
            //if zeroes less or equal to k then always update len and try to find and update maxLen
            if(zeroes<=k){
               int  len = right-left+1;
                maxLen = Math.max(maxLen, len);
            }
            else{
                    //check if the element is 0 in every iteration, if it is zero then reduce it.
                    //this condition only executes when it is satisfied
                    //that means zeroes get updated on this condition
                    //left pointer keeps or moving towards right in every iteration
                    //even right moves, constant windown is maintained
                    if(arr[left]== 0){
                        //reducing zeroes
                        zeroes--;
                    }
                    //moving left pointer
                    left++;
            }
        //in every while loop iteration move right towards right
        right++;
        }
    System.out.println(maxLen);

	}
}
