// REFER THIS CLASS:
// IN-ORDER: A+B
// ITERATIVE, USING DFS 
// THE ONLY RECURSION IS USE OF STACKS BY DFS
// EXPECTED ADD: LEFT-NODE-RIGHT
// WE ARE IN A WAY GOING DOWN TO LEFTMOST NODE, WHICH NEEDS DFS, NOT BFS

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) { // Uses ORRRRRRRRRRR
            while (curr != null) {
                stack.push(curr); // Here we use push ; not add
                curr = curr.left; // Keep going left of curr
            }
            curr = stack.pop(); // we use poll() in queue
            res.add(curr.val);
            curr = curr.right; // curr.right, not , root.right
        }
        return res;
    }
}