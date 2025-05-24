class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count > 0) sb.append(c);  // Append only if it's not an outer '('
                count++;
            } else {
                count--;
                if (count > 0) sb.append(c);  // Append only if it's not an outer ')'
            }
        }

        return sb.toString();
    }
}
