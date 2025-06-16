class Solution {
    public int minBitFlips(int start, int goal) {
        int XOR = start ^ goal;
        int count = 0;
        while (XOR != 0) {
            if ((XOR & 1) == 1) {
                count++;
            }
            XOR = XOR >> 1;
        }
        return count;
    }
}
