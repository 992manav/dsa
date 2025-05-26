class Solution {
    public boolean rotateString(String s, String t) {
        if (s.length() != t.length()) return false;
        return (s + s).contains(t);
    }
}
