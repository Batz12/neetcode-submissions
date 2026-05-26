class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefixProducts = new int[nums.length];
        int[] suffixProducts = new int[nums.length];

        int product = 1;

        for(int i = 0; i < nums.length; i++) {
            prefixProducts[i] = product;
            product *= nums[i];
        }

        product = 1;

        for(int i = nums.length - 1; i >= 0; i--) {
            suffixProducts[i] = product;
            product *= nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            result[i] = prefixProducts[i] * suffixProducts[i];
        }

        return result;
    }
}  
