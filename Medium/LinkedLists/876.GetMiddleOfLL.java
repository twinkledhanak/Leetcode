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
    public ListNode middleNode(ListNode head) {
        ListNode fastptr = head, slowptr = head;
        // Here we know that fastptr will reach null first
        // It is important to have null check for ptr that reaches null first
        while(fastptr != null && fastptr.next != null){ // ** fastptr check for null too!!
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
        }

        return slowptr;
    }
}
/**
classic example of fast and slow pointers
Fast jumps 2 places, slow jumps one place
So when fast reaches end, slow must have reached in the middle

Time Complexity: O(N), where N is the number of nodes in the given list.

Space Complexity: O(1), the space used by slow and fast.
*/