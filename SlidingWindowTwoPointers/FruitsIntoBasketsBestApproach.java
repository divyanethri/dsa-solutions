import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    for(int i=0; i<n; i++){
	        arr[i] = scn.nextInt();
	    }

        //Fruits Into Baskets Solution Better Approach
        // arr= [3,3,3,1,2,1,1,2,3,3,4]
        // output: 5
        //Time Complexity: O(2N)
        //Space Complexity: O(K)
    
        //Two pointers Sliding window Approach
        //here unlike brute force we move the left pointer towards right.
        //we will move left and have a constant window, in better approach we are moving left all at once.
        //but here we will move left in such a way that it maintains a maxLen of constant window
        //because its waste of time to actually generating the less length subarray.
        //if we know the maxLen then we maintain the constant window space.
        //while moving left we also reduce the countvalue of the element which is there in the map.
        //As it's a waste of time calculating
        //declare maxLen
        int maxLen = 0;
        //declare left and right pointers variables
	    int left = 0;
	    int right = 0;
	    //Declare Map data structure
	    Map<Integer, Integer> map = new HashMap<>();
	    //loop a while loop till right is less than array length
	    while(right < arr.length){
	        //Now, put/ add the elements into the map data structure
	        //map.getorDefault(fruits[right],0) it get the count and adds one, if there's no such element already exisiting in the map then it will add 1 to the zero.
	        //remember the syntax;
	        map.put(arr[right], map.getOrDefault(arr[right],0)+1);
	            //if map size greater than two then move the left pointer towards the right to maintain the constant space/ window
	            if(map.size() > 2){
	                //put/add the count-1 in the map data structure
	                map.put(arr[left], map.get(arr[left])-1);
	                //if map.get of element equals to 0 then it indicates that there is no such element. which means that element should not be there in the map
	                //so when the same element occur in the future then it must be new to map to be actually added to it.
	                if(map.get(arr[left]) == 0){
	                    //remove the element if the count/value of the element in the map is zero.
	                    map.remove(arr[left]);
	                }
	                //always increment left 
	                //this is the whole point
	            left++;
	           }
	
	        //if map size is less than or equal to 2 then calculate the maxLen
	        
	        if(map.size() <= 2){
	            maxLen = Math.max(maxLen, right - left + 1);
	        }
	        //move the right pointer
	   right++;     
	    }
    System.out.println(maxLen);

	}
}
