class Solution {
    public int maxProfit(int[] prices) {
        int bestBuyPrice = prices[0], maxProfit = 0;
        for (int price : prices) {
            bestBuyPrice = Math.min(bestBuyPrice, price);
            maxProfit = Math.max(maxProfit, price - bestBuyPrice);
        }
        
        return maxProfit;
    }
}
