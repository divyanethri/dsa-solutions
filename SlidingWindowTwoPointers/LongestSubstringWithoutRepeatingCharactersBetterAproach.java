import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner scn = new Scanner(System.in);
	    String s = scn.next();

        //LongestSubstringWithoutRepeatingCharacters Better Approach
        //Time Complexity: O(N)
        //Space Complexity: O(K)
        int left = 0;
        int maxLength = 0;
        
        //input: abcabcbb
        //output: 3
        //create a hashmap
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        //loop through the string
        for(int right = 0; right < s.length(); right++){
            //get every character
            char ch = s.charAt(right);
            
            //check if the char is already in the hashmap and it should be greater than left
            //then move left pointer to the one palce ahead of the current element
            if(map.containsKey(ch) && map.get(ch) >= left){
                left = map.get(ch) + 1;
            }
            //find maxLength
            maxLength = Math.max(maxLength, right - left + 1);
            //now put the character and right index in the hashmap.
            //if character already exists then hashmap takes care of updating the value.
            map.put(ch, right); 
        }
    System.out.println(maxLength);

	}
}
