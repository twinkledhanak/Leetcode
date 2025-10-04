//In a directed acyclic graph, we can use Kahn's algorithm to get the topological ordering.
// The advantage of using Kahn's algorithm is that it also aids in the detection of graph cycles.

// Input -> DAG
// Output -> True or False, if all courses can be taken or not
// Idea is to process everything with least dependency first

class Solution {


    // 1. adjMap, visited, Queue (BFS)
    // 1. adjMap,        , Queue, inDegree (Kahn)

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjMap = new ArrayList<>(numCourses);

        // 1. AdjMap and inDegree populated
        for (int i = 0; i < numCourses; i++) {
            adjMap.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjMap.get(prerequisite[1]).add(prerequisite[0]); // {0,1} : 0 <- 1
            inDegree[prerequisite[0]]++; // in-degree of 0 increases
        }




        Queue<Integer> queue = new LinkedList<>();
        // Push all the nodes with inDegree zero in the queue. // BFS, just offer start vertex. Here, offer vertices with in-deg 0
        // ****** It is possible that we may have multiple nodes with 0 in-degree in graph. So better to use Queue to store it
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i); // we need at least one node whose indegree is zero, to start with
            }
        }

        int nodesVisited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodesVisited++; // or   topologicalOrder[i++] = node;

            for (int neighbor : adjMap.get(node)) {
                // Delete the edge "node -> neighbor".
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) { // If the degree becomes 0, it will be the next node to be processed
                    queue.offer(neighbor);
                }
            }
        }

        return nodesVisited == numCourses;
    }
}


// Time: O(V+E) ; Space: O(V+E)
// O(n+m) for both; n = no of courses, m = no of prerequisites