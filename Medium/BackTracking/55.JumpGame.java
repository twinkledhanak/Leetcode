// Simple Backtracking solution, but Bruteforce.
// Time: O(2 raised to n)
// Space: O(n)
public class Solution {

    public boolean canJump(int[] nums) {
        // helper function is called
        return helper(0, nums); // We can pass a list to store combinations
    }


    public boolean helper(int position, int[] nums) {
        // end condition -> if position is final index, we are good. Can store values here if needed
        if (position == nums.length - 1) {
            return true; // we just need to return T/F based on condition
        }

        // DECISION LOGIC AT EACH STEP

        // We want to make maximum possible jumps at every step, eg, 3 -> Instead of going for 1+2 or 1+1+1 , we go 3
        int furthestJump = Math.min(position + nums[position], nums.length - 1);

        // For a given pos, all places you can reach is : [pos+1,farthest pos]
        // Checking all indexes, from pos + 1 until the farthest you can go 
        // Whichever returns true
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (helper(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }
}

// BRUTEFORCE BACKTRACKING, BUT NOW OPTIMISING IT WITH MEMOISATION

// Initially, all elements of the memo table are UNKNOWN, except for the last one, which is (trivially) GOOD (it can reach itself)
// Modify the backtracking algorithm such that the recursive step first checks if the index is known (GOOD / BAD)
// If it is known then return True / False
// Otherwise perform the backtracking steps as before
// Once we determine the value of the current index, we store it in the memo table

//Time: O(n2)
//Space: O(n)

enum Index {
    GOOD, BAD, UNKNOWN
}

public class Solution {
    Index[] memo;

    public boolean canJump(int[] nums) {
        // Memoisation steps
        // Step 1: Initially everything is UNKNOWN
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        // Step 2:
        // Trivial case, when on last index, we are already there, so it is good
        memo[memo.length - 1] = Index.GOOD;



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