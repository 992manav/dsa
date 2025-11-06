class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;

        int[] prefix = new int[n];

        int start = 0;
        for (int i = 0; i < shifts.length; i++) {
            int end = i + 1;

            prefix[start] += shifts[i] % 26 ;
            if (end < n) prefix[end] -= shifts[i] % 26 ;
        }

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + prefix[i];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int shift = prefix[i] % 26;
            char c = (char) ((s.charAt(i) - 'a' + shift) % 26 + 'a');
            sb.append(c);
        }

        return sb.toString();
    }
}
