
enum Index {
    GOOD, BAD, UNKNOWN
}

public class Solution {
    Index[] memo;
    int[] costmemo;

    public boolean canJump(int[] nums) {
        // Memoisation steps
        // Step 1: Initially everything is UNKNOWN or Zero
        memo = new Index[nums.length];
        cost = new int[nums.length];

        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
            cost[i] = 0; 
        }

        // Step 2:
        // Trivial case, when on last index, we are already there, so it is good
        memo[memo.length - 1] = Index.GOOD;
        cost[0] = 0;
        cost[1] = 1;

        // Same as bruteforce call
        return helper(0, nums);
    }

    public boolean helper(int position, int[] nums) {

        // Setting values for memo based on different conditions

        // Use memo table for existing values first
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        // DECISION LOGIC AT EACH STEP

        // We want to make maximum possible jumps at every step, eg, 3 -> Instead of going for 1+2 or 1+1+1 , we go 3
        int furthestJump = Math.min(position + nums[position], nums.length - 1);

        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (helper(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        // If we still made it until here, outside the loop, index is bad
        memo[position] = Index.BAD;
        return false;
    }

    
}