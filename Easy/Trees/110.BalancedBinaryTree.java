class Solution {
  public boolean isBalanced(TreeNode root) {
    // An empty tree (wow) satisfies the definition of a balanced tree
    if (root == null) {
      return true;
    }

    // Check if subtrees have height within 1. If they do, check if the
    // subtrees are balanced
    // Do this instead of comparing values
    return Math.abs(height(root.left) - height(root.right)) < 2
        && isBalanced(root.left)
        && isBalanced(root.right);
  }
    // Recursively obtain the height of a tree. An empty tree has -1 height
  private int height(TreeNode root) {
    // An empty tree has height -1
    if (root == null) {
      return -1;
    }
    return 1 + Math.max(height(root.left), height(root.right));
  }

};

// What is the height considered here as? In terms of No of nodes or edges?
// It is considered in terms of no of edges
// Another alternative way of writing height() is:
/*
  public int height(TreeNode root){
        // no of edges
        if(root == null)
            return 0;

        if(root.left==null && root.right==null)
            return 0;

        return Math.max(height(root.left),height(root.right)) + 1;    

    }
 */


// What I thought: 
// Time: O(n) - we are traversing all n nodes. If it is balanced, h=logN. Can be both.
// It is recursion within recursion, so for every node we are calling height
// O(n * logN)