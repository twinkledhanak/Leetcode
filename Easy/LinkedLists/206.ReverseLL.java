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

        ListNode curr = head; // Initializing with start node, curr is a pointer. We point our curr to nodes
        // and manipulate them

        while (curr != null) {
            ListNode nextTemp = curr.next; // Save the next values of this curr; It is the main info

            curr.next = prev; // Now that we saved the remaining list, this one's link is useless. Overwrite it.
            prev = curr;

            // Move over to the next node
            curr = nextTemp;
        }
        return prev; // prev is going to be our new head!
    }
}