//https://leetcode.com/problems/subarray-sum-equals-k/editorial/?envType=study-plan-v2&envId=apple-spring-23-high-frequency
/*
It is looking like sliding window ; but it is not sliding window
WHY WILL SLIDING WINDOW NOT WORK?
A. CONSTRAINTS MENTION WE HAVE NEG NUMBERS
B. WE FAIL CASES WHERE MULTIPLE SUBARRAYS OVERLAP EACH OTHER , [1,2,3] => sum = 3 ; answers are [1,2] and [3]


Deals with prefix sum and storing them in hashmaps 

Store prefix sum until all indices (y)
Mark the freq of each sum (y,1)
Subtract the target from fre sum => (y-k)
If we have encountered (y-k) earlier, it means that we have an array of sum k
*/


// NO SLIDING WINDOW -- CANNOT BE USED IF ARRAY HAS NEGATIVE INTEGERS

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // At current index, we got some value sum. y.
            // Somewhere, we already have y-k stored with non-zero freq
            // at this point, at current index, we search for sum-k, i.e, y-k 
            // We have y, if we find (y-k), it means that sum k was found somewhere. We dont care where
            // We are NOT looking for the complement in the array; We check the map for it
            if (map.containsKey(sum - k))
                count += map.get(sum - k);

            // (sum,frequency) Eg, [(y-k),2]   so, y-k sum has come before
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}