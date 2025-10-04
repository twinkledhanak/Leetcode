/*
Most important concept
A = [a b c]
    [d e f]

A is a matrix of 2 rows and 3 columns 
If we were to represent A as a single dim array, we can convert it to row-order or column-order 

row-order = [a b c d e f]
colum-order = [a d b e c f]

In row-major order, the element at (r, c) would end up at index r * nc + c
int row = id / nc; 
int col = id % nc;

*/


class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {

                    // Using Iterative BFS instead of recursive DFS to save space
                    //idea is to store both r and c as a single integer. If you were to convert grid to a one-dimensional array
                    // using row-major order, the element at (r, c) would end up at index r * nc + c

                    // neighbours has a list of all indices of the matrix
                    ++num_islands;
                    grid[r][c] = '0'; // mark as visited
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c); // add a given element to Queue
                    while (!neighbors.isEmpty()) {

                        // Similar to always - retrieve a neighbour and get it's position in grid
                        // retrieve the row and column from the neighbour id we calculated earlier
                        int id = neighbors.remove();
                        int row = id / nc; 
                        int col = id % nc;

                        // For every element retrieved, we define it in terms of it's row and column indices
                        // Explore all 4 directions for each element we retrieved
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }
}