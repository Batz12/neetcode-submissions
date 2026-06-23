class Solution {
    public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for(String word : words) {
            insert(root, word);
        }

        List<String> result = new ArrayList<String>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    public void insert(TrieNode root, String word) {
        TrieNode node = root;

        for(char c : word.toCharArray()) {
            int index = c - 'a';

            if(node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.word = word;
    }

    public void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '#' ) {
            return;
        }

        char ch = board[r][c];

        int index = ch - 'a';

        if(node.children[index] == null) {
            return;
        }

        node = node.children[index];

        if(node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, node, result);
        dfs(board, r - 1, c, node, result);
        dfs(board, r, c + 1, node, result);
        dfs(board, r, c - 1, node, result);

        board[r][c] = ch;

    }
}
