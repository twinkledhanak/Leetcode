// Top down - Recursion + Memoization

class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    private int[] nums;
    
    private int dp(int i) {
        // Base cases
        if (i == 0) return nums[0]; // index is 0, so 1 element
        if (i == 1) return Math.max(nums[0], nums[1]); // index is 1, so two elements
        if (!memo.containsKey(i)) {
            memo.put(i, Math.max(dp(i - 1), dp(i - 2) + nums[i])); // Recurrence relation
        }
        return memo.get(i);
    }
    
    public int rob(int[] nums) {
        this.nums = nums;
        return dp(nums.length - 1); // Passing the last Index
    }
}