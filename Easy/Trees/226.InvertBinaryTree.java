// Symmetric trees - The LST of node A is RST of node B
// Symmetric trees - The RST of node A is LST of node B

// Example of Symmetric tree - Pretend Mirror is in middle
/*
      1
    2 - 2
  3,4 - 4,3
*/

// Invert Tree - Pretend Mirror is at extreme RHS
/*
        4
     2    7  
    1,3   6,9

        4
     7    2
    9,6   3,1
*/

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

// We can do a BFS traversal of the tree and invert
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // Swap LHS and RHS
            TreeNode current = queue.poll();
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