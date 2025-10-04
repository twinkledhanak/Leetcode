
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2

        if (source == destination) // stupid test case
            return true;

        // 1. Create an adjacency map/list
        Map<Integer,List<Integer>> adjMap = new HashMap<>();

        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];

            // bi-directional
            adjMap.computeIfAbsent(a, k -> new ArrayList<>());
            adjMap.get(a).add(b);

            adjMap.computeIfAbsent(b, k -> new ArrayList<>());
            adjMap.get(b).add(a);

        }

        // 2. Visited
        Set<Integer> visited = new HashSet<>();

        // 3. BFS, Queues
        //Queue<Integer> queue = new ArrayQueue<>();
        Queue<Integer> queue = new LinkedList<>(); // -> cause of slow runtime, LL is slow


        // Start BFS traversal
        queue.add(source);
        visited.add(source);

        while(!queue.isEmpty()){
            Integer curr = queue.poll();
            
            for(Integer node: adjMap.getOrDefault(curr,new ArrayList<>())){

                if(node == destination)
                    return true;

                if(!visited.contains(node)){
                    visited.add(node);
                    queue.add(node);
                }
            }


        }

        return false;


    }
}
