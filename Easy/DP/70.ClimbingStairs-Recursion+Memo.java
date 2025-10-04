class Solution {
    int climbStairs(int n) {
        Map<Integer,Integer> memo = new HashMap<>();
        return helper(0,n,memo);
    }

    public int helper(int s, int n, Map<Integer,Integer> memo){
        if(s > n)
            return 0;

        if(s==n) .  // Yess, we do have a condition when start==n
            return 1; // ******** Why do we return 1? It represents the No of ways to go from s to n, we atleast found 1 way

        if(memo.containsKey(s))
            return memo.get(s);    

        int val = helper(s+1,n,memo) + helper(s+2,n,memo);
        memo.put(s,val);

        return memo.get(s);

    }

}

// We start from 1 and go to n=3
// we cannot decompose problem from n=3 to n-1 and n-2, it gets too confusing