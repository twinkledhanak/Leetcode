class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // Case 1: Rob from house 0 to n-2 (exclude last)
        int max1 = robLinear(Arrays.copyOfRange(nums, 0, n - 1));

        // Case 2: Rob from house 1 to n-1 (exclude first)
        int max2 = robLinear(Arrays.copyOfRange(nums, 1, n));

        return Math.max(max1, max2);
    }

    private int robLinear(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }
}
