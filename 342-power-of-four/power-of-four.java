class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        if ((n & (n - 1)) == 0) {
            if (((int)(Math.log(n) / Math.log(2)) & 1) == 0) {
                return true;
            }
        }
        return false;
    }
}
