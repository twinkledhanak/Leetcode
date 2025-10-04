
// We can pass both i, n (all condition variables)
// Create separate functions
public class Solution {
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
}

// Without Memo, Time: O(2^n), Space: O(n)
// Time: O(n), Space: O(n)

/*
Why i+1 and i+2?
Draw the recursion tree by Pepcoding
rotate that tree, from top to bottom
We have to traverse that tree now (from top to bottom - which is recursion)
so, we go from 0 to 1,2
hence, i+1 and i+2
Because each time you recurse, you’re already "making the move." The move itself doesn’t count as a new way — only reaching n does.
So, NOT (1+f(i+1)) and (1+f(i+2))

So, then why is DP solution from i-1 and i-2?
We create an array in DP and store previous solutions
We are doing bottom up, meaning, using the base cases to derive the final solution.
To refer the base cases, we have to refer previous indexes in this case and previous is at i-1 and i-2
*/