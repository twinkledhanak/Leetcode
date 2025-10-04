class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
                  
        // We still use memoisation, but it is called TABULATION

        int[] cache = new int[N + 1]; // we go all the way until N, <=N, so we need one extra
        cache[1] = 1;
        for (int i = 2; i <= N; i++) { // ** NOte that we are using < and = to N -> <=N and not <N
            cache[i] = cache[i - 1] + cache[i - 2]; // if we consider we are at i, we use i+1, i+2 it is not possible.
            // we do not know i+1 and i+2 values at this moment
        }
    
        return cache[N]; // the final value of fib(n) will be stored at index n
    }
}

//Time: O(n)
//Space: O(n)

// UPDATE********
/**
We can improve the space complexity to only O(1) instead of O(n) -> By avoiding storing entire array
THIS IS A BIG IMPACT CHANGE, TO O(1)
*/


class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }

        int current = 0;
        int prev1 = 1;
        int prev2 = 0;

        for (int i = 2; i <= N; i++) {
            // Just store the previous results in variables, not array
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}

// If we USE MATRICES,  we can change the complexity to T,S: O(logN)
// If we USE GOLDEN RATIO, complexity T,S: O(logN),O(1)