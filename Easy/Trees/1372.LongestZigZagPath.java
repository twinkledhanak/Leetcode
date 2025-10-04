/**
In DP, we explore all choices and get maximum
In Trees, while recursing - we achieve the same 

Combine Trees + DFS = Maximising choices with recursion 
*/

class Solution {
    int pathLength = 0;

    // we have two choices - exploring left and right
    // We can select any one and get maximum sum 
    // It gives DP vibes, but it not DP exactly.

    public int longestZigZag(TreeNode root) {
        dfs(root, false, 0); // explore left once
        dfs(root, true, 0); // explore right
        return pathLength;
    }


    private void dfs(TreeNode node, boolean goLeft, int steps) {
        if (node == null) {
            return;
        }
        pathLength = Math.max(pathLength, steps); // HOW CAN ANYONE FORGET THE ANSWER VARIABLE?

        // !@#$%^&*()!@#$%^&*()
        // Most important step - we are making two calls for each step, so total 4 steps


        if (goLeft) {
            dfs(node.left, false, steps + 1); // select right, increment steps
            dfs(node.right, true, 1); // ** You reset steps to 1 (Not 0) since you’re starting a new zigzag path in the opposite direction.
        } else {
            dfs(node.left, false, 1);
            dfs(node.right, true, steps + 1);
        }
    }

    
}

/*
Time complexity: O(n)

Using the dfs function, we recursively visit both the childrens of every node once. As a result, it takes O(n) time because 
there are n nodes in total. We iterate over each edge once to visit all the all nodes, which again takes O(n) operations as
 there are n−1 edges in the tree.
Space complexity: O(n)

The recursion stack used by dfs can have no more than n elements in the worst-case scenario where each node is added to it. 
It would take up O(n) space in that case.

*/