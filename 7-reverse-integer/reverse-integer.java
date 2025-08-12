class Solution {
    public int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;  // convert to positive for reversal
        }

        // Remove trailing zeros from x (optional, can skip this)
        while (x % 10 == 0 && x != 0) {
            x = x / 10;
        }

        String s = Integer.toString(x);      // Convert to string
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();                        // Reverse the string
        s = sb.toString();

        int num;
        try {
            num = Integer.parseInt(s);       // Convert reversed string to int
        } catch (NumberFormatException e) {
            // If overflow happens
            return 0;
        }

        if (flag) {
            num = -num;                     // Restore negative sign if needed
        }

        return num;
    }
}
