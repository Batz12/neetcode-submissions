class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[] next = new boolean[n + 1];

        next[n] = true;

        for(int j = n - 2; j >= 0; j--) {
            if(p.charAt(j + 1) == '*') {
                next[j] = next[j + 2];
            }
        }

        for(int i = m - 1; i >= 0; i--) {
            boolean[] curr = new boolean[n + 1];


            for(int j = n - 1; j >= 0; j--) {
                boolean firstMatch = ((s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '.'));

                if((j + 1 < n) && p.charAt(j + 1) == '*') {
                    curr[j] = curr[j + 2] || (firstMatch && next[j]);
                } else {
                    curr[j] = firstMatch && next[j + 1];
                }
                
            }

            next = curr;
        }

        return next[0];
    }
}
