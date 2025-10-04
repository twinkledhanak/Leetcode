class Solution {
    public int findKthLargest(int[] nums, int k) {
        int result = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // 71 ms
        // for(int x: nums) 
        //     maxHeap.offer(x);

        // 91ms
        // List<Integer> op = Arrays.stream(nums).boxed().collect(Collectors.toList());
        // maxHeap.addAll(op);

        while(k>0){
            result = maxHeap.poll();
            k--;
        }
        return result;
    }
}

// O(n*logN) using Max heap
// We need an improvement, where we restrict the heap size
// we do not add all elements of array in heap
// Heap size cannot be greater than k
// Using Min Heap, the time will be O(n*logk), which is >>>> improvement
// Space: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num: nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        
        return minHeap.peek();
    }
}

/*
Min heap, pop everything until k elements remain, 
[1,2,3,4,5] -> 1st Largest element, rank=1, k=1 => 5
[1,2,3,4,5] -> 2nd Largest element, rank=2, k=2 => 4 [decide between 4 and 5], k=2 => 2 elements are needed to decide
Elements with higher value of k are not needed, k=3,4,5,6

The problem is asking for the kth largest element. Let's push all the elements onto a min-heap, but pop from the heap when
the size exceeds k. When we pop, the smallest element is removed. By limiting the heap's size to k, after handling all elements,
the heap will contain exactly the k largest elements from the array.

It is impossible for one of the green elements to be popped because that would imply there are at least k elements in the array 
greater than it. This is because we only pop when the heap's size exceeds k, and popping removes the smallest element.

After we handle all the elements, we can just check the top of the heap. Because the heap is holding the k largest elements 
and the top of the heap is the smallest element, the top of the heap would be the kth
largest element, which is what the problem is asking for
*/


// QuickSelect - Usually it is for kth smallest element
// Time: O(n) in average case; O(n^2) in worst case
// Space: O(n)


class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num: nums) {
            list.add(num);
        }
        
        return quickSelect(list, k);
    }
    
    public int quickSelect(List<Integer> nums, int k) {
        int pivotIndex = new Random().nextInt(nums.size()); // random pivot
        int pivot = nums.get(pivotIndex);
        
        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        for (int num: nums) {
            if (num > pivot) { // If we want kth smallest, original quick select is used - num < pivot
                left.add(num); // Defn of left is swapped, usually QUickSelect is for kth smallest, but we have largest
            } else if (num < pivot) {
                right.add(num);
            } else {
                mid.add(num);
            }
        }
        
        if (k <= left.size()) {
            return quickSelect(left, k);
        }
        
        if (left.size() + mid.size() < k) {
            return quickSelect(right, k - left.size() - mid.size()); // *****
        }


        // For finding k-th smallest
        /*
        for (int num : nums) {
            if (num < pivot) { // Adjusted for finding k-th smallest
                left.add(num);
            } else if (num > pivot) {
                right.add(num);
            } else {
                mid.add(num);
            }
        }
        
        if (k <= left.size()) {
            return quickSelect(left, k);
        }
        
        if (left.size() + mid.size() < k) {
            return quickSelect(right, k - left.size() - mid.size());
        }

        */




        
        return pivot;
    }
}

// Finding k-th Smallest
class Solution {
    public int findKthSmallest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        
        return quickSelect(list, k);
    }
    
    public int quickSelect(List<Integer> nums, int k) {
        int pivotIndex = new Random().nextInt(nums.size());
        int pivot = nums.get(pivotIndex);
        
        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        for (int num : nums) {
            if (num < pivot) { // Adjusted for finding k-th smallest
                left.add(num);
            } else if (num > pivot) {
                right.add(num);
            } else {
                mid.add(num);
            }
        }
        
        if (k <= left.size()) {
            return quickSelect(left, k);
        }
        
        if (left.size() + mid.size() < k) {
            return quickSelect(right, k - left.size() - mid.size());
        }
        
        return pivot;
    }
}





// Counting sort 
/*
Given n as the length of nums and m as maxValue - minValue,

Time complexity: O(n+m)

We first find maxValue and minValue, which costs O(n).

Next, we initialize count, which costs O(m).

Next, we populate count, which costs O(n).

Finally, we iterate over the indices of count, which costs up to O(m).

Space complexity: O(m)

We create an array count with size O(m).

*/
