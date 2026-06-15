class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int stone : stones) {
            maxHeap.add(stone);
        }

        while(maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            int diff = x - y; // x will be greater than y as max is always at top of heap

            if(diff != 0) {
                maxHeap.add(diff);
            }
        }

        return (maxHeap.size() == 1)?  maxHeap.poll() : 0;
    }
}
