class Solution {
    public boolean canPlaceQueen(int r, int c, char[][] board, int n) {
        // Row check
        for(int i = 0; i < c; i++) {
            if(board[r][i] == 'Q') {
                return false;
            }
        }

        // Upper left Diagonal check
        for(int i = r - 1, j =  c - 1; i >= 0 && j >= 0; i--,j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        // Lower left diagonal check
        for(int i = r + 1, j = c - 1; i < n &&  j >=0; i++,j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }


    public void backtrack(int c, int n, char[][] board, List<List<String>> result) {
        if(c == n) {
            List<String> current = new ArrayList<String>();

            for(int i = 0; i < n; i++) {
                current.add(new String(board[i]));
            }

            result.add(current);
            
            return;
        }

        for(int r = 0; r < n; r++) {
            if(canPlaceQueen(r, c, board, n)) {
                board[r][c] = 'Q';

                backtrack(c + 1, n, board, result);

                board[r][c] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> result = new ArrayList<List<String>>();

        backtrack(0, n, board, result);


        return result;
    }
}
