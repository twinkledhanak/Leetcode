// Please do it after Walls and Gate
// I have put the simplified solution here that is loosely derived from Walls and gates
// It is to make code more readable and life more easier
// I initially thought the idea was based on DP
// But, this is a grid traversal, where matrix itself is acting as storage for DP
/** 
WE ARE MODIFYING THE INPUT ARRAY HERE, SO CONFIRM WITH INTERVIEWER IF WE CAN DO THIS 
THE ONLY REASON WE DO THIS IS, THE ORIGINAL SOLUTION TO THIS PROBLEM HAS SOME FOR LOOP LOGIC
INSIDE THE MAIN BFS WHICH IS VERY CONFUSING (MORE LIKE LEVEL ORDER TRAVERSAL OF THE TREE)
*/

// Feb 2026 solution

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // A. Different from WAG
        // If we are blocked at the start or end, nothing below matters
        if(grid[0][0] == 1 || grid[R-1][C-1] == 1)
            return -1;

        // B. Different from WAG
        // Remember, we can check 8 directions here!! Not 4
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};

        // start offered to queue
        queue.offer(new int[]{0,0});


        // Marking the cell as visited, this just helps with BFS 
        grid[0][0] = 1; 

        while(!queue.isEmpty()){
            int[] cell = queue.poll();

            // C. Different from WAG
            // We have reached the last index while processing
            if(cell[0] == R-1 && cell[1] == C-1) 
                return grid[cell[0]][cell[1]];


            for(int[] d:dir){
                int nx = cell[0]+d[0];
                int ny = cell[1]+d[1];

                // This is Grid BFS, so we filter when we enqueue
                if(nx>=0&&nx<R&&ny>=0&&ny<C&&grid[nx][ny]==0){
                    grid[nx][ny] = grid[cell[0]][cell[1]] + 1;
                    queue.offer(new int[]{nx,ny}); 
                }
                    
            }
        }
        return -1;
        
    }
}

