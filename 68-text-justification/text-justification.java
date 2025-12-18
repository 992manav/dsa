import java.util.*;

class Solution {

    String makeString(List<String> lst, int cur_len, int max) {

        int gaps = max - cur_len;
        int no_of_words = lst.size();
        int bichkispace = no_of_words - 1;

        StringBuilder sb = new StringBuilder();

        if (bichkispace <= 0) {
            sb.append(lst.get(0));
            sb.append(" ".repeat(gaps));
            return sb.toString();
        }

        if (gaps % bichkispace == 0) {
            int space_count = gaps / bichkispace;
            String space = " ".repeat(space_count);

            for (int i = 0; i < lst.size(); i++) {
                sb.append(lst.get(i));
                if (i != lst.size() - 1) {
                    sb.append(space);
                }
            }

        } else {
            int space_count = gaps / bichkispace;
            int extra = gaps % bichkispace;
            String space = " ".repeat(space_count);

            for (int i = 0; i < lst.size(); i++) {
                sb.append(lst.get(i));
                if (i != lst.size() - 1) {
                    sb.append(space);
                    if (extra > 0) {
                        sb.append(" ");
                        extra--;
                    }
                }
            }
        }

        return sb.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> final_lst = new ArrayList<>();
        List<String> lst = new ArrayList<>();

        int i = 0;
        int cur_len = 0;

        while (i < words.length) {
            String s = words[i];
            int len = s.length();

            if (cur_len + len + lst.size() <= maxWidth) {
                lst.add(s);
                cur_len += len;
                i++;
            } else {
                final_lst.add(makeString(lst, cur_len, maxWidth));
                lst = new ArrayList<>();
                cur_len = 0;
            }
        }

        if (!lst.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < lst.size(); j++) {
                sb.append(lst.get(j));
                if (j != lst.size() - 1) sb.append(" ");
            }
            sb.append(" ".repeat(maxWidth - sb.length()));
            final_lst.add(sb.toString());
        }

        return final_lst;
    }
}
