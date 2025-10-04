import java.util.HashMap;

public class Main {

// ******************************************************************************
public class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }
}

/**
This takes exponential time , O(2^N) -> (fan-out)^(height of tree)  
When we draw the state space tree - we have 2 child/options for every node, so fan-out=2
It is definitely not a balanced tree, so height=no of nodes=n and not logN
Hence, O(2^N)

Space: O(n)
We need space proportional to N to account for the max size of the stack, in memory. This stack keeps track of the function
calls to fib(N). This has the potential to be bad in cases that there isn't enough physical memory to handle the increasingly 
growing stack, leading to a StackOverflowError. The Java docs have a good explanation of this, describing it as an error that 
occurs because an application recurses too deeply.
*/

// In below optimisation approaches too, the space complexity still remains the same.
// What changes is the time complexity, from exponential to linear
// MORE OPTIMISED WITH MEMOISATION
// ******************************************************************************
  HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

  private int fib(int N) {
    if (cache.containsKey(N)) {
      return cache.get(N);
    }
    int result;
    if (N < 2) {
      result = N;
    } else {
      result = fib(N-1) + fib(N-2);
    }
    // keep the result in cache.
    cache.put(N, result);
    return result;
  }
}

// Time: O(n)
// Space: O(n)
// ******************************************************************************

class Solution {
    // Creating a hash map with 0 -> 0 and 1 -> 1 pairs
    private Map<Integer, Integer> cache = new HashMap<>(Map.of(0, 0, 1, 1));

    public int fib(int N) {

        //1. First step should always be checking cache, to avoid repeating calculations
        if (cache.containsKey(N)) {
            return cache.get(N);
        }

        //2. Updating cache at appropriate time
        cache.put(N, fib(N - 1) + fib(N - 2));

        //3. Final result
        return cache.get(N);
    }
}