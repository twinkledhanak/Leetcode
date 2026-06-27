Given a tree with n nodes (labeled 0 to n-1) represented as an edge list, find all nodes that are endpoints
of any diameter of the tree. Return a binary array where result[i] = 1 if node i is a diameter endpoint, 
else 0.
Note: A tree can have multiple diameters (all same length). A node is a key node if it is an endpoint of
any of them.

Example 1:
n=7, edges: [[0,1],[1,2],[2,3],[2,4],[0,5],[0,6]]
Output: [0,0,0,1,1,1,1]

Example 2:
n=2, edges: [[0,1]]
Output: [1,1]

/**
Mental Model
Step 1 — Why two BFS?
BFS from any node → farthest node is ALWAYS a diameter endpoint (theorem)
BFS from that endpoint → farthest node is the OTHER endpoint
Distance between them = diameter length D


Step 2 — Why BFS again from both endpoints?

Tree can have multiple diameters, fanning out like this:

    u1  u2  u3          ← all at distance D from v-side
      \  |  /
       --+--
       core
       --+--
      /  |  \
    v1  v2  v3          ← all at distance D from u-side

Any node at distance D from u = a v-side endpoint
Any node at distance D from v = a u-side endpoint
Union of both sets = ALL diameter endpoints

Step 3 — In a tree, BFS distance = THE distance
Only one path exists between any two nodes
→ shortest path = longest path = only path
→ BFS distance is exact, not just a lower bound

OA Summary:
1. BFS from anywhere    → find endpoint u
2. BFS from u           → find endpoint v, learn diameter D  
3. BFS from u and v     → any node at distance D from either = key node

*/

class Solution {
    public int[] findKeyNodes(int n, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        // Step 2: BFS from node 0 → find one diameter endpoint u
        /** Returns [index, furthest distance] */
        int u = farthestNode(0, n, adj)[0];

        // Step 3: BFS from u → find other endpoint v and diameter length D
        int[] fromU = farthestNode(u, n, adj);
        int v = fromU[0];
        int diameter = fromU[1];

        // Step 4: BFS from both u and v → full distance arrays
        int[] distFromU = bfsDist(u, n, adj); // distance of u : to : all nodes
        int[] distFromV = bfsDist(v, n, adj); // distance of v : to : all nodes

        // Step 5: Any node at distance D from u OR v is an endpoint
        int[] result = new int[n];
        for (int i = 0; i < n; i++)
            if (distFromU[i] == diameter || distFromV[i] == diameter)
                result[i] = 1;

        return result;
    }

    // Returns [farthestNode index, distanceToIt]
    private int[] farthestNode(int src, int n, List<List<Integer>> adj) {
        int[] dist = bfsDist(src, n, adj);

        /** Assume, index:0 is start point. Compare all nodes from 1 to n */
        int farthestIndex = 0;
        for (int i = 1; i < n; i++)
            if (dist[i] > dist[farthestIndex])
                farthestIndex = i;
        return new int[]{farthestIndex, dist[farthestIndex]};
    }

    // Returns distance array from src to every node
    private int[] bfsDist(int src, int n, List<List<Integer>> adj) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[src] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        return dist;
    }
}