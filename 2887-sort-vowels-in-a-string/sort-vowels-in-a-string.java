import java.util.*;

class Solution {
    public String sortVowels(String s) {
        List<Integer> positions = new ArrayList<>();
        List<Character> vowels = new ArrayList<>();

        char[] res = s.toCharArray();

        // collect vowels and their positions
        for (int i = 0; i < res.length; i++) {
            if (isVowel(res[i])) {
                positions.add(i);
                vowels.add(res[i]);
            }
        }

        // sort vowels
        Collections.sort(vowels);

        // put back sorted vowels
        for (int i = 0; i < positions.size(); i++) {
            res[positions.get(i)] = vowels.get(i);
        }

        return new String(res);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
