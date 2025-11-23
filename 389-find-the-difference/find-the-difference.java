class Solution {
    public char findTheDifference(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        int n = a.length;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                return b[i];
            }
        }

        return b[n];
    }
}
