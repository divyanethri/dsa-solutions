import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//Longest Substring with at most k Distinct Characters
		//input: s = aaabbccd k = 2
		//output: 5
		//Time Complexity: O(n x N)
		//Space Complexity: O (N x log (256))
		//based on map it might take up to log of (256)
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int k =sc.nextInt();
		//create a map for storing characters count
		Map<Character, Integer> map = new HashMap<>();
		int maxLen = 0;
		
		//we will use two for loops and generate all the substrings
		//then find out which which is the longest substring according to our condition
		for(int i=0; i<s.length(); i++){
		    //we need to clear all the elements in the map every time outer loop iterates
            map.clear();
		    for(int j=i; j<s.length(); j++){
		        //put the character and increment count
		        map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
		        //check map size and if the map size is less or equal to k then find the maxLen
		        //if not then break as we don't need to iteration any more
		        if(map.size() <= k){
		            maxLen = Math.max(maxLen, j-i+1);
		        }else{
		            break;
		        }
		    }
		}
		
	System.out.println(maxLen);

	}
}
