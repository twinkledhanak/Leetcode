// lhs <= node
// rhs > node

// overall, lhs < rhs

// If we have an in-order traversal of a BST, we get a sorted array
// One approach is to convert the given tree to its inorder traversal and see if we get a sorted array

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null); // Integer is a reference, so it can store null
    }

    public boolean helper(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }

        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) // Acc to me, it should be root.val < low for invalid. root.val>= low is valid bst
            ||
         (high != null && root.val >= high)){ 
            return false;
        }

        // The left and right subtree must also be valid.
        return (helper(root.right, root.val, high) && helper(root.left, low, root.val));
    }

    
}


// Stanford link:
// http://cslibrary.stanford.edu/110/BinaryTrees.html
private boolean isBST(Node node) {
  if (node==null) return(true);

  // do the subtrees contain values that do not
  // agree with the node?
  if (node.left!=null && maxValue(node.left) > node.data) return(false); // uses only >
  if (node.right!=null && minValue(node.right) <= node.data) return(false);

  // check that the subtrees themselves are ok
  return( isBST(node.left) && isBST(node.right) );
}



// My thoughts:
// Time: Lets say it is BST. H= N or logN, this case is logN
// Space: Recurs stack + non recursive: logN + constant => logN

// This is true for average case
// For worse case: Time and Space: O(n)