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