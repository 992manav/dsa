class Solution {
    public int smallestNumber(int n) {
        int no_bits = (int)(Math.log(n) / Math.log(2)) + 1;
        return (1 << no_bits) - 1;
    }
}
