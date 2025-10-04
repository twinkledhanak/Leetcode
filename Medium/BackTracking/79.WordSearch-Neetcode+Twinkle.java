
// Combines my idea of making a string : AB, backtrack and then removing B from AB
// with idea from neetcode

class Solution {
    
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        // index is the position tracker on main word
        
        // Step 1: Search for the first letter on the board
        // First letter = word.charAt(0);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                 // if grid has 2 A's, it will do below for only those 2 A's
                if (board[i][j] == word.charAt(0)) {
                    StringBuilder currString = new StringBuilder(); // Making string from scratch
                    if (helper(board, word, 0, i, j, row, col, currString)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    // board pos - i,j ; row, col; index: to iterate word
    private boolean helper(char[][] board, String word, int index, int i, int j, int row, int col, StringBuilder currString) {
        // ******************************* Base conditions *******************************
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != word.charAt(index)) {
            return false;
        }

        // We could traverse the entire string
        if (index == word.length() - 1) {
            return true;
        }
        
        // Why do we need currString here at all?
        // 1. When we backtrack, we must know what char to remove
        // 2. When we backtract, we must know what char to re-instate on grid (we had modified grid earlier)
        currString.append(board[i][j]); // Append to a string
        board[i][j] = '#';
        
        // The adding part is out of the loop 
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (helper(board, word, index + 1, newI, newJ, row, col, currString)) {
                return true;
            }
        }
        
        board[i][j] = currString.charAt(currString.length() - 1); // Backtrack
        currString.deleteCharAt(currString.length() - 1); // Remove the last character
        
        return false;
    }
}

// Time complexity: O(n^2) for searching the word's first letter
// In the one letter that matches the word's first letter

My complexity derived as :
/**
We have to recurse and backtrack,
(fan-out)^(no of nodes)
fan out = max(4,2) = 4 choices
no of nodes = no of cells in grid = n
m => m is no of letters
O(n * 4^m)

*/

Actual:
/**
Time Complexity: O(N⋅3^L) where N is the number of cells in the board and L is the length of the word to be matched.

For the backtracking function, initially we could have at most 4 directions to explore, but further the choices are reduced into 
3 (since we won't go back to where we come from).
As a result, the execution trace after the first step could be visualized as a 3-nary tree, each of the branches represent a
 potential exploration in the corresponding direction. Therefore, in the worst case, the total number of invocation would be 
 the number of nodes in a full 3-nary tree, which is about 3^L


We iterate through the board for backtracking, i.e. there could be N times invocation for the backtracking function in the worst case.


Space Complexity: O(L) where L is the length of the word to be matched.

The main consumption of the memory lies in the recursion call of the backtracking function. The maximum length of the call stack would be the length of the word. Therefore, the space complexity of the algorithm is O(L).

*/