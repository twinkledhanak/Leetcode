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

///// DOESNT WORK, CHECK WHYYYY??????


class Solution {
    public TreeNode buildTree(int[] postorder, int[] inorder) {
        if (postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // Call the helper function with initial indices
        // start,end,postorder , start,end,inorder
        return helper(postorder.length-1, 0, postorder, 0,inorder.length-1, inorder);
        
    }

    private TreeNode helper(int postStart, int postEnd, int[] postorder,  int inStart, int inEnd, int[] inorder) {
        // Base case: if there are no elements to construct the tree
        if (postStart > postEnd || inStart > inEnd) { // check this
            return null;
        }

        
        // The first element in postorder array is the root
        TreeNode root = new TreeNode(postorder[postStart]);

        // Find the root in the inorder array
        int parent = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postStart]) {
                parent = i;
                break;
            }
        }

        // Calculate the number of elements in the left subtree
        //int leftTreeSize = parent - inStart;
        int leftTreeSize = parent - inStart;
        int rightTreeSize = inEnd - parent;

        // Recursively construct the left and right subtrees
        //root.left = helper(postStart + 1, postStart + leftTreeSize, postorder,  inStart, parent - 1, inorder);
        //root.right = helper(postStart + leftTreeSize + 1, postEnd, postorder,  parent + 1, inEnd, inorder);

        
        root.right = helper(postEnd - 1 - rightTreeSize, postEnd - 1, postorder,  parent + 1, inEnd, inorder);
        root.left = helper(postStart, postStart + leftTreeSize - 1, postorder,  inStart, parent - 1, inorder);
        
        return root;
    }

}