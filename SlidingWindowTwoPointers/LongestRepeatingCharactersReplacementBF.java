import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		//k is the number of characters we can replace at a time
		//Longest Repeating Character Replacement Brute Force
		int k = sc.nextInt();
		String s = sc.next();
		int maxLen= 0;
		//Brute Force
		//Time Complexity: O(N x N)
		//Space Complexity: O(K)
		
		//input 1: ABABBA output: 5
		//input 2: AAABBCCD output: 5
		
		//loop through the string
		//this loops create all the possible substrings
		for(int i=0; i<s.length(); i++){
		    // while the outer loop is running
		    //everytime create a hash array of size 26
		    // initialise maxfrequency
		    int[] hash = new int[26];
		    int maxfreq =0;
		    //do inner loop from the i index
		    for(int j=i; j<s.length(); j++){
		        // now, increment the count
		        //this below syntax is to increment the element in the index of equivalent to the character ascii
		        hash[s.charAt(j) -'A']++;
		        // get the max freq by passing max freq and the hash of that character
		        maxfreq = Math.max(maxfreq, hash[s.charAt(j) -'A']);
		        //now to find out if the substring is valid or not.
		        // we need to find out how many different characters are present in the substring
		        // we need to substract max freq from the substring length
		        // we find substring left by J - I + 1
		        
		        int changes = j-i+1 - maxfreq;
		        // if the changes variable is less than or equal to k which means it is a valid substring.
		        //so find the max Length from the max len and the length of the substring
		        if(changes<=k){
		            maxLen = Math.max(maxLen, j-i+1);
		        }// is it not a valid substring then we don't need to parse entire the loop 
		        // so break from the loop.
		        else{
		            break;
		        }
		        
		    }
		}
		///print the maxLength
		System.out.println(maxLen);

	}
}
