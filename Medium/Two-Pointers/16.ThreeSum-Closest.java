class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // Instead of anything random, rely on num array to initialize final value
        // I had used Integer.MAX_VALUE
        int result = nums[0] + nums[1] + nums[2];

        // Same as 3 sum
        for (int i = 0; i < nums.length - 2; i++) {
            // No need to check for duplicate values

            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                // if my sum has some diff, result has some diff wrt target
                // result diff is greater? It is farthest from target
                // Idea: At every triplet sum, compare it with prev and save the sum
                // We return result and it will have value of sum closest to target
                // REMEMEBER TO USE Math.abs(...) for distance from the centre
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }

                if (sum < target) // In a sorted array, 
                    j++; // we move towards target
                else k--;
            }
        }
        return result;
    }
}