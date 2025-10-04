Building a Min Heap in

O(nlogn) time can be done by repeatedly inserting elements into the heap one by one:

Start with an empty heap.
Insert each element: For each element, insert it into the heap using the heap insertion process, which takes 

O(logn) time per insertion.
Repeat for all 

n elements: Since there are 
n elements, the overall time complexity is 
O(nlogn).

Single element insertion: logN

Building a min heap in 
O(n) time can be achieved using the heapify process (Floyd algorithm), where you treat the array as a complete binary tree and
apply the heapify operation from the bottom-up.



Difference between Heaps and Binary Search tree:


Heaps:
1. Inserting one element: O(logN)
2. Inserting multiple elements: O(nlogN)
3. Creating a heap from scratch: O(nlogN) , but can be done in O(n) with Floyd
3. Allows duplicates 
4. It is not ordered
5. Heap is a complete binary tree and it is balanced!!!

Binary Search tree:
1. Inserting one element: O(logN)
2. Inserting multiple elements: O(nlogN)
3. Creating a heap from scratch: O(nlogN)
4. Does NOT allow duplicate 
5. Ordered 
6. BST is balanced, but sometimes it can be unbalanced too
