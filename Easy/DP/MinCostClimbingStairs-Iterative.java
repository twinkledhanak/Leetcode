class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // The array's length should be 1 longer than the length of cost
        // This is because we can treat the "top floor" as a step to reach

        // dp[i] represents the cost to reach the ith step (arrive beyond step i)
        int dp[] = new int[cost.length + 1];
        
        // Start iteration from step 2, since the minimum cost of reaching
        // step 0 and step 1 is 0
        // Step 0 and Step 1 is free as problem indicates. No cost to just be there on these two steps
        // When we reach step 2, it could be from either 0 or 1
        // we will have to consider the min cost to reach 0 and cost to jump from 0 to 2
        // we will have to consider the min cost to reach 1 and cost to jump from 1 to 2
        // Minimum of these two choices
        for (int i = 2; i < dp.length; i++) {
            int takeOneStep = dp[i - 1] + cost[i - 1];
            int takeTwoSteps = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(takeOneStep, takeTwoSteps);
        }
        
        // The final element in dp refers to the top floor
        return dp[dp.length - 1]; // ***** cost is expressed in terms of a different variable
        // but, it still returns the last element of the array
    }
}

// The DP is for cost for every stairs; not for no of ways 
// Hence we maintain a mincost array, not any array for no of distinct ways
// Time: O(n); Space: O(n)

// If we just write - Min(dp[i-1],dp[i-2]) => it means we are only considering the fact we have reached i-1 or i-2.
// We havent considered the cost of jump from i-1 to i OR i-2 to i