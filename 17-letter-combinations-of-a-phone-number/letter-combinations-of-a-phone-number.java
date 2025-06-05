import java.util.*;

class Solution {

    List<String> final_list = new ArrayList<>();

    String[][] keypad = {
        {"a", "b", "c"},      // 2
        {"d", "e", "f"},      // 3
        {"g", "h", "i"},      // 4
        {"j", "k", "l"},      // 5
        {"m", "n", "o"},      // 6
        {"p", "q", "r", "s"}, // 7
        {"t", "u", "v"},      // 8
        {"w", "x", "y", "z"}  // 9
    };

    void fun(StringBuilder s, String num, int index) {
        if (index == num.length()) {
            final_list.add(s.toString());
            return;
        }

        int digit = num.charAt(index) - '0';
        for (int i = 0; i < keypad[digit - 2].length; i++) {
            s.append(keypad[digit - 2][i]);
            fun(s, num, index + 1);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public List<String> letterCombinations(String num) {
        if (num == null || num.length() == 0) return final_list;

        StringBuilder sb = new StringBuilder();
        fun(sb, num, 0);
        return final_list;
    }
}
