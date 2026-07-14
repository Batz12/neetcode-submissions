class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int total = 0;

        for(int i = 0; i < n; i++) {
            total += nums[i];
        }

        if(Math.abs(target) > total) {
            return 0;
        }

        if((target + total) % 2 != 0) {
            return 0;
        }

        int subsetTarget = (target + total) / 2;

        int[] dp = new int[subsetTarget + 1];

        dp[0] = 1;

        for(int num : nums) {
            for(int sum = subsetTarget; sum >= num; sum--) {
                dp[sum] += dp[sum - num];
            }
        }

        return dp[subsetTarget];
    }
}
