class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Comparator<Integer> comparator = (a, b) -> {
            int dist = Integer.compare(Math.abs(x - a), Math.abs(x - b));

            if(dist != 0) {
                return dist;
            }

            return Integer.compare(a, b);
        };

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(comparator);

        for(int num : arr) {
            minHeap.add(num);
        }

        List<Integer> result = new ArrayList<Integer>();

        while(k > 0) {
            result.add(minHeap.poll());
            k--;
        }

        Collections.sort(result);

        return result;
    }
}