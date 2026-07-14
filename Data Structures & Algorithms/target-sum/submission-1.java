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

        int offset = total;

        int[][] dp = new int[n + 1][2 * total + 1];

        dp[n][offset] = 1;

        for(int i = n - 1; i >= 0; i--) {
            for(int sum = -total; sum <= total; sum++) {
                int count = 0;

                if(sum + nums[i] <= total) {
                    count += dp[i + 1][sum + nums[i] + offset];
                }

                if((sum - nums[i]) >= -total) {
                    count += dp[i + 1][sum - nums[i] + offset];
                }

                dp[i][sum + offset] = count;
            }
        }


        return dp[0][target + offset];
    }
}
