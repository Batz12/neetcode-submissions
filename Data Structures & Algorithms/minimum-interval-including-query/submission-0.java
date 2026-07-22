class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] sortedQueries = new int[queries.length][2];

        for(int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[queries.length];

        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;

        for(int[] queryEntry : sortedQueries) {
            int query = queryEntry[0];

            while(i < intervals.length && intervals[i][0] <= query) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                minHeap.add(new int[]{end - start + 1, end});
                i++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            if(!minHeap.isEmpty()) {
                result[queryEntry[1]] = minHeap.peek()[0];
            } else {
                result[queryEntry[1]] = -1;
            }
        }


        return result;
    }
}
