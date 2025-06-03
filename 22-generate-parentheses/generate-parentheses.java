import java.util.*;

class Solution {
    
    List<String> lst = new ArrayList<>();

    void fun(StringBuilder s, String c, int l, int r, int equal) {
        s.append(c);
        if (c.equals("(")) {
            l--;
            equal--;
        } else {
            r--;
            equal++;
        }

        if (l == 0 && r == 0) {
            lst.add(s.toString());
            return; // to avoid further recursion after reaching the end
        }

        if (equal < 0) {
            if (r > 0) {
                fun(new StringBuilder(s), ")", l, r, equal);
            }
        }

        if (l > 0) {
            fun(new StringBuilder(s), "(", l, r, equal);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        StringBuilder s = new StringBuilder();
        fun(s, "(", n, n, 0);
        return lst;
    }
}
