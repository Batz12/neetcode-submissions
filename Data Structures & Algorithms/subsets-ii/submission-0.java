class Solution {
    public void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(current));

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // choose num
            current.add(nums[i]);
            backtrack(i + 1, nums, current, result);
            

            // dont choose num
            current.remove(current.size() - 1);
         }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        backtrack(0, nums, new ArrayList<Integer>(), result);

        return result;
    }
}
