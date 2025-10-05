// Whenever we are calculating Depth, use this function:

// A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs 
// by more than one.
// Height Balanced Tree can mention Height, but the real calculation is based upon Depth
// Height Balanced Tree = Depth(two subtrees) !> 1


class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;

        // This was my mistake => To return from root node and not add further recursion
        //return (getDepth(root.left,0) - getDepth(root.right,0)) > 1? false:true;        
        if (Math.abs(getDepth(root.left, 0) - getDepth(root.right, 0)) > 1)
            return false;

        // We also have to traverse entire tree LOL
        return isBalanced(root.left) && isBalanced(root.right);    
    }

    // No of nodes
    public int getDepth(TreeNode root, int sum){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1; // single node

        sum += 1;
        int left = getDepth(root.left, sum);
        int right = getDepth(root.right, sum);    

        return Math.max(left,right) + 1;
    }
}






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