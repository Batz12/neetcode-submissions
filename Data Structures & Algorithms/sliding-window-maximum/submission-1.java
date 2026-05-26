class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<Integer>();

        int index = 0;

        // Here (i - k) maintains the window. The indices to the left of window will be lesser than (i - k)
        for(int i = 0; i < nums.length; i++) {
            while(!dq.isEmpty() && dq.peekFirst() <= (i - k)) {
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.addLast(i);

            if(i >= k - 1) {
                result[index++] = nums[dq.peekFirst()];
            }
        }

       return result;
    }
}
