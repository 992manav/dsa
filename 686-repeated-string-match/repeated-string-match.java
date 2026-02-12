class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int count = 1;

        int limit = b.length() / a.length() + 2;

        while (!sb.toString().contains(b)) {
            sb.append(a);
            count++;

            if (count > limit) {
                return -1;
            }
        }

        return count;
    }
}
