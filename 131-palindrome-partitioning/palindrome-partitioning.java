import java.util.*;

class Solution {

    boolean check_pali(String s) {
        int i = 0;
        int j = s.length() - 1;

        if (s.length() == 1) {
            return true;
        }

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

    void fun(String s, int index, List<String> lst) {
        if (index == s.length()) {
            final_lst.add(new ArrayList<>(lst));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (check_pali(sub)) {
                lst.add(sub);
                fun(s, i + 1, lst);
                lst.remove(lst.size() - 1); // backtrack
            }
        }
    }

    public List<List<String>> partition(String s) {
        fun(s, 0, new ArrayList<>());
        return final_lst;
    }
}
