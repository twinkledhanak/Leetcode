class Solution {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null)
      return false;

      // Every time there is a sum variable, we keep on decreasing it

    sum -= root.val;
    if ((root.left == null) && (root.right == null))
      return (sum == 0);
    return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
  }
}

// Time complexity : we visit each node exactly once, thus the time complexity is O(N), where N 
// is the number of nodes.
// Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only one child node,
//  the recursion call would occur N times (the height of the tree), therefore the storage to keep the call stack 
//  would be O(N). But in the best case (the tree is completely balanced), the height of the tree 
//  would be log⁡(N). Therefore, the space complexity in this case would be O(log⁡(N))