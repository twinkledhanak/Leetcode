/**
LC Official:

Bottom UP / Tabulation 
*/

public class Solution {
  public int coinChange(int[] givenCoins, int amount) { // Eg. [1,2,5] = i => 11
    int max = amount + 1;
    // dp[amount] = min no of givenCoins needed to make that amount

    int[] dp = new int[amount + 1]; // we make i array of size one greater.
    Arrays.fill(dp, max); /// *************** We may end up making a larger amount than expected

    dp[0] = 0;
    for (int i = 1; i <= amount; i++) { // we have to fill up table for all amounts

    // for all the choices that we have -
      for (int coin = 0; coin < givenCoins.length; coin++) { 
        if (givenCoins[coin] <= i) {
          // i - givenCoins[coin] => eg. dp[11] = dp[11-coin1] + 1 = dp[10] + 1
          dp[i] = Math.min(dp[i], dp[i - givenCoins[coin]] + 1); // dp[i] already has some max value
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }
}

// if the recurrence relation has minCoins(int amount) and we have minCoins(9) => We have to express minCoins(9) in terms of dp arr
// If the array indexes represent amount, dp[11] depends on dp[9] => dp[i] depends on dp[i - coin of deno 1]
// If the array indexes represent amount, dp[11] depends on dp[9] => dp[i] depends on dp[i - coin of deno 5]
// If the array indexes represent amount, dp[11] depends on dp[9] => dp[i] depends on dp[i - coin[j]]





// Recursion with DP, Memoisation -> Top down approach
class Solution {

    int[] dp;
    public int coinChange(int[] givenCoins, int amount) {
        // Initialisation
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        // Call recursion function
        int ans = helper(givenCoins, amount);
        return (ans == Integer.MAX_VALUE) ?  -1 : ans;
    }

    int helper(int[] givenCoins, int amount) {

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
        for(int i = 0; i < givenCoins.length; i++) {
            int ans = helper(givenCoins, amount - givenCoins[i]);

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



public class Solution {

  public int coinChange(int[] givenCoins, int amount) {
    if (amount < 1) // we first check the amount, corner cases
        return 0;

    return coinChange(givenCoins, amount, new int[amount]);
  }

  private int coinChange(int[] givenCoins, int rem, int[] count) {
    if (rem < 0) 
        return -1; // no possibility of anything
    if (rem == 0) 
        return 0;
    if (count[rem - 1] != 0) 
        return count[rem - 1];

    int min = Integer.MAX_VALUE;
    for (int coin : givenCoins) {
      int res = coinChange(givenCoins, rem - coin, count);
      if (res >= 0 && res < min)
        min = 1 + res;
    }
    count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
    return count[rem - 1];
  }
}