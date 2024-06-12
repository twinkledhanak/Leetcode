// Trees are mirrio images of each other, values of left and right are swapped completely

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // Extract left result
        TreeNode left = invertTree(root.left);

        // Extract right result
        TreeNode right = invertTree(root.right);
        
        // Swap left and right results
        root.left = right;
        root.right = left;
        return root;
    }
}

// Since each node in the tree is visited only once, the time complexity is O(n), where n is the number of nodes in the tree.
//  We cannot do better than that, since at the very least we have to visit each node to invert it.

// Because of recursion, O(h) function calls will be placed on the stack in the worst case, where h is the height of the tree.
//  Because h∈O(n), the space complexity is O(n).