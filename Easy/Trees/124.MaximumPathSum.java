class Solution {
    // Max Path sum needs the max of entire left and max of entire right to compare

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }

    private int maxSum;

    // post order traversal of subtree rooted at `root`
    // We use POST ORDER TRAVERSAL
    // Understand why it is Post order
    // At any point, we need the max from left and right to decide which direction to move from root
    // It means, we need to process the children before we process the root
    // WHICH is the concept of POST ORDER Traversal of trees

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // POST: AB+
        // We get max of left first
        // We get max of right next
        // then do an operation involving root (+)


        // add the path sum from left subtree. Note that if the path
        // sum is negative, we can ignore it, or count it as 0.
        // This is the reason we use `Math.max` here.
        // MAX OF ENTIRE LEFT
        int left = Math.max(helper(root.left), 0);

        // add the path sum from right subtree. 0 if negative
        // MAX OF ENTIRE RIGHT
        int right = Math.max(helper(root.right), 0);

        // if left or right path sum are negative, they are counted
        // as 0, so this statement takes care of all four scenarios
        maxSum = Math.max(maxSum, left + right + root.val); // NOT ADDING 1, BUT ROOT.VAL AS WE NEED TO ADD ROOT'S VALUE, NOT 1

        // return the max sum for a path starting at the root of subtree
        return Math.max(left + root.val, right + root.val);
    }
}

// Time: O(n)
// Space: O(n)