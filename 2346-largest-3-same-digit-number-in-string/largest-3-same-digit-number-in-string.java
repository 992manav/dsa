class Solution {
    public String largestGoodInteger(String num) {
        char ans = 0;
        for (int i = 0; i <= num.length() - 3; i++) {
            char c = num.charAt(i);
            if (c == num.charAt(i + 1) && c == num.charAt(i + 2)) {
                ans = (c > ans) ? c : ans;
            }
        }

        if (ans == 0) return "";
        return "" + ans + ans + ans;
    }
}
