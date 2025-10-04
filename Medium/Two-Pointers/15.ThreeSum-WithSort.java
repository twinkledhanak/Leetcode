// Time: O(n^2), sorting time is O(nlogN) but it is less than O(n^2)
// Space: O(logN) to O(n)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 1. Sort the array to use Two Pointer
        // *************************
        Arrays.sort(nums);

        // 2. Continue only if first element is less than 0;
        // If First element is > 0, and array is sorted, it means all values in array are > 0 and positive, so their sum cannot be equal to zero
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) { // not same as prev, but when i=0, prev check wont work

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
            // sum is neg, we need to move more on rhs side, since sorted array has pos numbers on right
            // Sum has to be made zero, which is possible by moving right
            if (sum < 0) { 
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));

                // **************************
                // // Manipulate the window boundaries based on window pointers, to skip duplicates
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }
}

// LC official solution without any sorts
// Higher level overview:
/**
1. i+j+k=0 => Use i+j = -k 
2. use one loop to track the outer elements i
3. For each pair (i,j) calculate and track the complement [In two sum we just have a number for which we track the compl]
4. I had the same idea but my way of tracking the complement & final result is not efficient
5. 

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) 
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = (-1) * (nums[i] + nums[j]);
                    
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(
                            nums[i],
                            nums[j],
                            complement
                        );
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i); // storing a prev result, so nums[j] when j=1. Later when we are at j=2, we can check prev 
                    // if a complement was present and it was for what value of i
                }
        }
        return new ArrayList(res);
    }
}

// Time: O(n2) and Space: O(n)


/// Tried the one approach without sorting
// List of all problems:
/**
Too many repeated combinations:

It checks all (i, j, k) index combinations for every pair (i, j), even if the value nums[k] has already been used in another valid triplet.

No deduplication at index level:

Even though triplets are deduplicated via sorting, the algorithm generates many of them repeatedly, especially in cases like [0,0,0,...].

Expensive inner loop over map.get(sum):

This is often a list of many indices, especially for repeating numbers, causing the inner loop to behave more like O(n).

➤ So, instead of doing O(n²) total work, it becomes closer to O(n³) in the worst case.

*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int i = 0;
        int j = i + 1;
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i); // Store indices instead of values
        }

        Set<List<Integer>> result = new HashSet<>();

        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                int sum = -1 * (nums[i] + nums[j]);

                if (map.containsKey(sum)) {
                    for (int k : map.get(sum)) {
                        // Make sure k is different from i and j
                        if (k != i && k != j) {
                            List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                            Collections.sort(triplet); // Ensure consistent order for Set
                            result.add(triplet);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}
