/** Helper function to return the index-th node in the linked list. */
private SinglyListNode getNode(int index) {
    SinglyListNode cur = head;
    for (int i = 0; i < index && cur != null; ++i) {
        cur = cur.next;
    }
    return cur;
}
/** Helper function to return the last node in the linked list. */
private SinglyListNode getTail() {
    SinglyListNode cur = head;
    while (cur != null && cur.next != null) {
        cur = cur.next;
    }
    return cur;
}
/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
public int get(int index) {
    SinglyListNode cur = getNode(index);
    return cur == null ? -1 : cur.val;
}
