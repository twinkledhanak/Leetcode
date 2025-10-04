public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root); // ** Same root is passed twice
}

public boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) 
        return true;
    if (t1 == null || t2 == null) 
        return false;

    // CANNOT WRITE 
    /*
    IF(P.VAL == Q.VAL) RETURN TRUE; AS WE HAVE MULTIPLE CONDITIONS TO BE CHECKED BEFORE WE CAN RETURN TRUE
    */


    return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
}


// Time complexity: O(n). Because we traverse the entire input tree once, the total run time is O(n), 
// where n is the total number of nodes in the tree.

// Space complexity: The number of recursive calls is bound by the height of the tree. In the worst case, the tree is linear 
// and the height is in O(n). Therefore, space complexity due to recursive calls on the stack is O(n) 
// in the worst case.

// Example of Symmetric tree
/*
1
2 - 2
3,4 - 4,3
*/

// Iterative solution:
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        // Using Queues since it is BFS
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) 
                continue;
            if (t1 == null || t2 == null) 
                return false;
            if (t1.val != t2.val) 
                return false;
                
            q.add(t1.left);
            q.add(t2.right);
            
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}