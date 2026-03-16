class Solution {
    List<Integer> rightside = new ArrayList();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside;
        
        helper(root, 0);
        return rightside;
    }
    
    public void helper(TreeNode node, int level) {
        if (level == rightside.size()) // we pick the last node from every level. So, size of result increases with every level
            rightside.add(node.val);
        
        // RIGHT SIDE VIEW
        if (node.right != null) 
            helper(node.right, level + 1);  //***********First right */
        if (node.left != null) 
            helper(node.left, level + 1);

        // LEFT SIDE VIEW
        // if (node.left != null) 
        //     helper(node.left, level + 1);
        // if (node.right != null) 
        //     helper(node.right, level + 1); 

    }    
    
    
}

// Time: O(n) - traversing entire tree
// Space: O(n) - storing all nodes but < n. No of levels = no of nodes stored. Levels? 
// O(D) to keep the queues, where D is a tree diameter. Let's use the last level to estimate the queue size. 
// This level could contain up to N/2 tree nodes in the case of complete binary tree.

/** BFS Traversal code -- Recursive */
class Solution {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) 
            return levels;
        helper(root, 0);
        return levels;
    }

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level) 
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null) 
            helper(node.left, level + 1);
        if (node.right != null) 
            helper(node.right, level + 1);
    }

    
}

// Feb 2026
// Iterative solution loosely based on level order traversal
// Core idea: Do level order traversal of tree, after we have all the nodes of a given level - 
// pick the last node and save it


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // I need to do level order traversal and pick the last element
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rhs = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        if(root==null)
            return rhs;

        queue.offer(root);
        while(!queue.isEmpty()){
            int qSize = queue.size();
            result.add(new ArrayList<>());

            for(int i=0; i<qSize; i++){
                TreeNode node = queue.poll();

                result.get(level).add(node.val);

                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);

            }

            List<Integer> ls = result.get(level);
            rhs.add(ls.get(ls.size()-1)); // CORE IDEA
            level +=1;
            
        }

        return rhs;

    }
}