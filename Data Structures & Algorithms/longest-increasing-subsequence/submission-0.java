class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        int size = 0;

        for(int num : nums) {
            int left = 0;
            int right = size;

            while(left < right) {
                int mid = left + (right - left) / 2;

                if(dp[mid] < num) { // we are storing in dp the smallest ending values
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            dp[left] = num;

            if(left == size) {
                size++;
            }
        } 

        return size;
    }
}
