class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>(); // Store the num with the index
        for(int i = 0; i < nums.length; i++) {
            Integer diff = Integer.valueOf(target - nums[i]);
            
            if(memo.containsKey(diff)) {
                output[0] = memo.get(diff).intValue();
                output[1] = i;
                break;
            }

            memo.put(Integer.valueOf(nums[i]), Integer.valueOf(i));
        }
        return output;
    }
}
