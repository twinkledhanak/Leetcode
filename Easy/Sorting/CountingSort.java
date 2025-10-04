/**
Official Leetcode solution:
Constraints:

1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000

Idk why they did this, it's complexity is worse than the hashmap
Since the freq array size is 2k
O(N + 2klog2K) = O(N + klogK) ; O(K)

It looks like counting sort, but the GFG code for counting sort is also different

*/

class Solution {
    // Constant to make elements non-negative.
    final int K = 1000;
    
    public boolean uniqueOccurrences(int[] arr) {

        //We can make use of the fact that the integers in the array will always be in the range [-1000, 1000].
        // This range is of length 2000, and therefore we need an array of the same size to store the frequency of each element.
        int freq[] = new int[2 * K + 1];
      
        // Store the frequency of elements in the unordered map.
        // The freq array is twice the size so we scale out input too
        for (int num : arr) {
            freq[num + K]++; // This frequency value can be neg so we are adding 1000 
        }
        
        // Sort the frequency count.
        Arrays.sort(freq); 
        
        // I can create a hashmap and then sort the values, if the same values are found again side by side - Return FALSE;
        // Why Counting sort?
        // It is the same thing, I create an array of frequency (with fancy size and negtopos integers) and then sort it

        // If the adjacent freq count is equal, then the freq count isn't unique.
        for (int i = 0; i < 2 * K; i++) {
            if (freq[i] != 0 && freq[i] == freq[i + 1]) {
                return false;
            }
        }
        
        // If all the elements are traversed, it implies frequency counts are unique.
        return true;
    }
}

/////

public class Solution {
    public void countingSort(int[] arr) {
        // Sorts an array of integers where minimum value is 0 and maximum value is K
        int K = Arrays.stream(arr).max().getAsInt();
        int[] counts = new int[K + 1];
        for (int elem : arr) {
            counts[elem] += 1;
        }
        // we now overwrite our original counts with the starting index
        // of each element in the final sorted array
        int startingIndex = 0;
        for (int i = 0; i < K + 1; i++) {
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }

        int sortedArray[] = new int[arr.length];
        for (int elem : arr) {
            sortedArray[counts[elem]] = elem;
            // since we have placed an item in index counts[elem], we need to
            // increment counts[elem] index by 1 so the next duplicate element
            // is placed in appropriate index
            counts[elem] += 1;
        }

        // common practice to copy over sorted list into original arr
        // it's fine to just return the sortedArray at this point as well
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArray[i];
        }
    }
}