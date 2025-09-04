import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
			
		//Number of Substring Containing all three characters Optimised Approach
		//Time Complexity = O(N);
		//Space Complexity = O(K)
		//Optimised Approach
		//input: bbacba
		//output: 9
		
		//call the find substrings method
	    int res = findSubstrings(s);
	    //print the substrings count
        System.out.println(res);
    }
    
    //define the function
    public int findSubstrings(String s){
        //declare count
        int count = 0;
        //create a static array and initialise with -1 values.
        int[] lastseen = {-1,-1,-1};
        
        //loop through the String, this approach only takes 1 loop
		for(int i=0; i<s.length(); i++){
		    //this we are assigning i index as value tothe respective character
		    //this syntax is important
		    // 'a' - 'a' = 0
		    // lastseen[0] = i;
		    //'b' - 'a' = 1
		    //lastseen[1] = i;
		    // 'c' - 'a' = 2
		    //lastseen[2] = i
            lastseen[s.charAt(i) - 'a'] = i;
            //if lastseen is not equal to -1
            //which means it has some index.
            if(lastseen[0] != -1 && lastseen[1] != -1 && lastseen[2] != -1  )
            {
                // then we need to find out the minimum index from three indexes.
                //from minimum index we understand that 
                // three character substring has occured and from that all the characters towards left also forms a substring
                // so we try to find the minimum index of the substring 
                //add 1 to it because we already have one substring from where we are findind the minimum
                //for finding the minimum we need to define a function
                count = count + ( 1 + findMin(lastseen[0], lastseen[1], lastseen[2]));
    
            }

		}
		//return the count
    return count;
     }
     //this function returns the minimum index value.
     public int findMin(int a, int b, int c){
        if(a < b && a< c) return a;
        else if(b< a && b < c) return b;
        else return c;
     }
}
