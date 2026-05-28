class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] <= nums[high]) {
                high = mid; // finding the minimum at mid or left half
            } else {
                low = mid + 1;  // finding the minimum in the other part of the array (right part)
            }
        }

        return nums[low];
    }
}
