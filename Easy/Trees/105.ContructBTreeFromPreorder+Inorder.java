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

// preorder = [1,2,3,4], inorder = [2,1,3,4]
// Output: [1,2,3,null,null,null,4]


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // Call the helper function with initial indices
        // start,end,preorder , start,end,inorder
        return helper(0, preorder.length-1, preorder, 0,inorder.length-1, inorder); // ***** passing length-1
        
    }

    private TreeNode helper(int preStart, int preEnd, int[] preorder,  int inStart, int inEnd, int[] inorder) {
        // Base case: if there are no elements to construct the tree
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element in preorder array is the root
        TreeNode root = new TreeNode(preorder[preStart]); // **** use preStart, not inStart

        // Find the root in the inorder array
        int parent = -1;
        for (int i = inStart; i <= inEnd; i++) { // ********* WE START FROM inStart
            if (inorder[i] == preorder[preStart]) {
                parent = i;
                break;
            }
        }

        // Calculate the number of elements in the left subtree
        int leftTreeSize = parent - inStart;

        // Recursively construct the left and right subtrees
                  //helper(int preStart, int preEnd, int[] preorder,  int inStart, int inEnd, int[] inorder) {
        root.left = helper(preStart + 1, preStart + leftTreeSize, preorder,  inStart, parent - 1, inorder);
        root.right = helper(preStart + leftTreeSize + 1, preEnd, preorder,  parent + 1, inEnd, inorder);

        return root;
    }

}