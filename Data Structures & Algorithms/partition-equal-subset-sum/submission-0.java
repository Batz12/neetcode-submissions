class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int target = 0;

        for(int num : nums) {
            target += num;
        }

        if(target % 2 != 0) {
            return false;
        }

        target = target / 2;

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for(int num : nums) {
            for(int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }
}
