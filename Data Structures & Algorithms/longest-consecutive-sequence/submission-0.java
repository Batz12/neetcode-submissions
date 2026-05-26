class Solution {
    public int longestConsecutive(int[] nums) {
        // We can find start of sequence by checking if num - 1 exists in the array or not. 
        // If it does not exist, then this element must be the start
        // We find the starting sequence and then update longest counter if the next elements are present in the list

        HashSet<Integer> numsSet = new HashSet<Integer>();
        int longestCnt = 0; 

        for(Integer num : nums) {
            numsSet.add(num);
        }

        for(Integer num : numsSet) {
            boolean isPrevNumInSet = numsSet.contains(num - 1);

            if(!isPrevNumInSet) {
                int longestRunningCnt = 1;
                int nextNum = num + longestRunningCnt;

                while(numsSet.contains(nextNum)) {
                    longestRunningCnt++;
                    nextNum = num + longestRunningCnt;
                }

                longestCnt = Math.max(longestCnt, longestRunningCnt);
            }
        }

        return longestCnt;
    }
}
