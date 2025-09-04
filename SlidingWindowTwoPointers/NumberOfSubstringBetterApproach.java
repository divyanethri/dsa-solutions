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
		
		//Number of Substring Containing all three characters Better Approach
		//Time Complexity = O(2N);
		//Space Complexity = O(K)
		//Better Approach
		//input: bbacba
		//output: 9
		
				
		//this is unlike Longest substrings problems, in that we need longest.
		//Here we want count of substrings.

		//declare count
		int count = 0;
    
        //loop through the string
		for(int i=0; i<s.length(); i++){
		    //create a map everytime the outer loop iterates
		    Map<Character, Integer> map = new HashMap<>();
		    //loop through the string from ith index
		    for(int j=i; j<s.length(); j++){
		        //select the character
		        char c = s.charAt(j);
		        //now add the character into the map, if the char already exists then increment the value.
				//else if it is not then add 1
		        map.put(c, map.getOrDefault(c, 0)+1);
		        //if the map.size() == 3 which means there are all the characters there in the map.
		        if(map.size()==3){
		            //for better approach we will add to the count the remaining length of the string.
		            //as we already have the three characters substring in the map
		            //so all the remaining characters forms the substring as well.
		            //find those characters length i.e., (s.length() - j);
		            count = count + (s.length() - j);
		            //remember to break from the loop.
		            //as you already calculated the all the substrings.
		            break;
		            
		        }
		    }

		}
		//return the count
		System.out.println(count);

	}
}
