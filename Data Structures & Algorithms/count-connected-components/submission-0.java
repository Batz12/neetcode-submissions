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

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int numOfComponents = n;

        for(int[] edge : edges) {
            if(union(edge[0], edge[1])) {
                numOfComponents--;
            }
        }

        return numOfComponents;
    }
}
