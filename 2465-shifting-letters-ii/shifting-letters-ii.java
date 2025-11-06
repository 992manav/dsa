class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] prefix = new int[n];

        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1] + 1;
            int dir = shifts[i][2];
            if (dir == 0) dir = -1;
            prefix[start] += dir % 26;
            if (end < n) prefix[end] -= dir % 26;
        }

        for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + prefix[i];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int shift = prefix[i] % 26;
            int v = (s.charAt(i) - 'a' + shift) % 26;
            if (v < 0) v += 26;
            sb.append((char)(v + 'a'));
        }

        return sb.toString();
    }
}
