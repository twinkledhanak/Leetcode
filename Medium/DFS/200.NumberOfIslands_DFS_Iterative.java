class Solution{
    public int numIslands(char[][] grid){
        int R = grid.length;
        int C = grid[0].length;
        int noOfIslands = 0;

        // 1. First the first land & then start dfs
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j, R, C);
                    noOfIslands +=1;
                }
            }
        }
        return noOfIslands;


    }


    void dfs(char[][] grid, int i, int j, int R, int C){
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{i,j});
        // Rectification #1: We want to mark the cell as visited inside the traversal
        // Adding below line was giving TLE
        // Marked a cell as 0 BEFORE processing it
        // WE DID VISIT THIS CELL, BUT WAS IT VALID? MAYBE NOT
        //grid[i][j] = '0';

        while(!stack.isEmpty()){
            int[] arr = stack.pop(); // current index

            // Process the index
            // use return; Stop the dfs if any invalid cell is found => Wrong approach ************************
            // use continue; Skip the invalid cell and continue with the dfs
            if(arr[0] >= R || arr[0] < 0 || arr[1] >=C || arr[1] < 0 || grid[arr[0]][arr[1]] == '0')
                continue; // Rectification #2: I have to skip the invalid cell, not terminate entire dfs
            
            grid[arr[0]][arr[1]] = '0';

            // Rectification #3: I have to manually push all directions into the stack
            stack.push(new int[]{arr[0],arr[1]+1});
            stack.push(new int[]{arr[0],arr[1]-1});
            stack.push(new int[]{arr[0]+1,arr[1]});
            stack.push(new int[]{arr[0]-1,arr[1]});
                
             

        }


    }


}

|                                                | **DFS Recursive**                      | **DFS Iterative**                                                    | **BFS Recursive**                                  | **BFS Iterative**                                         |
| ---------------------------------------------- | -------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------- | --------------------------------------------------------- |
| **When to mark visited?**                      | ✅ Before recursive call                | ✅ After popping from stack                                           | ⚠️ Rarely used                                     | ✅ When enqueuing                                          |
| **Why?**                                       | To avoid cycles and infinite recursion | Because stack might hold same cell multiple times if not yet visited | BFS recursion is rare (usually not used for grids) | To avoid adding the same cell multiple times to the queue |
