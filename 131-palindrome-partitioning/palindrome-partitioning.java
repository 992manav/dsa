import java.util.*;

class Solution {

    boolean check_pali(StringBuilder s) {
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

    void fun(StringBuilder sb, String s, int index, List<String> lst) {

        if (index == s.length()) { 
            final_lst.add(new ArrayList<>(lst)); 
            return;
        }

        for (int i = index; i < s.length(); i++) {
            StringBuilder sub = new StringBuilder(s.substring(index, i + 1));
            if (check_pali(sub)) {
                lst.add(sub.toString());
                fun(sb, s, i + 1, lst);
                lst.remove(lst.size() - 1); 
            }
        }
    }

    public List<List<String>> partition(String s) {
        fun(new StringBuilder(), s, 0, new ArrayList<>());
        return final_lst;
    }
}
