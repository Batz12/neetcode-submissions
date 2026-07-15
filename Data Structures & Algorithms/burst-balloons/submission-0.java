class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;

        for(int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i]; 
        }

        int[][] dp = new int[n + 2][n + 2];

        for(int len = 2; len < n + 2; len++) {
            for(int l = 0; l + len < n + 2; l++) {
                int r = l + len;

                for(int k = l + 1; k < r; k++) {
                    dp[l][r] = Math.max(dp[l][r], dp[l][k] + dp[k][r] + (balloons[l] * balloons[k] * balloons[r]));
                }

            }
        }

        return dp[0][n + 1];
    }
}
