class Solution {
    public boolean dfs(char[][] board, String word, int index, int row, int col) {
        // found word
        if(index == word.length()) {
            return true;
        }

        // out of bounds
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }

        // character not matched
        if(board[row][col] != word.charAt(index)) {
            return false;
        }

        //valid visit
        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = 
                dfs(board, word, index + 1, row, col - 1) ||
                dfs(board, word, index + 1, row - 1, col) ||
                dfs(board, word, index + 1, row, col + 1) ||
                dfs(board, word, index + 1, row + 1, col);

        board[row][col] = temp;

        return found;
    }

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
