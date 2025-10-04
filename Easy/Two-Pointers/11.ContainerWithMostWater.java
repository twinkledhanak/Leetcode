class Solution {
    public int maxArea(int[] nums) {
        int i=0;
        int j=nums.length-1;

        int maxArea = Integer.MIN_VALUE;

        while(i<j){
            int area = (j-i) * (Math.min(nums[i],nums[j]));
            maxArea = Math.max(maxArea,area);
            if(nums[i]<=nums[j]) i++; // Note the <= here, not just <
            else j--;
        }
        
        return (maxArea == Integer.MIN_VALUE)? 0: maxArea;
    }
}

Time complexity: O(n). Single pass.

Space complexity: O(1). Constant space is used.