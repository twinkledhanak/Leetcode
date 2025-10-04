// https://leetcode.com/problems/shortest-bridge/description/
// Leetcode explanation is confusing
// Refer to Neetcode for solution
// https://www.youtube.com/watch?v=gkINMhbbIbU


// https://leetcode.com/discuss/study-guide/1833581/bfs-and-its-variations

// Also refer to recursive BFS solution

class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int firstX = -1, firstY = -1;
        
        // Find any land cell, and we treat it as a cell of island A.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    firstX = i;
                    firstY = j;
                    break;
                }
            }
        }

        // bfsQueue for BFS on land cells of island A; secondBfsQueue for BFS on water cells.
        List<int[]> bfsQueue = new ArrayList<>();
        List<int[]> secondBfsQueue = new ArrayList<>();
        bfsQueue.add(new int[]{firstX, firstY});
        secondBfsQueue.add(new int[]{firstX, firstY});
        grid[firstX][firstY] = 2;

        // BFS for all land cells of island A and add them to secondBfsQueue.
        while (!bfsQueue.isEmpty()) {
            List<int[]> newBfs = new ArrayList<>();
            for (int[] cell : bfsQueue) {
                int x = cell[0];
                int y = cell[1];
                for (int[] next : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
                    int curX = next[0];
                    int curY = next[1];
                    if (curX >= 0 && curX < n && curY >= 0 && curY < n && grid[curX][curY] == 1) {
                        newBfs.add(new int[]{curX, curY});
                        secondBfsQueue.add(new int[]{curX, curY});
                        grid[curX][curY] = 2;
                    }
                }
            }
            bfsQueue = newBfs;
        }

        int distance = 0;
        while (!secondBfsQueue.isEmpty()) {
            List<int[]> newBfs = new ArrayList<>();
            for (int[] cell : secondBfsQueue) {
                int x = cell[0];
                int y = cell[1];
                for (int[] next : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
                    int curX = next[0];
                    int curY = next[1];
                    if (curX >= 0 && curX < n && curY >= 0 && curY < n) {
                        if (grid[curX][curY] == 1) {
                            return distance;
                        } else if (grid[curX][curY] == 0) {
                            newBfs.add(new int[]{curX, curY});
                            grid[curX][curY] = -1;
                        }
                    }
                }
            }

            // Once we finish one round without finding land cells of island B, we will
            // start the next round on all water cells that are 1 cell further away from
            // island A and increment the distance by 1.
            secondBfsQueue = newBfs;
            distance++;
        }
        return distance;
    }
}

// From Neetcode, but converted to java -
import java.util.*;

class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private Set<int[]> visited;
    private int N;

    public int shortestBridge(int[][] grid) {
        N = grid.length;
        visited = new HashSet<>();
        boolean found = false;

        // Find the first island and mark it in the visited set
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    dfs(grid, r, c);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        // Perform BFS to find the shortest path to the second island
        return bfs(grid);
    }

    private void dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= N || grid[r][c] == 0 || !visited.add(new int[]{r, c})) {
            return;
        }

        for (int[] dir : directions) {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }

    private int bfs(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>(visited);
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for (int[] dir : directions) {
                    int curR = r + dir[0];
                    int curC = c + dir[1];

                    if (curR < 0 || curC < 0 || curR >= N || curC >= N || visited.contains(new int[]{curR, curC})) {
                        continue;
                    }

                    if (grid[curR][curC] == 1) {
                        return steps;
                    }

                    queue.offer(new int[]{curR, curC});
                    visited.add(new int[]{curR, curC});
                }
            }
            steps++;
        }
        return -1; // Should never reach here if input is valid
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {
            {0, 1, 0},
            {0, 0, 0},
            {0, 0, 1}
        };
        System.out.println(sol.shortestBridge(grid)); // Output: 2
    }
}
