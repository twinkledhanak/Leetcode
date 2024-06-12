/**
     * Time Complexity: O(nlog(k))
     * Space Complexity: O(n)
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        // Create hashmap
        for (int num : nums) 
            map.put(num, map.getOrDefault(num, 0) + 1);

        // Create a priority queue, but put the entire map inside. Use Map.Entry
        // Max heap
        // prioirty queue that holds map, empty structure
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) ->
            a.getValue() - b.getValue()
        );

        // Inside this map structure, we just copy entire record directly
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            pq.add(it);
            if (pq.size() > k) pq.poll();
        }
        int i = k;
        while (!pq.isEmpty()) {
            arr[--i] = pq.poll().getKey();
        }
        return arr;
    }
}
