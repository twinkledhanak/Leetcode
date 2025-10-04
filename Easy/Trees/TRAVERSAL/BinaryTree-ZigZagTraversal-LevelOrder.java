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
 // 1. level: 0,2 -> R to L
 // 2. level: 1,3,5 -> L->R
 // Same level order traversal; iterative
 // BFS, Queue

// Do a level order traversal of Binary tree
// For one level, print nodes L->R
// For next level, print nodes R->L


class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        int level = 0;
        if(root==null)
            return result;

        queue.add(root); // QUEUE.OFFER() WORKS

        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> list = new ArrayList<>(); // this list will hold bfs nodes of same level

            for(int i=0; i<len; i++){
                // at level 0, what do we want to do?
                
                TreeNode node = queue.remove();
                list.add(node.val);


                if(node.left!=null) // QUEUE.OFFER() WORKS
                    queue.add(node.left); /// ADD, NOT PUSH. Because of this mistake I was getting wrong nodes, [20,7] not [20,9]

                if(node.right!=null)
                    queue.add(node.right); // QUEUE.OFFER() WORKS
            }
            if(level % 2 == 1)
                Collections.reverse(list);

            result.add(list);
            level+=1;
            

        }
        return result;
    }
}

// Below is very similar to earlier traversals;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root == null) 
            return results;

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
                TreeNode node = queue.poll(); // poll() works NOT pollLast()

                // fulfill the current level. We get the node at current level
                results.get(level).add(node.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) 
                    queue.add(node.left);
                if (node.right != null) 
                    queue.add(node.right);
            }
            if(level%2==1) // Reversing all lists at odd levels
                Collections.reverse(results.get(level)); /// *******************

            // go to next level
            level++;
        }
        return results;
    }
}

/**
Time Complexity: O(N), where N is the number of nodes in the tree.

We visit each node once and only once.

In addition, the insertion operation on either end of the deque takes a constant time, rather than using the array/list data structure where the inserting at the head could take the O(K) time where K is the length of the list.

Space Complexity: O(N) where N is the number of nodes in the tree.

The main memory consumption of the algorithm is the node_queue that we use for the loop, apart from the array that we use to keep the final output.

As one can see, at any given moment, the node_queue would hold the nodes that are at most across two levels. Therefore, at most, the size of the queue would be no more than 2⋅L, assuming L is the maximum number of nodes that might reside on the same level. Since we have a binary tree, the level that contains the most nodes could occur to consist of all the leave nodes in a full binary tree, which is roughly L= 
2
N
​
 . As a result, we have the space complexity of 2⋅ 
2
N
​
 =N in the worst case.



*/