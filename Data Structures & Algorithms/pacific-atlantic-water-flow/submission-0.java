class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    public void dfs(int r, int c, int[][] heights, boolean[][] visited, int prevHeight) {
        if(r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        for(int[] dir : directions) {
            dfs(r + dir[0], c + dir[1], heights, visited, heights[r][c]);
        }

    }


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int numRow = heights.length;
        int numCol = heights[0].length;

        boolean[][] pacific = new boolean[numRow][numCol];
        boolean[][] atlantic = new boolean[numRow][numCol];


        for(int i = 0; i < numRow; i++) {
            dfs(i, 0, heights, pacific, heights[i][0]);
            dfs(i, numCol - 1, heights, atlantic, heights[i][numCol - 1]);
        }


        for(int j = 0; j < numCol; j++) {
            dfs(0, j, heights, pacific, heights[0][j]);
            dfs(numRow - 1, j, heights, atlantic, heights[numRow - 1][j]);
        }

        for(int i = 0; i < numRow; i++) {
            for(int j = 0; j < numCol; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }
}
