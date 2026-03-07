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

        while (j < len) {
            char c = s.charAt(j);
            if (c != target.charAt(j)) {
                count++;
            }
            j++;
        }

        ans = Math.min(ans, count);

        s = s + s;

        while (j < s.length()) {
            char c = s.charAt(j);

            if (c != target.charAt(j)) {
                count++;
            }

            char start = s.charAt(i);
            if (start != target.charAt(i)) {
                count--;
            }

            ans = Math.min(ans, count);

            i++;
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

        while (j < len) {
            char c = s.charAt(j);

            if (c != target2.charAt(j)) {
                count++;
            }
            j++;
        }

        ans = Math.min(ans, count);

        while (j < s.length()) {
            char c = s.charAt(j);

            if (c != target2.charAt(j)) {
                count++;
            }

            char start = s.charAt(i);
            if (start != target2.charAt(i)) {
                count--;
            }

            ans = Math.min(ans, count);

            i++;
            j++;
        }

        return ans;
    }
}