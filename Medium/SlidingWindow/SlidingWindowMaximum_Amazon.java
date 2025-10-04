class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        result.add(nums[deque.peekFirst()]);

        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
            result.add(nums[deque.peekFirst()]);
        }
        // Return the resultult as an array.
        return result.stream().mapToInt(i->i).toArray();
    }
}