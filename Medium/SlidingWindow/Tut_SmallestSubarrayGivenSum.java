package slidingwindow;
// Dynamic window
/**
1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104

*/

public class SmallestSubarrayGivenSum {

    public static int smallestSubarray(int targetSum, int[] arr) {
        int minWindowSize = Integer.MAX_VALUE;
        int currentWindowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentWindowSum += arr[windowEnd];

        // What is happening until above code?
        /**
        We just keep adding to the sum until the criteria is satisfied
        Which criteria? That the current sum >=8.
        Imagine if the entire array's sum did not cross 8 (array of all zeros or 1, maybe 6 elements)
        In that case, there might not be any sliding window

        Difference from static case -
        In static case, we explicitly check when the window size is reached/breached
        Here, we just let the currentSum go on until given condition

        Now, when the criteria is met by itself, we will have some initial window, we dont know the size.
        At this point, we dont know the windowStart and we dont have to extract any elements from start to end.
        Unless, it is a string, thwn we might have to take substring from start to end.
        For arrays generally, we SHOULD NOT extract elements from start to end, it will result in even higher complexity
        */


        // We want to shrink window everytime it is invalid
        // We slide through all values even after we shrink left side, what if we find a better solution
        // ***************IMPORTANT
            while(currentWindowSum >= targetSum) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currentWindowSum -= arr[windowStart]; // NOT arr[i-(k-1)]
                windowStart++;
            }
        }

        return minWindowSize;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4,2,2,7,8,1,2,8,10};
        int targetSum = 8;
        System.out.println(smallestSubarray(targetSum, input));
    }
}

// Dynamic Sliding window can use any other data structure - Hashmap or even Monotonic Deque
// In Sliding window maximum, we want to avoid O(n^2) complexity
// The idea resembles sliding window, but uses Memoisation, but is NOT exactly Dynamic programming
// The overall sliding window feels like movement of a Monotonic deque