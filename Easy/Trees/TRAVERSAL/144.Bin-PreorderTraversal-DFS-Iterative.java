
// REFER THIS CLASS:
// PREORDER: +AB
// ITERATIVE, USING DFS 
// THE ONLY RECURSION IS USE OF STACKS BY DFS
// EXPECTED ADD: NODE-LEFT-RIGHT
// SINCE STACKS: NODE-RIGHT-LEFT
// LINKED-LIST IS USED TO IMPLEMENT STACKS, GETTING THE TOPMOST ELEMENT OF STACK IS SAME AS GETTING LAST ELEMENT OF LL

class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    LinkedList<TreeNode> stack = new LinkedList<>(); // it is still some variant of LIST, USE ADD() ONLY
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) {
      return output;
    }

    // Just like DFS, add first one to stack
    stack.add(root); // ADD(), NOT PUSH; Since add works, offer() will also work


    while (!stack.isEmpty()) {
// get the last, instead of using stack.peek()
      TreeNode node = stack.pollLast(); // since we use LL impl, use this. poll() will remove the first element, more deque suitable

       // Node, RIght , Left 
      output.add(node.val); // +

      // SInce it is stack, reverse the order of pushing
      // When doing it for N-ary tree, we completely reverse the list. Here, when we have control, we just push it in reverse way
      // +ab , push right first ****
      if (node.right != null) {
        stack.add(node.right); // ADD, NOT PUSH, we have a LL; Since add works, offer() will also work
      }

      if (node.left != null) {
        stack.add(node.left); // ADD, NOT PUSH; Since add works, offer() will also work
      }


    }
    return output;
  }
}


/*
Aspect:	poll()	;; pollLast()
Stack<Node> stack = new Stack<>(); LinkedList<Node> stack = new LinkedList<>();
When we use original stack class; When we use LinkedList as stack class
Function:	Retrieves and removes the first element of the deque ;;	Retrieves and removes the last element of the deque.
Equivalent Method:	Similar to removeFirst() ;;	Similar to removeLast().
Return Value:	Returns the head (first element) or null if the deque is empty ;;	Returns the tail (last element) or null if the deque is empty.
Typical Use Case:	Used when you need to operate on the front of the deque ;;	Used when you need to operate on the end of the deque.
Null Handling:	Returns null if the deque is empty, without throwing an exception ;;	Returns null if the deque is empty, without throwing an exception.
*/

LinkedList<TreeNode> stack = new LinkedList<>();
stack.push(...);
stack.poll();

LinkedList<TreeNode> stack = new LinkedList<>();
stack.add(...);
stack.pollLast();

why do we reverse the order in iterative approach?

Recursion and iteration both use a stack — but recursion uses the call stack, 
while iteration uses an explicit data stack.
The “reversal” happens because stacks are LIFO, and you must manually simulate the call order that 
recursion gives you for free.

In iterative preorder, you are replacing the JVM call stack with your own stack.

This means:
	•	You must push nodes manually
	•	You must decide push order
	•	You must respect LIFO behavior
