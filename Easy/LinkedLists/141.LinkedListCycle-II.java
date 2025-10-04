// Tell where the hare and tortoise meet for the first time
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Initialize tortoise and hare pointers
        ListNode tortoise = head;
        ListNode hare = head;

        // Move tortoise one step and hare two steps
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            // Check if the hare meets the tortoise
            if (tortoise == hare) {
                break;
            }
        }

        // Check if there is no cycle using FAST ptr
        if (hare == null || hare.next == null) {
            return null;
        }

        // ***************
        // At this point, we know both ptrs are in a cycle
        // We just need the start

        // Reset either tortoise or hare pointer to the head
        hare = head; // ********suppose we set fast pointer to head, then slow gives start of cycle

        // Move both pointers one step until they meet again
        while (tortoise != hare) {
            tortoise = tortoise.next;
            hare = hare.next;
        }

        // Return the node where the cycle begins
        return tortoise; // ********suppose we set fast pointer to head, then slow gives start of cycle
    }
}

// It is easy to analyze the space complexity. If you only use pointers without any other extra space, the space complexity will 
// be O(1). However, it is more difficult to analyze the time complexity. In order to get the answer, we need to analyze how many
//  times we will run our loop .

// In our previous finding cycle example, let's assume that we move the faster pointer 2 steps each time and move the slower pointer
//  1 step each time.

// If there is no cycle, the fast pointer takes N/2 times to reach the end of the linked list, where N is the length of the linked 
// list.
// If there is a cycle, the fast pointer needs M times to catch up the slower pointer, where M is the length of the cycle in the list.

// Obviously, M <= N. So we will run the loop up to N times. And for each loop, we only need constant time. So, the time complexity of
//  this algorithm is O(N) in total.