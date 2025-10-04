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
// +ab
/**

HERE, WE REVERSE 'ALL THE CHILDREN' BEFORE ADDING.
WHY REVERSE? WE HAVE A STACK

 */



class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if(root == null)
            return output;

        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pollLast();
            output.add(node.val);

            // MOST IMP **********
            // In trees, we did reverse for Postorder
            Collections.reverse(node.children); // we reverse at intermediate level only, we cannot control the left and right order
            // just like we did in stacks; For binary tree, we just have two nodes - we dont have a list to reverse
            
            // Instead of left and right, we just add all nodes in the list
            // We have to add them in given order
            for(Node child: node.children){
                stack.add(child); 
            }
            
        }    


        return output;
    }
}


Time complexity: we visit each node exactly once, and for each visit, the complexity of the operation (i.e. appending the child
 nodes) is proportional to the number of child nodes n (n-ary tree). Therefore the overall time complexity is O(N)
 , where N is the number of nodes, i.e. the size of the tree.

Space complexity: depending on the tree structure, we could keep up to the entire tree, therefore, the space complexity is
 O(N).