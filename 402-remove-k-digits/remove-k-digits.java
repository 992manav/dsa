class Solution {
    public String removeKdigits(String num, int k) {

        int n = num.length();

        if (n == 1) {
            return k == 0 ? num : "0";
        }

        StringBuilder sb = new StringBuilder();

        while (k > 0) {
            boolean flag = false;

            for (int i = 0; i < n; i++) {
                if (k == 0) {
                    sb.append(num.substring(i));
                    break;
                }

                char current = num.charAt(i);
                char next = (i < n - 1) ? num.charAt(i + 1) : current;

                if (i < n - 1 && current > next) {
                    flag = true;
                    k--;

                    while (sb.length() > 0 && sb.charAt(sb.length() - 1) > next && k > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                        k--;
                    }
                    // Skip appending current
                } else {
                    sb.append(current);
                }
            }

            // Remove leading zeroes
            int start = 0;
            while (start < sb.length() && sb.charAt(start) == '0') {
                start++;
            }

            if (start > 0) {
                sb.delete(0, start);
            }

            if (!flag) break;

            if (k > 0) {
                num = sb.toString();
                n = num.length(); // update n after new num
                sb.setLength(0);
            }
        }

        // Final cleanup if k > 0
        while (k > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
