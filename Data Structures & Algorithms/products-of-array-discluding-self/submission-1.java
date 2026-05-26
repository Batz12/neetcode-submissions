class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int product = 1;

        // Prefix
        for(int i = 0; i < nums.length; i++) {
            result[i] = product;
            product *= nums[i];
        }

        product = 1;

        // Suffix
        for(int i = nums.length - 1; i >= 0; i--) {
            result[i] *= product;
            product *= nums[i];
        }

        return result;
    }
}  
