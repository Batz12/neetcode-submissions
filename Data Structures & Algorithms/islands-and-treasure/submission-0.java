class Solution {
    public class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public boolean isCellValid(Cell cell, int[][] grid) {
        if(cell.row < 0 || cell.col < 0 || cell.row >= grid.length || cell.col >= grid[0].length) {
            return false;
        }

        return true;
    }


    public void islandsAndTreasure(int[][] grid) {
        Queue<Cell> queue = new LinkedList<Cell>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    queue.add(new Cell(i, j));
                }
            }
        }

        while(!queue.isEmpty()) {
            Cell cell = queue.poll();

            Cell top = new Cell(cell.row - 1, cell.col);
            Cell bottom = new Cell(cell.row + 1, cell.col);
            Cell left = new Cell(cell.row, cell.col - 1);
            Cell right = new Cell(cell.row, cell.col + 1);

            List<Cell> cellsToProcess = new ArrayList<Cell>(List.of(top, bottom, left, right));
            
            for(Cell neighbor : cellsToProcess) {
                if(!isCellValid(neighbor, grid)) {
                    continue;
                }

                if(grid[neighbor.row][neighbor.col] != Integer.MAX_VALUE) {
                    continue;
                }


                grid[neighbor.row][neighbor.col] = grid[cell.row][cell.col] + 1;
                queue.add(neighbor);
            }
        }
    }
}
