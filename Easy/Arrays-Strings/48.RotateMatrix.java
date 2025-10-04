class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int y = n - 1 - j; // y
                int x = n - 1 - i; // x

// i, j, x , y, i
                int temp = matrix[y][i];
                matrix[y][i] = matrix[x][y];
                matrix[x][y] = matrix[j][x];
                matrix[j][x] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}

Time complexity: O(M), as each cell is getting read once and written once.

Space complexity: O(1) because we do not use any other additional data structures.


