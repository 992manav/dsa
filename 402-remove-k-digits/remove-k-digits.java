class Solution {
    public String removeKdigits(String num, int k) {

        if (num.length() == 1) {
            return k == 0 ? num : "0";
        }

        StringBuilder sb = new StringBuilder();

        while (k > 0) {
            boolean flag = false;

            for (int i = 0; i < num.length(); i++) {
                if (k == 0) {
                    sb.append(num.substring(i));
                    break;
                }

                if (i < num.length() - 1 && num.charAt(i) > num.charAt(i + 1)) {
                    flag = true;
                    k--;
                    // Remove previous larger digits if necessary
                    while (sb.length() > 0 && sb.charAt(sb.length() - 1) > num.charAt(i + 1) && k > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                        k--;
                    }
                    // Skip appending num.charAt(i)
                } else {
                    sb.append(num.charAt(i));
                }
            }

            // Remove leading zeroes
            while (sb.length() > 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }

            if (!flag) break;

            if (k > 0) {
                num = sb.toString();
                sb.setLength(0); // Faster than creating new object
            }
        }

        // If any k still left, remove from end
        while (k > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
