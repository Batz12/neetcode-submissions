class WordDictionary {

    public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;

        for(char c : word.toCharArray()) {
            int index = c - 'a';

            if(node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }

    public boolean dfs(int index, TrieNode node, String word) {
        if(index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        if(c == '.') {
            for(TrieNode child : node.children) {
                if(child != null && dfs(index + 1, child, word)) {
                    return true;
                }
            }

            return false;
        } else {
            int childIndex = c - 'a';

            if(node.children[childIndex] == null) {
                return false;
            }

            return dfs(index + 1, node.children[childIndex], word);
        }

    }

    public boolean search(String word) {
        return dfs(0, root, word);
    }
}
