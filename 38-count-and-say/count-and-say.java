class Solution {

    String fun(StringBuilder s, StringBuilder sb, int n) {

        if (n == 0) {
            return s.toString(); 
        }

        int count = 0;
        sb.setLength(0); // Clear the StringBuilder for reuse

        for (int i = 0; i < s.length(); i++) {
            count++;

            if (i + 1 == s.length() || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(count);
                sb.append(s.charAt(i));
                count = 0;
            }
        }

        return fun(sb, new StringBuilder(), n - 1);

    }

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        return fun(sb, new StringBuilder(), n - 1);
    }
}
