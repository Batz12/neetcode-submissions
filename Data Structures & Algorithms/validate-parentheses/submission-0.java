class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        HashMap<Character, Character> matchingBracketsMap = new HashMap<Character, Character>();
        matchingBracketsMap.put(']', '[');
        matchingBracketsMap.put('}', '{');
        matchingBracketsMap.put(')', '(');

        for(Character ch : s.toCharArray()) {
            if(matchingBracketsMap.containsKey(ch)) {
                Character openingBracket = matchingBracketsMap.get(ch);
                if(stack.isEmpty() || stack.peek() != openingBracket) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
