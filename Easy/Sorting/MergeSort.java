class Solution {
    // Function to merge two sub-arrays in sorted order.
    /* 
    Merge the sorted arrays in better way. If arrays are not sorted, they will get sorted while merging
    */

    public int[] sortArray(int[] nums) {
        int[] temporaryArray = new int[nums.length];

        mergeSort(nums, 0, nums.length - 1, temporaryArray);
        return nums;
    }

    // Recursive function to sort an array using merge sort
    private void mergeSort(int[] arr, int left, int right, int[] tempArr) { //*** Golden rule of passing indices, not actual partitions */
        // LOOKS LIKE A PIECE OF CODE FROM BINARY SEARCH

        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        // Sort first and second halves recursively.
        mergeSort(arr, left, mid, tempArr);
        mergeSort(arr, mid + 1, right, tempArr);


        // Merge the sorted halves.
        merge(arr, left, mid, right, tempArr);
    }


    private void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
        // 1. Calculate the start and sizes of two halves.
        int start1 = left;
        int start2 = mid + 1;
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // 2. Copy elements of both halves into a temporary array.
        for (int i = 0; i < n1; i++) {
            tempArr[start1 + i] = arr[start1 + i];
        }
        for (int i = 0; i < n2; i++) {
            tempArr[start2 + i] = arr[start2 + i];
        }

        // Merge the sub-arrays 'in tempArray' back into the original array 'arr' in sorted order from its start (left).
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (tempArr[start1 + i] <= tempArr[start2 + j]) {
                arr[k] = tempArr[start1 + i]; // If first half has a smaller element, copy that
                i += 1;
            } else {
                arr[k] = tempArr[start2 + j]; // If Second half has a smaller element, copy that
                j += 1;
            }
            k += 1; // We will end up adding some element from either first half/second half, so increment left
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k] = tempArr[start1 + i];
            i += 1;
            k += 1;
        }
        while (j < n2) {
            arr[k] = tempArr[start2 + j];
            j += 1;
            k += 1;
        }
    }

}

/* 
Time Complexity:

Best Case: O(n log n), When the array is already sorted or nearly sorted.
Average Case: O(n log n), When the array is randomly ordered.
Worst Case: O(n log n), When the array is sorted in reverse order.
Space Complexity: O(n), Additional space is required for the temporary array used during merging.
*/