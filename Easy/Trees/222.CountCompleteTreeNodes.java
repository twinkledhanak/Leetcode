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
    public int countNodes(TreeNode root) {
        // 2^0 + 2^1 + no of nodes in last level = O(n)
        // we need two things -> no of levels and no of nodes in last level
        // The fancy solution in Leetcode uses some Binary Search
    }
}

//https://leetcode.com/problems/count-complete-tree-nodes/editorial/