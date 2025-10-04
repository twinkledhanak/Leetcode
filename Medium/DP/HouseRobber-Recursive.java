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


// this also worked
class Solution {
    public int rob(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        return helper(nums.length-1,nums,map);
    }

    public int helper(int i, int[] nums, Map<Integer,Integer> map){
        // only put condition for 0 -> 1 automatically worked
       if(i < 0)
        return 0;

       if(map.containsKey(i))
        return map.get(i);


        map.put(i,Math.max(helper(i-1,nums,map), helper(i-2,nums,map) + nums[i])); 
        return map.get(i);

    }
}