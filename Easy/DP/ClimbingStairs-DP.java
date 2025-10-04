// Direct Recursive approach
public class Solution {
    public int climbStairs(int n) {
        return climb_Stairs(0, n);
    }

    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        // ******** Why do we return 1? It represents the No of ways to go from s to n, we atleast found 1 way
        // #$%^*&^%$#$%^&^&**((*^%$#@#$%))
        if (i == n) {
            return 1; // If it was cost, it can be return i
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }
}

// Problem is in Time complexity
// T: O(2^n) -> (Fan-out)^(height) = (Fan-out)^(No of nodes)
// No of choices = fan out = 2

// Space: O(n)




// RECURSIVE APPROACH WITH MEMOIZATION
class Solution {
    // Either make it global at class level or pass it as a param
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