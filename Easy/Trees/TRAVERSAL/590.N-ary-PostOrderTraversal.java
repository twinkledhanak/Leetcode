/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/**

HERE, WE REVERSE THE OUTPUT

 */


class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if(root == null)
            return output;

        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pollLast();
            output.add(node.val);

            
            // Instead of left and right, we just add all nodes in the list
            // We have to add them in given order
            for(Node child: node.children){
                stack.add(child); 
            }
            
        }    

        // Refer below to understand what is the need to reverse?
        Collections.reverse(output); // we reverse at last
        return output;
    }
}

/**
    1
2   3   4    
output = [1, 4, 3, 2]
But expected postorder = [2, 3, 4, 1] => If we do not reverse

*/


Time complexity: we visit each node exactly once, and for each visit, the complexity of the operation (i.e. appending the child
 nodes) is proportional to the number of child nodes n (n-ary tree). Therefore the overall time complexity is O(N)
 , where N is the number of nodes, i.e. the size of the tree.

Space complexity: depending on the tree structure, we could keep up to the entire tree, therefore, the space complexity is
 O(N).