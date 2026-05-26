class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> sCharFreq = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tCharFreq = new HashMap<Character, Integer>();

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            tCharFreq.putIfAbsent(ch, 0);
            tCharFreq.put(ch, tCharFreq.get(ch) + 1);
        }

        int start = 0;
        int shortestLength = Integer.MAX_VALUE;
        String shortestSubstring = "";

        int formed = 0;
        int required = tCharFreq.size();

        for(int end = 0; end < s.length(); end++) {
            char sChar = s.charAt(end);
            sCharFreq.putIfAbsent(sChar, 0);
            sCharFreq.put(sChar, sCharFreq.get(sChar) + 1);

            if(tCharFreq.containsKey(sChar) && (sCharFreq.get(sChar).equals(tCharFreq.get(sChar)))) {
                formed++;
            }


            // Shrinking the window
            while(formed == required) {
                int length = (end - start) + 1;

                if(length < shortestLength) {
                    shortestLength = length;
                    shortestSubstring = s.substring(start, start + shortestLength);
                }

                char left = s.charAt(start);
                sCharFreq.put(left, sCharFreq.get(left) - 1);

                if(tCharFreq.containsKey(left) && (sCharFreq.get(left) < tCharFreq.get(left))) {
                    formed--;
                }

                start++;
            }
        }


        return shortestSubstring;
    }
}
