
// Using Hash table

public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            if (nodesSeen.contains(current)) {
                return true;
            }
            nodesSeen.add(current);
            current = current.next;
        }
        return false;
    }
}

// Time: O(n), Space: O(n)

// Floyd's cycle finding algo
// We can also use two pointers to check if cycle exists 
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

// I'm using fast and slow pointers again to determine presence of cycle, but 
// the overall logic is incorrect, it gave TLE
// I was assigning ptr to head and then fast and slow to ptr
// Corrected code below::
/**
Higher level intuition here is that: fast ptr will keep moving, slow will also move
Due to presence of cycle, fast ptr will cross slow ptr. 
Which means that: at some point, value of both ptrs will be same

The point at which fast and slow meet != start node of the cycle
Whenever they meet first, lets start again from there
reset any one to head 
increment both by 1 
Now, wherever they meet - IT IS THE START OF CYCLE

*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head; // assign to head
        ListNode fast = head; // assign to head
        while (fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}