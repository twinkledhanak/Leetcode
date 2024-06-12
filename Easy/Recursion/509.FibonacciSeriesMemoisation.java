import java.util.HashMap;

public class Main {

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