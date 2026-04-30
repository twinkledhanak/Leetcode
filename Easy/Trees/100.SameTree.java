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
 */

 // LITERALLY EVERYTHING IS SAME
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;

        // remember to write this condition
        if(p == null || q == null)
            return false;

        return (p.val == q.val) && isSameTree(p.left,q.left)
        && isSameTree(p.right,q.right);        
    }
}

// Iterative approach
// Comparing two trees side by side, BFS serves better than DFS
class Solution {
    public boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;

        // init deques
        // BFS level order traversal. BFS? For early termination, comparing width is better.
        // Level order traversal? Works best with BFS
        ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
        deqP.addLast(p);
        deqQ.addLast(q);

        while (!deqP.isEmpty()) {
            // Since Queues, removeFirst(). If we wanted to use Stacks, then .removeLast()
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            if (!check(p, q)) return false;
            if (p != null) {
                // in Java nulls are not allowed in Deque
                if (!check(p.left, q.left)) return false;
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!check(p.right, q.right)) return false;
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;
    }
}