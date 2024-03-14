class Solution {

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
}