/*
      1
    /   \
    2   3   
  /  \
 4    5

Inorder: 4,2,5,1,3
Preordr: 1,2,4,5,3 (another variant of DFS) +ab
Postord: 4,5,2,3,1
Level Order: 1,2,3,4,5 
BFS Traversal: (~) 1,2,3,4,5
*/
// Level order traversal - Iterative and Recursive
// Right side view of tree - Recursive (uses level)
// Level order traversal Recursive and Right side view of tree are very similar
// ***************************!!!!!!!!!!!!!!!@#%^
// https://leetcode.com/discuss/general-discussion/1094690/views-and-traversal-of-binary-tree-important-topics-must-read

// Binary tree - level order traversal - Iterative ; BFS; Uses Queues
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root == null) 
            return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {

            // *************************************** Treating every level separately **************//
            // start the current level
            results.add(new ArrayList<Integer>()); // first make the list for level, then add elements

            // number of elements in the current level
            int queue_size = queue.size();
            // It appears as though queue size is changing everytime. It is. But the length was updated only once per level

            for (int i = 0; i < queue_size; ++i) {
                TreeNode node = queue.poll(); // ****poll() works NOT pollLast(); We want the first element here!!! NOT the last!!

                // fulfill the current level. We get the node at current level
                results.get(level).add(node.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) 
                    queue.add(node.left);
                if (node.right != null) 
                    queue.add(node.right);
            }


            // go to next level
            level++; // ****** DO NOT FORGET
        }
        return results;
    }
}


// Level order traversal - Recursive, uses level and results
class Solution {
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) 
            return results;
        helper(root, 0);
        return levels;
    }

    public void helper(TreeNode node, int level) {
        // start the current level ; whenever we have a level/size parameter, always check its bounds
        if (results.size() == level) // for every new level, initialize a new list
            results.add(new ArrayList<Integer>());

        // fulfil the current level, some custom logic 
        results.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null) helper(node.left, level + 1); // DONT forget to increment levels
        if (node.right != null) helper(node.right, level + 1);
    }

    
}

// Another example
// Right side view - Recursive
// Note the return type, its just a list
class Solution {
    List<Integer> rightside = new ArrayList(); 
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) 
            return rightside;
        helper(root, 0);
        return rightside;
    }
    
    public void helper(TreeNode node, int level) {
        if (level == rightside.size()) // we pick the last node from every level. So, size of result increases with every level
            rightside.add(node.val);
        
        // RIGHT SIDE VIEW
        if (node.right != null) helper(node.right, level + 1);  //***********First right */
        if (node.left != null) helper(node.left, level + 1);
        // We have the steps for left side also, but we are always making the call to right first.
        // By the time we reach left nodes, the level val has increased and it may not match the result array size
    }    
}
