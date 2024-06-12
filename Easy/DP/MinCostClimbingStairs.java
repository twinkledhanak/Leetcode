class Solution {
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        return dp(n,cost); // Send beyond last index as we have to cross array bounds to reach top floor
    }

    public int dp(int index,int[] cost){
        
        if(index <= 1)
            return 0; // No cost to start from either

        if(map.containsKey(index)){
            return map.get(index);
        }

// do not write this as if-else . It is a plain simple recursion call
        int result = Math.min( dp(index-2,cost)+cost[index-2], dp(index-1,cost)+cost[index-1] );
        map.put(index,result);
        
        return map.get(index);    
    }
}