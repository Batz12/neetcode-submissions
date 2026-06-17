class Solution {
    public void backtrack(int index, int[] nums, List<Integer> currentList, List<List<Integer>> result) {
        // base case
        if(index == nums.length) {
            result.add(new ArrayList<Integer>(currentList));
            return;
        }

        // with num[index]
        currentList.add(nums[index]);
        backtrack(index + 1, nums, currentList, result);

        // without num[index]
        currentList.remove(currentList.size() - 1);
        backtrack(index + 1, nums, currentList, result);
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        backtrack(0, nums, new ArrayList<Integer>(), result);

        return result;
    }  
}
