class Solution {
    // Morris is suited for all traversals, we learnt this one variant - for Preorder using Morris.
    // TBT (Threaded BT) are only good for Inorder traversal, Morris is good for all 3
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();

        // Remember to copy the reference
        TreeNode node = root;

        while (node != null) {
            // WE ARE SOLVING PROBLEM OF LEFT TO RIGHT 
            // if left doesnt exists, go to right directly. (+ab -- +b)
            if (node.left == null) { 
                output.add(node.val); /// ********* FIRST SAVE
                node = node.right;
            } 

            // Go to left and then go rightmost (Why? For that left noe, we must find all right to connect)
            else {
                // Predecessor -> One that came before
                // We want a connection from left to right, so save left
                TreeNode predecessor = node.left; 
                while ((predecessor.right != null) && (predecessor.right != node)){
                    predecessor = predecessor.right;
                }
            // -----------------------------------------------------------------------------

                // But the right may or may not exist

                if (predecessor.right == null) { // if rightmost is null, save & go to left
                    output.add(node.val); /// ********* SECOND SAVE
                    predecessor.right = node; /// **********
                    node = node.left;
                } else { // rightmost is present, go to right
                    predecessor.right = null;
                    node = node.right;
                }
            }

        }
        return output;
    }
}

// Q: 129. Sum Root to Leaf; Morris Traversal, Time: O(N), Space: O(1)
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