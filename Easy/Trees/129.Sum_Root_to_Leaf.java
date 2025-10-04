/**
This solution gave me some more insights on Pre-order traversal
We are doing basic Pre-order traversal here
We have 3 options for Pre-order implementation:
Iterative: better time
Recursive: easy
Morris: better space

we first start with Iterative for best time!

What Not to do: I wanted to create paths from root to leaf - store them and then traverse and parse to Int.
*/

class Solution {
    public int sumNumbers(TreeNode root) {

        /**
        We know Pre-order DFS Iterative uses LinkedList and pollLast.
        We can use ArrayDeque here instead..
        */

        int rootToLeaf = 0, currNumber = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
        stack.push(new Pair(root, 0)); // (Node; Integer value until from start until before reaching the node)

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();

            root = p.getKey();
            currNumber = p.getValue();

            // Do something with the current node and then move forward

            if (root != null) {
                // Do something
                currNumber = currNumber * 10 + root.val; // Until now, add something to it


                // if it's a leaf, update root-to-leaf sum
                if (root.left == null && root.right == null) {
                    rootToLeaf += currNumber;
                } 
                
                else {
                    stack.push(new Pair(root.right, currNumber));
                    stack.push(new Pair(root.left, currNumber));
                }
            }


        }
        return rootToLeaf;
    }
}

// Recursive:
class Solution {
    int rootToLeaf = 0;

    public void preorder(TreeNode r, int currNumber) {
        if (r != null) {
            currNumber = currNumber * 10 + r.val;
            // if it's a leaf, update root-to-leaf sum
            if (r.left == null && r.right == null) {
                rootToLeaf += currNumber;
            }
            preorder(r.left, currNumber);
            preorder(r.right, currNumber);
        }
    }

    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return rootToLeaf;
    }
}

// Morris:::

class Solution {
    public int sumNumbers(TreeNode root) {
        int rootToLeaf = 0, currNumber = 0;
        int steps;
        TreeNode predecessor;

        while (root != null) {
            // If there is a left child,
            // then compute the predecessor.
            // If there is no link predecessor.right = root --> set it.
            // If there is a link predecessor.right = root --> break it.
            if (root.left != null) {
                // Predecessor node is one step to the left
                // and then to the right till you can.
                predecessor = root.left;
                steps = 1;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                    ++steps;
                }

                // Set link predecessor.right = root
                // and go to explore the left subtree
                if (predecessor.right == null) {
                    currNumber = currNumber * 10 + root.val;
                    predecessor.right = root;
                    root = root.left;
                }
                // Break the link predecessor.right = root
                // Once the link is broken,
                // it's time to change subtree and go to the right
                else {
                    // If you're on the leaf, update the sum
                    if (predecessor.left == null) {
                        rootToLeaf += currNumber;
                    }
                    // This part of tree is explored, backtrack
                    for (int i = 0; i < steps; ++i) {
                        currNumber /= 10;
                    }
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // If there is no left child
            // then just go right.
            else {
                currNumber = currNumber * 10 + root.val;
                // if you're on the leaf, update the sum
                if (root.right == null) {
                    rootToLeaf += currNumber;
                }
                root = root.right;
            }
        }
        return rootToLeaf;
    }
}