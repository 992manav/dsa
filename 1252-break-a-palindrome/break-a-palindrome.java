class Solution {
    public String breakPalindrome(String pali) {
        StringBuilder sb = new StringBuilder();
        int i;
        boolean flag = false;
        for (i = 0; i < pali.length(); i++) {
            if (pali.charAt(i) == 'a') {
                sb.append('a');
            } else {
                if (i != pali.length() / 2) {
                    sb.append('a');
                    flag = true;
                    break;
                } else {
                    sb.append(pali.charAt(i));
                }
            }
        }

        i = i + 1;
        for (; i < pali.length(); i++) {
            sb.append(pali.charAt(i));
        }

        if (flag) {
            return sb.toString();
        }

        if (pali.length() == 1) {
            return "";
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append('b');
        return sb.toString();
    }
}
