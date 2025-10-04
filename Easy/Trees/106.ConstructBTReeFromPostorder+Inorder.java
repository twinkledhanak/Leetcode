/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// **** In Postorder, the tree is formed from Right to Left

class Solution {
    int parent;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

     public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // start from the last postorder element
        // **We calculate parent globally only -> Why? postorder.length might change as we are consider diff partition size always
        parent = postorder.length - 1;

        // build a hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder) 
            map.put(val, idx++); // (val, integer) -> just like two sum (10,i=0), (11,i=1), (12,i=3)

        return helper(0, inorder.length - 1); // only pass indices for inorder; not sure why postorder is used
    }

    public TreeNode helper(int inStart, int inEnd) {
        // if there are no elements to construct subtrees
        if (inStart > inEnd) return null;

        // pick up parent element as a root
        int parentVal = postorder[parent];
        TreeNode root = new TreeNode(parentVal);

        // root splits inorder list
        // into left and right subtrees
        int index = map.get(parentVal);

        // recursion
        // parent is the index, parentVal is the actual value
        parent--;

        // ****
        // FOR POSTORDER, RST IS FORMED FIRST
        // build the right subtree
        root.right = helper(index + 1, inEnd);


        // build the left subtree
        root.left = helper(inStart, index - 1);
        return root;
    }

   
}

// Time: O(n); Space: O(n)
