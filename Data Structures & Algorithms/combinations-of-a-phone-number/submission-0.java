class Solution {
    public void backtrack(int index, String digits, HashMap<Character, List<Character>> charMap, StringBuilder current, List<String> result) {
        if(index == digits.length()) {
            result.add(current.toString());
            return;
        }

        List<Character> charList = charMap.get(digits.charAt(index));

        for(Character ch : charList) {
            current.append(ch);

            backtrack(index + 1, digits, charMap, current, result);

            current.deleteCharAt(current.length() - 1);
        }


    }


    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()) {
            return new ArrayList<String>();
        }

        List<String> combinations = new ArrayList<String>();

        HashMap<Character, List<Character>> charMap = new HashMap<Character, List<Character>>();
        charMap.put('2', List.of('a', 'b', 'c'));
        charMap.put('3', List.of('d', 'e', 'f'));
        charMap.put('4', List.of('g', 'h', 'i'));
        charMap.put('5', List.of('j', 'k', 'l'));
        charMap.put('6', List.of('m', 'n', 'o'));
        charMap.put('7', List.of('p', 'q', 'r', 's'));
        charMap.put('8', List.of('t', 'u', 'v'));
        charMap.put('9', List.of('w', 'x', 'y', 'z'));

        backtrack(0, digits, charMap, new StringBuilder(), combinations);

        return combinations;
    }
}
