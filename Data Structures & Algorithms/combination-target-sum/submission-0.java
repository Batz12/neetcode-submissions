class Solution {
    public void backtrack(int index, int[] nums, int target, List<Integer> current, List<List<Integer>> result) {    
        if(target == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }

        if(index < nums.length && target > 0) {
            // choose element
            current.add(nums[index]);
            backtrack(index, nums, target - nums[index], current, result);

            // dont choose element
            current.remove(current.size() - 1);
            backtrack(index + 1, nums, target, current, result);
        }
    }


    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        backtrack(0, nums, target, new ArrayList<Integer>(), result);

        return result;
    }
}
