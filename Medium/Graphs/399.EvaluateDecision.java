/**

a/b = 2.0.  => a -> b weight is a/b. Two way connected. b -> a = 1/weight
b/c = 3.0   => b -> c
No self connections are present in the graph,
rather => if start and end is same -> return 1

answer for: a/c ?
Is there a path from a to c? Can I reach c from a?
is c connected to a?

Input can be represented as graph.
For every query -> If variable is not a part of given graph => return -1 (early)
It is a undirected graph, with weights.
Every direction has a different type of weight.

Map<String, List<Pair>> => class Pair is String, Double
a -> {(b, 0.5)}
b -> {(a, 2.0), (c, 3.0)}
c -> {(b, 1/3.0)}

Run a DFS from given vertex in graph and explore the graph.
Main challenge? Maintain a running product as we explore the path from source to end
*/


class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Pair>> adjMap = new HashMap<>();
        double[] result = new double[queries.size()];
        

        int i=0, j=0;

       // 1. Create the graph from give equations
       for(List<String> list: equations){
            adjMap.computeIfAbsent(list.get(0), k -> new ArrayList<>()).add(new Pair(list.get(1),values[i]));
            adjMap.computeIfAbsent(list.get(1), k -> new ArrayList<>()).add(new Pair(list.get(0),1/values[i]));
            i++;
       }     

       for(List<String> query: queries){
        // Moved it here, as we need to treat every query separately
            Deque<Pair> stack = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();

            String left = query.get(0);
            String right = query.get(1);

            // base cases
            if(!adjMap.containsKey(left) || !adjMap.containsKey(right)){
                result[j++] = -1.0;
                continue;
            }

            if(left.equals(right)){
                result[j++] = 1.0;
                continue;
            }
                

            // Do DFS for current
            stack.push(new Pair(left, 1.0));
            double answer = -1.0;

            while(!stack.isEmpty()){
                Pair node = stack.pop();

                // Base case, when we find the 'right' vertex - exploring from 'left'
                if(node.vertex.equals(right)){
                    answer = node.weight; // this has value from accumulated product
                    break;
                }

                visited.add(node.vertex);

                for (Pair nei : adjMap.getOrDefault(node.vertex, new ArrayList<>())) {
                    if (!visited.contains(nei.vertex))
                        // ******* accumulating the product of current node with nei *******
                        stack.push(new Pair(nei.vertex, node.weight * nei.weight));
                }
            }
            result[j++] = answer;
       }

        return result;
    }
}

class Pair{
    String vertex;
    double weight;

    public Pair(String vertex, double weight){
        this.vertex = vertex;
        this.weight = weight;
    }
}