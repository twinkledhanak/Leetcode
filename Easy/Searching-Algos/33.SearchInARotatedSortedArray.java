class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

// sort it 
// wanted to find pivot, O(n) if done sequentially. Using Bin Search, it is logN
// Array is not sorted, so we just find pivot, where
// lhs of pivot is sorted and rhs is also sorted already
// in both partitions do:
// search -> binary


        // Find the index of the pivot element (the smallest element)
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[n - 1]) { // ** Compare with last element (n-1); not right
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // left is where we found our pivot

        // Binary search over elements on the pivot element's left
        int answer = binarySearch(nums, 0, left - 1, target); // int answer = binarySearch(nums, 0, pivot - 1, target);
        if (answer != -1) { // if we already found elements on lhs side, do not go to search on rhs
            return answer;
        }

        // Binary search over elements on the pivot element's right
        return binarySearch(nums, left, n - 1, target); // return binarySearch(nums, pivot, n - 1, target);
    }

    // Binary search over an inclusive range [left_boundary ~ right_boundary]
    private int binarySearch(int[] nums,int leftBoundary,int rightBoundary,int target) {
        int left = leftBoundary, right = rightBoundary;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1; // we must search on LHS; reduce right
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

/*
Time complexity: O(logn)

The algorithm requires one binary search to locate pivot, and at most 2 binary searches to find target. Each binary search takes O(logn) time.
Space complexity: O(1)

We only need to update several parameters left, right and mid, which takes O(1) space.
*/