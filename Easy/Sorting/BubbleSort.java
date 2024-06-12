public class Solution {
    public void bubbleSort(int[] arr) {
        // Mutates arr so that it is sorted via swapping adjacent elements until
        // the arr is sorted.
        boolean hasSwapped = true;
        while (hasSwapped) {
            hasSwapped = false;



            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    // Swap adjacent elements
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    hasSwapped = true;
                }
            }

        // in worst case makes another pass to determine if array is sorted, O(n)
        // n-1 passes are generally needed for n elements
        // total: O(n2)

        }
    }
}