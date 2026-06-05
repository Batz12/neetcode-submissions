class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        // Cycle detection
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        // Finding intersection point
        slow = nums[0];

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
