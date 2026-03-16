/**
Elems: freq - sorted order of freq - descending order. Top k. 
1 : 3
2 : 2 
3 : 1 

Brute force: Hash Map. Sort this on basis of values. Return top k => O(n * logN)
Max heap => Hash Map O(n) => worst case, hmap can have n elements => Inserting into max heap is O(nlogN)

Min Heap => Hash Map O(n) => worst case, hmap can have n elements => Inserting into min heap will also be O(nlogN)

The main idea here is that - it does not matter if we are using min or max heap, but how many elements are we maintaining in the heap
Maintaining a heap of size k is the key optimization — switching from log n → log k.
O(n*logK) is definitely better than O(n*logN)

Start with an empty heap.
Insert elements one by one. Increase the size gradually.
If heap size exceeds k, remove one element to bring it back to size k. This is the main decision.

When we have array: [2,3,5] and k=2
heap [2] ; iter# = 0
heap [3,2] ; iter# = 1
heap [5,3,2] ; iter# = 2 -> but this means that we have breached our size k and we have to remove one element to bring back heap to k

Which element to remove? Easiest one. Which is the easiest? - the top one
We will end up removing 5. Which is incorrect.
The strategy here is correct, but the data structure is incorrect for this problem as it is doing reverse of it.

The removal of element is needed to maintain size, 
If we want to prevent largest element from getting removed - we should not keep largest at the root.
But max heap always keep largest element at the root.
So, use min heap to remove minimum elements and protect max elements

*/



/**
     * Time Complexity: O(nlog(k))
     * Space Complexity: O(n)
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        // Create hashmap
        for (int num : nums) 
            map.put(num, map.getOrDefault(num, 0) + 1);

        // Create a priority queue, but put the entire map inside. Use Map.Entry
        // Min heap
        // prioirty queue that holds map, empty structure
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) ->
            a.getValue() - b.getValue()
        );

        // Inside this map structure, we just copy entire record directly
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            pq.add(it);
            if (pq.size() > k) 
                pq.poll();
        }
        int i = k;
        while (!pq.isEmpty()) {
            arr[--i] = pq.poll().getKey();
        }
        return arr;
    }
}
