import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
        //Binary Subarrays With Sum
        //Before moving on with question we need to know how prefix sum works and how it is used to solve this 
        //you need to understand Longest subarray with given Sum(positive)
        //Longest subarray with given Sum(positive)(negatives)
        //Count Subarray sum Equals K 
        //as this gives the solution to the problem
        //we are trying not to use hash map as it may take alot of space 
        //we want to reduce the space complexity
        //for that we are using two pointers approach.
        //normally we can't iterate with two pointers in this problem.
        //as we don't know when to move left or right.
        // in that sense or confusion we are trying to find subarrays less than goal
        //Time Complexity: O(2N);
        //Space Complexity: O(N) it used to be O(N) x Log N based on the Hash Map 
        //input: nums = [1,0,1,0,1] goal =2
        //output: 4
        
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<nums.length; i++){
		    nums[i] = sc.nextInt();
		}
		
		//here we are finding the subarrays less than or equal to goal.
		//here with the help of the func method we are first trying to find the subarrays equal to the sum goal
		//then we are finding the subarrays equal to the sum which is goal-1
		//this gives all the subarrays which are less than goal.
		//now we subtract the count of goal-1 subarrays from goal subarrays
		
        System.out.println(func(nums, goal) - func(nums, goal-1));
    }

    public int func(int[] nums, int goal){
        //this is a base condition because when goal is equal to 0 then goal-1 would be -1, which is negative which means there's no subarrays so we return 0;
        if(goal< 0) return 0;
        //declare and initialise left, right, sum, count =0;
        int l =0; int r =0; int sum=0; int cnt=0;
        //we are looping a while loop which is less than nums.length
        while(r < nums.length){
            //we add the nums[r] to the sum variable
            sum += nums[r];
            //now we make sure if the sum crosses goal then we try to reduce it by moving left variable
            //here while we are moving the left we need to subtract the element.
            //if element is zero then we again loop.
            //if element is one then we may reduce the sum and it may be less than or equal to the goal
            while(sum > goal){
                //remove nums[l] from the sum variable
                sum = sum - nums[l];
                //increase the left variable
                l++;
            }
            //now increment the count by adding length of the subarray
            cnt = cnt + (r-l+1);
            //increment right
            r++;
        }
        return cnt;
    }
}
