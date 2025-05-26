class Solution {
    public boolean rotateString(String s, String t) {

        if (s.length() != t.length()) return false;

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (sb.charAt(i) == t.charAt(0)) {
                if (sb.toString().contains(t)) {
                    return true;
                } else {
                     sb.append(sb.charAt(i));
                }
            }else{
                sb.append(sb.charAt(i));
            }
        }

        if (sb.toString().equals(t)) {
            return true;
        } else {
            return false;
        }
    }
}
