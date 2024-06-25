class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] prerequisites1 = {{1, 0}, {0, 1}};
        int[][] prerequisites2 = {{1, 0}, {2, 1}, {3, 2}};

        System.out.println(sol.canFinish(2, prerequisites1)); // Output: false
        System.out.println(sol.canFinish(4, prerequisites2)); // Output: true
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            addEdge(adj, prerequisite[1], prerequisite[0]); // directed adjMap , so only 1 edge
        }

        return !isCyclic(adj, numCourses);
    }

    // Function to add an edge to the directed adjMap
    private static void addEdge(Map<Integer, List<Integer>> adjMap, int from, int to) {
        adjMap.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        // adjMap.computeIfAbsent(to, k -> new ArrayList<>()).add(from); // add this if undirected adjMap
    }

    // 1. adjmap, visited, Stack() needed. currentPath set is needed too
    // Function to detect cycle in a directed adjMap using iterative DFS
    private static boolean isCyclic(Map<Integer, List<Integer>> adjMap, int numCourses) {
        // 1. adjmap, visited, stack needed
        Set<Integer> visited = new HashSet<>();
        Set<Integer> currentPath = new HashSet<>();

    // running dfs for all vertices
        for (int vertex = 0; vertex < numCourses; vertex++) {
            if (!visited.contains(vertex)) { // if a vertex is new, not processed, proceeeeeed. check if cycle is detected for it
                if (isCyclicUtil(adjMap, vertex, visited, currentPath)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCyclicUtil(Map<Integer, List<Integer>> adjMap, int start, Set<Integer> visited, Set<Integer> currentPath) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start); // visit first node, ****.1.**** but dont add it to visited & currentPath.

        while (!stack.isEmpty()) {
            int node = stack.peek(); // &&&&&&&, peek(), not pop() get the stack top

            //****.2.****
            if (visited.contains(node)) { // node is completely processed
                // Do not consider the node anymore
                stack.pop();
                currentPath.remove(node);
                continue;
            }
            visited.add(node); // now we will completely process this node
            currentPath.add(node);
            //****.2.****

            for (int neighbor : adjMap.getOrDefault(node, new ArrayList<>())) {
                // if neighbour is also not completely processed,
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor); // push it in our stack
                } 
                else if (currentPath.contains(neighbor)) {
                    return true; // return true when neigh exists, so cycle detected
                }
            }
        }
        return false;
    }

   
}

/*
visited: 
This set tracks all the nodes that have been completely processed. Once a node is fully explored and all its descendants 
are processed, it is added to the visited set. Nodes in this set are not revisited or reconsidered during further DFS traversals.

currentPath:
This set keeps track of the nodes that are currently on the recursion stack/path of the DFS. It helps in detecting back edges,
which indicate cycles. When a node is added to the stack (or recursion call), it is added to currentPath. If we encounter a node that
is already in currentPath, it means we have a back edge, indicating a cycle.

visited = {}, currentPath = {}.
We start DFS from 0, so currentPath becomes {0}.
From 0, we go to 1, now currentPath = {0, 1}.
From 1, we go to 2, now currentPath = {0, 1, 2}.
From 2, we go back to 0, which is already in currentPath.
Since 0 is in currentPath, a cycle is detected.



*/