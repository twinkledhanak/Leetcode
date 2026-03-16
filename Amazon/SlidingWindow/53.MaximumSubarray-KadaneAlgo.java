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

// Feb 2026 solution:
class Solution {
    public int maxSubArray(int[] nums) {
        
        int start=0, end=0;
        int sum = 0;
        int maxSum = nums[0];

        for(end=0; end<nums.length; end++){
            // letting window grow
            sum += nums[end];
            maxSum = Math.max(maxSum, sum);
            // correct when sum gets negative
            // but what if all values in array are negative
            if(sum < 0){
                sum = 0;
            }

            
        }

        return maxSum;
    }
}