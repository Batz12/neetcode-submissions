class Solution {
    public int maxProfit(int[] prices) {
        int hold = -prices[0];
        int cash = 0;

        for(int i = 1; i < prices.length; i++) {
            int prevHold = hold;

            hold = Math.max(hold, cash - prices[i]);
            cash = Math.max(cash, prevHold + prices[i]);
        }

        return cash;
    }
}