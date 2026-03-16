/**
This is a streaming problem
We always have to keep memory bounded and not let heap size grow to n
We try to maintain heap size to k
Even when we have all elements provided to us initially, the size of array can be n
Hence, even when inserting the current set of elements -
we take care of two constraints:
1. Insert only if current heap size < k 
OR
2. Insert only if we actually have a large value (larger than peek())

We maintain a min heap as we want to refer all largest elements all the time, hence they need to be in heap
The only way this can happen is when the heap type is max - so larger elements are always present
The question asks for Largest elements always - not smallest
refer to Top k frequent elements if more confusion on why we select a min heap here


*/
class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;

        for (int num : nums) {
            add(num); // $%^*()(*^%$%^(*^%$#$$%^&*()))
            // In my solution, I was doing queue.offer(num) which makes heap grow until n
            // Instead, we call the add() method and take care of all constraints
        }
    }

    public int add(int val) {
        // Add to our minHeap if we haven't processed k elements yet
        // or if val is greater than the top element (the k-th largest)
        if (minHeap.size() < k || minHeap.peek() < val) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}

/**
Time Complexity: O((M+N)⋅logk)
Space Complexity: O(k)

The minHeap maintains at most k elements, so the space complexity is O(k).
*/
