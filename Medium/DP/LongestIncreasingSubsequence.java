/**
My understanding of the problem - 

/**
dp[n] = length of longest subseq until index n
dp[6] = 4

dp[0] = 1 // until the first element
dp[1] = a<b? 2: 1  // from the first until the second element
dp[3] =  dp[2] ; elem[3]       // from first until the third element
elem has to be considered if it is greater than the max of prev

dp[3] = if(elem[3]>maxElemUntil2)? dp[2]+1: dp[2]

*/


*/
    // Dynamic programming, O(n^2) - Iterative Solution
    public int lengthOfdp(int[] nums) {
        if (nums.length == 1) 
            return 1;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maximumSoFar = 1;

        // STARTING FROM END OF ARRAY IS NOT VERY INTUITIVE
        // We start from the end, go towards the start, eg, [1,2,4,3] - start considering from 3, then 4, 2,1
        for (int i = nums.length - 1; i >= 0; i--) {

            // For every 3, we consider a set of values after it to make a decision about longest increasing subsequence    
            for (int j = i + 1; j < nums.length; j++) { // , eg, for 3, consider nothing. For 2 - consider 4 and 3
                if (nums[i] < nums[j]) { // Yes, the sequence is increasing!
                    int result = Math.max(1 + dp[j], dp[i]);
                    dp[i] = result;
                }
            }


            maximumSoFar = Math.max(maximumSoFar, dp[i]);
        }
        return maximumSoFar;
    }

 /*Typically, dynamic programming problems can be solved with three main components. If you're new to dynamic programming, this
  might be hard to understand but is extremely valuable to learn since most dynamic programming problems can be solved this way.

// Get dp[]
// Get recurrence relation
// Start filling DP array
*/

// SAME PROBLEM, STARTING FROM START OF THE ARRRAY

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maximumSoFar = 1; // dp[i] -> stores the max length LIS until index i

        // We start from the beginning and go towards the end
        for (int i = 0; i < n; i++) {
            // For every nums[i], consider all previous elements to make a decision about longest increasing subsequence
            // MY MISTAKE: I WAS JUST CONSIDERING ONE PREVIOUS ELEMENT
            // dp[3] = if(elem[3]>maxElemUntil2)? dp[2]+1: dp[2] -> 3 has to be compared with all prev elements; not just 2
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) { // Yes, the sequence is increasing!
                    dp[i] = Math.max(dp[i], dp[j] + 1); // (1, dp[2] + 1) we already have 1 for all elements in dp
                    // it is like incrementing the counters
                }
            }
            maximumSoFar = Math.max(maximumSoFar, dp[i]); // with dp[i], NOT dp[j]
        }

        return maximumSoFar;
    }

// Time: O(n^2) since double loop; Space: O(n)

// USING Binary search to improve the time to O(nlogN)

class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }
        
        return sub.size();
    }
    
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = (left + right) / 2;
        
        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }
            
            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
