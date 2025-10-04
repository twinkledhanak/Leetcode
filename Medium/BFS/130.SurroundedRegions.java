// https://leetcode.com/problems/surrounded-regions/description/

// BFS FROM BORDERS
// Very similar to finding all number of islands, but we do not consider the cells on border
// We start the DFS from the border cells, not the ones which we have to mark
// https://leetcode.com/problems/surrounded-regions/editorial/

/**
Simple Explanation:
You have a board filled with 'X' and 'O' where:

'X' is like a wall.
'O' is like an open space. The task is to find all the groups of 'O's that are completely surrounded by 'X's, like a group of spaces
trapped inside walls. When you find these groups, you need to turn all the 'O's in that group into 'X's because they are trapped.
However, if an 'O' is on the edge of the board or connected to an 'O' on the edge, it can't be trapped since it's "touching the
outside." So, those 'O's remain unchanged.

My understanig from above -
Assuming all borders is entire X - all internal 0 cells surrounded by X will be captured - keeping track of 3 X's for each 0?
If all borders is 0 - nothing can be done
If border is mix of X and 0 - some cells 0 on the border cant be captured, only the internal 0 cells can be.

Lets say if we start BFS from X on border - what do we get? Nothing. They are useless cells
If we start BFS from 0's on the border - we get all connected cells of those 0 - which WILL NOT BE CAPTURED -
It is a negative sentiment - to avoid these connected cells - opposite of no of islands which is a positive 
We are only considering the cells that are connected horizontally or vertically; not diagonal as in the LC example

Sometimes we focus so much on x that we forget it is easier to get 1-x

Get all border cells
Use DFS and identify useless cells (if any border has 0, all connected cells arw useless)


*/


/*
List of optimisations done for this BFS:
1. Rather than iterating all candidate cells (the ones filled with O), we check only the ones on the borders.
2.Our starting points of DFS are those cells that meet two conditions: 1). on the border. 2). filled with O.
3. As an alternative solution, one might decide to iterate all O cells, which is less optimal compared to our starting points
4. Rather than using a sort of visited[cell_index] map to keep track of the visited cells, we simply mark visited cell in place.
5. This technique helps us gain both in the space and time complexity.
BUT, ALWAYS ASK INTERVIEWER IF INPUT CAN BE CHANGED IN PLACE
6. Rather than doing the boundary check within the DFS() function, we do it before the invocation of the function
*/
// start dfs from all 0 cells in the border

// BFS AND DFS GIVES SAME TIME AND SPACE COMPLEXITY -
public class Solution {
    protected Integer ROWS = 0;
    protected Integer COLS = 0;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        this.ROWS = board.length;
        this.COLS = board[0].length;

        List<Pair<Integer, Integer>> borders = new LinkedList<Pair<Integer, Integer>>();
        // Eg. 3X3 grid

        // Step 1). construct the list of border cells
        for (int r = 0; r < this.ROWS; ++r) { 
            borders.add(new Pair(r, 0)); // (0,0), (1,0), (2,0) ...     left border
            borders.add(new Pair(r, this.COLS - 1)); // (0,2), (1,2) ...  right border
        }
        for (int c = 0; c < this.COLS; ++c) {
            borders.add(new Pair(0, c)); // (0,0), (0,1), (0,2) ... top border
            borders.add(new Pair(this.ROWS - 1, c)); // (2,0), (2,1) .. bottom border
        }

    
        // Step 2). mark the escaped cells
        for (Pair<Integer, Integer> pair : borders) {
            this.DFS(board, pair.first, pair.second);
        }

        // SO far, what all do we have on the board?
        // The cells on board - marked as X -> nothing needed
        // The cells on board's border - which were O - now marked as E => We cannot do anything for O's on border. Distinguish them
        // The cells on board - not lying on border, but inside - already O => Our main target which we have to make X now

        // SO now, 
        // X cells remain same
        // We first change E to O, but then we wont be able to differentiate between E's O and target O.
        // So, we first change original Os to X
        // Then E to O

        // Step 3). flip the cells to their correct final states
        for (int r = 0; r < this.ROWS; ++r) {
            for (int c = 0; c < this.COLS; ++c) {
                if (board[r][c] == 'O') 
                    board[r][c] = 'X';
                if (board[r][c] == 'E') 
                    board[r][c] = 'O';
            }
        }
    }

    // AIM: to separate the unwanted O cells from target O cells, mark them as E
    protected void DFS(char[][] board, int row, int col) {
        // This is a border cell, but if it is 0, we have some logic/processing
        // If it is not 0, it is either X or something else and X is useless

        // If cell is useless, return (val != 0)
        if (board[row][col] != 'O')  // if the border cell is either X or E, basically - not O - do nothing
            return;

        // yes, the border cell was O and we could not have flipped it, so mark it E
        board[row][col] = 'E'; // Connected to 0, hence useless cell

        // One col before the boundary
        if (col < this.COLS - 1) 
            this.DFS(board, row, col + 1); // can go right

        if (row < this.ROWS - 1) 
            this.DFS(board, row + 1, col); // can go bottom

        if (col > 0) 
            this.DFS(board, row, col - 1); // can go left

        if (row > 0) 
            this.DFS(board, row - 1, col); // can go up
    }
}

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}



/*
Time Complexity: O(N) where N is the number of cells in the board. In the worst case where it contains only the O cells on the board, we would traverse each cell twice: once during the DFS traversal and the other time during the cell reversion in the last step.

Space Complexity: O(N) where N is the number of cells in the board. There are mainly two places that we consume some additional memory.

We keep a list of border cells as starting points for our traversal. We could consider the number of border cells is proportional to the total number (N) of cells.

During the recursive calls of DFS() function, we would consume some space in the function call stack, i.e. the call stack will pile up along with the depth of recursive calls. And the maximum depth of recursive calls would be N as in the worst scenario mentioned in the time complexity.

As a result, the overall space complexity of the algorithm is O(N).

*/