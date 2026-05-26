class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> charFrequency = new HashMap<Character, Integer>();

        int start = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        for(int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);

            charFrequency.putIfAbsent(ch, 0);
            charFrequency.put(ch, charFrequency.get(ch) + 1);

            maxFrequency = Math.max(maxFrequency, charFrequency.get(ch));

            int lengthOfSubstring = (end - start) + 1;

            while((lengthOfSubstring - maxFrequency) > k) {
                char startCh = s.charAt(start);
                charFrequency.put(startCh, charFrequency.get(startCh) - 1);
                start++;
                lengthOfSubstring = (end - start) + 1;
            }

            maxLength = Math.max(maxLength, lengthOfSubstring);
        }


        return maxLength;
    }
}
