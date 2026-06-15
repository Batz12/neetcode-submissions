class KthLargest {
    PriorityQueue<Integer> minHeap;
    int heapSize;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<Integer>();

        heapSize = k;

        for(int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);

            if(minHeap.size() > heapSize) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);

        if(minHeap.size() > heapSize) {
            minHeap.poll();
        }
        
        return minHeap.peek();
    }
}
