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

        //Fruits Into Baskets Solution Brute Force
        // arr= [3,3,3,1,2,1,1,2,3,3,4]
        // output: 5
        //Time Complexity: O(N x N)
        //Space Complexity: O(K);
        
        //declare maxLen
        int maxLen = 0;
        
        //In brute force we need to create all the substrings.
        //loop through all the elements;
        for(int i=0; i<arr.length; i++){
            //while looping through all the elements through the array.
            //we need to set the Set data structure to new;
            //As we create new substrings from here.
            Set<Integer> s = new HashSet<>();
            //Now loop from i to N
            //adding the element to the Set data structure
            for(int j=i; j<arr.length; j++)
            {
                //add element to the set
                s.add(arr[j]);
                //check if the size of the Set is less than or equal to 2
                //max 2 types of fruits can be there at once in the Set.
                if(s.size() <=2){
                    //If size is less than or equal to 2 then calculate the maxLen
                    maxLen = Math.max(maxLen, j-i+1);
                }else{
                    // if size is greater than 2 then break from the inner loop.
                    break;
                }
            }
        }
    System.out.println(maxLen);

	}
}
