class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> output = new ArrayList<>();

        // 1. Creating adjMatrix for DFS ; we use Map implementation for more efficiency
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int[] pair : prerequisites) {
            adjMap.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]); // List only stores ones for related nodes
            // 0 -> {1,2} . 0 is connected to 1 and 2
        }
        // The computeIfAbsent(Key, Function) method of HashMap class is used to compute the value for a given key using the given 
        // mapping function
        // If remapping function returns null for a key, then no mapping is recorded for that key. This MAY CAUSE AN ISSUE
        // IF WE HAVE NO CHILDREN FOR A NODE, THAT NODE WILL NOT BE PRESENT IN THIS MAP
        // AS A SOLUTION, WHEN WE ARE RETRIEVING THE NODES LATER IN DFS, USE METHOD getOrDefault() THAT WILL RETURN EMPTY LIST
        // FOR NODES NOT HAVING ANY CHILD NODES & THEREFORE ARE NOT PRESENT IN OUR ADJMAP 


        // 2. Visited is a set intead of plain list/array/map
        Set<Integer> visit = new HashSet<>();

        // 3. We also detect if there is a cycle present in the graph
        Set<Integer> cycle = new HashSet<>();

        // Main DFS logic, we are running DFS from all nodes of the graph, so that no node is missed
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, adjMap, visit, cycle, output)) { // dfs (start_node,    adjMap,visited,cycle,output)
                return new int[0]; // return proper output if there is a cycle
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = output.get(i);
        }
        return result;
    }



    // DFS method here detects if there is cycle present or not
    private boolean dfs(int course, Map<Integer, List<Integer>> adjMap,
                        Set<Integer> visit, Set<Integer> cycle, List<Integer> output) {
        if (cycle.contains(course)) {
            return false; // Start node is already present in the set, we've circled/cycled back, so no further action 
        }

        // if a node is already visited/processed, do nothing
        // We only add nodes to visited & output once their neighbours are explored
        if (visit.contains(course)) {
            return true;
        }

        // This may be the first time we're encountering the node, so keeping track in case if we encounter it again in a cycle
        cycle.add(course);
        for (int pre : adjMap.getOrDefault(course, Collections.emptyList())) { // getOrDefault(key, default value if nothing present)
            
            // get the neighbours of a given node/course, but we are not using stack here, we use recursion, so that internally
            // uses stack
            if (!dfs(pre, adjMap, visit, cycle, output)) {
                return false; // do not use flag lofic everywhere, try to return false/true directly
            }
        }
        cycle.remove(course);
        visit.add(course);
        output.add(course);
        return true;
    }
}
,