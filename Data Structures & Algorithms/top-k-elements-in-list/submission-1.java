class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqTable = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> freqTable.get(n2) - freqTable.get(n1));
        HashSet<Integer> heapAddedElements = new HashSet<Integer>();

        for(int num : nums) {
            freqTable.putIfAbsent(num, 0);
            freqTable.put(num, freqTable.get(num) + 1);
        }

        for(int num : nums) {
             if(!heapAddedElements.contains(num)) {
                heap.add(num);
                heapAddedElements.add(num);
            }
        }

        int[] result = new int[k];

        for(int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }
}
