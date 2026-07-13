class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        dp[n - 1] = 1;

        for(int r = m - 1; r >= 0; r--) {
            for(int c = n - 2; c >= 0; c--) {
                dp[c] += dp[c + 1];
            }
        }

        return dp[0];
    }
}
