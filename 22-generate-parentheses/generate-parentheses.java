import java.util.*;

class Solution {

    List<String> lst = new ArrayList<>();

    void fun(StringBuilder s, int l, int r, int balance) {
        if (l == 0 && r == 0) {
            lst.add(s.toString());
            return;
        }

        // Try adding '('
        if (l > 0) {
            s.append('(');
            fun(s, l - 1, r, balance - 1);
            s.deleteCharAt(s.length() - 1); // backtrack
        }

        // Try adding ')' only if it won't unbalance
        if (r > 0 && balance < 0) {
            s.append(')');
            fun(s, l, r - 1, balance + 1);
            s.deleteCharAt(s.length() - 1); // backtrack
        }
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        fun(sb, n - 1, n, -1); // initial call with one '(' used
        return lst;
    }
}
