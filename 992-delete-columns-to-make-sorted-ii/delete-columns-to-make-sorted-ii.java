class Solution {

    boolean[] indexes;
    String[] strs;

    boolean check(int f_i, int s_i, int len) {

        String a = strs[f_i];
        String b = strs[s_i];
        boolean flag = false;

        for (int i = 0; i < len; i++) {
            if (!indexes[i]) {
                if (a.charAt(i) > b.charAt(i)) {
                    indexes[i] = true;
                    flag = true;
                } else if (a.charAt(i) < b.charAt(i)) {
                    break;
                }
            }
        }
        return flag;
    }

    public int minDeletionSize(String[] strs) {

        this.strs = strs;
        int len = strs[0].length();
        indexes = new boolean[len];

        while (true) {
            boolean flag = false;
            for (int i = 0; i < strs.length - 1; i++) {
                if (check(i, i + 1, len)) {
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (indexes[i]) {
                count++;
            }
        }
        return count;
    }
}
