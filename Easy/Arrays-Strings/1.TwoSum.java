// Two pass:
// Time: O(n), Space: O(n)
// ***************
// Remember to return empty array
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        // In case there is no solution, return an empty array
        return new int[] {};
    }
}

// One pass:
// Time: O(n), Space: O(n)
// Remember to return empty array
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) { // 1. WE NEED NOT CHECK THE INDEX AND COMPLEMENT'S INDEX
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // Return an empty array if no solution is found
        return new int[] {};
    }
}