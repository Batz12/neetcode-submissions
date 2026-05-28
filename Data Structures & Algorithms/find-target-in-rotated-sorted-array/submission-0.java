class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int pivotIndex = 0;

        while(low < high) {
            int mid = low + (high - low)/2;

            if(nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        pivotIndex = low;

        if(nums[pivotIndex] <= target && target <= nums[nums.length - 1]) {
            // Right side
            low = pivotIndex;
            high = nums.length - 1;
        } else {
            // left side
            high = pivotIndex;
            low = 0;
        }

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
