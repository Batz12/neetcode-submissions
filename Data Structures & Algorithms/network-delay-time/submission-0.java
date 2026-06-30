class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjacencyList = new HashMap<Integer, List<int[]>>();
        int[] dist = new int[n + 1];
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        int max = 0;

        Arrays.fill(dist, Integer.MAX_VALUE);
        minHeap.add(new int[]{k, 0});
        dist[k] = 0;

        for(int[] edgeInfo : times) {
            adjacencyList.putIfAbsent(edgeInfo[0], new ArrayList<int[]>());
            adjacencyList.get(edgeInfo[0]).add(new int[]{edgeInfo[1], edgeInfo[2]});
        }

        while(!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int time = current[1];

            if(time > dist[node]) {
                continue;
            }

            if(!adjacencyList.containsKey(node)) {
                continue;
            }

            for(int[] neighbor : adjacencyList.get(node)) {
                int next = neighbor[0];
                int weight = neighbor[1];

                int newTime = time + weight;

                if(newTime < dist[next]) {
                    dist[next] = newTime;
                    minHeap.add(new int[]{next, newTime});
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) { 
                return -1;
            }

            max = Math.max(max, dist[i]);
        }

        return max;
    }
}
