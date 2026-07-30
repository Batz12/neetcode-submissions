class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        int res = 0;
        
        for(int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;

            int sum = bitA ^ bitB ^ carry;

            carry = (bitA & bitB) | (bitA & carry) | (bitB & carry);

            res |= (sum << i);
        }
        
       
        return res;
    }
}
