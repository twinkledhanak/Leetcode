/**
This uses combination of two ideas -
No of islands and backtracking
Basic layout is no of islands and then idea of exploring as choices of backtracking
We do not really keep appending and check the string chars
We only append when the char is right, so we can just check the length

Start with all chars of the grid
We do backtracking, we compare char by char
We just backtracking and find all position; increment position of string when we find a match

*/

class Solution {
    private char[][] board;
    private int ROWS;
    private int COLS;

// This is correct, but they are storing the path and removing from path
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int row = 0; row < this.ROWS; ++row) {
            for (int col = 0;col < this.COLS;++col) {
                // invoke backtrack for all rows/cols of grid, I WANTED TO DO IT ONLY FOR 2 POS
                if (this.backtrack(row, col, word, 0)) // Index is for cleanup
                return true;
            }
        }
        return false;
    }

    protected boolean backtrack(int row, int col, String word, int index) {
        /* Step 1). check the bottom case. */
        if (index >= word.length()) return true; // ?????? , yes, we were able to reach the entire word while matching characters

        /* Step 2). Check the boundaries. */
        if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS) 
            return false;   

        if (this.board[row][col] != word.charAt(index)) // instead of comparing everything, just compare the current index of word and position
            return false;    

        /* Step 3). explore the neighbors in DFS */
        boolean ret = false;
        // mark the path before the next exploration
        this.board[row][col] = '#'; // modifying the original grid

        int[] rowOffsets = { 0, 1, 0, -1 };
        int[] colOffsets = { 1, 0, -1, 0 };
        for (int d = 0; d < 4; ++d) {
            ret = this.backtrack(row + rowOffsets[d],col + colOffsets[d],word,index + 1);
            if (ret) break;
        }

        /* Step 4). clean up and return the result. */
        this.board[row][col] = word.charAt(index); // clean up since we were placing # everywhere
        return ret;
    }
}

/*
// Referring back to old formula:
// (Time at every node) * (fan-out)^(height+1)
// Fan-out => no of expansion nodes for every nodes // no of choices => 3 for letter '2' [a,b,c] and 4 for letter '7' = 4
// m^(height+1)
// Height is no of nodes of tree , in worst case is n, good case - logn
// m^(n+1) ~ = m^(n)
// We iterate through all digits, array size is n
// (n) * m^(n+1) OR (n) * m^(n)

Between grid traversal, O(n^2) and Backtracking - BT takes the maximum time

Fan-out here - expected 4 (4 directions), but we cannot go back to previous one, so total 3 directions only
fan-out=3
L = length of word to be matched -> 
Therefore, in the worst case, the total number of invocation would be the number of nodes in a full 3-nary tree, which is about 3^L
No of cells in grid - N
N * (3^L)

The main consumption of the memory lies in the recursion call of the backtracking function. The maximum length of the call stack
would be the length of the word. Therefore, the space complexity of the algorithm is O(L).

*/