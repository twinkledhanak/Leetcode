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
    public List<Integer> preorderTraversal(TreeNode root) {
        // Note the LL used here
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();


        // IMP
        if (root == null) {
            return output;
        }

        stack.add(root); // In pre-order, we explore root first
        while(!stack.isEmpty()){
            // Process the top of stack first
            TreeNode node = stack.pollLast();
            output.add(node.val);

            // EXPLORE RIGHT FIRST **************************
            if(node.right!=null)
                stack.add(node.right);



            if(node.left!=null)
                stack.add(node.left);


            
        }
        return output; 
    }
}