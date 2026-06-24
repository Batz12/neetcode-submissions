class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<int[]>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    queue.add(new int[]{i , j});
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                if(newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length) {
                    continue;
                }

                if(grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[newRow][newCol] = grid[r][c] + 1;
                queue.add(new int[]{newRow, newCol});
            }
            
        }
    }
}
