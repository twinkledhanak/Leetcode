/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) {
      return output;
    }

    // Just like DFS, add first one to stack
    stack.add(root);


    while (!stack.isEmpty()) {
// get the last, instead of using stack.peek()
      TreeNode node = stack.pollLast();


      // Left, right, node   -> +ab  

      if (node.left != null) {
        stack.add(node.left);
      } 

      // SInce it is stack, reverse the order of pushing
      // +ab , push right first
      if (node.right != null) {
        stack.add(node.right);
      }
      
     
      
      output.add(node.val); // +

    }
    /// *******************************
     Collections.reverse(output);
    return output;


    }
}