class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1, mid = 0, result = -1;
        while(low <= high){
            mid = low + (high - low) / 2;

            if(target == nums[mid])
                return mid;       
            else{
                // Search left or right
                if(target < nums[mid])
                    high = mid-1;
                else 
                    low = mid+1;
            } 
        }
        
        return result;

    }
}
