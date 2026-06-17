class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(minHeap.isEmpty() || num > minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }

        if(minHeap.size() > maxHeap.size() + 1) {
            int rightMedian = minHeap.poll();
            maxHeap.add(rightMedian);
        } else if(maxHeap.size() > minHeap.size() + 1) {
            int leftMedian = maxHeap.poll();
            minHeap.add(leftMedian);
        }
    }
    
    public double findMedian() {
        // In odd case, we can take from which heap is larger. If even, we take mean of both heap top elements.
        if(minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }

        if(minHeap.size() < maxHeap.size()) {
            return maxHeap.peek();
        }

        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}