// Recursion WithOUT memoisation
// This solution gets TLE
class Solution {

    public int coinChange(int[] coins, int amount) {
        return minCoins(amount, coins);
    }

    public int minCoins(int amount, int[] coins) {
            if (amount == 0) 
        return 0;
            if (amount < 0) 
        return -1;  // Invalid case

        int minCoinsNeeded = Integer.MAX_VALUE;

        for(int i=0; i<coins.length; i++){
            // go over every choice
            int c = minCoins(amount - coins[i], coins);
            // We have a chance of returning invalid value as well, which is -1. It will get picked as minimum value
            if(c != -1)
                minCoinsNeeded = Math.min(minCoinsNeeded,c+1);
        }

        return minCoinsNeeded == Integer.MAX_VALUE? -1: minCoinsNeeded;
    }
}

// Recursion with memoisation
class Solution {

    public int coinChange(int[] coins, int amount) {
        Map<Integer,Integer> map = new HashMap<>(Map.of(0,0)); // amount, coins
        return minCoins(amount, coins, map);
    }

    public int minCoins(int amount, int[] coins, Map<Integer,Integer> map) {
            if (amount == 0) 
        return 0;
            if (amount < 0) 
        return -1;  // Invalid case

        if(map.containsKey(amount))
            return map.get(amount);

        int minCoinsNeeded = Integer.MAX_VALUE;

        for(int i=0; i<coins.length; i++){
            // go over every choice
            int c = minCoins(amount - coins[i], coins, map);
            // We have a chance of returning invalid value as well, which is -1. It will get picked as minimum value
            if(c != -1)
                minCoinsNeeded = Math.min(minCoinsNeeded,c+1);
        }

        map.put(amount, minCoinsNeeded == Integer.MAX_VALUE? -1: minCoinsNeeded);

        return map.get(amount);
    }
}

[1,2,5] => amount: 11

// Dp - Bottom UP - Iterative
class Solution{
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1]; // i = amount; dp[i] = min coins for this amount
        Arrays.fill(dp, Integer.MAX_VALUE); // we wanted to initialize everything to 0, but we also have -1 as output
        // If we have 0s then we might not get the right min value. So initialize everything to max
    
        // Base condition
        if(amount < 0)
            return -1;
        dp[0] = 0;

        // all amounts leading to coins is 1
        // but if c > amount, we will get OOM
        // Do not do this 
        // for(int c : coins)
        //     dp[c] = 1;

        // prev dp problems - we had choice - refer to one or two steps previous 
        // here we always refer to coins we have

        for(int i=1; i<=amount; i++){
            for(int c: coins){
                dp[i] = dp[i-c] // amount-c

            }
        }
        
        
    } 
}