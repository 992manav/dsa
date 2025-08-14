class Solution {
    public String largestGoodInteger(String num) {
        int ans = -1;
        for (int i = 0; i <= num.length() - 3; i++) {
            char c = num.charAt(i);
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (num.charAt(i + j) == c) {
                    count++;
                } else {
                    break;
                }
            }

            if (count == 3) {
                ans = Math.max(Character.getNumericValue(c), ans);
            }
        }

        if (ans == -1) return "";
        return String.valueOf(ans) + ans + ans;
    }
}
