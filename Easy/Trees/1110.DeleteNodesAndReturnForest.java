class Solution {
    
    HashSet<Integer> set = new HashSet<>();
    List<TreeNode> list = new ArrayList<>();
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int val: to_delete){
            set.add(val);
        }
        helper(root);
        if(!set.contains(root.val)){
            list.add(root);
        }
        return list;
    }
    
    public TreeNode helper(TreeNode node){
        if(node == null)
            return null;
        
        node.left = helper(node.left);
        node.right = helper(node.right);
        
        if(set.contains(node.val)){
            if(node.left != null){
                list.add(node.left);
            }
            if(node.right != null){
                list.add(node.right);
            }
            return null;
        }
        return node;
    }
}

// When and from where to remove the node?? I knew that if I have to delete any node I have to assign it to null. But how could
// I do that the same time I am checking if the node has to be deleted or not. We can't do that. What we have to do is to get to
// know if the leftNode/rightNode is deleted or not. If yes then assign the current node's left/right node to null.
// When to add the node?? We have to add the node only when the current node is going to be deleted. So if the left node is not
// deleted add it to the list. Same is the scenario for right node.
// ** The first solution I thought is to return a boolean value if the node will be deleted. We could do that too. But this is 
// the cleaner code **