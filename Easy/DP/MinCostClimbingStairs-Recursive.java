class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();


    // In Climbing stair - Recursive, we have i+1 and i+2, but here, we cannot do that

    // There is cost associated with every step now
    public int minCostClimbingStairs(int[] cost) {
        return minimumCost(cost.length, cost);
    }

    private int minimumCost(int i, int[] cost) {
        // Base case, we are allowed to start at either step 0 or step 1
        if (i <= 1) {
            return 0; // The cost is 0 at the start step, when the array size is <=1
        }

        // Check if we have already calculated minimumCost(i)
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        // If not, cache the result in our hash map and return it
        int downOne = cost[i - 1] + minimumCost(i - 1, cost);
        int downTwo = cost[i - 2] + minimumCost(i - 2, cost);
        memo.put(i, Math.min(downOne, downTwo));
        return memo.get(i);
    }
}

// Time: O(n); Space: O(n)