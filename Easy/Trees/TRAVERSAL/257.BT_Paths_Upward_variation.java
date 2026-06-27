/**



*/


/**
Initial attempt to write Part 1:
Improvements:
1. We dont need to store Target in a new node. We can simply add it to the path.
2. Use boolean to communicate between both approaches - top down and bottom up.
Why boolean? At every point - the decision: Whether the node should be added in the path or not?
Min answer that tells what to do - returning a boolean
Since the parent needs to know if a target was found in any sub-child, we NEED a return value.
Choosing boolean return value like below is the easiest way. Global boolean flag is messy approach.
*/

public List<Integer> getPath(TreeNode root, int value) {
    List<Integer> path = new ArrayList<>();
    helper(root, value, path);
    return path;
}

private boolean helper(TreeNode node, int value, List<Integer> path) {
    if (node == null) return false;

    // GOING DOWN PHASE — searching for target
    if (node.val == value) {
        path.add(node.val);
        return true;
    }

    if (helper(node.left, value, path) ||
        helper(node.right, value, path)) {
        
        // COMING BACK UP PHASE — building path => Implicit recursion stack movement
        path.add(node.val);
        return true; // Why True? I found the target somewhere in my subtree.
    }

    return false;
}









/*
class Solution{
	TreeNode target;
	public List<String> getpath(TreeNode root, int value){
		List<String> result = new ArrayList<>();
		if(root==null)
			return result;
        helper(root,value);
	}

	public void helper(TreeNode root, int value){
		if(root == null)
			return;

		// If we found our target node, save it	
		if(root.val == value)	
			target=new TreeNode(root);

        // Keep recursing, just like pre-order
		helper(root.left, value);
		helper(root.right, value);	
	}	
}
*/
