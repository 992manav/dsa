import java.util.HashMap;
import java.util.Map;

class Solution {

    int calc(Map<Character, Integer> map) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int value : map.values()) {
            if (value < min) min = value;
            if (value > max) max = value;
        }

        return max - min;
    }

    public int beautySum(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>(); // Reinitialize for each i

            for (int j = i; j < s.length(); j++) {
                char k = s.charAt(j);
                map.put(k, map.getOrDefault(k, 0) + 1);

                if (map.size() > 1) { // Only calculate beauty if there's variation
                    int ans = calc(map);
                    sum += ans;
                }
            }
        }

        return sum;
    }
}
