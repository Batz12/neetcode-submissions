class Solution {
    int[] parent;
    int[] rank;

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) {
            return false;
        }

        if(rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }

        return true;
    }

    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<int[]>();
        int n = points.length;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                edges.add(new int[]{i, j, dist});
            }
        }

        edges.sort((a, b) -> a[2] - b[2]);

        int cost = 0;
        int edgesUsed = 0;

        for(int[] edge : edges) {
            int p1 = edge[0];
            int p2 = edge[1];
            int dist = edge[2];

            if(union(p1, p2)) {
                cost += dist;
                edgesUsed++;

                if(edgesUsed == n - 1) {
                    break;
                }
            }
        }

        return cost;
    }
}
