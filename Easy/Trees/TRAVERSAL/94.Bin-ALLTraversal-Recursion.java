class Solution {
    // USES RECURSION
    // ** Note that we are also passing the ArrayList as a parameter in the recursive function
    

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }


// OUR HELPER() IS NOT RETURNING ANYTHING, SO WE CANNOT ADD THIS CONDITION:
// if (root == null)
//    return null
// NO OTHER ADD() CONDITIONS TO BE WRITTEN!!!

// inorder -> a+b
    public void helper(TreeNode root, List<Integer> res) {
        // ********** No writing of extra conditions
        if (root != null) {
            helper(root.left, res);
            res.add(root.val); // only add in the entire method
            helper(root.right, res);
        }
    }

// Another variant could be where helper is returning an arraylist
// This is just the pre-order variant
    public List<Integer> helper(TreeNode root, List<Integer> result){
        // This is mandatory, otherwise - we might get an NPE for leaf nodes during recursion
        if(root == null)
            return null;

        result.add(root.val);
        helper(root.left,result);
        helper(root.right,result);

        return result;
    }



// postorder -> ab+
    public void helper(TreeNode root, List<Integer> res) {
            if (root != null) {
                helper(root.left, res);
                helper(root.right, res);
                res.add(root.val);
                
            }
        }

// PRE-ORDER -> +ab
    public void helper(TreeNode root,List<Integer> result){
        if(root != null){
            // +ab
        result.add(root.val);
        helper(root.left,result);
        helper(root.right,result);
    }    


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

// Feb 2026

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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        return helper(root,result);      

    }

    // Pre-order helper
    public List<Integer> helper(TreeNode root, List<Integer> result){
        if(root == null)
            return null;

        result.add(root.val);    
        helper(root.left,result);
        helper(root.right,result);

        return result;    
    }

    // In-order helper
    public void helper(TreeNode node, List<Integer> result){
        if(node == null)
            return;
        helper(node.left,result);
        result.add(node.val);
        helper(node.right,result);  
    }

    // Post-order helper
    public void helper(TreeNode node, List<Integer> result){
        if(node == null)
            return;
        helper(node.left,result);
        helper(node.right,result);  
        result.add(node.val);
    }
    
}