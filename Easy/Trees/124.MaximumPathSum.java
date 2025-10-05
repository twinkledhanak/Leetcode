✅ Where your instincts were correct:

You correctly saw that you need a global max, not just local at any node
You wanted to discard bad subpaths (like Kadane’s does)
You sensed you need to choose whether to extend a path through a node or start fresh
These are excellent instincts.


❌ Where you went off-course:

You assumed tree traversal can be treated like a list traversal.
You tried to force linear traversal (in-order) to explore paths — but valid paths in a tree can fork and go multiple directions.
You tried to apply Kadane logic iteratively, which works for arrays but is not natural for trees (which grow recursively).
You were tracking localSum across tree levels — but each node should have its own local decision, and that needs recursive isolation.


💡 What can you do to refine your thinking?
1. Don’t anchor too hard on a known pattern

Kadane’s is a great analogy — but once the structure (tree vs array) doesnt align, let the analogy go and ask:

What does “maximum path” mean in this structure?
What kind of decisions are made at each node?

2. Respect the recursive nature of trees

When youre solving a tree problem, think from the leaves up.

Ask: what does each subtree return to its parent?

The structure of recursion often maps more cleanly to tree properties than iteration does.

3. Model your solution around a recursive function

In this case:

For every node, "what is the maximum path sum going down from here?"
And "what is the maximum path sum if I include both children and this node?"


// Found the answer for why post order & not in-order
// Consider the tree below -
            1
    2               3
4     5        6        7


/*
When we say Inorder - We start a path from 4, hoping it would go through 4 -> 2 -> 1 ... etc
If that doesnt work for some reason - we are right in ignoring that path.
But we cannot continue ahead from 1 directly.
Who will explore that path from 5 -> 2 -> 1 ?

It means we have to explore all children before we can explore the parent, but we start with left child and then right child
Hence, it IS Post-order
*/





class Solution {
    // Max Path sum needs the max of entire left and max of entire right to compare

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }

    private int maxSum;

    // post order traversal of subtree rooted at `root`
    // We use POST ORDER TRAVERSAL
    // Understand why it is Post order
    // At any point, we need the max from left and right to decide which direction to move from root
    // It means, we need to process the children before we process the root
    // WHICH is the concept of POST ORDER Traversal of trees

    // I ALSO GOT CONFUSED BETWEEN POSTORDER & INORDER
    // THEY BOTH START FROM THE BOTTOM
    // BUT, IT IS ALSO IMPORTANT WHAT COMES AFTER THAT-
    // IF I HAVE TP PROCESS THE CHILD ONLY - THEN POSTORDER

    // THIS DOESNT LOOK LIKE POST ORDER
    WE ARE USED TO SEEING IT AS: AB+
PROCESSING THE LEFT, THE RIGHT AND THEN DOING SOMETHING WITH THE NODE

BUT,
WE CAN ALSO HAVE EXAMPLE OF FUNCTIONAL POST ORDER TRAVERSAL


we process both left and right children FIRST and then parent node -> functional meaning of postorder 
// Inorder functional meaning -> One child -> root -> Again another child
// Pre-order -> From the root first, then come to the children
// Post-order -> Children first, their computation result is stored and could be used at the parent level


    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // POST: AB+
        // We get max of left first
        // We get max of right next
        // then do an operation involving root (+)


        // add the path sum from left subtree. Note that if the path
        // sum is negative, we can ignore it, or count it as 0.
        // This is the reason we use `Math.max` here.
        // MAX OF ENTIRE LEFT
        int left = Math.max(helper(root.left), 0);

        // add the path sum from right subtree. 0 if negative
        // MAX OF ENTIRE RIGHT
        int right = Math.max(helper(root.right), 0);

        // if left or right path sum are negative, they are counted
        // as 0, so this statement takes care of all four scenarios
        maxSum = Math.max(maxSum, left + right + root.val); // NOT ADDING 1, BUT ROOT.VAL AS WE NEED TO ADD ROOT'S VALUE, NOT 1

        // return the max sum for a path starting at the root of subtree
        return Math.max(left + root.val, right + root.val);
    }
}

// Time: O(n)
// Space: O(n)