class Solution {
    List<Integer> rightside = new ArrayList();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside;
        
        helper(root, 0);
        return rightside;
    }
    
    public void helper(TreeNode node, int level) {
        if (level == rightside.size()) 
            rightside.add(node.val);
        
        // RIGHT SIDE VIEW
        if (node.right != null) 
            helper(node.right, level + 1);  
        if (node.left != null) 
            helper(node.left, level + 1);

        // LEFT SIDE VIEW
        // if (node.left != null) 
        //     helper(node.left, level + 1);
        // if (node.right != null) 
        //     helper(node.right, level + 1); 

    }    
    
    
}