class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int currDay = 0; currDay < n; currDay++) {
            int currentTemp = temperatures[currDay];
            // Pop until the current day's temperature is not
            // warmer than the temperature at the top of the stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int prevDay = stack.pop();
                answer[prevDay] = currDay - prevDay;
            }
            // First element is always pushed to stack, while loop is skipped for it
            stack.push(currDay);
        }
        
        return answer;
    }
}

// We use Monotonic decreasing stack here, to hold temperatures
// Monotonic decreasing -> 3,2,1 (stack top)

// Feb 2026 solution with clear variables
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> deque = new ArrayDeque<>();
        // monotonic descreasing

        for(int i=0; i<temperatures.length; i++){

            while(!deque.isEmpty() && temperatures[i] > temperatures[deque.peekLast()]){
                int ans = deque.pollLast();
                answer[ans] = i - ans; // only extra logic is to save the value in answer
                // Eg. for temp at index:2 , value at index:6 is answer
                // No of days to wait: 6-2=4
            }
            deque.offerLast(i);    
        }

        return answer;
    }
}
Time: O(n)
Space: O(n)