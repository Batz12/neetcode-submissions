class Solution {
    public int characterReplacement(String s, int k) {
        int[] charFrequency = new int[26];

        int start = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        for(int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);

            charFrequency[ch - 'A']++;

            maxFrequency = Math.max(maxFrequency, charFrequency[ch - 'A']);

            int lengthOfSubstring = (end - start) + 1;

            // We will shrink the window by the same amount that it exceeded k (that's why maxFrequency is not updated)
            while((lengthOfSubstring - maxFrequency) > k) {
                char startCh = s.charAt(start);
                charFrequency[startCh - 'A']--;
                start++;
                lengthOfSubstring = (end - start) + 1;
            }

            maxLength = Math.max(maxLength, lengthOfSubstring);
        }


        return maxLength;
    }
}
