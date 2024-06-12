// Print the total number of solutions possible for N-Queens

class Solution {
    private int ctr=0;
    public int totalNQueens(int n) {
        
        int[][] chess = new int[n][n];
        printNQueens(chess,"",0);
        return ctr;
    }

    public void printNQueens(int[][] chess, String qsf, int row){
        
        if(row == chess.length){
            ctr+=1;
           // System.out.println("ctr: "+ctr);
           // IF WE WANT TO PRINT THE ACTUAL SOLUTIONS, WE CAN USE THIS
           // System.out.println(" "+qsf);
            return;
        }

        for(int col=0; col<chess.length; col++){
            if(isSafe(chess,row,col) == true){
                chess[row][col] = 1;
                //printNQueens(chess,qsf + row + " " + col + " ",row+1);// IF WE WANT TO PRINT THE ACTUAL SOLUTIONS, WE CAN USE THIS
                printNQueens(chess,qsf,row+1);
                chess[row][col] = 0;
            }

        }
        

    }


    public boolean isSafe(int[][] chess, int row, int col){
        for(int i=row-1, j=col; i>=0; i--){
            if(chess[i][j] == 1){
                return false;
            }
        }

        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(chess[i][j] == 1){
                return false;
            }
        }

        for(int i=row-1, j=col+1; i>=0 && j<chess.length; i--, j++){
            if(chess[i][j] == 1){
                return false;
            }
        }
        return true;
    }
}