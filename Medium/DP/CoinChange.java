
// Recursion with DP, Memoisation -> Top down approach
class Solution {

    int[] dp;
    public int coinChange(int[] coins, int amount) {
        // Initialisation
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        // Call recursion function
        int ans = coinCount(coins, amount);
        return (ans == Integer.MAX_VALUE) ?  -1 : ans;
    }

    int coinCount(int[] coins, int amount) {

        // Base case
        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return Integer.MAX_VALUE;
        }

        // reading Cache for values, if they exist
        if(dp[amount] != -1) {
            return dp[amount];
        }

        int minCoins = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int ans = coinCount(coins, amount - coins[i]);

            if(ans != Integer.MAX_VALUE) {

                //we have returned 0 in ans, so now we are updating the ans count
                //hence 1 + ans
                minCoins = Math.min(minCoins, 1 + ans);
            }
        }
        return dp[amount] = minCoins;
    }
}

Time complexity : O(S*n). where S is the amount, n is denomination count.
In the worst case the recursive tree of the algorithm has height of S and the algorithm solves only S subproblems because it
 caches precalculated solutions in a table. Each subproblem is computed with nnn iterations, one by coin denomination. 
 Therefore there is O(S*n) time complexity.

Space complexity : O(S), where S is the amount to change
We use extra space for the memoization table.