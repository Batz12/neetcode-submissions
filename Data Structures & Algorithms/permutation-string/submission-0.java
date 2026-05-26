class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1CharFrequency = new int[26];
        int[] s2CharFrequency = new int[26];

        int start = 0;

        if(s1.length() > s2.length()) {
            return false;
        }

        for(int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            s1CharFrequency[ch - 'a']++;
        }

        int windowSize = s1.length();

        for (int end = 0; end < s2.length(); end++) {
            char s2Char = s2.charAt(end);
            s2CharFrequency[s2Char - 'a']++;

            if(end >= windowSize) {
                char startChar = s2.charAt(start);
                s2CharFrequency[startChar - 'a']--;
                start++;
            }

            if(Arrays.equals(s1CharFrequency, s2CharFrequency)) {
                return true;
            }
        }

        return false;
    }
}
