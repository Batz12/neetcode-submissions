class Solution {
    int[][] directions = {
        {1, 0},
        {-1 ,0},
        {0, 1},
        {0, -1}
    };

    public int dfs(int r, int c, int[][] dp, int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(dp[r][c] != 0) {
            return dp[r][c];
        }

        dp[r][c] = 1;

        for(int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && matrix[nr][nc] > matrix[r][c]) {
                dp[r][c] = Math.max(dp[r][c], 1 + dfs(nr, nc, dp, matrix));
            }
        }

        return dp[r][c];
    }

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        int length = 0;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
               length = Math.max(length, dfs(r, c, dp, matrix));
            }
        }

        return length;
    }
}
