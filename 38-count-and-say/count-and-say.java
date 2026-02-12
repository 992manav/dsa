class Solution {

    String fun(StringBuilder s, int n) {

        if (n == 0) {
            return s.toString();
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;
        int i;

        for (i = 1; i < s.length(); i++) {

            if (s.charAt(i) != s.charAt(i - 1)) {
                sb.append(count);
                sb.append(s.charAt(i - 1)); 
                count = 1;
            } else {
                count++;
            }
        }

        sb.append(count);
        sb.append(s.charAt(i - 1));

        return fun(sb, n - 1);
    }

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        return fun(sb, n - 1);
    }
}
