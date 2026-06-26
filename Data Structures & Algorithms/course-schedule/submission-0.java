class Solution {
    public boolean dfs(int course, List<Integer>[] graph, HashSet<Integer> visited, HashSet<Integer> cycle) {
        if(cycle.contains(course)) {
            return false;
        }

        if(visited.contains(course)) {
            return true;
        }

        cycle.add(course);

        for(int prereq : graph[course]) {
            if(!dfs(prereq, graph, visited, cycle)) {
                return false;
            }
        }

        cycle.remove(course);

        // to just say for that specific course there are no further dependable prerequisites (possiblity of cycle)
        // and it can be directly be used by other courses without checking prerequisites again
        visited.add(course); 

        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Constructing adjacency list
        List<Integer>[] graph = new ArrayList[numCourses];

        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];

            graph[course].add(prerequisite);
        }

        HashSet<Integer> visited = new HashSet<Integer>();
        HashSet<Integer> cycle = new HashSet<Integer>();

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, graph, visited, cycle)) {
                return false;
            }
        }

        return true;
    }
}
