/**
PRE-REQUISITE FOR Q.863-ALL-NODES-AT-DISTANCE-K-IN-BINARY-TREE

We know how to extract downward paths in a tree, starting from root to leaf
We have never extracted an UPWARD path before.

The purpose of this problem to find a target node in the binary tree and PRINT PATH FROM THAT TARGET NODE TO ROOT OF BINARY TREE

Part 1: Find the target node in tree [Going top-down, pre-order traversal]
Part 2: When the target node is found, start storing the path. Storing the path happens automatically with recursion stack.
Refer Traversal_summary_Patterns to understand how both top-down and bottom-up are present in same problem.
*/
/**
root, target, k
all nodes at distance K
no of edges? between node,target is k

FIND THE TARGET INSIDE Tree
OR, 
Alternate logic: Any node's distance from root = depth
Maybe, finding all nodes with depth=k (wrt root)
Now, change root to random node with value k
Now, calculate depth of all nodes WRT to this node
Pick the nodes that have depth=k
OR
If this was a graph, it is easier. We pick source node, do BFS level order.

BUT WAIT.
We can do a BFS level order traversal on tree. Just like right side view.
What is the problem here?

Level order traversal of tree only goes downward. We do not have a way to go UP.
If we see example 5,
node 1 is obtained by going upwards. 

Part 1 — Finding target location:
buildParentMap handles this implicitly. We don't need target's exact location because BFS starts directly from target node.

Part 2 — Going down from target upto k:
current.left and current.right directions in BFS.

Part 3 — Going up from target upto k:
parentMap.get(current) direction in BFS.

BFS From Target — Expanding Ripples
Think of dropping a stone in water.
Target node is where the stone drops.
Ripples expand outward in all directions — left, right, and upward through parent.
Each ripple = one level = one distance unit.

Distance 0:
        [5]         ← starting point

Distance 1:
      [6, 2, 3]     ← one step in every direction
      6 = left child
      2 = right child
      3 = parent
 */

class Solution {
    // Part 1: Parent map — lets us move upward
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null) 
            return result;
        
        // Step 1: Build parent map using DFS
        buildParentMap(root, null);
        
        // Step 2: BFS from target in all 3 directions
        Deque<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        
        queue.addLast(target);
        visited.add(target);
        
        int distance = 0;
        
        while (!queue.isEmpty()) {

            /** When we have reached distance=k */
            if (distance == k) {
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }
            
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                
                /** At every level, move forward ONE unit in all directions */

                // PART 2a: Go down left
                if (current.left != null && !visited.contains(current.left)) {
                    visited.add(current.left);
                    queue.addLast(current.left);
                }
                
                // PART 2b: Go down right
                if (current.right != null && !visited.contains(current.right)) {
                    visited.add(current.right);
                    queue.addLast(current.right);
                }
                
                // PART 3: Go up to parent
                TreeNode parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.addLast(parent);
                }
            }
            
            distance++;
        }
        
        return result;
    }
    
    // Preorder DFS — going down phase records parent for each node
    private void buildParentMap(TreeNode node, TreeNode parent) {
        if (node == null) 
            return;
        
        parentMap.put(node, parent);
        buildParentMap(node.left, node);
        buildParentMap(node.right, node);
    }
}
