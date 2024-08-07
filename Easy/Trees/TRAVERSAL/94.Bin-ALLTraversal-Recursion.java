class Solution {
    // USES RECURSION
    

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }


// OUR HELPER() IS NOT RETURNING ANYTHING, SO WE CANNOT ADD THIS CONDITION:
// if (root == null)
//    return null

// inorder -> a+b
    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
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