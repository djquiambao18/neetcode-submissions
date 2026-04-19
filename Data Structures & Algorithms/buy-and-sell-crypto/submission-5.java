class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }

        int buyPtr = 0, maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            // case when buy price is bigger than stock price:
            // reset the buyPtr to current, reset maxProfit to 0
            if(prices[i] < prices[buyPtr]) {
                buyPtr = i;
            }
            maxProfit = Math.max(maxProfit, prices[i] - prices[buyPtr]);
        }
        return maxProfit;
    }
}
