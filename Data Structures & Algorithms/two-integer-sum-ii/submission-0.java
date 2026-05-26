class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        // As array is sorted we can search until we reach a sum less than the target.
        // If sum is more than target, we decrement the right pointer; else we increment the left pointer.
        int sum = 0;

        while(start < end) {
            sum = numbers[start] + numbers[end];
            if(sum == target) {
                return new int[]{start + 1, end + 1};
            } else if(sum > target) {
                end--;
            } else {
                start++;
            }
        }

        return new int[2];
    }
}
