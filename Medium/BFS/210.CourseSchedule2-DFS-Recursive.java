class Solution {
// find actual order    
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

        // 3. We also detect if there is a cycle present in the graph, *** difference here is we have directed graph 1 -> 2
        Set<Integer> cycle = new HashSet<>();

        // Main DFS logic, we are running DFS from all nodes of the graph, so that no node is missed
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, adjMap, visit, cycle, output)) { // dfs (start_node,    adjMap,visited,cycle,output)
                return new int[]{}; // return proper output if there is a cycle
            }
        }

        int[] result = new int[numCourses]; // convert it to array[] from List<> as expected output type is array[]
        for (int i = 0; i < numCourses; i++) {
            result[i] = output.get(i);
        }
        return result;
    }


// CODE SEGMENT A: (Refer B below)

    // DFS method here detects if there is cycle present or not
    private boolean dfs(int course, Map<Integer, List<Integer>> adjMap,
                        Set<Integer> visit, Set<Integer> cycle, List<Integer> output) {
        if (cycle.contains(course)) {
            // return true; cycle exists ; below we return false for some business 
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
                return false; // do not use flag logic everywhere, try to return false/true directly
            }
        }
        cycle.remove(course); // Gives backtrack feel, adding and removing

        visit.add(course);
        output.add(course); // The only extra line we have missing in  CourseSchedule - I
        return true;
    }
}

// Time: O(V+E) ; Space: O(V+E)

// CODE SEGMENT B:
// Cycle detection logic core is same, if cycle exists - yes return true
// We handle the other business logic from this output
// We reverse the path obtained from DFS.

public int[] findOrder(int numCourses, int[][] prerequisites) {
        // dfs, recursion

        // make a directed graph
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int edge[]: prerequisites){
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        Set<Integer> cycle = new HashSet<>();
        Set<Integer> visitedSet = new HashSet<>();
        List<Integer> path = new ArrayList<>();

        for(int i=0; i< numCourses; i++){
            if(doesCycleExists(i,graph,cycle,visitedSet,path))
                return new int[]{}; // cycle exists, return nothing

        }

        // Path returned from DFS is reverse. Hence, we have to reverse it again.
        Collections.reverse(path); // #$%^&*(*&^%$#$%^&*(*&^%$#$%^&*(O*^%$#$%^&*())))
        return path.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

boolean doesCycleExists(int course, Map<Integer,List<Integer>> graph, Set<Integer> cycle, Set<Integer> visitedSet, List<Integer> path){

        if(cycle.contains(course))
            return true; // has cycle  
        
        if(visitedSet.contains(course))
            return false; // already processed

        cycle.add(course);
        for(int neigh: graph.getOrDefault(course, new ArrayList<>())){
            if(doesCycleExists(neigh,graph,cycle,visitedSet,path))
                return true;
        }

        cycle.remove(course);
        visitedSet.add(course);
        path.add(course);
        
        return false;
    }


//Difference in code A vs code B
/**
At first glance - yes both A and B look opposite of each other - A returning true and B returning false
Since the meaning to be interpreted here is different

Both codes do POSTORDER DFS.
path.add(course);   // after exploring neighbors

That means:
	•	dependencies are added before
	•	dependents are added after

Because of this line: graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
This is the correct direction for topo, but postorder traversal produces reverse topo    

// This template refers to another similar template of BACKTRACKING

parentSet.add(course);
    for(int neigh: graph.getOrDefault(course, new ArrayList<>())){
        if(doesCycleExists(neigh,graph,parentSet,visitedSet,path))
            return true;
    }
parentSet.remove(course);

What is even difference between Post order DFS and Backtracking?



*/