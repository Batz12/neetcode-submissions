class Solution {

    public void backtrack(int n, int open, int close, String current, List<String> result) {
        if(current.length() == (2 * n)) {
            result.add(current);
            return;
        }

        // choose (
        if(open < n) {
            backtrack(n, open + 1, close, current + "(", result);
        }
        

        // choose )
        if(close < open) {
            backtrack(n, open, close + 1, current + ")", result);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();

        backtrack(n, 0, 0, "", result);
        return result;
    }
}
