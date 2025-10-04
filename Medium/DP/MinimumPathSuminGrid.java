/**
My Solution:
We give the answer at dp[R-1][C-1]:
As a followup to this question, when we are asked to print the path, we can follow the matrix from last cell in reverse order
and follow the min elements
*/



public class Solution {
    // 2D DP Solution
    public int minPathSum(int[][] grid) {

        int R = grid.length;
        int C = grid[0].length;
        int[][] dp = new int[R][C]; // the extra storage we need

        // We fill the DP array 
        // Higher level intution is same as before, we refer to top and left element for filling a value in current cell
        dp[0][0] = grid[0][0];

        // Eg. Current matrix is:
        /**
        1 3 1
        1 5 1
        4 2 1

        DP looks like:
        1 4 5
        2 7 6
        6 8 7 ---> Answer is 7
        
        We first fill the DP array as: (STEP 2: Individual row and column sum)
        1 4 5
        2
        6


        */

        // (STEP 2: Individual row and column sum) ; Remember to use the right DP matrix, not grid
        for(int j=1; j<C; j++)
            dp[0][j] = grid[0][j]+ dp[0][j-1]; // not grid[0][j-1]
        // (STEP 2: Individual row and column sum)
        for(int i=1; i<R; i++)
            dp[i][0] = grid[i][0]+ dp[i-1][0];     
        

        // Similar to our previous logic -> Referring to top and left element for getting the min
        for(int i=1; i< R; i++){
            for(int j=1; j<C; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        // for(int i=0; i<R; i++){
        //     for(int j=0; j<C; j++){
        //         System.out.print(dp[i][j]);
        //     }
        //     System.out.println("-----------");
        // }

        return dp[R-1][C-1];

    }
}


//////////////////////////////////////////////////////////////////////////////////////////

// Alll these solutions give the answer at dp[0][0]

public class Solution {
    // 2D DP Solution
    public int minPathSum(int[][] grid) {

        int R = grid.length;
        int C = grid[0].length;
        int[][] dp = new int[R][C]; // the extra storage we need

        for (int i = R - 1; i >= 0; i--) {
            for (int j = C - 1; j >= 0; j--) {
                
                int currentPos = grid[i][j];

                if(i == R - 1 && j != C - 1) // last row 
                    dp[i][j] = currentPos +  dp[i][j + 1]; // Only right

                else if(j == C - 1 && i != R - 1) // last column
                    dp[i][j] = currentPos + dp[i + 1][j]; // downwards

                else if(j != C - 1 && i != R - 1)
                    dp[i][j] = currentPos + Math.min(dp[i + 1][j], dp[i][j + 1]); // We are filling the previous pos with current
                    
                else
                    dp[i][j] = currentPos; // filling with the same value as grid, nothing else needed
            }
        }
        return dp[0][0];
    }
}

// Time: O(m*n); Space: O(m*n) since grid traversal and storage

/*
Higher level intuition:
1. Using 2D matrix for DP, same size as input matrix
2. Initialize the bottom right of the dp matrix first
3. The answer will be the matrix position (0,0) 
4. Why do we start from bottom? It was evident from the examples that using Min.. logic from (0,0) will not give min path
5. Starting from end and filling the matrix in reverse helps
6. The below approach gives TLE, but we got to learn that-
7. For DP problems, we need to fill the entire DP matrix, preferably from R to L. We fill the previous with current pos
8. Only filling the min values will give TLE

**********************
When it says -
Look only downward and rightward - we replicate the same in code
When last column, only look downward - Fill values by looking left
When last row, only look rightward - Fill values by looking right

*/

// Just for fun. it gives TLE. Lessons learnt are above -
public class Solution {
    // 2D DP Solution
    public int minPathSum(int[][] grid) {

        int R = grid.length;
        int C = grid[0].length;
        int[][] dp = new int[R][C]; // the extra storage we need

        dp[R-1][C-1] = grid[R-1][C-1];    
        int i=R-1, j=C-1;
        while(i >=0 || j>=0){
            int I=0, J=0;
            if(grid[i-1][j] <= grid[i][j-1]){
                I=i-1; J=j;
            }
            else{
                I=i;J=j-1;
            }
            dp[I][J] = dp[i][j] + grid[I][J];    
            
        }



        return dp[0][0];
    }
}