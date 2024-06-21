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

// This may be tagged as Medium, but we are not checking if the tree is balanced or not. This could be a followup question

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return helper(root,val); // passing the root initially
    }


    public TreeNode helper(TreeNode root, int val){
        if (root == null){
            return new TreeNode(val);
        }

        if (val <= root.val & root.left == null){
            root.left = new TreeNode(val);
            return root;
        }

        if (val > root.val & root.right == null){
            root.right = new TreeNode(val);
            return root;
        }

        if (val <= root.val)
            helper(root.left,val); // not storing anything, as in recurison, the above conditions will execute and they return val directly
            // no need to explicitly store it, let the above conditions + their return + global return take care of everything
        
        else 
            helper(root.right,val);

        return root; // global return of the root
    }
}