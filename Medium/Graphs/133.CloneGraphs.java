/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

Time: O(m+n)
Space: O(n)

*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // Hash map to save the visited node and it's respective clone
        // as key and value respectively. This helps to avoid cycles.
        Map<Node, Node> visited = new HashMap();

        // Put the first node in the queue
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);
        // Clone the node and put it in the visited dictionary.
        visited.put(node, new Node(node.val, new ArrayList())); // Instead of original node, we put a clone using Node.val

        // Start BFS traversal
        while (!queue.isEmpty()) {
            // Pop a node say "n" from the from the front of the queue.
            Node twinkle = queue.remove();
            // Iterate through all the neighbors of the node "n"
            for (Node curr : twinkle.neighbors) {
                if (!visited.containsKey(curr)) {
                    // Clone the neighbor and put in the visited, if not present already
                    visited.put(curr,new Node(curr.val, new ArrayList())); // put the clone, neighbour.val
                    // Add the newly encountered node to the queue.
                    queue.add(curr);
                }

                // We are adding a lot of new ArrayList<>() everywhere!!
                // Add the clone of the neighbor to the neighbors of the clone node "n".
                // Get Twinkle's neighbours; add current node's neighnour
                visited.get(twinkle).neighbors.add(visited.get(curr));


            }
        }

        // Return the clone of the node from visited.
        return visited.get(node); // the node passed in the function parameter
    }
}