class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> characterFrequencyTable = new HashMap<Character, Integer>();

        for(Character ch : s.toCharArray()) {
            if(characterFrequencyTable.containsKey(ch)) {
                characterFrequencyTable.put(ch, characterFrequencyTable.get(ch) + 1);
            } else {
                characterFrequencyTable.put(ch, 1);
            }
        }

        for(Character ch : t.toCharArray()) {
            if(characterFrequencyTable.containsKey(ch)) { 
                characterFrequencyTable.put(ch, characterFrequencyTable.get(ch) - 1);

                if(characterFrequencyTable.get(ch) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }

        for(Integer value : characterFrequencyTable.values()) {
            if(value != 0) {
                return false;
            }
        }

        return true;
    }
}
