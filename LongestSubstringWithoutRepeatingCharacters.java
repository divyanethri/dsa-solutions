import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner scn = new Scanner(System.in);
		String str = scn.next();
		//Longest substring without repeating characters
		//consecutive 
		// input: cadbzabcd
		//output: 5
		//Time Complexity: N x N = N2
		//Space Complexity: K
		//create a hashmap to store the charcters as keys and Integer as value
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>(256);
		//initialise maxLen to 0
		int maxLen = 0;
		
		//loop through the string
		for(int i=0; i< str.length(); i++){
		    //create/ reinitialise a new hashmap everytime
		    hmap = new HashMap<Character, Integer>(256);
		    // loop through to create a substring
		    for(int j= i; j< str.length(); j++){
		        //check if the hmap contains the character and if charcter value is equal to 1
		        // if it is equal to 1 then it is already occured which means we need to break from this loop, entirely.
		        if(hmap.containsKey(str.charAt(j)) && hmap.get(str.charAt(j))== 1) break;
		        
		        // if it doesn't break, that means the character has been occured even once.
		        //considering that unoccured character and find the length by j-i+1
		        //call MaxLength method to find the maxLen by passing existing maxLen and current len
		        int len = (j-i) +1;
		        maxLen = maxLength(maxLen, len);
		        //after updating maxLen now as the character has been occured, put the value as 1 in for that character key. 
		        hmap.put(str.charAt(j), 1);
		        
		    }
		}
		//print the length
		System.out.println(maxLen);

	}
		public static int  maxLength(int maxLen, int newLen){
	    if(maxLen > newLen) return maxLen;
	    else return newLen;

    }
}
