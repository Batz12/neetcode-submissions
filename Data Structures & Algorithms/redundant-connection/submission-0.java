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

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1 ;
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            if(!union(edge[0], edge[1])) {
                // found the cycle (redundant edge among already present components)
                return new int[]{edge[0], edge[1]};
            }
        }

        return new int[]{};
    }
}
