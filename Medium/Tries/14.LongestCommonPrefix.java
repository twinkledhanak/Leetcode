// Eg. [flower, flow, flight] => longest prefix is fl

/**
Horizontal scanning
Take first string and compare it with all other strings 
Time: O(S) and Space: O(1)
*/

class Solution {
    public String longestCommonPrefix(String[] wordList) {
        if (wordList.length == 0) 
            return "";
        String prefix = wordList[0]; // prefix = flower

        for (int i = 1; i < wordList.length; i++){
            String nextWord = wordList[i]; // nextWord = flow

            while (nextWord.indexOf(prefix) != 0){ // (flow).indexOf(flower) != 0
                // we are trying to reduce the length of prefix string by 1 everytime

                // Next time, flower becomes flowe
                prefix = prefix.substring(0, prefix.length() - 1); // (0,n-1] exclusive

                // At any point, if the first two words do not have a common prefix, it will also be same for rest of the words
                if (prefix.isEmpty()) 
                    return "";
            }

        }
        
        return prefix;
    }
}

/**
Checking: flow with prefix: flower
One: -1
flowe
One: -1
flow

Checking: flight with prefix: flow
One: -1
flo
One: -1
fl
*/

/**
DIVIDE AND CONQUER

n = no of Strings in the array
m = length of each String in the array

Time: O(S), where S is the number of all characters in the array, S=m⋅n
In the best case this algorithm performs O(minLen⋅n) comparisons, where minLen is the shortest string of the array

Space complexity : O(m⋅logn)

There is a memory overhead since we store recursive calls in the execution stack. There are logn recursive calls, 
each store need m space to store the result, so space complexity is O(m⋅logn)
*/

class Solution {
    public String longestCommonPrefix(String[] wordList) {
        if (wordList == null || wordList.length == 0) 
            return "";

        // Divide and conquer -> passing array bounds
        // (wordList,0,n-1)   <-> (wordList,L,R)
        return longestCommonPrefix(wordList, 0, wordList.length - 1); 
    }

    private String longestCommonPrefix(String[] wordList, int l, int r) {
        if (l == r) {
            return wordList[l];
        } else {

            // Step 1: DIVIDE
            int mid = (l + r) / 2; // OR l + (r-l)/2

            // Just like Binary Search which is only on sorted array,
            // Any array can be used for Divide and conquer
            String lcpLeft = longestCommonPrefix(wordList, l, mid); // mid is part of the left partition
            String lcpRight = longestCommonPrefix(wordList, mid + 1, r);

            // Step 2: CONQUER
            // At this point the previous recursion calls to divide the array have ended
            // Now we have new calls to combine the left and the right array
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) 
                return left.substring(0, i);
        }

        // Not just min but entire length matches
        return left.substring(0, min); 
    }
}