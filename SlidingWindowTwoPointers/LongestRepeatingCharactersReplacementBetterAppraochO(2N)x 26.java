import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc = new Scanner(System.in);
	    String s = sc.next();
	    int k = sc.nextInt();
	    //Longest Repeating Character Replacement Better Approach
	    //Time Complexity: O( N + N) X 26
	    //Space Complexity: O (k)

        //input 1: ABABBA output: 5
		//input 2: AAABBCCD output: 5
        
	    //the string only has uppercase letters
	    //This is a better approach as we move left pointer towards right
		int res = findCharReplacement(s, k);   
        return res;     
    }
    public int findCharReplacement(String s, int k){
        //declare left, right, maxLen, maxFreq
        //declare a hash array of length 26
        int l =0;
        int r =0;
        int maxLen =0;
        int maxFreq =0;
        int[] hash = new int[26];
        //we need to loop till right is less than the length of the strin
        while(r < s.length()){
            //now at the character index 'B' - 'A' = 1
            //which means hash[1]++
            //increment the count of that character (frequency)
            hash[s.charAt(r) - 'A']++;
            //now calculate the maxFreq
            //for this you need to do
            //calculate max between maxFreq and the frequency of that character
            maxFreq = Math.max(maxFreq,hash[s.charAt(r) - 'A']);
            
            //now if the elements which are unique is greater than k 
            //(r-l +1 ) - MaxFreq gives how many other characters are there
            // so by that we can analyse if we can replace the number of characters
            while(((r-l + 1)- maxFreq) > k){
                // now we need to move left towards right
                //which means we need to reduce the frequency of that character
                hash[s.charAt(l) - 'A']--;
                //then we need to initialise mazfreq to 0
                //so that we can again find the maxfreq in that new generated substring
                maxFreq =0;
                //now by looping all the 26 elements we need to find which has max frequency
                for(int i=0; i<26; i++){
                    maxFreq = Math.max(maxFreq, hash[i]);
                }
                //we need to move left towards right by incrementing 1
                l++;

            }
            
            // (r-l +1 ) - MaxFreq gives number less than or equal to k then we can replace the characters and make it valid
            if(((r-l + 1)- maxFreq) <= k){
                //in this case we can find the max length
                maxLen = Math.max(maxLen, r-l+1);
            }
            //always make sure to increment the right
        r++;
        }
        //return the maxLength
    return maxLen;

	}
}
