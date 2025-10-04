/**
Kadane's algorithm, example of Dynamic programming
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];

        for(int i=1; i<nums.length; i++){
            // Whole logic: take current element or running sum and current element, whichever is maximum
            currSum = Math.max(nums[i], currSum+nums[i]);
            maxSum = Math.max(maxSum,currSum);
        }

        return maxSum;
    }
}

// Time: O(n)
// Space: O(1)