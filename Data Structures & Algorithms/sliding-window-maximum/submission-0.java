class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        
        int index = 0;

        // Here (i - k) maintains the window. The indices to the left of window will be lesser than (i - k)
        for(int i = 0; i < nums.length; i++) {
            maxHeap.add(new int[]{nums[i], i});

            while(maxHeap.peek()[1] <= (i - k)) {
                maxHeap.poll();
            }

            if(i >= k - 1) {
                result[index++] = maxHeap.peek()[0];
            }
        }

       return result;
    }
}
