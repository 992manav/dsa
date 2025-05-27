import java.util.HashMap;
import java.util.Map;

class Solution {

    int calc(Map<Character, Integer> map) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Traverse all values
        for (int value : map.values()) {
            if (value < min) min = value;
            if (value > max) max = value;
        }

        return max - min;
    }

    public int beautySum(String s) {
        int sum = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            map.clear(); // reset for each substring starting at i
            for (int j = i; j < s.length(); j++) {
                char k = s.charAt(j);
                map.put(k, map.getOrDefault(k, 0) + 1);

                int ans = calc(map);
                sum += ans;
            }
        }

        return sum;
    }
}
