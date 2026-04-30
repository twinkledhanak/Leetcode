class Solution {
    public boolean validTree(int n, int[][] edges) {
        // If cycle exists - return false - not a tree

        // convert given edges to graph
        // while doing so - check if cycle exists
        // CHECK 1: No of edges must be exactly n-1
        if (edges.length != n - 1)
            return false;

        Map<Integer,List<Integer>> graph = new HashMap<>();
        Set<Integer> visitedSet = new HashSet<>();

        for(int edge[]: edges){
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        // CHECK 2: DFS only from the start node
        // NOTE how instead of parentSet, we just use a single parent variable
        if(doesCycleExists(0,-1,graph,visitedSet))
            return false; // not a valid tree, it is graph with cycles
        
        // CHECK 3: all of the nodes must be reachable, which makes visitedSize = n
        // To avoid any un-connected components
        return visitedSet.size() == n;
    }

    public boolean doesCycleExists(int node, int parent, Map<Integer,List<Integer>> graph,
        Set<Integer> visitedSet){

        visitedSet.add(node);       

        for(int neigh: graph.getOrDefault(node, new ArrayList<>())){
            if (!visitedSet.contains(neigh)) {
                if (doesCycleExists(neigh, node, graph, visitedSet))
                    return true;
            } else if (neigh != parent) {
                return true;
            }
        }
        
        return false;
    }

}

// set cycle, set visited, int node, graph
// int parent  , set visited, int node, graph