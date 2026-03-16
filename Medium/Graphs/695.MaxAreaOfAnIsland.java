// In java - every recursion gets it own local copy of the variable. Java works on pass by value
// These values are modified by every dfs call
// But IF that value is not returned or used, it's essentially lost.


class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int R = grid.length;
        int C = grid[0].length;
        int maxArea = 0;

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(grid[i][j] == 1){
                    // Assume every dfs will return the no of cells of count 1
                    int area = dfs(grid, i, j, R, C);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j, int R, int C){
        // Start with a recursive function

        // If invalid cell
        if(i >= R || i < 0 || j >= C || j < 0 || grid[i][j] == 0)
            return 0; // return; when void

        // marking as visited before recursion
        grid[i][j] = 0; 

        // Learning #1 => instantiate variable inside the function
        // But, IF WE SET THIS TO 0 => IT WILL RESET THE ENTIRE HISTORY
        // HENCE WE SET IT TO 1
        // IF I HAD PASSED area in parameter - along with some more changes - it would have counted
        // all the ones we have in the grid & we have better techniques than recursion to do that
        int area = 1; 

        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int[] dir : directions){
            area += dfs(grid, i+dir[0], j+dir[1], R, C); // Learning #2 => Accumulate the deeper values of recursion
        }

        return area;
    }


}

Time: O(m*n)
Space: O(m*n) - nothing is min max here 

| Statement   | Valid in this context? | What it does                                      | Result              |
| ----------- | ---------------------- | ------------------------------------------------- | ------------------- |
| `return 0;` | ✅ Yes                  | Returns 0 area for invalid cell                   | ✅ Correct           |
| `return;`   | ❌ Invalid here         | Compilation error — function expects `int` return | ❌ Wont compile     |
| continue; | ❌ Invalid here         | Only valid inside loops — not in a method         | ❌ Compilation error |
