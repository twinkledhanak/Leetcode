class Solution {
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    public TreeNode helper(int left, int right) {
        if (left > right) return null;

        // When array length is odd, choose middle one
        // When length is even, we choose middle + 1 (right side)
        // We can also choose middle-1 (left side), that approach is also one of the leetcode solutions
        // always choose right middle node as a root
        int p = (left + right) / 2;
        if ((left + right) % 2 == 1) ++p;

        // preorder traversal: node -> left -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

    
}

// Another approach, but handling the overflow issue when splitting middle, all in one liner

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
 **/
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;

        return helper(nums,0,nums.length-1);    
    }

    public TreeNode helper(int[] nums, int low, int high){
        // Whenever we have boundary variables - we always do check their validity
        if(low > high)
            return null;

        // Need to find midpoint
        int midpoint = low + (high-low)/2; // @#$%^*(*&^%#$%^*(I*^%$%^UIO))
        // Made the mistake here: [l + (h-l)] / 2 is incorrect. The divide by 2 is only for (h-l)


        // Found my root
        TreeNode root = new TreeNode(nums[midpoint]);
        root.left = helper(nums, low, midpoint-1);
        root.right = helper(nums, midpoint+1, high);

        return root;

    }
}

// What I thought of:
// Time Complexity: O(n) since we traverse entire array once
// Space Complexity: O(logN) we split at middle, creating a balanced tree, recursion stack height O(logN). Non-recursion: no storage

// Actual:
// Same!!