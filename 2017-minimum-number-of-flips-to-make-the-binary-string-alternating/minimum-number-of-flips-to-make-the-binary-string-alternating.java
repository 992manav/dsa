class Solution {
    public int minFlips(String s) {

        int len = s.length();

        int i = 0;
        int j = 0;

        int count = 0;
        int ans = 2 * len;

        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        int idx = 0;
        while (idx < 2 * len) {
            if (flag) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            flag = !flag;
            idx++;
        }

        String target = sb.toString();

        s = s + s;

        while (j < 2 * len) {

            if (s.charAt(j) != target.charAt(j)) {
                count++;
            }

            if (j - i + 1 > len) {
                if (s.charAt(i) != target.charAt(i)) {
                    count--;
                }
                i++;
            }

            if (j - i + 1 == len) {
                ans = Math.min(ans, count);
            }

            j++;
        }

        i = 0;
        j = 0;
        count = 0;

        sb = new StringBuilder();
        flag = true;

        idx = 0;
        while (idx < 2 * len) {
            if (flag) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            flag = !flag;
            idx++;
        }

        String target2 = sb.toString();

        while (j < 2 * len) {

            if (s.charAt(j) != target2.charAt(j)) {
                count++;
            }

            if (j - i + 1 > len) {
                if (s.charAt(i) != target2.charAt(i)) {
                    count--;
                }
                i++;
            }

            if (j - i + 1 == len) {
                ans = Math.min(ans, count);
            }

            j++;
        }

        return ans;
    }
}