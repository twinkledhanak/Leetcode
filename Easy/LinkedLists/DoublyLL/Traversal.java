/*
class Node {
    public int val;
    public Node prev;
    public Node next;
};
*/

// Forward traversal
Node ptr = head; // head is given

while(ptr != null){
    //print
    ptr = ptr.next;
}



// Backward traversal
Node ptr = tail; // Given

while(ptr != null){
    // print
    ptr = ptr.prev;
}
