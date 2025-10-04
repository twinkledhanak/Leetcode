// FIRST BACKTRACKING PROBLEM TO HAVE MEMOISATION

// This code gives TLE for some cases
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
        // *****************************
        int furthestJump = Math.min(position + nums[position], nums.length - 1);

        // For a given pos, all places you can reach is : [pos+1,farthest pos]
        // Checking all indexes, from pos + 1 until the farthest you can go 
        // Whichever returns true
        // ***** NOTE the <= , instead of just <
        // WE START FROM POS + 1
        for (int i = position + 1; i <= furthestJump; i++) { // ********* Note the condition for furthest jump
            if (helper(i, nums)) {
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

// Backtracking with Memoisation (Recursion) - DP - Top Down
//Time: O(n2)
//Space: O(n)

// DP - Bottom up Tabulation / Iterative
//Time: O(n2)
//Space: O(n)


// GPT -> Memoisation + backtracking
public class Solution {

    public boolean canJump(int[] nums) {
        Boolean[] memo = new Boolean[nums.length]; // memo[i] stores: can we reach the end from i?
        return helper(0, nums, memo);
    }

    public boolean helper(int position, int[] nums, Boolean[] memo) {
        if (position == nums.length - 1) {
            return true;
        }

        if (memo[position] != null) 
            return memo[position];

        int furthestJump = Math.min(position + nums[position], nums.length - 1);

        for (int i = position + 1; i <= furthestJump; i++) {
            if (helper(i, nums, memo)) {
                memo[position] = true;
                return true;
            }
        }

        memo[position] = false;
        return false;
    }
}





// We use MEMOISATION along with backtracking -
// What is being cached here?
// The indices!!!!!!!!
enum Index {
    GOOD, BAD, UNKNOWN // We can just use numbers to differentiate: -1: Unk, 0: Bad, 1: Good
}

public class Solution {
    Index[] memo;

    public boolean canJump(int[] nums) {
        // [UNK, UNK, UNK]
        // idx: 0, 1, 2
        // [Bad, Good, Good]

        // Memoisation steps
        // Step 1: Initially everything is UNKNOWN
        // Note the array data type here
        memo = new Index[nums.length]; // Yesss, same length only, not n+1, why? We want to reach last index which is (n-1)
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
        // If it is a good index, we know we will reach the end 
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        // DECISION LOGIC AT EACH STEP, we have to set values as Good or Bad

        // We want to make maximum possible jumps at every step, eg, 3 -> Instead of going for 1+2 or 1+1+1 , we go 3
        // Incorrect ->  memo[position] = choices => 3 (we can make jumps of length 1,2,3 but max is 3)
        // if position + memo[position] = (from idx)1 + (val)3 = (idx)4 -> if this is beyond our array bounds -
        // But we dont want to go beyond the array bounds
        // So we cut it off at array length
        // Max Jump we can make is only till we reach the end of array
        int furthestJump = Math.min(position + nums[position], nums.length - 1);

        for (int i = position + 1; i <= furthestJump; i++) {
            if (helper(i, nums)) { // Let the function decide
                memo[position] = Index.GOOD; // @#$%^&*(*&^%$#@!@#$%^&*)
                return true;
            }
        }

        // If we still made it until here, outside the loop, index is bad
        memo[position] = Index.BAD;
        return false;
    }

    
}

// For above: O(n^2) ; O(n)

// Backtracking of TLE: O(2^n) ; O(n)
// Greedy is O(n); O(1)
// Refer to LIS before Jump Game2


// GRREEDDDDYYYYYYY

public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;

        // Start iterating from last position
        // Until the first position - since we want to know if we can reach the end FROM the START pos
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0; // we have to determine if we can reach the end from the start
    }
}