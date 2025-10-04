class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buyIndex = 0, sellIndex = 0;
        int maxVal = Integer.MIN_VALUE;

        for(sellIndex=1; sellIndex<n; sellIndex++){
            maxVal = Math.max(maxVal, prices[sellIndex]-prices[buyIndex]);
            if(prices[sellIndex] < prices[buyIndex])
                buyIndex = sellIndex;
        }

        return maxVal <= 0? 0: maxVal;

    }
}

// Another solution:
// Use loop like Dynamic sliding windoe; but it is actually just two pointers

class Solution {
    public int maxProfit(int[] prices) {
        int buy=0,sell=0;
        int maxProfit = Integer.MIN_VALUE;
        if(prices.length <= 1)
            return 0;

        for(sell=1; sell<prices.length; sell++){
            // We do not have to calculate profit for all conditions
            if(prices[sell] >= prices[buy]) // **
                maxProfit = Math.max(maxProfit, prices[sell]-prices[buy]);

            if(prices[sell] < prices[buy])
                buy=sell;
        }   

        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }
}

/*
Time complexity: O(n). Only a single pass is needed.

Space complexity: O(1). Only two variables are used.
*/