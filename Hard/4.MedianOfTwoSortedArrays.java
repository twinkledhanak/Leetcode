/*

Target Time complexity: O(log(m+n))


Approach 1: Merge Sort

Merge both arrays into one while keeping them sorted.
Track the middle element(s) to find the median.
Use two pointers to merge without extra space.
Time complexity: 
O(m+n) due to full array traversal.
Space complexity: 
O(1) since only two pointers are used.


Approach 2: Binary Search, Recursive

Use binary search on two sorted arrays to find the 
kth smallest element.
Recursively reduce the search space by discarding halves of the arrays.
Adjust 
k based on removed elements to find the median.
Time complexity: 
O(log(m⋅n)) due to recursive halving.
Space complexity: 
O(log(m+n)) for recursion stack.

Approach 3: A Better Binary Search

Perform binary search only on the smaller array to find the correct partition.
Ensure that the maximum of the left half is less than or equal to the minimum of the right half.
Compute the median based on partition edges.
Time complexity: 
O(log(min(m,n))) by focusing on the smaller array.
Space complexity: 
O(1) as only a few variables are used.

*/