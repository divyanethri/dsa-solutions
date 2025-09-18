import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//Longest Substring with at most k Distinct Characters Better Approach
		//input: s = aaabbccd k = 2
		//output: 5
		//Time Complexity: O(N) + O(N) = O(2N)
		//Space Complexity: O ( log (256))
		//based on map it might take up to log of (256)
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int k =sc.nextInt();
		//create a map for storing characters count
		Map<Character, Integer> map = new HashMap<>();
		int maxLen = 0;
		
		int l = 0;
		int r = 0;
		//we are declaring and initialisizing, map maxlen, left (l) and right(r) variables
		
		//loop through till r is less than string length
		while(r < s.length()){
		    //put the character in the map if it doesn't exist then increment the frequency or the count
		    map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
		    //now if the map size is greater than k then remove the elements from the left
		    //increment the left
			//This loop goes N only
		    while(map.size() > k){
		        //decrease the count of the left count 
		        map.put(s.charAt(l), map.get(s.charAt(l))-1);
		        //if the count of l indexed character is equal to 0 then there is not such character
		        //we can remove it from the map
		        if(map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
		        // now increment the left index
		        l++;
		    }
		    //check if the map size is less than k 
		    // that means the substring is valid
		    //we can now calculate the maxLen
		    if(map.size() <= k){
		        maxLen = Math.max(maxLen, r-l+1);
		    }
		    //increment the right index everytime
		    r++;
		}
		
	System.out.println(maxLen);

	}
}
