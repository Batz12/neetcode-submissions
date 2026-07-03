class Solution {
    private int robRange(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for(int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int range1 = robRange(nums, 0, nums.length - 2);
        int range2 = robRange(nums, 1, nums.length - 1);

        return Math.max(range1, range2);
    }
}
