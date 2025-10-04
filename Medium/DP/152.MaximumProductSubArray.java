// Similar to what I've understood so far - GPT but worked
public int maxProduct(int[] nums) {
    if (nums.length == 0)
        return 0;

    int localMax = nums[0];
    int localMin = nums[0];
    int globalProduct = nums[0];

    for (int i = 1; i < nums.length; i++) {
        // Must store tempMax before overwriting
        int tempMax = localMax;

        localMax = Math.max(nums[i], Math.max(nums[i] * localMax, nums[i] * localMin));
        // Use temp max since localMax must have be overriden
        localMin = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * localMin));

        globalProduct = Math.max(globalProduct, localMax);
    }

    return globalProduct;
}



public int maxProduct(int[] nums) {
        int maxValue = Integer.MIN_VALUE;

        // 1. I had initialized the values to 0
        // It failed for [-2] where it was returning 0
        // So had to initialize all of them to min value
        int product1 = Integer.MIN_VALUE;
        int product2 = Integer.MIN_VALUE;

        Set<Integer> hashSet = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            // trick to optimisze when there are a lot of dups in the array
            // Trick from Rotten oranges?
            if(!hashSet.contains(i)){ 
                hashSet.add(i);
                for(int j=i; j<nums.length; j++){
                    if(i == j)
                        product1 = nums[i];
                    else{
                        // I was storing an entire DP array
                        // So, just used variables instead to save on space 
                        product2 = product1 * nums[j];
                        product1 = product2; // Remeber to update the prev value
                    }
                    
                    // Had to get the max for all 3 values, not just p1 and p2
                    maxValue = Math.max(maxValue, product1);    	    
                    maxValue = Math.max(maxValue, product2);
                }
            }
            
        }

        return maxValue;
    }

    // Tried to create the same matrix as for longest pallindromic substrings 
    // Did the traversal
    // Found the actual logic
    // Right representation of problem is very important
    // We implemented approach 2, space optimised DP, but still O(n2)

| Approach                       | Uses Array? | Time   | Space  | Considered DP?      |
| ------------------------------ | ----------- | ------ | ------ | ------------------- |
| Brute-force with 2D `dp[i][j]` | Yes         | O(n²)  | O(n²)  | ❌ Not efficient DP  |
| Nested loops with products     | No          | O(n²)  | O(1)   | ❌ Still brute-force |
| Kadane-style max/min tracking  | No          | ✅ O(n) | ✅ O(1) | ✅ **Yes – DP**      |


// We can convert our code to Kadane if we understand what is the problem
// In our code, we have two for loops
// If we can reduce that to one loop with some minor corrections - it might work