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
        HashSet<Integer> numSet = new HashSet<Integer>();

        while(!numSet.contains(n)) {
            numSet.add(n);
            n = getSquaredSum(n);

            if(n == 1) {
                return true;
            }
        }

        return false;
    }
}
