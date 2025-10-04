public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        // dp[0] = 0; -> can be done
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

// Time: O(n); Space: O(n)
// Refer the recursion solution for more explanation on i-1 and i-2 VS i+1 and i+2
/*

🔍 Why do we only consider dp[i-1] and dp[i-2]?

Because those are the only steps you can take at any point.

From step i-1, you can take 1 step to reach i.

From step i-2, you can take 2 steps to reach i.

There is no way to reach step i from step i-3 in a single move if you can only take 1 or 2 steps at a time.

*/