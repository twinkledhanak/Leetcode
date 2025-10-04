class Solution {

    public int sumEvenGrandparent(TreeNode root) {
        return solve(root, -1, -1);
    }

    int solve(TreeNode root, int parent, int gParent) {
        if (root == null) {
            return 0;
        }
        
        // Iterate over the child with updated values of parent and grandparent.
        return solve(root.left, root.val, parent) 
                + solve(root.right, root.val, parent)
                + (gParent % 2 != 0 ? 0 : root.val);
    }

}
/**
Higher level intuition:
Use DFS
and pre-order
At every node, we just store the values of parent and grandparent (Two Extra Nodes)
*/