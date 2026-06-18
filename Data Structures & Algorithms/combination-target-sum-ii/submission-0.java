class Solution {
    public void backtrack(int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            // skip duplicates
            if(i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if(candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);

            // move to next num
            backtrack(i + 1, candidates, target - candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(candidates);

        backtrack(0, candidates, target, new ArrayList<Integer>(), result);

        return result;
    }
}
