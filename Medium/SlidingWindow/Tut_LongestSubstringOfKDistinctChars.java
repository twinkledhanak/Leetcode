import java.util.*;
// Dynamic window with another data structure

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    // Similar to Dynamic Window, we have windowStart and windowEnd
    int windowStart = 0, maxLength = 0;
    // We also need an auxilliary data structure
    Map<Character, Integer> charFrequencyMap = new HashMap<>();

    /*
    I faced two problems with these kind of questions:
    1. When it is a string, to get a substring of it based on window is very easy operation. s.substring(start,end)
    But, when it is an array, to get all elements from start to end, like we did in a string will take extra computation
    We should avoid doing that. When we have an array, we must proceed as below. DEAL WITH AN ELEMENT AT A GIVEN TIME ONLY.
    FOR A STRING, WE CAN WAIT UNTIL END AND TAKE ENTIRE SUBSTRING TOGETHER. 

    2. Even with a string, we then may have to iterate over it to find all unique chars or freq or something else.
    This means, we create a window and then again iterate over all elements twice. O(n) and O(k), k elements in a window
    Overall, O(n.k) or O(n^2) when k=n
    We must avoid such kind of scenarios for both String and Array.

    Option 1 may be easier for Strings, but Option 2 is difficult for both arrays and Strings.

    ALWAYS TRY TO WORK CHAR BY CHAR AND DO COMPUTATION AS WE ITERATE OVER ELEMENTS ONCE WHEN CREATING A WINDOW.
    DO NOT RE-ITERATE AGAIN IN THE WINDOW.
    WE ARE NOT EVEN USING MEMOISATION.
    THIS WILL LEAD TO INCREASE IN TIME COMPLEXITY AS SAME ELEMENT IS ACCESSED TWICE, ONCE WHEN CREATING WINDOW AND SECOND,
    WHEN RE-ITERATING THROUGH THAT WINDOW

    */

    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      // Do something with every char we encounter in the window
      char rightChar = str.charAt(windowEnd);
      charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);


      // Dynamic window to be manipulated in the same way as earlier, we just slide through the entire window
      // We also increment start but with whatever window is remaining, we check the window validity
      // Once again, we do not have a static winow size to check - so, we check the given criteria
      // Which in our case is - size of the map -> When we have encountered k distinct elements - the size will be k
      // So, check for when we have already breached the size limit, assume we now have 5 keys in the map
      // Instead of building from 0 to 5, we are reducing from 5 to min value we can still satisfying the condition
      while (charFrequencyMap.size() > k) {
        char leftChar = str.charAt(windowStart);
        // Since we now shrink the window, we have to do two things -

        // 1. Reduce the char's freq in the map
        charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1); 
        
        // 2. If the char's freq becomes zero, remove it from the map so that we do not consider it again
        // We have a constraint on size of map (no. of elements) = hence, we have to remove unwanted elements from map
        if (charFrequencyMap.get(leftChar) == 0) {
          charFrequencyMap.remove(leftChar);
        }
        windowStart++;
      }

      // We kept shrinking the window until we reached k distinct characters
      // Now we have exactly k distinct characters
      // Therefore, we must record the window size
      // Below code will be invoked twice - once when we reached exactly k distinct chars and also during other times
      // when the for loop is actually called
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1); 
    }
  }
}