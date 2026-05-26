class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();

        for(int number : nums) {
            if(set.contains(number)) {
                return true;
            }

            set.add(number);
        }

        return false;
    }
}