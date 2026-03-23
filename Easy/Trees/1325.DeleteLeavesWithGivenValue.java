
/**
1. Delete a node only if it is a leaf
2. And value matches target
What is delete? Removing that node entirely from the tree

What not to do:
getting leaf node is easy ONCE
Problem is tricky since it asks to iterate tree again and again
We run risk of traversing a huge tree again and again

What to do instead:
If leaf node - we delete
If not - we track this parent - check if any of the children have target
keep repeating that operation recursively on the node until we clean it up completely

Solution is exploring all nodes of the tree, so DFS traversal
We use Preorder everytime we want to track parent - child relationship
Will Inorder traversal help here? Since we are concerned with leaves only?
Mostly no.
Will Postorder traversal help here? YES. Not Preorder.
Here, the fate of parent node depends on all children.
We process the children first and then the parent.
*/

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null)
            return null;

        return helper(root,target);    
    }

    public TreeNode helper(TreeNode root, int target){
        if(root == null)
            return null;

        // Process children first, postorder, ab+
        //TreeNode left = helper(root.left, target);
        // I was deleting the node but not updating the parent with latest value 
        root.left = helper(root.left, target);
        root.right = helper(root.right, target);

        // Manual attempt and not trusting recursion will handle cleanup
        // if(left!=null && left.val==target)
        //     left=null;
        // if(right!=null && right.val==target)
        //     right=null;

        // Do something for the parent
        if(root.left==null && root.right==null && root.val==target)
            root=null;

        return root;    

    }
}

// Time: O(n) => n = no of nodes
// Space: O(n), Space O(1) for extra variables is not counted