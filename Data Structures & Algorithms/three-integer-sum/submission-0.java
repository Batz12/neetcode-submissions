class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            // We must also check if first Num is duplicate
            if((i > 0) && nums[i] == nums[i - 1]) {
                continue;
            }


            int first = nums[i];

            int secondNumIndex = i + 1;
            int thirdNumIndex = nums.length - 1;

            if(first > 0) {
                break; // if 1st number is only +ve, the numbers to the right will be +ve and will not add up to (-1 * firstNum)
            }

            int target = (-1 * first);

            while(secondNumIndex < thirdNumIndex) {
                int sum = nums[secondNumIndex] + nums[thirdNumIndex];
                if(sum == target) {
                    result.add(List.of(first, nums[secondNumIndex], nums[thirdNumIndex]));
                    
                    // After sorting, duplicate values will cluster together and hence must be skipped.
                    while((secondNumIndex < thirdNumIndex) && nums[secondNumIndex] == nums[secondNumIndex + 1]) {
                        secondNumIndex++;
                    }

                    while((secondNumIndex < thirdNumIndex) && nums[thirdNumIndex] == nums[thirdNumIndex - 1]) {
                        thirdNumIndex--;
                    }

                    secondNumIndex++;
                    thirdNumIndex--;
                } else if(sum > target) {
                    thirdNumIndex--;
                } else {
                    secondNumIndex++;
                }
            }
        }

        return result;
    }
}
