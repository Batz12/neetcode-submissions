class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> numSet = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(numSet.contains(nums[i])) {
                return true;
            }

            numSet.add(nums[i]);

            if(i >= k) {
                // We remove the previous element as we move the sliding window
                numSet.remove(nums[i - k]); 

            }
        }

        return false;
    }
}