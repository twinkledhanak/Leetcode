class Solution {

    /***
    Higher level Intuition for LCA - 
    1. We need to find where are the nodes p and q located in the tree
    2. We also need to keep of parents for each of these nodes, as only having immediate parent of p and q wont help    

    What do we use to search here? BFS or DFS?
    BFS - helps search faster
    DFS - helps to search, with direction from root to deepest leaf -> Will help with keeping track of previous parents
    
    Hence, we go with DFS
    But, we have 3 ways of DFS - In, Pre and Post
    Pre resembles the problem best

    Preorder recursive solution below - 
    1 --> 2 --> 4 --> 8
BACKTRACK 8 --> 4
4 --> 9 (ONE NODE FOUND, return True)
BACKTRACK 9 --> 4 --> 2
2 --> 5 --> 10
BACKTRACK 10 --> 5
5 --> 11 (ANOTHER NODE FOUND, return True)
BACKTRACK 11 --> 5 --> 2

2 is the node where we have left = True and right = True and hence it is the lowest common ancestor.

    */

    private TreeNode ans;

    public Solution() {
        // Variable to store LCA node.
        this.ans = null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // MARKING EACH PARENT WITH SOMETHING
        // Instead of focussing on individual elems, we focus on setting a common property at every node
        // We dont store the list of parents
        // While traversing, we just assign some values to nodes (runtime) so they can be used again when that node is revisited

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0; 
        // when left = 1, it means either p, q were found in this node's lst

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
        // when right = 1, it means either p, q were found in this node's rst

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }
}

// Time: O(n) and Space: O(n)