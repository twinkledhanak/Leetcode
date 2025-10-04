//https://stackoverflow.com/questions/9255620/why-does-dijkstras-algorithm-use-decrease-key

// Refer to Algo excel sheet for complexities

import java.util.*;

class Graph {
    private int V;
    private List<List<iPair>> adj;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int w) {
        adj.get(u).add(new iPair(v, w));
        adj.get(v).add(new iPair(u, w));
    }

    void shortestPath(int src) {
        // Min Heap
        PriorityQueue<iPair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.weight));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE); // initialized with infinity

        pq.add(new iPair(0, src));
        dist[src] = 0;

        /**
        // a,b,weight => Pair (b,weight)
        1 — u — A — v — B
        When at node A, we perform relaxation.
        If (dist until A + cost(A,B) < dist (1,B) ).     
        If (dist till A frm 1 + v < dist till B from 1)
        Update value of v = dist until U + cost(A,B)
         */

        while (!pq.isEmpty()) {
            iPair u = pq.poll();

            for (iPair v : adj.get(u)) { // Same as example of graph with weights, we created a Pair class
                if (dist[v.node] > dist[u.node] + v.weight) { // v.node is vertex ; v.weight = edge weight of v
                    dist[v.node] = dist[u.node] + v.weight; ?
                    pq.add(new iPair(dist[v.node], v.node)); // instead of decrease-key, insert a new node in PQ
                }
            }
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    static class iPair {
        int node, weight;

        iPair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int V = 9;
        Graph g = new Graph(V);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        g.shortestPath(0);
    }
}

// Time Complexity:
/*
O(V^2)	Using Prims implementation
O(E * log V) 	If the input graph is represented using adjacency list, it can be reduced with the help of a binary heap.
O(E * log V) 	Same as above but priority queue instead of heap, that priority_queue doesn’t support the decrease key.
To resolve this problem, do not update a key, but insert one more copy of it. So we allow multiple instances of the same vertex 
in the priority queue. This approach doesn’t require decreasing key operations
*/