class Solution {
    public String lexSmallest(String s) {
        int len = s.length();
        char first = s.charAt(0);
        char lastc = s.charAt(len - 1);
        int min_index = -1;
        char min = first;
        int max = -1;
        String equal = null;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c <= first) {
                if (c < min) {
                    min_index = i;
                    min = c;
                } else if (c == min) {
                    String a = new StringBuilder(s.substring(0, min_index + 1)).reverse().append(s.substring(min_index + 1)).toString();
                    String b = new StringBuilder(s.substring(0, i + 1)).reverse().append(s.substring(i + 1)).toString();
                    if (a.compareTo(b) > 0) {
                        min_index = i;
                    }
                }
            }

            if (c > lastc && max == -1) max = i;

            if (c == lastc) {
                String last2 = new StringBuilder(s.substring(0, i)).append(new StringBuilder(s.substring(i)).reverse()).toString();

                if (max == -1) {
                    if (equal == null || last2.compareTo(equal) < 0) equal = last2;
                } else {
                    String last1 = new StringBuilder(s.substring(0, max)).append(new StringBuilder(s.substring(max)).reverse()).toString();
                    if (last1.compareTo(last2) > 0) equal = last2;
                }
            }
        }

        String str = new StringBuilder(s.substring(0, min_index + 1)).reverse().append(s.substring(min_index + 1)).toString();

        String last = null;
        if (max != -1) {
            last = new StringBuilder(s.substring(0, max)).append(new StringBuilder(s.substring(max)).reverse()).toString();
            if (equal != null && equal.compareTo(last) < 0) last = equal;
        }

        if (equal != null && (last == null || equal.compareTo(last) < 0)) last = equal;

        if (last == null || str.compareTo(last) < 0) return str;
        return last;
    }
}
