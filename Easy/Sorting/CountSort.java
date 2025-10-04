/**
When we have a definite range of numbers of an array,
we can use count sort

Eg. We have 15 elements in an array
but, each of these elements is in a definitive range - [0-3]
0 0 1 3 2 1 0 0 .....

Or to give the ranks to students who have appeared for a JEE Main exam
Refer Pepcoding
*/

class Solution {
    // Constant to make elements non-negative.
    final int K = 1000;
    
    public boolean uniqueOccurrences(int[] arr) {
        int freq[] = new int[2 * K + 1];
      
        // Store the frequency of elements in the unordered map.
        for (int num : arr) {
            freq[num + K]++;
        }
        
        // Sort the frequency count.
        Arrays.sort(freq);
        
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