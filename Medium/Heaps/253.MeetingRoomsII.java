// Min heap on basis of start time
// [0,30] => Give 1 room
// [5,10] -> 5<30 = Give 1 room
// [15,20] -> 15>10 = Reuse room, no addtion
// return answer 2

// [2,4] [7,10]
// [2,4] starts first - assign one room
// [7,10] -> 7 > 4 = reuse room
// Ultimately we give preference to second no of the array which is the end time.

/**
The dry run is correct, but we have to do two things:
1. Sort the array by their start time
2. Use a heap to track the end time

In cases like these, we have to track which meeting finishes the earliest. So we know how to allocate a room.
We have to use a min heap, since top of the min heap represents the min (earliest) value when a meeting ends

When we say a meeting in on-going, it means that its end time is present in the heap.

Why are we NOT using a variable to keep a track of the meeting rooms?

If we keep a variable, we also have to track all the previous meetings to decide whether to increment variable OR not
*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Edge case: if there are no meetings, no rooms are needed
        if (intervals == null || intervals.length == 0) return 0;

        // Step 1: Sort all intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Use a min-heap to track end times of ongoing meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Step 3: Go through each meeting
        for (int[] meeting : intervals) {
            int start = meeting[0];
            int end = meeting[1];

            // If the earliest meeting in heap is done before current starts, reuse the room
            if (!minHeap.isEmpty() && start >= minHeap.peek()) {
                minHeap.poll(); // Room is freed
            }

            // Always add the current meeting's end time to the heap
            minHeap.offer(end);
        }

        // The size of the heap is the number of rooms needed
        return minHeap.size();
    }
}
