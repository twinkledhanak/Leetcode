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

// Feb 2026
// Most simplest solution
// This problem was never a sliding window or two pointer
// It falls in some prefix some category
// One of the constraints is that we do NOT buy and sell the same day

class Solution {
    public int maxProfit(int[] prices) {
        // We keep track of two things -
        // Min value of buy price - we literally compare with MAX_VALUE and keep updating minPrice
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;   // best buy so far
                // If it is the best buy, why dont we sell it then?
                // Reason: It is still the same day and we are not allowed to sell on same day
                // Also the profit would be zero since the BuyPrice = SellPrice = minPrice
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }
}