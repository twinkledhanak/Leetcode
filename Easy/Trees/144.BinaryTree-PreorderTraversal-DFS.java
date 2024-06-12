class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    LinkedList<TreeNode> stack = new LinkedList<>(); // it is still some variant of LIST, USE ADD() ONLY
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) {
      return output;
    }

    // Just like DFS, add first one to stack
    stack.add(root);


    while (!stack.isEmpty()) {
// get the last, instead of using stack.peek()
      TreeNode node = stack.pollLast();

       // Node, RIght , Left 
      output.add(node.val); // +

      // SInce it is stack, reverse the order of pushing
      // +ab , push right first
      if (node.right != null) {
        stack.add(node.right); // ADD, NOT PUSH
      }

      if (node.left != null) {
        stack.add(node.left); // ADD, NOT PUSH
      }


    }
    return output;
  }
}