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
            // ALL NEIGHBOURS ARE ADDED IN QUEUE, SO THEY ARE EXPLOITED IN BFS ORDER
            for (int neighbor : adjList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }


        }




    }



}


