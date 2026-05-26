class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqTable = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> freqTable.get(n2) - freqTable.get(n1));

        for(int num : nums) {
            freqTable.putIfAbsent(num, 0);
            freqTable.put(num, freqTable.get(num) + 1);
        }

        for(int num : freqTable.keySet()) {
            heap.add(num);
        }

        int[] result = new int[k];

        for(int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }
}
