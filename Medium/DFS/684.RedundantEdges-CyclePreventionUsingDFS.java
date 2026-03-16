// Main goal: Traverse the graph and remove the edge that causes cycle formation.
// We do DFS from every vertex and when we encounter a cycle, remove the edge that was forming one
// CYcle detection with BFS is very difficult as we have to keep a track of parent nodes
// DFS -> Finding everything connected -> Like group of all 1's or 0's
// => Same concept here


//we process the edges in the order they appear in the input list. 
//This ensures that if multiple redundant edges are present, the last one we process will be the one that forms the cycle.

// | Return Value | Meaning in context of the problem                                                                                     |
// | ------------ | --------------------------------------------------------------------------------------------------------------------- |
// | `true`       | ✅ A path **exists** from `source` to `target`. Adding this edge would create a **cycle**. This edge is **redundant**. |
// | `false`      | ❌ No path exists from `source` to `target`. It's **safe to add** this edge to the graph.                              |


class Solution {
    Set<Integer> visited = new HashSet();
    int MAX_EDGE_VAL = 1000;

    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[MAX_EDGE_VAL + 1];
        for (int i = 0; i <= MAX_EDGE_VAL; i++) {
            graph[i] = new ArrayList();
        }

        for (int[] edge: edges) {
            visited.clear(); // DO NOT MISS THIS :)
            // u, v, dfs(u,v)
            if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() && dfs(graph, edge[0], edge[1])) { // {2,3}
                return edge; // cycle prevention
            }
            // when no cycle formed by the edges, only then add them to the graph
            graph[edge[0]].add(edge[1]); 
            graph[edge[1]].add(edge[0]);
        }
        throw new AssertionError();
    }
    public boolean dfs(ArrayList<Integer>[] graph, int source, int target) {

        // Recursive dfs => adding to visited is done before starting the recursion

        if (!visited.contains(source)) {
            visited.add(source);


            if (source == target) 
                return true; // path is found
            for (int nei: graph[source]) { // We explore all children (connected nodes) of source, if any of them is target
                if (dfs(graph, nei, target)) 
                    return true; // path is found
            }
        }
        return false; // already visited node
    }
}


✅ What BFS can do:

BFS can explore all nodes level by level.

BFS can build a spanning tree (not necessarily minimum) if you use it to avoid revisiting nodes.

But BFS doesn’t naturally detect cycles, and it doesn’t give you control over which edge in the cycle was the one that caused it.

❌ Why this fails for this problem:

No weights ⇒ No MST concept

The problem has no edge weights, so “minimum” is meaningless here.

You're not optimizing for anything.

You don’t need a full tree-building traversal

You're only asked to find the extra edge that causes a cycle.

No need to build a new tree — just identify the one bad edge.

BFS doesnt track back edges easily

To detect a cycle with BFS, you’d need to keep track of parent nodes.

But even then, identifying which edge to remove (especially the one that appears last in the input) is clunky with BFS.



MORE CLEANER VERSION OF THE CODE:
concept:
We make a graph out of inputs 
In this problem, we have to satisfy some conditions even before we make a graph 
we use dfs to ensure a edge can be added or not 

#Where to even consider logic for marking a node for visited
// In simple terms, where to handle the recursion logic? Inside the DFS if it is recursive
dfs(node):
    if node is already visited:
        return

    mark node as visited

    for each neighbor of node:
        dfs(neighbor)



class Solution {
    // Keep track of visited nodes during DFS
    Set<Integer> visited = new HashSet<>();

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Process each edge one by one
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            // Clear visited before each DFS
            visited.clear();

            // Check if u and v are already connected in the current graph
            if (graph.containsKey(u) && graph.containsKey(v) && dfs(graph, u, v)) {
                // If yes, this edge creates a cycle → redundant
                return edge;
            }

            // Otherwise, add edge to graph (bidirectional)
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

    }

    // DFS to check if target is reachable from source
    private boolean dfs(Map<Integer, List<Integer>> graph, int source, int target) {
        if (visited.contains(source)) {
            return false; // Already visited, skip
        }

        visited.add(source); // Mark current node

        if (source == target) {
            return true; // Found a path to target
        }

        // Explore all neighbors
        for (int nei : graph.getOrDefault(source, new ArrayList<>())) {
            if (dfs(graph, nei, target)) {
                return true; // Found target in one of the paths
            }
        }

        return false; // No path found
    }
}

Doing DFS for once: O(V+E)
We are doing DFS for every edge, O(V * (V+E)) = O(V^2) or we consider no of edges = n
Time: O(n^2)
Space: O(n)