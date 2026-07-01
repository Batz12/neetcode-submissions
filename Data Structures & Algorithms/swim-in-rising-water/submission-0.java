class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);

        boolean[][] visited = new boolean[n][n];

        minHeap.add(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        while(!minHeap.isEmpty()) {
            int[] current = minHeap.poll();

            int time = current[0];
            int row = current[1];
            int col = current[2];

            if(row == n-1 && col == n-1) {
                return time;
            }

            for(int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= n || visited[newRow][newCol]) {
                    continue;
                }

                visited[newRow][newCol] = true;

                int newTime = Math.max(time, grid[newRow][newCol]);

                minHeap.add(new int[]{newTime, newRow, newCol});
            }
        }

        return -1;
    }
}
