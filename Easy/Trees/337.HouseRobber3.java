// Mar 2026 solution

// Final attempt with two states
// Much simpler code, instead of a memo array with - node,{maxIfPick,maxIfSkip}
// we maintain two states per node => return two variables per node
class Solution {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    
    // Returns {maxIfPicked, maxIfSkipped} for this subtree
    private int[] helper(TreeNode node) {
        if (node == null) 
            return new int[]{0, 0};
        
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        
        // Pick this node → cannot pick children
        // Pick this node: consider skip of children
        // index 0: pick, 1: skip
        int pick = node.val + left[1] + right[1];
        
        // Skip this node → children can be picked or skipped
        int skip = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[]{pick, skip};
    }
}
// Time: O(n)
// Space: O(n)




// Initial attempt without memoisation
// DFS Preorder recursion where node has a state
// Node can be processed or dropped based on this state
// This is done since we have to keep track of adjacent nodes
// if a parent is processed dfs(node,canPick), set the child canPick to false
// This decision is taken using boolean variable canPick
// if a node has canPick == true, we are allowed to explore this node & its parent was not explored
class Solution {
    public int rob(TreeNode root) {
        return helper(root, true);
    }

    public int helper(TreeNode root, boolean canPick) {
        if (root == null)
            return 0;

        // Decision wrapper based on state of canPick
        // value of canPick reverses based on whether we picked a prev node
        // canPick <==> allowedToPick
        if (canPick) {
            // OPTION 1: pick
            // false: we picked this one, so cannot pick next
            int pick = root.val 
                + helper(root.left, false) 
                + helper(root.right, false);

            // OPTION 2: skip
            int skip = helper(root.left, true) 
                + helper(root.right, true);

            return Math.max(pick, skip);
        } else {
            // skipping the current node means we are allowed explore the next node
            // Think like a sum getting bubbled up from bottom (result of a recusion)
            // We add it
            return helper(root.left, true) 
                 + helper(root.right, true);
        }
    }
}

// Difference between House Robber (Linear) and House Robber (Tree)
// 1. Two choices - Max(prev, prev-1+current)
// 2. Single global sum variable can work for antire array


// 1. Two choices, but implement a way to track adjacent nodes
// 2. Single global sum variable does not work, since in tree - all paths branch and are considered independent
// We let each path return its own value. The global sum cannot hold all the branching possibilities.