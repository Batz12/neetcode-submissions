class Solution {
    public boolean dfs(int node, int parent, List<Integer>[] graph, HashSet<Integer> visited) {
        visited.add(node);

        for(int neighbor : graph[node]) {
            if(neighbor == parent) {
                // for ignoring the back edge of some nodes (beacuse we already considered the previous node)
                continue; 
            }

            if(visited.contains(neighbor)) {
                return false;
            }

            if(!dfs(neighbor, node, graph, visited)) {
                return false;
            }
        }

        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) {
            return false;
        }

        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<Integer>();

        if(!dfs(0, -1, graph, visited)) {
            return false;
        }

        return visited.size() == n;
    }
}
