class Solution {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int sold = 0;
        int cooldown = 0;

        for(int price : prices) {
            int prevHold = hold;
            int prevSold = sold;
            int prevCooldown = cooldown;

            hold = Math.max(prevHold, prevCooldown - price);

            sold = prevHold + price;

            cooldown = Math.max(prevCooldown, prevSold);
        }

        return Math.max(sold, cooldown);
    }
}
