// Main goal: Traverse the graph and remove the edge that causes cycle formation.
// We do DFS from every vertex and when we encounter a cycle, remove the edge that was forming one
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] output = new int[2];
        
        // We are given a matrix, but we create a map
        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        for(int[] edge: edges){
            adjMap.computeIfAbsent(edge[0], k -> new ArrayList()).add(edge[1]);
        }

        // Visited notes
        Set<Integer> visited = new HashSet<>();

        Stack<Integer> stack = new Stack<>();

        for(int node=1 ; node<=edges.length; node++){
            // Run DFS for every node
            stack.push(node);
            visited.add(node);


            while(!stack.isEmpty()){
                int currentNode = stack.peek();
                stack.pop();

                for(int n: adjMap.getOrDefault(currentNode, Collections.emptyList())){
                    if(!visited.contains(n)){
                            visited.add(n);
                            stack.push(n);
                    }
                    else{
                            // we encounetered the node again which was visited
                            System.out.println("Cycle detected: "+currentNode+" -> "+n);
                            output[0] = currentNode;
                            output[1] = n;  
                            break;
                    } 

                }

            }


        }

        return output;
        
    }
}
