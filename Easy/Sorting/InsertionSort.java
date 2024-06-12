public class Solution {
    public void insertionSort(int[] arr) {
        // Mutates elements in arr by inserting out of place elements into appropriate
        // index repeatedly until arr is sorted

        // ASSUMES THAT LHS OF ELEMENTS IS SORTED SO JUST CONSIDER RHS
        // DO NOT CONSIDER ELEMENT THAT DOESNT HAVE LHS, SO WE START FROM POS:1
        // DROP ELEMENT ONLY IF IT IS GREATER THAN ITS PREV ELEMENT OR PREV DOESNT EXISTS



        for (int i = 1; i < arr.length; i++) {

            int currentIndex = i;

            // move from rhs to lhs while sorting
            while (currentIndex > 0 && arr[currentIndex - 1] > arr[currentIndex]) {
                // Swap elements that are out of order
                int temp = arr[currentIndex];
                arr[currentIndex] = arr[currentIndex - 1];
                arr[currentIndex - 1] = temp;

                // IMP
                currentIndex -= 1;
            }
        }
    }
}