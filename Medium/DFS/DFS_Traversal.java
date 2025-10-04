class Graph {
    int V;
    int[][] adjList; // Matrix

    Graph(int V){
        this.V = V;
        this.adjList = new int[V][V];
    }

    public void addEdge(int u, int v){
        // We add it only 1 way for directed graphs
        adjlist[u][v] = 1; // we can add weight too!
        // adjList[v][u] = 1; // If GRAPH IS NOT DIRECTED AND WE NEED BOTH
    }

    public void DFS(int startVertex){
        boolean[] visited = new boolean[V]; // By default set to false
        Stack<Integer> stack = new Stack<>(); // or Deque<Integer> stack = new ArrayDeque<>();

        visited[startVertex] = true;
        stack.push(startVertex);

        while(!stack.isEmpty()){
            int currentVertex = stack.peek();
            stack.pop();

            // Just referencing the matrix as adjList[vertex] which gives back an array
            // ALL NEIGHBOURS ARE ADDED IN STACK, SO THEY ARE EXPLOITED IN DFS ORDER
            for (int neighbor : adjList[currentVertex]) { // for(int neighbour: adjList.getOrDefault(currentVertex,Collections.emptyList()))
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }


        }




    }



}

// Time complexity:
// O(v+e) with adjList
// O(v^2) with matrix

// ANother problem that had come from No of islands:
|                                                | **DFS Recursive**                      | **DFS Iterative**                                                    | **BFS Recursive**                                  | **BFS Iterative**                                         |
| ---------------------------------------------- | -------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------- | --------------------------------------------------------- |
| **When to mark visited?**                      | ✅ Before recursive call                | ✅ After popping from stack                                           | ⚠️ Rarely used                                     | ✅ When enqueuing                                          |
| **Why?**                                       | To avoid cycles and infinite recursion | Because stack might hold same cell multiple times if not yet visited | BFS recursion is rare (usually not used for grids) | To avoid adding the same cell multiple times to the queue |


//Alternative DFS Traversal:

ArrayList<Integer>[] graph = new ArrayList[MAX_EDGE_VAL + 1];
for (int i = 0; i <= MAX_EDGE_VAL; i++) {
    graph[i] = new ArrayList();
}

for (int[] edge: edges) {
    // visited.clear(); // DO NOT MISS THIS :)
    // if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() && dfs(graph, edge[0], edge[1])) { // {2,3}
    //     return edge; // cycle prevention
    // }
    graph[edge[0]].add(edge[1]); // when no cycle formed by the edges, only then add them to the graph
    graph[edge[1]].add(edge[0]);
}
