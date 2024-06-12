
// RECURSIVE APPROACH WITH MEMOIZATION
class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<>();
    
    private int dp(int i) {
        if (i <= 2) return i;
        // Instead of just returning dp(i - 1) + dp(i - 2), calculate it once and then
        // store it inside a hashmap to refer to in the future
        if (!memo.containsKey(i)) {
            memo.put(i, dp(i - 1) + dp(i - 2));
        }
        
        return memo.get(i);
    }
    
    public int climbStairs(int n) {
        return dp(n);
    }
}


// ITERATIVE APPROACH 
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        
        // An array that represents the answer to the problem for a given state
        int[] dp = new int[n + 1]; 
        dp[1] = 1; // Base cases
        dp[2] = 2; // Base cases
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Recurrence relation
        }
        
        return dp[n];
    }
}