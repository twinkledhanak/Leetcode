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

This is LCA type question.
What Should a Node Report to Its Parent?
When a node is processing, it can be in one of these situations:
1. I found p below me (or I am p)
2. I found q below me (or I am q)
3. I found nothing
4. I found BOTH p and q below me
Given these four situations — what should each node return to its parent?
Think about it this way:

If you're a node and your left child says "I found p" and your right child says "I found q" —
what does that mean about YOU?
The node is the lca
The question is to be answered at a parent node, on basis of what has been the response 
from child level nodes.

My initial attempt (Broken, just for intuition):
    public TreeNode lca(TreeNode root){
        if(root == null)
            return null;
        int left = lca(root.left, p, q); // 0,1
        int right = lca(root.right, p, q); // 0,1
        if(left+right == 2) // both nodes found
            return root;
        if(p != null && root.val == p.val) ? return 1 : return 0;
        if(q != null && root.val == q.val) ? return 1 : return 0;                    
    }
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) 
            return null;
        if (root == p || root == q) 
            return root;  // found one, report up

        TreeNode left  = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)        // your left+right==2
            return root;
        
        return left != null ? left : right;       // pass up whoever was found
    }
}