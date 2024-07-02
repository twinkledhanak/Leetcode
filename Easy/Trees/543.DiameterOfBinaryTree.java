
/*
      1
    /   \
    2   3   
  /  \
 4    5
 */


// For every node, get the max height/longest path of Left tree and right tree. Find the node where sum of its longest left and 
// right branches is maximised

// It is NOT the following - max height of lhs + max height of rhs => why? we are only considering root node here.
// Our diameter may or may not pass through the root node. So we have to do this calculation for every node recursively


class Solution {
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }

    // The return value of this function is a height, but it is not used anywhere. We just calculate both height and diameter
    // diameter is a class level variable that is updated by this function. Height is returned but not used
    private int longestPath(TreeNode node){
        if(node == null) return 0;
        // recursively find the longest path in
        // both left child and right child
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        // update the diameter if left_path plus right_path is larger
        diameter = Math.max(diameter, leftPath + rightPath);

        // return the longest one between left_path and right_path;
        // remember to add 1 for the path connecting the node and its parent
        return Math.max(leftPath, rightPath) + 1; // since we start from root.left and root.right
    }
}

// Time complexity: O(N). This is because in our recursion function longestPath, we only enter and exit from each node once.
//  We know this because each node is entered from its parent, and in a tree, nodes only have one parent.

// Space complexity: O(N). The space complexity depends on the size of our implicit call stack during our DFS, which relates 
// to the height of the tree. In the worst case, the tree is skewed so the height of the tree is O(N). 
// If the tree is balanced, it'd be O(logN).


int answer = 0;

public int diameterOfBinaryTree(TreeNode root) {
    int maxLengthToRoot = lengthToLeaf(root);
    return answer;
    
}

int lengthToLeaf(TreeNode root){

    if(root == null)
        return -1;

    if(root.left == null && root.right == null)
        return 0;
    
    
    int maxPathLength = 0;
    
    int leftLength = 0;
    if(root.left != null){
        leftLength = lengthToLeaf(root.left);
        maxPathLength = leftLength + 1;
    }
        
    
    int rightLength = 0;
    if(root.right != null){
        rightLength = lengthToLeaf(root.right);
        maxPathLength = maxPathLength + rightLength + 1;
    }
        
    answer = Math.max(answer, maxPathLength);
    return Math.max(leftLength, rightLength) + 1;
    
}

