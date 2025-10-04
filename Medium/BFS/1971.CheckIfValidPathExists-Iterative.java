/**
bi-directional
convert matrix to adjList
bfs
queue
visited
 */
// Time: O(V+E); Space: O(V+E)
// You loop once over all edges → O(E). => When building the AdjList
// Each vertex is enqueued at most once → O(V). => When doing BFS
// Building adjacency list O(E) + BFS traversal O(V + E)
// → O(V + E)

/*
Space complexity:
Adjacency list: O(V + E)
Visited set: O(V)
Queue: O(V)
→ O(V + E) overall
*/

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if(source==destination)
            return true;

        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        // We are not using two for-loops to traverse the matrix here
        // This smartly avoids the O(n2) complexity
        for(int arr[]: edges){
            adjMap.computeIfAbsent(arr[0],k -> new ArrayList<>()).add(arr[1]);
            adjMap.computeIfAbsent(arr[1],k -> new ArrayList<>()).add(arr[0]);
        }


        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(source);
        visited.add(source);

        while(!queue.isEmpty()){
            Integer curr = queue.poll();

// for(Integer neighbour: adjMap.getOrDefault(curr, Collections.emptyList())){
            for(Integer neighbour: adjMap.getOrDefault(curr,new ArrayList<>())){

                if(neighbour == destination)
                    return true;

                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.offer(neighbour);
                }

            }


        }

        return false;
    }
}

