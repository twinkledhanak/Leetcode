/**
Brute Force:
Check the board (rowsRecord, colsRecord and two diagonals) after every move
Time: O(m*n)
Space: O(n^2)
*/
class Solution {

    // Initialize the board, n = 3 in this problem.
    private int[][] board;
    private int n = 3;
    
    public String tictactoe(int[][] moves) {
        board = new int[n][n];
        int player = 1; // Players are 1 and -1; A and B
        
        // For each move
        for (int[] move : moves){
            int row = move[0], col = move[1];

            // Mark the current move with the current playrer's id.
            board[row][col] = player;

            // If any of the winning conditions is met, return the current player's id.
            if (checkRow(row, player) || checkCol(col, player) || 
                // how do we know it is a diagonal? row will be same as col
               (row == col && checkDiagonal(player)) || (row + col == n - 1 && checkAntiDiagonal(player))){
                return player == 1 ? "A" : "B";
            }

            // If no one wins so far, change to the other player alternatively. 
            // That is from 1 to -1, from -1 to 1.
            player *= -1;       
        }

        // If all moves are completed and there is still no result, we shall check if 
        // the grid is full or not. If so, the game ends with draw, otherwise pending.
        // If the number of moves = no of cells on the grid -> grid is full; could mean that game is either draw or pending
        return moves.length == n * n ? "Draw" : "Pending";   
    }

    // Check if any of 4 winning conditions to see if the current player has won.
    // For a given row, check all colsRecord -> row i, colsRecord 0,1,2
    private boolean checkRow(int row, int player){ 
        for (int col = 0; col < n; ++col){
            if (board[row][col] != player) 
                return false;
        }
        return true;
    }
    
    // For a given col, check all rowsRecord -> row 0,1,2 col = i
    private boolean checkCol(int col, int player){
        for (int row = 0; row < n; ++row){
            if (board[row][col] != player) 
                return false;
        }
        return true;
    }
    
    // No need to pass the row; we will iterate through all rowsRecord
    private boolean checkDiagonal(int player){
        for (int row = 0; row < n; ++row){
            if (board[row][row] != player) return false;
        }
        return true;
    }
    
    private boolean checkAntiDiagonal(int player){
        for (int row = 0; row < n; ++row){
            if (board[row][n - 1 - row] != player) return false;
        }
        return true;
    }
}  

/**
Optimised approach:
If a player A wins, who is denoted by 1, we will have sum of any row/col/diagonal as 3
If a player B wins, who is denoted by -1, we will have sum of any row/col/diagonal as -3
So, we record each move and check the sum of row/col/diagonal.
If we have reached 3 or -3 (n or -n), we have a winner
If the sum is not yet reached -> Pending
If a row has 2 moves of player A and one of Player B, it will still not be 3 => 1+1-1 = 1
Draw condition? 

Let n be the length of the board and m be the length of input moves.

Time complexity: O(m)
For every move, we update the value for a row, column, diagonal, and anti-diagonal. Each update takes constant time. 
We also check if any of these lines satisfies the winning condition which also takes constant time.

Space complexity: O(n)
We use two arrays of size n to record the value for each row and column, and two integers of constant space to record to 
value for diagonal and anti-diagonal.
*/

class Solution {
    public String tictactoe(int[][] moves) {

        // n stands for the size of the board, n = 3 for the current game.
        int n = 3;

        // Use rowsRecord and colsRecord to record the value on each row and each column.
        // diag1 and diag2 to record value on diagonal or anti-diagonal.
        int[] rowsRecord = new int[n], colsRecord = new int[n];
        int diag = 0, anti_diag = 0;
        
        // Two players having value of 1 and -1, player_1 with value = 1 places first.
        int player = 1;
        
        for (int[] move : moves){

            // Get the row number and column number for this move.
            int row = move[0], col = move[1];
            
            // Update the row value and column value.
            // Each player's move will contribute to both row and col
            // It can also update a diagonal
            rowsRecord[row] += player;
            colsRecord[col] += player;
            
            // If this move is placed on diagonal or anti-diagonal, 
            // we shall update the relative value as well.
            if (row == col){
                diag += player;
            }
            if (row + col == n - 1){
                anti_diag += player;
            }
            
            // Check if this move meets any of the winning conditions.
            if (Math.abs(rowsRecord[row]) == n || Math.abs(colsRecord[col]) == n || 
                Math.abs(diag) == n || Math.abs(anti_diag) == n){
                return player == 1 ? "A" : "B";
            }
            
            // If no one wins so far, change to the other player alternatively. 
            // That is from 1 to -1, from -1 to 1.
            player *= -1;
        }
        
        // If all moves are completed and there is still no result, we shall check if 
        // the grid is full or not. If so, the game ends with draw, otherwise pending.
        return moves.length == n * n ? "Draw" : "Pending";
    }
}