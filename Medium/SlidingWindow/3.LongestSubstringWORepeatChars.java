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

// More latest approach from Feb 2026
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Instead of a map, we use a set to check if char is unique
        Set<Character> set = new HashSet<>();
        int start = 0, maxLength = 0;

        for(int end = 0; end < s.length(); end++){
            char c = s.charAt(end);

            // remove duplicates until c can be added safely
            // I was assuming removing only one char from start was sufficient
            // REFER TO TEMPLATE BELOW
            while(set.contains(c)){
                set.remove(s.charAt(start));
                start++;
            }

            set.add(c);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}


/**
Dynamic Sliding window
Step 1: Define the window invariant
What must ALWAYS be true inside the window?


Step 2: Expand the window (always)

Step 3: Find the violation (Opposite of invariant)

Step 4: Shrink until valid

while (window violates invariant) {
    remove(nums[left]);
    left++;
}

Step 5: Update answer

*/
