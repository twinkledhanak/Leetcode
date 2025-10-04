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
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null)
            return true;
        

        // The current node's value must be between low and high. Expected: low <= root.val < high
        if ((low != null && root.val <= low) || (high != null && root.val >= high))
            return false;
        

        // The left and right subtree must also be valid.
        // LST: root.left, low, root.val is higher
        // RST: root.right, root.val , high
        return (helper(root.right, root.val, high) && helper(root.left, low, root.val));
    }

    
}

// Time: O(n) , Space: O(n)


// Another, slightly wrong approach;
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    public boolean helper(TreeNode root){
        if(root == null)
            return true;

        if(root.left == null && root.right == null)
            return true;

        if(root.left.val <= root.val && root.right.val > root.val)
            return true;    

        return isValidBST(root.left) && isValidBST(root.right);

    }
 }


/*
The problem is this approach will not work for all cases. Not only the right child should be larger than the node but all 
the elements in the right subtree.
That means one should keep both upper and lower limits for each node while traversing the tree, and compare the node value not
with children values but with these limits.

*/


