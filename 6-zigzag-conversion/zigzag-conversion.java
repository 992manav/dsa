class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder[] a = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            a[i] = new StringBuilder();
        }

        int index = 0;
        while (index < s.length()) {
            // vertically down
            for (int i = 0; i < numRows && index < s.length(); i++) {
                a[i].append(s.charAt(index++));
            }
            // diagonally up
            for (int i = numRows - 2; i > 0 && index < s.length(); i--) {
                a[i].append(s.charAt(index++));
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(a[i]);
        }

        return result.toString();
    }
}
