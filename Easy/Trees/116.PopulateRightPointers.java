class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        // Initialize a queue data structure which contains
        // just the root of the tree
        Queue<Node> Q = new LinkedList<Node>();
        Q.add(root);

        // Outer while loop which iterates over
        // each level
        while (Q.size() > 0) {
            // Note the size of the queue
            int size = Q.size();

            // Iterate over all the nodes on the current level
            for (int i = 0; i < size; i++) {
                // Pop a node from the front of the queue
                Node node = Q.poll();

                // This check is important. We don't want to
                // establish any wrong connections. The queue will
                // contain nodes from 2 levels at most at any
                // point in time. This check ensures we only
                // don't establish next pointers beyond the end
                // of a level
                // FOR ALL NODES, NULL IS ALREADY SET
                // WE JUST HAVE TO SET VALUE FOR ROOTS AND LST
                if (i < size - 1) { // IN A GIVEN LEVEL, [2,3] -> SET THE REQUIRED VALUES ONLY FOR LST
                    // IF Q SIZE IS 2, [2,3] -> LAST ELEMENT IS RIGHT WHOSE PTR IS ALREADY SET TO NULL
                    // SO JUST UPDATE PTR FOR LSTs
                    node.next = Q.peek();
                }

                // Add the children, if any, to the back of
                // the queue
                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
        }

        // Since the tree has now been modified, return the root node
        return root;
    }
}

/**

Time Complexity: O(N) since we process each node exactly once. Note that processing a node in this context means popping the 
node from the queue and then establishing the next pointers.
Space Complexity: O(N). This is a perfect binary tree which means the last level contains N/2 nodes. The space complexity for 
breadth first traversal is the space occupied by the queue which is dependent upon the maximum number of nodes in particular level.
So, in this case, the space complexity would be O(N).

*/

// Space: O(1) approach
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        // Start with the root node. There are no next pointers
        // that need to be set up on the first level
        Node leftmost = root;

        // Once we reach the final level, we are done
        while (leftmost.left != null) {
            // Iterate the "linked list" starting from the head
            // node and using the next pointers, establish the
            // corresponding links for the next level
            Node head = leftmost;

            while (head != null) {
                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // Progress along the list (nodes on the current level)
                head = head.next;
            }

            // Move onto the next level
            leftmost = leftmost.left;
        }

        return root;
    }
}