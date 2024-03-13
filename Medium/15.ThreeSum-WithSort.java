class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 1. Sort the array to use Two Pointer
        Arrays.sort(nums);

        // 2. Continue only if first element is less than 0;
        // If First element is > 0, and array is sorted, it means all values in array are > 0 and positive, so their sum cannot be equal to zero
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {

                // TO use Two Pointer, we keep a third constant and make a window with two pointers for other 3 variables
                // [-4,-1,-1,0,1,2] => current = -4; low = -1 and high = 2 (low and high form a window)
                twoSumII(nums, i, res);
            }
        return res;
    }


    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        // [-4,-1,-1,0,1,2] => current = -4; low = -1 and high = 2 (low and high form a window)
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];

            // Similar logic from Two Sum, refer snippet below:
            // if(numbers[a]+numbers[b] > target)
            //     b--; // Manipulating the largest
            // else
            //     a++; 

            // Manipulate the window boundaries based on sum
            if (sum < 0) { 
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));

                // // Manipulate the window boundaries based on window pointers, to skip duplicates
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }
}