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

// Core idea:
/**
Keep track of maximum per path
Keep counting nodes at global level

*/


class Solution {
    int count = 0;  // Global

    public int goodNodes(TreeNode root) {
        int maxVal = Integer.MIN_VALUE;

        if(root==null)
            return 0;

        return helper(root,maxVal);    
    }

    // max should be local to every path, hence passed as parameter
    public int helper(TreeNode root, int maxVal){
        if(root == null)
            return 0;

        
        maxVal = Math.max(maxVal, root.val);
        if(root.val >= maxVal)
            count +=1;

        helper(root.left,maxVal);
        helper(root.right,maxVal);

        return count;
    }
}