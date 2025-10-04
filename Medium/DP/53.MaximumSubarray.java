// Sumeet Sir
class Solution {
    public int maxSubArray(int[] nums) {
        // Goal is to make a choice for every element
        // To include or exclude it

        if(nums.length == 0)
            return 0;

        int localSum = nums[0];
        int globalSum = nums[0];

        for(int i=1; i<nums.length; i++){
            if(localSum >= 0)
                localSum += nums[i];
            else
                localSum = nums[i];

            if(localSum > globalSum)
                globalSum = localSum;        
        }

        return globalSum;

    }
}

/*
When we can have multiple sub arrays in a given array,
element has a choice - to be in a prev sub array or to start a new one from itself

A given problem might have a requirement for maximum sum
So consider the sum property everytime for an element 
When a element is IN or OUT of choice, it will affect the sum [requirement]

7 -14 x
When making a choice for -14, we do not consider what is there in future
We make a decision based on the previous: local max sum; global max sum; etc

When exploring these two choices for every element, we are calculating sum & storing values
*/


/**
Main Intuition:
Keep track of two variables-
One variable for keeping the track of running sum
One variable for keeping the track of maximum sum

Another intuition is that we cannot use Sliding Window here as we have negative numbers
It may or may not give correct answer always

The idea is that if we have a negative number, it is useless. 
If we encounter a negative number, but if it a small number so that overall sum is still positive, so we can still consider it.

[-2,1,-3,4,-1,2,1,-5,4]

Even more advanced solution uses Divide and Conquer + Recursion
Time: O(nlogN) and Space: O(n)

Overall logic: Max sum from LHS + Max sum from RHS + middle element = Best combined sum (Max)
*/


class Solution {
    public int maxSubarray(int[] nums) {
        // Initialize our variables using the first element.
        // There is no sum refrence we have so far, so instead of initializing to some random val -1
        // Start the array
        int currentSubarraySum = nums[0];
        int maxSubarraySum = nums[0];

        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            currentSubarraySum = Math.max(nums[i], currentSubarraySum + nums[i]); // [4,-1,2,1]
            maxSubarraySum = Math.max(maxSubarraySum, currentSubarraySum);
        }

        return maxSubarraySum;
    }
}

// Time: O(n) ; Space: O(1)

// Divide and Conquer
/*
If we were to split our input in half, then logically the optimal subarray either:

Uses elements only from the left side
Uses elements only from the right side
Uses a combination of elements from both the left and right side
Thus, the answer is simply the largest of:

The maximum subarray contained only in the left side
The maximum subarray contained only in the right side
The maximum subarray that can use elements from both sides

*/