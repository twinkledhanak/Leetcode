//https://leetcode.com/problems/merge-k-sorted-lists/editorial/

/**
We can approach it various methods, but the best one we understand is Priority Queue
Since we need multiple nodes' comparison 
*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0); // maybe it can be -1 ?
        ListNode point = head;

        // we can directly create min heap here
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node); // using offer() instead of add()
            }
        }

        // Min heap: so, we will get all nodes in sorted order
        // We just have to connect them with prev nodes 

        while (!queue.isEmpty()) {
            point.next = queue.poll(); // head's next is pointed to min node popped from stack
            point = point.next;
            if (point.next != null) {
                queue.offer(point.next); // *************??????????????????
            }
        }
        return head.next;
    }
}

// Time: O(nlogK) -> k = number of Linked lists we have 
// Space: O(n) for the new list, O(k) for the heap

// Divide and Conquer: Time: O(nlogK), Space: O(1) -- saving heap space
// If we merge lists one by one, Time: O(nK), Space: O(1)





// Official LC solution
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0); // maybe it can be -1 ?
        ListNode point = head;

        // we can use a comparator here; We cannot modify ListNode class to add a new method here
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if (o1.val > o2.val) {
                        return 1;
                    } else if (o1.val == o2.val) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        );
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            point.next = queue.poll();
            point = point.next;
            if (point.next != null) {
                queue.add(point.next);
            }
        }
        return head.next;
    }
}