/**

Redundant Edge detection using Union Find and 
Cycle detection using DFS recursive have similar purpose

If cycle exists, we can never finish the courses;
In order to detect cycle, run DFS from all nodes

*/


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // MAIN IDEA::::: Check if cycle exists? If yes, we cannot finish the given courses

        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        for(int[] pre: prerequisites){
            adjMap.computeIfAbsent(pre[1], k-> new ArrayList<>()).add(pre[0]); // directed
        }

        // Whenever we have cycle detection, we have one more HashSet for cycle
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();


        for(int i=0; i<numCourses; i++){
            // for all courses, DFS is good for cycle detection, we run DFS from all nodes
            if(!dfs(i,adjMap,visited,cycle)) // i = source, from 0 to n-1
                return false;
        }

        return true;

    }

    public boolean dfs(int source, Map<Integer,List<Integer>> adjMap, Set<Integer> visited, Set<Integer> cycle ){

        // cycle, so we cannot do anything; ideally return true for cycle detection
        if(cycle.contains(source))
            return false; // False => We cannot complete anything

        if(visited.contains(source))
            return true;

        // Looks like backtracking format of calls
        // Add; recursive call; Remove
        // make a dfs cakk with every nodes
        cycle.add(source);
        for(Integer nodes: adjMap.getOrDefault(source, Collections.emptyList())){
            if(!dfs(nodes,adjMap,visited,cycle))
                return false; // why return false? - contains cycle, so we cannot do anything
        }
        cycle.remove(source); // verfied that this source is not forming a cycle, so removed it from Cycle()

        visited.add(source);
        return true;
    }


}

// Time: O(V+E) ; Space: O(V+E)
// // O(n+m) for both; n = no of courses, m = no of prerequisites

// NOW FLIP THE LOGIC A BIT

// What is easier for me to understand -
// dfs must return the decision whether a cycle exists or not
// other method will have the business logic 


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build the adjacency list
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int[] pre : prerequisites) {
            adjMap.computeIfAbsent(pre[1], k -> new ArrayList<>()).add(pre[0]); // Directed edge: pre[1] → pre[0]
        }

        Set<Integer> visited = new HashSet<>(); // fully explored nodes
        Set<Integer> cycle = new HashSet<>();   // recursion stack (to detect cycle)

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, adjMap, visited, cycle)) {
                // dfs returns true => cycle detected
                return false;
            }
        }

        return true; // no cycle detected in any component
    }

    public boolean dfs(int node, Map<Integer, List<Integer>> adjMap, Set<Integer> visited, Set<Integer> cycle) {
        if (cycle.contains(node)) {
            return true; // cycle found
        }

        if (visited.contains(node)) {
            return false; // already explored, do nothing
        }

        cycle.add(node); // mark as part of recursion stack, we assume this one would be the node causing cycle

        for (int neighbor : adjMap.getOrDefault(node, Collections.emptyList())) {
            if (dfs(neighbor, adjMap, visited, cycle)) {
                return true; // if any path returns true, cycle exists
            }
        }

        cycle.remove(node);    // done exploring this path
        visited.add(node);     // mark as completely explored, no need to remove anything from visited. visited does not go through BTracking

        return false; // no cycle found from this node
    }
}
