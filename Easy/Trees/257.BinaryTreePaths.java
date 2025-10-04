/**
Given a binary tree, give all its result
            1
     2           3
4        5   

result: 
1 -> 2 -> 4; 
1 -> 2 -> 5; 
1 -> 3
*/

class Solution {

  LinkedList<String> result = new LinkedList();

  public List<String> binaryTreePaths(TreeNode root) {
    if(root == null)
        return result;

    helper(root, "");
    return result;
  }  


 public void helper(TreeNode root, String path) {
    if(root != null){
        path += Integer.toString(root.val); // Since path is a string

        // if reach a leaf
        if (root.left == null && root.right == null)  
            result.add(path);  
        
        // What to do with remaining nodes 
        // extend the current path
        path += "->"; 
        helper(root.left, path);
        helper(root.right, path);
        
    }
    
  }
  
}