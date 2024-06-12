class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
		// Add array to priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
        
		// Compare two top numbers from priority queue if they are consecutive
        int num = pq.poll();
        int localMax = 1;
        int globalMax = 1;
        while (!pq.isEmpty()) {
            int n = pq.poll();
            if (num == n) {
                continue;                   // If current and next number are same, continue to next number.
            } else if (num + 1 == n) {
                localMax++;                 // If current and next number are consecutive, incremenet localMax count.
            } else {
                localMax = 1;               // If current and next number are not consecutive, reset localMax count.
            }
            num = n;                        // Advance num to next number in priority queue.
            globalMax = Math.max(localMax, globalMax);  // Keep taking the max of globalMax and localMax.
        }
        return globalMax;
    }
}

// [200,1,100,4,2,3] - unsorted