/*
      1
    /   \
    2   3   
  /  \
 4    5

Inorder: 4,2,5,1,3
Preordr: 1,2,4,5,3 (another variant of DFS) +ab
Postord: 4,5,2,3,1
BFStrav: 1,2,3,4,5 (level order)

*/
// Level order traversal - Iterative and Recursive
// Right side view of tree - Recursive (uses level)
// Level order traversal Recursive and Right side view of tree are very similar



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
                TreeNode node = queue.remove(); // Not poll() or pollLast()

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
            level++;
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
        // start the current level
        if (results.size() == level) // for every new level, initialize a new list
            results.add(new ArrayList<Integer>());

        // fulfil the current level, some custom logic 
        results.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null) helper(node.left, level + 1);
        if (node.right != null) helper(node.right, level + 1);
    }

    
}

// Another example
// Right side view - Recursive
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
    }    
}
