class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> characterMap = new HashMap<Character, Integer>();
        
        int windowStart = 0;
        int longestLength = 0;

        // If we found duplicate at some index, then we can move start of window past that point

        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char ch = s.charAt(windowEnd);

            if(characterMap.containsKey(ch) && characterMap.get(ch) >= windowStart) {
                windowStart = characterMap.get(ch) + 1;
            }

            characterMap.put(ch, windowEnd);
            int length = (windowEnd - windowStart) + 1;

            if(length > longestLength) {
                longestLength = length;
            }
        }

        return longestLength;
    }
}
