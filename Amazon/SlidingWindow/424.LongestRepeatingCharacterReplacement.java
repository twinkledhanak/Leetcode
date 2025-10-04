/**
Neetcode solution
*/

class Solution {

    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int ans = 0;
        int max = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) { // Formal loop for sliding window
            arr[s.charAt(j) - 'A']++; // Using an array to keep count of frequency of each of the characters
            // This array stores frequency of characters
            max = Math.max(max, arr[s.charAt(j) - 'A']); // We always keep a track of maximum frequency

            // we need to derive a condition for valid window
            // Eg. BABB => We have (B,3) so max freq is B, we prefer the main char as B
            // The minority char will be replaced
            // Eg. A has freq = 1; Total length is 4 and B is most freq char with 3, we need to replace only (4-3) chars
            // So, only 1 char
            // A valid window has no of replacements <= k
            // length of window - max freq <= k 
            // 4 - 3 <= 2 (k=2 is given)
            // But this is reverse again as we check invalid condition and decrement frequency
            // We are incrementing our window start and so, decrease the freq from the map/array
            // Increment the start pointer in the standard way
            if (j - i + 1 - max > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}


/**
My Solution, partially correct :)
*/