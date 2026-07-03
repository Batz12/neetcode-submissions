class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int prev2 = 0;
        int prev1 = 0;

        for(int i = 0; i < nums.length; i++) {
            int current = Math.max(prev1, prev2 + nums[i]); // max(dp[i - 1], dp[i - 2] + nums[i])
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
