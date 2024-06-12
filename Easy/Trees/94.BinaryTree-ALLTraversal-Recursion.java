class Solution {
    // USES RECURSION
    

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

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


}