class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        int i = 0;
        int num = 0;
        while (i < 32) {  // limit to 32 bits to avoid infinite loop
            int bit1 = (a & 1);
            int bit2 = (b & 1);

            int bit = bit1 ^ bit2 ^ carry;

            if ((bit & 1) == 1) {
                num = num | (1 << i);

                if (bit1 == 1 && bit2 == 1 && carry == 1) {
                    carry = 1;
                } else {
                    carry = 0;
                }

            } else {

                if (bit1 == bit2 && bit1 == 1) {
                    carry = 1;
                } else if (bit1 == carry && carry == 1) {
                    carry = 1;
                } else if (bit2 == carry && carry == 1) {
                    carry = 1;
                } else {
                    carry = 0;
                }
            }
            a >>= 1;
            b >>= 1;
            i++;
        }
        return num;
    }
}
