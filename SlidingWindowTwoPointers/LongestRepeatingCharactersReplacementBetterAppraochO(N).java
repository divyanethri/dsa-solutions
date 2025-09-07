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
	    //Time Complexity: O( N)
	    //in this we try to repalce while loop with a condition
	    //Space Complexity: O (k)
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
            //this while loop is replaceced with if condition
            //so that time complexity decreases
            //and important thing is we don't need to find a length less length than maxLength
            //for that reason we maintain a constant window.
            //everytime we maintain a constant window
            if(((r-l + 1)- maxFreq) > k){
                // now we need to move left towards right
                //which means we need to reduce the frequency of that character
                hash[s.charAt(l) - 'A']--;
               
               //we removed the maxfreq as we don't need to reupdate the maxfreq
               //length - maxFreq <= k
               //there is no point in downgrading or decreasing it to lesser value than max freq as it will yield length which will be lesser than maxlen.
               
               //why will we find value lesser than maxLength?
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
