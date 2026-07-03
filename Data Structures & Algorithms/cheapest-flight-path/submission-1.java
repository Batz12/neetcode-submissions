class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<int[]>();
        }

        for(int[] f : flights) {
            graph[f[0]].add(new int[]{f[1], f[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]); // (cost, node, stops)
        
        minHeap.add(new int[]{0, src, 0});

        int[] bestStops = new int[n];
        Arrays.fill(bestStops, Integer.MAX_VALUE);

        while(!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();

            int cost = cur[0];
            int node = cur[1];
            int stops = cur[2];

            if(node == dst) return cost;

            if(stops > k || stops >= bestStops[node]) continue;

            bestStops[node] = stops;

            for(int[] neighbor : graph[node]) {
                minHeap.add(new int[]{cost + neighbor[1], neighbor[0], stops + 1});
            }
        }

        return -1;
    }
}
