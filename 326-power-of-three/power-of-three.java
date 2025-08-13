class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;

        double p = Math.log(n) / Math.log(3);
        int pInt = (int) Math.round(p);

        return Math.pow(3, pInt) == n;
    }
}
