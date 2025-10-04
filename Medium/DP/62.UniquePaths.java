// THIS SOLUTION FILLS MATRIX FROM TOP TO BOTTOM AND THEN LEFT TO RIGHT (COLUMN WISE FIRST)
// ************************************************************************************************************
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];

        // Pt. A
        for (int[] arr : d) {
            Arrays.fill(arr, 1);
        }

        // we start from col and also, col = 1, since col=0 already has our start point
        for (int col = 1; col < m; ++col) { 
            // we start from row = 1, row is considered after the col
            for (int row = 1; row < n; ++row) {


                // We are filling out matrix from top to bottom, then left to right
                // NOT left to right and top to bottom, hence the reverse order of loops
                d[col][row] = d[col - 1][row] + d[col][row - 1];
            }
        }
        return d[m - 1][n - 1]; // last cell of the matrix has the answer
    }
}

// THIS SOLUTION FILLS MATRIX IN STANDARD WAY 
// ************************************************************************************************************
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];

        // Pt. A
        for (int[] arr : d) {
            Arrays.fill(arr, 1);
        }

        // Interchanged the row and cols order here
        for (int row = 1; row < m; ++row) {
        for (int col = 1; col < n; ++col) { 
                d[row][col] = d[row-1][col] + d[row][col-1];
            }
        }
        return d[m - 1][n - 1]; // last cell of the matrix has the answer
    }
}

// We start from the bottom
// We depend on prev two values, top and left as from the start we can only move right and down

// Couple of important points::
/*
Pt. A => Base case is:
1   1
1   x

We have our entire first row and first col filled with ones
But rather than having custom logic, we just fill everything with 1's.
We can always re-write values,
initially our x will be 1 (due to Pt. A)
But later, we will override that value with the dp logic.


We are iteratively building solution, so we have loops and we start from base case.
We're moving in direction towards end, but building solution from start to end.

Time complexity: O(N×M).

Space complexity: O(N×M).

We can do better than this, but there is a python3 solution only using binomial coefficients

https://leetcode.com/problems/unique-paths/editorial/?envType=study-plan-v2&envId=dynamic-programming

*/


