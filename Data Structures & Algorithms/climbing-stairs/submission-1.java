class Solution {
    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }

        int prevTwoSteps = 1;
        int prevOneStep = 2;

        for(int i = 3; i <= n; i++) {
            int current = prevTwoSteps + prevOneStep;
            prevTwoSteps = prevOneStep;
            prevOneStep = current;
        }

        return prevOneStep;
    }
}
