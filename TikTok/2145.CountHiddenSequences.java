// Assume we start with a = 0,
// continuously calculate the next value by difference.
// We only need to record the current value a, the max and the min value in this sequence.

// Now we need to put the sequence with range [min, max] into a range of [lower, upper].

// If upper - lower < max - min, no possible hidden sequences.
// If upper - lower == max - min, we have only 1 possible hidden sequences.
// If upper - lower == max - min + 1, we have 2 possible hidden sequences.
// If upper - lower == max - min + k, we have k + 1 possible hidden sequences.


// Complexity
// Time O(n)
// Space O(1)


// Java

    public int numberOfArrays(int[] diff, int lower, int upper) {
        long a = 0, ma = 0, mi = 0;
        for (int d: diff) {
            a += d;
            ma = Math.max(ma, a);
            mi = Math.min(mi, a);
        }
        return (int)Math.max(0, (upper - lower) - (ma - mi) + 1);
    }