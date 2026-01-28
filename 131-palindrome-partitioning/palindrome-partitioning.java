import java.util.*;

class Solution {

    boolean check_pali(StringBuilder s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    List<List<String>> final_lst = new ArrayList<>();

    void fun(int i, String cur, String s, List<String> lst) {

        if (i == s.length()) {
            if (cur.length() == 0) {
                final_lst.add(new ArrayList<>(lst));
            }
            return;
        }

        char c = s.charAt(i);
        String str = cur + c;

        if (check_pali(new StringBuilder(str))) {
            lst.add(str);
            fun(i + 1, "", s, lst);
            lst.remove(lst.size() - 1);
        }

        fun(i + 1, str, s, lst);
    }

    public List<List<String>> partition(String s) {
        fun(0, "", s, new ArrayList<>());
        return final_lst;
    }
}
