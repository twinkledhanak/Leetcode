class Solution {

  // A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
  public int maxDepth(TreeNode root) {
    if (root == null) { // we consider no of nodes, so return 0, not -1
      return 0;
    } 
    else {
      int left_height = maxDepth(root.left);
      int right_height = maxDepth(root.right);
      return java.lang.Math.max(left_height, right_height) + 1;
    }
  }
}

// Time complexity: O(n)


// Alternate code:
/*
class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    public int helper(TreeNode root){
        if(root == null) // no node, return no of nodes, which is 0
            return 0;

        if(root.left == null && root.right == null) // 1 node, return no of nodes, which is 1
            return 1;

        return Math.max(helper(root.left),helper(root.right)) + 1; // since no of nodes
    }
}

*/

/*
         5
      /      \
   10       15
  /   \      /   \
20   25     30   35
         \
         45

for root-> height is 3, depth(root): 0 (no of edges)
for root-> height is 4, depth, 1 (no of nodes)

    // consider no of nodes for Depth
    public int maxDepthNodes(TreeNode root) {
        if(root == null)
            return 0; 
        if(root.left == null & root.right == null)
            return 1;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
            
    }

    // consider no of edges for Depth
    public int maxDepthEdges(TreeNode root) {
        if(root == null)
            return 0;  
        if(root.left == null & root.right == null)
            return 0; // ******* only one base case difference
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
            
    }




*/


