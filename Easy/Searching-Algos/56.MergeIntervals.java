class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return null;
        // min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int interval[] : intervals)
            pq.offer(interval);

        List<int[]> list = new ArrayList<>();
        list.add(pq.poll());

        int start = 0, end = 1;
        while (!pq.isEmpty()) {
            int prev[] = list.get(list.size() - 1);
            int curr[] = pq.poll();
            if (curr[start] <= prev[end]) {
                prev[start] = Math.min(curr[start], prev[start]);
                prev[end] = Math.max(curr[end], prev[end]);
            } else
                list.add(curr);
        }
        return list.toArray(new int[list.size()][2]);
    }
}

// [[4,5],[1,4]] or [[1,3],[2,6],[8,10]]
// Sort them on basis of first element
// Following conditions are met if intervals are overlapping:
// end(i) > start(i+1) ; 3 > 2
// start(i) < start(i+1) ; 2 is less than all elements before 3
// Best DS is PQ