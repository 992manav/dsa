class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder buffer = new StringBuilder();

        int len = s.length();
        boolean flag = false;

        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                flag = true;
                buffer.append(c);
            } else if (flag) {
                buffer.reverse();         // reverse the collected word
                sb.append(buffer);        // add it to result
                sb.append(" ");           // add space
                buffer.setLength(0);      // clear buffer
                flag = false;             // reset flag
            }
        }

        if (flag) {
            buffer.reverse();
            sb.append(buffer);
        } else if (sb.length() > 0) {
            sb.setLength(sb.length() - 1); // remove last space
        }

        return sb.toString();
    }
}
