class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int runningSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0, windowEnd = 0;


        for(int x: nums){
            runningSum += x;
        }
        if(runningSum < target)
            return 0;
        else if(runningSum == target)
            return n;
        else {
            runningSum = 0;
            for(windowEnd = 0; windowEnd < n; windowEnd++){
            runningSum += nums[windowEnd];

            while(runningSum >= target){
                // time to calculate length
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                runningSum -= nums[windowStart];
                windowStart ++;
            }
        }
        }
        

        return minLength;

    }
}
