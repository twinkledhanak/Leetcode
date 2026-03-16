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


// Latest Feb 2026

If shrinking is meant to FIX the window → shrink on violation
If shrinking is meant to OPTIMIZE the window → shrink on validity

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start=0, end=0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for(end=0; end<nums.length; end++){
            sum += nums[end];
            
            // window validity needs optimisation (shrinking is not present to fix anything broken)
            while(sum >= target){
                minLen = Math.min(minLen, end-start+1);
                sum -= nums[start];
                start += 1;
            }
            
        }

        return minLen == Integer.MAX_VALUE? 0 : minLen;
    }
}
