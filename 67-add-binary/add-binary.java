class Solution {
    public String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (Math.max(i, j) >= 0) {
            char c1;
            if (i < 0) {
                c1 = '0';
            } else {
                c1 = a.charAt(i);
            }

            char c2;
            if (j < 0) {
                c2 = '0';
            } else {
                c2 = b.charAt(j);
            }

            if (c1 == '0' && c2 == '0') {
                sb.append((char)(carry + '0'));
                carry = 0;
            } else if (c1 == '1' && c2 == '1') {
                sb.append((char)(carry + '0'));
                carry = 1;
            } else {
                if (carry == 1) {
                    sb.append('0');
                    carry = 1;
                } else {
                    sb.append('1');
                    carry = 0;
                }
            }

            i--;
            j--;
        }

        if (carry == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}
