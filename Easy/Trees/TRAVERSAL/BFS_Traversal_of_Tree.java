// Iterative solution

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) 
            return null;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Some custom logic for the question
            // Swap LHS and RHS
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            
            if (current.left != null) 
                queue.add(current.left);
            if (current.right != null) 
                queue.add(current.right);
        }
        return root;
    }
}