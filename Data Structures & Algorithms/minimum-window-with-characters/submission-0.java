class Solution {
    public boolean isFreqGreaterOrEqual(HashMap<Character, Integer> largerMap, HashMap<Character, Integer> smallerMap) {
        for(Character ch : smallerMap.keySet()) {
            if(!largerMap.containsKey(ch) || largerMap.get(ch) < smallerMap.get(ch)) {
                return false;
            }
        }

        return true;
    }


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

        for(int end = 0; end < s.length(); end++) {
            char sChar = s.charAt(end);
            sCharFreq.putIfAbsent(sChar, 0);
            sCharFreq.put(sChar, sCharFreq.get(sChar) + 1);

            while(isFreqGreaterOrEqual(sCharFreq, tCharFreq)) {
                int length = (end - start) + 1;
                if(length < shortestLength) {
                    shortestLength = length;
                    shortestSubstring = s.substring(start, start + shortestLength);
                }
                

                sChar = s.charAt(start);
                sCharFreq.put(sChar, sCharFreq.get(sChar) - 1);
                start++;
            }
        }


        return shortestSubstring;
    }
}
