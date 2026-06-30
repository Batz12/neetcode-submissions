class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> wildCards = new HashMap<String, List<String>>();
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        int cnt = 1;

        Set<String> words = new HashSet<String>(wordList);

        if(!words.contains(endWord)) {
            return 0;
        }

        // Constructing the wildcard words
        for(String word : words) {
            for(int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i+1);

                if(!wildCards.containsKey(pattern)) {
                    wildCards.put(pattern, new ArrayList<String>());
                }

                wildCards.get(pattern).add(word);
            }
        }

        // BFS
        queue.add(beginWord);
        visited.add(beginWord);

        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int j = 0; j < size; j++) {

                String word = queue.poll();

                if(word.equals(endWord)) {
                    return cnt;
                }

                for(int i = 0; i < word.length(); i++) {
                    String pattern = word.substring(0, i) + "*" + word.substring(i+1);

                    List<String> neighbors = wildCards.get(pattern);

                    if(neighbors != null) {
                        for(String possibleString : neighbors) {
                            if(!visited.contains(possibleString)) {
                                visited.add(possibleString);
                                queue.add(possibleString);
                            }
                        }

                        neighbors.clear();
                    }
                }
            }

            cnt++;
        }

        return 0;
    }
}
