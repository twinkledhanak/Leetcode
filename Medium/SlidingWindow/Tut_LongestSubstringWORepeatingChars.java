/**
Sliding Window:
Time: O(n) , n = length of th input string - as we traverse the string once
Space: O(min(m,n)) , m = length of charset, suppose if all chars are repeating, "aaaa" n =4 but m=1, so our set only has m chars
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int windowStart = 0, windowEnd = 0;
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>(); // Track current characters in the window

        for (windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currentChar = s.charAt(windowEnd);

            // Shrink the window if the character is already in the set (duplicate found)
            // Only try to handle the invalid condition
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(windowStart)); // Remove the leftmost character
                windowStart++;
            }

            // Add the current character to the set
            charSet.add(currentChar);

            // Update maxLength with the current window size
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}

/**
If we know that the charset is rather small, we can mimic what a HashSet/HashMap does with a boolean/integer array as direct 
access table. Though the time complexity of query or insertion is still O(1), the constant factor is smaller in an array than 
in a HashMap/HashSet. Thus, we can achieve a shorter runtime by the replacement here.

Commonly used tables are:

int[26] for Letters 'a' - 'z' or 'A' - 'Z'
int[128] for ASCII
int[256] for Extended ASCII

We have 2 advantages -
We save on space, only O(m)
We support all ascii chars
Time also improves a bit

*/
// Implementing Dynamic Sliding Window, but with support for extended ASCII
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] set = new int[256]; // Array to store the presence of characters
        int windowStart = 0;
        int maxLength = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currentChar = s.charAt(windowEnd);

            // If the current character is already in the window, move the start position
            // *******************
            // Difference 1: Not using While, but using if
            // Difference 2: Checking freq in array
            // *******************
            if (set[currentChar] > 0) {

                // *******************
                // Difference 3: Prev, we increment start++. Now - use a fancy formula
                windowStart = Math.max(windowStart, set[currentChar]);
            }

            // Update the position of the current character (+1 because we store positions 1-based)
            // *******************
            // Difference 4: Prev, we used to add to set 
            set[currentChar] = windowEnd + 1;

            // Update the maximum length
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}