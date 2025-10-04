// Imp learning is when to use 2 IF statements & when to use IF-ELSE

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int a = 0;
        int b = nums.length-1;
        
        while(a<b){
            if(a!=b && nums[a]+nums[b] == target)
                return new int[]{a+1,b+1};
            if(nums[a]+nums[b] > target)
                b--;
            else // writing another if would not have helped here. Imp - we have an else here
                a++;        
        }
        return new int[]{-1,-1};

    }
}

// We have to take advantage of the fact that array is sorted
// We just have different conditions for a and b

// Time: O(n) as we go over the entire array once
// Space: O(1) as we are just storing values in pointers & using them for comparison

// Taking care of Overflows (AS A FOLLOW-UP)

// 1. Typecast everything to long
// long sum = (long) numbers[low] + (long) numbers[high];

// 2. Use overflow check
// Cannot write it as low+high > max so instead we re-write it as : low > max- high
if (numbers[low] > 0 && numbers[high] > 0 && numbers[low] > Integer.MAX_VALUE - numbers[high]) {
    high--; // Prevent overflow
} else {
    // above code
}