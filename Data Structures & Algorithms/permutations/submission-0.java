class Solution {
    public void backtrack(int[] nums, List<Integer> current, boolean[] visited, List<List<Integer>> result) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }

        for(int i = 0; i < visited.length; i++) {
            if(visited[i]) {
                continue;
            }
            

            current.add(nums[i]);
            visited[i] = true;
            backtrack(nums, current, visited, result);
            current.remove(current.size() - 1);
            visited[i] = false;
        }

    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        backtrack(nums, new ArrayList<Integer>(), new boolean[nums.length], result);
        return result;
    }
}
