// Uses DFS

/***

CASE 1: WHEN WE ARE ALLOWED TO MODIFY THE INPUT MATRIX
 */
class Solution {

// DO NOT MAINTAIN A SEPARATE VISITED MATRIX HERE, IT JUST GETS CONFUSING. INSTEAD JUST MODIFY THE GRID TO SET TO 1 OR 0
// DFS DOESNT RETURN ANYTHING, JUST CHECKS ALL BOUNDARY VALIDITY CONDITIONS FOR AN ISLAND.
// DFS MARKS ALL VISITED AS ZERO IN MAIN GRID. SO NO OF DFS CALLS FROM MAIN WILL INCREMENT NUM_ISLANDS ONLY FOR VALID ANSWER
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int nr = grid.length;
    int nc = grid[0].length;
    int num_islands = 0; // No static variables!

    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == '1') {
          ++num_islands;
          dfs(grid, r, c); // Doesnt return anything, just for the sake of marking everything visited
        }
      }
    }

    return num_islands;
  }


  void dfs(char[][] grid, int r, int c) {
    int nr = grid.length;
    int nc = grid[0].length;

    // we do not want the i,j to be equal to grid boundaries
    // Hence, r >= nr, not just, r > nr
    // We are just checking for '0' in the grid - not '#'
   
    // Case 1:
    /**
    We mark the visited cell as #
    In dfs function - we change 
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] != '1') { // stop dfs it is not 1
            return;
        }

        grid[i][j]='#';

    We consider both # and 0 as water, so update these two conditions

    */

    // Case 2:
    /**
     We mark the visited cell as 0
     Below code works for it
     We only have two variables in the grid, 0 and 1 
    
    */

    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
      return;
    }

    // *******
    // WHEN MARKING VISITED, WE CHANGE THE VALUE TO '0' HERE FOR THE GRID CELL
    grid[r][c] = '0'; // ==> saviorrrrr. I had added check, visited[i][j] = true but didnt work
    dfs(grid, r - 1, c);
    dfs(grid, r + 1, c);
    dfs(grid, r, c - 1);
    dfs(grid, r, c + 1);

    // if we are reverting the grid back to its original position value, it is simply backtracking!!
    // Backtracking in a nutshell -
    // modify something
    // recurse
    // revert back to original state

    // the idea that we can just backtrack after taking one step is not always true, we may go deep inside a route,
    // take 4 right steps and then a wrong one, so we just revert that one step
  }

  
}

// Time: O(m*n), consider only the matrix, O(n^2) , if it is a square matrix
// If we were working with adj matrix - we are only accessing the rows of matrix & col access in real time
// So there it makes sense to have O(m+n)
/*
When dfs(grid, r, c) is called, it marks the cell (r, c) and all its connected '1's as '0'. This marking ensures that the same 
cell will not be visited again in future iterations of the outer loops or subsequent DFS calls.
The DFS function itself explores all possible cells connected to (r, c). Each cell is visited once and only once due to the marking.

Space: O(m*n) as the DFS stack will make m*n number of calls (stack depth)

*/



/**
CASE 2: WHEN WE CANNOT MODIFY THE INPUT GRID
*/

class Solution{
    public int numIslands(char[][] grid) {    

        int R = grid.length;
        int C = grid[0].length;
        Set<String> visited = new HashSet<>(); // Set; String of form i,j
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int noOfIslands = 0;

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(grid[i][j] == '1' && !visited.contains(i+","+j)){ // 1.
                    // start DFS 
                    noOfIslands++;
                    dfs(i,j,R,C,grid,visited,directions);
                }
            }
        }
        return noOfIslands;

    }

    public void dfs(int i, int j, int R, int C, char[][] grid, Set<String> visited, int[][] directions){
        // boundary check
        if(i<0 || j<0 || i>=R || j>=C || grid[i][j] == '0' || visited.contains(i + "," + j)) // 2.
            return;

        visited.add(i+","+j);    // 3. Instead of modifying the grid

        for(int[] d : directions)
            dfs(i+d[0],j+d[1],R,C,grid,visited,directions);


            
        
    }


}
