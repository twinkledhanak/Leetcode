// Pepcoding explanation for Substrings
// Given string abcd - find all pallindromic substrings

/**
Lets focus on substrings - then we can check for pallindrome part

s=abcd => how to get all substrings?

starting with a => a,ab,abc,abcd
starting with b => b,bc,bcd
starting with c => c,cd
starting with d => d

Total => n(n+1)/2 = n^2 substrings for a given string of length n

Now, by brute force if we check whether each of the substring is pallindromic,
we must iterate over time in O(n) time using two pointers

Brute force: O(n^2) is the total count of substrings and O(n) time to check for 
the special property => Pallindrome

Total time complexity for Brute force: O(n^3)



If we use DP here, we can reduce the time complexity from O(n^3) to O(n^2)

First we need a better way to represent all our substrings 
Here we use matrix format => 
Upper right is always filled with values and bottom left is always invalid and empty

        end =>
        a   b   c   d
 s   a
 t   b
 a   c
 r   d
 t

 |
 V

Template to traverse across this matrix:
Top-Down iterative approach and it does not use recursion

boolean[][] dp = new boolean[s.length()][s.length()];
int count=0;
for(int gap=0; gap<s.length(); gap++){
	
	for(int i=0, j=gap; j<dp.length; i++, j++){
		// a,b,c; Trivial case along the diagonal
		if(gap==0)
			dp[i][j] = true;

		// aa, ab, bc; Trivial case just above the diagonal	
		else if(gap==1)
			dp[i][j] = s.charAt(i) == s.charAt(j) ? true : false;

		// abc
		else
			dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true)? true : false;

		if(dp[i][j] == true)
			count += 1;		
				
	}
}




*/






class Solution {
    public int countSubstrings(String s) {

        // For DP matrix
        boolean[][] dp = new boolean[s.length()][s.length()];

        // For results,
        int count=0;

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

                if(dp[i][j] == true)
                    count+=1;

            }// inner for

            
        }// outer for

        return count;
    }
}

