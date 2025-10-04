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