class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        int[] indegree = new int[numCourses];

        for(int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];

            graph[prereq].add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            result[index++] = current;

            for(int nextCourse : graph[current]) {
                indegree[nextCourse]--;
                if(indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        return (index == numCourses)? result : new int[0];

    }
}
