/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        ListNode ptr = head; // Initializing with start node, ptr is a pointer. We point our ptr to nodes
        // and manipulate them

        while (ptr != null) {
            ListNode post = ptr.next; // Save the next values of this ptr; It is the main info

            ptr.next = prev; // Now that we saved the remaining list, this one's link is useless. Overwrite it.
            prev = ptr;

            // Move over to the next node
            ptr = post;
        }
        return prev; // prev is going to be our new head!
    }
}

// Time: O(n) - to traverse the LL 
// Space: O(1)