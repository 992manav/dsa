class Solution {

    String fun(StringBuilder s, int n) {

        if (n == 0) {
            return s.toString(); 
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count++;

            if (i + 1 == s.length() || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(count);
                sb.append(s.charAt(i));
                count = 0;
            }
        }

        return fun(sb, n - 1);
    }

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        return fun(sb, n - 1);
    }
}
