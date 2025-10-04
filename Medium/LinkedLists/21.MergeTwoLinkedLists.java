/**
Merging two lists -> We use splice -> Split and Splice
Dont create a new list - instead we just start with an empty node
We just keep editing the minimum of the nodes
SEE THE ANIMATION IN LEETCODE SOLUTION
*/


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) { // get the minimum of the two
                prev.next = l1; // we point to l1 now
                l1 = l1.next; // since we updated; increment l1 now
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next; // ** Always maintain a previous node of LL, WHATEVER NODE WE ADD WILL BECOME PREV. WE THEN ADD NEXT NODE
        }

        // At least one of l1 and l2 can still have extra nodes at this point, so connect
        // the non-null list to the end of the merged list.
        // If l1 is null, link to l2 
        // If not, continue with l1
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}

// Time: O(m+n) ; to traverse both lists
// Space: O(1)