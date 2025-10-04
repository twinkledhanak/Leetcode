/*
Equivalent definitions of a bipartite graph:

There is no cycle of odd length

we can split the nodes of the graph
(vertex set of the graph) into 2 subsets so
that there is all the edges go from 1 subset
to the other subset.

3.The graph should be bi-colourable.
4. Connected nodes cannot have same colour

*/
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        // colour size depends on graph
        int[] color = new int[n];
        Arrays.fill(color, -1); // At any time, we will have 3 coloured nodes - 0 , 1 and -1 (null or no colour)

        // One by one, start pushing all nodes into Stack
        for (int start = 0; start < n; ++start) {
            if (color[start] == -1) {
                Stack<Integer> stack = new Stack();
                stack.push(start);
                color[start] = 0;

                while (!stack.empty()) {
                    Integer node = stack.pop();
                    for (int nei: graph[node]) {
                        if (color[nei] == -1) {
                            stack.push(nei);

                            color[nei] = color[node] ^ 1;
// This is a clever trick:

// color[node] = 0 → color[nei] = 1

// color[node] = 1 → color[nei] = 0

// Its equivalent to saying: assign the opposite color
                            color[nei] = color[node] ^ 1; /// @#$%^*()(*&^%$#@!@#$%^&*())
                        } 
                        // The adjacent node has ended up with the same colour, so return false
                        else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}