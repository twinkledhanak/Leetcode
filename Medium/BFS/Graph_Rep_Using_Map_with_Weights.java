class Solution {
    public int minAreaRect(int[][] edges1) {
        int n = 6;
        int[][] edges = {
            {0, 3, 2}, // Edge from 0 to 3 with weight 2
            {1, 2, 4}, // Edge from 1 to 2 with weight 4
            {1, 5, 1}, // Edge from 1 to 5 with weight 1
            {2, 4, 7}, // Edge from 2 to 4 with weight 7
            {3, 5, 3}, // Edge from 3 to 5 with weight 3
            {5, 4, 5}, // Edge from 5 to 4 with weight 5
            {5, 0, 6}  // Edge from 5 to 0 with weight 6
        };

        // Use a map to represent the graph with weights
        Map<Integer, List<Pair>> graph = new HashMap<>();

        // Build the graph
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int weight = edges[i][2];

            // Add edge from a to b with weight
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new Pair(b, weight));
            // Add edge from b to a with weight (if the graph is undirected)
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new Pair(a, weight));
        }

        // Print the graph
        for (Map.Entry<Integer, List<Pair>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + "---->");
            for (Pair pair : entry.getValue()) {
                System.out.print("(" + pair.vertex + ", " + pair.weight + ") ");
            }
            System.out.println();
        }
        return 1;
    }

    // Helper class to store a vertex and its associated weight
    static class Pair {
        int vertex;
        int weight;

        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    
}