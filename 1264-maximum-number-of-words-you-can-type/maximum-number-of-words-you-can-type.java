import java.util.*;

class Solution {
    public int canBeTypedWords(String text, String bl) {
        int count = 0;

        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                count++;
            } else {
                if (map.containsKey(c)) {
                    map.get(c).add(count); 
                } else {
                    map.put(c, new ArrayList<>(Arrays.asList(count))); // fixed syntax
                }
            }
        }

        Set<Integer> st = new HashSet<>();
        for (char c : bl.toCharArray()) {
            if (map.containsKey(c)) {
                List<Integer> lst = map.get(c);
                st.addAll(lst);
            }
        }
        return count - st.size() + 1;
    }
}
