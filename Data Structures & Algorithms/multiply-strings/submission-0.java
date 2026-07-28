class Solution {

    public String computeSum(String newResult, String total) {
        StringBuilder res = new StringBuilder();

        int i = newResult.length() - 1;
        int j = total.length() - 1;
        int carry = 0;

        while(i >= 0 || j >= 0 || carry != 0) {
            int digit1 = (i >= 0)? newResult.charAt(i) - '0' : 0;
            int digit2 = (j >= 0)? total.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;

            res.append(sum % 10);

            carry = sum / 10;

            i--;
            j--;
        }

        res.reverse();
        return res.toString();
    }

    public String getPartialProduct(String num1, int digit, int zeroes) {
        if(digit == 0) {
            return "0";
        }

        int m = num1.length();

        StringBuilder res = new StringBuilder();

        int carry = 0;

        for(int i = m - 1; i >= 0; i--) {
            int firstNumDigit = num1.charAt(i) - '0';

            int product = ((firstNumDigit * digit) + carry);

            res.append(product % 10);

            carry = product / 10;
        }

        if(carry != 0) {
            res.append(carry);
        }

        res.reverse();

        while(zeroes > 0) {
            res.append("0");
            zeroes--;
        }

        return res.toString();
    }

    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        if(num1.length() < num2.length()) {
            return multiply(num2, num1);
        }

        int n = num2.length();
        int zeroes = 0;

        String res = "0";

        for(int i = n - 1; i >= 0; i--) {
            int digit = num2.charAt(i) - '0';

            String partialProduct = getPartialProduct(num1, digit, zeroes);

            res = computeSum(partialProduct, res);

            zeroes++;
        }

        return res;
    }
}
