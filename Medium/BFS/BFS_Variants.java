// https://leetcode.com/discuss/study-guide/1833581/bfs-and-its-variations

Doing BFS is easy;
But doing BFS from a more optimal point is equally important


1. Standard BFS
    -Time: O(V+E) // Using adj list, O(v^2) using adj matrix
    -Space: O(V+E)

2. BFS from Borders 
    -(Surrounded regions, we accumulate all border cells together and start BFS from each cell)
    -Time: O(N) , N = Number of Cells on the board we traverse
    -Space: O(N), N = Number of Cells on the board we traverse (Please read the explanation)

3. 0-1 BFS (Shortest Bridge)
    -We traverse entire grid 
    -Time: O(n*m) // n: no of rows, m: no cols
    -Space: O(n*m)


4. Multi Source BFS (Walls and Gates, we accumulate all gates together and start BFS from each gate)
    -We traverse entire grid 
    -Time: O(n*m) // n: no of rows, m: no cols
    -Space: O(n*m)

5. BFS with Bitmasking (Shortest Path with Alternating colours)
    -Time: O(V+E)
    -Space: O(V+E) 

6. Bi-Directional BFS (Word ladder)
    -

7. Recursive BFS 
- We know recursion uses stacks, but we use queue in this recursive function
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