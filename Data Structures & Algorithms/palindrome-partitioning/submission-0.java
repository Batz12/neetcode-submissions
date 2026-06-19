class Solution {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
    
    public void backtrack(int index, String s, List<String> current, List<List<String>> result) {
        if(index == s.length()) {
            result.add(new ArrayList<String>(current));
            return;
        } 

        for(int i = index; i < s.length(); i++) {

            String part = s.substring(index, i + 1);

            if(isPalindrome(part)) {
                current.add(part);

                backtrack(i + 1, s, current, result);

                current.remove(current.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();

        backtrack(0, s, new ArrayList<String>(), result);

        return result;
    }
}
