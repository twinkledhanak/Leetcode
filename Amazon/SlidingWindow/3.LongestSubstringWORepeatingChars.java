/**
Newly learnt approach
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int start=0, end=0;
        Map<Character,Integer> map = new HashMap<>(); // we can also use a set
        int maxLen = Integer.MIN_VALUE;

        if(s.length() == 0)
            return 0;

        for(end = 0; end < s.length(); end++){ // standard for loop
            Character ch = s.charAt(end); // trying to consider only one char

            // do not write this in a IF condition
            map.put(ch, map.getOrDefault(ch,0) + 1); // using a hashmap as we we want to avoid a function call with entire string
                

            // char already exists, eg string aa
            // while(given condition) translates to while(string has distinct chars)
            // But we have a diff condition here *******

            // If the current character appears more than once, shrink the window from the left
            while(map.get(ch) > 1){
                // so now, we cannot consider this string
                // time to shrink, remove the first char
                System.out.println("Removing char: "+s.charAt(start)+" from index: "+start);
                map.put(s.charAt(start),map.get(s.charAt(start))-1);
                start += 1;
            }

            maxLen = Math.max(maxLen, end-start+1);

        }

        return maxLen == Integer.MAX_VALUE? 0 : maxLen;

    }
}

// Time: O(n) ; Space: O(min(m,n)) - n = length of string; m = size of charset

/**
Standard learnt approach
standard for loop, have a function call to check for validity
no while loop
*/

class Solution {

    public int lengthOfLongestSubstring(String subs){
        int n = subs.length();
        int windowStart = 0, windowEnd = 0;
        int maxLen = Integer.MIN_VALUE;

        if(n==0)
        return 0;

        // Note the windowEnd is from position: 1, not 0
        for(windowEnd = 1; windowEnd<n; windowEnd++){
            String substr = subs.substring(windowStart,windowEnd+1); // Substring needs windowEnd+1 to get right value
            if(hasAllDistinct(substr)){
                maxLen = Math.max(maxLen,substr.length());
            }
            else 
                windowStart++;
        }

        // Referred a test case to return 1 whenever we still have MIN_VALUE returned!
        return maxLen == Integer.MIN_VALUE? 1: maxLen;

    }

    // One way to check for unique characters is by creating a hashset
    public boolean hasAllDistinct(String s){
        Set<Character> hashSet = new HashSet<>();
        char[] ch = s.toCharArray();
        for(char c: ch){
            if(hashSet.contains(c))
                return false;
            hashSet.add(c);
        }
        return true;
    }
}

// Time: O(n) ; Space: O(min(m,n))

// Optimised code with ASCII Support

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



