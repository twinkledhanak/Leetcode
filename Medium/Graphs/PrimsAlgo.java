// java program for Prim's MST for adjacency list
// representation of graph

// select a min edge
// select a connected min edge

// Refer to Algo excel sheet for complexities
import java.util.*;

class Solution {
    public int[] primMST(int n, int[][] edges) {

        // 1. Build the graph — same as before
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adjMap.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
            adjMap.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, w});
        }

        // 2. Setup — same spirit as BFS setup
        int[] parent = new int[n];      // which node connected us to MST
        int[] key    = new int[n];      // cheapest edge cost to reach this node
        boolean[] inMST = new boolean[n];

        Arrays.fill(parent, -1);
        Arrays.fill(key, Integer.MAX_VALUE);

        // MinHeap instead of Queue — int[]{node, cost}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // 3. Seed the starting node — same as seeding solar panels in BFS
        key[0] = 0;
        minHeap.offer(new int[]{0, 0});

        // 4. Prim's traversal — same structure as BFS while loop
        while (!minHeap.isEmpty()) {
            int u = minHeap.poll()[0];  // pick cheapest node (like polling queue in BFS)

            if (inMST[u]) continue;     // skip if already visited (replaces visited set)
            inMST[u] = true;

            for (int[] neighbour : adjMap.getOrDefault(u, new ArrayList<>())) {
                int v = neighbour[0];
                int w = neighbour[1];

                // same as: if (!visited.contains(neighbour)) in BFS
                if (!inMST[v] && w < key[v]) {
                    parent[v] = u;      // track which node pulled v into MST
                    key[v] = w;         // update cheapest edge cost
                    minHeap.offer(new int[]{v, w});
                }
            }
        }

        return parent;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = {
            {0,1,4}, {0,7,8}, {1,2,8}, {1,7,11},
            {2,3,7}, {2,8,2}, {2,5,4}, {3,4,9},
            {3,5,14},{4,5,10},{5,6,2}, {6,7,1},
            {6,8,6}, {7,8,7}
        };
        int[] parent = sol.primMST(9, edges);
        System.out.println("Edges of MST:");
        for (int i = 1; i < parent.length; i++)
            System.out.println(parent[i] + " - " + i);
    }
}
```

## How it maps to our BFS pattern
```
BFS (solar panels)          Prim's MST
──────────────────────────────────────────────────
Queue                   →   PriorityQueue (MinHeap)
visited set             →   inMST[] boolean array
seed sources            →   seed node 0
distance[v]=distance[u]+1  →   key[v] = edge weight
re-queue neighbour      →   minHeap.offer(neighbour)