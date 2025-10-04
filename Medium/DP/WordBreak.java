/**
Higher Level Intuition:
We have to use the entire dictionary and create combination of words that will give us our String s.

It is NOT the following-
I tried to go over the entire list of words and replace them in the word. If the String length becomes zero - we return true.
Eg. of failure 
[car, ca, rs] ; s = cars
Expected : True ; What my code returned: False


Tree looks like as:
[leet,code] ; s = leetcode
wb(leet) has 4 options
l + wb(eet) ; le + wb(et) ; lee + wb(t) ; leet + wb("")


*/

class Solution {
    private String s;
    private List<String> wordDict;
    private int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        this.memo = new int[s.length()];
        Arrays.fill(this.memo, -1);
        return dp(s.length() - 1); // START FROM THE END
    }
    
    private boolean dp(int i) {
        if (i < 0) return true;
        
        if (memo[i] != -1) {
            return memo[i] == 1;
        }
        
        //[leet,code] - check for all choices
        for (String word: wordDict) {
            // Handle out of bounds case
            if (i - word.length() + 1 < 0) {
                continue;
            }
            // if the string is leetcode, word-dicts : current word is leet, then word
            if (s.substring(i - word.length() + 1, i + 1).equals(word) && dp(i - word.length())) {
                memo[i] = 1;
                return true;
            }
        }
        
        memo[i] = 0;
        return false;
    }
    
    
}

/*
Word Break - We have a string, applepenapple and worddict = [apple,pen]. We have to determine if we can split s in a way that 
all it's substrings are in worddict. Simplifying the problem statement, we have to find if there is a combination of words from dict 
that exists and form the original string. Words can be used 0 to Infinite times 
Here, we form a substring everytime and check if it exists in the worddict or not 
*/


// Iterative

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()]; // dp[i] means the string until index i is valid and can be split

        // from start to end
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                // Handle out of bounds case
                int wl = word.length();
                if (i < wl - 1) {
                    continue; // my index has not yet reached the length of first word in dict
                }

                // Instead of using two pointer approach, I can just take substring in an approriate way
                if (i == wl - 1 || dp[i - wl]) { // ** dp until previous is true, prev = i-wl, current=i-wl+1
                    if (s.substring(i - wl + 1, i + 1).equals(word)){
                        dp[i] = true;
                        break; // ***
                    }
                }
            }
        }

        return dp[s.length() - 1];
    }
}

// worddict: [abcd, de]
// word: defgabcd

/*
Given n as the length of s, m as the length of wordDict, and k as the average length of the words in wordDict,

Time complexity: O(n⋅m⋅k)

The logic behind the time complexity is identical to the previous approach. It costs us O(m⋅k) to calculate each state, and 
we calculate O(n) states in total.

Space complexity: O(n)

We use an array dp of length n.
*/