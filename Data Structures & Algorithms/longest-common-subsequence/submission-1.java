class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[] dp = new int[n + 1];

        for(int i = m - 1; i >= 0; i--) {
            int diagonal = 0;

            for(int j = n - 1; j >= 0; j--) {
                int temp = dp[j];

                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[j] = 1 + diagonal;
                } else {
                    dp[j] = Math.max(dp[j], dp[j + 1]); // skipping character from text1 or text2
                }

                diagonal = temp;
            }
        }

        return dp[0];
    }
}
