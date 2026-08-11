class Solution {
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            } else {
                return false;
            }
        }
    
        return true;
        
    }

    public boolean validPalindrome(String s) {
        if(s == null || s.isEmpty()) {
            return false;
        }

        int start = 0;
        int end = s.length() - 1;

        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
            } else {
                start++;
                end--;
            }
        }

        return true;
    }
}