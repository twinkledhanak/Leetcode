// 1. Get to the middle of LL using slow and fast pts
// 2. Reverse the seconf half
// 3. Compare the first and second half
// 4. return result
// THE TRICK OF USING FUNCTIONS FOR EACH TASK IS NOOIIIICEEEE

class Solution {

    public boolean isPalindrome(ListNode head) {

        if (head == null) return true;

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head); // 1 to slow -- slow (the middle) is considered part of first half
        ListNode secondHalfStart = reverseList(firstHalfEnd.next); // slow+1 to end
        // A = reverseList(B.next)
        // *** we reverse the second half since it is easy

        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true; // why do we need a result variable? we can work without it too,
        // but, we have to reverse the LL irrespective whether it is pallindrome or not
        // If we just return false directly, we may not get a chance to reverse the LL back to original

        // List1: Head to Start
        // List2: Start+1 to End
        while (result && p2 != null) {
            if (p1.val != p2.val) 
                result = false;
            p1 = p1.next;
            p2 = p2.next;
        }        

        // **** We are restoring the list here; not sure if that has to be done everytime
        // Restore the list and return the result.
        // B.next = reverseList(A);
        firstHalfEnd.next = reverseList(secondHalfStart); // again give, slow+1
        return result;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow; // which is also the middle
    }

    // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode post = curr.next;
            curr.next = prev;
            prev = curr;
            curr = post;
        }
        return prev; // the new node which was at the end in original or now at start
        // 1 -> 2 -> 3 -> X
        // 1 <- 2 <- 3 
        // prev = 3
    }

    
}

/**
Time complexity : O(n), where n is the number of nodes in the Linked List.
Similar to the above approaches. Finding the middle is O(n), reversing a list in place is O(n), and then comparing
the 2 resulting Linked Lists is also O(n).

Space complexity : O(1).
We are changing the next pointers for half of the nodes. This was all memory that had already been allocated,
so we are not using any extra memory and therefore it is O(1).

I have seen some people on the discussion forum saying it has to be O(n) because we're creating a new list. This is incorrect, 
because we are changing each of the pointers one-by-one, in-place. We are not needing to allocate more than O(1) extra memory 
to do this work, and there is O(1) stack frames going on the stack. It is the same as reversing the values in an Array in place
(using the two-pointer technique).
The downside of this approach is that in a concurrent environment (multiple threads and processes accessing the same data), 
access to the Linked List by other threads or processes would have to be locked while this function is running, because 
the Linked List is temporarily broken. This is a limitation of many in-place algorithms though
*/