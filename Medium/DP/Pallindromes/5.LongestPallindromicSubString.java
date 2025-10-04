// My working solution after referring to Sumeet Sir!!
class Solution {
    public String longestPalindrome(String s) {
        // Idea is to make a DP array
        // Get the substrings
        // Decide if a substring is pallindromic or not
        // return the value of max length one


        boolean[][] dp = new boolean[s.length()][s.length()];
        String maxString = "";
        for(int gap=0; gap<s.length(); gap++){

            for(int i=0, j=gap; j<dp.length; i++, j++){
                if(gap == 0) // a,b,c
                     dp[i][j] = true;
                else if(gap == 1)
                    dp[i][j] = s.charAt(i) == s.charAt(j)? true : false;
                else
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true)? true: false;    
                
                // final decision logic   
                if(dp[i][j] == true){
                    if(maxString.length() < s.substring(i,j+1).length())
                        maxString = s.substring(i,j+1);
                }

            }

        }

        return maxString;
        
    }
}





class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] longestPalWindow = new int[] { 0, 0 };

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;// base case => single character; length=1; it is a pallindrome
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) { // base case for length=2
                dp[i][i + 1] = true;
                longestPalWindow[0] = i;
                longestPalWindow[1] = i + 1;
            }
        }

        for (int diff = 2; diff < n; diff++) { // lengths>2
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    longestPalWindow[0] = i;
                    longestPalWindow[1] = j;
                }
            }
        }

        int i = longestPalWindow[0];
        int j = longestPalWindow[1];
        return s.substring(i, j + 1);
    }
}

// Time: O(n2) ; Space: O(n2)
// Refer to 647.pallindromeSubstringLongest -> same question