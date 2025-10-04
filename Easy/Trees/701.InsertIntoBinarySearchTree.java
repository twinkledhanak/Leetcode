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

        // Try to add one value at a time, either lst or rst
        if (val <= root.val & root.left == null){ // Left has to be null; otherwise whatever we add will override existing
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

// Other Iterative approach:
class Solution {
  public TreeNode insertIntoBST(TreeNode root, int val) {
    TreeNode node = root;
    while (node != null) {

        // insert into the right subtree
        if (val > node.val) {
            // insert right now
            if (node.right == null) {
                node.right = new TreeNode(val);
                return root; // if insertion is done; then just return
            }
            else 
                node = node.right; // ** Go more right
        }
        // insert into the left subtree
        else {
            // insert right now
            if (node.left == null) {
                node.left = new TreeNode(val);
                return root; // if insertion is done; then just return
            }
            else
                node = node.left; // ** Go more left
        }
    }

    return new TreeNode(val);
  }
}