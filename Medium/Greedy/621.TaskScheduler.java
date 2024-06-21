// Facts for this problem:
// 1. Tasks can be processed in any order
// 2. Each task takes 1 unit of time
// 3. We want to start with A _ _ (when n=2, two empty slots)
// 4. We need the frequency of each tasks and since it is greedy approach, we process the task which is most painful first.
// 5. More painful is also more frequent, as we have to insert a lot of wait time
// 6. So, while we're waiting, might as well process other tasks when waiting for cooling for A
// 7. Identical tasks cannot be processed one after the other
// 8. Obvious data structure here is max heap

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 1. make a map to know the counts of all characters
        Map<Character, Integer> counts = new HashMap<>();
        for (char task : tasks) {
            counts.put(task, counts.getOrDefault(task, 0) + 1);
        }

        // 2. Creating max heap, but we are storing only frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(counts.values());
        // Lets say we are using only the max heap, we have to update the value and push the element again as (elem,freq)

        int time = 0;
        Deque<int[]> queue = new ArrayDeque<>();  // pairs of [cnt, idleTime]
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            if (!queue.isEmpty() && time >= queue.peek()[1]) {
                maxHeap.offer(queue.poll()[0]);
            }
            if (!maxHeap.isEmpty()) {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    queue.offer(new int[]{cnt, time + n + 1});
                }
            }
            time++;
        }
        return time;
    }
}
