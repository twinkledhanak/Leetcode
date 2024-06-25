import java.util.*;



/// DIfference is in the graph representation
// USES MAP TO REPRESENT GRAPH

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 3}, {1, 2}, {1, 5}, {2, 4}, {3, 5}, {5, 4}, {5, 0}};
        // {0, 3} -> 0 is key, 3 is value

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            graph.get(a).add(b);
        }

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + "---->");
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.print(entry.getValue().get(i) + " ");
            }
            System.out.println();
        }
    }
}

// Output is just a Map
// 
// 0---->3          vertex 0: --connected to-- :vertex 3
// 1---->2 5        vertex 1: --connected to-- :vertex 2 ; vertex 1: --connected to-- :vertex 5
// 2---->4 
// 3---->5 
// 5---->4 0 