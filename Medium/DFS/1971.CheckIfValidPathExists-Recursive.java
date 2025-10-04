// Time: O(m+n)
// Space: O(m+n) ; recursion takes O(n) space but it is not maximum
// n: no of nodes; m: no of edges

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] seen = new boolean[n];

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }
        
        return dfs(graph, seen, source, destination);
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int currNode, int destination) {
        if (currNode == destination) {
            return true;
        }
        if (!seen[currNode]) {
            seen[currNode] = true;
            for (int nextNode : graph.get(currNode)) {
                if (dfs(graph, seen, nextNode, destination)) {
                    return true; // same as boundary condition. Think of next node, if it is dest, it will return true.
                    // So, this one must also return truw
                }
            }
        }
        return false;
    }
}

// to check iff there exists a valid path 

// i,j,R,C
dfs(){
    if(!visited)
        visited.add(curr)

    if(i > R || j > C || loc[i][j]==0)
        // invalid    

    for(int neigh: graph.get(curr)){
        // but, in our case, we do not have any adjList
    }    
    // we have to explore in all 4 directions for it
    for(dr,dc in directions)
        dfs(i+dr,j+dc,R,L)
}