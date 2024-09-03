/*
You are given a set of jobs that can run in parallel, and you need to minimize the number of operations required to complete all jobs.
The operations are defined such that in each operation, one job (the "major" job) is executed for x seconds while all other 
jobs are executed for y seconds, where y < x.

Objective:
Find the minimum number of operations needed to complete all jobs.

Approach:
Use max heap and decrease the value of every job. Selected job -> reduce by x; others: reduce by y

Another good approach:
Using Binary Search

*/

import java.util.PriorityQueue;
import java.util.Comparator;

public class JobSchedulerWithHeap {

    public static int minOperations(int[] executionTime, int x, int y) {
        // Step 1: Use a max heap to store the jobs based on their execution time
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // Step 2: Add all job execution times to the max heap
        for (int time : executionTime) {
            maxHeap.offer(time);
        }

        int operations = 0;

        // Step 3: Perform the operations until all jobs are completed
        while (!maxHeap.isEmpty() && maxHeap.peek() > 0) {
            operations++;

            // Remove the largest job (major job) from the heap
            int majorJob = maxHeap.poll();
            majorJob -= x;

            // Process the remaining jobs
            PriorityQueue<Integer> tempHeap = new PriorityQueue<>(Comparator.reverseOrder());
            while (!maxHeap.isEmpty()) {
                int currentJob = maxHeap.poll();
                currentJob -= y;
                if (currentJob > 0) {
                    tempHeap.offer(currentJob);
                }
            }

            // If the major job is not yet complete, add it back to the heap
            if (majorJob > 0) {
                tempHeap.offer(majorJob);
            }

            // Replace the old heap with the updated one
            maxHeap = tempHeap;
        }

        return operations;
    }

    public static void main(String[] args) {
        int[] executionTime = {3, 4, 1, 7, 6}; // Example input
        int x = 4;
        int y = 2;
        int result = minOperations(executionTime, x, y);
        System.out.println("Minimum number of operations: " + result);
    }
}

// Max Heap Approach: O(n log n + m log n) where m is the number of operations	O(n) for the heap

// Binary Search approach:
/*
We are given an element from the array, element.
We are considering k operations in total.
In each operation:
We can pick one element and subtract 𝑥 from it.
We subtract 𝑦 from all other elements.

Calculation Explanation
Initial Reduction by 𝑘 Operations:
In 𝑘 operations, every element will be reduced by at least 𝑘×𝑦 (since 𝑦 is subtracted from every element in each operation).
So, the value of the element after 𝑘 operations will be:
element_after_ky = element − 𝑘 × 𝑦

After the 𝑘 operations, the remaining value to be reduced to reach zero is:
remaining = element − 𝑘 × 𝑦
If remaining is already less than or equal to zero, no additional operations are needed for this element.

Additional Reductions with 𝑥:

If remaining is greater than zero, we need additional operations to bring it down to zero.
Each such operation can pick the element and subtract 𝑥 from it. Since each such operation reduces the element by
𝑥 − 𝑦 (because 𝑥 is subtracted from the picked element, and 𝑦 is added back because 𝑦 was subtracted from it during the initial 
𝑘 operations).

Calculating Extra Operations:

The total number of such extra operations needed to reduce remaining to zero can be calculated by:
extra_ops = ⌈remaining / (𝑥 − 𝑦)⌉

In integer arithmetic, the ceiling function can be implemented by adding 𝑥 − 𝑦 − 1 before integer division. This ensures we 
round up correctly:
extra_ops = ⌊(remaining + 𝑥 − 𝑦 − 1) / (𝑥 − 𝑦)⌋

Substituting remaining:
extra_ops = (element − 𝑘 × 𝑦 + 𝑥 − 𝑦 − 1) // (𝑥 − 𝑦)

https://leetcode.com/discuss/interview-question/5463280/Citadel-2024-OA


*/
def can_reduce_to_zero(arr, x, y, k):
    required_ops = 0
    for element in arr:
        if element <= k * y:
            continue
        extra_ops = (element - k * y + x - y - 1) // (x - y)
        required_ops += extra_ops
        if required_ops > k:
            return False
    return True

def min_operations_to_zero(arr, x, y):
    left, right = 0, max(arr) // min(x, y) + 1
    while left < right:
        mid = (left + right) // 2
        if can_reduce_to_zero(arr, x, y, mid):
            right = mid
        else:
            left = mid + 1
    return left

# Example usage
arr = [10, 20, 30]
x, y = 3, 1
print(min_operations_to_zero(arr, x, y))