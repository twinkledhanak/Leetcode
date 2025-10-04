// First do 206.
// ADVANTAGE OF HAVING ITERATIVE SOLUTION OVER RECURSIVE SOLUTION
// It may so happen that you cannot change the data available in the nodes.
// In that scenario, we have to modify the links themselves to achieve the reversal.

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode ptr = head, prev = null;
        // **** LEFT AND RIGHT ARE 1-BASED POSITIONS; NOT THE VALUES
        while (left > 1) { // 1-BASED, SO > 1
            prev = ptr; // we always store the prev one; keep iterating till current reaches left
            ptr = ptr.next;
            left--;
            right--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = ptr;// @TODO - Understand the need 

        // Iteratively reverse the nodes until right becomes 0.
        // Right-left = 4-2 = 2 => we have to reverse the list that has 3 nodes, from left, left+i until right
        // Instead of traversing to right again and then reversing, we reverse WHILE we iterate.
        ListNode post = null;
        while (right > 0) { // **** FOR REMAINING RIGHT
            post = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = post;
            right--;
        }
        // Adjust the final connections as explained in the algorithm
        // The node before the reversed sublist is still pointing to start of original sublist
        // Eg. 1 -> 2 -> 3 -> 4 -> 5 -> X
        /**
              1 <-> 2 <- 3 <- 4    5 -> X
        1 is still pointing to 2 ; but 2 is the old head, 1 must point to 4
        2 is still pointing to node before the reversed sublist. It must point to the node after the sublist, 5
        Desired o/p:  1-> 4 -> 3 -> 2 -> 5 -> X

        These adjustments are to be made after the reversal is done. 
        I was trying to make these changes at start. If not fixed, we will get error -
        Cycle detected in Linked List -> Trying printing the LL and you'll see!

        Last state of prev and ptr after above rev code -
        
        */
        if (con != null) {
            con.next = prev; // Make (saved ptr) 1 point to 4; prev which was 1 is now upgraded and stopped at 4
        } else {
            head = prev;
        }

        tail.next = ptr; // 2 is saved in tail; tail = 2, line 20; ptr also got upgraded and stopped at 5
        return head;
    }
}

// Time: O(n) ; Space: O(1)