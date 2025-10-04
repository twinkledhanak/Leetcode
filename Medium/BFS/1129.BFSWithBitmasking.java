// https://leetcode.com/problems/shortest-path-with-alternating-colors/description/

// LEETCODE OFFICIAL
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        // I had just created a pair class, LC is just working with List
        // Base idea is same, make (node,colour) from given edges
        // Colour is the main property we use instead of the weight
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] redEdge : redEdges) 
            adj.computeIfAbsent(redEdge[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(redEdge[1], 0));
        
        for (int[] blueEdge : blueEdges)
            adj.computeIfAbsent(blueEdge[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(blueEdge[1], 1));
        
        // Creating the final result, we did the same!!
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        // we had made visited Set, they have a matrix of n rows and only 2 columns
        boolean[][] visit = new boolean[n][2]; 
        Queue<int[]> q = new LinkedList<>();

        // Start with node 0, with number of steps as 0 and undefined color -1.
        // In Q, they mention answer node has values starting from 0
        // So, it is a cryptic way of saying that 0 is the start source
        // We calculate all other distances from Node 0
        // answer[0] will always be 0

        /**
        My understanding of the problem:
        We use 0 as source and remaining all nodes as dest, we do BFS of finding path from source to destination.
        We will use the iterative queue implementation instead of recursive
        Similar to one of the earlier problems, but what is the difference here?
        We have to select the alternate path (different colour path) everytime.
        That's the challenge.
        */

        // Start with node 0, with number of steps as 0 and undefined color -1.
        q.offer(new int[] { 0, 0, -1 }); // Node, steps colour
        answer[0] = 0;
        // A node can be visited from red or blue edge, we keep track of which edge was used to reach
        visit[0][1] = visit[0][0] = true; 
        // Node 0 is visited already, from both red and blue edges :)

        while (!q.isEmpty()) {
            int[] element = q.poll();
            int node = element[0], steps = element[1], prevColor = element[2];

            if (!adj.containsKey(node)) {
                continue;
            }

            for (List<Integer> nei : adj.get(node)) { // Retrieve the list of Pairs we made (Node,Colour)
                int neighbor = nei.get(0);
                int color = nei.get(1);

                //standard - Keep count of steps at every node
                // If not visited and not the same as prev colour, proceed
                if (!visit[neighbor][color] && color != prevColor) { 
                    if (answer[neighbor] == -1)
                        answer[neighbor] = 1 + steps; /// ********** NOT answer[]+=1;

                    visit[neighbor][color] = true;
                    q.offer(new int[] { neighbor, 1 + steps, color });
                }
            }
        }
        return answer;
    }
}

/*
-Time: O(V+E)
-Space: O(V+E)
*/



// Partial solution, at least the structure is correct

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // Assume: Source is 0 for all answer array
        int[] answer = new int[n];
        Arrays.fill(answer,-1);
        Set<Integer> visited = new HashSet<>();

        // Create a map
        Map<Integer,List<Node>> adjMap = new HashMap<>();
        for(int[] edge: redEdges)
            adjMap.computeIfAbsent(edge[0], k->new ArrayList<>()).add(new Node(edge[1],"R"));
        for(int[] edge: blueEdges)
            adjMap.computeIfAbsent(edge[0], k->new ArrayList<>()).add(new Node(edge[1],"B"));
        

        // We need BFS for all nodes, start node is 0
        for(int i=0; i<n; i++){
            checkPath(0,i,adjMap,visited,answer); // TODO - Decide on return type
        }

    }


    public void checkPath(int source, int dest, Map<Integer,List<Node>> adjMap, Set<Integer> visited,
        int[] answer){
            // checking if path exists from Source to Destination, BFS, uses Queues
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(source);

            while(!queue.isEmpty()){
                
            }


        }


    public class Node{
        int val;
        String colour;

        public Node(int val, String colour){
            this.val = val;
            this.colour = colour;
        }
    }
}