/**
https://leetcode.com/problems/binary-tree-paths/description/

PRE-REQUISITE FOR Q.863-ALL-NODES-AT-DISTANCE-K-IN-BINARY-TREE
**/


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

All root to leaf paths.
Follows Top-Down. Start from top, append node values to a string and pass down
to children.
Classic top-down. Path is a parameter passed down. Perfect.
Problem?
we need: 1->2->5 NOT 1->2->5->.
Change 1: So, if the leaf node value is met, do not add ->
Change 2: Add the path to result list ONLY when we reach leaf node. Otherwise it is incomplete.
Change 3: Path as a parameter needs to reset after one path is traversed.
Reset using: new StringBuilder(path)
*/

class Solution {
    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        
        if(root==null)
            return result;

        StringBuilder path = new StringBuilder();
        helper(root, path);
        return result;   
    }

    public void helper(TreeNode root, StringBuilder path){
        if(root==null)
            return;

        path = path.append(root.val);
        
        if(root.left==null && root.right==null)
            result.add(path.toString()); // Add to the result here
        else
            path.append("->");

        /** Since path is modified, make a new path initialized with value from parent */
        /** This way, new path has new reference different from old path, but has old values */ 
        helper(root.left,new StringBuilder(path));
        helper(root.right,new StringBuilder(path));
        // path = new StringBuilder(); --> recursion already occured. No use of reset.
        
    }
}