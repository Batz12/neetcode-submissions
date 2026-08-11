class Solution {
    public String mergeAlternately(String word1, String word2) {
        int start1 = 0;
        int start2 = 0;

        int m = word1.length();
        int n = word2.length();

        StringBuilder result = new StringBuilder();

        while(start1 < m && start2 < n) {
            result.append(word1.charAt(start1));
            result.append(word2.charAt(start2));

            start1++;
            start2++;
        }

        if(start1 < m) {
            result.append(word1.substring(start1, m));
        }

        if(start2 < n) {
            result.append(word2.substring(start2, n));
        }

        return result.toString();
    }
}