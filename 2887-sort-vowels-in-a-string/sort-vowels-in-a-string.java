import java.util.*;

class Solution {
    public String sortVowels(String s) {
        List<Integer> lst = new ArrayList<>();
        List<Character> vowels = new ArrayList<>();

        char[] res = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (check(c)) {
                lst.add(i);
                vowels.add(c);
            }
            res[i] = s.charAt(i);
        }

        char[] arr = new char[vowels.size()];
        for (int i = 0; i < vowels.size(); i++) {
            arr[i] = vowels.get(i);
        }

        Arrays.sort(arr);
        int k = 0;
        for (int i = 0; i < lst.size(); i++) {
            int index = lst.get(i);
            res[index] = arr[k];
            k++;
        }

        return new String(res);
    }

    private boolean check(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
