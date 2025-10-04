/**
Using Max-heaps / Priority Queues But in NEEEEETCODE way
// Time: O(n)
// Space: O(1)
*/

class Solution {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) 
            return tasks.length;

        // We can have tasks from A-Z, so totally 26 tasks are possible AT MAX.
        int[] arr = new int[26];
        // We could have used a hashmap to keep the frequency count, but we use an array instead
        for (char c : tasks) 
            arr[c - 'A']++;



        // For monitoring the task frequencies    
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int val : arr) 
            if (val > 0) 
                pq.add(val);

        // To keep in order which task must be processed when in later duration
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        // our time consideration starts from t=0
        // How does the Queue look? (1,3) -> Freq of task A is still 1 and it can be considered again at time t=3



        int time = 0;

        while ((!pq.isEmpty() || !q.isEmpty())) {
            time++;
            // First go to Task list
            // Add tasks from PQ to Normal Queue
            if (!pq.isEmpty()) {
                int val = pq.poll(); // Consider a task; decrement its frequency; add in queue when this task can be reconsidered
                val--;
                if (val > 0) // Given task can be considered again only at time: current time+n units later
                    q.add(new Pair(val, time + n));
            }

            // Now come to queue for task reconsideration
            // Add tasks from Normal Queue to PQ
            if (!q.isEmpty() && q.peek().getValue() == time) // q.peek() actually gives first element of the queue
                pq.add(q.poll().getKey()); // q.poll() gives a Pair. We take the first part (task freq) and insert into into queue
        }
        return time;
    }
}


/**
Using Max-heaps / Priority Queues
// Time: O(n)
// Space: O(1)
*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Build frequency map
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }
        
        // Max heap to store frequencies
        // But, how many elements does this heap store? k
        // N = no of given tasks , [a,a,a,b,b,b] -> Heap only has the distinct frequencies - a and b, so 2 values
        // Heap will not have n elements, we define the number of elements in heap as k
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(freq[i]);
            }
        }

        int time = 0;
        // Process tasks until the heap is empty
        while (!pq.isEmpty()) {
            int cycle = n + 1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            // Execute tasks in each cycle
            while (cycle-- > 0 && !pq.isEmpty()) {
                int currentFreq = pq.poll();
                if (currentFreq > 1) {
                    store.add(currentFreq - 1);
                }
                taskCount++;
            }
            // Restore updated frequencies to the heap
            store.forEach(pq::offer);
            // Add time for the completed cycle
            time += (pq.isEmpty() ? taskCount : n + 1);
        }
        return time;
    }
}

