/*
With the pattern we have - we will use a 2D array for dp and end up doing a traversal
in two loops - so time complexity is going to be O(n^2)

And this is optimal complexity for problems like:
Longest Pallindromic Substring - where even the DP sol is O(n^2)

But for problems like: Maximum Product Subarray,
While it fits in this category - 
We have a better algorithm called Kadane's algorithm that is DP
and gives the solution in O(n)

*/