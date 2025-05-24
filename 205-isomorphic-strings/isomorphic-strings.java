class Solution {
    public boolean isIsomorphic(String s, String t) {

        char[] arr = new char[256]; // use 256 to cover all ASCII characters
        char[] brr = new char[256];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // character from s
            char d = t.charAt(i); // character from t

            int idx_c = c; // char to int (ASCII)
            int idx_d = d;

            if (arr[idx_c] == 0) { // check if unassigned
                if (brr[idx_d] != 0) {
                    return false;
                }
                arr[idx_c] = d;
                brr[idx_d] = c;
            } else {
                if (arr[idx_c] != d) {
                    return false;
                }
            }
        }
        return true;
    }
}
