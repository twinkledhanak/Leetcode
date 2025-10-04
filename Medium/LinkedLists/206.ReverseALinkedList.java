class Solution {

    /*
    LinkedList problem for reversal can be done via both recursive and iterative methods.
    Esp. for reverse, both take the same time complexity, O(n)
    Space used for iterative is less, O(1) as compared to recursion, O(n)
    */

    public ListNode reverseList(ListNode head) {
        // prev; ptr; post
        // 1:2:3:4:5
        ListNode prev = null;
        ListNode ptr = head;

        while (ptr != null) {
            ListNode post = ptr.next; // null (prev) -> 1 (ptr) -> 2 (post)
            ptr.next = prev;          // null (prev) <- 1 (ptr)    2 (post) //reverse the point
            // Moving one step ahead, and reversing all ties on the way
            prev = ptr;               // null (prev) <- 1 (ptr changed to prev)       2 (post)
            ptr = post;               // 1 (prev) <- 2 (ptr is post)  
        }
        return prev; // ****** We return prev, nothing else; the end of LL is now the new head since it has been reversed
        // After execution of above code -> prev = head, ptr=null, post=some garbage (~) or null
    }
}

/*
while (ptr != null) {
            ListNode post = ptr.next;   // post will always keep pushing ahead
            ptr.next = prev;           // who is assigned? = with what? 
            
            prev = ptr;               // We only have to update prev and ptr; post is auto update
            ptr = post;               // We can write; ptr = ptr.next, but it will cause issues
        }
        return prev;
*/


/**
Higher level intuition: we must keep track of prev and next nodes both

Time complexity : O(n).
Assume that n is the list's length, the time complexity is O(n).

Space complexity : O(1).
*/

// Recursive solution
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
/*
Time complexity : O(n).
Assume that n is the list's length, the time complexity is O(n).

Space complexity : O(n).
The extra space comes from implicit stack space due to recursion. The recursion could go up to n levels 
deep.
*/

/*
Visual representation

1 -> 2 -> 3 -> 4 -> 5 -> X


A. Node post = ptr.next 
ptr=1, prev=null, post=2

B. ptr.next=prev
ptr=1, prev=null, post=2
Null <- 1    2 -> 3 -> 4 -> 5 -> X

C. prev=ptr
ptr=1, prev=1, post=2

D. ptr = post
ptr=2, prev=1, post=3 (will become in next while loop)

return prev, which is now on extreme RHS and represents the start of the list (head)

*/