/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Delete here is more like override

class Solution {
    public void deleteNode(ListNode node) {
        ListNode postptr = node.next;
        node.val = postptr.val;
        node.next = postptr.next;
    }
}

/**
Challenge here is that we dont know the previous node or head node
Normally delete requires prev node address
Here, we simply override the current node with data and address from the next node
*/