class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<int[]>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                
            }
        }

        int time = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for(int i = 0; i < size; i++) {
                int[] cell = queue.poll();

                for(int[] dir : directions) {
                    int newRow = cell[0] + dir[0];
                    int newCol = cell[1] + dir[1];

                    if(newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] != 1) {
                        continue;
                    }

                    
                    queue.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 2;
                    rotted = true;
                }
            }

            if(rotted) { // Only incrementing if rotting has occurred (at final step, no rotting will happen but it will still come here)
                time++;
            }
        }

        // Check to see if any fresh fruit remains
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }


        return time;
    }
}
