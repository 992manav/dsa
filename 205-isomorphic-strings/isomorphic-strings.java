import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // character from s
            char d = t.charAt(i); // character from t

            if (!map.containsKey(c)) {
                if (map.containsValue(d)) {
                    return false;
                }
                map.put(c, d);
            } else {
                if (map.containsValue(d)) {
                    Character ch = null;
                    for (Character key : map.keySet()) {
                        if (map.get(key) == d) {
                            ch = key;
                            break;
                        }
                    }

                    if (ch == null || ch != c) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
