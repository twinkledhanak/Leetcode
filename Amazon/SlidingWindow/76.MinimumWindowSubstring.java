/**
Sliding window, passed 264/268 test cases:
Learn the basics here first -

Template for DYNAMIC Sliding window for Strings:
1. Have a loop to go through the string
2. Have a while to check for given condition on the string, NOT the window length
The risk? If we write -  while(checkIfValid(....)){}, the function must be as optimised as possible, otherwise TLE
To avoid this risk, we have to use an auxiliary data structure.
Also, we avoid making the string!! Just work with the characters and their hashmap frequency

3. If we enter the while loop, it is true condition. Check/update required variables
4. Add condition to compress string inside while loop itself
5. return result


ONE POSSIBLE OPTIMISATIOn: Refer to Neetcode solution below
To avoid this risk, we have to use an auxiliary data structure.
Hashmap -
t map => (char, count)

*/

class Solution { // DO not refer, it just passes 264/268 test cases
    public String minWindow(String s, String t) {
        if(s.length() < t.length())
            return new String();

        // Dynamic window, but we do not want to shrink window size beyond t
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";
        StringBuilder window = new StringBuilder();

        // Step 1.
        for(end = 0; end<s.length(); end++){

            window = window.append(s.charAt(end));
            //System.out.println("Checking for validity: "+window);

            // Step 2.
            while(checkIfValid(window.toString(),t)){
                //System.out.println("Valid : "+window);

                // Step 3.
                if(minLen > window.length()){
                    minLen = Math.min(minLen, window.length());
                    result = window.toString();
                }

                // Step 4. , we are shrinking our window here
                // When we have a hashmap, we have to manipulate the hashmap again for this deleted character
                window = new StringBuilder(window.substring(1));
                start+=1;
                    
            }

            

        } // end of for   
        return result;

    }

    public boolean checkIfValid(String window, String t){
        int swapCount = 0;

        if(window.length() < t.length())
            return false;
        for(int i=0; i<t.length(); i++){
            if(window.indexOf(t.charAt(i)) != -1){
                window = window.replaceFirst(t.charAt(i)+"",""); 
                swapCount += 1;
            }
                
        }    

        if(swapCount == t.length())
            return true;

        return false;    
    }
}


// NEETCODE

class Solution {

    //sliding window
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Optimised , creating a freq hashmap for t
        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int matched = 0;
        int start = 0;
        int minLen = s.length() + 1;
        int subStr = 0;


        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            char right = s.charAt(endWindow); // I put it in a window

            if (map.containsKey(right)) { // we are comparing and decrementing the value in t, but if not matched, how do we put values again?
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++; // EVEN THOUGH THE COUNT IS ZERO, WE DO NOT REMOVE IT FROM THE MAP
            }

            while (matched == map.size()) { // condition? Count of distinct chars is same in both strings
                if (minLen > endWindow - start + 1) { // condition met, valid window since everything matched
                    minLen = endWindow - start + 1;
                    subStr = start; // record the start index
                }

                // Get this deleted char, we are now trying to restore it back to the hashmap
                // We need to restore only if it was existing in the map
                char deleted = s.charAt(start++);
                // trying to restore the map again?
                if (map.containsKey(deleted)) { 
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1); // increment the value of this deleted
                    // also, increment the value of other variables reduced previously
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }
}

// Feb 2026 solution
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        int[] tFreq = new int[128];       // frequency of chars in t
        int[] windowFreq = new int[128];  // frequency of chars in current window
        int required = 0;                 // number of unique chars to satisfy

        // Build frequency array for t and count unique characters
        for (char c : t.toCharArray()) {
            if (tFreq[c] == 0) 
                required++;  // first occurrence
            tFreq[c]++;
        }

        int formed = 0;           // how many unique chars currently satisfy tFreq
        int l = 0;                // left pointer
        int[] ans = {Integer.MAX_VALUE, 0, 0}; // length, left, right

        // Step 1: Grow the window using a for loop
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            windowFreq[c]++;

            // For the current char, can we compare freq in both windows?
            // Update invariant, when freq matches - we have collected all of given char
            if (windowFreq[c] == tFreq[c]) 
                formed++;

            // Step 2: Shrink while invariant holds (window valid)
            // we maintain two properties for every char
            // the freq counter and formed variable
            while (formed == required) {
                // Step 3: Capture property
                if (r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // From regular template
                char leftChar = s.charAt(l);
                windowFreq[leftChar]--;

                if (windowFreq[leftChar] < tFreq[leftChar]) {
                    formed--; // invariant no longer holds
                }

                // From regular template
                l++; // shrink left
            }
        }

        return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);
    }
}

/**
if s < t
    return null; not possible

t will have an array to maintain freq

valid length of s = all chars of t + k (some random chars)
Min window size for s is going to be t.length()

I think the invariant must be:
We shrink the window on validity as any window we start
with is still growing
*/

// SOME MORE IMPORTANT NOTES:
From efficient computation pov, what all does this problem teach us?
One way I can think is -
In a similar leetcode problem - we just compare the both freq arrays one by one and return false if 
they dont match for even one character. That is how we know they represent a valid window.
In this case, instead of complete comparison of arrays - they are using required and formed counts.
What does this tell us?

1. When a state changes incrementally, never recompute global truth — track the delta.
Naivve approach:
After each change:
    compare windowFreq[] vs tFreq[]

Optimised approach:
Update only what changed
Track whether that change affects validity

This exact idea appears in:
	•	incremental compilers
	•	database indexes
	•	cache invalidation
	•	event-driven systems

If you find yourself repeatedly checking a condition from scratch, you are one invariant away from an O(1) solution.    