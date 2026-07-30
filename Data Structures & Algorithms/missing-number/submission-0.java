class Solution {
    public int missingNumber(int[] nums) {
        int expectedResult = 0;

        for(int i = 1; i <= nums.length; i++) {
            expectedResult ^= i;
        }

        int result = 0;

        for(int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return (expectedResult ^ result);
    }
}
