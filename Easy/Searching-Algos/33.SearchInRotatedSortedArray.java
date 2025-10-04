/**
Time: O(logN) ; Space: O(n)
Using two binary searches -> when finding pivot, re-arrange the left and right boundaries using BS. Again, do BS with new boundaries.
Follow up: Using only one binary search -> 
*/

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        // [0,1,2,4,5,6,7] rotated at index: 3
        // rhs wass: pivot to end
        // smallest elem is the new rhs
        // [4,5,6,7,0,1,2] 
        // What is actually the pivot: 0

        // Find the index of the pivot element (the smallest element)
        while (left <= right) {
            int mid = low + (right - left) / 2; // 7


            if (nums[mid] > nums[n - 1]) { // compare 7 with last elem -> 7 with 2 -> 7>2
                left = mid + 1; // pivot is on rhs, range updated as: left(mid+1) to high(n-1)
            } else {
                right = mid - 1; // pivot is on lhs, range updated as: left(low) to high(mid-1)
            }
        }

        // Binary search over elements on the pivot element's left
        int answer = binarySearch(nums, 0, left - 1, target);
        if (answer != -1) {
            return answer;
        }

        // Binary search over elements on the pivot element's right
        return binarySearch(nums, left, n - 1, target);
    }

    // Binary search over an inclusive range [left_boundary ~ right_boundary]
    private int binarySearch(
        int[] nums,
        int leftBoundary,
        int rightBoundary,
        int target
    ) {
        int left = leftBoundary, right = rightBoundary;
        while (left <= right) {
            int mid = low + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) { // target is on left side
                right = mid - 1; // update right boundary
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}


/// using only one binary search
// Still same overall complexity
// Time: O(logN); Space: O(n)
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // [4,5,6,7,0,1,2] ; mid=7
            // Case 1: find target
            if (nums[mid] == target) {
                return mid;
            }

            // [4,5,6,7,0,1,2] ; nums[mid]=7, left=0, nums[left]=4
            // Case 2: subarray on mid's left is sorted
            
            // Compare outer range
            else if (nums[mid] >= nums[left]) { // 7 >= 4 range is [4,...,7]

                // Compare target within this range
                if (target >= nums[left] && target < nums[mid]) { // target between [4...7], first half
                    right = mid - 1; // update right boundary to search in left half
                } else {
                    left = mid + 1;
                }
            }
            // Case 3: subarray on mid's right is sorted
            else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}