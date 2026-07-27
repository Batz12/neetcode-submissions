class Solution {
    private double myPowValue(double x, long n) {
        if(n == 0) {
            return 1;
        }

        double half = myPowValue(x, (n / 2));
        double product = half * half;

        if(n % 2 != 0) {
            product *= x; 
        }

        return product;
    }

    public double myPow(double x, int n) {
        long N = n;

        if(N < 0) {
            x = 1 / x;
            N = -N;
        }

        return myPowValue(x, N);
    }
}
