// https://leetcode.com/problems/minimum-area-rectangle/solutions/2888872/c-solution-using-dfs/


class Solution {
    public int minAreaRect(int[][] points) {

        int n = points.length();
        int[][] graph = new int[n][n];

        // 1. Find all edges parallel to X-axis
        // 2. Find all edges parallel to Y-axis
        // 3. create a graph using this edges
        for(int i=0; i+1<points.length(); i++){
            double result = calculateSlope(points[i][0],points[i][1],points[i+1][0],points[i+1][1]); // x1,y1,x2,y2
            if(result == 0.0){
                // parallel to x-axis, add an edge in graph
                graph[i][i+1] = Maths.abs(points[i+1][0],points[i][0]);
                graph[i+1][i] = Maths.abs(points[i+1][0],points[i][0]);
            }

            if(result == Nan) // undef
                // parallel to y-axis    
                graph[i][i+1] = Maths.abs(points[i+1][1],points[i][1]);
                graph[i+1][i] = Maths.abs(points[i+1][1],points[i][1]);
        }


        // 4. Run DFS from every edge
        // 5. Get a cycle and calculate min area
        // 6. Return min area

        for(int i=0; i<graph.length(); i++){
            HashSet<Integer> visited = new HashSet<>();
            Stack<Integer> stack = new Stack<>();

            visited.add(i);
            stack.push(i);

            while(!stack.isEmpty()){
                int currentVertex = stack.peek();
                stack.pop();

                for(int neigh: graph[currentVertex]){
                    if(!visited.contains(neigh)){
                        visited.add(neigh);
                    }
                    else{
                        // cycle detected
                        
                    }
                }
            }


        }



        
    }


    public double calculateSlope(int x1, int y1, int x2, int y2){
        return Math.atan((y2-y1)/(x2-x1));
    }

}


