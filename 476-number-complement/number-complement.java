class Solution {
    public int findComplement(int n) {
        int temp = n;
        int count = 0;
        while (temp != 0) {
            temp = temp >> 1;
            count++;
        }
        int num = (1 << count) - 1;
        int x = ~0 ^ num;
        return (~n) ^ x;
    }
}
