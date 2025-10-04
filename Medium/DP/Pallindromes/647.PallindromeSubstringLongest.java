
class Solution {
    public String longestPalindrome(String s)  {

         // For DP matrix
        boolean[][] dp = new boolean[s.length()][s.length()];

        // For results,
        int maxLength=-1; String answer = "";

        // Now, we traverse from base case to actual case
        // We use concept of gaps
        for(int gap=0; gap<s.length(); gap++){

            // i = rows, j=columns
            for(int i=0,j=gap; j<dp.length; i++,j++){ 

                // base cases
                if(gap==0) // eg. "a"
                    dp[i][j] = true;
                else if(gap==1) // eg. "ab", "cc", "bc"
                    dp[i][j] = s.charAt(i) == s.charAt(j);    

                else{
                    // always compare outermost chars and rely on dp table for inner string
                    // "acba" => compare a with a , rely on dp table for cb
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]==true)
                        dp[i][j] = true;
                    else 
                        dp[i][j] = false;    
                }    

                if(dp[i][j] == true){
                    if(s.substring(i,j+1).length() > maxLength){
                        maxLength = s.substring(i,j+1).length();
                        answer = s.substring(i,j+1);
                    }
                }
                    

            }// inner for

            
        }// outer for

        return answer;



    }
}