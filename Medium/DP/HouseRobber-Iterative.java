
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length]; // it is already n+1, we have 1 based houses, !@#$%^&*()(*&^%$#$%^&*(*&^%$#@#$%^&*))
        // I was doing int[nums.length+1] which is incorrect

// SIMPLE CONDITIONS BUT NOT TO MISS
        if(nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);
        
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2],dp[i-1]); // Max (choice1,choice2)
            // Max( consider prev house; consider prevprev house + current)
        }

        //return dp[nums.length-1]; //******* My result is stored in last index */
        // STOPP writing results in terms of input variables; it may or may not work always
        return dp[dp.length-1];
    }
}

// Super proud, did it myself
// Started from base case and was building up, but got confused in writing recursive approach instead
// Decide how you're going, from building up or down ; their complexity is better so we explain the recursive first and 
// then explain the iterative approach

/*
At house 4 -> choices are
Max(choice1, choice2)

choice1: consider current house:4 and max money until 2 houses before (house:2)
choice2: discard current house and consider it's previous adjacent(house:3)

I'm referring to previous values but moving in upward/forward direction

*/