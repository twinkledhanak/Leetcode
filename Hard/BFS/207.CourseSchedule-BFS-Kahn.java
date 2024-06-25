//In a directed acyclic graph, we can use Kahn's algorithm to get the topological ordering.

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
            adjMap.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }




        Queue<Integer> queue = new LinkedList<>();
        // Push all the nodes with inDegree zero in the queue. // BFS, just offer start vertex. Here, offer vertices with in-deg 0
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int nodesVisited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodesVisited++;

            for (int neighbor : adjMap.get(node)) {
                // Delete the edge "node -> neighbor".
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return nodesVisited == numCourses;
    }
}