class Solution {
    public int lastRemaining(int n) {
        int diff = 1;
        boolean left = true;
        int start = 1;
        int c = n;
        while (c > 1) {
            if (left) {
                start = start + diff;
            } else {
                if (c % 2 == 1) {
                    start = start + diff;
                }
            }
            c = c / 2;
            diff = diff * 2;
            left = !left;
        }
        return start;
    }
}
