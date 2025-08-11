class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            if (i < n - 1 &&
                sb.length() > 0 &&
                sb.charAt(sb.length() - 1) == curr &&
                curr == s.charAt(i + 1)) {
                continue;
            }
            sb.append(curr);
        }
        return sb.toString();
    }
}
