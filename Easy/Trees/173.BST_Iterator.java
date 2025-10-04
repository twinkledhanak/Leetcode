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
class BSTIterator {
    List<Integer> inorder;
    int index = -1;

    public BSTIterator(TreeNode root) {
        // create an inorder traversal list
        inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            inorder.add(curr.val);
            curr = curr.right;
        }

    }
    
    public int next() {
        /**
        The only mistake I did here was to call hasNext() method here.
        if(hasNext())
            //.. do something
        else
            // return -1

        THIS WAS NOT NEEDED                
        */

        // get the value at the index maintained
        index+=1;
        return inorder.get(index);
           

    }
    
    public boolean hasNext() {
        // return if value at index is < length of list
        return (index+1 < inorder.size())? true:false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


 // Time: O(1) on average for next() and hasNext()
/* Time complexity : O(N) is the time taken by the constructor for the iterator. The problem statement only asks us to analyze 
the complexity of the two functions, however, when implementing a class, it's important to also note the time it takes to initialize
a new object of the class and in this case it would be linear in terms of the number of nodes in the BST. In addition to the space 
occupied by the new array we initialized, the recursion stack for the inorder traversal also occupies space but that is limited to
O(h) where h is the height of the tree.
next() would take O(1)
hasNext() would take O(1
*/

 // Space: O(h) where h = no of nodes in the tree = height -> O(n) or O(logN)