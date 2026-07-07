class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        
        int dp1 = 1; // dp[i + 1]
        int dp2 = 0; // dp[i + 2]

        for(int i = n - 1; i >= 0; i--) {
            int current = 0;

            if(s.charAt(i) == '0') {
                dp2 = dp1;
                dp1 = 0;
                continue;
            }

            // Decoding 1 digit
            current = dp1;

            // Decoding 2 digits
            if(i + 1 < n) {
                int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');

                if(num >= 10 && num <= 26) {
                    current += dp2;
                }
            }

            dp2 = dp1;
            dp1 = current;
        }


        return dp1;
    }
}
