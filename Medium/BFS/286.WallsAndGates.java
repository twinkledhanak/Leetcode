/*
Instead of searching from an empty room to the gates, how about searching the other way round? In other words, we initiate 
breadth-first search (BFS) from all gates at the same time. Since BFS guarantees that we search all rooms of distance d before
searching rooms of distance d + 1, the distance to an empty room must be the shortest.
*/

// Multi Source BFS

private static final int EMPTY = Integer.MAX_VALUE;
private static final int GATE = 0;
private static final List<int[]> DIRECTIONS = Arrays.asList(
        new int[] { 1,  0},
        new int[] {-1,  0},
        new int[] { 0,  1},
        new int[] { 0, -1}
);

public void wallsAndGates(int[][] rooms) {
    int m = rooms.length;
    if (m == 0) return;
    int n = rooms[0].length;
    Queue<int[]> q = new LinkedList<>();

    // Go thorugh entire grid, whenever we encounter a gate - start bfs and fill up the cells 
    for (int row = 0; row < m; row++) {
        for (int col = 0; col < n; col++) {
            if (rooms[row][col] == GATE) {
                q.add(new int[] { row, col }); // just enqueue the gates together!!
            }
        }
    }

    // Now go through all gates together and fill up the closest empty cells first, in all four directions
    while (!q.isEmpty()) {

        // 1. Take a given gate
        int[] point = q.poll(); 
        int row = point[0];
        int col = point[1];

        // 2. Search in all directions
        for (int[] direction : DIRECTIONS) { 
            int r = row + direction[0];
            int c = col + direction[1];
            if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                continue;
            }
            rooms[r][c] = rooms[row][col] + 1; //** Modify the actual grid */ ;Just increment values from previous ones

            q.add(new int[] { r, c });
        }
    }
}
/*
Time complexity : O(mn).

If you are having difficulty to derive the time complexity, start simple.

Let us start with the case with only one gate. The breadth-first search takes at most m×n steps to reach all rooms, therefore 
the time complexity is O(mn). But what if you are doing breadth-first search from k gates?
Once we set a room's distance, we are basically marking it as visited, which means each room is visited at most once. 
Therefore, the time complexity does not depend on the number of gates and is O(mn).

Space complexity : O(mn).
The space complexity depends on the queue's size. We insert at most m×n points into the queue.
*/

// Another way of writing the same above code, but in a way that - BFS grids - filter when enqueue, not pop

class Solution {
    public void wallsAndGates(int[][] rooms) {
        // start with a gate
        // find connected empty rooms
        // fill them, if already filled - take minimum
        // use BFS, queue all gates together

        int row = rooms.length;
        int col = rooms[0].length;
        int INF = Integer.MAX_VALUE;
        int distance = 1;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

        // Enqueue all gates together
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(rooms[i][j] == 0) // gate
                    queue.offer(new int[]{i,j});
            }
        }

        // Starting one BFS from the gates
        while(!queue.isEmpty()){
            int[] cell = queue.poll();

            for(int d[]: directions){
                // Invalid positions wont have anything
                int x = cell[0]+d[0];
                int y = cell[1]+d[1];

                // Enqueue only valid cells
                // What are valid cells?
                // Within boundaries and empty [==INF] condition
                if(x>=0&&x<row&&y>=0&&y<col&&rooms[x][y]==INF){ // (*&^%$#@#$%^&*&^%$#@#$%^&*()(*&^%$#))
                    rooms[x][y] = rooms[cell[0]][cell[1]] + 1; 
                    queue.offer(new int[]{x,y});
                }
            }
        }

    }
}


/***
1️⃣ When a variable should be global (or persistent across calls)
	•	Purpose: You want to remember information across multiple calls or iterations.
	•	Example: Cycle detection in DFS:
Set<Integer> visited = new HashSet<>();
Set<Integer> recursionStack = new HashSet<>();
	visited keeps track of all nodes you’ve completely explored.
	•	recursionStack keeps track of nodes currently in the path.
	•	Both sets need to persist across all DFS calls, otherwise you lose track of nodes you’ve 
    already processed → might detect false cycles or revisit nodes unnecessarily.

Key rule: If the information represents “state of the entire search” and not just one path, 
it should persist globally (or at least at the outer method level).

2️⃣ When a variable should be local (or reset for each call)
	•	Purpose: You want information that is specific to the current invocation or path, not shared globally.
	•	Example: Distance in BFS on a grid:
    distance is relative to the BFS traversal.
	•	It should be calculated for each cell separately:
rooms[nrr][ncc] = rooms[r][c] + 1;

If you use a single global distance counter, it increments incorrectly because BFS visits cells in layers,
not sequentially. The distance should flow with the BFS layers, not as a single global counter.

Key rule: If the information is path-specific or incremental per node, it should be local or calculated 
per node — otherwise it gets corrupted when multiple paths are explored in parallel (BFS) or recursively (DFS).

Does the variable need to persist across multiple calls or iterations?
	•	YES → global
	•	NO → local


*/