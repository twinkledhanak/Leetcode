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

/**
Summary:::
Kth largest // Kth Smallest
1. If array is sorted -> directly lookup the array and return appropriate value
2. If array is NOT sorted ->
Kth largest -> use Min Heap -> O(nlogK) [If we use Max here, it is O(nlogN)]
Kth smallest -> use Max Heap -> O(nlogK) [If we use Min here, it is O(nlogN)]
 */





// Time: O(nlogK)
// In kth largest, we had unsorted array 
// Here, we already have sorted array. So NO need of heap later on. Simply return inorder.get(k-1);


class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // 1. Need an inorder traversal of this tree
        // 2. Create a max heap and pop()

        List<Integer> inorder = new ArrayList<>();
        helper(root,inorder);
        return findSmallest(inorder,k);
    }

    public List<Integer> helper(TreeNode root,List<Integer> inorder){
        if(root == null)
            return new ArrayList<>();

        if (root != null) {
                helper(root.left,inorder);
                inorder.add(root.val);
                helper(root.right,inorder); 
        }   

        return inorder;
    }

    public int findSmallest(List<Integer> inorder, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int x: inorder){
            maxHeap.add(x);
            if(maxHeap.size() > k)
                maxHeap.poll();
        }

        return maxHeap.peek();
    }

}