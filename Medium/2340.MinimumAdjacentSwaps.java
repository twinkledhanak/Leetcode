
class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;

        if(n==1)
            return 0;


        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        int minPosIndex = -1;
        int maxPosIndex = Integer.MIN_VALUE;
        int minSteps = 0;

        // To get the min/max value and in case of duplicate min/max, get the ones closer to their end
        // smallest is closer to start of array
        // largest is closer to end of array
        for(int i=0; i<n; i++){
            if(minVal > nums[i]){
                minVal = nums[i];
                minPosIndex = Math.max(minPosIndex,i); // 5 goes to n-1
            }

            if(nums[i] >= maxVal){
                maxVal = nums[i];
                maxPosIndex = Math.max(maxPosIndex,i); // 1 goes to 0
            }


        }

        //System.out.println("Min element: "+minVal+" at pos: "+minPosIndex);
        //System.out.println("Max element: "+maxVal+" at pos: "+maxPosIndex);

        // if max is on right and min is on left, how to calculate steps such that smallest number is closer to start and largest is closer to end
        if(minPosIndex < maxPosIndex){
            minSteps = (n-1-maxPosIndex) + minPosIndex;
        }
        if(minPosIndex > maxPosIndex){
            minSteps =  (n-1-maxPosIndex) + minPosIndex - 1;
        }
        

        return minSteps;

    }


}