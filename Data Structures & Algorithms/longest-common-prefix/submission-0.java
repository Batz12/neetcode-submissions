class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode();

        // Build
        for(String word : strs) {
            TrieNode cur = root;

            for(char c : word.toCharArray()) {
                int index = c - 'a';

                if(cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }

                cur = cur.children[index];
            }

            cur.isWord = true;
        }

        // Traverse
        StringBuilder prefix = new StringBuilder();
        TrieNode cur = root;

        while(true) {
            int count = 0;
            int next = -1;

            for(int i = 0; i < 26; i++) {
                if(cur.children[i] != null) {
                    count++;
                    next = i;
                }
            }

            if(count != 1 || cur.isWord) {
                break;
            }

            prefix.append((char) (next + 'a'));
            cur = cur.children[next];
        }

        return prefix.toString();
    }
}