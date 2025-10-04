/**
1. Inorder Traversal
2. Get sorted array
3. Compare all consecutive elements and return the min diff 
4. DO NOT return the diff of only first two elements, counter example - 1,10,11,15 -> inorder ; sorted array but diff is not small
*/

class Solution {
    // List to store the tree nodes in the inorder traversal.
    List<Integer> inorderNodes = new ArrayList<>();
    
    void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        
        inorderTraversal(node.left);
        // Store the nodes in the list.
        inorderNodes.add(node.val);
        inorderTraversal(node.right);
    }
    
    int getMinimumDifference(TreeNode root) {
       inorderTraversal(root);
        
        int minDifference = Integer.MAX_VALUE;
        // Find the diff between every two consecutive values in the list.
        for (int i = 1; i < inorderNodes.size(); i++) {
            minDifference = Math.min(minDifference, inorderNodes.get(i) - inorderNodes.get(i-1));
        }
        
        return minDifference;
    }
};