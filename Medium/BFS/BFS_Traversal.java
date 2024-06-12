// Higher level intuition: Imagine a tree/graph
// 1. This BFS version is from a single source
// 2. Start with the initial source vertex, loop through each of the nieghbours and keep updating the queue.
// 3. We go to a node, then its neighbours (A,B,C), and once these neighbours are explore, 
// we explore neighbours of first neighbour A again
// Down, L ---> R in a queue

// USES ADJACENCY MATRIX TO REPRESENT GRAPH

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

    public void BFS(int startVertex){
        boolean[] visited = new boolean[V]; // By default set to false
        Queue<Integer> q = new ArrayQueue<>(); // or new LinkedList<>();

        visited[startVertex] = true;
        q.offer(startVertex);

        while(!q.isEmpty()){
            int currentVertex = q.peek();
            q.pop();

            // Just referencing the matrix as adjList[vertex] which gives back an array
            // ALL NEIGHBOURS ARE ADDED IN QUEUE, SO THEY ARE EXPLOITED IN BFS ORDER
            for (int neighbor : adjList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }


        }




    }



}


