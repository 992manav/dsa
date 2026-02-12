class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int count = 1;

        while (!sb.toString().contains(b)) {
            sb.append(a);
            count++;

            if (count > (b.length() / a.length()) + 2) {
                return -1;
            }
        }

        return count;
    }
}
