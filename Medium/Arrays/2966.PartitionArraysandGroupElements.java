class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length / 3][3];
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            ans[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return ans;
    }
}

/**
1 element can be a part of only 1 partition
Sorting the array
Traverse elements in increments of 3 (rather than grouping or other permutation logic)
Since sorted, only the extremes needed to be compared to satisfy <= k criteria
That is the main takeaway, all elements diff <= k, but we only compare the extremes - since each partition is already sorted
*/