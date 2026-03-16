class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int start=0, end=0, m=0;
        // Store indices, not values since there can be duplicates
        Deque<Integer> queue = new ArrayDeque<>();

        // possible that ans size can be less than nums with extra zeros at end
        //int[] ans = new int[nums.length]; => resulted in [3,3,5,5,6,7,0,0]
        // trying to make it an array list
        List<Integer> ans = new ArrayList<>();

        for(end=0; end<nums.length; end++){
            
            // With each number we encounter, add it to the queue
            // But checking the monotonic decreasing property first
            // Modified to work with indices, not storing direct values 
            while(queue.size() > 0 && nums[queue.peekLast()] < nums[end])
                queue.pollLast();

            queue.offerLast(end);
// ------------------------------------------------------------------------------------            
// Didnt know this part was needed
// remove indices outside window
// We do it before shrinking because the element might already be invalid for the current window.
            if(queue.peekFirst() < start) // we have index comparisonss!!!
                queue.pollFirst();

// ------------------------------------------------------------------------------------
// Incrementing window start and storing result             
            if(end-start+1==k){ 
                //ans[m++]=queue.peekFirst();
                ans.add(nums[queue.peekFirst()]);
                start+=1;
            }
        }
        return ans.stream().mapToInt(i->i).toArray();
    }
}   