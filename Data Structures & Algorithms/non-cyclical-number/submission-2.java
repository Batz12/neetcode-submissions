class Solution {
    public int getSquaredSum(int n) {
        int sum = 0;

        while(n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }

        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getSquaredSum(n);

        while(fast != 1 && slow != fast) {
            slow = getSquaredSum(slow);
            fast = getSquaredSum(getSquaredSum(fast));
        }

        return fast == 1;
    }
}
