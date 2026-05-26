class Solution {
    public boolean isValidSudoku(char[][] board) {
        // We need to track the row, columns and also each square
        HashMap<Integer, HashSet<Character>> rowMap = new HashMap<Integer, HashSet<Character>>();
        HashMap<Integer, HashSet<Character>> colMap = new HashMap<Integer, HashSet<Character>>();
        HashMap<Integer, HashSet<Character>> squareMap = new HashMap<Integer, HashSet<Character>>();
    
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    continue;
                }

                rowMap.putIfAbsent(i, new HashSet<Character>());
                colMap.putIfAbsent(j, new HashSet<Character>());

                int selectedSquare = (i / 3) * 3 + (j / 3);

                squareMap.putIfAbsent(selectedSquare, new HashSet<Character>());

                boolean isDuplicateElementInRow = (rowMap.get(i).contains(board[i][j]));
                boolean isDuplicateElementInCol = (colMap.get(j).contains(board[i][j]));
                boolean isDuplicateElementInSquare = (squareMap.get(selectedSquare).contains(board[i][j]));

                if(isDuplicateElementInRow || isDuplicateElementInCol || isDuplicateElementInSquare) {
                    return false;
                }

                rowMap.get(i).add(board[i][j]);
                colMap.get(j).add(board[i][j]);
                squareMap.get(selectedSquare).add(board[i][j]);
            }
        }

        return true;
    }
}
