// Java code to Reverse a doubly linked list,
// using two pointers
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class GfG {

    // Function to reverse a Doubly Linked List using two
    // pointers
    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        /**
        Singly List reversal code for reference:
        ListNode ptr=head, prev=null;
        while(ptr != null){
            ListNode post = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = post;
        }
        return prev; // in doubly, we still return prev, but we have 2 ref options - .prev and .next
        */
        // 1 <-> 2 <-> 3 <-> 4 -> NULL
        // prev=null; ptr=1; 

        Node ptr = head; 
        Node prev = null;

        // Traverse the list and reverse the links
        while (ptr != null) {
          
            // Swap the next and prev pointers 
            // -> swapping 2 and NULL-S in 1st iteration
            // -> swapping ; prev is used as the temp here
            prev = ptr.prev;        // NULL-S <- 1  2 <->
            ptr.prev = ptr.next;    // 2 <- 1 -> NULL-S // 1 ka prev must point to 2
            ptr.next = prev;        // 2 <-> 1 -> NULL-S

            // Move to the next node in the original list
            // (which is now previous due to reversal)
            ptr = ptr.prev; // next node after 1 is 2, but we just reversed all conns of 1, so now go to 2
            // WHERE is 2? prev of ptr
        }

        // Update head of Doubly Linked List
        head = prev.prev; // we reached the end of LL; the end of LL is now the new head since it has been reversed
        // We have 2 ref options to return, which one to consider? .prev or .next? we refer to the prev here as everything is reversed

        return head;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
      
        // Create a doubly linked list:
          // NULL-S <- 1 <-> 2 <-> 3 <-> 4 -> NULL-E
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        System.out.println("Original Doubly Linked List");
        printList(head);

        head = reverse(head);

        System.out.println("Reversed Doubly Linked List");
        printList(head);
    }
}
