
    // Dynamic programming, O(n^2) - Iterative Solution
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;

        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);
        int maximumSoFar = 1;

        // We start from the end, go towards the start, eg, [1,2,4,3] - start considering from 3, then 4, 2,1
        for (int i = nums.length - 1; i >= 0; i--) {

            // For every 3, we consider a set of values after it to make a decision about longest increasing subsequence    
            for (int j = i + 1; j < nums.length; j++) { // , eg, for 3, consider nothing. For 2 - consider 4 and 3
                if (nums[i] < nums[j]) { // Yes, the sequence is increasing!
                    int result = Math.max(1 + LIS[j], LIS[i]);
                    LIS[i] = result;
                }
            }


            maximumSoFar = Math.max(maximumSoFar, LIS[i]);
        }
        return maximumSoFar;
    }

 