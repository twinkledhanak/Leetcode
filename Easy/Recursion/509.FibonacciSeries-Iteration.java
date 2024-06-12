class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
                  
        // We still use memoisation, but it is called TABULATION

        int[] cache = new int[N + 1];
        cache[1] = 1;
        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2]; // if we consider we are at i, we use i+1, i+2 it is not possible.
            // we do not know i+1 and i+2 values at this moment
        }
    
        return cache[N];
    }
}

//Time: O(n)
//Space: O(n)