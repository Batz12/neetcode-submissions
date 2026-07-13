class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = 1;

        for(int r = m - 1; r >= 0; r--) {
            for(int c = n - 1; c >= 0; c--) {
                if(r == m - 1 && c == n - 1) {
                    continue;
                }

                int down = (r + 1 < m)? dp[r + 1][c] : 0;
                int right = (c + 1 < n)? dp[r][c + 1] : 0;

                dp[r][c] = down + right;

            }
        }

        return dp[0][0];
    }
}
