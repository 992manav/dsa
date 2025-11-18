class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int count = 0;

        if (bits[n - 1] == 1) {
            return false;
        } else {
            for (int i = n - 2; i >= 0; i--) {
                if (bits[i] == 1) {
                    count++;
                } else {
                    break;
                }
            }
            if (count % 2 == 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
