class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> characterSet = new HashSet<Character>();
        
        int windowStart = 0;
        int windowEnd = 0;
        int longestLength = 0;

        while(windowEnd < s.length()) {
             if(!characterSet.contains(s.charAt(windowEnd))) {
                characterSet.add(s.charAt(windowEnd));

                int length = (windowEnd - windowStart) + 1;

                if(length > longestLength) {
                    longestLength = length;
                }

                windowEnd++;
            } else {
                characterSet.remove(s.charAt(windowStart));
                windowStart++;
            }

        }

        return longestLength;
    }
}
