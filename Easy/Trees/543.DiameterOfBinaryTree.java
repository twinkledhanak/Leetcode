
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

/***
THIS QUESTION IS VERY SIMILAR TO MAX-SUM PATH QUESTION
IN THAT Q, WE ADD THE VALUES OF ALL NODES AND GIVE THE PATH WITH MAX SUM
HERE, WE DO EXACT SAME THING, BUT INSTEAD, RETURN THE NUMBER OF NODES ON THE LONGEST PATH (DIAMETER)

We have to traverse the tree - DFS, BFS
We need to find the longest route - suggesting going from root to leaf - 
But, we need the maximum of both the children, suggesting, we have POSTorder -> first processing the children, then parent
*/

class Solution {
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }

    // Even though the return value is not used; we use it internally to update diameter
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

