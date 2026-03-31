/*
The benefit of having tail recursion is that for certain programming languages (e.g. C++) the compiler could optimize the 
memory allocation of the call stack by reusing the same space for every recursive call, rather than creating the space for 
each one. As a result, one could obtain the constant space complexity O(1) for the overhead of the recursive calls.
Note that the optimization of tail recursion is not supported by Python or Java.
*/

// Considering depth definition in terms of no of nodes
// Following Post order defn as every node has same return value 
 class Solution {
     public int maxDepth(TreeNode root) {
        if(root == null)
			return 0;

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		return Math.max(left,right)+1; // no of nodes
     }
  }
/**
Time: O(H) => In this case, it could be O(n)
Space: O(H) => Depending if the tree is completely skewed: O(n) or O(logn)
*/

// Iterative version is much more ugly for Post order versions
// We explicitly have to track depth using parallel stacks 
// Do this only if we have risk of stack overflow for tree depths

/*
Why is depths a LL and not a variable?
Because we explore multiple tree paths and single variable 
cannot keep track of everything. So we have a parallel stack.

    class Solution {
    public int maxDepth(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        if (root == null) return 0;

        stack.add(root);
        depths.add(1);

        int depth = 0, current_depth = 0;
        while (!stack.isEmpty()) {
            root = stack.pollLast();
            current_depth = depths.pollLast();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(root.left);
                stack.add(root.right);
                depths.add(current_depth + 1);
                depths.add(current_depth + 1);
            }
        }
        return depth;
    }
}

*/



