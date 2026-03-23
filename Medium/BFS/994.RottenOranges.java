/**
Main USP: BFS + Iterative + level order


0: Empty
1: Fresh
2: Rotten

Fresh becomes rotten (1 -> 2) if 1 is connected in 4 dir of 2
Min time for all fresh oranges to be rotten

Vibes: Of Flood fill BFS
Can keep track of count of fresh oranges
BFS done from Rotten oranges
Everytime a 1 -> 2, add it to queue for exploration
We decrement count of fresh oranges, at the end if count of fresh > 0, ret -1

keep track of visited rotten oranges
Skip: Empty, 3
Once we visit a rotten/fresh: mark it to 3 so not visited again

All above is correct, but tracking time?
Time is tracked ONCE for every level


Meaning? We have to track levels in the problem
BFS + Iterative + level order

*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int empty=0, fresh=1, rotten=2, visited=3;
        int countFresh = 0, minutes=-1; // NOT 0

        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

        // Enqueue all rotten oranges in queue
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(grid[i][j] == rotten)
                    queue.offer(new int[]{i,j});
                if(grid[i][j] == fresh)
                    countFresh+=1;    
            }
        }

        // BFS from rotten oranges
        while(!queue.isEmpty()){
            //int[] pos = queue.poll();
            int qSize = queue.size();

            // EXPLICITLY tracking the levels to increment minutes
            for(int i=0; i<qSize; i++){
                int[] pos = queue.poll();

                for(int[] d: dir){
                    int x = pos[0]+d[0];
                    int y = pos[1]+d[1];

                    // Filter & enqueue
                    // Add fresh and convert to rotten+visited
                    if(x>=0 && x<R && y>=0 && y<C && grid[x][y]==fresh){
                        grid[x][y] = visited;
                        countFresh-=1;
                        queue.offer(new int[]{x,y});
                    }
                    
                }
            }        
            minutes+=1;
        }

        // For cases like [[0]], when above loop doesnt run
        return countFresh>0? -1 : Math.max(0,minutes);

    }
}

// Time: O(R*C)
// Space: O(R*C)