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

// REFER THIS CLASS:
// POSTORDER: AB+
// ITERATIVE, USING DFS 
// THE ONLY RECURSION IS USE OF STACKS BY DFS
// EXPECTED ADD: LEFT-RIGHT-NODE
// SINCE STACKS: LEFT-RIGHT-NODE + Collections.rev()

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) {
      return output;
    }

    // Just like DFS, add first one to stack
    stack.add(root); // Since add works, offer() will also work


    while (!stack.isEmpty()) {
// get the last, instead of using stack.peek()
      TreeNode node = stack.pollLast(); 


     // ab+

      if (node.left != null) {
        stack.add(node.left); // Since add works, offer() will also work
      } 

      if (node.right != null) {
        stack.add(node.right);// Since add works, offer() will also work
      }
      
     
      
      output.add(node.val); // +

    }

    
    /// *******************************
     Collections.reverse(output);
    return output;


    }
}